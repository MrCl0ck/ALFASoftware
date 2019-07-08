package modelo.cadastros.produto;


public class ModeloProduto {
	
	private String codigo;
	private String codigoDeBarras;
	private String descricao;
	private double valorDaCompra;
	private double valorDaVenda;
	private double lucro;
	private Unidade unidade;
	private Tipo tipo;
	private int estoqueMinimo;
	private int estoqueMaximo;

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

	public Unidade getUnidade() {
		if(unidade==null) {
			unidade = new Unidade();
		}			
		return unidade;
	}

	public Tipo getTipo() {		
		if(tipo==null) {
			tipo = new Tipo();
		}			
		return tipo;
	}


	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}
	
	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}
	
	public int getEstoqueMaximo() {
		return estoqueMaximo;
	}
	
	public void setEstoqueMaximo(int estoqueMaximo) {
		this.estoqueMaximo = estoqueMaximo;
	}
}
