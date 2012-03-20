
package Controlador;

import Vista.VentanaPrincipal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * @see ControladorBenef es una clase singleton
 * @author Jose Angel Gonzalez Molina
 */
public class ControladorBenef {

	//Atributo para singleton
	private static ControladorBenef instancia = null;
	
	public static ControladorBenef getInstance(VentanaPrincipal v){
		
		if(instancia == null)
			instancia = new ControladorBenef(v);
		return instancia;
		
	}
	
	private VentanaPrincipal vista;
	
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
	
	private ControladorBenef(VentanaPrincipal v){
		
		vista = v;
		vista.anadirListenerImgNBenef(new ListenerImgNBenef());
		vista.anadirListenerImgBBuscar(new ListenerImgBBuscar());
		
	}
	
	public void mostrar(){
		vista.mostrarVistaBenef();
	}
	
}
