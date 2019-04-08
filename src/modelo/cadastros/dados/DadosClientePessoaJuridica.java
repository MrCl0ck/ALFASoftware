package modelo.cadastros.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.Banco;
import modelo.cadastros.cliente.ModeloClientePessoaFisica;
import modelo.cadastros.cliente.ModeloClientePessoaJuridica;
import modelo.tableModel.ClienteFisicoTable;
import modelo.tableModel.ClienteJuridicoTable;

public class DadosClientePessoaJuridica {
	private static ClienteJuridicoTable clienteTabela = new ClienteJuridicoTable();
	private static Banco banco = new Banco();
	
	public DadosClientePessoaJuridica() {
		getClientesJuridicos();	
		getClientesNaTabela();
	}
	
	//------------------------------------FUNÇÕES TABELA-------------------------------------------------------------
	public void bancoDeDadosIncluir(ModeloClientePessoaJuridica clienteJuridico) {	
		boolean retornoFuncao = false;
		
		try {
		retornoFuncao =	banco.inserir("endereco", // Tabela
						"`cep`, `numero`, `logradouro`, `bairro`, `complemento`, `cidade`, `uf`",
						"'" + clienteJuridico.getCep() + "','" + clienteJuridico.getNumeroEndereco() + "','"
							+ clienteJuridico.getLogradouro() + "','" + clienteJuridico.getBairro()
							+ "','" + clienteJuridico.getComplemento() + "','"
							+ clienteJuridico.getCidade() + "','" + clienteJuridico.getUf_estado()
						    + "'");

				String id = banco.primeiroEultimo("endereco", "id", 1);

		retornoFuncao =	banco.inserir("cliente",
						"`cpf`, `cnpj`, `razaosocial`, `nome`, `inscricaoestadual`, `rg`, `representante`, `situacao`, `datanasc`, `sexo`, `uf_rg`, `orgaoexpedidor`, `email`, `limitecredito`, `telefone`, `ENDERECO_id`",
						"'" + null + "','" + clienteJuridico.getCnpj() + "','" + clienteJuridico.getRazaoSocial() + "','"
							+ null + "','" + clienteJuridico.getInscricaoEstadual() + "','" + null
							+ "','" + clienteJuridico.getRepresentante() + "','" + clienteJuridico.getSituacao() + "','"
							+ null + "','" + null
							+ "','" + clienteJuridico.getInscricaoEstadualUF() + "','"
							+ null + "','" + clienteJuridico.getEmail()
							+ "','" + clienteJuridico.getLimiteCredito() + "','"
				     		+ clienteJuridico.getTelefone() + "','" + id + "'");
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		if(retornoFuncao == true) {
			setClientes();
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);	
		}		
	}
	
	public void bancoDeDadosAlterar(ModeloClientePessoaJuridica clienteJuridicoAtual, String cnpjBusca, String idBusca) {
		boolean retornoFuncao = false;
		
		retornoFuncao = banco.atualizar("cliente", "cnpj", cnpjBusca, "situacao='" + clienteJuridicoAtual.getSituacao() + "',cnpj='" + clienteJuridicoAtual.getCnpj() + "',razaosocial='" + clienteJuridicoAtual.getRazaoSocial() + "',representante='" + clienteJuridicoAtual.getRepresentante() + "',inscricaoestadual='" + clienteJuridicoAtual.getInscricaoEstadual() + "',uf_rg='" + clienteJuridicoAtual.getInscricaoEstadualUF() + "',telefone='" + clienteJuridicoAtual.getTelefone() + "',email='" + clienteJuridicoAtual.getEmail() + "',limitecredito='" + clienteJuridicoAtual.getLimiteCredito() + "'");
		retornoFuncao = banco.atualizar("endereco", "id", idBusca, "cep='" + clienteJuridicoAtual.getCep() + "',logradouro='" + clienteJuridicoAtual.getLogradouro() + "',numero='" + clienteJuridicoAtual.getNumeroEndereco() + "',bairro='" + clienteJuridicoAtual.getBairro() + "',complemento='" + clienteJuridicoAtual.getComplemento() + "',cidade='" + clienteJuridicoAtual.getCidade() + "',uf='" + clienteJuridicoAtual.getUf_estado() + "'");
		
		if(retornoFuncao == true) {
			JOptionPane.showMessageDialog(null, "Alteração do registro de cliente feita com sucesso!", "Alteração", JOptionPane.INFORMATION_MESSAGE);
			setClientes();
		}		
	}
	
	public boolean bancoDeDadosExcluir(String cnpjBusca, String idBusca) {
		boolean retornoFuncao = false;
		
		retornoFuncao = banco.excluir("cliente", "cnpj", cnpjBusca);		
		retornoFuncao = banco.excluir("endereco", "id", idBusca);
		
		if(retornoFuncao == true) {
			JOptionPane.showMessageDialog(null, "Exclusão do registro de cliente feita com sucesso!", "Alteração", JOptionPane.INFORMATION_MESSAGE);
			setClientes();
			return true;
		}		
		else {
			return false;
		}
	}
	//---------------------------------------------------------------------------------------------------------------
	//------------------------------------FUNÇÕES TABELA-------------------------------------------------------------
	
		public void adicionarClienteTabela(ModeloClientePessoaJuridica cliente) {
			clienteTabela.addCliente(cliente);
		}
		
		public ClienteJuridicoTable getClientesNaTabela() {
			return clienteTabela;
		}
		
		//---------------------------------------------------------------------------------------------------------------
	
	
		//------------------------------------FUNÇÕES ARRAYLIST-------------------------------------------------------------

		
		//-------------------------------------------------------------------------------------------------
		//GET E SET ARRAYLIST GERAL DESSA CLASSE, PEGAR OS VALORES CONTIDOS NO BANCO DE DADOS E ATUALIZA.
		
		public ArrayList<ModeloClientePessoaJuridica> getClientesJuridicos(){
			return banco.consultarClienteJuridico();
		}	
		
		public static void setClientes(){
			banco.consultarClienteJuridico();
		}
		
		//-------------------------------------------------------------------------------------------------
		
		//------------------------------------FUNÇÕES DE PESQUISA-------------------------------------------------------------
		
		public static ModeloClientePessoaJuridica buscaArrayGeralPorCnpjEInscricaoEstadual(ModeloClientePessoaJuridica clienteASerBuscado) {
			for (ModeloClientePessoaJuridica u: banco.consultarClienteJuridico()) {
				if(u.getCnpj().equals(clienteASerBuscado.getCnpj()) && u.getInscricaoEstadual().equals(clienteASerBuscado.getInscricaoEstadual())) {
					return u;
				}				
			}
			return null;
		}
		
		public static ModeloClientePessoaJuridica buscaArrayGeralRazaoSocialContem(ModeloClientePessoaJuridica clienteASerBuscado) {
			for (ModeloClientePessoaJuridica u: banco.consultarClienteJuridico()) {
				if(u.getRazaoSocial().equals(clienteASerBuscado.getRazaoSocial())) {
					return u;
				}				
			}
			return null;
		}
}
