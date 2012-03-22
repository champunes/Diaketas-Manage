
package Controlador;

import Vista.VentanaPrincipal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @see ControladorVolunt es una clase singleton
 * @author Jose Angel Gonzalez Molina
 */

public class ControladorVolunt implements Controlador{

	//Atributo para singleton
	private static ControladorVolunt instancia = null;
	
	public static ControladorVolunt getInstance(VentanaPrincipal v){
		
		if(instancia == null)
			instancia = new ControladorVolunt(v);
		return instancia;
		
	}
	
	private VentanaPrincipal vista;
	
	//Clase para controlar los eventos de la imagen Nuevo Voluntario
	class ListenerImgNVolunt implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent me) {
			vista.mostrarVistaNVolunt();
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
	
	//Clase para controlar los eventos de la imagen Buscar Voluntario
	class ListenerImgVBuscar implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent me) {
			vista.mostrarVistaVBuscar();
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
	
	//Clase para controlar los eventos de la imagen Contabilidad
	class ListenerImgContab implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent me) {
			vista.mostrarVistaContab();
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
	
	//Clase para controlar los eventos de la imagen Ayudas
	class ListenerImgAyuda implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent me) {
			vista.mostrarVistaAyuda();
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
	
	private ControladorVolunt(VentanaPrincipal v){
		vista = v;
		vista.anadirListenerImgNVolunt(new ListenerImgNVolunt());
		vista.anadirListenerImgVBuscar(new ListenerImgVBuscar());
		vista.anadirListenerImgContab(new ListenerImgContab());
		vista.anadirListenerImgAyuda(new ListenerImgAyuda());
	}
	
	@Override
	public void actualizarVista() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public void mostrarVista(){
		vista.mostrarVistaVolunt();
	}
	
}
