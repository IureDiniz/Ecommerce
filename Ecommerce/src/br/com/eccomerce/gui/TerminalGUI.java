package br.com.eccomerce.gui;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.eccomerce.dao.ProdutoDAO;
import br.com.eccomerce.dao.ClienteDAO;
import br.com.eccomerce.dao.PedidoDAO;
import br.com.eccomerce.dao.ProdutoPedidoDAO;
import br.com.eccomerce.model.Cliente;
import br.com.eccomerce.model.Produto;
import br.com.eccomerce.model.Pedido;
import br.com.eccomerce.model.ProdutoPedido;
import br.com.eccomerce.model.Venda;

public class TerminalGUI {
	static Scanner leitor = new Scanner(System.in);
	
	public static void menu() {
		boolean continuar = true;
		
	    // loop principal que exibe o menu enquanto 'continuar' for true
		while(continuar) {
			try {
				int escolha;
				linhaCompostaDupla();
				System.out.print("\n--- MENU --- \n" 
									+ "1. Produtos\n"
									+ "2. Pedidos\n"
									+ "3. Clientes\n"
									+ "4. Sair\n"
									+ "Sua escolha: ");
				escolha = leitor.nextInt();
				leitor.nextLine(); // Limpa o buffer
				linhaCompostaDupla();
				
				switch(escolha) {
				case 1:
					menuProduto();
					break;
				case 2:
					menuPedido();
					break;
				case 3: 
					menuCliente();
					break;
				case 4:
					System.out.println();
					linhaSimples();
					System.out.println("Saindo...");
					linhaSimples();
					continuar = false;
					break;
				default:
					linhaSimples();
					System.out.println("Escolha invalida");
					linhaSimples();
					break;
				}
			}
			catch(Exception e) {
				System.out.println();
				linhaComposta();
				System.out.println("VALOR DIGITADO INVALIDO");
				linhaComposta();
				if(leitor.hasNextLine());{
					leitor.nextLine();
				}
				
			}
			
			
		}
		leitor.close();
	}
	
	private static void menuProduto() {
		
		boolean continuar = true;
		while(continuar) {
			try {
				int escolha;
				System.out.print("\n--- MENU PRODUTO --- \n" 
									+ "1. Listar Produtos\n"
									+ "2. Adicionar Produtos\n"
									+ "3. Excluir Produtos\n"
									+ "4. Modificar Produtos\n"
									+ "5. Procurar pelo Nome\n"
									+ "6. Procurar pelo Preço\n"
									+ "7. Voltar\n"
									+ "Sua escolha: ");
				escolha = leitor.nextInt();
				
				switch(escolha) {
				case 1:
					System.out.println();
					linhaComposta();
					listarProduto();
					linhaComposta();
					break;
				case 2:
					System.out.println();
					linhaComposta();
					adicionarProduto();
					linhaComposta();
					break;
				case 3: 
					System.out.println();
					linhaComposta();
					excluirProduto();
					linhaComposta();
					break;
				case 4:
					System.out.println();
					linhaComposta();
					modificarProduto();
					linhaComposta();
					break;
				case 5:
					System.out.println();
					linhaComposta();
					procurarNomeProduto();
					linhaComposta();
					break;
				case 6:
					System.out.println();
					linhaComposta();
					procurarPrecoProduto();
					linhaComposta();
					break;
				case 7:
					System.out.println();
					linhaSimples();
					System.out.println("Voltando...");
					linhaSimples();
					continuar = false;
					break;
				default:
					System.out.println();
					linhaSimples();
					System.out.println("Escolha invalida");
					linhaSimples();
					System.out.println();
					linhaComposta();
					break;
				}
			}
			catch(InputMismatchException e) {
				System.out.println();
				linhaComposta();
				System.out.println("VALOR DIGITADO INVALIDO");
				linhaComposta();
				leitor.nextLine(); // Limpa o buffer
			}
			catch(Exception e) {
				System.out.println();
				linhaComposta();
				System.out.println("OCORREU UM ERRO " + e);
				linhaComposta();
				leitor.nextLine(); // Limpa o buffer
			}
		}
	}
	
