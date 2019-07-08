package modelo.cadastros.validacoes;

import javax.swing.JOptionPane;

import modelo.cadastros.dados.DadosFornecedorPessoaFisica;
import modelo.cadastros.fornecedor.ModeloFornecedorFisica;

public class ValidacaoFornecedorPessoaFisica {

	private ModeloFornecedorFisica fornecedor;
	private boolean resultadoValidacaoTodosCamposGeral;
	private boolean resultadoValidacaoCpfRg;
	
	public ValidacaoFornecedorPessoaFisica(ModeloFornecedorFisica cliente) {
		this.fornecedor = fornecedor;
		setResultadoValidacaoTodosCamposGeral(validacaoTodosCamposGeral());	
	}

	public void validarCPF() {
		setResultadoValidacaoCpfRg(validacaoCpfRg());
	}
	
	public boolean validacaoTodosCamposGeral() {
		boolean resultado = true;
		String errosConcatenados = "";
		
		if(fornecedor.getSituacao().equals("Selecione")) {
			errosConcatenados += "Escolha uma opção da lista 'Situação'!\n";
			resultado = false;
		}
		if(fornecedor.getNome().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Nome'!\n";
			resultado = false;
		}
		if(fornecedor.getDataNascimento().trim().length() < 5) {
			errosConcatenados += "Preencha o campo 'Data de Nascimento'!\n";
			resultado = false;
		}
		if(fornecedor.getSexo().equals("Selecione")) {
			errosConcatenados += "Escolha uma opção da lista 'Sexo'!\n";
			resultado = false;
		}
		if(fornecedor.getCpf().trim().length() < 11) {//----------------------
			errosConcatenados += "Preencha o campo 'CPF'!\n";
			resultado = false;
		}
		if(fornecedor.getRg().trim().length() <= 9 ) {//---------------------
			errosConcatenados += "Preencha o campo 'RG'!\n";
			resultado = false;
		}
		if(fornecedor.getUfRg().equals("Selecione")) {
			errosConcatenados += "Escolha uma opção da lista 'UF'!\n";
			resultado = false;
		}
		if(fornecedor.getOrgaoExpeditorRg().equals("")) {
			errosConcatenados += "Preencha o campo 'Órgão Expeditor'!\n";
			resultado = false;
		}

		if(fornecedor.getCep().trim().length() < 5) {
			errosConcatenados += "Preencha o campo 'Nome'!\n";
			resultado = false;
		}
		if(fornecedor.getLogradouro().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Logradouro'!\n";
			resultado = false;
		}
		if(fornecedor.getNumeroEndereco().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Nº'!\n";
			resultado = false;
		}
		if(fornecedor.getBairro().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Bairro'!\n";
			resultado = false;
		}
		if(fornecedor.getCidade().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Cidade'!\n";
			resultado = false;
		}
		if(fornecedor.getUf_estado().equals("Selecione")) {
			errosConcatenados += "Escolha uma opção da lista 'UF'!\n";
			resultado = false;
		}
		if(fornecedor.getTelefone().trim().length() <= 11) {
			errosConcatenados += "Preencha o campo 'Telefone'!\n";
			resultado = false;
		}
		if(fornecedor.getEmail().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Email'!\n";
			resultado = false;
		}
		if(fornecedor.getRamoAtividade().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Ramo de Atividade'!\n";
			resultado = false;
		}
		if(fornecedor.getFax().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Fax'!\n";
			resultado = false;
		}
		
		if(resultado == true) {
			return true;
		}
		else {			
			JOptionPane.showMessageDialog(null, errosConcatenados, "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}				
	}
	
	public boolean validacaoCpfRg() {
		DadosFornecedorPessoaFisica fornecedorCpfRg = new DadosFornecedorPessoaFisica();
			
		for (int i = 0; i < fornecedorCpfRg.getFornecedoresFisicos().size() ; i++) {
			if(fornecedor.getCpf().equals(fornecedorCpfRg.getFornecedoresFisicos().get(i).getCpf().toString()) || fornecedor.getRg().equals(fornecedorCpfRg.getFornecedoresFisicos().get(i).getRg().toString())){
				JOptionPane.showMessageDialog(null, "Este cliente já está cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}		
		
		return true;
	}
	
	public boolean isResultadoValidacaoTodosCamposGeral() {
		return resultadoValidacaoTodosCamposGeral;
	}

	private void setResultadoValidacaoTodosCamposGeral(boolean resultadoValidacaoTodosCamposGeral) {
		this.resultadoValidacaoTodosCamposGeral = resultadoValidacaoTodosCamposGeral;
	}

	public boolean isResultadoValidacaoCpfRg() {
		return resultadoValidacaoCpfRg;
	}

	private void setResultadoValidacaoCpfRg(boolean resultadoValidacaoCpfRg) {
		this.resultadoValidacaoCpfRg = resultadoValidacaoCpfRg;
	}	
}
