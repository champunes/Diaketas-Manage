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
 *		003 - Mar 26, 2012 - JGM - Restructuración de la clase para adaptarse a la arquitectura MVC
 *		004 - Mar 27, 2012 - JGM - ListenerBtGuardar - Lectura del formulario en la vista
 *      005 - Mar 29, 2012 - JGM - insertarVoluntario() - Manejo de la insercion de un voluntario
 *		006 - Abr 23, 2012 - JGM - GuardarVoluntario, BorrarVoluntario, VerVoluntario
 **
 ** NOTAS:
 **   
 **
 */

package Controlador;

import JDBC.VoluntarioJDBC;
import Modelo.Identificable;
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
		vista.anadirListenerBtPassVoluntario(new ListenerBtPassVoluntario());
		vista.anadirListenerNavToVoluntariosFromContabilidad(new ListenerNavToVoluntarios());	
		vista.anadirListenerNavToVoluntariosFromAyudas(new ListenerNavToVoluntarios());
		vista.anadirListenerNavToVoluntariosFromBuscarVoluntario(new ListenerNavToVoluntarios());
		vista.anadirListenerNavToVoluntariosFromDatosVoluntario(new ListenerNavToVoluntarios());
		
    }
	
	private boolean insertarVoluntario(Voluntario volun,String password){
		
		if (this.comprobarDatos(volun) == false ||this.comprobarContrasena(password) == false)
			return false;
		
		try{
			vol.añadirVoluntario(volun);
		}
		catch(SQLException se){
			System.err.print(se.getMessage());
		}
		
		return true;	
			
	}
	
	private boolean modificarVoluntario(Voluntario volun){
		
		if (this.comprobarDatos(volun) == false)
			return false;
		
		try{
			vol.modificarDatosVoluntario(volun);
		}
		catch(SQLException se){
			System.err.print(se.getMessage());
		}
		
		return true;			
		
	}

	@Override
	public boolean comprobarDatos(Identificable dato) {
		//Comprobar DNI
		//if(dato.getNIF().length() < 9 || dato.getNIF().length() > 9)
		//	return false;		
		return true;
	}

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
			vista.mostrarVistaDatosVoluntario();
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btBuscarVoluntarioDNI
	 */
	
	private class ListenerBtBuscarVoluntarioDNI implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			String nifVol = vista.obtenerBusquedaVoluntarioDNI();
			
			try{
				Voluntario volun = vol.obtenerVoluntario(nifVol);
				String datos[] = new String[3];
				datos[0] = nifVol;
				datos[1] = volun.getNombre()+" "+volun.getApellidos();
				datos[2] = volun.getFechaDENacimiento().toString();
				vista.escribirTablaBusquedaVoluntario(datos);
			}
			catch(SQLException ex){
				System.err.print(ex.getMessage());
			}
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btVerVoluntarioBusqueda
	 */
	
	private class ListenerBtVerVoluntarioBusqueda implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			vista.mostrarVistaDatosVoluntario();

			String[] datosVol = new String[8];

			try{
				Voluntario volun = vol.obtenerVoluntario(vista.obtenerBusquedaVoluntarioDNI());
				datosVol[0] = volun.getNombre();
				datosVol[1] = volun.getApellidos();
				datosVol[2] = volun.getNIF();
				datosVol[3] = volun.getFechaDENacimiento().toString();
				datosVol[4] = volun.getDomicilio();
				datosVol[5] = String.valueOf(volun.getCP());
				datosVol[6] = volun.getLocalidad();
				datosVol[7] = String.valueOf(volun.getTelefonoFijo());

				vista.escribirVoluntarioDatos(datosVol);
			}
			catch(SQLException ex){
				System.err.print(ex.getMessage());
			}
				
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btBorrar
	 */
	
	private class ListenerBtBorrar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			String nif = vista.obtenerNIFVoluntario();
			
			try{
			if(!vol.borrarVoluntario(nif))
				System.err.print("Error borrando beneficiario");
			}
			catch(SQLException ex){
				System.err.print(ex.getMessage());
			}
			
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btGuardar
	 */
	
	private class ListenerBtGuardar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			Voluntario volun = new Voluntario();
			/*El orden de los datos en el array es:
			 Nombre,Apellidos,NIF,FechaNacimiento,Nacionalidad,EstadoCivil,
			 NivelEstudios,Profesion,Domicilio,CP,Localidad,Telefono,Observaciones
			*/
			volun.setNombre(vista.obtenerNombreVoluntario());
			volun.setApellidos(vista.obtenerApellidosVoluntario());
			volun.setNIF(vista.obtenerNIFVoluntario());
			DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);		
			try{
				java.util.Date fecha = df.parse(vista.obtenerFechaNacimientoVoluntario());
				java.sql.Date fechasql = new java.sql.Date(fecha.getTime());
				volun.setFechaDENacimiento(fechasql);
			}
			catch(ParseException p){
				System.err.print(p.getMessage());
			}
			//volun.setEstadoCivil(vista.obtenerEstadoCivilVoluntario());
			//volun.setNivelEstudios(vista.obtenerNivelEstudiosVoluntario());
			//volun.setProfesion(vista.obtenerProfesionVoluntario());
			volun.setDomicilio(vista.obtenerDomicilioVoluntario());
			volun.setCP(Integer.parseInt(vista.obtenerCPVoluntario()));
			volun.setLocalidad(vista.obtenerLocalidadVoluntario());
			volun.setTelefonoFijo(Integer.parseInt(vista.obtenerTelefonoVoluntario()));
			volun.setTelefonoMovil(Integer.parseInt(vista.obtenerTelefonoVoluntario()));
			//volun.setObservaciones(vista.obtenerObservacionesVoluntario());
			
			String pass = ControladorVoluntarios.genContrasena();
			if(insertarVoluntario(volun,ControladorVoluntarios.genContrasena()) == false)
				modificarVoluntario(volun);
			vista.mostrarDiagPassVoluntario(pass);
					
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btPassVoluntario
	 */
	
	private class ListenerBtPassVoluntario implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			vista.mostrarVistaDatosVoluntario();
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
