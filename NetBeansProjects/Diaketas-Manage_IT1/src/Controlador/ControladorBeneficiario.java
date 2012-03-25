/**
 ** NOMBRE CLASE: 
 **	  ControladorBeneficiario.java
 **
 ** DESCRIPCION:
 **        Controlador del panel de beneficiarios, asímismo de algunas operaciones que ocurren dentro de su jerarquía de paneles
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


public class ControladorBeneficiario implements ActionListener{

	/** PATRON DE DISEÑO SINGLETON */
    
	private static ControladorBeneficiario instancia = null;
	
	public static ControladorBeneficiario getInstance(){
		
		if(instancia == null)
			instancia = new ControladorBeneficiario();
		return instancia;
		
	}
	
    private VentanaPrincipal vista;
	
    /**
     * Constructor de la clase
     */
    private ControladorBeneficiario(){
    
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
        
        System.out.println("ActionCommand: " + sAccion);
        
        if (sAccion.equals("buscarBeneficiario")){
            vista.mostrarVistaBuscarBeneficiario();
        }
        else if (sAccion.equals("nuevoBeneficiario")){
            vista.mostrarVistaDatosBeneficiario();
        }
        else if (sAccion.equals("navToMainFromBeneficiarios")){
            vista.mostrarVistaPrincipal();
        }
        
        /** PANEL BUSQUEDA BENEFICIARIO **/
        else if (sAccion.equals("navToMainFromBuscarBeneficiario")){
            vista.mostrarVistaPrincipal();
        }
        else if (sAccion.equals("navToBeneficiariosFromBuscarBeneficiario")){
            vista.mostrarVistaBeneficiarios();
        }
        else if (sAccion.equals("buscarBeneficiarioDNI")){
            
        }
        else if (sAccion.equals("modificarItemBusquedaBeneficiario")){
            
        }
        else if (sAccion.equals("eliminarItemBusquedaBeneficiario")){
            
        }
        
        /** PANEL DATOS BENEFICIARIO **/
        else if (sAccion.equals("navToMainFromBeneficiarioDatos")){
            vista.mostrarVistaPrincipal();
        }
        else if (sAccion.equals("navToBeneficiariosFromBeneficiarioDatos")){
            vista.mostrarVistaBeneficiarios();
        }
 
    }
	
}
