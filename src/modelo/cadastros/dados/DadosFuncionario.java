package modelo.cadastros.dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.Banco;
import modelo.cadastros.funcionario.ModeloFuncionario;

public class DadosFuncionario {

	private static FuncionarioTable FuncionarioTabela = new FuncionarioTable();
	private static Banco banco = new Banco();
	
	public DadosFuncionario() {
		getFuncionarios();
		getFuncionariosNaTabela();
	}

	// ------------------------------------FUNÇÕES TABELA-------------------------------------------------------------

		public void bancoDeDadosIncluir(ModeloFuncionario funcionario) {
			boolean retornoFuncao = false;

			try {
				retornoFuncao = banco.inserir("endereco", // Tabela, a inserção de email e telefone está sendo feita na
															// tabela de cliente fisico
						"`cep`, `numero`, `logradouro`, `bairro`, `complemento`, `cidade`, `uf`",
						"'" + funcionario.getCep() + "','" + funcionario.getNumeroEndereco() + "','"
								+ funcionario.getLogradouro() + "','" + funcionario.getBairro() + "','"
								+ funcionario.getComplemento() + "','" + funcionario.getCidade() + "','"
								+ funcionario.getUf_estado() + "'");

				String id = banco.primeiroEultimo("endereco", "id", 1);
				
				retornoFuncao = banco.inserir("cargo", "`nome`", funcionario.getCargo());
				
				String idCargo = banco.primeiroEultimo("cargo", "id", 1);

				retornoFuncao = banco.inserir("funcionario",
						"`cpf`, `nome`, `rg`, `uf_rg`, `orgaoexpedidor`, `dataexpedicao`, `nacionalidade`, `naturalidade`, `datanasc`, `sexo`, `ctps`, `dataadmissao`, `cargo`, `telefone`, `email`, `setor`, `salario`, `usuario`, `senha`, `CARGO_id`, `ENDERECO_id`",
						"'" + funcionario.getCpf() + "','" + funcionario.getNome() +  "','"
								+ funcionario.getRg() + "','" + funcionario.getUfRg() + "','" + funcionario.getOrgaoExpeditor()+ "','" + funcionario.getDataExpedicaoRg()+ "','" + funcionario.getNacionalidade()+ "','" + funcionario.getNaturalidade()
								+ "','" + funcionario.getDataDeNascimento() + "','" + funcionario.getSexo() + "','" + funcionario.getCtps() + "','" + funcionario.getDataDeAdmisao() + "','" + null+ "','" 
								+ funcionario.getTelefone() + "','" + funcionario.getEmail() + "','" + funcionario.getSetor() + "','"
								+ funcionario.getSalario() + "','" + funcionario.getNomeDeUsuario() + "','" + funcionario.getSenha() + "','" + idCargo + "','" + id + "'");
			} catch (Exception e) {
				// TODO: handle exception
			}

			if (retornoFuncao == true) {
				JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!", "Cadastrado",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

		//Parei aqui
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public void bancoDeDadosAlterar(ModeloFuncionario funcionarioAtual, String cpfBusca, String idBusca) {
			boolean retornoFuncao = false;

			retornoFuncao = banco.atualizar("fornecedor", "cpf", cpfBusca,
					"situacao='" + fornecedorFisicoAtual.getSituacao() + "',nome='" + fornecedorFisicoAtual.getNome() + "',cpf='"
							+ fornecedorFisicoAtual.getCpf() + "',datanasc='" + fornecedorFisicoAtual.getDataNascimento()
							+ "',sexo='" + fornecedorFisicoAtual.getSexo() + "',rg='" + fornecedorFisicoAtual.getRg()
							+ "',uf_rg='" + fornecedorFisicoAtual.getUfRg() + "',orgaoexpedidor='"
							+ fornecedorFisicoAtual.getOrgaoExpeditorRg() + "',telefone='" + fornecedorFisicoAtual.getTelefone()
							+ "',email='" + fornecedorFisicoAtual.getEmail() + "',ramoatividade='"
							+ fornecedorFisicoAtual.getRamoAtividade() + "',fax='"
							+ fornecedorFisicoAtual.getFax() + "'");
			
			retornoFuncao = banco.atualizar("endereco", "id", idBusca,
					"cep='" + fornecedorFisicoAtual.getCep() + "',logradouro='" + fornecedorFisicoAtual.getLogradouro()
							+ "',numero='" + fornecedorFisicoAtual.getNumeroEndereco() + "',bairro='"
							+ fornecedorFisicoAtual.getBairro() + "',complemento='" + fornecedorFisicoAtual.getComplemento()
							+ "',cidade='" + fornecedorFisicoAtual.getCidade() + "',uf='" + fornecedorFisicoAtual.getUf_estado()
							+ "'");

			if (retornoFuncao == true) {
				JOptionPane.showMessageDialog(null, "Alteração do registro de fornecedor feita com sucesso!", "Alteração",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

		public boolean bancoDeDadosExcluir(String cpfBusca, String idBusca) {
			boolean retornoFuncao = false;

			retornoFuncao = banco.excluir("fornecedor", "cpf", cpfBusca);
			retornoFuncao = banco.excluir("endereco", "id", idBusca);

			if (retornoFuncao == true) {
				JOptionPane.showMessageDialog(null, "Exclusão do registro de fornecedor feita com sucesso!", "Exclusão",
						JOptionPane.INFORMATION_MESSAGE);
				return true;
			} else {
				return false;
			}
		}
		// ---------------------------------------------------------------------------------------------------------------

		// ------------------------------------FUNÇÕES TABELA-------------------------------------------------------------

		public void adicionarFornecedorTabela(ModeloFornecedorFisica fornecedor) {
			fornecedorTabela.addFornecedor(fornecedor);
		}

		public FornecedorFisicoTable getFornecedoresNaTabela() {
			return fornecedoresTabela;
		}

		// ---------------------------------------------------------------------------------------------------------------

		// ------------------------------------FUNÇÕES ARRAYLIST-------------------------------------------------------------

		// -------------------------------------------------------------------------------------------------

		// GET E SET ARRAYLIST GERAL DESSA CLASSE, PEGAR OS VALORES CONTIDOS NO BANCO DE DADOS E ATUALIZA.

		public ArrayList<ModeloFornecedorFisica> getFornecedoresFisicos() {
			return banco.consultarFornecedorFisico();
		}

		public static void setFornecedores() {
			banco.consultarFornecedorFisico();
		}

		// -------------------------------------------------------------------------------------------------

		// ------------------------------------FUNÇÕES DE PESQUISA-------------------------------------------------------------

		public static ModeloFornecedorFisica buscaArrayGeralPorCpfERg(ModeloFornecedorFisica fornecedorASerBuscado) {
			for (ModeloFornecedorFisica u : banco.consultarFornecedorFisico()) {
				if (u.getCpf().equals(fornecedorASerBuscado.getCpf()) && u.getRg().equals(fornecedorASerBuscado.getRg())) {
					return u;
				}
			}
			return null;
		}

		public static ModeloFornecedorFisica buscaArrayGeralNomeContem(ModeloFornecedorFisica fornecedorASerBuscado) {
			for (ModeloFornecedorFisica u : banco.consultarFornecedorFisico()) {
				if (u.getNome().equals(fornecedorASerBuscado.getNome())) {
					return u;
				}
			}
			return null;
		}
}
