package br.com.eccomerce.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.JdbcPreparedStatement;

import br.com.eccomerce.factory.ConnectionFactory;
import br.com.eccomerce.model.ProdutoPedido;

public class ProdutoPedidoDAO {
	public static void saveProdutoPedido(ProdutoPedido produtoPedido) {
		String sql = "INSERT INTO tbProdutoPedido(PED_CODIGO, PRO_CODIGO, PRP_QUANTIDADE) VALUES (?, ?, ?)";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			// Prepara a execução de uma query
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			
			// Adiciona os valores esperados pela query
			pstm.setInt(1, produtoPedido.getPED_CODIGO());
			pstm.setInt(2, produtoPedido.getPRO_CODIGO());
			pstm.setDouble(3, produtoPedido.getPRP_QUANTIDADE());
			
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
	
	public static List<ProdutoPedido> listProdutoPedido(){
		List<ProdutoPedido> produtoPedidos = new ArrayList<ProdutoPedido>();
		
		String sql = "SELECT * FROM tbProdutoPedido";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do banco. ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				ProdutoPedido produtoPedido = new ProdutoPedido();
				
				// Recuperar os atributos
				produtoPedido.setPRP_CODIGO(rset.getInt("PRP_CODIGO"));
				produtoPedido.setPED_CODIGO(rset.getInt("PED_CODIGO"));
				produtoPedido.setPRO_CODIGO(rset.getInt("PRO_CODIGO"));
				produtoPedido.setPRP_QUANTIDADE(rset.getInt("PRP_QUANTIDADE"));
				
				
				produtoPedidos.add(produtoPedido);
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
		
		return produtoPedidos;
	}

	public static List<ProdutoPedido> listProdutoPedido(int PED_CODIGO){
		List<ProdutoPedido> produtoPedidos = new ArrayList<ProdutoPedido>();
		
		String sql = "SELECT * FROM tbProdutoPedido";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do banco. ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				ProdutoPedido produtoPedido = new ProdutoPedido();
				
				// Recuperar os atributos
				produtoPedido.setPRP_CODIGO(rset.getInt("PRP_CODIGO"));
				produtoPedido.setPED_CODIGO(rset.getInt("PED_CODIGO"));
				produtoPedido.setPRO_CODIGO(rset.getInt("PRO_CODIGO"));
				produtoPedido.setPRP_QUANTIDADE(rset.getInt("PRP_QUANTIDADE"));
				
				if(produtoPedido.getPED_CODIGO() == PED_CODIGO) {
					produtoPedidos.add(produtoPedido);
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
		
		return produtoPedidos;
	}
	
	public static void updateProdutoPedido(ProdutoPedido produtoPedido) {
		String sql = "UPDATE tbProdutoPedido SET PED_CODIGO = ?, PRO_CODIGO = ?, PRP_QUANTIDADE = ?" +
				 "WHERE PRP_CODIGO = ?";
	
	Connection conn = null;
	JdbcPreparedStatement pstm = null;
	
	try {
		//Cria conexão
		conn = ConnectionFactory.createConnectionToMySQL();
		
		// Cria classe de execução da query
		pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
		
		// Adiciona os valores para atualizar
		pstm.setInt(1, produtoPedido.getPED_CODIGO());
		pstm.setInt(2, produtoPedido.getPRO_CODIGO());
		pstm.setInt(3, produtoPedido.getPRP_QUANTIDADE());
		pstm.setInt(4, produtoPedido.getPRP_CODIGO());
		
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
	
	public static void deleteProdutoPedido(ProdutoPedido produtoPedido) {
		String sql = "DELETE FROM tbProdutoPedido WHERE PRP_CODIGO = ?";
		
		Connection conn = null; 
		JdbcPreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, produtoPedido.getPRP_CODIGO());
			
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
