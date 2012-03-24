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
public class Familiar {
    
    private String apellidos;
    private Date fechaNacimiento;
    private String NIF;
    private String nombre;
    private String ocupacion;
    private String parentesco;
    
    private ArrayList<Beneficiario> beneficiario;
    
    public void set_apellidos(String apellidos){
        
        this.apellidos=apellidos;
    }
    
    public void set_fechaNacimiento(Date fechaNacimiento){
        
        this.fechaNacimiento=fechaNacimiento; 
    }
    
    public void set_NIF(String NIF){
        
        this.NIF=NIF;
    }
    
    public void set_nombre(String nombre){
        
        this.nombre=nombre;
        
    }
    
    public void set_ocupacion(String ocupacion){
        
        this.ocupacion=ocupacion;
        
    }
    
    public void set_parentesco(String parentesco){
        
        this.parentesco=parentesco;
        
    }
    
    public String get_apellidos(){
        
        return apellidos;
    }
    
     public Date get_fechaNacimiento(){
        
        return fechaNacimiento;
    }
    
     public String get_NIF(){
        
        return NIF;
    }
    
     public String get_nombre(){
        
        return nombre;
    }
    
     public String get_ocupacion(){
        
        return ocupacion;
    }
    
     public String get_parentesco(){
        
        return parentesco;
    }
}
