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
public class Beneficiario extends Persona {
    
    
    private String estadoCivil;
    private String nacionalidad;
    private int nivelDeEstudio;
    private String observaciones;
    private String ocupacion;
    private String profesion;
    private String situacionEconomica;
    private String vivienda;
    private float viviendaAlquiler;
    private String viviendaObservaciones;
    
    private ArrayList<Familiar>  familiares;
    private ArrayList<Ayuda> ayudasPrestadas;

    /**
     * Constructor por defecto
     */
    public Beneficiario() {
    }

    /**
     * 
     * @return
     */
    public ArrayList<Ayuda> getAyudasPrestadas() {
        return ayudasPrestadas;
    }

    /**
     * 
     * @param ayudasPrestadas
     */
    public void setAyudasPrestadas(ArrayList<Ayuda> ayudasPrestadas) {
        this.ayudasPrestadas = ayudasPrestadas;
    }

    /**
     * 
     * @return
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * 
     * @param estadoCivil
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * 
     * @return
     */
    public ArrayList<Familiar> getFamiliares() {
        return familiares;
    }

    /**
     * 
     * @param familiares
     */
    public void setFamiliares(ArrayList<Familiar> familiares) {
        this.familiares = familiares;
    }

    /**
     * 
     * @return
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * 
     * @param nacionalidad
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * 
     * @return
     */
    public int getNivelDeEstudio() {
        return nivelDeEstudio;
    }

    /**
     * 
     * @param nivelDeEstudio
     */
    public void setNivelDeEstudio(int nivelDeEstudio) {
        this.nivelDeEstudio = nivelDeEstudio;
    }

    /**
     * 
     * @return
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * 
     * @param observaciones
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * 
     * @return
     */
    public String getOcupacion() {
        return ocupacion;
    }

    /**
     * 
     * @param ocupacion
     */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    /**
     * 
     * @return
     */
    public String getProfesion() {
        return profesion;
    }

    /**
     * 
     * @param profesion
     */
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    /**
     * 
     * @return
     */
    public String getSituacionEconomica() {
        return situacionEconomica;
    }

    /**
     * 
     * @param situacionEconomica
     */
    public void setSituacionEconomica(String situacionEconomica) {
        this.situacionEconomica = situacionEconomica;
    }

    /**
     * 
     * @return
     */
    public String getVivienda() {
        return vivienda;
    }

    /**
     * 
     * @param vivienda
     */
    public void setVivienda(String vivienda) {
        this.vivienda = vivienda;
    }

    /**
     * 
     * @return
     */
    public float getViviendaAlquiler() {
        return viviendaAlquiler;
    }

    /**
     * 
     * @param viviendaAlquiler
     */
    public void setViviendaAlquiler(float viviendaAlquiler) {
        this.viviendaAlquiler = viviendaAlquiler;
    }

    /**
     * 
     * @return
     */
    public String getViviendaObservaciones() {
        return viviendaObservaciones;
    }

    /**
     * 
     * @param viviendaObservaciones
     */
    public void setViviendaObservaciones(String viviendaObservaciones) {
        this.viviendaObservaciones = viviendaObservaciones;
    }
  
    
}
