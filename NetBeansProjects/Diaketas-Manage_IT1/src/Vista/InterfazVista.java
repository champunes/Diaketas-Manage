package Vista;

import java.awt.event.ActionListener;

/**
 *
 * @author champunes
 */
public interface InterfazVista {

	void setControlador(ActionListener c);
	void mostrarVistaPrincipal();
	void mostrarVistaSecundaria();
	
	//Constantes que definen las posibles operaciones
	static final String BOTON = "Boton";
	
}
