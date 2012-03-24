/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jobero
 */
public class Movimiento {
    
    private String concepto;
    private Date fecha;
    private float importe;
    //Puede ser G para gasto o I para ingreso
    private char tipo;
    
    private ArrayList<Ayuda> ayudasAsociadas;
    private Asociacion asociacionQueGenera;

    /**
     * Constructor por defecto
     */
    public Movimiento() {
    }

    /**
     * 
     * @return
     */
    public Asociacion getAsociacionQueGenera() {
        return asociacionQueGenera;
    }

    /**
     * 
     * @param asociacionQueGenera
     */
    public void setAsociacionQueGenera(Asociacion asociacionQueGenera) {
        this.asociacionQueGenera = asociacionQueGenera;
    }

    /**
     * 
     * @return
     */
    public ArrayList<Ayuda> getAyudasAsociadas() {
        return ayudasAsociadas;
    }

    /**
     * 
     * @param ayudasAsociadas
     */
    public void setAyudasAsociadas(ArrayList<Ayuda> ayudasAsociadas) {
        this.ayudasAsociadas = ayudasAsociadas;
    }

    /**
     * 
     * @return
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * 
     * @param concepto
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * 
     * @return
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * 
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * 
     * @return
     */
    public float getImporte() {
        return importe;
    }

    /**
     * 
     * @param importe
     */
    public void setImporte(float importe) {
        this.importe = importe;
    }

    /**
     * 
     * @return
     */
    public char getTipo() {
        return tipo;
    }

    /**
     * 
     * @param tipo
     */
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    
}
