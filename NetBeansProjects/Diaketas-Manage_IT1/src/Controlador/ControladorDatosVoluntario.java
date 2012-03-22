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
 * @author psylock
 */
public class ControladorDatosVoluntario implements Controlador{

     //Atributo para singleton
	private static ControladorDatosVoluntario instancia = null;
	
	public static ControladorDatosVoluntario getInstance(VentanaPrincipal v){
		
		if(instancia == null)
			instancia = new ControladorDatosVoluntario(v);
		return instancia;
		
	}

    private VentanaPrincipal vista;

    private ControladorDatosVoluntario(VentanaPrincipal v) {
        vista = v;
        vista.anadirListenerlabMainVDatos(new ListenerlabMainVDatos());
        vista.anadirListenerlabVVDatos(new ListenerlabVVDatos());
        vista.anadirListenerbtnDatosVolGuardar(new ListenerbtnDatosVolGuardar());
        vista.anadirListenerbtnDatosVolLimpiar(new ListenerbtnDatosVolLimpiar());
    }
    
    
    class ListenerlabMainVDatos implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            vista.mostrarVistaPrincipal();
        }

        @Override
        public void mousePressed(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
        
    }
    
    
    class ListenerlabVVDatos implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            vista.mostrarVistaVolunt();
        }

        @Override
        public void mousePressed(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
        
    }
    
    class ListenerbtnDatosVolGuardar implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mousePressed(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    class ListenerbtnDatosVolLimpiar implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mousePressed(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
        
    }
    
    @Override
    public void actualizarVista() {
        vista.mostrarVistaDatosVoluntarios();
    }

    @Override
    public void mostrarVista() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
