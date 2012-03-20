package Controlador;

import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author champunes
 */
public class ControladorPrincipal {
	
	private VentanaPrincipal vista;
	private ControladorSocios CS;
	private ControladorBenef CB;
	
	//Clase para controlar los eventos del boton identificacion	
	class ListenerBIdent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			vista.mostrarVistaPrincipal();
		}
		
	}
	
	//Clase para controlar los eventos de la imagen de Socios
	class ListenerImgSocios implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent me) {
			CS = new ControladorSocios();
		}

		@Override
		public void mousePressed(MouseEvent me) {
		}

		@Override
		public void mouseReleased(MouseEvent me) {
		}

		@Override
		public void mouseEntered(MouseEvent me) {
		}

		@Override
		public void mouseExited(MouseEvent me) {
		}
		
	}
	
	//Clase para controlar los eventos de la imagen de Beneficiarios
	class ListenerImgBenef implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent me) {
			CB = new ControladorBenef(vista);
		}

		@Override
		public void mousePressed(MouseEvent me) {
		}

		@Override
		public void mouseReleased(MouseEvent me) {
		}

		@Override
		public void mouseEntered(MouseEvent me) {
		}

		@Override
		public void mouseExited(MouseEvent me) {
		}
		
	}
	
	//Constructor por defecto	
	public ControladorPrincipal(){
		vista = new VentanaPrincipal();
		vista.mostrarVistaIdentificacion();
		vista.anadirListenerBIdent(new ListenerBIdent());
		vista.anadirListenerImgSocios(new ListenerImgSocios());
		vista.anadirListenerImgBenef(new ListenerImgBenef());
		vista.setVisible(true);
	}	
	
}
