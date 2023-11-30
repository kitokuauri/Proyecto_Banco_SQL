import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost:3306/banco_pruebas";
        String usuario = "banco";
        String contraseña = "banco";
		
		Gestor gestor = new Gestor(url, usuario, contraseña);
		
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
			System.out.println("18. Login y registro.");
			System.out.println("0. Finalizar");
			System.out.println("~ ~ ~ ~ ~ ~");
			
		numero = sc.nextInt();	
            
            switch (numero){
            case 1: // Insercion 1 gestor
            	gestor.insertarGestor();
                break;
            case 2: // Insercion varios gestores
            	
                break;
            case 3: // Obtencion 1 gestor
            	
                break;
            case 4: // Obtencion todos los gestores
                
                break;
            case 5: // Actualizacion 1 gestor
            	
                break;
            case 6: // Eliminación 1 gestor
            	
                break;
            case 7: // Insercion 1 cliente
            	
                break;
            case 8: // Obtencion 1 cliente
            	
            	break;
            case 9: // Obtencion todos los clientes
            	  
            	break;
            case 10: // Actualizacion 1 Cliente
            	
            	break;
            case 11: // Eliminación 1 Cliente
            	
            	break;
            case 12: // Obtencion 1 mensaje
            	
            	break;
            case 13: // Obtencion todos los mensajes
            	
            	break;
            case 14: // Envio 1 mensaje
              
                break;
            case 15: // Obtencion 1 transferencia
            	
            	break;
            case 16: // Obtencion todas las transferencias
            	
            	break;
            case 17: // Envio 1 transferencia
            
            	break;
            case 18: // Login y Registro
            	
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
