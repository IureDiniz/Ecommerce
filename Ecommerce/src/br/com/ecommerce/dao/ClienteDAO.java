package br.com.ecommerce.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.JdbcPreparedStatement;

import br.com.ecommerce.factory.ConnectionFactory;
import br.com.ecommerce.model.Cliente;

public class ClienteDAO {
	
	public static void saveCliente(Cliente cliente) {
		String sql = "INSERT INTO tbCliente(CLI_NOME, CLI_EMAIL, CLI_ENDERECO, CLI_TELEFONE) VALUES (?, ?, ?, ?)";
	
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		try {
			// Faz conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			// Prepara a execução de uma query
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			
			// Adiciona os valores esperados pela query
			pstm.setString(1, cliente.getCLI_NOME());
			pstm.setString(2, cliente.getCLI_EMAIL());
			pstm.setString(3, cliente.getCLI_ENDERECO());
			pstm.setString(4, cliente.getCLI_TELEFONE());
			
			// Executa a query
			pstm.execute();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// Fechar as conexões
			
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static List<Cliente> getCliente(){
		String sql = "SELECT * FROM tbCliente";
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do banco. ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Cliente cliente = new Cliente();
				
				// Recuperar os atributos
				cliente.setCLI_CODIGO(rset.getInt("CLI_CODIGO"));
				cliente.setCLI_NOME(rset.getString("CLI_NOME"));
				cliente.setCLI_EMAIL(rset.getString("CLI_EMAIL"));
				cliente.setCLI_ENDERECO(rset.getString("CLI_ENDERECO"));
				cliente.setCLI_TELEFONE(rset.getString("CLI_TELEFONE"));
				
				clientes.add(cliente);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) {
					rset.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return clientes;
	}

	public static Cliente getCliente(int codigoCliente){
		String sql = "SELECT * FROM tbCliente";
		Cliente cliente = new Cliente();
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do banco. ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Cliente aux = new Cliente();
				
				// Recuperar os atributos
				aux.setCLI_CODIGO(rset.getInt("CLI_CODIGO"));
				aux.setCLI_NOME(rset.getString("CLI_NOME"));
				aux.setCLI_EMAIL(rset.getString("CLI_EMAIL"));
				aux.setCLI_ENDERECO(rset.getString("CLI_ENDERECO"));
				aux.setCLI_TELEFONE(rset.getString("CLI_TELEFONE"));
				
				if(aux.getCLI_CODIGO() == codigoCliente) {
					cliente = aux;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) {
					rset.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return cliente;
	}
	
	public static void updateCliente(Cliente cliente) {
		String sql = "UPDATE tbCliente SET CLI_NOME = ?, CLI_EMAIL = ?, CLI_ENDERECO = ?, CLI_TELEFONE = ?" +
					 "WHERE CLI_CODIGO = ?";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		try {
			//Cria conexão
			conn = ConnectionFactory.createConnectionToMySQL();
			
			// Cria classe de execução da query
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			
			// Adiciona os valores para atualizar
			pstm.setString(1, cliente.getCLI_NOME());
			pstm.setString(2, cliente.getCLI_EMAIL());
			pstm.setString(3, cliente.getCLI_ENDERECO());
			pstm.setString(4, cliente.getCLI_TELEFONE());
			pstm.setInt(5, cliente.getCLI_CODIGO());
			
			// Executa a query
			pstm.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void deleteCliente(Cliente cliente) {
		String sql = "DELETE FROM tbCliente WHERE CLI_CODIGO = ?";
		
		Connection conn = null; 
		JdbcPreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, cliente.getCLI_CODIGO());
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
}
