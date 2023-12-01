import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Gestor extends Conexion {

	public Gestor(String url, String usuario, String contraseña) {
		super(url, usuario, contraseña);
	}
	
	
//	métodos
	Scanner sc = new Scanner(System.in);
	
	public void insertarGestor() throws SQLException {
		String query = "INSERT INTO gestor(nombre, apellido, edad, email, salario) VALUES(?,?,?,?,1200)";
		
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
		PreparedStatement instruccion = conexion.prepareStatement(query);
		
		System.out.println("Nombre:");
		instruccion.setString(1,sc.next());
		
		System.out.println("Apellido:");
		instruccion.setString(2,sc.next());
		
		System.out.println("Edad:");
		instruccion.setInt(3,sc.nextInt());
		
		System.out.println("Email:");
		instruccion.setString(4,sc.next());
		
		if(instruccion.executeUpdate() !=1) {
			throw new SQLException("Error en la inserción");
		} else {
			System.out.println("Gestor añadido correctamente");
		}
		instruccion.close();
	}
	
	public void insertarGestorAleatorio() throws SQLException {
		String query = "INSERT INTO gestor(nombre, apellido, edad, email, salario) VALUES(?,?,?,?,1200)";
		
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
		PreparedStatement instruccion = conexion.prepareStatement(query);
		instruccion.setString(1, stringAleatorio01);
		instruccion.setString(2, stringAleatorio02);
		instruccion.setInt(3, intAleatorio01);
		instruccion.setString(4, stringAleatorio03);
		if(instruccion.executeUpdate() !=1) {
			throw new SQLException("Error en la inserción");
		} else {
			System.out.println("Gestor añadido correctamente");
		}
		instruccion.close();
	}
	public void insertarVariosGestoresAl() throws SQLException {
		for(int i=0;i<4;i++) {
            insertarGestorAleatorio();
        	}
	}
	
	public void obtenerGestor() throws SQLException {
		String query = "SELECT * FROM gestor WHERE id = ?";
		
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
		PreparedStatement instruccion = conexion.prepareStatement(query);
		System.out.println("Id:");
		instruccion.setInt(1, sc.nextInt());
		
		ResultSet resultado = instruccion.executeQuery();
		if(resultado.next()) {
			System.out.println("Gestor " + resultado.getInt("id"));
			
			System.out.println("Nombre y apellidos: " + resultado.getString("nombre") + " " + resultado.getString("apellido"));
			
			System.out.println("Edad: " + resultado.getInt("edad") + " años");
			
			System.out.println("Email: " + resultado.getString("email"));
			
			System.out.println("Salario: " + resultado.getInt("salario") + "€");
		} else {
			System.out.println("No existe ningún gestor con ese Id.");
		}
		resultado.close();
		instruccion.close();
	}
	
	public void obtenerTodosGestores() throws SQLException {
		String query = "SELECT * FROM gestor";
		
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
		Statement instruccion = conexion.createStatement();	
		
		ResultSet resultado = instruccion.executeQuery(query);
		
//		comprueba si el resultado está antes de la primera fila (si lo está, no hay nada en la tabla)
		if(!resultado.isBeforeFirst()) {
			System.out.println("No existe ningún gestor.");
		} else {
			System.out.println("Listado de Gestores: ");
			
			while(resultado.next()) {
				System.out.println("Gestor " + resultado.getInt("id"));
				
				System.out.println("Nombre y apellidos: " + resultado.getString("nombre") + " " + resultado.getString("apellido"));
				
				System.out.println("Edad: " + resultado.getInt("edad") + " años");
				
				System.out.println("Email: " + resultado.getString("email"));
				
				System.out.println("Salario: " + resultado.getInt("salario") + "€");
				
				System.out.println("...");
			}
		}
		resultado.close();
		instruccion.close();
	}
	
	
	public void actualizarGestor() throws SQLException {
		String query = "UPDATE gestor SET nombre=?, apellido=?, edad=?, email=? WHERE id=?";
		
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
		PreparedStatement instruccion = conexion.prepareStatement(query);
		System.out.println("¿Id?");
		instruccion.setInt(5, sc.nextInt());
		
		System.out.println("Nombre:");
		instruccion.setString(1,sc.next());
		
		System.out.println("Apellido:");
		instruccion.setString(2,sc.next());
		
		System.out.println("Edad:");
		instruccion.setInt(3,sc.nextInt());
		
		System.out.println("Email:");
		instruccion.setString(4,sc.next());
		
		if(instruccion.executeUpdate() !=1) {
			throw new SQLException("Error en la actualización");
		} else {
			System.out.println("Gestor actualizado correctamente");
		}
		instruccion.close();
	}
	
	public void eliminarGestor() throws SQLException {
		String query = "DELETE FROM gestor WHERE id=?";
		
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
		PreparedStatement instruccion = conexion.prepareStatement(query);
		System.out.println("¿Id?");
		instruccion.setInt(1, sc.nextInt());
		
		if(instruccion.executeUpdate() !=1) {
			throw new SQLException("Error en la eliminación");
		} else {
			System.out.println("Gestor eliminado correctamente");
		}
		instruccion.close();
	}
	
	
}
	
	

