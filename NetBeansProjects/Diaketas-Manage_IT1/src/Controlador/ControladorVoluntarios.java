
package Controlador;

import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @see ControladorVolunt es una clase singleton
 * @author Jose Angel Gonzalez Molina
 */

public class ControladorVoluntarios implements ActionListener{

	//Atributo para singleton
	private static ControladorVoluntarios instancia = null;
	
	public static ControladorVoluntarios getInstance(VentanaPrincipal v){
		
		if(instancia == null)
			instancia = new ControladorVoluntarios(v);
		return instancia;
		
	}
	
	private VentanaPrincipal vista;
      

		
	
	private ControladorVoluntarios(VentanaPrincipal v){
		vista = v;
		
	}
	

	public void mostrarVista(){
		vista.mostrarVistaVolunt();
	}

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
	
}
