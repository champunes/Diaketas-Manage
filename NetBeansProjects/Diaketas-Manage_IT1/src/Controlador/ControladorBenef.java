
package Controlador;

import Vista.VentanaPrincipal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 *
 * @author Jose Angel Gonzalez Molina
 */
public class ControladorBenef {

	private VentanaPrincipal vista;
	
	//Clase para controlar los eventos de la etiqueta main
	class ListenerLabBMain implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent me) {
			vista.mostrarVistaPrincipal();
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
	
	//Clase para controlar los eventos de la imagen Nuevo Beneficiario
	class ListenerImgNBenef implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent me) {
			vista.mostrarVistaNBenef();
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
	
	class ListenerImgBBuscar implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent me) {
			vista.mostrarVistaBBuscar();
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
	
	public ControladorBenef(VentanaPrincipal v){
		
		vista = v;
		vista.mostrarVistaBenef();
		vista.anadirListenerLabBMain(new ListenerLabBMain());
		vista.anadirListenerImgNBenef(new ListenerImgNBenef());
		vista.anadirListenerImgBBuscar(new ListenerImgBBuscar());
		
	}
	
}
