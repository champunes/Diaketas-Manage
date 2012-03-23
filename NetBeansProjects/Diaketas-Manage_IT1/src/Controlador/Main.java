package Controlador;

import Vista.VentanaPrincipal;

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
            Vista.VentanaPrincipal VP = Vista.VentanaPrincipal.getInstance();
            ControladorPrincipal.getInstance().setVentanaPrincipal(VP);
	}
}
