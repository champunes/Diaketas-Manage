/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaPrincipal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Mario Orozco Borrego
 */
public class ControladorContabilidad implements Controlador{

    //Atributo para singleton
	private static ControladorContabilidad instancia = null;
	
	public static ControladorContabilidad getInstance(VentanaPrincipal v){
		
		if(instancia == null)
			instancia = new ControladorContabilidad(v);
		return instancia;
		
	}

    private VentanaPrincipal vista;
    
    
    private ControladorContabilidad(VentanaPrincipal v) {
        vista = v;
        vista.anadirListenerlabVContMain(new ListenerlabVContMain());
        vista.anadirListenerlabVContVoluntarios(new ListenerlabVContVoluntarios());
        vista.anadirListenerBtnObtenerContabilidad(new ListenerbtnObtenerContabilidad());
    }
    
    /*
     * @brief Clase para el control de la navegabilidad, va al panel principal de Voluntarios
     */
    class ListenerlabVContVoluntarios implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            vista.mostrarVistaVolunt();
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
    
    
    class ListenerlabVContMain implements MouseListener{

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
    
    class ListenerbtnObtenerContabilidad implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            //ACCION AL PULSAR EL BOTÓN
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
    
    @Override
    public void actualizarVista() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mostrarVista() {
        vista.mostrarVistaContab();
    }
    
}
