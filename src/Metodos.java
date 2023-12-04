import java.sql.SQLException;

public interface Metodos {

	public abstract void insertar() throws SQLException ;
	public abstract void obtener() throws SQLException ;
	public abstract void obtenerTodos() throws SQLException ;
	public abstract void actualizar() throws SQLException ;
	public abstract void eliminar() throws SQLException ;
	public abstract boolean comprobarTabla() throws SQLException;
	public abstract boolean existeId(int id) throws SQLException;
	public void obtenerTodosReducido() throws SQLException;
	
}
