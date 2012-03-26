/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import Modelo.Ayuda;
import Modelo.TipoAyuda;
import Modelo.Voluntario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jobero
 */
public class AyudaJDBC {
    
    private AyudaJDBC instancia;
    
    private AyudaJDBC(){
        
        
    }
    
    public AyudaJDBC getInstance(){

        if(instancia == null)
             instancia = new AyudaJDBC();
        return instancia;

    }
    
    //Mirar
    public ArrayList<Ayuda> buscarAyudas(String dni, Date fechaIni, Date fechaFin , float importeIni, float importeFin, String tipoAyuda) throws SQLException{
    
        ArrayList<Ayuda> lista_ayudas = new ArrayList<Ayuda>();
        DriverJDBC driver = DriverJDBC.getInstance() ;
        
        String sentencia = "SELECT * FROM ayuda a, tipoayuda t WHERE a.VoluntarioNIF='"+dni+"' AND a.fecha>="+fechaIni+" AND a.Fecha<="+fechaFin+" AND a.Importe>="+importeIni+" AND a.Importe<="+importeFin+" AND t.OID = a.tipoAyudaOID AND t.titulo LIKE '%"+tipoAyuda+"%'";
        
        ResultSet resultado = driver.seleccionar(sentencia);
        Ayuda temp;
        while(resultado.next()){
            temp = new Ayuda();
            
            temp.setOID(resultado.getString("OID"));
            temp.setFecha(resultado.getDate("Fecha"));
            temp.setObservaciones(resultado.getString("Observaciones"));
            temp.setImporte(resultado.getFloat("Importe"));
            
            lista_ayudas.add(temp);
        }
        
        return lista_ayudas;
    }
    
    public boolean comprobarTipoAyuda(String titulo) throws SQLException{
        
        DriverJDBC driver = DriverJDBC.getInstance() ;
        
        String sentencia = "SELECT Titulo FROM tipoayuda WHERE titulo='"+titulo+"' LIMIT 1";
        
        ResultSet resultados = driver.seleccionar(sentencia);
        
        if(resultados.next())
            return true;
        else
            return false;
        
        
    }
    
    public Ayuda obtenerAyuda(TipoAyuda tipoAyuda , String beneficiarioDNI , Date fecha) throws SQLException{
        
        DriverJDBC driver = DriverJDBC.getInstance() ;
        
        Ayuda ayuda = null;
        String sql = "SELECT * FROM ayuda WHERE fecha='"+fecha+"' AND beneficiarioNIF='"+beneficiarioDNI+"' AND TipoAyudaOID='"+tipoAyuda.getOID()+"' LIMIT 1" ;
        ResultSet resultados = driver.seleccionar(sql);
        
        if(resultados.next()){
            ayuda = new Ayuda();
            ayuda.setOID(resultados.getString("OID"));
            ayuda.setFecha(resultados.getDate("Fecha"));
            ayuda.setImporte(resultados.getFloat("Importe"));
            ayuda.setObservaciones("Observaciones");
            
        }
        return ayuda;
    }
    
    public ArrayList<TipoAyuda> obtenerDatosTipoAyuda() throws SQLException{
        
        DriverJDBC driver = DriverJDBC.getInstance() ;
        ArrayList<TipoAyuda> tiposAyuda = new ArrayList<TipoAyuda>();
        
        String sql = "SELECT * FROM tipoayuda";
        ResultSet resultados = driver.seleccionar(sql);
        TipoAyuda temp;
        
        if(resultados.next()){
            temp = new TipoAyuda();
            temp.setOID(resultados.getString("OID"));
            temp.setDescripcion(resultados.getString("Descripcion"));
            temp.setTitulo(resultados.getString("Titulo"));
            if("1".equals(resultados.getString("Monetaria")))
                temp.setMonetaria(true);
            else
                temp.setMonetaria(false);
            
            tiposAyuda.add(temp);

        }
        return tiposAyuda;
    }
    
