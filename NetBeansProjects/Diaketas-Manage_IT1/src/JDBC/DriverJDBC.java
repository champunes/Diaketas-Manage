/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jobero
 */
public class DriverJDBC {
    
    
    private Connection conex;
    private String hostBD;
    private DriverJDBC instancia;
    private String nombreBD;
    private String password;
    private String usuarioBD;
    private Statement st;
    
    
    
    private DriverJDBC(){
        
        
    }
    
    private boolean conectar() throws ClassNotFoundException, SQLException{
        
        Class.forName("com.mysql.jdbc.Driver");
	conex = DriverManager.getConnection("jdbc:mysql://127.0.0.1/diaketas", "root", "1234");
		
        return true;
    }
    
    private boolean desconectar(){
        
        
        return true;
    }
    
    public boolean actualizar(String cadena){
        
        return true;
    }
    
    public boolean eliminar(String cadena){
        
        return true;
    }
    
    public DriverJDBC getInstance(){
        
        return this.instancia;
    }
    
    public boolean insertar(String cadena){
        
        return true;
    }
    
    public ResultSet seleccionar (String cadena){
        
        
    }
}

