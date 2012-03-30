/**
 ** NOMBRE CLASE: 
 **	  VoluntarioJDBC.java
 **
 ** DESCRIPCION:
 **       Abstracción JDBC de Voluntario
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
 *      001 - Mar 27, 2012 - FBR - Implementación de los métodos
 *      002 - Mar 30, 2012 - AAN - Reestructuracion para la tabla persona
 *      
 **
 ** NOTAS:
 **   
 **
 */
package JDBC;

import Modelo.Voluntario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jobero
 */
public class VoluntarioJDBC {
    
    private static VoluntarioJDBC instancia;
    
    private VoluntarioJDBC(){
        
    }
    
    public static VoluntarioJDBC getInstance(){
        
        if(instancia == null)
             instancia = new VoluntarioJDBC();
        return instancia;
        
    }
    
    public boolean añadirVoluntario (Voluntario voluntario) throws SQLException{
        
        DriverJDBC driver = DriverJDBC.getInstance() ;
        Integer Cp = voluntario.getCP();
        String Cp_cadena = Cp.toString();
        Integer telefono_fijo = voluntario.getTelefonoFijo();
        String telefono_fijo_cadena = telefono_fijo.toString();
        Integer telefono_movil = voluntario.getTelefonoMovil();
        String telefono_movil_cadena = telefono_movil.toString();  
        
        String sql = "INSERT INTO voluntario (NIF,Password) VALUES ('"+voluntario.getNIF()+"','"+voluntario.getPassword()+"')";
        
        String sql2 = "INSERT INTO persona (NIF,Nombre,Apellidos,CP,TelefonoFijo,TelefonoMovil,Domicilio,Localidad,FechaNacimiento) VALUES ('"+voluntario.getNIF()+"','"+voluntario.getNombre()+"','"+voluntario.getApellidos()+"','"+Cp_cadena+"','"+telefono_fijo_cadena+"','"+telefono_movil_cadena+"','"+voluntario.getDomicilio()+"','"+voluntario.getLocalidad()+"','"+voluntario.getFechaDENacimiento().toString()+"')";
        
        boolean exito=driver.insertar(sql);
         boolean exito2=driver.insertar(sql2);
        
        return exito;
        
    }
    
    public boolean borrarVoluntario (String DNI ) throws SQLException{
        
        DriverJDBC driver = DriverJDBC.getInstance() ;
           
        String sql = "DELETE FROM voluntario WHERE NIF='"+DNI+"'";
            
        boolean exito = driver.eliminar(sql);
                     
        return exito;
    }
    
   public boolean modificarDatosVoluntario (Voluntario voluntario) throws SQLException{
            
            DriverJDBC driver = DriverJDBC.getInstance() ;
            Integer Cp = voluntario.getCP();
            String Cp_cadena = Cp.toString();
            Integer telefono_fijo = voluntario.getTelefonoFijo();
            String telefono_fijo_cadena = telefono_fijo.toString();
            Integer telefono_movil = voluntario.getTelefonoMovil();
            String telefono_movil_cadena = telefono_movil.toString();
            
            
            String sql2 = "UPDATE persona SET NIF='"+voluntario.getNIF()+"',Nombre='"+voluntario.getNombre()+"',Apellidos='"+voluntario.getApellidos()+"',FechaNacimiento='"+voluntario.getFechaDENacimiento().toString()+"',CP='"+Cp_cadena+"',TelefonoFijo='"+telefono_fijo_cadena+"',TelefonoMovil='"+telefono_movil_cadena+"',Domicilio='"+voluntario.getDomicilio()+"',Localidad='"+voluntario.getLocalidad()+"' WHERE NIF ="+voluntario.getNIF()+"'";
            
            String sql = "UPDATE voluntario SET Password='"+voluntario.getPassword()+"' WHERE NIF ="+voluntario.getNIF()+"'";
            
            boolean exito = driver.actualizar(sql);
            boolean exito2 = driver.actualizar(sql2);
            
            return exito;
        }
    
    public ArrayList<Voluntario> obtenerListadoVoluntario(String dato, String tipoDato) throws SQLException{
            
            DriverJDBC driver = DriverJDBC.getInstance() ;
           
            String sql = "SELECT * FROM voluntario WHERE "+tipoDato+"="+dato;
            String sql2 = "SELECT * FROM persona WHERE "+tipoDato+"="+dato;
            
            ResultSet resultados = driver.seleccionar(sql);
            
            ResultSet resultado2 = driver.seleccionar(sql2);
            ArrayList<Voluntario> listadoVoluntarios = new ArrayList<Voluntario>();
            Voluntario temp = null;
            
            if(resultados.next()){
                temp = new Voluntario();
                temp.setPassword(resultados.getString("Password"));
                
            }
            
            if(resultado2.next()){
                
                temp.setNIF(resultado2.getString("NIF"));
                temp.setNombre(resultado2.getString("Nombre"));
                temp.setApellidos(resultado2.getString("Apellidos"));
                temp.setFechaDENacimiento(resultado2.getDate("FechaNacimiento"));
                temp.setCP(resultado2.getInt("CP"));
                temp.setTelefonoFijo(resultado2.getInt("TelefonoFijo"));
                temp.setTelefonoMovil(resultado2.getInt("TelefonoMovil"));
                temp.setDomicilio(resultado2.getString("Domicilio"));
                temp.setLocalidad(resultado2.getString("Localidad"));
                
                listadoVoluntarios.add(temp);
            }
            return listadoVoluntarios;
        } 
    
    public Voluntario obtenerVoluntario(String DNI) throws SQLException{
        
        DriverJDBC driver = DriverJDBC.getInstance() ;
           
        String sql = "SELECT * FROM voluntario WHERE (NIF='"+DNI+"')";
        String sql2 = "SELECT * FROM persona WHERE (NIF='"+DNI+"')";
            
        ResultSet resultado = driver.seleccionar(sql);
            
        ResultSet resultado2 = driver.seleccionar(sql2);
        Voluntario voluntario = null ;
           
        if(resultado.next()){
            voluntario = new Voluntario();
            voluntario.setPassword(resultado.getString("Password"));
        }
         
        if(resultado2.next()){
            voluntario.setNIF(resultado.getString("NIF"));
            voluntario.setNombre(resultado.getString("Nombre"));
            voluntario.setApellidos(resultado.getString("Apellidos"));
            voluntario.setCP(resultado.getInt("CP"));
            voluntario.setTelefonoFijo(resultado.getInt("TelefonoFijo"));
            voluntario.setTelefonoMovil(resultado.getInt("TelefonoMovil"));
            voluntario.setDomicilio(resultado.getString("Domicilio"));
            voluntario.setLocalidad(resultado.getString("Localidad"));
            voluntario.setFechaDENacimiento(resultado.getDate("FechaNacimiento"));
        }
        return voluntario;
        
    }
    
    
}
