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
    
}
