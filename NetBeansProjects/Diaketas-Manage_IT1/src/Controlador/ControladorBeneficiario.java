
package Controlador;

import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @see ControladorBenef es una clase singleton
 * @author Mario Orozco Borrego
 */
public class ControladorBeneficiario implements ActionListener{

	//Atributo para singleton
	private static ControladorBeneficiario instancia = null;
	
	public static ControladorBeneficiario getInstance(){
		
		if(instancia == null)
			instancia = new ControladorBeneficiario();
		return instancia;
		
	}
	
	private VentanaPrincipal vista;
	
	
	private ControladorBeneficiario(){
		
	}
	
     public void setVentanaPrincipal(VentanaPrincipal pvista){
         vista = pvista;
     }
   
	
	public void mostrarVista(){
		vista.mostrarVistaBenef();
	}

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String sAccion = ae.getActionCommand();
        
        System.out.println("ActionCommand: " + sAccion);
        
        if (sAccion.equals("buscarBeneficiario")){
            
        }
        else if (sAccion.equals("nuevoBeneficiario")){

        }
        else if (sAccion.equals("navToMainFromBeneficiarios")){
            vista.mostrarVistaPrincipal();
        }
        else {
            
        }
    }
	
}
