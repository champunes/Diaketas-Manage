
package Controlador;

import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @see ControladorVolunt es una clase singleton
 * @author Mario Orozco Borrego
 */

public class ControladorVoluntarios implements ActionListener{

	//Atributo para singleton
	private static ControladorVoluntarios instancia = null;
	
	public static ControladorVoluntarios getInstance(){
		
		if(instancia == null)
			instancia = new ControladorVoluntarios();
		return instancia;
		
	}
	
	private VentanaPrincipal vista;
      

	public void setVentanaPrincipal(VentanaPrincipal pvista){
         vista = pvista;
        }	
	
	private ControladorVoluntarios(){
		
	}
	

	public void mostrarVista(){
		vista.mostrarVistaVolunt();
	}

    @Override
    public void actionPerformed(ActionEvent ae) {
        String sAccion = ae.getActionCommand();
        
        if (sAccion.equals("ayudas")){
            
        }
        else if (sAccion.equals("buscarVoluntario")){
            
        }
        else if (sAccion.equals("contabilidad")){
            vista.mostrarVistaContab();
        }
        else if (sAccion.equals("nuevoVoluntario")){
            
        }
        else if (sAccion.equals("navToMainFromVoluntarios")){
            vista.mostrarVistaPrincipal();
        }
        else{
            System.out.println("Accion no reconocida.");
        }
    }
	
}
