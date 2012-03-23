
package Controlador;

import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @see ControladorBenef es una clase singleton
 * @author Jose Angel Gonzalez Molina
 */
public class ControladorBeneficiario implements ActionListener{

	//Atributo para singleton
	private static ControladorBeneficiario instancia = null;
	
	public static ControladorBeneficiario getInstance(VentanaPrincipal v){
		
		if(instancia == null)
			instancia = new ControladorBeneficiario(v);
		return instancia;
		
	}
	
	private VentanaPrincipal vista;
	
	
	private ControladorBeneficiario(VentanaPrincipal v){
		
		vista = v;
		
		
	}
	
	
	
	public void mostrarVista(){
		vista.mostrarVistaBenef();
	}

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
	
}