    public boolean insertarTipoAyuda(TipoAyuda t) throws SQLException{
        
        DriverJDBC driver = DriverJDBC.getInstance() ;
        int monetaria;
        if(t.isMonetaria())
            monetaria=1;
        else
            monetaria=0;
        
        String sql = "INSERT INTO tipoayuda (OID,Descripcion, Monetaria,Titulo) VALUES ('"+t.getOID()+"','"+t.getDescripcion()+"','"+monetaria+"','"+t.getTitulo()+"')";
        
        boolean exito = driver.insertar(sql);
        
        return exito;
        
    }
    
    public boolean eliminarDatosAyuda(String ayudaOID) throws SQLException{
        
        DriverJDBC driver = DriverJDBC.getInstance() ;
        
        String sql = "DELETE FROM modificacionayuda WHERE AyudaOID ='"+ayudaOID+"'";
        boolean exito = driver.eliminar(sql);
        
        if(exito){
            String sql2 = "DELETE FROM ayuda WHERE OID='"+ayudaOID+"'";
            exito= driver.eliminar(sql);
        }
            
        return exito;
    }
    
    public boolean eliminarDatosTipoAyuda(String tipoayudaOID) throws SQLException{
        
        DriverJDBC driver = DriverJDBC.getInstance() ;
        
        String sql = "DELETE FROM tipoayuda WHERE OID ='"+tipoayudaOID+"'";
        boolean exito = driver.eliminar(sql);
        
        return exito;
        
    }
    
    public boolean modificarDatosAyuda(Ayuda temp, Voluntario voluntario) throws SQLException{
        
        DriverJDBC driver = DriverJDBC.getInstance() ;
        Float importe = new Float(temp.getImporte());
        
        String sql = "UPDATE ayuda SET Importe='"+importe.toString()+"',tipoAyudaOID='"+temp.getTipo_ayuda().getOID()+"',observaciones='"+temp.getObservaciones()+"' WHERE OID='"+temp.getOID()+"'";
        
        boolean exito= driver.actualizar(sql);
        Date fecha_actual = new Date();
        
        
        if(exito){
           String sql2 = "INSERT INTO modificacionayuda (AyudaOID,voluntarioNIF,fECHA) VALUES ('"+temp.getOID()+"','"+voluntario.getNIF()+"','"+fecha_actual.toString()+"')";
           exito = driver.insertar(sql2);
        }
        else{
             System.out.println("Error al realizar el UPDATE en la base de datos");
             System.exit(1);
        }
        
        return exito;
    }
    
    public boolean modificarDatosTipoAyuda(TipoAyuda t) throws SQLException{
        
        DriverJDBC driver = DriverJDBC.getInstance() ;
        
        int monetaria;
        if(t.isMonetaria())
            monetaria=1;
        else
            monetaria=0;
        
        String sql = "UPDATE tipoayuda SET Titulo="+t.getTitulo()+",Descripcion="+t.getDescripcion()+",Monetaria="+monetaria+"WHERE OID="+t.getOID();
        
        boolean exito= driver.actualizar(sql);
        
        return exito;
    }
    
    public boolean registrarDatosAyuda (Ayuda temp,String beneficiarioDNI,String voluntarioDNI) throws SQLException{
        
        DriverJDBC driver = DriverJDBC.getInstance() ;
        String fecha = temp.getFecha().toString();
        Float importe = temp.getImporte();
        
        //Asociacion ID siempre será 1 en esta primera iteracion
        
        String sql = "INSERT INTO ayuda (OID,Fecha,Importe,Observaciones,TipoAyudaOID,AsociacionID,VoluntarioNIF,BeneficiarioNIF) VALUES ('"+temp.getOID()+"','"+fecha+"','"+importe.toString()+"','"+temp.getObservaciones()+"','"+temp.getTipo_ayuda().getOID()+"','1','"+voluntarioDNI+"','"+beneficiarioDNI+"')";
        
        boolean exito = driver.insertar(sql);
        
        return exito;
        
    }
}
