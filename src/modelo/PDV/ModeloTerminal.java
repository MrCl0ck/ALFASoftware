package modelo.PDV;

import java.util.ArrayList;

import modelo.cadastros.produto.ModeloProduto;

public class ModeloTerminal {
	private String codigoProduto;
	private String quantidade;
	private double valorUnitario;
	private String descricao;
	private double desconto;
	private ArrayList<ModeloProduto> produtosLista;	
	
	public ArrayList<ModeloProduto> getProdutosLista() {
		return produtosLista;
	}
	public void setProdutosLista(ArrayList<ModeloProduto> produtosLista) {
		this.produtosLista = produtosLista;
	}
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
		
}
