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
	
	public static ControladorContabilidad getInstance(){
		
		if(instancia == null)
			instancia = new ControladorContabilidad();
		return instancia;
		
	}

    private VentanaPrincipal vista;
    
    
    private ControladorContabilidad() {
       
    }
   
     public void setVentanaPrincipal(VentanaPrincipal pvista){
         vista = pvista;
     }
 

   
    public void mostrarVista() {
        vista.mostrarVistaContab();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String sAccion = ae.getActionCommand();
        
        if (sAccion.equals("obtenerContabilidad")){
            
        }
        else if (sAccion.equals("navToMainFromContabilidad")){
            vista.mostrarVistaPrincipal();
        }
        else if (sAccion.equals("navToVoluntariosFromContabilidad")){
            vista.mostrarVistaVolunt();
        }
        else{
            System.out.println("Accion no reconocida");
        }
    }
    
}
