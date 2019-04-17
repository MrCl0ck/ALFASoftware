package modelo.cadastros.fornecedor;

import modelo.cadastros.EnderecoCadastro;

public class ModeloFornecedorFisica extends EnderecoCadastro{
	
	private int id;
	private String nome;
	private String ramoAtividade;
	private String cpf;
	private String rg;
	private String ufRg;
	private String orgaoExpeditorRg;
	private String sexo;
	private String dataNascimento;	
	private String fax;
	private String situacao;
	
	public ModeloFornecedorFisica() {
		
	}
	
	public ModeloFornecedorFisica(int id, String nome, String ramoAtividade, String cpf, String rg, String ufRg,
			String orgaoExpeditorRg, String sexo, String dataNascimento, String fax, String situacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.ramoAtividade = ramoAtividade;
		this.cpf = cpf;
		this.rg = rg;
		this.ufRg = ufRg;
		this.orgaoExpeditorRg = orgaoExpeditorRg;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.fax = fax;
		this.situacao = situacao;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRamoAtividade() {
		return ramoAtividade;
	}
	public void setRamoAtividade(String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getUfRg() {
		return ufRg;
	}
	public void setUfRg(String ufRg) {
		this.ufRg = ufRg;
	}
	public String getOrgaoExpeditorRg() {
		return orgaoExpeditorRg;
	}
	public void setOrgaoExpeditorRg(String orgaoExpeditorRg) {
		this.orgaoExpeditorRg = orgaoExpeditorRg;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
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