package Controlador;

import JDBC.CuotaJDBC;
import Modelo.Cuota;
import Modelo.Identificable;
import Modelo.Socio;
import Vista.VentanaPrincipal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 ** NOMBRE CLASE: 
 **	  ControladorCuota
 **
 ** DESCRIPCION:
 **       Controlador del panel de cuotas
 **       
 **
 ** DESARROLLADO POR:
 *          Raphael Colleau (RC)
 **        
 **
 ** SUPERVISADO POR:
 **          
 **
 ** HISTORIA:
 ** 	000 - 1 mai 2012 - RC - Creacion
 **
 ** NOTAS:
 **   
 **
 */
public class ControladorCuota implements Controlador{

    /**
     * PATRON DE DISEÑO SINGLETON
     */
    private static ControladorCuota instancia = null;

    public static ControladorCuota getInstance(VentanaPrincipal pvista) {

        if (instancia == null) {
            instancia = new ControladorCuota(pvista);
        }
        return instancia;

    }
    
    private VentanaPrincipal vista;

    public ControladorCuota(VentanaPrincipal vista) {
        this.vista = vista;
    }
    
    
    @Override
    public boolean comprobarDatos(Identificable dato) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Cuota anadirCuota (String[] datos){
        // TODO comprobar datos
        return null;
    }
    
    public boolean cancelarCuota (Cuota c) {
        if (c.getFechaUltimoPago() == c.getFechaInicio()) {
            try {
                return CuotaJDBC.getInstance().eliminarCuota(c);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCuota.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                return CuotaJDBC.getInstance().cancelarCuota(c);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorCuota.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public ArrayList<Cuota> comprobarImpagos (Socio s) {
        ArrayList<Cuota> cuotas = null;
        try {
            cuotas = CuotaJDBC.getInstance().comprobarImpagos();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCuota.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cuotas;
    }
    
    public ArrayList<Cuota> verHistorialCuotas (Socio s) {
        ArrayList<Cuota> cuotas = null;
        
        /* TODO 
        try {
            CuotaJDBC.getInstance().historialCuotas(s);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCuota.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return cuotas;
    }
}
