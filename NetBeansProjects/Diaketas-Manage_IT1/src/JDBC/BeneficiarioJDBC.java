/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import Modelo.Familiar;
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
        
        instancia=null;
        
        }
    
        public boolean añadirFamiliar (Familiar f, String cadena) throws SQLException{

            DriverJDBC driver = DriverJDBC.getInstance() ;
            String sentencia ;
            String fecha ;
            fecha = f.getFechaNacimiento().toString();

            sentencia = "INSERT INTO familiar (NIF,Apellidos,FechaNacimiento,Nombre,Ocupacion,Parentesco) VALUES ('"+f.getNIF()+"','"+f.getApellidos()+"','"+fecha+"','"+f.getNombre()+"','"+f.getOcupacion()+"','"+f.getParentesco()+"' )";

            driver.insertar(sentencia);

            return true;
        }

        public ArrayList<Familiar> datosFamiliares(String NIF_familiar) throws SQLException{

            ArrayList<Familiar> familiares = new ArrayList<Familiar>();
            ResultSet rs;
            DriverJDBC driver = DriverJDBC.getInstance() ;
            Familiar f;
            //Si no introducimos parámetro alguno se devolveran todos los familiares
            if(NIF_familiar==null){
                String consulta = "SELECT * FROM familiar ";
                rs = driver.seleccionar(consulta);

                while (rs.next()){
                    f=new Familiar();
                    f.setNIF(rs.getString("NIF"));
                    f.setApellidos(rs.getString("Apellidos"));
                    f.setFechaNacimiento(rs.getDate("FechaNacimiento"));
                    f.setNombre(rs.getString("Nombre"));
                    f.setOcupacion(rs.getString("Ocupacion"));
                    f.setParentesco(rs.getString("Parentesco"));

                    familiares.add(f);

                }   
            } else{

                String consulta = "SELECT * FROM familiar where NIF = '"+NIF_familiar+"'";
                rs = driver.seleccionar(consulta);

                f=new Familiar();

                f.setNIF(rs.getString("NIF"));
                f.setApellidos(rs.getString("Apellidos"));
                f.setFechaNacimiento(rs.getDate("FechaNacimiento"));
                f.setNombre(rs.getString("Nombre"));
                f.setOcupacion(rs.getString("Ocupacion"));
                f.setParentesco(rs.getString("Parentesco"));

                familiares.add(f);

            }

            return familiares;

        }

        public boolean eliminarDatosfamiliar(String dni_familiar) throws SQLException{

            String sentencia_busqueda = "SELECT "+dni_familiar+" FROM familiar WHERE NIF='"+dni_familiar+"'";
            String sentencia_eliminacion = "DELETE FROM familiar WHERE NIF='"+dni_familiar+"'";

            DriverJDBC driver = DriverJDBC.getInstance() ;
            driver.eliminar(sentencia_busqueda, sentencia_eliminacion); 

            return true;
        }

        public BeneficiarioJDBC getInstance(){

            if(instancia == null)
                    instancia = new BeneficiarioJDBC();
            return instancia;

        }
    
    
}
