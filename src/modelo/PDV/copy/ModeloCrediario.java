package modelo.PDV.copy;

import java.util.ArrayList;

import modelo.cadastros.cliente.ModeloClientePessoaFisica;
import modelo.cadastros.cliente.ModeloClientePessoaJuridica;
import modelo.cadastros.produto.ModeloProduto;

public class ModeloCrediario {
	private ArrayList<ModeloProduto> listaProdutos;
	private ModeloClientePessoaFisica clienteFisico;
	private ModeloClientePessoaJuridica clienteJuridico;
	private double valorDaCompra;
	
	public ArrayList<ModeloProduto> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(ArrayList<ModeloProduto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	public ModeloClientePessoaFisica getClienteFisico() {
		return clienteFisico;
	}
	public void setClienteFisico(ModeloClientePessoaFisica clienteFisico) {
		this.clienteFisico = clienteFisico;
	}
	public ModeloClientePessoaJuridica getClienteJuridico() {
		return clienteJuridico;
	}
	public void setClienteJuridico(ModeloClientePessoaJuridica clienteJuridico) {
		this.clienteJuridico = clienteJuridico;
	}
	public double getValorDaCompra() {
		return valorDaCompra;
	}
	public void setValorDaCompra(double valorDaCompra) {
		this.valorDaCompra = valorDaCompra;
	}
	
	
}
