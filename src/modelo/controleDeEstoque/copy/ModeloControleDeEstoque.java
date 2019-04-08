package modelo.controleDeEstoque.copy;

public class ModeloControleDeEstoque {
	private String tipoDaMovimentacao;
	private String descricaoDaOperacao;
	private String nomeFornecedor;
	private String cpf_cnpjFornecedor;
	private String data;
	private String codigoItem;
	private String descricaoItem;
	private String quantidadeItem;
	private double valorItem;
	
	public String getTipoDaMovimentacao() {
		return tipoDaMovimentacao;
	}
	public void setTipoDaMovimentacao(String tipoDaMovimentacao) {
		this.tipoDaMovimentacao = tipoDaMovimentacao;
	}
	public String getDescricaoDaOperacao() {
		return descricaoDaOperacao;
	}
	public void setDescricaoDaOperacao(String descricaoDaOperacao) {
		this.descricaoDaOperacao = descricaoDaOperacao;
	}
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	public String getCpf_cnpjFornecedor() {
		return cpf_cnpjFornecedor;
	}
	public void setCpf_cnpjFornecedor(String cpf_cnpjFornecedor) {
		this.cpf_cnpjFornecedor = cpf_cnpjFornecedor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getCodigoItem() {
		return codigoItem;
	}
	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}
	public String getDescricaoItem() {
		return descricaoItem;
	}
	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}
	public String getQuantidadeItem() {
		return quantidadeItem;
	}
	public void setQuantidadeItem(String quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}
	public double getValorItem() {
		return valorItem;
	}
	public void setValorItem(double valorItem) {
		this.valorItem = valorItem;
	}
	
	
}
