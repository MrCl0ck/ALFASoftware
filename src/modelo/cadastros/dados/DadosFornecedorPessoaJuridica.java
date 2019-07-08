package modelo.cadastros.dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.Banco;
import modelo.cadastros.fornecedor.ModeloFornecedorJuridica;
import modelo.tableModel.JuridicoTable;
import modelo.tableModel.JuridicoTable_Fornecedor;

public class DadosFornecedorPessoaJuridica {

	private static JuridicoTable_Fornecedor fornecedorTabela = new JuridicoTable_Fornecedor();
	private static Banco banco = new Banco();
	
	public DadosFornecedorPessoaJuridica() {
		getFornecedoresJuridicos();	
		getFornecedoresNaTabela();
	}
	
	public void bancoDeDadosIncluir(ModeloFornecedorJuridica fornecedorJuridico) {	
		boolean retornoFuncao = false;
		
		try {
		retornoFuncao =	banco.inserir("endereco", // Tabela
						"`cep`, `numero`, `logradouro`, `bairro`, `complemento`, `cidade`, `uf`",
						"'" + fornecedorJuridico.getCep() + "','" + fornecedorJuridico.getNumeroEndereco() + "','"
							+ fornecedorJuridico.getLogradouro() + "','" + fornecedorJuridico.getBairro()
							+ "','" + fornecedorJuridico.getComplemento() + "','"
							+ fornecedorJuridico.getCidade() + "','" + fornecedorJuridico.getUf_estado()
						    + "'");

				String id = banco.primeiroEultimo("endereco", "id", 1);

		retornoFuncao =	banco.inserir("fornecedor",
				"`cpf`, `cnpj`, `nome`, `razaosocial`, `rg`, `representante`, `uf_rg`, `orgaoexpedidor`, `sexo`, `datanasc`, `telefone`, `fax`, `email`, `situacao`, `ramoatividade`, `ENDERECO_id`",
						"'" + null + "','" + fornecedorJuridico.getCnpj() + "','" + null + "','"
							+ fornecedorJuridico.getRazaoSocial() + "','" + null + "','" + fornecedorJuridico.getRepresentante()
							+ "','" + null + "','" + null + "','"
							+ null + "','" + null
							+ "','" + fornecedorJuridico.getTelefone() + "','"
							+ fornecedorJuridico.getFax() + "','" + fornecedorJuridico.getEmail()
							+ "','" + fornecedorJuridico.getSituacao() + "','"
				     		+ fornecedorJuridico.getRamoAtividade() + "','" + id + "'");
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		if(retornoFuncao == true) {
			setFornecedores();
			JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);	
		}		
	}
	
	public void bancoDeDadosAlterar(ModeloFornecedorJuridica fornecedorJuridicoAtual, String cnpjBusca, String idBusca) {
		boolean retornoFuncao = false;
		
		retornoFuncao = banco.atualizar("fornecedor", "cnpj", cnpjBusca,
				"situacao='" + fornecedorJuridicoAtual.getSituacao() + "',razaosocial='" + fornecedorJuridicoAtual.getRamoAtividade() + "',cnpj='"
						+ fornecedorJuridicoAtual.getCnpj() + "',telefone='" + fornecedorJuridicoAtual.getTelefone()
						+ "',email='" + fornecedorJuridicoAtual.getEmail() + "',ramoatividade='"
						+ fornecedorJuridicoAtual.getRamoAtividade() + "',fax='"
						+ fornecedorJuridicoAtual.getFax() + "',telefone='" + fornecedorJuridicoAtual.getRepresentante()
						+ "'");
		
		retornoFuncao = banco.atualizar("endereco", "id", idBusca, "cep='" + fornecedorJuridicoAtual.getCep() + "',logradouro='" + fornecedorJuridicoAtual.getLogradouro() + "',numero='" + fornecedorJuridicoAtual.getNumeroEndereco() + "',bairro='" + fornecedorJuridicoAtual.getBairro() + "',complemento='" + fornecedorJuridicoAtual.getComplemento() + "',cidade='" + fornecedorJuridicoAtual.getCidade() + "',uf='" + fornecedorJuridicoAtual.getUf_estado() + "'");
		
		if(retornoFuncao == true) {
			JOptionPane.showMessageDialog(null, "Alteração do registro de fornecedor feita com sucesso!", "Alteração", JOptionPane.INFORMATION_MESSAGE);
			setFornecedores();
		}		
	}
	
	public boolean bancoDeDadosExcluir(String cnpjBusca, String idBusca) {
		boolean retornoFuncao = false;
		
		retornoFuncao = banco.excluir("fornecedor", "cnpj", cnpjBusca);		
		retornoFuncao = banco.excluir("endereco", "id", idBusca);
		
		if(retornoFuncao == true) {
			JOptionPane.showMessageDialog(null, "Exclusão do registro de fornecedor feita com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
			setFornecedores();
			return true;
		}		
		else {
			return false;
		}
	}
	//---------------------------------------------------------------------------------------------------------------
	//------------------------------------FUNÇÕES TABELA-------------------------------------------------------------
	
		public void adicionarFornecedorTabela(ModeloFornecedorJuridica fornecedor) {
			fornecedorTabela.addFornecedor(fornecedor);
		}
		
		public JuridicoTable_Fornecedor getFornecedoresNaTabela() {
			return fornecedorTabela;
		}
		
		//---------------------------------------------------------------------------------------------------------------
	
	
		//------------------------------------FUNÇÕES ARRAYLIST-------------------------------------------------------------

		
		//-------------------------------------------------------------------------------------------------
		//GET E SET ARRAYLIST GERAL DESSA CLASSE, PEGAR OS VALORES CONTIDOS NO BANCO DE DADOS E ATUALIZA.
		
		public ArrayList<ModeloFornecedorJuridica> getFornecedoresJuridicos(){
			return banco.consultarFornecedorJuridico();
		}	
		
		public static void setFornecedores(){
			banco.consultarFornecedorJuridico();
		}
		
		//-------------------------------------------------------------------------------------------------
		
		//------------------------------------FUNÇÕES DE PESQUISA-------------------------------------------------------------
		
		public static ModeloFornecedorJuridica buscaArrayGeralPorCnpj(ModeloFornecedorJuridica fornecedorASerBuscado) {
			for (ModeloFornecedorJuridica u: banco.consultarFornecedorJuridico()) {
				if(u.getCnpj().equals(fornecedorASerBuscado.getCnpj())) {
					return u;
				}				
			}
			return null;
		}
		
		public static ModeloFornecedorJuridica buscaArrayGeralRazaoSocialContem(ModeloFornecedorJuridica fornecedorASerBuscado) {
			for (ModeloFornecedorJuridica u: banco.consultarFornecedorJuridico()) {
				if(u.getRazaoSocial().equals(fornecedorASerBuscado.getRazaoSocial())) {
					return u;
				}				
			}
			return null;
		}

}
