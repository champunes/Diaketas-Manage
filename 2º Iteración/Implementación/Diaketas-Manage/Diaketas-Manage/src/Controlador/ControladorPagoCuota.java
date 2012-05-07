/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import JDBC.CuotaJDBC;
import JDBC.PagoCuotaJDBC;
import JDBC.SocioJDBC;
import Modelo.*;
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
 **	  ControladorPagoCuota
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
 ** 	000 - 5 mai 2012 - RC - Creacion y metodos
 *      001 - 6 mai 2012 - RC - relleno de metodos
 *      002 - 7 mai 2012 - RC - interface actionListener
 **
 ** NOTAS:
 **   
 **
 */
public class ControladorPagoCuota implements Controlador, ActionListener{

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

    public ControladorPagoCuota(VentanaPrincipal vista) {
        this.vista = vista;
    }

    @Override
    public boolean comprobarDatos(Identificable dato) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean anadirPagoCuota (String[] datos, Voluntario v) {
        
        if (!testDatos(datos))
            return false;
            
        Socio socio;
        try {   
            socio = SocioJDBC.getInstance().obtenerSocio(v.getNIF());
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPagoCuota.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        Cuota cuota;
        try {
            cuota = SocioJDBC.getInstance().obtenerCuotaActiva(socio);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPagoCuota.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        try {
            CuotaJDBC.getInstance().actualizarUltimoPago(cuota);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPagoCuota.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        PagoCuota pc = new PagoCuota();
        pc.setConcepto(datos[PagoCuota.CONCEPTO_ID]);
        pc.setFecha(Date.valueOf(datos[PagoCuota.CONCEPTO_ID]));
        pc.setImporte(Integer.parseInt(datos[PagoCuota.IMPORTE_ID]));
        pc.setOIDVoluntario((v.getOID().intValue()));
        pc.setOIDSocio(socio.getOIDSocio());
        
        
        try {
            PagoCuotaJDBC.getInstance().añadirPagoCuota(pc);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPagoCuota.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    
    public boolean eliminarPagoCuota (PagoCuota pc) {
        Socio s = new Socio();
        s.setOIDSocio(pc.getOIDSocio());
        Cuota c;
        try {
            c = SocioJDBC.getInstance().obtenerCuotaActiva(s);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPagoCuota.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        try {
            boolean exito = CuotaJDBC.getInstance().atrasarUltimoPago(c);
            if(!exito) 
                return false;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPagoCuota.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        try {
            boolean exito = PagoCuotaJDBC.getInstance().eliminarPagoCuota(pc);
            if(!exito) 
                return false;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPagoCuota.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }
    /*
    public ArrayList<Movimiento> historialPagosCuotas (Socio s) {
        
    }*/
    
    private boolean testDatos (String[] datos) {
        // cada campo debe ser not null
        for (int i=0; i<datos.length; i++) {
            if (datos[i].length() < 1)
                return false;
        }
        
        if (!TestDatos.isOnlyDigit(datos[PagoCuota.IMPORTE_ID]))
            return false;
        
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
