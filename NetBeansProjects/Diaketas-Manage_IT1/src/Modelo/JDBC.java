
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Jose Angel Gonzalez Molina
 */
public class JDBC {

	public JDBC() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/diaketas", "root", "root");
		
		Statement st = conexion.createStatement();
		
		//Borrar una tabla
		st.executeUpdate("DROP TABLE socio");
		
		//Crear una tabla
		st.executeUpdate("CREATE TABLE socio (id INT AUTO_INCREMENT, PRIMARY KEY (id), nombre VARCHAR(20), apellidos VARCHAR(30), telefono VARCHAR(20) )");
		
		//Insertar datos
		String nombres[] = {"Juan", "Pedro", "Antonio"};
		String apellidos[] = {"Gomez", "Lopez", "Alvarez"};
		String telefonos[] = {"123", "456", "789"};
		
		for(int i=0;i<nombres.length;i++){
			st.executeUpdate("INSERT INTO socio (nombre,apellidos,telefono) VALUES ('"+nombres[i]+"','"+apellidos[i]+"','"+telefonos[i]+"' )");
		}
		
		//Consultar datos
		ResultSet rs = st.executeQuery("SELECT * FROM socio");
		while (rs.next()){
			System.out.println("nombre = "+rs.getObject("nombre")+
					", apellidos = "+rs.getObject("apellidos")+
					", telefono = "+rs.getObject("telefono"));
		}
		//IMPORTANTES LOS CLOSE
		rs.close();
		
		//Updatear datos. Cambiar el telefono de "Juan"
		//Buscamos la tupla y obtenemos el id
		rs = st.executeQuery("SELECT id FROM socio WHERE nombre='Juan'");
		//Para que fuera mas correcto deberíamos comprobar si rs.next devuelve algo (a lo mejor nadie se llama Juan)
		rs.next();		
		int id = rs.getInt("id");
		
		st.executeUpdate("UPDATE socio SET telefono='111' WHERE id="+id);
		
		//Borrar datos. Borrar a "Pedro"
		rs = st.executeQuery("SELECT id FROM socio WHERE nombre='Pedro'");
		rs.next();
		id = rs.getInt("id");
		
		st.executeUpdate("DELETE FROM socio WHERE id="+id);
		
		//IMPORTANTES LOS CLOSE
		conexion.close();;
	}
	
}
