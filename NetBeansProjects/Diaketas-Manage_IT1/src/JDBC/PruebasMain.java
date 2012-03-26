/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import Modelo.Beneficiario;
import Modelo.Familiar;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author psylock
 */
public class PruebasMain {
    
    public static void main (String ...args){
        

        DriverJDBC driver = DriverJDBC.getInstance();
        driver.configurar("127.0.0.1", "diaketas", "", "root");
        
        if (!driver.conectar()){
            System.out.println("No se ha podido conectar a la base de datos");
            System.exit(-1);
        }
        
        BeneficiarioJDBC benf = BeneficiarioJDBC.getInstance();
        
        
        Familiar fam = new Familiar();
        fam.setApellidos("Garcia Perez");
        fam.setNombre("Antonio");
        fam.setFechaNacimiento("1990-04-3");
        
        fam.setNIF("12345678X");
        fam.setOcupacion("Estudiante");
        fam.setParentesco("Hijo");
   
       
        try {
            benf.añadirFamiliar(fam, "98765432Y");
        } catch (SQLException ex) {
           // Logger.getLogger(PruebasMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList<Familiar> familiares;
        try {
            familiares = benf.datosFamiliares("98765432Y");
            
            System.out.println(familiares);
        } catch (SQLException ex) {
            Logger.getLogger(PruebasMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
