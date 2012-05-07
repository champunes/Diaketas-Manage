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
 *			José Ángel González Molina (JGM)
 **        
 **
 ** SUPERVISADO POR:
 **          
 **
 ** HISTORIA:
 ** 	000 - Mar 22, 2012 - MOB - Creacion
 *      001 - Mar 22, 2012 - MOB - Reestructuración de la clase, ahora implementa ActionListener
 *      002 - Mar 22, 2012 - MOB - Modificación del método Overriden actionPerformed de la interfaz para que gestione las diferentes acciones de la UI
 *		003 - Mar 26, 2012 - JGM - Reestructuracion de la clase para adaptarse a la arquitectura MVC
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


public class ControladorContabilidad{

    /** PATRON DE DISEÑO SINGLETON */
    
    private static ControladorContabilidad instancia = null;

    public static ControladorContabilidad getInstance(VentanaPrincipal pvista){

            if(instancia == null)
                    instancia = new ControladorContabilidad(pvista);
            return instancia;

    }

    private VentanaPrincipal vista;
    
    /**
     * Constructor de la clase 
     */
    private ControladorContabilidad(VentanaPrincipal pvista) {
     
	/** 
     * Establece como ventana padre la pasada como parámetro
     */
		vista = pvista;
	/** 
     * Conecta el controlador con las distintas interfaces de la vista
     */	
		vista.anadirListenerBtnObtenerContabilidad(new ListenerBtnObtenerContabilidad());
		
    }
	
	/**
	 * Clase interna para manejar los eventos de btnObtenerContabilidad
	 */
	
	private class ListenerBtnObtenerContabilidad implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			String sAccion = ae.getActionCommand();
			System.out.println("Accion ejecutada: " + sAccion);
		}
		
	}
    
}
