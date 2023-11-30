import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Gestor extends Conexion {

	public Gestor(String url, String usuario, String contraseña) {
		super(url, usuario, contraseña);
	}
	
	
//	métodos
	Scanner sc = new Scanner(System.in);
	
	public void insertarGestor() {
		String query = "INSERT INTO gestor(nombre, apellido, edad, email, salario) VALUES(?,?,?,?,1200)";
		
		try {
			Connection conexión = DriverManager.getConnection(url, usuario, contraseña);
			PreparedStatement insertarGestor = conexión.prepareStatement(query);
			
			System.out.println("Nombre:");
        	insertarGestor.setString(1,sc.next());
    		
    		System.out.println("Apellido:");
    		insertarGestor.setString(2,sc.next());
    		
    		System.out.println("Edad:");
    		insertarGestor.setInt(3,sc.nextInt());
    		
    		System.out.println("Email:");
    		insertarGestor.setString(4,sc.next());
    		
    		if(insertarGestor.executeUpdate() !=1) {
				throw new SQLException("Error en la inserción");
			} else {
				System.out.println("Gestor añadido correctamente");
			}
			
		} catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
}
	
	

