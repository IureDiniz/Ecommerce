package br.com.eccomerce.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.JdbcPreparedStatement;

import br.com.eccomerce.factory.ConnectionFactory;
import br.com.eccomerce.model.Cliente;
import br.com.eccomerce.model.Produto;

public class ProdutoDAO {
	
	public static void saveProduto(Produto produto) {
		String sql = "INSERT INTO tbProduto(PRO_NOME, PRO_DESCRICAO, PRO_VALOR, PRO_ESTOQUE) VALUES (?, ?, ?, ?)";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			// Prepara a execução de uma query
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			
			// Adiciona os valores esperados pela query
			pstm.setString(1, produto.getPRO_NOME());
			pstm.setString(2, produto.getPRO_DESCRICAO());
			pstm.setDouble(3, produto.getPRO_VALOR());
			pstm.setInt(4, produto.getPRO_ESTOQUE());
			
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
	
	public static Produto getProduto(int codigo) {
		Produto produto = new Produto();
		
		String sql = "SELECT * FROM tbProduto";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do banco. ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Produto aux = new Produto();
				
				// Recuperar os atributos
				aux.setPRO_CODIGO(rset.getInt("PRO_CODIGO"));
				aux.setPRO_NOME(rset.getString("PRO_NOME"));
				aux.setPRO_DESCRICAO(rset.getString("PRO_DESCRICAO"));
				aux.setPRO_VALOR(rset.getDouble("PRO_VALOR"));
				aux.setPRO_ESTOQUE(rset.getInt("PRO_ESTOQUE"));
				
				if(aux.getPRO_CODIGO() == codigo) {
					produto = aux;
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
		
		return produto;
	}
	
	public static void updateProduto(Produto produto) {
	String sql = "UPDATE tbProduto SET PRO_NOME = ?, PRO_DESCRICAO = ?, PRO_VALOR = ?, PRO_ESTOQUE = ? WHERE PRO_CODIGO = ?";
	
	Connection conn = null;
	JdbcPreparedStatement pstm = null;
	
	try {
		//Cria conexão
		conn = ConnectionFactory.createConnectionToMySQL();
		
		// Cria classe de execução da query
		pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
		
		// Adiciona os valores para atualizar
		pstm.setString(1, produto.getPRO_NOME());
		pstm.setString(2, produto.getPRO_DESCRICAO());
		pstm.setDouble(3, produto.getPRO_VALOR());
		pstm.setInt(4, produto.getPRO_ESTOQUE());
		pstm.setInt(5, produto.getPRO_CODIGO());
		
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
	
	public static void deleteProduto(Produto produto) {
		String sql = "DELETE FROM tbProduto WHERE PRO_CODIGO = ?";
		
		Connection conn = null; 
		JdbcPreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, produto.getPRO_CODIGO());
			
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

	public static List<Produto> listProduto(){
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "SELECT * FROM tbProduto";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do banco. ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Produto produto = new Produto();
				
				// Recuperar os atributos
				produto.setPRO_CODIGO(rset.getInt("PRO_CODIGO"));
				produto.setPRO_NOME(rset.getString("PRO_NOME"));
				produto.setPRO_DESCRICAO(rset.getString("PRO_DESCRICAO"));
				produto.setPRO_VALOR(rset.getDouble("PRO_VALOR"));
				produto.setPRO_ESTOQUE(rset.getInt("PRO_ESTOQUE"));
				
				produtos.add(produto);
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
		
		return produtos;
	}

	public static List<Produto> listProduto(String pesquisaNome) {
		String sql = "SELECT * FROM tbProduto WHERE PRO_NOME LIKE ? or PRO_DESCRICAO LIKE ?";
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, "%" + pesquisaNome + "%");
			pstm.setString(2, "%" + pesquisaNome + "%");

			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Produto produto = new Produto();
				
				// Recuperar os atributos
				produto.setPRO_CODIGO(rset.getInt("PRO_CODIGO"));
				produto.setPRO_NOME(rset.getString("PRO_NOME"));
				produto.setPRO_DESCRICAO(rset.getString("PRO_DESCRICAO"));
				produto.setPRO_VALOR(rset.getDouble("PRO_VALOR"));
				produto.setPRO_ESTOQUE(rset.getInt("PRO_ESTOQUE"));
				
				produtos.add(produto);
			}
			
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
		return produtos;
	}

	public static List<Produto> listProduto(double precoMinimo, double precoMaximo) {
	String sql = "SELECT * FROM tbProduto WHERE PRO_VALOR between ? and ?";
	
	List<Produto> produtos = new ArrayList<Produto>();
	
	Connection conn = null;
	JdbcPreparedStatement pstm = null;
	
	
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
		pstm.setDouble(1, precoMinimo);
		pstm.setDouble(2, precoMaximo);
		rset = pstm.executeQuery();
		
		while (rset.next()) {
			Produto produto = new Produto();
			
			// Recuperar os atributos
			produto.setPRO_CODIGO(rset.getInt("PRO_CODIGO"));
			produto.setPRO_NOME(rset.getString("PRO_NOME"));
			produto.setPRO_DESCRICAO(rset.getString("PRO_DESCRICAO"));
			produto.setPRO_VALOR(rset.getDouble("PRO_VALOR"));
			produto.setPRO_ESTOQUE(rset.getInt("PRO_ESTOQUE"));
			
			produtos.add(produto);
		}
		
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
	return produtos;
}
}