	private static void menuPedido() {
		boolean continuar = true;
		while(continuar) {
			try {
				int escolha;
				System.out.print("\n--- MENU PEDIDO --- \n" 
									+ "1. Listar Pedidos\n"
									+ "2. Adicionar Pedidos\n"
									+ "3. Excluir Pedidos\n"
									+ "4. Modificar Pedidos\n"
									+ "5. Voltar\n"
									+ "Sua escolha: ");
				escolha = leitor.nextInt();
				
				switch(escolha) {
				case 1:
					System.out.println();
					linhaComposta();
					listarPedido();
					System.out.println();
					linhaComposta();
					break;
				case 2:
					System.out.println();
					linhaComposta();
					adicionarPeidido();
					System.out.println();
					linhaComposta();
					break;
				case 3: 
					System.out.println();
					linhaComposta();
					excluirPeidido();
					System.out.println();
					linhaComposta();
					break;
				case 4:
					System.out.println();
					linhaComposta();
					modificarPedido();
					System.out.println();
					linhaComposta();
					break;
				case 5:
					System.out.println();
					linhaSimples();
					System.out.println("Voltando...");
					linhaSimples();
					continuar = false;
					System.out.println();
					linhaComposta();
					break;
				default:
					System.out.println();
					linhaSimples();
					System.out.println("Escolha invalida");
					linhaSimples();
					System.out.println();
					linhaComposta();
					break;
				}
			}
			catch(InputMismatchException e) {
				System.out.println();
				linhaComposta();
				System.out.println("VALOR DIGITADO INVALIDO");
				linhaComposta();
				leitor.nextLine(); // Limpa o buffer
			}
			catch(Exception e) {
				System.out.println();
				linhaComposta();
				System.out.println("OCORREU UM ERRO " + e);
				linhaComposta();
				leitor.nextLine(); // Limpa o buffer
			}
		}

	}

	private static void menuCliente() {

		boolean continuar = true;
		while(continuar) {
			try {
				int escolha;
				System.out.print("\n--- MENU CLIENTE --- \n" 
									+ "1. Listar Cliente\n"
									+ "2. Adicionar Cliente\n"
									+ "3. Excluir Cliente\n"
									+ "4. Modificar Cliente\n"
									+ "5. Voltar\n"
									+ "Sua escolha: ");
				escolha = leitor.nextInt();
				
				switch(escolha) {
				case 1:
					System.out.println();
					linhaComposta();
					listarCliente();
					linhaComposta();
					break;
				case 2:
					System.out.println();
					System.out.println();
					linhaComposta();
					adicionarCliente();
					System.out.println();
					linhaComposta();
					break;
				case 3: 
					System.out.println();
					linhaComposta();
					excluirCliente();
					System.out.println();
					linhaComposta();
					break;
				case 4:
					System.out.println();
					linhaComposta();
					modificarCliente();
					System.out.println();
					linhaComposta();
					break;
				case 5:
					System.out.println();
					linhaSimples();
					System.out.println("Voltando...");
					linhaSimples();
					System.out.println();
					linhaComposta();
					continuar = false;
					break;
				default:
					System.out.println();
					linhaSimples();
					System.out.println("Escolha invalida");
					linhaSimples();
					System.out.println();
					linhaComposta();
					break;
				}
			}
			catch(InputMismatchException e) {
				System.out.println();
				linhaComposta();
				System.out.println("VALOR DIGITADO INVALIDO");
				linhaComposta();
				leitor.nextLine(); // Limpa o buffer
			}
			catch(Exception e) {
				System.out.println();
				linhaComposta();
				System.out.println("OCORREU UM ERRO " + e);
				linhaComposta();
				leitor.nextLine(); // Limpa o buffer
			}
		}

	}
	
	
	// PRODUTO
	private static void listarProduto() {
		try {
			// Cria uma lista com todos o produtos no banco de dados
			List<Produto> produtos = ProdutoDAO.listProduto();
			
			// Verifica se lista está vazia
			if(produtos.isEmpty()) {
				System.out.println();
				linhaSimples();
				System.out.println("Nenhum produto foi encontrado");
				linhaSimples();
			}
			else {
				// Imprime os produtos da lista com espaço entre eles até o penultimo produto
				int i = 1;
				for(Produto produto : produtos) {
					System.out.println(produto.toString());
					
					// Verifica se o produto NÃO é o último
					if(i != produtos.size()) {
						System.out.println();
					}
					i++;
				}
			}
		}
		catch(Exception e) {
			System.out.println();
			linhaComposta();
			System.out.println("OCORREU UM ERRO " + e);
			linhaComposta();
		}
	}

