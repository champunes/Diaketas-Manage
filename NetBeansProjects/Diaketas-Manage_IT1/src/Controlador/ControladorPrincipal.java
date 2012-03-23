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
public class ControladorPrincipal implements ActionListener{
	
	private static ControladorPrincipal instancia;
        
	
	public static ControladorPrincipal getInstance(){
            if (instancia == null)
                instancia = new ControladorPrincipal();
            
            return instancia;
		
	}
	
	private VentanaPrincipal vista;
        
	//Constructor por defecto	
	private ControladorPrincipal(){
            
            System.out.println("Constructor de ControladorPrincipal");
              //  vista = new VentanaPrincipal();
		//vista.setVisible(true);
                //vista.mostrarVistaIdentificacion();
                 //  vista = VentanaPrincipal.getInstance();
	}
	
     public void setVentanaPrincipal(VentanaPrincipal pvista){
         vista = pvista;
     }
   

    @Override
    public void actionPerformed(ActionEvent ae) {
          System.out.println("ActionPerformed");
        
        String sAccion = ae.getActionCommand();
        System.out.println("Accion: " + sAccion);
     
        if (sAccion.equals("accionLogin")){
            vista.mostrarVistaPrincipal();
        }
        else if(sAccion.equals("entrarAPanelBeneficiarios")){
            vista.mostrarVistaBenef();
        }
        else if(sAccion.equals("entrarAPanelBolsaTrabajo")){
            
        }
        else if (sAccion.equals("entrarAPanelSocios")){
            
        }
        else if (sAccion.equals("entrarAPanelVoluntarios")){
            vista.mostrarVistaVolunt();
        }
        else{
            System.out.println("La accion no se reconoce");
        }
    }
	
}
