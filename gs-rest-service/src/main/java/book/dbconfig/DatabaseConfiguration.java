package book.dbconfig;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@ConfigurationProperties("oracle")
public class DatabaseConfiguration {

	@NotNull
	private String username = "fsd";
	@NotNull
	private String password = "password";
	@NotNull
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Bean
	public Connection dataSource() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser("fsd");
		dataSource.setPassword("password");
		dataSource.setURL(url);
		System.out.println(url);
		dataSource.setImplicitCachingEnabled(true);
		Connection connection = dataSource.getConnection();
		return connection;
	}
	
	@Bean
	public DataSource dataSource1() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser("fsd");
		dataSource.setPassword("password");
		dataSource.setURL(url);
		return dataSource;
	}

}
