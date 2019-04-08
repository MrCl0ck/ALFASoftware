package modelo.PDV.copy;

import java.util.ArrayList;

import modelo.cadastros.EnderecoCadastro;
import modelo.cadastros.produto.ModeloProduto;

public class ModeloEntrega {
	private ArrayList<ModeloProduto> itensAdquiridos;
	private ArrayList<ModeloProduto> itensASeremEntregues;
	private String dataEntrega;
	private String enderecoEntrega;
	private EnderecoCadastro endereco;
	
	public ArrayList<ModeloProduto> getItensAdquiridos() {
		return itensAdquiridos;
	}
	public void setItensAdquiridos(ArrayList<ModeloProduto> itensAdquiridos) {
		this.itensAdquiridos = itensAdquiridos;
	}
	public ArrayList<ModeloProduto> getItensASeremEntregues() {
		return itensASeremEntregues;
	}
	public void setItensASeremEntregues(ArrayList<ModeloProduto> itensASeremEntregues) {
		this.itensASeremEntregues = itensASeremEntregues;
	}
	public String getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}
	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	public EnderecoCadastro getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoCadastro endereco) {
		this.endereco = endereco;
	}
	
	
}
