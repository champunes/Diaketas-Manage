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
 *		003 - Mar 26, 2012 - JGM - Restructuracion de la clase para adaptarse a la arquitectura MVC
 *      
 **
 ** NOTAS:
 **   
 **
 */

package Controlador;

import Vista.VentanaPrincipal2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorPrincipal2 {
	
    /** PATRON DE DISEÑO SINGLETON */
    
    private static ControladorPrincipal2 instancia;


    public static ControladorPrincipal2 getInstance(VentanaPrincipal2 pvista){
        if (instancia == null)
            instancia = new ControladorPrincipal2(pvista);

        return instancia;

    }

    private VentanaPrincipal2 vista;

    /**
     * Constructor de la clase
     */	
    private ControladorPrincipal2(VentanaPrincipal2 pvista){

	/** 
     * Establece como ventana padre la pasada como parámetro
     */
		vista = pvista;
	/** 
     * Conecta el controlador con las distintas interfaces de la vista
     */
		vista.anadirListenerBtConectarse(new ListenerBtConectarse());
		vista.anadirListenerBtBeneficiario(new ListenerBtBeneficiario());
		vista.anadirListenerBtBolsaTrabajo(new ListenerBtBolsaTrabajo());
		vista.anadirListenerBtSocio(new ListenerBtSocio());
		vista.anadirListenerBtVoluntario(new ListenerBtVoluntario());
		vista.anadirListenerNavToMainFromBeneficiarios(new ListenerNavToMain());
		vista.anadirListenerNavToMainFromContabilidad(new ListenerNavToMain());
		vista.anadirListenerNavToMainFromVoluntarios(new ListenerNavToMain());
		vista.anadirListenerNavToMainFromAyudas(new ListenerNavToMain());
		vista.anadirListenerNavToMainFromBuscarBeneficiario(new ListenerNavToMain());
		vista.anadirListenerNavToMainFromBuscarVoluntario(new ListenerNavToMain());
		vista.anadirListenerNavToMainFromDatosVoluntario(new ListenerNavToMain());
		vista.anadirListenerNavToMainFromBeneficiarioDatos(new ListenerNavToMain());
		
    }
   
	/**
	 * Clase interna para manejar los eventos de btConectarse
	 */
	
	private class ListenerBtConectarse implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			vista.mostrarVistaPrincipal();
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btBeneficiario
	 */
	
	private class ListenerBtBeneficiario implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {			
			ControladorBeneficiario2.getInstance(vista);
			vista.mostrarVistaBeneficiarios();
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btBolsaTrabajo
	 */
	
	private class ListenerBtBolsaTrabajo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			String sAccion = ae.getActionCommand();
			System.out.println("Accion ejecutada: " + sAccion);
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btSocio
	 */
	
	private class ListenerBtSocio implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			String sAccion = ae.getActionCommand();
			System.out.println("Accion ejecutada: " + sAccion);
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btVoluntario
	 */
	
	private class ListenerBtVoluntario implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			ControladorVoluntarios2.getInstance(vista);
			vista.mostrarVistaVoluntarios();
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de los navegadores a main
	 */
	
	private class ListenerNavToMain implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			vista.mostrarVistaPrincipal();
		}
		
	}
	
}
