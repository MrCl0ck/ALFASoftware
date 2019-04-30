package modelo.cadastros.fornecedor;

import java.util.ArrayList;

import modelo.cadastros.EnderecoCadastro;

public class ModeloFornecedorJuridica extends EnderecoCadastro{
	
	private int id;
	private String razaoSocial;
	private String cnpj;
	private String representante;
	private String ramoAtividade;
	private String fax;
	private String situacao;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getRepresentante() {
		return representante;
	}
	
	public void setRepresentante(String representante) {
		this.representante = representante;
	}
	
	public String getRamoAtividade() {
		return ramoAtividade;
	}
	
	public void setRamoAtividade(String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}
	
	public String getFax() {
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
}
