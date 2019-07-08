package modelo.cadastros.validacoes;

import javax.swing.JOptionPane;

import modelo.cadastros.dados.DadosFornecedorPessoaJuridica;
import modelo.cadastros.fornecedor.ModeloFornecedorJuridica;

public class ValidacaoFornecedorPessoaJuridica {

	private ModeloFornecedorJuridica fornecedor;
	private boolean resultadoValidacaoTodosCamposGeral;
	private boolean resultadoValidacaoCnpjEInscricaoEstadual;
	
	public ValidacaoFornecedorPessoaJuridica(ModeloFornecedorJuridica fornecedor) {
		this.fornecedor = fornecedor;
		setResultadoValidacaoTodosCamposGeral(validacaoTodosCamposGeral());
	}

	public void validarCNPJ() {
		setResultadoValidacaoCnpjInscricaoEstadual(validacaoCnpjInscricaoEstadual());
	}
	
	public boolean validacaoTodosCamposGeral() {
		boolean resultado = true;
		String errosConcatenados = "";
		
		if(fornecedor.getSituacao().equals("Selecione")) {
			errosConcatenados += "Escolha uma opção da lista 'Situação'!\n";
			resultado = false;
		}
		if(fornecedor.getRazaoSocial().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Razão Social'!\n";
			resultado = false;
		}
		if(fornecedor.getCnpj().trim().length() <= 11) {//----------------------
			errosConcatenados += "Preencha o campo 'CNPJ'!\n";
			resultado = false;
		}
		if(fornecedor.getRepresentante().trim().equals("")) {//----------------------
			errosConcatenados += "Preencha o campo 'Representante'!\n";
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
//		if(cliente.getComplemento().trim().equals("")) {
//			errosConcatenados += "Preencha o campo 'Complemento'!\n";
//			resultado = false;
//		}
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
	
	public boolean validacaoCnpjInscricaoEstadual() {
		DadosFornecedorPessoaJuridica fornecedorCpfRg = new DadosFornecedorPessoaJuridica();
			
		for (int i = 0; i < fornecedorCpfRg.getFornecedoresJuridicos().size() ; i++) {
			if(fornecedor.getCnpj().equals(fornecedorCpfRg.getFornecedoresJuridicos().get(i).getCnpj().toString())){
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

	public boolean isResultadoValidacaoCnpjEInscricaoEstadual() {
		return resultadoValidacaoCnpjEInscricaoEstadual;
	}

	private void setResultadoValidacaoCnpjInscricaoEstadual(boolean resultadoValidacaoCnpjEInscricaoEstadual) {
		this.resultadoValidacaoCnpjEInscricaoEstadual = resultadoValidacaoCnpjEInscricaoEstadual;
	}	
}