	private static void adicionarProduto() {
		try {
			// Lê os dados do produto
			System.out.print("Nome: ");
			
			if(leitor.hasNextLine()) { // Limpa buffer
				leitor.nextLine();
			}
			
			String nome = leitor.nextLine();
			
			System.out.print("Descrição: ");
			String descricao = leitor.nextLine();
			
			System.out.print("Valor: R$");
			double valor = leitor.nextDouble();
			
			// Verifica se o valor do produto é menor que 1
			if(valor < 1) {
				System.out.println();
				linhaSimples();
				System.out.println("Valor do produto invalido");
				linhaSimples();
				return;
			}
			
			System.out.print("Quantidade: ");
			int quantidade = leitor.nextInt();
			
			// Verifica se a quantidade é menor que zero
			if(quantidade < 0) {
				System.out.println();
				linhaSimples();
				System.out.println("Quantidade do produto invalida");
				linhaSimples();
				return;
			}

			Produto produto = new Produto(nome, descricao, valor, quantidade);
			
			try {
				ProdutoDAO.saveProduto(produto);
			}
			catch(Exception e) {
				System.out.println();
				linhaComposta();
				System.out.println("ERRO AO CADASTRAR PRODUTO: " + e.toString());
				linhaComposta();
			}
			
		}
		catch(InputMismatchException e) {
			System.out.println();
			linhaComposta();
			System.out.println("VALOR DIGITADO INVALIDO");
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
		catch(Exception e) {
			System.out.println();
			linhaComposta();
			System.out.println("OCORREU UM ERRO " + e);
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
	}

	private static void excluirProduto() {

		try {
			System.out.print("CODIGO DO PRODUTO: ");
			int codigo = leitor.nextInt();
			
			Produto produto = ProdutoDAO.getProduto(codigo);
			
			// Verifica se o produto adquirido está em branco
			if(produto.getPRO_CODIGO() == 0) {
				System.out.println();
				linhaSimples();
				System.out.println("Produto não encontrado");
				linhaSimples();
			}
			else {
				// Exibe o produto selecionado e pede confirmação de exclusão
				System.out.println(produto.toString());
				System.out.print("Deseja excluir(S/N)?  ");
				String resposta = leitor.next();
				System.out.println();
				
				if(resposta.toCharArray()[0] == 'S' || resposta.toCharArray()[0] == 's') {
					ProdutoDAO.deleteProduto(produto);
					System.out.println("Produto excluido com sucesso");
				}
				else {
					System.out.println("Nenhum produto foi excluido");
				}
			}		
		}
		catch(InputMismatchException e) {
			System.out.println();
			linhaComposta();
			System.out.print("VALOR DIGITADO INVALIDO");
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
		catch(Exception e) {
			System.out.println();
			linhaComposta();
			System.out.print("OCORREU UM ERRO " + e);
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
	}

	private static void modificarProduto() {
		try {
			System.out.print("CODIGO DO PRODUTO: ");
			int codigo = leitor.nextInt();
			
			Produto produto = ProdutoDAO.getProduto(codigo);
			
			// Verifica se o produto adquirido está em branco
			if(produto.getPRO_CODIGO() == 0) {
				System.out.println();
				linhaSimples();
				System.out.println("Produto não encontrado");
				linhaSimples();
			}
			else {
				// Exibe o produto selecionado e confirma modificação
				System.out.println(produto.toString());
				System.out.print("Deseja modificar(S/N)?  ");
				String resposta = leitor.next();
				System.out.println();
				
				if(resposta.toCharArray()[0] == 'S' || resposta.toCharArray()[0] == 's') {
					
					System.out.print("NOVO NOME: ");
					leitor.nextLine();
					String nome = leitor.nextLine();
					
					System.out.print("NOVA DESCRIÇÃO: ");
					String descricao = leitor.nextLine();
					
					System.out.print("NOVO VALOR: R$");
					double valor = leitor.nextDouble();
					
					if(valor < 1) {
						System.out.println();
						linhaSimples();
						System.out.println("Valor do produto invalido");
						linhaSimples();
						return;
					}
					
					System.out.print("NOVO ESTOQUE: ");
					int estoque = leitor.nextInt();
					
					if(estoque < 0) {
						System.out.println();
						linhaSimples();
						System.out.println("Quantidade do produto invalida");
						linhaSimples();
						return;
					}
					
					produto.setPRO_NOME(nome);
					produto.setPRO_DESCRICAO(descricao);
					produto.setPRO_VALOR(valor);
					produto.setPRO_ESTOQUE(estoque);
					
					ProdutoDAO.updateProduto(produto);
				}
				else {
					System.out.println("Nenhum produto foi modificado");
					return;
				}
			}
		}
		catch(InputMismatchException e) {
			System.out.println();
			linhaComposta();
			System.out.println("VALOR DIGITADO INVALIDO");
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
		catch(Exception e) {
			System.out.println();
			linhaComposta();
			System.out.println("OCORREU UM ERRO " + e);
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
	}

	private static void procurarNomeProduto() {
		try {
			System.out.print("Nome: ");
			if(leitor.hasNextLine()){
				leitor.nextLine();
			}
			String nome = leitor.nextLine();
			
			// Cria uma lista com todos os produtos com nome semelhante à pesquisa
			List<Produto> produtos = ProdutoDAO.listProduto(nome);
			
			// Verifica se a lista está vaiza
			if(produtos.isEmpty()) {
				System.out.println();
				linhaSimples();
				System.out.println("Nenhum produto encontrado");
				linhaSimples();
			}
			else {
				// Exibe os produtos da lista
				System.out.println();
				int i = 1;
				for(Produto produto : produtos) {
					System.out.println(produto.toString());
					if(i != produtos.size()) {
						System.out.println();
					}
					i++;
				}
			}
		}
		catch(InputMismatchException e) {
			System.out.println();
			linhaComposta();
			System.out.println("VALOR DIGITADO INVALIDO");
			linhaComposta();
		}
		catch(Exception e) {
			System.out.println();
			linhaComposta();
			System.out.println("OCORREU UM ERRO " + e);
			linhaComposta();
		}
	}
	
	private static void procurarPrecoProduto() {
		try {
			System.out.print("Preco minimo: ");
			double precoMinimo = leitor.nextDouble();
			
			System.out.print("Preco máximo: ");
			double precoMaximo = leitor.nextDouble();
			
			List<Produto> produtos = ProdutoDAO.listProduto(precoMinimo, precoMaximo);
			
			// Verifica se a lista está vazia
			if(produtos.isEmpty()) {
				System.out.println();
				linhaSimples();
				System.out.println("Nenhum produto encontrado");
				linhaSimples();
			}
			else {
				// Imprime todos os produtos da lista
				System.out.println();
				int i = 1;
				for(Produto produto : produtos) {
					System.out.println(produto.toString());
					if(i != produtos.size()) {
						System.out.println();
					}
					i++;
				}
			}
		}
		catch(InputMismatchException e) {
			System.out.println();
			linhaComposta();
			System.out.println("VALOR DIGITADO INVALIDO");
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
		catch(Exception e) {
			System.out.println();
			linhaComposta();
			System.out.println("OCORREU UM ERRO: " + e);
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
	}

	// PEDIDO
	private static void listarPedido(){
		try {
			List<Pedido> pedidos = PedidoDAO.listPedido();
			
			if(pedidos.isEmpty()) {
				// Verifica se a lista de pedidos está vazia
				System.out.println();
				linhaSimples();
				System.out.println("Nenhum pedido encontrado");
				linhaSimples();
			}
			else {
				// Exibe todos os elementos da lista
				for(Pedido pedido : pedidos) {
					Venda venda = new Venda(pedido.getPED_CODIGO());
					System.out.println(venda.toString());
				}
			}
		}
		catch(Exception e) {
			System.out.println();
			linhaComposta();
			System.out.println("OCORREU UM ERRO: " + e);
			linhaComposta();
		}
	}
	
	private static void adicionarPeidido() {
		try {
			List<Produto> produtos = new ArrayList<Produto>();
			int codigoCliente, codigoProduto;
			int nItens;
			int qtdeProduto;
			
			System.out.print("CODIGO DO CLIENTE: ");
			codigoCliente = leitor.nextInt();
			
			// Verifica se o cliete existe
			if(Cliente.existeCliente(codigoCliente)) {
				System.out.print("NUMERO DE ITENS: ");
				nItens = leitor.nextInt();
				
				// Verifica se a quantidade de itens vendidosé menor que um
				if(nItens < 1) {
					System.out.println();
					linhaSimples();
					System.out.println("Número de itens inválido");
					linhaSimples();
				}
				
				// Define a data atual e salva o pedido
				Date dataAtual = new Date();
				Pedido pedido = new Pedido(codigoCliente, dataAtual);
				PedidoDAO.savePedido(pedido);
				
				// Laço para salvar os produtos
				for(int i = 0; i < nItens; i++) {
					System.out.print("CODIGO DO PRODUTO: ");
					codigoProduto = leitor.nextInt();
					
					// Verifica se o produto existe e o adiciona a venda
					if(Produto.existeProduto(codigoProduto)) {
						produtos.add(ProdutoDAO.getProduto(codigoProduto));
						
						System.out.print("QUANTIDADE: ");
						qtdeProduto = leitor.nextInt();
						
						// Verifica se a quantidade é maior que 1
						if(qtdeProduto > 1) {
							
							// Verifica se ainda há estoque do produto e confirma se o produto deve ser adicionado
							if(Produto.emEstoque(codigoProduto, qtdeProduto)) {
								
								System.out.println("\n\n " + i+1 + " " + produtos.get(i) + "\n");
								
								System.out.print("Deseja adicionar esse produto(S/N)?  ");
								String resposta = leitor.next();
								System.out.println();
								
								if(resposta.toCharArray()[0] == 'S' || resposta.toCharArray()[0] == 's') {
									
									Pedido ultimoPedido = PedidoDAO.getLastPedido();
									ProdutoPedido produtoPedido = new ProdutoPedido(ultimoPedido.getPED_CODIGO(), codigoProduto, qtdeProduto);
									ProdutoPedidoDAO.saveProdutoPedido(produtoPedido);
									
									produtos.get(i).setPRO_ESTOQUE(produtos.get(i).getPRO_ESTOQUE() - qtdeProduto);
									for(Produto item : produtos) {
										ProdutoDAO.updateProduto(item);
									}
									
								}
								
							}
							
							else {
								System.out.println();
								linhaSimples();
								System.out.println("Quantidade maior que o estoque");
								linhaSimples();
								i--;
							}
						}
						
						else {
							System.out.println();
							linhaSimples();
							System.out.println("Não é possivel fazer venda de quantidade nula ou negativa");
							linhaSimples();
						}
					}
					
					else {
						System.out.println();
						linhaSimples();
						System.out.println("Produto não encontrado");
						linhaSimples();
						i--;
					}
				}				
			}
			
			else {
				System.out.println();
				linhaSimples();
				System.out.println("Cliente não localizado");
				linhaSimples();
			}
		}
		catch(InputMismatchException e) {
			System.out.println();
			linhaComposta();
			System.out.println("VALOR DIGITADO INVALIDO");
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
		catch(Exception e) {
			System.out.println();
			linhaComposta();
			System.out.println("OCORREU UM ERRO: " + e);
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
	}
	
	private static void excluirPeidido() {
		try {
			System.out.print("Digite o código do pedido: ");
			int codigo = leitor.nextInt();
			Pedido pedido = PedidoDAO.listPedido(codigo);
			
			// Verifica se o pedido existe
			if(pedido == null) {
				System.out.println();
				linhaSimples();
				System.out.println("Pedido não encontrado");
				linhaSimples();
			}
			else {
				Venda venda = new Venda(codigo);
				
				// Exibe a venda, confirma a excusão e exclui todos os produtoPedidos e o pedido em sí
				System.out.println(venda.toString());
				System.out.print("Deseja excluir(S/N)?  ");
				String resposta = leitor.next();
				System.out.println();
				
				if(resposta.toCharArray()[0] == 'S' || resposta.toCharArray()[0] == 's') {
					venda.deleteVenda();
					System.out.println("Venda excluida com sucesso");
				}
				else {
					System.out.println("Nenhuma venda foi excluida");
				}

			}
		}
		catch(InputMismatchException e) {
			System.out.println();
			linhaComposta();
			System.out.println("VALOR DIGITADO INVALIDO");
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
		catch(Exception e) {
			System.out.println();
			linhaComposta();
			System.out.println("OCORREU UM ERRO: " + e);
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
	}
	
	private static void modificarPedido() {
		try {
			// Objeto que guardará as alterações
			Pedido pedidoNovo = new Pedido();
			List<ProdutoPedido> produtosPedidosNovos = new ArrayList<ProdutoPedido>();
			
			// Busca do pedido que será modificado
			System.out.print("Digite o código do pedido: ");
			int codigoPedido = leitor.nextInt();
			
			// Objetos que trazem os dados antigos
			Pedido pedidoAntigo = PedidoDAO.listPedido(codigoPedido);
			
			// Verifica se o pedido é vazio
			if(pedidoAntigo.getPED_CODIGO() == 0) {
				System.out.println();
				linhaSimples();
				System.out.println("Pedido não encontrado");
				linhaSimples();
				return;
			}
			else {
				int codigoCliente, codigoProduto;
				int nItens;
				int qtdeProduto;
				
				System.out.print("CODIGO DO CLIENTE: ");
				codigoCliente = leitor.nextInt();

				Cliente testaCliente = ClienteDAO.getCliente(codigoCliente);
				
				// Verifica se o cliente é vazio
				if(testaCliente.getCLI_CODIGO() == 0) {
					System.out.println();
					linhaSimples();
					System.out.println("Cliente não encontrado");
					linhaSimples();
					return;
				}
				else {
					// Atualiza os dados que serão atualizados
					pedidoNovo.setCLI_CODIGO(codigoCliente);
					pedidoNovo.setPED_DATA(pedidoAntigo.getPED_DATA());
					
					System.out.print("NUMERO DE ITENS: ");
					nItens = leitor.nextInt();
					
					if(nItens < 1) {
						System.out.println();
						linhaSimples();
						System.out.println("Deve existir pelo menos um produto para cada pedido");
						linhaSimples();
						return;
					}
					
					// Laço para adicionar os novos itens
					for(int i = 0; i < nItens; i++) {
						System.out.print("CODIGO DO PRODUTO: ");
						codigoProduto = leitor.nextInt();
			
						// Verifica se o produto existe
						if(!Produto.existeProduto(codigoProduto)) {
							System.out.println();
							linhaSimples();
							System.out.println("Produto não localizado");
							linhaSimples();
							i--;
						}
						else {
							System.out.print("QUANTIDADE: ");
							qtdeProduto = leitor.nextInt();
							
							// Testa se o valor posto é valido
							if(qtdeProduto < 1) {
								System.out.println();
								linhaSimples();
								System.out.println("Não é possivel fazer venda de quantidade nula ou negativa");
								linhaSimples();
								i--;
							}
							else {
								ProdutoPedido produtoPedidoNovo = new ProdutoPedido(codigoPedido, codigoProduto, qtdeProduto);
								produtosPedidosNovos.add(produtoPedidoNovo);
							}
						}
					}
					
					Venda venda = new Venda(codigoPedido);
					
					// Exibe a venda, confirma a excusão e exclui todos os produtoPedidos e o pedido em sí
					System.out.println();
					System.out.println(venda.toStringModificada(produtosPedidosNovos));
					System.out.print("Deseja modificar(S/N)?  ");
					String resposta = leitor.next();
					System.out.println();
					
					if(resposta.toCharArray()[0] == 'S' || resposta.toCharArray()[0] == 's') {
						venda.modificaVenda(pedidoNovo, produtosPedidosNovos);
						System.out.println();
						linhaSimples();
						System.out.println("Venda modificada com sucesso");
						linhaSimples();
					}
					else {
						System.out.println();
						linhaSimples();
						System.out.println("Nenhuma venda foi modificada");
						linhaSimples();
					}
					
				}
				
			}
		}
		catch(InputMismatchException e) {
			System.out.println();
			linhaComposta();
			System.out.println("VALOR DIGITADO INVALIDO");
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
		catch(Exception e) {
			System.out.println();
			linhaComposta();
			System.out.println("OCORREU UM ERRO: " + e);
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
	}
	
	// CLIENTE
	private static void listarCliente() {
		try {
			List<Cliente> clientes = ClienteDAO.getCliente();
			
			// Verifica se a lista está vaiza
			if(clientes.isEmpty())  {
				System.out.println();
				linhaSimples();
				System.out.println("Nenhum cliente foi encontrado");
				linhaSimples();
			}
			else {
				// Imprime os elementos da lista
				int i = 1;
				for(Cliente cliente : clientes) {
					System.out.println(cliente.toString());
					if(i < clientes.size()) {
						System.out.println();
					}
					i++;
				}
			}
		}
		catch(Exception e) {
			System.out.println();
			linhaComposta();
			System.out.println("OCORREU UM ERRO: " + e);
			linhaComposta();
		}
	}

	private static void adicionarCliente() {
		try {
			System.out.print("Nome: ");
			if(leitor.hasNextLine()) {
				leitor.nextLine();
			}
			String nome = leitor.nextLine();
			
			System.out.print("Email: ");
			String email = leitor.nextLine();
			
			System.out.print("Endereco: ");
			String endereco = leitor.nextLine();
			
			System.out.print("Telefone: ");
			String telefone= leitor.nextLine();
			
			Cliente cliente = new Cliente(nome, email, endereco, telefone);
			
			ClienteDAO.saveCliente(cliente);
		}
		catch(InputMismatchException e) {
			System.out.println();
			linhaComposta();
			System.out.println("VALOR DIGITADO INVALIDO");
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
		catch(Exception e) {
			System.out.println();
			linhaComposta();
			System.out.println("OCORREU UM ERRO " + e);
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
	}

	private static void excluirCliente() {
		try {
			System.out.print("CODIGO DO CLIENTE: ");
			int codigo = leitor.nextInt();
			
			Cliente cliente = ClienteDAO.getCliente(codigo);
			
			// Verifica se o cliente está em branco
			if(cliente.getCLI_CODIGO() == 0) {
				System.out.println();
				linhaSimples();
				System.out.println("Cliente não encontrado");
				linhaSimples();
			}
			else {
				// Exibe o cliente selecionado e confirma a exclusão
				System.out.println(cliente.toString());
				System.out.print("Deseja excluir(S/N)?  ");
				String resposta = leitor.next();
				System.out.println();
				
				if(resposta.toCharArray()[0] == 'S' || resposta.toCharArray()[0] == 's') {
					ClienteDAO.deleteCliente(cliente);
					System.out.print("CLiente excluido com sucesso");
				}
				else {
					System.out.print("Nenhum Cliente foi excluido");
				}
			}
		}
		catch(InputMismatchException e) {
			System.out.println();
			linhaComposta();
			System.out.println("VALOR DIGITADO INVALIDO");
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
		catch(Exception e) {
			System.out.println();
			linhaComposta();
			System.out.println("OCORREU UM ERRO " + e);
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
	}

	private static void modificarCliente() {
		try {
			System.out.print("CODIGO DO CLIENTE: ");
			int codigo = leitor.nextInt();
			
			Cliente cliente= ClienteDAO.getCliente(codigo);
			
			if(cliente.getCLI_CODIGO() == 0) {
				// Confere se o cliente está vazio
				System.out.println();
				linhaSimples();
				System.out.println("Cliente não encontrado");
				linhaSimples();
			}
			else {
				// Exibe o cliente e confirma a modificação
				System.out.println(cliente.toString());
				System.out.print("Deseja modificar(S/N)?  ");
				String resposta = leitor.next();
				System.out.println();
				
				if(resposta.toCharArray()[0] == 'S' || resposta.toCharArray()[0] == 's') {
					
					System.out.print("NOVO NOME: ");
					leitor.nextLine();
					String nome = leitor.nextLine();
					
					System.out.print("NOVA EMAIL: ");
					String email = leitor.nextLine();
					
					System.out.print("NOVO ENDERECO: ");
					String endereco = leitor.nextLine();
					
					System.out.print("NOVO TELEFONE: ");
					String telefone = leitor.nextLine();
					
					cliente.setCLI_NOME(nome);
					cliente.setCLI_EMAIL(email);
					cliente.setCLI_ENDERECO(endereco);
					cliente.setCLI_TELEFONE(telefone);
					
					ClienteDAO.updateCliente(cliente);
					System.out.print("Cliente modificado com sucesso");
				}
				else {
					System.out.print("Nenhum cliente foi modificado");
					return;
				}
			}
		}
		catch(InputMismatchException e) {
			System.out.println();
			linhaComposta();
			System.out.println("VALOR DIGITADO INVALIDO");
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
		catch(Exception e) {
			System.out.println();
			linhaComposta();
			System.out.println("OCORREU UM ERRO " + e);
			linhaComposta();
			leitor.nextLine(); // Limpa o buffer
		}
	}

	// LINHAS
	private static void linhaSimples() {
		System.out.print("--------------------\n");
	}
	
	private static void linhaComposta() {
		System.out.print("====================\n");
	}

	private static void linhaCompostaDupla() {
		System.out.print("\n====================\n");
		System.out.print("====================\n");
	}
}
