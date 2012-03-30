/**
 ** NOMBRE CLASE: 
 **	  BeneficiarioJDBC.java
 **
 ** DESCRIPCION:
 **       Abstracción JDBC de Beneficiario
 **       
 **
 ** DESARROLLADO POR:
 *        Francisco José Beltrán Rodriguez (FBR)
 *	   
 **        
 ** SUPERVISADO POR:
 **       Adolfo Arcoya Nieto (AAN)   
 **
 ** HISTORIA:
 ** 	000 - Mar 24, 2012 - FBR - Creacion
 **     001 - Mar 25, 2012 - FBR - Implementacion de los metodos
 **     002 - Mar 26, 2012 - FBR - Implementacion de los métodos 
 **     003 - Mar 26, 2012 - FBR - Corregidos errores en las sentencias de añadirFamiliar() y datosFamiliares()
 *      004 - Mar 27, 2012 - FBR - Ampliación e implementación de métodos
 *      005 - Mar 30, 2012 - AAN - Reestructuracion para usar la tabla person
 **
 ** NOTAS:
 **   
 **
 */

package JDBC;

import Modelo.Beneficiario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jobero
 */
    public class BeneficiarioJDBC {
    
        private static BeneficiarioJDBC instancia;
    
        private BeneficiarioJDBC(){
        
        
        }
    
        
       /* public boolean añadirFamiliar (Familiar f, String beneficiarioNIF) throws SQLException{

            DriverJDBC driver = DriverJDBC.getInstance() ;
            String sentencia, sentencia2 ;
            String fecha ;
            fecha = f.getFechaNacimiento();

            sentencia = "INSERT INTO Familiar (NIF,Apellidos,FechaNacimiento,Nombre,Ocupacion,Parentesco) VALUES ('"+f.getNIF()+"','"+f.getApellidos()+"','"+fecha+"','"+f.getNombre()+"','"+f.getOcupacion()+"','"+f.getParentesco()+"' )";

            boolean exito = driver.insertar(sentencia);
            
            if(exito==true){
                sentencia2 = "INSERT INTO FamiliarBeneficiario (BeneficiarioNIF, FamiliarNIF) VALUES ('"+beneficiarioNIF+"','"+f.getNIF()+"')";
                driver.insertar(sentencia2); 
            }else{
                System.out.println("Error al realizar el INSERT en la base de datos");
                System.exit(1);
            }    
            
            return true;
        }

        public ArrayList<Familiar> datosFamiliares(String beneficiarioDNI) throws SQLException{

            ArrayList<Familiar> familiares = new ArrayList<Familiar>();
            ResultSet resultados;
            DriverJDBC driver = DriverJDBC.getInstance() ;
            Familiar temp ;
            //Si no introducimos parámetro alguno se devolveran todos los familiares
           
            String consulta = "SELECT * FROM familiar f, familiarbeneficiario fb WHERE fb.beneficiarioNIF='"+beneficiarioDNI+"' AND f.NIF=fb.FamiliarNIF";
            resultados = driver.seleccionar(consulta);

            while (resultados.next()){
                temp=new Familiar();
                temp.setNIF(resultados.getString("NIF"));
                temp.setApellidos(resultados.getString("Apellidos"));
                temp.setFechaNacimiento(resultados.getDate("FechaNacimiento").toString());
                temp.setNombre(resultados.getString("Nombre"));
                temp.setOcupacion(resultados.getString("Ocupacion"));
                temp.setParentesco(resultados.getString("Parentesco"));

                familiares.add(temp);

            }   

            return familiares;

        }

        */
        public boolean eliminarDatosfamiliar(String familiar_DNI, String beneficiario_DNI) throws SQLException{

            DriverJDBC driver = DriverJDBC.getInstance() ;
           
            String sentencia = "DELETE FROM familiar_beneficiario WHERE FamiliarNIF= '"+familiar_DNI+"' AND BeneficiarioNIF = '"+beneficiario_DNI+"'";

            
            boolean exito = driver.eliminar(sentencia); 

            if(exito==false){
                System.out.println("Error al realizar el DELETE en la base de datos");
                System.exit(1);
                
            }
            else {
                String sentencia2 = "DELETE FROM familiar WHERE NIF= '"+familiar_DNI+"'";
                boolean exito2 = driver.eliminar(sentencia2);
                
            }    
            return true;
        }

        public static BeneficiarioJDBC getInstance(){

            if(instancia == null)
                    instancia = new BeneficiarioJDBC();
            return instancia;

        }
        
        
        public Beneficiario obtenerBeneficiario(String DNI) throws SQLException{
            
            DriverJDBC driver = DriverJDBC.getInstance() ;
           
            String sql = "SELECT * FROM beneficiario WHERE (NIF='"+DNI+"')";
            
            String sql2 = "SELECT * FROM persona WHERE (NIF='"+DNI+"')";
            ResultSet resultado = driver.seleccionar(sql);
            ResultSet resultado2 = driver.seleccionar(sql2);
            Beneficiario benef = null ;
            if(resultado2.next()){
                benef = new Beneficiario();
                benef.setNIF(resultado.getString("NIF"));
                benef.setNombre(resultado.getString("Nombre"));
                benef.setApellidos(resultado.getString("Apellidos"));
                benef.setFechaDENacimiento(resultado.getDate("FechaNacimiento"));
                benef.setCP(resultado.getInt("CP"));
                benef.setTelefonoFijo(resultado.getInt("TelefonoFijo"));
                benef.setTelefonoMovil(resultado.getInt("TelefonoMovil"));
                benef.setDomicilio(resultado.getString("Domicilio"));
                benef.setLocalidad(resultado.getString("Localidad"));
            }
            
            if(resultado.next()){
                benef.setEstadoCivil(resultado.getString("EstadoCivil"));
                benef.setNacionalidad(resultado.getString("Nacionalidad"));
                benef.setNivelDeEstudio(resultado.getInt("NivelDeEstudio")); //En la base de datos NivelDeEstudio debe aparecer como entero
                benef.setObservaciones(resultado.getString("Observaciones"));
                benef.setOcupacion(resultado.getString("Ocupacion"));
                benef.setProfesion(resultado.getString("Profesion"));
                benef.setSituacionEconomica(resultado.getString("SituacionEconomica"));
                benef.setVivienda(resultado.getString("Vivienda"));
                benef.setViviendaAlquiler(resultado.getFloat("ViviendaAlquiler"));
                benef.setViviendaObservaciones(resultado.getString("ViviendaObservaciones"));
            }
               
            return benef;
        }
        
        public boolean borrarBeneficiario (String DNI) throws SQLException{
            
            DriverJDBC driver = DriverJDBC.getInstance() ;
           
            String sql = "DELETE FROM Beneficiario WHERE NIF='"+DNI+"'";
            
            boolean exito = driver.eliminar(sql);
            
            if(exito){
                sql = "DELETE from familiar WHERE beneficiarioNIF='"+DNI+"'";
                exito = driver.eliminar(sql);
            }
            
            return exito;
        } 
        
        
        public ArrayList<Beneficiario> obtenerListadoBeneficiario(String dato, String tipoDato) throws SQLException{
            
            DriverJDBC driver = DriverJDBC.getInstance() ;
           
            String sql = "SELECT * FROM beneficiario WHERE "+tipoDato+"="+dato+"'";
            String sql2= "SELECT * FROM persona WHERE "+tipoDato+"="+dato+"'";
            ResultSet resultados = driver.seleccionar(sql);
            ArrayList<Beneficiario> listadoBeneficiarios = new ArrayList<Beneficiario>();
            Beneficiario temp = null;
            if(resultados.next()){
                temp = new Beneficiario();
                temp.setNIF(resultados.getString("NIF"));
                temp.setNivelDeEstudio(resultados.getInt("NivelDeEstudio")); //En la base de datos NivelDeEstudio debe aparecer como entero
                temp.setObservaciones(resultados.getString("Observaciones"));
                temp.setOcupacion(resultados.getString("Ocupacion"));
                temp.setProfesion(resultados.getString("Profesion"));
                temp.setSituacionEconomica(resultados.getString("SituacionEconomica"));
                temp.setVivienda(resultados.getString("Vivienda"));
                temp.setViviendaAlquiler(resultados.getFloat("ViviendaAlquiler"));
                temp.setViviendaObservaciones(resultados.getString("ViviendaObservaciones"));
                temp.setNacionalidad(resultados.getString("Nacionalidad"));
                listadoBeneficiarios.add(temp);
            }
            
            ResultSet resultados2 = driver.seleccionar(sql2);
            if(resultados2.next()){
                temp.setNombre(resultados.getString("Nombre"));
                temp.setApellidos(resultados.getString("Apellidos"));
                temp.setFechaDENacimiento(resultados.getDate("FechaNacimiento"));
                temp.setCP(resultados.getInt("CP"));
                temp.setTelefonoFijo(resultados.getInt("TelefonoFijo"));
                temp.setTelefonoMovil(resultados.getInt("TelefonoMovil"));
                temp.setDomicilio(resultados.getString("Domicilio"));
                temp.setLocalidad(resultados.getString("Localidad"));
                
                   
                listadoBeneficiarios.add(temp);
            }
            return listadoBeneficiarios;
        } 
        
        public boolean modificarDatosBeneficiario (Beneficiario beneficiario) throws SQLException{
            
            DriverJDBC driver = DriverJDBC.getInstance() ;
            Integer Cp = beneficiario.getCP();
            String Cp_cadena = Cp.toString();
            Integer telefono_fijo = beneficiario.getTelefonoFijo();
            String telefono_fijo_cadena = telefono_fijo.toString();
            Integer telefono_movil = beneficiario.getTelefonoMovil();
            String telefono_movil_cadena = telefono_movil.toString();
            Integer nivel_estudio = beneficiario.getNivelDeEstudio();
            String nivel_estudio_cadena = nivel_estudio.toString();
            
            String sql2 = "UPDATE persona SET NIF='"+beneficiario.getNIF()+"',Nombre='"+beneficiario.getNombre()+"',Apellidos='"+beneficiario.getApellidos()+"',FechaNacimiento='"+beneficiario.getFechaDENacimiento()+"',CP='"+Cp_cadena+"',TelefonoFijo='"+telefono_fijo_cadena+"',TelefonoMovil='"+telefono_movil_cadena+"',Domicilio='"+beneficiario.getDomicilio()+"',Localidad='"+beneficiario.getLocalidad()+"WHERE NIF ="+beneficiario.getNIF()+"'";
            
            boolean exito2 = driver.actualizar(sql2);
            
            String sql = "UPDATE beneficiario SET NIF='"+beneficiario.getNIF()+"',Nacionalidad='"+beneficiario.getNacionalidad()+"',EstadoCivil='"+beneficiario.getEstadoCivil()+"',NivelDeEstudio='"+nivel_estudio_cadena+"',Observaciones='"+beneficiario.getObservaciones()+"',Ocupacion='"+beneficiario.getOcupacion()+"',Profesion='"+beneficiario.getProfesion()+"',SituacionEconomica='"+beneficiario.getSituacionEconomica()+"',Vivienda='"+beneficiario.getVivienda()+"',ViviendaAlquiler='"+beneficiario.getViviendaAlquiler()+"',ViviendaObservaciones='"+beneficiario.getViviendaObservaciones()+"WHERE NIF ="+beneficiario.getNIF()+"'";
            
            boolean exito = driver.actualizar(sql);
            
            return exito;
        }
    
        public boolean añadirBeneficiario (Beneficiario beneficiario) throws SQLException{
        
        DriverJDBC driver = DriverJDBC.getInstance() ;
        Integer Cp = beneficiario.getCP();
        String Cp_cadena = Cp.toString();
        Integer telefono_fijo = beneficiario.getTelefonoFijo();
        String telefono_fijo_cadena = telefono_fijo.toString();
        Integer telefono_movil = beneficiario.getTelefonoMovil();
        String telefono_movil_cadena = telefono_movil.toString();  
        Integer nivel_estudio = beneficiario.getNivelDeEstudio();
        String nivel_estudio_cadena = nivel_estudio.toString();
        Float vivienda_alquiler = beneficiario.getViviendaAlquiler();
        String vivienda_alquiler_cadena = nivel_estudio.toString();
        String sql2 = "INSERT INTO persona (NIF,Nombre,Apellidos,FechaNacimiento,CP,TelefonoFijo,TelefonoMovil,Domicilio,Localidad) VALUES ('"+beneficiario.getNIF()+"','"+beneficiario.getNombre()+"','"+beneficiario.getApellidos()+"','"+beneficiario.getFechaDENacimiento()+"','"+Cp_cadena+"','"+telefono_fijo_cadena+"','"+telefono_movil_cadena+"','"+beneficiario.getDomicilio()+"','"+beneficiario.getLocalidad()+"')";
        boolean exito2 = driver.insertar(sql2);
        String sql = "INSERT INTO beneficiario (NIF,EstadoCivil,Nacionalidad,NivelDeEstudio,Observaciones,Ocupacion,Profesion,SituacionEconomica,Vivienda,ViviendaAlquiler,ViviendaObservaciones) VALUES ('"+beneficiario.getNIF()+"','"+beneficiario.getEstadoCivil()+"','"+beneficiario.getNacionalidad()+"','"+nivel_estudio_cadena+"','"+beneficiario.getObservaciones()+"','"+beneficiario.getOcupacion()+"','"+beneficiario.getProfesion()+"','"+beneficiario.getSituacionEconomica()+"','"+beneficiario.getVivienda()+"','"+vivienda_alquiler_cadena+"','"+beneficiario.getViviendaObservaciones()+"')";
        
        boolean exito=driver.insertar(sql);
        
        return exito;
        
    }
}
