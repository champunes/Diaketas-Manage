package Controlador;

import Vista.InterfazVista;
import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author champunes
 */
public class ControladorPrincipal implements ActionListener{
	
	public VentanaPrincipal vista;

	public void crearVistaPrincipal(){
		vista = new VentanaPrincipal();
		vista.mostrarVistaPrincipal();
		vista.setControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals(InterfazVista.BOTON))
			vista.mostrarVistaSecundaria();
	}
	
}
