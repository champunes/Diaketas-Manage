/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import Modelo.Ayuda;
import Modelo.Movimiento;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jobero
 */
public class MovimientoJDBC {
    
     private static MovimientoJDBC instancia;
    
     private MovimientoJDBC(){
        
        instancia=null;
        
     }
     
     public MovimientoJDBC getInstance(){

            if(instancia == null)
                    instancia = new MovimientoJDBC();
            return instancia;

     }
     
     public float obtenerBalance(Date fecha_inicial, Date fecha_final){
         
         float total=0;
         
         
         
         return total;
     }
     
     public ArrayList<Movimiento> obtenerDatosGastos(Date fecha_inicial, Date fecha_final){
         
         ArrayList<Movimiento> lista = new ArrayList<Movimiento>();
         
         return lista;
         
     }
     
     public ArrayList<Movimiento> obtenerDatosIngresos(Date fecha_inicial, Date fecha_final){
         
         ArrayList<Movimiento> lista = new ArrayList<Movimiento>();
         
         return lista;
         
     }
     
     public boolean registrarDatosGasto(Movimiento movimiento){
         
         
         
         return true;
     }
    
     public boolean registrarDatosGastoAyuda(Movimiento movimiento, Ayuda ayuda){
         
         
         
         return true;
     }
             
}
