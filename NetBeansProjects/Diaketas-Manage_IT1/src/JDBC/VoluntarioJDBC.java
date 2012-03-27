/**
 ** NOMBRE CLASE: 
 **	  VoluntarioJDBC.java
 **
 ** DESCRIPCION:
 **       Abstracción JDBC de Voluntario
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
 *      
 **
 ** NOTAS:
 **   
 **
 */
package JDBC;

/**
 *
 * @author Jobero
 */
public class VoluntarioJDBC {
    
    private VoluntarioJDBC instancia;
    
    private VoluntarioJDBC(){
        
    }
    
    public VoluntarioJDBC getInstance(){
        
        return this;
    }
}
