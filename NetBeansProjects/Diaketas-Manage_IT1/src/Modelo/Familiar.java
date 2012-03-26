/**
 ** NOMBRE CLASE: 
 **	  Familiar.java
 **
 ** DESCRIPCION:
 **       Representación de un familiar
 **       
 **
 ** DESARROLLADO POR:
 *        Francisco José Beltrán Rodriguez (FBR)
 *	   
 **        
 ** SUPERVISADO POR:
 **          
 **
 ** HISTORIA:
 ** 	000 - Mar 24, 2012 - FBR - Creacion
 **     001 - COMPLETA POR AQUI
 **     002 - Mar 26, 2012 - FBR - Cambiado tipo de dato de fechaNacimiento a String, (tiene que ser del formato YYYY-MM-DD)
 *      
 **
 ** NOTAS:
 **   
 **
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
    private String fechaNacimiento;
    private String NIF;
    private String nombre;
    private String ocupacion;
    private String parentesco;
    
    private ArrayList<Beneficiario> beneficiario;

    /**
     * Constructor por defecto
     */
    public Familiar() {
    }

    /**
     * 
     * @return
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * 
     * @param NIF
     */
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    /**
     * 
     * @return
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * 
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * 
     * @return
     */
    public ArrayList<Beneficiario> getBeneficiario() {
        return beneficiario;
    }

    /**
     * 
     * @param beneficiario
     */
    public void setBeneficiario(ArrayList<Beneficiario> beneficiario) {
        this.beneficiario = beneficiario;
    }

    /**
     * 
     * @return
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * 
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * 
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public String getParentesco() {
        return parentesco;
    }

    /**
     * 
     * @param parentesco
     */
    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
    
    
   
    

}
