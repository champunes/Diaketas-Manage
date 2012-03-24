/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Jobero
 */
 public class Voluntario extends Persona {
    
    private String password;
    
    private ArrayList<Modificacion> modificaciones;
    private ArrayList<Ayuda> ayudasDadas;

    /**
     * Constructor por defecto
     */
    public Voluntario() {
    }

    /**
     * 
     * @return
     */
    public ArrayList<Ayuda> getAyudasDadas() {
        return ayudasDadas;
    }

    /**
     * 
     * @param ayudasDadas
     */
    public void setAyudasDadas(ArrayList<Ayuda> ayudasDadas) {
        this.ayudasDadas = ayudasDadas;
    }

    /**
     * 
     * @return
     */
    public ArrayList<Modificacion> getModificaciones() {
        return modificaciones;
    }

    /**
     * 
     * @param modificaciones
     */
    public void setModificaciones(ArrayList<Modificacion> modificaciones) {
        this.modificaciones = modificaciones;
    }

    /**
     * 
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
