/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaPrincipal;

/**
 *
 * @author psylock
 */
public class ControladorDatosVoluntario implements Controlador{

     //Atributo para singleton
	private static ControladorDatosVoluntario instancia = null;
	
	public static ControladorDatosVoluntario getInstance(VentanaPrincipal v){
		
		if(instancia == null)
			instancia = new ControladorDatosVoluntario(v);
		return instancia;
		
	}

    private VentanaPrincipal vista;

    private ControladorDatosVoluntario(VentanaPrincipal v) {
        vista = v;
    }
    
    @Override
    public void actualizarVista() {
    }

    @Override
    public void mostrarVista() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
