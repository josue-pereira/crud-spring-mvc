package br.com.pmi.projetoinicial.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSqlServer {

	public static String status = "Não conectou...";

	public ConexaoSqlServer() {

	}

	public static java.sql.Connection getConexao() {

      Connection connection = null;         

    try {

    	  String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";                        

          Class.forName(driverName);

          String url = "jdbc:sqlserver://localhost:1433;user=sa;password=19960327;databaseName=projeto_spring";

          connection = DriverManager.getConnection(url);


          if (connection != null) {

              status = ("STATUS--->Conectado com sucesso!");

          } else {

              status = ("STATUS--->Não foi possivel realizar conexão");

          }

          return connection;

      } catch (ClassNotFoundException e) {  //Driver não encontrado

          System.out.println("O driver expecificado nao foi encontrado.");

          return null;

      } catch (SQLException e) {

    	  
          System.out.println("Nao foi possivel conectar ao Banco de Dados.");

          return null;

      }

  }

	// Método que retorna o status da sua conexão//

	public static String statusConection() {
		return status;

	}

	// Método que fecha sua conexão//

	public static boolean FecharConexao() {
		try {
			ConexaoSqlServer.getConexao().close();

			return true;
			
		} catch (SQLException e) {
			return false;

		}
	}

	// Método que reinicia sua conexão//

	public static java.sql.Connection ReiniciarConexao() {
		FecharConexao();

		return ConexaoSqlServer.getConexao();
	}
}
