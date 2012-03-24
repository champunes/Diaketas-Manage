/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.*;

/**
 *
 * @author Jobero
 */
public class DriverJDBC {
    
    
    private Connection conex;
    private String hostBD;
    private static DriverJDBC instancia;
    private String nombreBD;
    private String password;
    private String usuarioBD;
    private Statement statement;
    private ResultSet tabla;
    
    
    
    //Falta mirar bien los close!!
    
    private DriverJDBC(){
        
        instancia = null;
        conex = null;
        tabla = null;
        statement = null;
        
        
        
    }
    
    private boolean conectar() throws ClassNotFoundException, SQLException{
        
        Class.forName("com.mysql.jdbc.Driver");
	conex = DriverManager.getConnection("jdbc:mysql://127.0.0.1/diaketas", "root", "1234");
		
        return true;
    }
    
    private boolean desconectar() throws SQLException{
        
        conex.close();
        
        return true;
    }
    
    public boolean actualizar(String sentencia_busqueda, String sentencia_actualizacion) throws SQLException{
        
        tabla = statement.executeQuery(sentencia_busqueda);
	//Para que fuera mas correcto deberíamos comprobar si rs.next devuelve algo (a lo mejor nadie se llama Juan)
	if( tabla.next() == false)
            return false;
		
	//statement.executeUpdate("UPDATE socio SET telefono='111' WHERE id="+id);
        statement.executeUpdate(sentencia_actualizacion);
        
        return true;
    }
    
    public boolean eliminar(String sentencia_busqueda, String sentencia_eliminacion) throws SQLException{
        
        actualizar(sentencia_busqueda, sentencia_eliminacion);
        
        return true;
    }
    
    public static DriverJDBC getInstance(){
        
        if(instancia == null)
		instancia = new DriverJDBC();
	return instancia;
    }
    
    public boolean insertar(String sentencia) throws SQLException{
        
        statement.executeUpdate(sentencia);
        return true;
    }
    
    public ResultSet seleccionar (String cadena) throws SQLException{
        
        return statement.executeQuery(cadena);
    }
    
    
}

