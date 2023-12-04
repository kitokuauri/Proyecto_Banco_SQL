//SuperClasse

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;

public class Conexion {

	public Conexion() {
		this.url="jdbc:mysql://localhost:3306/banco_final";
		this.usuario="banco";
		this.contraseña="banco";
	}
	
//	atributos
	Random aleatorio = new Random(); 
	Scanner sc = new Scanner(System.in);
	
	protected String url;
	protected String usuario;
	protected String contraseña;
	
	protected int id;
	protected int id2;
	
	protected int intAleatorio01 = aleatorio.nextInt(100);
	protected int intAleatorio02 = aleatorio.nextInt(3000);
	
	protected String stringAleatorio01 = stringAleatorio();
	protected String stringAleatorio02 = stringAleatorio();
	protected String stringAleatorio03 = stringAleatorio();
	
//	metodos
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
	
	public java.sql.Date recibirFecha() {
		String fechaStr = sc.next();
		java.sql.Date fecha = null;
	    try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date parsedDate = dateFormat.parse(fechaStr);
	        fecha = new java.sql.Date(parsedDate.getTime());
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    return fecha;
	}
}
