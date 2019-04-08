package modelo.cadastros.produto;

import java.util.ArrayList;

public class ModeloProduto {
	private String codigo;
	private String codigoDeBarras;
	private String descricao;
	private double valorDaCompra;
	private double valorDaVenda;
	private double lucro;
	private ArrayList<String> unidade;
	private ArrayList<String> tipo;
	private String estoqueMinimo;
	private String estoqueMaximo;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}
	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValorDaCompra() {
		return valorDaCompra;
	}
	public void setValorDaCompra(double valorDaCompra) {
		this.valorDaCompra = valorDaCompra;
	}
	public double getValorDaVenda() {
		return valorDaVenda;
	}
	public void setValorDaVenda(double valorDaVenda) {
		this.valorDaVenda = valorDaVenda;
	}
	public double getLucro() {
		return lucro;
	}
	public void setLucro(double lucro) {
		this.lucro = lucro;
	}
	public ArrayList<String> getUnidade() {
		return unidade;
	}
	public void setUnidade(ArrayList<String> unidade) {
		this.unidade = unidade;
	}
	public ArrayList<String> getTipo() {
		return tipo;
	}
	public void setTipo(ArrayList<String> tipo) {
		this.tipo = tipo;
	}
	public String getEstoqueMinimo() {
		return estoqueMinimo;
	}
	public void setEstoqueMinimo(String estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}
	public String getEstoqueMaximo() {
		return estoqueMaximo;
	}
	public void setEstoqueMaximo(String estoqueMaximo) {
		this.estoqueMaximo = estoqueMaximo;
	}

}

