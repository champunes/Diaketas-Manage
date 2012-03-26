package Controlador;

import Vista.VentanaPrincipal;
import Vista.VentanaPrincipal2;

/**
 *
 * @author Jose Angel Gonzalez Molina
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
            //VentanaPrincipal.getInstance();
			ControladorPrincipal2.getInstance(VentanaPrincipal2.getInstance());
	}
}
