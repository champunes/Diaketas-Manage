/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import JDBC.ColaboracionJDBC;
import Modelo.Colaboracion;
import Modelo.Colaborador;
import Modelo.Identificable;
import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 ** NOMBRE CLASE: 
 **	  ControladorColaborador
 **
 ** DESCRIPCION:
 **       
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
 *      001 - 2 mai 2012 - RC - adicion de metodos
 *      002 - 5 mai 2012 - RC - relleno de metodos
 *      003 - 7 mai 2012 - RC - interface actionListener
 **
 ** NOTAS:
 **   
 **
 */
public class ControladorColaboracion implements Controlador, ActionListener{

    /** PATRON DE DISEÑO SINGLETON */
    
    private static ControladorColaboracion instancia;


    public static ControladorColaboracion getInstance(VentanaPrincipal pvista){
        if (instancia == null)
            instancia = new ControladorColaboracion(pvista);

        return instancia;

    }
    
    private VentanaPrincipal vista;

    public ControladorColaboracion(VentanaPrincipal vista) {
        this.vista = vista;
    }
    
    
    @Override
    public boolean comprobarDatos(Identificable dato) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Colaboracion anadirColaboracion (String[] datos){
        if (!testDatos(datos))
            return null;
        
        Colaboracion c = new Colaboracion();
        
        c.setConcepto(datos[Colaboracion.CONCEPTO_ID]);
        c.setFecha(Date.valueOf(datos[Colaboracion.FECHA_ID]));
        c.setImporte(Integer.parseInt(datos[Colaboracion.IMPORTE_ID]));
        
        
        try {
            ColaboracionJDBC.getInstance().añadirColaboracion(c);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorColaboracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean eliminarColaboracion (Colaboracion c) {
        try {
            return ColaboracionJDBC.getInstance().eliminarColaboracion(c);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorColaboracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public ArrayList<Colaboracion> historialColaboraciones (Colaborador c, Date fechaInicio, Date fechaFin) {
        try {
            return ColaboracionJDBC.getInstance().HistorialColaboraciones(c, fechaInicio, fechaFin);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorColaboracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    private boolean testDatos (String[] datos) {
        // cada campo debe ser not null
        for (int i=0; i<datos.length; i++) {
            if (datos[i].length() < 1)
                return false;
        }
        
        if (!TestDatos.isOnlyDigit(datos[Colaboracion.IMPORTE_ID]))
            return false;
        
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
