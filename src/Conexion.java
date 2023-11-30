//SuperClasse
public class Conexion {

	public Conexion(String url, String usuario, String contraseña) {
		this.url=url;
		this.usuario=usuario;
		this.contraseña=contraseña;
	}
	
//	atributos
	protected String url;
	protected String usuario;
	protected String contraseña;
}
