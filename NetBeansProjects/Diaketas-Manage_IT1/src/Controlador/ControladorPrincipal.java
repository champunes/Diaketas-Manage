package Controlador;

import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author champunes
 */
public class ControladorPrincipal {
	
	public VentanaPrincipal vista;
	
	//Clase para controlar los eventos del boton identificacion	
	class ListenerBIdent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			vista.mostrarVistaPrincipal();
		}
		
	}
	
	//Constructor por defecto	
	public ControladorPrincipal(){
		vista = new VentanaPrincipal();
		vista.mostrarVistaIdentificacion();
		vista.anadirListenerBIdent(new ListenerBIdent());
		vista.setVisible(true);
	}	
	
}
