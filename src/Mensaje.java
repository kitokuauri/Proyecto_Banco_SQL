import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Mensaje extends Conexion implements Metodos{

	public Mensaje() {
		// TODO Auto-generated constructor stub
	}
	
//	métodos
	Scanner sc = new Scanner(System.in);

	@Override
	public void insertar() throws SQLException {
		// TODO Auto-generated method stub
		String query = "INSERT INTO mensaje(id_remitente, id_destinatario, remitente, destinatario, fecha, mensaje) VALUES(?,?,?,?,?,?)";
		
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
		PreparedStatement instruccion = conexion.prepareStatement(query);
		
		System.out.println("Remitente:");
		instruccion.setString(1,sc.next());
		
		System.out.println("Id Remitente:");
		
		System.out.println("Destinatario:");
		instruccion.setString(2,sc.next());
		
		System.out.println("Id Destinatario:");
		
		System.out.println("Fecha (en formato yyyy-mm-dd):");
		instruccion.setDate(3, recibirFecha());
		
		System.out.println("Mensaje:");
		instruccion.setString(4,sc.next());
		
		if(instruccion.executeUpdate() !=1) {
			throw new SQLException("Error en la inserción");
		} else {
			System.out.println("Mensaje enviado correctamente");
		}
		instruccion.close();
	}
	
	public boolean existeId(int id) throws SQLException {
	    String query = "SELECT COUNT(*) FROM cliente WHERE id = 1";
	      
    	Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
    		
        PreparedStatement instruccion = conexion.prepareStatement(query);
        ResultSet resultado = instruccion.executeQuery();
        		
        if (resultado.next()) {
            int count = resultado.getInt(1);
            instruccion.close();
            return count > 0;
	    } else {
	    	return false;
	    }
        
	}

	@Override
	public void obtener() throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM mensaje WHERE id = ?";
		
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
		PreparedStatement instruccion = conexion.prepareStatement(query);
		System.out.println("Id:");
		instruccion.setInt(1, sc.nextInt());
		
		ResultSet resultado = instruccion.executeQuery();
		if(resultado.next()) {
			System.out.println("Mensaje " + resultado.getInt("id"));
			
			System.out.println("Remitente: " + resultado.getString("remitente") + " con id: " + resultado.getInt("id_remitente"));
			
			System.out.println("Destinatario: " + resultado.getString("destinatario") + " con id: " + resultado.getInt("id_destinatario"));
			
			System.out.println("Fecha: " + resultado.getDate("fecha"));
			
			System.out.println("Mensaje: " + resultado.getString("mensaje"));
		} else {
			System.out.println("No existe ningún mensaje con ese Id.");
		}
		resultado.close();
		instruccion.close();
	}

	@Override
	public void obtenerTodos() throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM mensaje";
		
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
		Statement instruccion = conexion.createStatement();	
		
		ResultSet resultado = instruccion.executeQuery(query);
		
		if(!comprobarTabla()) {
			System.out.println("No existe ningún mensaje.");
		} else {
			System.out.println("Listado de Mensajes: ");
			
			while(resultado.next()) {
				System.out.println("Mensaje " + resultado.getInt("id"));
				
				System.out.println("Remitente: " + resultado.getString("remitente") + " con id: " + resultado.getInt("id_remitente"));
				
				System.out.println("Destinatario: " + resultado.getString("destinatario") + " con id: " + resultado.getInt("id_destinatario"));
				
				System.out.println("Fecha: " + resultado.getDate("fecha"));
				
				System.out.println("Mensaje: " + resultado.getString("mensaje"));
				
				System.out.println("...");
			}
		}
		resultado.close();
		instruccion.close();
	}

	@Override
	public void actualizar() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean comprobarTabla() throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT 1 FROM mensaje LIMIT 1";
	      
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
  		
		PreparedStatement instruccion = conexion.prepareStatement(query);
		ResultSet resultado = instruccion.executeQuery();
		return resultado.next();
      
	}

}
