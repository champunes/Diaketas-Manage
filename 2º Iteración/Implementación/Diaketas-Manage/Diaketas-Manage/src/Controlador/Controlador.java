/**
 ** NOMBRE CLASE: 
 **	  Controlador.java
 **
 ** DESCRIPCION:
 **        Interfaz que implementan todos los controladores
 **       
 **
 ** DESARROLLADO POR:
 *          José Ángel González Molina (JGM)
 **        
 **
 ** SUPERVISADO POR:
 **          
 **
 ** HISTORIA:
 ** 	000 - Mar  17, 2012 - JGM - Creacion
 *      
 *      
 **
 ** NOTAS:
 **   
 **
 */

package Controlador;

import Modelo.Identificable;

public interface Controlador {

	public boolean comprobarDatos(Identificable dato);
	
}
