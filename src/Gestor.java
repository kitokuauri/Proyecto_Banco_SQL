import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.Random;
=======
import java.sql.Statement;
>>>>>>> 0738cf23e22373fa0051b927beb6b1cad645b0c9
import java.util.Scanner;

public class Gestor extends Conexion implements Metodos{

	public Gestor() {
	}
	
<<<<<<< HEAD
//	atributos
	Random aleatorio = new Random();
	
	String stringAleatorio01 = stringAleatorio();
	String stringAleatorio02 = stringAleatorio();
	String stringAleatorio03 = stringAleatorio();
	
	int intAleatorio01 = aleatorio.nextInt(100);
	int intAleatorio02 = aleatorio.nextInt(3000);
	
	
=======
>>>>>>> 0738cf23e22373fa0051b927beb6b1cad645b0c9
//	métodos
	Scanner sc = new Scanner(System.in);
	
	public void insertar() throws SQLException {
		String query = "INSERT INTO gestor(nombre, apellido, edad, email, salario) VALUES(?,?,?,?,1200)";
		
<<<<<<< HEAD
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
	
=======
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
	
	public void insertarAleatorios() throws SQLException {
		String query = "INSERT INTO gestor(nombre, apellido, edad, email, salario) VALUES(?,?,?,?,?)";
		
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
		PreparedStatement instruccion = conexion.prepareStatement(query);
		instruccion.setString(1, stringAleatorio01);
		instruccion.setString(2, stringAleatorio02);
		instruccion.setInt(3, intAleatorio01);
		instruccion.setString(4, stringAleatorio03);
		instruccion.setInt(5, intAleatorio02);
		if(instruccion.executeUpdate() !=1) {
			throw new SQLException("Error en la inserción");
		} else {
			System.out.println("Gestor añadido correctamente");
		}
		instruccion.close();
	}
	
	public void insertarVariosGestoresAl() throws SQLException {
		for(int i=0;i<4;i++) {
            insertarAleatorios();
        	}
	}
	
	public void obtener() throws SQLException {
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
	
	public void obtenerTodos() throws SQLException {
		String query = "SELECT * FROM gestor";
		
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
		Statement instruccion = conexion.createStatement();	
		
		ResultSet resultado = instruccion.executeQuery(query);
		
		if(!comprobarTabla()) {
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
	
	public void obtenerTodosReducido() throws SQLException {
		String query = "SELECT id, nombre, apellido FROM gestor";
		
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
		Statement instruccion = conexion.createStatement();	
		
		ResultSet resultado = instruccion.executeQuery(query);
		
		if(!comprobarTabla()) {
			System.out.println("No existe ningún gestor.");
		} else {
			System.out.println("Listado de Gestores: ");
			
			while(resultado.next()) {
				System.out.println("Gestor " + resultado.getInt("id"));
				
				System.out.println("Nombre y apellidos: " + resultado.getString("nombre") + " " + resultado.getString("apellido"));
				
				System.out.println("...");
			}
		}
		resultado.close();
		instruccion.close();
	}
	
	
	public void actualizar() throws SQLException {
		if(comprobarTabla()) {
			String query = "UPDATE gestor SET id=?, nombre=?, apellido=?, edad=?, email=? WHERE id=?";
			
			Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
			PreparedStatement instruccion = conexion.prepareStatement(query);
			System.out.println("¿Id?");
			id = sc.nextInt();
			if(existeId(id)) {
				instruccion.setInt(6, id);
				
				System.out.println("Id:");
				id = sc.nextInt();
				
					if(!existeId(id)) {
					instruccion.setInt(1,id);
					
					System.out.println("Nombre:");
					instruccion.setString(2,sc.next());
					
					System.out.println("Apellido:");
					instruccion.setString(3,sc.next());
					
					System.out.println("Edad:");
					instruccion.setInt(4,sc.nextInt());
					
					System.out.println("Email:");
					instruccion.setString(5,sc.next());
					
					if(instruccion.executeUpdate() !=1) {
						throw new SQLException("Error en la actualización");
					} else {
						System.out.println("Gestor actualizado correctamente");
					}
					instruccion.close();
				} else {
					System.out.println("Ya existe un gestor con ese Id. El Id no puede estar repetido.");
				}
			}else {
				System.out.println("El gestor escogido no existe.");
			}
		} else {
			System.out.println("No existe ningún gestor que actualizar.");
		}
	}
	
	public void eliminar() throws SQLException {
		if(comprobarTabla()) {
			String query = "DELETE FROM gestor WHERE id=?";
			
			Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
			PreparedStatement instruccion = conexion.prepareStatement(query);
			System.out.println("¿Id?");
	
			id = sc.nextInt();
			if(existeId(id)) {
				instruccion.setInt(1, id);
				
				if(instruccion.executeUpdate() !=1) {
					throw new SQLException("Error en la eliminación");
				} else {
					System.out.println("Gestor eliminado correctamente");
				}
				instruccion.close();
			} else {
				System.out.println("El gestor escogido no existe.");
			}
		} else {
			System.out.println("No existe ningún gestor que actualizar.");
		}
	}
	
	public boolean comprobarTabla() throws SQLException {
		 String query = "SELECT 1 FROM gestor LIMIT 1";
	      
    	Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
    		
        PreparedStatement instruccion = conexion.prepareStatement(query);
        ResultSet resultado = instruccion.executeQuery();
        return resultado.next();
        
	}

	@Override
	public boolean existeId(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT COUNT(*) FROM gestor WHERE id = ?";
	      
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
  		
		PreparedStatement instruccion = conexion.prepareStatement(query);
		instruccion.setInt(1, id);
      
		ResultSet resultado = instruccion.executeQuery();
      		
		if (resultado.next()) {
          int count = resultado.getInt(1);
          instruccion.close();
          return count >= 1;
	    } else {
	    	return false;
	    }
	}
	
	
>>>>>>> 0738cf23e22373fa0051b927beb6b1cad645b0c9
}
	
	

