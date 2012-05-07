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
 *		005 - Abr 16, 2012 - JGM - Comunicación con PanelBeneficiarioDatos
 *		006 - Abr 19, 2012 - JGM - Reparado el problema al insertar Familiares
 *		007 - May  1, 2012 - JGM - Añadido el metodo de insercion de Movimientos
 *		
 *      
 **
 ** NOTAS:
 **   
 **
 */

package Controlador;

import JDBC.BeneficiarioJDBC;
import JDBC.MovimientoJDBC;
import Modelo.Identificable;
import Modelo.Beneficiario;
import Modelo.Movimiento;
import Modelo.Persona;
import Modelo.Ayuda;
import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	private MovimientoJDBC mov;
	
    /**
     * Constructor de la clase
     */
    private ControladorBeneficiario(VentanaPrincipal pvista){
    
	/** 
     * Establece como ventana padre la pasada como parámetro
     */
		vista = pvista;
		
		ben = BeneficiarioJDBC.getInstance();
		mov = MovimientoJDBC.getInstance();
		
	/** 
     * Conecta el controlador con las distintas interfaces de la vista
     */	
		vista.anadirListenerBtBuscarBeneficiario(new ListenerBtBuscarBeneficiario());
		vista.anadirListenerBtNuevoBeneficiario(new ListenerBtNuevoBeneficiario());
		vista.anadirListenerBtBuscarBeneficiarioDNI(new ListenerBtBuscarBeneficiarioDNI());
		vista.anadirListenerBtVerBeneficiarioBusqueda(new ListenerBtVerBeneficiarioBusqueda());
		vista.anadirListenerBtGuardarBeneficiario(new ListenerBtGuardarBeneficiario());
		vista.anadirListenerBtEliminarBeneficiario(new ListenerBtEliminarBeneficiario());
		vista.anadirListenerBtGuardarFamiliarBeneficiario(new ListenerBtGuardarFamiliarBeneficiario());
		vista.anadirListenerBtEliminarFamiliarBeneficiario(new ListenerBtEliminarFamiliarBeneficiario());
		vista.anadirListenerBtGuardarIntervencionBeneficiario(new ListenerBtGuardarIntervencionBeneficiario());
		vista.anadirListenerBtEliminarIntervencionBeneficiario(new ListenerBtEliminarIntervencionBeneficiario());
		vista.anadirListenerNavToBeneficiariosFromBuscarBeneficiario(new ListenerNavToBeneficiarios());
		vista.anadirListenerNavToBeneficiariosFromBeneficiarioDatos(new ListenerNavToBeneficiarios());
    }
	
	@Override
	public boolean comprobarDatos(Identificable dato) {
		/*//Comprobar DNI
		if(dato.getNIF().length() < 9 || dato.getNIF().length() > 9)
			return false;		*/
		return true;
	}
	
	private boolean insertarBeneficiario(Beneficiario benef){
		
		if(comprobarDatos(benef) == false)
			return false;
	
		try{
			ben.añadirBeneficiario(benef);
		}
		catch(SQLException se){
			System.err.print(se.getMessage());
			return false;
		}
		
		return true;
		
	}
	
	private boolean modificarBeneficiario(Beneficiario benef){
		if(comprobarDatos(benef) == false)
			return false;
		
		try{			
			ben.modificarDatosBeneficiario(benef);
		}
		catch (SQLException ex){
			System.err.print(ex.getMessage());
			return false;
		}
		
		return true;		
	}
	
	private boolean insertarFamiliar(Beneficiario benef,String nifFam, String paren){
					
		try {
			ben.añadirFamiliar(benef, nifFam, paren);			
		} 
		catch (SQLException ex) {
			System.err.print(ex.getMessage());
			return false;
		}
		
		return true;
		
	}
	
	private boolean insertarGasto(Movimiento movim){
		
		try{
			mov.registrarDatosGasto(movim);
		}
		catch(SQLException ex){
			System.err.print(ex.getMessage());
			return false;	
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
			String nifBen = vista.obtenerBusquedaBeneficiarioDNI();
			
			try{
				Beneficiario benef = ben.obtenerBeneficiario(nifBen);
				String datos[] = new String[3];
				datos[0] = nifBen;
				datos[1] = benef.getNombre()+" "+benef.getApellidos();
				datos[2] = benef.getFechaDENacimiento().toString();
				vista.escribirTablaBusquedaBeneficiario(datos);
			}
			catch(SQLException ex){
				System.err.print(ex.getMessage());
			}
						
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btVerBeneficiarioBusqueda
	 */
	
	private class ListenerBtVerBeneficiarioBusqueda implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			vista.mostrarVistaDatosBeneficiario();
			
			String[] datosBen = new String[17];
			ArrayList<String[]> datosFam = new ArrayList();
			
			try{
				Beneficiario benef = ben.obtenerBeneficiario(vista.obtenerBusquedaBeneficiarioDNI());
				datosBen[0] = benef.getNombre();
				datosBen[1] = benef.getApellidos();
				datosBen[2] = benef.getNIF();
				datosBen[3] = benef.getFechaDENacimiento().toString();
				datosBen[4] = benef.getNacionalidad();
				datosBen[5] = benef.getEstadoCivil();
				datosBen[6] = benef.getNivelDeEstudio();
				datosBen[7] = benef.getProfesion();
				datosBen[8] = benef.getDomicilio();
				datosBen[9] = String.valueOf(benef.getTelefonoFijo());
				datosBen[10] = benef.getLocalidad();
				datosBen[11] = String.valueOf(benef.getCP());
				datosBen[12] = benef.getObservaciones();
				datosBen[13] = benef.getVivienda();
				datosBen[14] = String.valueOf(benef.getViviendaAlquiler());
				datosBen[15] = benef.getViviendaObservaciones();
				datosBen[16] = benef.getSituacionEconomica();				
				
				vista.escribirDatosGeneralesBeneficiarioDatos(datosBen);
				
				ArrayList<Persona> fams = ben.datosFamiliares(benef.getNIF());
				for(int i=0;i<fams.size();i++){
					String[] temp = new String[4];
					temp[0] = fams.get(i).getNombre() + " " + fams.get(i).getApellidos();
					temp[1] = fams.get(i).getFechaDENacimiento().toString();
					//temp[2] = fams.get(i).getParentesco();
					//temp[3] = fams.get(i).getOcupacion();
					datosFam.add(temp);
				}
				vista.escribirSituacionFamiliarBeneficiarioDatos(datosFam);
				
				
				//vista.escribirIntervencionesBeneficiarioDatos();
			}
			catch(SQLException ex){
				System.err.print(ex.getMessage());
			}

		}
		
	}

	/**
	 * Clase interna para manejar los eventos de btGuardarBeneficiario
	 */
	
	private class ListenerBtGuardarBeneficiario implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			
			Beneficiario benef = new Beneficiario();
			benef.setNombre(vista.obtenerNombreBeneficiario());
			benef.setApellidos(vista.obtenerApellidosBeneficiario());
			benef.setNIF(vista.obtenerNIFBeneficiario());
			DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);		
			try{
				java.util.Date fecha = df.parse(vista.obtenerFechaNacimientoBeneficiario());
				java.sql.Date fechasql = new java.sql.Date(fecha.getTime());
				benef.setFechaDENacimiento(fechasql);
			}
			catch(ParseException p){
				System.err.print(p.getMessage());
			}
			//vista.obtenerProvinciaNacimientoBeneficiario()
			benef.setNacionalidad(vista.obtenerNacionalidadBeneficiario());
			benef.setEstadoCivil(vista.obtenerEstadoCivilBeneficiario());
			benef.setNivelDeEstudio(vista.obtenerProfesionBeneficiario());
			benef.setProfesion(vista.obtenerDomicilioBeneficiario());
			benef.setDomicilio(vista.obtenerTelefonoBeneficiario());
			benef.setTelefonoFijo(Integer.parseInt(vista.obtenerLocalidadBeneficiario()));
			benef.setLocalidad(vista.obtenerCPBeneficiario());
			benef.setCP(Integer.parseInt(vista.obtenerCPBeneficiario()));
			benef.setObservaciones(vista.obtenerObservacionesBeneficiario());
			benef.setVivienda(vista.obtenerTipoViviendaBeneficiario());
			benef.setViviendaAlquiler(Float.parseFloat(vista.obtenerPrecioViviendaBeneficiario()));
			benef.setViviendaObservaciones(vista.obtenerEspecificarTipoVivienda());
			benef.setSituacionEconomica(vista.obtenerDescripcionSituacionBeneficiario());
			
			try{
				benef.setOID(BeneficiarioJDBC.genOID(benef));
			}
			catch(java.io.IOException ex){
				System.err.print(ex.getMessage());
			}
			
			if(insertarBeneficiario(benef) == false)
				modificarBeneficiario(benef);
			
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btEliminarBeneficiario
	 */
	
	private class ListenerBtEliminarBeneficiario implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			String nif = vista.obtenerNIFBeneficiario();
			
			try{
			if(!ben.borrarBeneficiario(nif))
				System.err.print("Error borrando beneficiario");
			}
			catch(SQLException ex){
				System.err.print(ex.getMessage());
			}
		}
		
	}
	
	/**
	 * Clase interna para manejar los eventos de btGuardarFamiliarBeneficiario
	 */
	
	private class ListenerBtGuardarFamiliarBeneficiario implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent ae) {
			
			String nifFam = vista.obtenerNIFFamiliarBeneficiario();
			String paren = vista.obtenerParentescoBeneficiario();
			Beneficiario benef = new Beneficiario();
			
			benef.setNombre(vista.obtenerNombreBeneficiario());
			benef.setApellidos(vista.obtenerApellidosBeneficiario());
			benef.setNIF(vista.obtenerNIFBeneficiario());
			DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);		
			try{
				java.util.Date fecha = df.parse(vista.obtenerFechaNacimientoBeneficiario());
				java.sql.Date fechasql = new java.sql.Date(fecha.getTime());
				benef.setFechaDENacimiento(fechasql);
			}
			catch(ParseException p){
				System.err.print(p.getMessage());
			}
			benef.setDomicilio(vista.obtenerDomicilioBeneficiario());
			benef.setTelefonoFijo(Integer.parseInt(vista.obtenerTelefonoBeneficiario()));
			benef.setLocalidad(vista.obtenerLocalidadBeneficiario());
			benef.setCP(Integer.parseInt(vista.obtenerCPBeneficiario()));
			
			insertarFamiliar(benef,nifFam,paren);
			
		}

	}
	
	
	//ESTA CLASE NO FUNCIONA BIEN PORQUE NECESITO UN CODIGO EN EL MODELO QUE ME DEVUELVA UNA PERSONA
	//CUANDO LE PASO LOS DATOS DEL FORMULARIO
	/**
	 * Clase interna para manejar los eventos de btEliminarFamiliarBeneficiario
	 */
	
	private class ListenerBtEliminarFamiliarBeneficiario implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent ae) {
			String nifFam = vista.obtenerNIFFamiliarBeneficiario();
			String nifBen = vista.obtenerNIFBeneficiario();
			
			try{
				ben.eliminarDatosfamiliar(nifFam, nifBen);
			}
			catch(SQLException ex){
				System.err.print(ex.getMessage());
			}
		}

	}
	
	/**
	 * Clase interna para manejar los eventos de btGuardarIntervencionBeneficiario
	 */
	
	private class ListenerBtGuardarIntervencionBeneficiario implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent ae) {
			String importe = vista.obtenerImporteBeneficiario();
			String concepto = vista.obtenerConceptoBeneficiario();
			//ArrayList<Ayuda> ayuAso = vista.obtenerAyudasAsociadas();
			//Asociacion aso = vista.obtenerAsociacion();
			//String tipo = vista.obtenerTipoIntervencion();
			String observ = vista.obtenerObservacionesIntervencionBeneficiario();
			String nifBen = vista.obtenerNIFBeneficiario();
			
			Movimiento movim = new Movimiento();
			movim.setImporte(Integer.parseInt(importe));
			movim.setConcepto(concepto);
			//movim.setObservaciones(observ);
			//movim.setAyudasAsociadas(ayuAso);
			//movim.setAsociacionQueGenera(aso);
			//movim.setTipo(tipo);			
			java.util.Date fecha = new java.util.Date();
			java.sql.Date fechasql = new java.sql.Date(fecha.getTime());
			movim.setFecha(fechasql);
			try{
				movim.setOID(MovimientoJDBC.genOID(movim));
			}
			catch(java.io.IOException ex){
				System.err.print(ex.getMessage());
			}
			
			insertarGasto(movim);
			
		}

	}
	
	/**
	 * Clase interna para manejar los eventos de btEliminarIntervencionBeneficiario
	 */
	
	private class ListenerBtEliminarIntervencionBeneficiario implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent ae) {
			String concepto = vista.obtenerConceptoBeneficiario();
			String nifBen = vista.obtenerNIFBeneficiario();
			
			//mov.eliminarGasto(concepto,nifBen);
			
			//Eliminar intervencion
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
