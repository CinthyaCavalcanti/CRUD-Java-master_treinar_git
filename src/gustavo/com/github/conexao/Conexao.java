package gustavo.com.github.conexao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

//precisa ajustar essa conex�o
/*
deveria ser uma classe anotada em vez
de uma classe com jdbc
*/

public class Conexao {
	private static BasicDataSource dataSource = null;
	
	private static DataSource getDataSource() {
		if (dataSource == null) {
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("");
			dataSource.setUrl("jdbc:mysql://localhost:3306/crud_java?useTimezone=true&serverTimezone=UTC&useSSL=false&rewriteBatchedStatements=true&relaxAutoCommit=true");	
			dataSource.setInitialSize(50);
			dataSource.setMaxIdle(100);
			dataSource.setMaxTotal(1000);
			dataSource.setMaxWaitMillis(5000);
			dataSource.setEnableAutoCommitOnReturn(true);
		}else if (dataSource.getEnableAutoCommitOnReturn()) {
			System.out.println("EnableAutoCommitOnReturn � true");
		}
		System.out.println("testeee");
		System.out.println("é null");
		System.out.println("mais uma mudan�a");
		
		return dataSource;
	}
	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
		
	}
}
