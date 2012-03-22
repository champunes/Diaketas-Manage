package Controlador;

import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @see Clase singleton
 * @author Jose Angel Gonzalez Molina
 */
public class ControladorPrincipal implements Controlador{
	
	private static ControladorPrincipal instancia = null;
	
	public static ControladorPrincipal getInstance(){
		
		if(instancia == null)
			instancia = new ControladorPrincipal();
		return instancia;
		
	}
	
	private VentanaPrincipal vista;
	private Controlador C;
	
	//Clase para controlar los eventos del boton identificacion	
	class ListenerBIdent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			mostrarVista();
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
			C = ControladorBeneficiario.getInstance(vista);
			C.mostrarVista();
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
	class ListenerImgVolunt implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent me) {
			C = ControladorVoluntarios.getInstance(vista);
			C.mostrarVista();
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
			mostrarVista();
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
		vista.anadirListenerImgVolunt(new ListenerImgVolunt());
		vista.anadirListenerLabBMain(new ListenerLabBMain());
		vista.setVisible(true);
	}
	
	@Override
	public void actualizarVista() {
		throw new UnsupportedOperationException("Not supported yet.");
	}	
	
	@Override
	public void mostrarVista() {
		vista.mostrarVistaPrincipal();
	}
	
}
