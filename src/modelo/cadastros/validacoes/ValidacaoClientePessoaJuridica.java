package modelo.cadastros.validacoes;

import javax.swing.JOptionPane;

import modelo.cadastros.cliente.ModeloClientePessoaJuridica;
import modelo.cadastros.dados.DadosClientePessoaJuridica;

public class ValidacaoClientePessoaJuridica {
	private ModeloClientePessoaJuridica cliente;
	private boolean resultadoValidacaoTodosCamposGeral;
	private boolean resultadoValidacaoCnpjEInscricaoEstadual;

	public ValidacaoClientePessoaJuridica(ModeloClientePessoaJuridica cliente) {
		this.cliente = cliente;
		setResultadoValidacaoTodosCamposGeral(validacaoTodosCamposGeral());
	}
	
	public void validarCNPJ() {
		setResultadoValidacaoCnpjInscricaoEstadual(validacaoCnpjInscricaoEstadual());
	}
	
	public boolean validacaoTodosCamposGeral() {
		boolean resultado = true;
		String errosConcatenados = "";
		
		if(cliente.getSituacao().equals("Selecione")) {
			errosConcatenados += "Escolha uma opção da lista 'Situação'!\n";
			resultado = false;
		}
		if(cliente.getRazaoSocial().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Razão Social'!\n";
			resultado = false;
		}
		if(cliente.getCnpj().trim().length() <= 11) {//----------------------
			errosConcatenados += "Preencha o campo 'CNPJ'!\n";
			resultado = false;
		}
		if(cliente.getRepresentante().trim().equals("")) {//----------------------
			errosConcatenados += "Preencha o campo 'Representante'!\n";
			resultado = false;
		}
		if(cliente.getInscricaoEstadual().trim().length() <= 9 ) {//---------------------
			errosConcatenados += "Preencha o campo 'Inscrição Estadual'!\n";
			resultado = false;
		}
		if(cliente.getInscricaoEstadualUF().equals("Selecione")) {
			errosConcatenados += "Escolha uma opção da lista 'UF'!\n";
			resultado = false;
		}
		if(cliente.getLimiteCredito() <= 0) {
			errosConcatenados += "Insira um valor válido no campo 'Limite de Crédito'!\n";
			resultado = false;
		}
		if(cliente.getCep().trim().length() < 5) {
			errosConcatenados += "Preencha o campo 'Nome'!\n";
			resultado = false;
		}
		if(cliente.getLogradouro().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Logradouro'!\n";
			resultado = false;
		}
		if(cliente.getNumeroEndereco().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Nº'!\n";
			resultado = false;
		}
		if(cliente.getBairro().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Bairro'!\n";
			resultado = false;
		}
//		if(cliente.getComplemento().trim().equals("")) {
//			errosConcatenados += "Preencha o campo 'Complemento'!\n";
//			resultado = false;
//		}
		if(cliente.getCidade().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Cidade'!\n";
			resultado = false;
		}
		if(cliente.getUf_estado().equals("Selecione")) {
			errosConcatenados += "Escolha uma opção da lista 'UF'!\n";
			resultado = false;
		}
		if(cliente.getTelefone().trim().length() <= 11) {
			errosConcatenados += "Preencha o campo 'Telefone'!\n";
			resultado = false;
		}
		if(cliente.getEmail().trim().equals("")) {
			errosConcatenados += "Preencha o campo 'Email'!\n";
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
		DadosClientePessoaJuridica clienteCpfRg = new DadosClientePessoaJuridica();
			
		for (int i = 0; i < clienteCpfRg.getClientesJuridicos().size() ; i++) {
			if(cliente.getCnpj().equals(clienteCpfRg.getClientesJuridicos().get(i).getCnpj().toString()) || cliente.getInscricaoEstadual().equals(clienteCpfRg.getClientesJuridicos().get(i).getInscricaoEstadual().toString())){
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
