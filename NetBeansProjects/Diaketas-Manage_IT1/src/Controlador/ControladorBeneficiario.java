
package Controlador;

import Vista.VentanaPrincipal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * @see ControladorBenef es una clase singleton
 * @author Jose Angel Gonzalez Molina
 */
public class ControladorBeneficiario implements Controlador{

	//Atributo para singleton
	private static ControladorBeneficiario instancia = null;
	
	public static ControladorBeneficiario getInstance(VentanaPrincipal v){
		
		if(instancia == null)
			instancia = new ControladorBeneficiario(v);
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
	
	private ControladorBeneficiario(VentanaPrincipal v){
		
		vista = v;
		vista.anadirListenerImgNBenef(new ListenerImgNBenef());
		vista.anadirListenerImgBBuscar(new ListenerImgBBuscar());
		
	}
	
	@Override
	public void actualizarVista() {
		throw new UnsupportedOperationException("Not supported yet.");
	}	
	
	public void mostrarVista(){
		vista.mostrarVistaBenef();
	}
	
}
