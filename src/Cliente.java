import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Cliente extends Conexion implements Metodos {
	
	Gestor gestor = new Gestor();

	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
//	métodos
	Scanner sc = new Scanner(System.in);

	@Override
	public void insertar() throws SQLException {
		// TODO Auto-generated method stub
		String query = "INSERT INTO cliente(id_gestor, nombre, apellido, edad, email) VALUES(?,?,?,?,?)";
		
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
		PreparedStatement instruccion = conexion.prepareStatement(query);
		
		System.out.println("Id Gestor:");
		gestor.obtenerTodosReducido();
		id = sc.nextInt();

		if(gestor.existeId(id)) {
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
				throw new SQLException("Error en la inserción");
			} else {
				System.out.println("Cliente añadido correctamente");
			}
			instruccion.close();
		}else {
			System.out.println("No existe ningún gestor con ese id.");
		}
	}

	@Override
	public void obtener() throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM cliente WHERE id = ?";
		
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
		PreparedStatement instruccion = conexion.prepareStatement(query);
		System.out.println("Id:");
		instruccion.setInt(1, sc.nextInt());
		
		ResultSet resultado = instruccion.executeQuery();
		if(resultado.next()) {
			System.out.println("Cliente " + resultado.getInt("id"));

			System.out.println("Id del Gestor:  " + resultado.getInt("id_gestor"));
			
			System.out.println("Nombre y apellidos: " + resultado.getString("nombre") + " " + resultado.getString("apellido"));
			
			System.out.println("Edad: " + resultado.getInt("edad") + " años");
			
			System.out.println("Email: " + resultado.getString("email"));
		} else {
			System.out.println("No existe ningún cliente con ese Id.");
		}
		resultado.close();
		instruccion.close();
	}

	@Override
	public void obtenerTodos() throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM cliente";
		
		Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
		Statement instruccion = conexion.createStatement();	
		
		ResultSet resultado = instruccion.executeQuery(query);
		
		if(!comprobarTabla()) {
			System.out.println("No existe ningún cliente.");
		} else {
			System.out.println("Listado de Clientes: ");
			
			while(resultado.next()) {
				System.out.println("Cliente " + resultado.getInt("id"));
				
				System.out.println("Id del Gestor: " + resultado.getInt("id_gestor"));
				
				System.out.println("Nombre y apellidos: " + resultado.getString("nombre") + " " + resultado.getString("apellido"));
				
				System.out.println("Edad: " + resultado.getInt("edad") + " años");
				
				System.out.println("Email: " + resultado.getString("email"));
				
				System.out.println("...");
			}
		}
		resultado.close();
		instruccion.close();
	}

	@Override
	public void actualizar() throws SQLException {
		// TODO Auto-generated method stub
		if(comprobarTabla()) {
			String query = "UPDATE cliente SET id=?, id_gestor=?, nombre=?, apellido=?, edad=?, email=? WHERE id=?";
			
			Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
			PreparedStatement instruccion = conexion.prepareStatement(query);
			System.out.println("¿Id?");
			instruccion.setInt(7, sc.nextInt());
				
			System.out.println("Id:");
			id = sc.nextInt();
			
				if(!existeId(id)) {
				instruccion.setInt(1,id);
				
				System.out.println("Id Gestor:");
				gestor.obtenerTodosReducido();
				id = sc.nextInt();

				if(gestor.existeId(id)) {
					instruccion.setInt(2,id);
					
					System.out.println("Nombre:");
					instruccion.setString(3,sc.next());
					
					System.out.println("Apellido:");
					instruccion.setString(4,sc.next());
					
					System.out.println("Edad:");
					instruccion.setInt(5,sc.nextInt());
					
					System.out.println("Email:");
					instruccion.setString(6,sc.next());
					
					if(instruccion.executeUpdate() !=1) {
						throw new SQLException("Error en la actualización");
					} else {
						System.out.println("Cliente actualizado correctamente");
					}
					instruccion.close();
				}else {
					System.out.println("No existe un gestor con ese Id. Intentelo de nuevo.");
				}
			} else {
				System.out.println("Ya existe un cliente con ese Id. El Id no puede estar repetido.");
			}
		} else {
			System.out.println("No existe ningún cliente que actualizar.");
		}
		
	}

	@Override
	public void eliminar() throws SQLException {
		// TODO Auto-generated method stub
		if(comprobarTabla()) {
			String query = "DELETE FROM cliente WHERE id=?";
			
			Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
			PreparedStatement instruccion = conexion.prepareStatement(query);
			System.out.println("¿Id?");
			
			instruccion.setInt(1, sc.nextInt());
			
			if(instruccion.executeUpdate() !=1) {
				throw new SQLException("Error en la eliminación");
			} else {
				System.out.println("Cliente eliminado correctamente");
			}
		
			instruccion.close();
		} else {
			System.out.println("No existe ningún cliente que eliminar.");
		}
	}
	
	public boolean comprobarTabla() throws SQLException {
	    String query = "SELECT 1 FROM cliente LIMIT 1";
	      
    	Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
    		
    	 PreparedStatement instruccion = conexion.prepareStatement(query);
         ResultSet resultado = instruccion.executeQuery();
         return resultado.next();
	}

	@Override
	public boolean existeId(int id) throws SQLException {
		// TODO Auto-generated method stub
		 String query = "SELECT COUNT(*) FROM cliente WHERE id = ?";
	      
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
	
	

}
