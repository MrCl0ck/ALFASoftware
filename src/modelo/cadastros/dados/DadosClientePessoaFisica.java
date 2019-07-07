package modelo.cadastros.dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.Banco;
import modelo.cadastros.cliente.ModeloClientePessoaFisica;
import modelo.tableModel.FisicoTable;

public class DadosClientePessoaFisica {
	private static FisicoTable clienteTabela = new FisicoTable();
	private static Banco banco = new Banco();
	
	public DadosClientePessoaFisica() {
		getClientesFisicos();	
		getClientesNaTabela();
	}
	
	//------------------------------------FUNÇÕES TABELA-------------------------------------------------------------
	
	public void bancoDeDadosIncluir(ModeloClientePessoaFisica clienteFisico) {	
		boolean retornoFuncao = false;
		
		try {
		retornoFuncao =	banco.inserir("endereco", // Tabela, a inserção de email e telefone está sendo feita na tabela de cliente fisico
						"`cep`, `numero`, `logradouro`, `bairro`, `complemento`, `cidade`, `uf`",
						"'" + clienteFisico.getCep() + "','" + clienteFisico.getNumeroEndereco() + "','"
							+ clienteFisico.getLogradouro() + "','" + clienteFisico.getBairro()
							+ "','" + clienteFisico.getComplemento() + "','"
							+ clienteFisico.getCidade() + "','" + clienteFisico.getUf_estado()
						    + "'");

				String id = banco.primeiroEultimo("endereco", "id", 1);

		retornoFuncao =	banco.inserir("cliente",
						"`cpf`, `cnpj`, `razaosocial`, `nome`, `inscricaoestadual`, `rg`, `representante`, `situacao`, `datanasc`, `sexo`, `uf_rg`, `orgaoexpedidor`, `email`, `limitecredito`, `telefone`, `ENDERECO_id`",
						"'" + clienteFisico.getCpf() + "','" + null + "','" + null + "','"
							+ clienteFisico.getNome() + "','" + null + "','" + clienteFisico.getRg()
							+ "','" + null + "','" + clienteFisico.getSituacao() + "','"
							+ clienteFisico.getDataNascimento() + "','" + clienteFisico.getSexo()
							+ "','" + clienteFisico.getUfRg() + "','"
							+ clienteFisico.getOrgaoExpeditorRg() + "','" + clienteFisico.getEmail()
							+ "','" + clienteFisico.getLimiteCredito() + "','"
				     		+ clienteFisico.getTelefone() + "','" + id + "'");
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		if(retornoFuncao == true) {
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);	
		}		
	}
	
	public void bancoDeDadosAlterar(ModeloClientePessoaFisica clienteFisicoAtual, String cpfBusca, String idBusca) {
		boolean retornoFuncao = false;
		
		retornoFuncao = banco.atualizar("cliente", "cpf", cpfBusca, "situacao='" + clienteFisicoAtual.getSituacao() + "',nome='" + clienteFisicoAtual.getNome() + "',cpf='" + clienteFisicoAtual.getCpf() + "',datanasc='" + clienteFisicoAtual.getDataNascimento() + "',sexo='" + clienteFisicoAtual.getSexo() + "',rg='" + clienteFisicoAtual.getRg() + "',uf_rg='" + clienteFisicoAtual.getUfRg() + "',orgaoexpedidor='" + clienteFisicoAtual.getOrgaoExpeditorRg() + "',telefone='" + clienteFisicoAtual.getTelefone() + "',email='" + clienteFisicoAtual.getEmail() + "',limitecredito='" + clienteFisicoAtual.getLimiteCredito() + "'");
		retornoFuncao = banco.atualizar("endereco", "id", idBusca, "cep='" + clienteFisicoAtual.getCep() + "',logradouro='" + clienteFisicoAtual.getLogradouro() + "',numero='" + clienteFisicoAtual.getNumeroEndereco() + "',bairro='" + clienteFisicoAtual.getBairro() + "',complemento='" + clienteFisicoAtual.getComplemento() + "',cidade='" + clienteFisicoAtual.getCidade() + "',uf='" + clienteFisicoAtual.getUf_estado() + "'");
		
		if(retornoFuncao == true) {
			//JOptionPane.showMessageDialog(null, "Alteração do registro de cliente feita com sucesso!", "Alteração", JOptionPane.INFORMATION_MESSAGE);
		}		
	}
	
	public boolean bancoDeDadosExcluir(String cpfBusca, String idBusca) {
		boolean retornoFuncao = false;
		
		retornoFuncao = banco.excluir("cliente", "cpf", cpfBusca);		
		retornoFuncao = banco.excluir("endereco", "id", idBusca);
		
		if(retornoFuncao == true) {
			//JOptionPane.showMessageDialog(null, "Exclusão do registro de cliente feita com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}		
		else {
			return false;
		}
	}
	//---------------------------------------------------------------------------------------------------------------

	//------------------------------------FUNÇÕES TABELA-------------------------------------------------------------
	
	public void adicionarClienteTabela(ModeloClientePessoaFisica cliente) {
		clienteTabela.addCliente(cliente);
	}
	
	public FisicoTable getClientesNaTabela() {
		return clienteTabela;
	}
	
	//---------------------------------------------------------------------------------------------------------------
	
	//------------------------------------FUNÇÕES ARRAYLIST-------------------------------------------------------------

	//-------------------------------------------------------------------------------------------------
	
	//GET E SET ARRAYLIST GERAL DESSA CLASSE, PEGAR OS VALORES CONTIDOS NO BANCO DE DADOS E ATUALIZA.
	
	public ArrayList<ModeloClientePessoaFisica> getClientesFisicos(){
		return banco.consultarClienteFisico();
	}	
	
	public static void setClientes(){
		banco.consultarClienteFisico();
	}
	
	//-------------------------------------------------------------------------------------------------
	
	//------------------------------------FUNÇÕES DE PESQUISA-------------------------------------------------------------
	
	public static ModeloClientePessoaFisica buscaArrayGeralPorCpfERg(ModeloClientePessoaFisica clienteASerBuscado) {
		for (ModeloClientePessoaFisica u:banco.consultarClienteFisico()) {
			if(u.getCpf().equals(clienteASerBuscado.getCpf()) && u.getRg().equals(clienteASerBuscado.getRg())) {
				return u;
			}				
		}
		return null;
	}
	
	public static ModeloClientePessoaFisica buscaArrayGeralNomeContem(ModeloClientePessoaFisica clienteASerBuscado) {
		for (ModeloClientePessoaFisica u: banco.consultarClienteFisico()) {
			if(u.getNome().equals(clienteASerBuscado.getNome())) {
				return u;
			}				
		}
		return null;
	}
}
