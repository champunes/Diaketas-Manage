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
 *			José Ángel González Molina (JGM)
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

import JDBC.VoluntarioJDBC;
import Modelo.Voluntario;
import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;


public class ControladorVoluntarios implements Controlador{

	/** PATRON DE DISEÑO SINGLETON */
	private static ControladorVoluntarios instancia = null;
	private static final String baseContrasena = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static ControladorVoluntarios getInstance(VentanaPrincipal pvista){
		
		if(instancia == null)
			instancia = new ControladorVoluntarios(pvista);
		return instancia;
		
	}
	
	public static String genContrasena(){
		
		String contrasena="";
		int longitud = baseContrasena.length();
		int largoContrasena = 6;
		
		for(int i=0;i<largoContrasena;i++){
			int numero = (int)(Math.random()*(longitud));
			String caracter = baseContrasena.substring(numero,numero+1);
			contrasena = contrasena+caracter;
		}
		System.out.println(contrasena);
		return contrasena;						
		
	}
	
	private VentanaPrincipal vista;
	private VoluntarioJDBC vol;

    /**
     * Constructor de la clase
     */
    private ControladorVoluntarios(VentanaPrincipal pvista){

	/** 
     * Establece como ventana padre la pasada como parámetro
     */
		vista = pvista;
		
		vol = VoluntarioJDBC.getInstance();
		
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
	
	private boolean insertarVoluntario(String[] datos,String password){
		
		if (this.comprobarDatos(datos) == false ||this.comprobarContrasena(password) == false)
			return false;
		
		Voluntario temp = new Voluntario();
		/*El orden de los datos en el array es:
			 Nombre,Apellidos,NIF,FechaNacimiento,Nacionalidad,EstadoCivil,
			 NivelEstudios,Profesion,Domicilio,CP,Localidad,Telefono,Observaciones
			*/
		
		temp.setNombre(datos[0]);
		temp.setApellidos(datos[1]);
		temp.setNIF(datos[2]);
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		try{
		temp.setFechaDENacimiento(df.parse(datos[3]));
		}
		catch(ParseException p){
			System.err.print(p.getMessage());
		}
		//temp.setNacionalidad(datos[4]);
		//temp.setEstadoCivil(datos[5]);
		//temp.setNivelEstudios(datos[6]);
		//temp.setProfesion(datos[7]);
		temp.setDomicilio(datos[8]);
		temp.setCP(Integer.parseInt(datos[9]));
		temp.setLocalidad(datos[10]);
		temp.setTelefonoFijo(Integer.parseInt(datos[11]));
		//temp.setObservaciones();
		temp.setPassword(password);
		
		try{
		vol.añadirVoluntario(temp);
		}
		catch(SQLException se){
			System.err.print(se.getMessage());
		}
		
		return true;	
			
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
	 * Clase interna para manejar los eventos de btAyudas
	 */
	
	private class ListenerBtAyudas implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			ControladorAyuda.getInstance(vista);
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
			ControladorContabilidad.getInstance(vista);
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
			String[] datos = new String[13];
			/*El orden de los datos en el array es:
			 Nombre,Apellidos,NIF,FechaNacimiento,Nacionalidad,EstadoCivil,
			 NivelEstudios,Profesion,Domicilio,CP,Localidad,Telefono,Observaciones
			*/
			datos[0] = vista.obtenerNombreVoluntario();
			datos[1] = vista.obtenerApellidosVoluntario();
			datos[2] = vista.obtenerNIFVoluntario();
			datos[3] = vista.obtenerFechaNacimientoVoluntario();
			datos[4] = vista.obtenerNacionalidadVoluntario();
			datos[5] = vista.obtenerEstadoCivilVoluntario();
			datos[6] = vista.obtenerNivelEstudiosVoluntario();
			datos[7] = vista.obtenerProfesionVoluntario();
			datos[8] = vista.obtenerDomicilioVoluntario();
			datos[9] = vista.obtenerCPVoluntario();
			datos[10] = vista.obtenerLocalidadVoluntario();
			datos[11] = vista.obtenerTelefonoVoluntario();
			datos[12] = vista.obtenerObservacionesVoluntario();
			
			insertarVoluntario(datos,ControladorVoluntarios.genContrasena());
					
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
