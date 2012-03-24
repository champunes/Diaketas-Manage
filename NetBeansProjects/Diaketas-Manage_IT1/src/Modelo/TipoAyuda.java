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
public class TipoAyuda {
    
    private String descripcion;
    private boolean monetaria;
    private String OID;
    private String titulo;
    
    private ArrayList<Ayuda> ayudas;

    /**
     * Constructor por defecto
     */
    public TipoAyuda() {
    }

    /**
     * 
     * @return
     */
    public String getOID() {
        return OID;
    }

    /**
     * 
     * @param OID
     */
    public void setOID(String OID) {
        this.OID = OID;
    }

    /**
     * 
     * @return
     */
    public ArrayList<Ayuda> getAyudas() {
        return ayudas;
    }

    /**
     * 
     * @param ayudas
     */
    public void setAyudas(ArrayList<Ayuda> ayudas) {
        this.ayudas = ayudas;
    }

    /**
     * 
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * 
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * 
     * @return
     */
    public boolean isMonetaria() {
        return monetaria;
    }

    /**
     * 
     * @param monetaria
     */
    public void setMonetaria(boolean monetaria) {
        this.monetaria = monetaria;
    }

    /**
     * 
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * 
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
