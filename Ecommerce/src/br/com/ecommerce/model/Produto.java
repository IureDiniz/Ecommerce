package br.com.ecommerce.model;

import br.com.ecommerce.dao.ProdutoDAO;

public class Produto {

	private int PRO_CODIGO;
	private String PRO_NOME;
	private String PRO_DESCRICAO;
	private double PRO_VALOR;
	private int PRO_ESTOQUE;
	
	public int getPRO_CODIGO() {
		return PRO_CODIGO;
	}
	public void setPRO_CODIGO(int pRO_CODIGO) {
		PRO_CODIGO = pRO_CODIGO;
	}
	public String getPRO_NOME() {
		return PRO_NOME;
	}
	public void setPRO_NOME(String pRO_NOME) {
		PRO_NOME = pRO_NOME;
	}
	public String getPRO_DESCRICAO() {
		return PRO_DESCRICAO;
	}
	public void setPRO_DESCRICAO(String pRO_DESCRICAO) {
		PRO_DESCRICAO = pRO_DESCRICAO;
	}
	public double getPRO_VALOR() {
		return PRO_VALOR;
	}
	public void setPRO_VALOR(double pRO_VALOR) {
		PRO_VALOR = pRO_VALOR;
	}
	public int getPRO_ESTOQUE() {
		return PRO_ESTOQUE;
	}
	public void setPRO_ESTOQUE(int pRO_ESTOQUE) {
		PRO_ESTOQUE = pRO_ESTOQUE;
	}
	
	public Produto(String nome, String descricao, double valor, int quantidade){
		this.PRO_NOME = nome;
		this.PRO_DESCRICAO = descricao;
		this.PRO_VALOR = valor;
		this.PRO_ESTOQUE = quantidade;
	}
	
	public Produto() {
		
	}

	// Interface usada no terminialGUI para listar produtos
	public String toString() {
		return "CODIGO: " + this.getPRO_CODIGO()
				+ "\nNOME: " + this.getPRO_NOME()
				+ "\nDESCRIÇÃO: " + this.getPRO_DESCRICAO()
				+ "\nVALOR: R$" + this.getPRO_VALOR()
				+ "\nESTOQUE: " + this.getPRO_ESTOQUE();
	}
	
	// Interface usada no terminalGUI para listar vendas
	public String toStringSpace() {
		return "		CODIGO: " + this.getPRO_CODIGO()
				+ "\n	NOME: " + this.getPRO_NOME()
				+ "\n	DESCRIÇÃO: " + this.getPRO_DESCRICAO()
				+ "\n	VALOR: R$" + this.getPRO_VALOR();
	}
	
	
	// Verifica se um produto existe
	public static boolean existeProduto(int codigoProduto) {
		Produto produto = ProdutoDAO.getProduto(codigoProduto);
		if(produto.getPRO_CODIGO() == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	// Verifica se o produto tem estoque maior ou igual a uma quantidade definida
	public static boolean emEstoque(int codigoProduto, int quantidade) {
		Produto produto = ProdutoDAO.getProduto(codigoProduto);
		if(produto.getPRO_ESTOQUE() >= quantidade) {
			return true;
		}
		else {
			return false;
		}
	}
}
