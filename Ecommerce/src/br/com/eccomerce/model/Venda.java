package br.com.eccomerce.model;

import java.util.List;

import br.com.eccomerce.dao.ClienteDAO;
import br.com.eccomerce.dao.PedidoDAO;
import br.com.eccomerce.dao.ProdutoDAO;
import br.com.eccomerce.dao.ProdutoPedidoDAO;

public class Venda {
	private Pedido pedido;
	private List<ProdutoPedido> produtos;
	private double valorTotal;
	
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public List<ProdutoPedido> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<ProdutoPedido> produtos) {
		this.produtos = produtos;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Venda(int codigo) {
		pedido = PedidoDAO.listPedido(codigo);
		
		produtos = ProdutoPedidoDAO.listProdutoPedido(pedido.getPED_CODIGO());
	}
	
	public String toString() {
		Cliente cliente = ClienteDAO.getCliente(pedido.getCLI_CODIGO());
		double valorTotal = 0;
		
		String saida = "PEDIDO: " + pedido.getPED_CODIGO()
				+ "\nCLIENTE: " + cliente.getCLI_NOME()
				+ "\nDATA: " + pedido.getPED_DATA()
				+ "\nPRODUTOS: ";
		
		for(ProdutoPedido item : produtos) {
			Produto produto = ProdutoDAO.getProduto(item.getPRO_CODIGO());
			saida += "\n      " + produto.getPRO_NOME()
					+ "\n - PREÇO: R$" + produto.getPRO_VALOR()
					+ "\n - QUANTIDADE: " + item.getPRP_QUANTIDADE();
			valorTotal += produto.getPRO_VALOR() * item.getPRP_QUANTIDADE();
		}
		saida += "\nVALOR TOTAL: R$" + valorTotal + "\n";
		
		return saida;
	}
}
