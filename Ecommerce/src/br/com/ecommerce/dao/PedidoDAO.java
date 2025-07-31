package br.com.ecommerce.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.JdbcPreparedStatement;

import br.com.ecommerce.factory.ConnectionFactory;
import br.com.ecommerce.model.Pedido;

public class PedidoDAO {
	public static void savePedido(Pedido pedido) {
		String sql = "INSERT INTO tbPedido(CLI_CODIGO, PED_DATA) VALUES (?, ?)";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			// Prepara a execução de uma query
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			
			// Adiciona os valores esperados pela query
			pstm.setInt(1, pedido.getCLI_CODIGO());
			pstm.setDate(2, pedido.getPED_DATA_SQL());
			
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
	
	public static List<Pedido> listPedido(){
		List<Pedido> pedidos = new ArrayList<Pedido>();
		
		String sql = "SELECT * FROM tbPedido";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do banco. ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Pedido pedido = new Pedido();
				
				// Recuperar os atributos
				pedido.setPED_CODIGO(rset.getInt("PED_CODIGO"));
				pedido.setCLI_CODIGO(rset.getInt("CLI_CODIGO"));
				pedido.setPED_DATA(rset.getDate("PED_DATA"));
				
				pedidos.add(pedido);
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
		
		return pedidos;
	}

	public static Pedido listPedido(int codigoPedido){
		Pedido pedido = null;
		
		String sql = "SELECT * FROM tbPedido";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do banco. ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Pedido aux = new Pedido();
				
				// Recuperar os atributos
				aux.setPED_CODIGO(rset.getInt("PED_CODIGO"));
				aux.setCLI_CODIGO(rset.getInt("CLI_CODIGO"));
				aux.setPED_DATA(rset.getDate("PED_DATA"));
				
				if(aux.getPED_CODIGO() == codigoPedido) {
					pedido = aux;
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
		
		return pedido;
	}

	public static Pedido getLastPedido(){
		Pedido pedido = null;
		
		String sql = "SELECT * FROM tbPedido";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do banco. ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			// Laço que percorre todos os pedidos até salvar o último
			while (rset.next()) {
				Pedido aux = new Pedido();
				
				// Recuperar os atributos
				aux.setPED_CODIGO(rset.getInt("PED_CODIGO"));
				aux.setCLI_CODIGO(rset.getInt("CLI_CODIGO"));
				aux.setPED_DATA(rset.getDate("PED_DATA"));

				pedido = aux;
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
		
		return pedido;
	}
	
	public static void updatePedido(Pedido pedido) {
		String sql = "UPDATE tbPedido SET CLI_CODIGO = ?, PED_DATA = ?" +
				 "WHERE PED_CODIGO = ?";
	
	Connection conn = null;
	JdbcPreparedStatement pstm = null;
	
	try {
		//Cria conexão
		conn = ConnectionFactory.createConnectionToMySQL();
		
		// Cria classe de execução da query
		pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
		
		// Adiciona os valores para atualizar
		pstm.setInt(1, pedido.getCLI_CODIGO());
		pstm.setDate(2, (Date) pedido.getPED_DATA());
		pstm.setInt(3, pedido.getPED_CODIGO());
		
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
	
	public static void deletePedido(Pedido pedido) {
		String sql = "DELETE FROM tbPedido WHERE PED_CODIGO = ?";
		
		Connection conn = null; 
		JdbcPreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, pedido.getPED_CODIGO());
			
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

