/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Mario Orozco Borrego
 */
public class ControladorContabilidad implements ActionListener{

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
       
    }
   
    
 

   
    public void mostrarVista() {
        vista.mostrarVistaContab();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
