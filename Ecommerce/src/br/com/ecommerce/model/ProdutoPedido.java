package br.com.ecommerce.model;

public class ProdutoPedido {
	private int PRP_CODIGO;
	private int PED_CODIGO;
	private int PRO_CODIGO;
	private int PRP_QUANTIDADE;
	
	public int getPRP_CODIGO() {
		return PRP_CODIGO;
	}
	public void setPRP_CODIGO(int pRP_CODIGO) {
		PRP_CODIGO = pRP_CODIGO;
	}
	public int getPED_CODIGO() {
		return PED_CODIGO;
	}
	public void setPED_CODIGO(int pED_CODIGO) {
		PED_CODIGO = pED_CODIGO;
	}
	public int getPRO_CODIGO() {
		return PRO_CODIGO;
	}
	public void setPRO_CODIGO(int pRO_CODIGO) {
		PRO_CODIGO = pRO_CODIGO;
	}
	public int getPRP_QUANTIDADE() {
		return PRP_QUANTIDADE;
	}
	public void setPRP_QUANTIDADE(int pRP_QUANTIDADE) {
		PRP_QUANTIDADE = pRP_QUANTIDADE;
	}

	public ProdutoPedido(int pedido, int produto, int quantidade) { 
		this.PED_CODIGO = pedido;
		this.PRO_CODIGO = produto;
		this.PRP_QUANTIDADE = quantidade;
	}
	public ProdutoPedido() {}
}
