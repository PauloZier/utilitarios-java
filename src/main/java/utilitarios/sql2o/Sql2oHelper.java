package utilitarios.sql2o;

import org.sql2o.Sql2o;

public final class Sql2oHelper {

	private String driver;
	private String url;
	private String user;
	private String password;
	
	public Sql2oHelper() {
	
	}
	
	public Sql2oHelper(String driver, String url, String user, String password) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public Sql2o createConnection() {
		
		try {
			
			Class.forName(driver);
			
			return new Sql2o(url, user, password);
			
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

	public static class Sql2oBuilder {
		
		private String driver;
		private String url;
		private String user;
		private String password;
		
		public Sql2oBuilder() {
		
		}
		
		public Sql2oBuilder(String driver, String url, String user, String password) {
			super();
			this.driver = driver;
			this.url = url;
			this.user = user;
			this.password = password;
		}

		public Sql2oBuilder setDriver(String driver) {
			this.driver = driver;
			return this;
		}
		
		public Sql2oBuilder setUrl(String url) {
			this.url = url;
			return this;
		}
		
		public Sql2oBuilder setUser(String user) {
			this.user = user;
			return this;
		}
		
		public Sql2oBuilder setPassword(String password) {
			this.password = password;
			return this;
		}
		
		public Sql2oHelper build() {
			
			return new Sql2oHelper(this.driver, this.url, this.user, this.password);
		}
		
		public Sql2o getConnection() {
			
			return this.build().createConnection();
		}
	}
}
