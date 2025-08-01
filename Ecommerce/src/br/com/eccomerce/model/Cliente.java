package br.com.eccomerce.model;

import br.com.eccomerce.dao.ClienteDAO;

public class Cliente {
	private int CLI_CODGO;
	private String CLI_NOME;
	private String CLI_EMAIL;
	private String CLI_ENDERECO;
	private String CLI_TELEFONE;
	
	public int getCLI_CODIGO() {
		return CLI_CODGO;
	}
	public void setCLI_CODIGO(int cLI_CODGO) {
		CLI_CODGO = cLI_CODGO;
	}
	public String getCLI_NOME() {
		return CLI_NOME;
	}
	public void setCLI_NOME(String cLI_NOME) {
		CLI_NOME = cLI_NOME;
	}
	public String getCLI_EMAIL() {
		return CLI_EMAIL;
	}
	public void setCLI_EMAIL(String cLI_EMAIL) {
		CLI_EMAIL = cLI_EMAIL;
	}
	public String getCLI_ENDERECO() {
		return CLI_ENDERECO;
	}
	public void setCLI_ENDERECO(String cLI_ENDERECO) {
		CLI_ENDERECO = cLI_ENDERECO;
	}
	public String getCLI_TELEFONE() {
		return CLI_TELEFONE;
	}
	public void setCLI_TELEFONE(String cLI_TELEFONE) {
		CLI_TELEFONE = cLI_TELEFONE;
	}

	public Cliente(String nome, String email, String endereco, String telefone) {
		this.CLI_NOME = nome;
		this.CLI_EMAIL = email;
		this.CLI_ENDERECO = endereco;
		this.CLI_TELEFONE = telefone;
	}
	
	public Cliente() {}
	
	public String toString() {
		return "CODIGO: " + this.getCLI_CODIGO()
				+ "\nNOME: " + this.getCLI_NOME()
				+ "\nEMAIL: " + this.getCLI_EMAIL()
				+ "\nENDERECO: " + this.getCLI_ENDERECO()
				+ "\nETELEFONE: " + this.getCLI_TELEFONE();
	}

	// Verifica se o cliente com o codigo determinado existe no bancod e dados e retorna valor booleano
	public static boolean existeCliente(int codigoCliente) {
		Cliente cliente = ClienteDAO.getCliente(codigoCliente);
		if(cliente.getCLI_CODIGO() == 0) {
			return false;
		}
		else {
			return true;
		}
	}
}
