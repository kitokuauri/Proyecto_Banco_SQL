import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Gestor extends Conexion {

	public Gestor(String url, String usuario, String contraseña) {
		super(url, usuario, contraseña);
	}
	
//	atributos
	Random aleatorio = new Random();
	
	String stringAleatorio01 = stringAleatorio();
	String stringAleatorio02 = stringAleatorio();
	String stringAleatorio03 = stringAleatorio();
	
	int intAleatorio01 = aleatorio.nextInt(100);
	int intAleatorio02 = aleatorio.nextInt(3000);
	
	
//	métodos
	Scanner sc = new Scanner(System.in);
	
	public void insertarGestor() {
		String query = "INSERT INTO gestor(nombre, apellido, edad, email, salario) VALUES(?,?,?,?,1200)";
		
		try {
			Connection conexión = DriverManager.getConnection(url, usuario, contraseña);
			PreparedStatement instruccion = conexión.prepareStatement(query);
			
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
				System.out.println("Gestor añadido correctamente.");
			}
			
		} catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void insertarGestoresAleatorios() {
		String query = "INSERT INTO gestor(nombre, apellido, edad, email, salario) VALUES(?,?,?,?,?)";
		
		try {
			Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
			PreparedStatement instruccion = conexion.prepareStatement(query);
			
			instruccion.setString(1,stringAleatorio01);
    		instruccion.setString(2,stringAleatorio02);
    		instruccion.setInt(3,intAleatorio01);
    		instruccion.setString(4,stringAleatorio03);
    		instruccion.setInt(3,intAleatorio01);
    	
    		if(instruccion.executeUpdate() !=1) {
				throw new SQLException("Error en la inserción");
			} else {
				System.out.println("Gestor añadido correctamente.");
			}
			
		} catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void eliminarGestor() {
		String query = "DELETE FROM gestor WHERE id = (?)";
		try {
			Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
			PreparedStatement instruccion = conexion.prepareStatement(query);
			
			System.out.println("Id:");
			instruccion.setInt(1, sc.nextInt());
			if(instruccion.executeUpdate() !=1) {
				throw new SQLException("Error en la inserción");
			} else {
				System.out.println("Gestores añadidos correctamente.");
			}
		} catch (SQLException e) {
            e.printStackTrace();
        }
		
		
	}
	
	
	
	
	public static String stringAleatorio() {
		 
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    return generatedString;
	}
	
}
	
	

