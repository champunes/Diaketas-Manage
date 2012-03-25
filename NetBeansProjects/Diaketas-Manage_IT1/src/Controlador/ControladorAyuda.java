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
 *      002 - Mar 23, 2012 - MOB - Modificación del método Overriden actionPerformed de la interfaz para que gestione las diferentes acciones de la UI
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


public class ControladorAyuda implements ActionListener{

    /** PATRON DE DISEÑO SINGLETON */
    
    private static ControladorAyuda instancia = null;

    public static ControladorAyuda getInstance(){

            if(instancia == null)
                    instancia = new ControladorAyuda();
            return instancia;

    }

    private VentanaPrincipal vista;

    /** 
    * Establece como ventana padre la pasada como parámetro
    * @param pvista ventana padre
    */
    public void setVentanaPrincipal(VentanaPrincipal pvista){
        vista = pvista;
    }	

    /** 
     * Constructor de la clase 
     */
    private ControladorAyuda(){

    }

    /**
     * Manejador de eventos de la interfaz
     * @param ae evento
     */ 
    @Override
    public void actionPerformed(ActionEvent ae) {
        String sAccion = ae.getActionCommand();
        
        /** PANEL DE AYUDAS **/
        if (sAccion.equals("navToMainFromAyudas")){
            vista.mostrarVistaPrincipal();
        }
        else if (sAccion.equals("navToVoluntariosFromAyudas")){
            vista.mostrarVistaVoluntarios();
        }
        else if (sAccion.equals("buscarBeneficiario")){
             System.out.println("Accion ejecutada: " + sAccion);
        }
        else if (sAccion.equals("guardarTipoAyudas")){
             System.out.println("Accion ejecutada: " + sAccion);
        }
        else if (sAccion.equals("guardarTipoAyuda")){
             System.out.println("Accion ejecutada: " + sAccion);
        }
        else if (sAccion.equals("eliminarTipoAyuda")){
             System.out.println("Accion ejecutada: " + sAccion);
        }
      
    }
	
}
