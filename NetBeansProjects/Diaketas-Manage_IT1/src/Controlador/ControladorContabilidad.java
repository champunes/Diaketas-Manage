/**
 ** NOMBRE CLASE: 
 **	  ControladorAyuda.java
 **
 ** DESCRIPCION:
 **       Controlador del panel de ayudas
 **       
 **
 ** DESARROLLADO POR:
 *          Mario Orozco Borrego (MOB)
 **        
 **
 ** SUPERVISADO POR:
 **          
 **
 ** HISTORIA:
 ** 	000 - Mar 22, 2012 - MOB - Creacion
 *      001 - Mar 22, 2012 - MOB - Reestructuración de la clase, ahora implementa ActionListener
 *      002 - Mar 22, 2012 - MOB - Modificación del método Overriden actionPerformed de la interfaz para que gestione las diferentes acciones de la UI
 *      
 **
 ** NOTAS:
 **   
 **
 */

package Controlador;

import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorContabilidad implements ActionListener{

    /** PATRON DE DISEÑO SINGLETON */
    
    private static ControladorContabilidad instancia = null;

    public static ControladorContabilidad getInstance(){

            if(instancia == null)
                    instancia = new ControladorContabilidad();
            return instancia;

    }

    private VentanaPrincipal vista;
    
    /**
     * Constructor de la clase 
     */
    private ControladorContabilidad() {
       
    }
   
   /** 
    * Establece como ventana padre la pasada como parámetro
    * @param pvista ventana padre
    */
    public void setVentanaPrincipal(VentanaPrincipal pvista){
         vista = pvista;
    }
 

   /**
     * Manejador de eventos de la interfaz
     * @param ae evento
     */ 
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String sAccion = ae.getActionCommand();
        
        if (sAccion.equals("obtenerContabilidad")){
            
        }
        else if (sAccion.equals("navToMainFromContabilidad")){
            vista.mostrarVistaPrincipal();
        }
        else if (sAccion.equals("navToVoluntariosFromContabilidad")){
            vista.mostrarVistaVoluntarios();
        }
    }
    
}
