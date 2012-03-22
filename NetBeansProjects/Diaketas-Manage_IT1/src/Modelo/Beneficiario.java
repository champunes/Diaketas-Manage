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
  
    
}
