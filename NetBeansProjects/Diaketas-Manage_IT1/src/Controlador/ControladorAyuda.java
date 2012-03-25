
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

public class ControladorAyuda implements ActionListener{

	//Atributo para singleton
	private static ControladorAyuda instancia = null;
	
	public static ControladorAyuda getInstance(){
		
		if(instancia == null)
			instancia = new ControladorAyuda();
		return instancia;
		
	}
	
	private VentanaPrincipal vista;
      

	public void setVentanaPrincipal(VentanaPrincipal pvista){
         vista = pvista;
        }	
	
	private ControladorAyuda(){
		
	}
	


    @Override
    public void actionPerformed(ActionEvent ae) {
        String sAccion = ae.getActionCommand();
        
      
        /** PANEL DE AYUDAS **/
        if (sAccion.equals("navToMainFromAyudas")){
            vista.mostrarVistaPrincipal();
        }
        else if (sAccion.equals("navToVoluntariosFromAyudas")){
            vista.mostrarVistaVolunt();
        }
        else if (sAccion.equals("buscarBeneficiario")){
            
        }
        else if (sAccion.equals("guardarTipoAyudas")){
            
        }
        else if (sAccion.equals("guardarTipoAyuda")){
            
        }
        else if (sAccion.equals("eliminarTipoAyuda")){
            
        }
      
        else{

        }
    }
	
}
