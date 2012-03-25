/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import Modelo.Ayuda;
import java.util.ArrayList;

/**
 *
 * @author Jobero
 */
public class AyudaJDBC {
    
    private AyudaJDBC instancia;
    
    private AyudaJDBC(){
        
        instancia=null;
        
    }
    
    public AyudaJDBC getInstance(){

        if(instancia == null)
             instancia = new AyudaJDBC();
        return instancia;

    }
    
    public ArrayList<Ayuda> buscarAyudas(){
    
        ArrayList<Ayuda> lista_ayudas = new ArrayList<Ayuda>();
        
        
        return lista_ayudas;
    }
    
    public boolean comprobarTipoAyuda(){
        
        return true;
    }
    
    
    
    
    
}
