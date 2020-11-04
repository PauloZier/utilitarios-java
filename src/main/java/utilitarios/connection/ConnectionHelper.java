package utilitarios.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConnectionHelper {

	private String driver;
	private String url;
	private String user;
	private String password;
	
	public ConnectionHelper() {
	
	}
	
	public ConnectionHelper(String driver, String url, String user, String password) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public Connection createConnection() {
		
		try {
			
			Class.forName(driver);
			
			return DriverManager.getConnection(url, user, password);
			
		} catch (Exception ex) {
			
			throw new RuntimeException(ex);
		}
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static class ConnectionBuilder {
		
		private String driver;
		private String url;
		private String user;
		private String password;
		
		public ConnectionBuilder() {
		
		}
		
		public ConnectionBuilder(String driver, String url, String user, String password) {
			super();
			this.driver = driver;
			this.url = url;
			this.user = user;
			this.password = password;
		}

		public ConnectionBuilder setDriver(String driver) {
			this.driver = driver;
			return this;
		}
		
		public ConnectionBuilder setUrl(String url) {
			this.url = url;
			return this;
		}
		
		public ConnectionBuilder setUser(String user) {
			this.user = user;
			return this;
		}
		
		public ConnectionBuilder setPassword(String password) {
			this.password = password;
			return this;
		}
		
		public ConnectionHelper build() {
			
			return new ConnectionHelper(this.driver, this.url, this.user, this.password);
		}
		
		public Connection getConnection() {
			
			return this.build().createConnection();
		}
	}
}
