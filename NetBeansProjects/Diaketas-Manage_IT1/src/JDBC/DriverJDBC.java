/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.*;

/**
 *
 * @author Jobero
 */
public class DriverJDBC {
    
    
    private Connection conex;
    private String hostBD;
    private static DriverJDBC instancia;
    private String nombreBD;
    private String password;
    private String usuarioBD;
    private Statement statement;
    private ResultSet tabla;
    
    
    
    //Falta mirar bien los close!!
    
    private DriverJDBC(){
        
        instancia = null;
        conex = null;
        tabla = null;
        statement = null;      
    }
    
    //Antes de conectar se debera haber configurado
    private boolean conectar() throws ClassNotFoundException, SQLException{
        
   
        //Siempre usaremos mysql
        Class.forName("com.mysql.jdbc.Driver");
	//conex = DriverManager.getConnection("jdbc:mysql://127.0.0.1/diaketas", usuarioBD, password);
	conex = DriverManager.getConnection("jdbc:mysql//"+hostBD+"/"+nombreBD , usuarioBD, password);	
        return true;
    }
    
    private boolean desconectar() throws SQLException{
        
        conex.close();
        
        return true;
    }
    
    public void configurar(String hostBD, String nombreBD, String password, String usuarioBD){
        
        this.hostBD=hostBD;
        this.nombreBD=nombreBD;
        this.password=password;
        this.usuarioBD=usuarioBD;
        
    }
    
    
    public boolean actualizar(String sentencia) throws SQLException{
        
        /*
        tabla = statement.executeQuery(sentencia_busqueda);
	//Para que fuera mas correcto deberíamos comprobar si rs.next devuelve algo (a lo mejor nadie se llama Juan)
	if( tabla.next() == false)
            return false;
	*/
        
	//statement.executeUpdate("UPDATE socio SET telefono='111' WHERE id="+id);
        statement.executeUpdate(sentencia);
        
        return true;
    }
    
    public boolean eliminar(String sentencia) throws SQLException{
        
        boolean exito= actualizar(sentencia);
        
        return exito;
    }
    
    public static DriverJDBC getInstance(){
        
        if(instancia == null)
		instancia = new DriverJDBC();
	return instancia;
    }
    
    public boolean insertar(String sentencia) throws SQLException{
         statement.executeUpdate(sentencia);
         
        return true;
    }
    
    public ResultSet seleccionar (String cadena) throws SQLException{
        
        return statement.executeQuery(cadena);
    }
    
    
}

