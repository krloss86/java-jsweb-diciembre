package ar.com.educacionit.dao.connection;

public final class ConnectionUtils {

	private String db;
	private String usuario;
	private String password;
	
	public ConnectionUtils(String db, String usuario, String password) {
		this.db = db;
		this.usuario = usuario;
		this.password = password;
	}
	
	public Connection getConnection() {
		return new Connection();
	}
}
