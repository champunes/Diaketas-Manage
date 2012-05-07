/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import JDBC.SocioJDBC;
import Modelo.Identificable;
import Modelo.Socio;
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
 **	  ControladorSocio
 **
 ** DESCRIPCION:
 **       Controlador del panel de coladores de typo socio
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
 ** 	000 - 1 mai 2012 - RC - Creacion y estructura
 ** 	001 - 4 mai 2012 - RC - Metodos con JDBC
 *      002 - 5 mai 2012 - RC - comproba datos
 **
 ** NOTAS:
 **   
 **
 */
public class ControladorSocio implements Controlador, ActionListener{

    /**
     * PATRON DE DISEÑO SINGLETON
     */
    private static ControladorSocio instancia = null;

    public static ControladorSocio getInstance(VentanaPrincipal pvista) {

        if (instancia == null) {
            instancia = new ControladorSocio(pvista);
        }
        return instancia;

    }
    
    private VentanaPrincipal vista;

    public ControladorSocio(VentanaPrincipal vista) {
        this.vista = vista;
    }
    
    
    @Override
    public boolean comprobarDatos(Identificable dato) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean anadirSocio(String[] datos) {
        if (!testDatos(datos))
            return false;
        
        Socio socio = new Socio();
        socio.setUsuario(datos[Socio.USUARIO_ID]);
        socio.setContrasena(ControladorVoluntarios.genContrasena());
        
        socio.setDNI(datos[Socio.DNI_ID]);
        socio.setNombre(datos[Socio.NOMBRE_ID]);
        socio.setApellidos(datos[Socio.APELLIDOS_ID]);
        socio.setSexo(datos[Socio.SEXO_ID].charAt(0));
        socio.setFechaDeNacimiento(Date.valueOf(datos[Socio.FECHA_DE_NACIMIENTO_ID]));
            
        socio.setEmail(datos[Socio.EMAIL_ID]);
        socio.setDireccion(datos[Socio.DIRECCION_ID]);
        socio.setLocalidad(datos[Socio.LOCALIDAD_ID]);
        socio.setProvincia(datos[Socio.PROVINCIA_ID]);
        socio.setCP(datos[Socio.CP_ID]);
        
        boolean exito;
        try {
             exito = SocioJDBC.getInstance().añadirSocio(socio);
        } catch (SQLException ex) {
            exito = false;
            Logger.getLogger(ControladorSocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return exito;
    }
    
    public Socio obtenerSocio (String DNI) {
        Socio socio = null;
        try {
            socio = SocioJDBC.getInstance().obtenerSocio(DNI);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorSocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return socio;
    }
    
    public boolean modificarSocio (String[] datos) {
        if (!testDatos(datos))
            return false;
        
        Socio socio = new Socio();
        socio.setUsuario(datos[Socio.USUARIO_ID]);
        socio.setContrasena(ControladorVoluntarios.genContrasena());
        
        socio.setDNI(datos[Socio.DNI_ID]);
        socio.setNombre(datos[Socio.NOMBRE_ID]);
        socio.setApellidos(datos[Socio.APELLIDOS_ID]);
        socio.setSexo(datos[Socio.SEXO_ID].charAt(0));
        socio.setFechaDeNacimiento(Date.valueOf(datos[Socio.FECHA_DE_NACIMIENTO_ID]));
            
        socio.setEmail(datos[Socio.EMAIL_ID]);
        socio.setDireccion(datos[Socio.DIRECCION_ID]);
        socio.setLocalidad(datos[Socio.LOCALIDAD_ID]);
        socio.setProvincia(datos[Socio.PROVINCIA_ID]);
        socio.setCP(datos[Socio.CP_ID]);
        
        boolean exito;
        try {
             exito = SocioJDBC.getInstance().modificarDatosSocio(socio);
        } catch (SQLException ex) {
            exito = false;
            Logger.getLogger(ControladorSocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return exito;
    }
    
    public boolean eliminarSocio (Socio socio) {
        try {
            return SocioJDBC.getInstance().eliminarSocio(socio);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorSocio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public ArrayList<Socio> buscarSocio (String tipoBusqueta, String valor) {
        ArrayList<Socio> socios;
        try {
            socios = SocioJDBC.getInstance().obtenerListadoSocios(tipoBusqueta, valor);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorC_Persona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return socios;
    }
    
    // proba los datos pero no sabemos cual son los datos que no son correcto
    private boolean testDatos (String[] datos) {
        // cada campo debe ser not null
        for (int i=0; i<datos.length; i++) {
            if (datos[i].length() < 1)
                return false;
        }
        
        if (!TestDatos.isDNI(datos[Socio.DNI_ID]))
            return false;
        
        if (!TestDatos.isCodigoPostal(datos[Socio.CP_ID]))
            return false;
        
        if (!TestDatos.isEmail(datos[Socio.EMAIL_ID]))
            return false;
        
        if (!TestDatos.isOnlyLetter(datos[Socio.NOMBRE_ID]))
            return false;
        
        if (!TestDatos.isOnlyLetter(datos[Socio.APELLIDOS_ID]))
            return false;
        
        if (!TestDatos.isOnlyLetter(datos[Socio.DIRECCION_ID]))
            return false;
        
        if (!TestDatos.isOnlyLetter(datos[Socio.LOCALIDAD_ID]))
            return false;
        
        if (!TestDatos.isOnlyLetter(datos[Socio.PROVINCIA_ID]))
            return false;
        
        if (!TestDatos.isOnlyLetterOrDigit(datos[Socio.USUARIO_ID]))
            return false;
        
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
