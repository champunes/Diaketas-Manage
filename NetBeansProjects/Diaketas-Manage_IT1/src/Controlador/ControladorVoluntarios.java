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

import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorVoluntarios implements ActionListener{

	/** PATRON DE DISEÑO SINGLETON */
	private static ControladorVoluntarios instancia = null;
	
	public static ControladorVoluntarios getInstance(){
		
		if(instancia == null)
			instancia = new ControladorVoluntarios();
		return instancia;
		
	}
	
	private VentanaPrincipal vista;
      
    /** 
     * Establece como ventana padre la pasada como parámetro
     * @param pvista ventana padre
     */
    public void setVentanaPrincipal(VentanaPrincipal pvista){
        vista = pvista;
    }	

    /**
     * Constructor de la clase
     */
    private ControladorVoluntarios(){

    }
	
    
    /**
     * Manejador de eventos de la interfaz
     * @param ae evento
     */  
    @Override
    public void actionPerformed(ActionEvent ae) {
        String sAccion = ae.getActionCommand();

        /** PANEL INICIO VOLUNTARIOS */
        if (sAccion.equals("ayudas")){
            vista.mostrarVistaAyuda();
        }
        else if (sAccion.equals("buscarVoluntario")){
            vista.mostrarVistaBuscarVoluntario();
        }
        else if (sAccion.equals("contabilidad")){
            vista.mostrarVistaContabilidad();
        }
        else if (sAccion.equals("nuevoVoluntario")){
            vista.mostarVistaDatosVoluntario();
        }
        else if (sAccion.equals("navToMainFromVoluntarios")){
            vista.mostrarVistaPrincipal();
        }
        
        /** PANEL DE DATOS DE VOLUNTARIOS */
        else if (sAccion.equals("navToMainFromDatosVoluntario")){
            vista.mostrarVistaPrincipal();
        }
        else if (sAccion.equals("navToVoluntariosFromDatosVoluntario")){
            vista.mostrarVistaVoluntarios();
        }
        else if (sAccion.equals("guardarDatosVoluntario")){
             System.out.println("Accion ejecutada: " + sAccion);
        }
        else if (sAccion.equals("borrarDatosVoluntario")){
             System.out.println("Accion ejecutada: " + sAccion);
        }
        
        /** PANEL DE BUSQUEDA DE VOLUNTARIOS */
        else if (sAccion.equals("navToMainFromBuscarVoluntario")){
            vista.mostrarVistaPrincipal();
        }
        else if (sAccion.equals("navToVoluntariosFromBuscarVoluntario")){
            vista.mostrarVistaVoluntarios();
        }
        else if (sAccion.equals("buscarVoluntarioDNI")){
             System.out.println("Accion ejecutada: " + sAccion);
        }
        else if (sAccion.equals("verVoluntarioBusqueda")){
             System.out.println("Accion ejecutada: " + sAccion);
        }
       
    }
	
}
