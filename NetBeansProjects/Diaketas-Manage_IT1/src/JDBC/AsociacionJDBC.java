/**
 ** NOMBRE CLASE: 
 **	  AsociacionJDBC.java
 **
 ** DESCRIPCION:
 **       Abstracción JDBC de Asociación
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
public class AsociacionJDBC {
    
    private AsociacionJDBC instance;
    
    private AsociacionJDBC(){
        
        
    }
    
    public AsociacionJDBC getInstance(){
        
        return this;
    }
    
}
