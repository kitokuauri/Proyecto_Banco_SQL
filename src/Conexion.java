//SuperClasse

import java.util.Random;

public class Conexion {

	public Conexion(String url, String usuario, String contraseña) {
		this.url=url;
		this.usuario=usuario;
		this.contraseña=contraseña;
	}
	
//	atributos
	Random aleatorio = new Random(); 
	
	protected String url;
	protected String usuario;
	protected String contraseña;
	
	protected int intAleatorio01 = aleatorio.nextInt(100);
	
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
}
