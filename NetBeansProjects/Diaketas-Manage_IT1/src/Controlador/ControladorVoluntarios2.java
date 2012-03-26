/**
 ** NOMBRE CLASE: 
 **	  ControladorVoluntarios.java
 **
 ** DESCRIPCION:
 **       Controlador del panel de voluntarios, asímismo de alguna de las operaciones ocurrida en los paneles
 *        interiores a su jerarquía de menús.
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

import Vista.VentanaPrincipal2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorVoluntarios2{

	/** PATRON DE DISEÑO SINGLETON */
	private static ControladorVoluntarios2 instancia = null;
	
	public static ControladorVoluntarios2 getInstance(VentanaPrincipal2 pvista){
		
		if(instancia == null)
			instancia = new ControladorVoluntarios2(pvista);
		return instancia;
		
	}
	
	private VentanaPrincipal2 vista;

    /**
     * Constructor de la clase
     */
    private ControladorVoluntarios2(VentanaPrincipal2 pvista){

	/** 
     * Establece como ventana padre la pasada como parámetro
     */
		vista = pvista;
	/** 
     * Conecta el controlador con las distintas interfaces de la vista
     */
		vista.anadirListenerBtAyudas(new ListenerBtAyudas());
		vista.anadirListenerBtBuscarVoluntario(new ListenerBtBuscarVoluntario());
		vista.anadirListenerBtContabilidad(new ListenerBtContabilidad());
		vista.anadirListenerBtNuevoVoluntario(new ListenerBtNuevoVoluntario());
		vista.anadirListenerBtBuscarVoluntarioDNI(new ListenerBtBuscarVoluntarioDNI());
		vista.anadirListenerBtVerVoluntarioBusqueda(new ListenerBtVerVoluntarioBusqueda());
		vista.anadirListenerBtBorrar(new ListenerBtBorrar());
		vista.anadirListenerBtGuardar(new ListenerBtGuardar());		
		vista.anadirListenerNavToVoluntariosFromContabilidad(new ListenerNavToVoluntarios());	
		vista.anadirListenerNavToVoluntariosFromAyudas(new ListenerNavToVoluntarios());
		vista.anadirListenerNavToVoluntariosFromBuscarVoluntario(new ListenerNavToVoluntarios());
		vista.anadirListenerNavToVoluntariosFromDatosVoluntario(new ListenerNavToVoluntarios());
		
    }
	
	/**
	 * Clase interna para manejar los eventos de btAyudas
	 */
	
	private class ListenerBtAyudas implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			ControladorAyuda2.getInstance(vista);
			vista.mostrarVistaAyuda();
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btBuscarVoluntario
	 */
	
	private class ListenerBtBuscarVoluntario implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			vista.mostrarVistaBuscarVoluntario();
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btContabilidad
	 */
	
	private class ListenerBtContabilidad implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			ControladorContabilidad2.getInstance(vista);
			vista.mostrarVistaContabilidad();
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btNuevoVoluntario
	 */
	
	private class ListenerBtNuevoVoluntario implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			vista.mostarVistaDatosVoluntario();
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btBuscarVoluntarioDNI
	 */
	
	private class ListenerBtBuscarVoluntarioDNI implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			String sAccion = ae.getActionCommand();
			System.out.println("Accion ejecutada: " + sAccion);
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btVerVoluntarioBusqueda
	 */
	
	private class ListenerBtVerVoluntarioBusqueda implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			String sAccion = ae.getActionCommand();
			System.out.println("Accion ejecutada: " + sAccion);
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btBorrar
	 */
	
	private class ListenerBtBorrar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			String sAccion = ae.getActionCommand();
			System.out.println("Accion ejecutada: " + sAccion);
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btGuardar
	 */
	
	private class ListenerBtGuardar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			String sAccion = ae.getActionCommand();
			System.out.println("Accion ejecutada: " + sAccion);
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de los navegadores a Voluntarios
	 */
	
	private class ListenerNavToVoluntarios implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			vista.mostrarVistaVoluntarios();
		}
		
	}
	
}
