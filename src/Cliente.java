import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Cliente extends Conexion implements Metodos {

	public Cliente(String url, String usuario, String contraseña) {
		super(url, usuario, contraseña);
		// TODO Auto-generated constructor stub
	}
	
//	métodos
	Scanner sc = new Scanner(System.in);

	@Override
	public void insertar() throws SQLException {
		// TODO Auto-generated method stub
		if(existeGestorId1()) {
//		El id de gestor por defecto es 1 porque tienen que estar ligado a un gestor existente
		String query = "INSERT INTO cliente(id_gestor, nombre, apellido, edad, email) VALUES(1,?,?,?,?)";
		
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
			System.out.println("Cliente añadido correctamente");
		}
		instruccion.close();
		} else {
			System.out.println("No existe un gestor con id=1. La inserción no se puede realizar.");
		}
	}
	
	public boolean existeGestorId1() throws SQLException {
	    String query = "SELECT COUNT(*) FROM gestor WHERE id = 1";
	      
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
			String query = "UPDATE cliente SET id=?, nombre=?, apellido=?, edad=?, email=? WHERE id=?";
			
			Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
			PreparedStatement instruccion = conexion.prepareStatement(query);
			System.out.println("¿Id?");
			instruccion.setInt(6, sc.nextInt());
				
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
					System.out.println("Cliente actualizado correctamente");
				}
				instruccion.close();
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
	            return count > 0;
		    } else {
		    	return false;
		    }
	}

}
