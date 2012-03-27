/**
 ** NOMBRE CLASE: 
 **	  TipoAyudaJDBC.java
 **
 ** DESCRIPCION:
 **       Abstracción JDBC de TipoAyuda
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
public class TipoAyudaJDBC {
    
    private TipoAyudaJDBC instancia;
    
    private TipoAyudaJDBC(){
        
    }
    
    public TipoAyudaJDBC getInstance(){
        
        return this;
    }
}
