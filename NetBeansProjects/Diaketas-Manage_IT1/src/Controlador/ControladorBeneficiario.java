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
 *		003 - Mar 26, 2012 - JGM - Restructuración de la clase para adaptarse a la arquitectura MVC
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


public class ControladorBeneficiario implements Controlador{

	/** PATRON DE DISEÑO SINGLETON */
    
	private static ControladorBeneficiario instancia = null;
	
	public static ControladorBeneficiario getInstance(VentanaPrincipal pvista){
		
		if(instancia == null)
			instancia = new ControladorBeneficiario(pvista);
		return instancia;
		
	}
	
    private VentanaPrincipal vista;
	
    /**
     * Constructor de la clase
     */
    private ControladorBeneficiario(VentanaPrincipal pvista){
    
	/** 
     * Establece como ventana padre la pasada como parámetro
     */
		vista = pvista;
	/** 
     * Conecta el controlador con las distintas interfaces de la vista
     */	
		vista.anadirListenerBtBuscarBeneficiario(new ListenerBtBuscarBeneficiario());
		vista.anadirListenerBtNuevoBeneficiario(new ListenerBtNuevoBeneficiario());
		vista.anadirListenerBtBuscarBeneficiarioDNI(new ListenerBtBuscarBeneficiarioDNI());
		vista.anadirListenerBtVerBeneficiarioBusqueda(new ListenerBtVerBeneficiarioBusqueda());
		vista.anadirListenerNavToBeneficiariosFromBuscarBeneficiario(new ListenerNavToBeneficiarios());
		vista.anadirListenerNavToBeneficiariosFromBeneficiarioDatos(new ListenerNavToBeneficiarios());
    }

	@Override
	public boolean comprobarDatos(String[] datos) {
		//Comprobar DNI
		if(datos[2].length() < 9 || datos[2].length() > 9)
			return false;		
		return true;
	}

	@Override
	public boolean comprobarContrasena(String contrasena) {
		return true;
	}
	
	/**
	 * Clase interna para manejar los eventos de btBuscarBeneficiario
	 */
	
	private class ListenerBtBuscarBeneficiario implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			vista.mostrarVistaBuscarBeneficiario();
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btNuevoBeneficiario
	 */
	
	private class ListenerBtNuevoBeneficiario implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			vista.mostrarVistaDatosBeneficiario();
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btBuscarBeneficiarioDNI
	 */
	
	private class ListenerBtBuscarBeneficiarioDNI implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			String sAccion = ae.getActionCommand();
			System.out.println("Accion ejecutada: " + sAccion);
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btVerBeneficiarioBusqueda
	 */
	
	private class ListenerBtVerBeneficiarioBusqueda implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			String sAccion = ae.getActionCommand();
			System.out.println("Accion ejecutada: " + sAccion);
		}
		
	}
	
	
	
	/**
	 * Clase interna para manejar los eventos de los navegadores a Beneficiarios
	 */
	
	private class ListenerNavToBeneficiarios implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			vista.mostrarVistaBeneficiarios();
		}
		
	}
	
}
