import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Gestor gestor = new Gestor();
		Cliente cliente = new Cliente();
		Mensaje mensaje = new Mensaje();
		Transferencia transferencia = new Transferencia();
		
		int numero = 1;
		
		
		while(numero != 0) {
			
			System.out.println("~~ MENÚ ~~");
			System.out.println("1. Inserción de un gestor.");
			System.out.println("2. Inserción masiva de gestores con datos aleatorios.");
			System.out.println("3. Obtención de un gestor.");
			System.out.println("4. Obtención de todos los gestores.");
			System.out.println("5. Actualización de un gestor.");
			System.out.println("6. Eliminación de un gestor.");
			System.out.println("7. Inserción de un cliente.");
			System.out.println("8. Obtención de un cliente.");
			System.out.println("9. Obtención de todos los clientes.");
			System.out.println("10. Actualización de un cliente.");
			System.out.println("11. Eliminación de un cliente.");
			System.out.println("12. Obtención de un mensaje.");
			System.out.println("13. Obtención de todos los mensajes.");
			System.out.println("14. Envío de un mensaje.");
			System.out.println("15. Obtención de una transferencia.");
			System.out.println("16. Obtención de todas las trasferencias");
			System.out.println("17. Envío de una transferencia.");
			System.out.println("0. Finalizar");
			System.out.println("~ ~ ~ ~ ~ ~");
			
		numero = sc.nextInt();	
            
            switch (numero){
            case 1: // Insercion 1 gestor
            	gestor.insertar();
                break;
            case 2: // Insercion varios gestores
            	gestor.insertarVariosGestoresAl();
                break;
            case 3: // Obtencion 1 gestor
            	gestor.obtener();
                break;
            case 4: // Obtencion todos los gestores
                gestor.obtenerTodos();
                break;
            case 5: // Actualizacion 1 gestor
            	gestor.actualizar();
                break;
            case 6: // Eliminación 1 gestor
            	gestor.eliminar();
                break;
            case 7: // Insercion 1 cliente
            	cliente.insertar();
                break;
            case 8: // Obtencion 1 cliente
            	cliente.obtener();
            	break;
            case 9: // Obtencion todos los clientes
            	 cliente.obtenerTodos();
            	break;
            case 10: // Actualizacion 1 Cliente
            	cliente.actualizar();
            	break;
            case 11: // Eliminación 1 Cliente
            	cliente.eliminar();
            	break;
            case 12: // Obtencion 1 mensaje
            	mensaje.obtener();
            	break;
            case 13: // Obtencion todos los mensajes
            	mensaje.obtenerTodos();
            	break;
            case 14: // Envio 1 mensaje
            	mensaje.insertar();
                break;
            case 15: // Obtencion 1 transferencia
            	transferencia.obtener();
            	break;
            case 16: // Obtencion todas las transferencias
            	transferencia.obtenerTodos();
            	break;
            case 17: // Envio 1 transferencia
            	transferencia.insertar();
            	break;
            case 0:
            	break;
            default:
            	System.out.println("Por favor, introduce un número válido.");	
            }

		} sc.close();
		
		System.out.println("Programa finalizado. ¡Hasta la vista!");
		
		
	}

}
