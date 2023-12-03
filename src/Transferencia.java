import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Transferencia extends Conexion implements Metodos {

	public Transferencia() {
		// TODO Auto-generated constructor stub
	}
	
//	métodos
	Scanner sc = new Scanner(System.in);

	@Override
	public void insertar() throws SQLException {
		// TODO Auto-generated method stub
		if(existeId(1)) {
//		El id de remitente y destinatario por defecto son 1 porque tienen que estar ligado a un cliente existente
		String query = "INSERT INTO transferencia(id_remitente, id_destinatario, remitente, destinatario, fecha, cantidad) VALUES(1,1,?,?,?,?)";
		
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
		PreparedStatement instruccion = conexion.prepareStatement(query);
		
		System.out.println("Remitente:");
		instruccion.setString(1,sc.next());
		
		System.out.println("Destinatario:");
		instruccion.setString(2,sc.next());
		
		System.out.println("Fecha (en formato yyyy-mm-dd):");
		instruccion.setDate(3, recibirFecha());
		
		System.out.println("Cantidad:");
		instruccion.setDouble(4,sc.nextDouble());
		
		if(instruccion.executeUpdate() !=1) {
			throw new SQLException("Error en la inserción");
		} else {
			System.out.println("Transferencia enviada correctamente");
		}
		instruccion.close();
		} else {
			System.out.println("No existe un cliente con id = 1. La inserción no se puede realizar.");
		}
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
		String query = "SELECT * FROM transferencia WHERE id = ?";
		
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
		PreparedStatement instruccion = conexion.prepareStatement(query);
		System.out.println("Id:");
		instruccion.setInt(1, sc.nextInt());
		
		ResultSet resultado = instruccion.executeQuery();
		if(resultado.next()) {
			System.out.println("Transferencia " + resultado.getInt("id"));
			
			System.out.println("Remitente: " + resultado.getString("remitente") + " con id: " + resultado.getInt("id_remitente"));
			
			System.out.println("Destinatario: " + resultado.getString("destinatario") + " con id: " + resultado.getInt("id_destinatario"));
			
			System.out.println("Fecha: " + resultado.getDate("fecha"));
			
			System.out.println("Cantidad: " + resultado.getDouble("cantidad") + "€");
		} else {
			System.out.println("No existe ningúna transferencia con ese Id.");
		}
		resultado.close();
		instruccion.close();
	}

	@Override
	public void obtenerTodos() throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM transferencia";
		
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
		Statement instruccion = conexion.createStatement();	
		
		ResultSet resultado = instruccion.executeQuery(query);
		
		if(!comprobarTabla()) {
			System.out.println("No existe ningúna transferencia.");
		} else {
			System.out.println("Listado de Transferencias: ");
			
			while(resultado.next()) {
				System.out.println("Transferencia " + resultado.getInt("id"));
				
				System.out.println("Remitente: " + resultado.getString("remitente") + " con id: " + resultado.getInt("id_remitente"));
				
				System.out.println("Destinatario: " + resultado.getString("destinatario") + " con id: " + resultado.getInt("id_destinatario"));
				
				System.out.println("Fecha: " + resultado.getDate("fecha"));
				
				System.out.println("Cantidad: " + resultado.getDouble("cantidad") + "€");
				
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
		 String query = "SELECT 1 FROM transferencia LIMIT 1";
	      
	    	Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
	    		
	        PreparedStatement instruccion = conexion.prepareStatement(query);
	        ResultSet resultado = instruccion.executeQuery();
	        return resultado.next();
	        
	}

}
