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
        
        
        }
    
        
        public boolean añadirFamiliar (Familiar f, String beneficiarioNIF) throws SQLException{

            DriverJDBC driver = DriverJDBC.getInstance() ;
            String sentencia, sentencia2 ;
            String fecha ;
            fecha = f.getFechaNacimiento().toString();

            sentencia = "INSERT INTO familiar (NIF,Apellidos,FechaNacimiento,Nombre,Ocupacion,Parentesco) VALUES ('"+f.getNIF()+"','"+f.getApellidos()+"','"+fecha+"','"+f.getNombre()+"','"+f.getOcupacion()+"','"+f.getParentesco()+"' )";

            boolean exito = driver.insertar(sentencia);
            
            if(exito==true){
                sentencia2 = "INSERT INTO familiarbeneficiario (BeneficiarioNIF, FamiliarNIF) VALUES ('"+beneficiarioNIF+",'"+f.getNIF()+"')";
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
           
            String consulta = "SELECT * FROM familiar f, familiarbeneficiario fb WHERE fb.beneficiarioNIF=' "+beneficiarioDNI+"' AND f.NIF=fb.FamiliarNIF";
            resultados = driver.seleccionar(consulta);

            while (resultados.next()){
                temp=new Familiar();
                temp.setNIF(resultados.getString("NIF"));
                temp.setApellidos(resultados.getString("Apellidos"));
                temp.setFechaNacimiento(resultados.getDate("FechaNacimiento"));
                temp.setNombre(resultados.getString("Nombre"));
                temp.setOcupacion(resultados.getString("Ocupacion"));
                temp.setParentesco(resultados.getString("Parentesco"));

                familiares.add(temp);

            }   

            return familiares;

        }

        
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

        public BeneficiarioJDBC getInstance(){

            if(instancia == null)
                    instancia = new BeneficiarioJDBC();
            return instancia;

        }
    
    
}
