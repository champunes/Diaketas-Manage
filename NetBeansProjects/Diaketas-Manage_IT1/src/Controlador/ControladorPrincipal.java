/**
 ** NOMBRE CLASE: 
 **	  ControladorPrincipal.java
 **
 ** DESCRIPCION:
 **       Controlador del panel principal que deriva a distintos paneles
 **       
 **
 ** DESARROLLADO POR:
 *          Mario Orozco Borrego (MOB)
 **         José Ángel González Molina (JGM)
 **        
 **
 ** SUPERVISADO POR:
 **          
 **
 ** HISTORIA:
 ** 	000 - Mar 20, 2012 - JGM - Creacion
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


public class ControladorPrincipal implements ActionListener{
	
    /** PATRON DE DISEÑO SINGLETON */
    
    private static ControladorPrincipal instancia;


    public static ControladorPrincipal getInstance(){
        if (instancia == null)
            instancia = new ControladorPrincipal();

        return instancia;

    }

    private VentanaPrincipal vista;

    /**
     * Constructor de la clase
     */	
    private ControladorPrincipal(){

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
     
        if (sAccion.equals("accionLogin")){
            vista.mostrarVistaPrincipal();
        }
        else if(sAccion.equals("entrarAPanelBeneficiarios")){
            vista.mostrarVistaBeneficiarios();
        }
        else if(sAccion.equals("entrarAPanelBolsaTrabajo")){
            
        }
        else if (sAccion.equals("entrarAPanelSocios")){
            
        }
        else if (sAccion.equals("entrarAPanelVoluntarios")){
            vista.mostrarVistaVoluntarios();
        }
      
    }
	
}
