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
 ** 	000 - Mar 24, 2012 - MOB - Creacion
 *      001 - Mar 24, 2012 - MOB - Reestructuración de la clase, ahora implementa ActionListener
 *      002 - Mar 24, 2012 - MOB - Modificación del método Overriden actionPerformed de la interfaz para que gestione las diferentes acciones de la UI
 *		003 - Mar 26, 2012 - JGM - Reestructuración de la clase para que se adapte a la arquitectura MVC
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


public class ControladorAyuda{

    /** PATRON DE DISEÑO SINGLETON */
    
    private static ControladorAyuda instancia = null;

    public static ControladorAyuda getInstance(VentanaPrincipal pvista){

            if(instancia == null)
                    instancia = new ControladorAyuda(pvista);
            return instancia;

    }

    private VentanaPrincipal vista;

    /** 
     * Constructor de la clase 
     */
    private ControladorAyuda(VentanaPrincipal pvista){

	/** 
     * Establece como ventana padre la pasada como parámetro
     */
		vista = pvista;
	/** 
     * Conecta el controlador con las distintas interfaces de la vista
     */
		vista.anadirListenerBtnBuscarBeneficiario(new ListenerBtnBuscarBeneficiario());
		vista.anadirListenerBtnGuardarTipoAyuda(new ListenerBtnGuardarTipoAyuda());
		vista.anadirListenerBtnEliminarTipoAyuda(new ListenerBtnEliminarTipoAyuda());
    }
	
	/**
	 * Clase interna para manejar los eventos de btnBuscarBeneficiario
	 */
	
	private class ListenerBtnBuscarBeneficiario implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			String sAccion = ae.getActionCommand();
			System.out.println("Accion ejecutada: " + sAccion);
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btnGuardarTipoAyuda
	 */
	
	private class ListenerBtnGuardarTipoAyuda implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			String sAccion = ae.getActionCommand();
			System.out.println("Accion ejecutada: " + sAccion);
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btnEliminarTipoAyuda
	 */
	
	private class ListenerBtnEliminarTipoAyuda implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			String sAccion = ae.getActionCommand();
			System.out.println("Accion ejecutada: " + sAccion);
		}
		
	}
	
}
