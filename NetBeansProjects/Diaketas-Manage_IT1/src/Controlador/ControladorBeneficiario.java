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
 *		004 - Mar 30, 2012 - JGM - ListenerBtGuardarBeneficiario e insertarBeneficiario()
 *		
 *      
 **
 ** NOTAS:
 **   
 **
 */

package Controlador;

import JDBC.BeneficiarioJDBC;
import Modelo.Beneficiario;
import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;


public class ControladorBeneficiario implements Controlador{

	/** PATRON DE DISEÑO SINGLETON */
    
	private static ControladorBeneficiario instancia = null;
	
	public static ControladorBeneficiario getInstance(VentanaPrincipal pvista){
		
		if(instancia == null)
			instancia = new ControladorBeneficiario(pvista);
		return instancia;
		
	}
	
    private VentanaPrincipal vista;
	private BeneficiarioJDBC ben;
	
    /**
     * Constructor de la clase
     */
    private ControladorBeneficiario(VentanaPrincipal pvista){
    
	/** 
     * Establece como ventana padre la pasada como parámetro
     */
		vista = pvista;
		
		ben = BeneficiarioJDBC.getInstance();
		
	/** 
     * Conecta el controlador con las distintas interfaces de la vista
     */	
		vista.anadirListenerBtBuscarBeneficiario(new ListenerBtBuscarBeneficiario());
		vista.anadirListenerBtNuevoBeneficiario(new ListenerBtNuevoBeneficiario());
		vista.anadirListenerBtBuscarBeneficiarioDNI(new ListenerBtBuscarBeneficiarioDNI());
		vista.anadirListenerBtVerBeneficiarioBusqueda(new ListenerBtVerBeneficiarioBusqueda());
		vista.anadirListenerBtGuardarBeneficiario(new ListenerBtGuardarBeneficiario());
		vista.anadirListenerBtEliminarBeneficiario(new ListenerBtEliminarBeneficiario());
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
	
	public boolean insertarBeneficiario(String datos[]){
		
		if(comprobarDatos(datos) == false)
			return false;
		
		Beneficiario temp = new Beneficiario();
		/*El orden de los datos en el array es:
			 Nombre,Apellidos,NIF,FechaNacimiento,ProvinciaNacimiento,Nacionalidad,EstadoCivil,
			 NivelEstudios,Profesion,Domicilio,Telefono,Localidad,CP,Observaciones,TipoVivienda,
			 PrecioVivienda,EspecificarTipoVivienda,DescripcionSituacion
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
		//temp.setProvinciaNacimiento(datos[4]);
		temp.setNacionalidad(datos[5]);
		temp.setEstadoCivil(datos[6]);
		temp.setNivelDeEstudio(Integer.parseInt(datos[7]));//Esto es muy raro, nivelEstudios un int????
		temp.setProfesion(datos[8]);
		temp.setDomicilio(datos[9]);
		temp.setTelefonoFijo(Integer.parseInt(datos[10]));
		temp.setLocalidad(datos[11]);
		temp.setCP(Integer.parseInt(datos[12]));
		temp.setObservaciones(datos[13]);
		temp.setVivienda(datos[14]);
		temp.setViviendaAlquiler(Float.parseFloat(datos[15]));
		temp.setViviendaObservaciones(datos[16]);
		temp.setSituacionEconomica(datos[17]);
		
		try{
			ben.añadirBeneficiario(temp);
		}
		catch(SQLException se){
			System.err.print(se.getMessage());
		}
		
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
	 * Clase interna para manejar los eventos de btVerBeneficiarioBusqueda
	 */
	
	private class ListenerBtGuardarBeneficiario implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			String datos[] = new String[18];
			/*El orden de los datos en el array es:
			 Nombre,Apellidos,NIF,FechaNacimiento,ProvinciaNacimiento,Nacionalidad,EstadoCivil,
			 NivelEstudios,Profesion,Domicilio,Telefono,Localidad,CP,Observaciones,TipoVivienda,
			 PrecioVivienda,EspecificarTipoVivienda,DescripcionSituacion
			*/
			datos[0] = vista.obtenerNombreBeneficiario();
			datos[1] = vista.obtenerApellidosBeneficiario();
			datos[2] = vista.obtenerNIFBeneficiario();
			datos[3] = vista.obtenerFechaNacimientoBeneficiario();
			datos[4] = vista.obtenerProvinciaNacimientoBeneficiario();
			datos[5] = vista.obtenerNacionalidadBeneficiario();
			datos[6] = vista.obtenerEstadoCivilBeneficiario();
			datos[7] = vista.obtenerNivelEstudiosBeneficiario();
			datos[8] = vista.obtenerProfesionBeneficiario();
			datos[9] = vista.obtenerDomicilioBeneficiario();
			datos[10] = vista.obtenerTelefonoBeneficiario();
			datos[11] = vista.obtenerLocalidadBeneficiario();
			datos[12] = vista.obtenerCPBeneficiario();
			datos[13] = vista.obtenerObservacionesBeneficiario();
			datos[14] = vista.obtenerTipoViviendaBeneficiario();
			datos[15] = vista.obtenerPrecioViviendaBeneficiario();
			datos[16] = vista.obtenerEspecificarTipoVivienda();
			datos[17] = vista.obtenerDescripcionSituacionBeneficiario();
			
			insertarBeneficiario(datos);
			
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btVerBeneficiarioBusqueda
	 */
	
	private class ListenerBtEliminarBeneficiario implements ActionListener{

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
