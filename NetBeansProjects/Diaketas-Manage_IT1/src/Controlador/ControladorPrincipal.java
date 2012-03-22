package Controlador;

import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @see Clase singleton
 * @author champunes
 */
public class ControladorPrincipal {
	
	private static ControladorPrincipal instancia = null;
	
	public static ControladorPrincipal getInstance(){
		
		if(instancia == null)
			instancia = new ControladorPrincipal();
		return instancia;
		
	}
	
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
			//getInstance()
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
			System.err.println("Hola");
			CB = ControladorBenef.getInstance(vista);
			CB.mostrar();
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
	
	//Constructor por defecto	
	private ControladorPrincipal(){
		vista = new VentanaPrincipal();
		vista.mostrarVistaIdentificacion();
		vista.anadirListenerBIdent(new ListenerBIdent());
		vista.anadirListenerImgSocios(new ListenerImgSocios());
		vista.anadirListenerImgBenef(new ListenerImgBenef());
		vista.anadirListenerLabBMain(new ListenerLabBMain());
		vista.setVisible(true);
	}	
	
}
