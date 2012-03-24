
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
        
        /** PANEL INICIO VOLUNTARIOS */
        if (sAccion.equals("ayudas")){
            vista.mostrarVistaAyuda();
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
        
        /** PANEL DE AYUDAS **/
        else if (sAccion.equals("navToMainFromAyudas")){
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
            System.out.println("Accion no reconocida.");
        }
    }
	
}
