package controle.cadastros.cliente;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.Banco;
import modelo.cadastros.cliente.ModeloClientePessoaFisica;
import modelo.cadastros.cliente.ModeloClientePessoaJuridica;
import modelo.cadastros.dados.DadosClientePessoaFisica;
import modelo.cadastros.dados.DadosClientePessoaJuridica;
import visao.cadastros.cliente.VisaoFramePrincipal;
import visao.cadastros.cliente.VisaoTelaCadastroCliente;

public class ControladorTelaCadastroCliente{
	private VisaoFramePrincipal framePrincipal;	
	private VisaoTelaCadastroCliente telaCliente;
	private ControladorTelaCadastroClientePessoaJuridica controladorPessoaJuridicaInstancia;
	private ControladorTelaCadastroClientePessoaFisica controladorPessoaFisicaInstancia;
	private Banco banco = new Banco();
	
	
	public ControladorTelaCadastroCliente(VisaoFramePrincipal frame) {
		framePrincipal = frame;
		inicializaTela();
		botoesDesablitadosInicialmente();
		addEvento();
	}

	public void addEvento() {
		getTipoClienteAction();
		getBotaoBuscarAction();
		getBotaoIncluirAction();
		getBotaoExcluirAction();
		getBotaoAlterarAction();
		getBotaoCancelarAction();
		getBotaoFecharAction();
		getSelecionarUmClienteTabela();
	}
	
	private void getBotaoAlterarAction() {
		telaCliente.getTelaPesquisa().getButtonAlterar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(telaCliente.getTelaPesquisa().getJTableDadosCliente().getSelectedRow() != -1) {
					int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();	
					if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Busca - Pessoa Física")) {
						getControladorPessoaFisicaInstancia().atribuicaoDeBuscaAosCampos(telaCliente.getBuscaExibicaoTableModelFisico(true).getCliente(linhaSelecionada));						
						getControladorPessoaFisicaInstancia().getTelaClienteFisico().getTelaPesquisa().getTextFieldEntradaDado().setText(telaCliente.getTelaPesquisa().getTextFieldEntradaDado().getText());
						getControladorPessoaFisicaInstancia().getTelaClienteFisico().getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem(telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString());
						getControladorPessoaFisicaInstancia().getTelaClienteFisico().getTelaPesquisa().getJTableDadosCliente().setModel(telaCliente.getBuscaExibicaoTableModelFisico(true));;
						getControladorPessoaFisicaInstancia().getTelaClienteFisico().getBuscaExibicaoTableModel(true).setClienteArray(telaCliente.getBuscaExibicaoTableModelFisico(true).getClienteArray());
						getControladorPessoaFisicaInstancia().getTelaClienteFisico().getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Física - Alteração de cliente");											
						getControladorPessoaFisicaInstancia().camposHabilitadosAoIncluirOuAlterar(true);
						getControladorPessoaFisicaInstancia().botoesHabilitadosEDesabilitadosAoIncluirOuAlterar(true);
						//chamar controlador
						//erro aqui....
					}
					else if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Busca - Pessoa Jurídica")) {
						getControladorPessoaJuridicaInstancia().atribuicaoDeBuscaAosCampos(telaCliente.getBuscaExibicaoTableModelJuridico(true).getCliente(linhaSelecionada));						
						getControladorPessoaJuridicaInstancia().getTelaClienteJuridico().getTelaPesquisa().getTextFieldEntradaDado().setText(telaCliente.getTelaPesquisa().getTextFieldEntradaDado().getText());
						getControladorPessoaJuridicaInstancia().getTelaClienteJuridico().getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem(telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString());
						getControladorPessoaJuridicaInstancia().getTelaClienteJuridico().getTelaPesquisa().getJTableDadosCliente().setModel(telaCliente.getBuscaExibicaoTableModelJuridico(true));;
						getControladorPessoaJuridicaInstancia().getTelaClienteJuridico().getBuscaExibicaoTableModel(true).setClienteArray(telaCliente.getBuscaExibicaoTableModelJuridico(true).getClienteArray());
						getControladorPessoaJuridicaInstancia().getTelaClienteJuridico().getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Jurídica - Alteração de cliente");											
						getControladorPessoaJuridicaInstancia().camposHabilitadosAoIncluirOuAlterar(true);
						getControladorPessoaJuridicaInstancia().botoesHabilitadosEDesabilitadosAoIncluirOuAlterar(true);
						//chamar controlador
						//erro aqui....
					}
				}	
			}
		});
		
	}

	private void getBotaoExcluirAction() {
		telaCliente.getTelaPesquisa().getButtonExcluir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Busca - Pessoa Física")) {
					exclusaoFisico();
				}
				else if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Busca - Pessoa Jurídica")) {
					exclusaoJuridico();
				}
			}
		});
	}
	public void exclusaoFisico() {
		int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
			ModeloClientePessoaFisica cliente = telaCliente.getBuscaExibicaoTableModelFisico(true).getCliente(linhaSelecionada);
			
			Object[] options = { "NÃO", "SIM" };
		      int opcao = JOptionPane.showOptionDialog(null, "Deseja excluir o cliente de nome: '" + cliente.getNome() +"' ?", "Exclusão",
		          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
		              null, options, options[0]);
		      
		      if(opcao == 1) {
		    	  telaCliente.getBuscaExibicaoTableModelFisico(true).removerCliente(linhaSelecionada);
		    	  String cpf = cliente.getCpf();
		    	  String id =  banco.consultar("cliente", "cpf" , cpf, "ENDERECO_id");;
		    	  
		    	  if(new DadosClientePessoaFisica().bancoDeDadosExcluir(cpf, id) == true) {
		    		  desabilitadosEHabilitadosInicialmente();
		    	  }	
		      }
	}
	
	public void exclusaoJuridico() {
		int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
		ModeloClientePessoaJuridica cliente = telaCliente.getBuscaExibicaoTableModelJuridico(true).getCliente(linhaSelecionada);
		
		Object[] options = { "NÃO", "SIM" };
	      int opcao = JOptionPane.showOptionDialog(null, "Deseja excluir o cliente de Razão Social: '" + cliente.getRazaoSocial() +"' ?", "Exclusão",
	          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
	              null, options, options[0]);
	      
	      if(opcao == 1) {
	    	  telaCliente.getBuscaExibicaoTableModelJuridico(true).removerCliente(linhaSelecionada);
	    	  String cnpjBusca = cliente.getCnpj();
	    	  String idBusca = banco.consultar("cliente", "cnpj" , cnpjBusca, "ENDERECO_id");
	    	  if(new DadosClientePessoaJuridica().bancoDeDadosExcluir(cnpjBusca, idBusca) == true) {
	    		  desabilitadosEHabilitadosInicialmente();
	    	  }				    	  
	      }	
	}

	private void getBotaoCancelarAction() {
		telaCliente.getTelaPesquisa().getButtonCancelar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "NÃO", "SIM" };
			      int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar a busca atual?", "Cancelamento",
			          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			              null, options, options[0]);
			      
			      if(opcao == 1) {
			    	  desabilitadosEHabilitadosInicialmente();
			      }
			}
		});
	}

	private void getBotaoFecharAction() {
		telaCliente.getTelaPesquisa().getButtonFechar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				framePrincipal.dispose();
			}			
		});
	}	
	
	private void getBotaoBuscarAction() {
		telaCliente.getTelaPesquisa().getButtonBuscar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String tipoBusca, valorBusca;
				
				tipoBusca = telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString();
				valorBusca = telaCliente.getTelaPesquisa().getTextFieldEntradaDado().getText();
				
				if(tipoBusca == "Nome" || tipoBusca == "CPF") {
					telaCliente.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Busca - Pessoa Física"); 
					buscaClienteFisico(tipoBusca, valorBusca);
					botoesHabilitadosPosBusca(true);
				}
				else if(tipoBusca == "Razão Social" || tipoBusca == "CNPJ") {
					telaCliente.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Busca - Pessoa Jurídica"); 
					buscaClienteJuridico(tipoBusca, valorBusca);
					botoesHabilitadosPosBusca(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Preencha o campo de busca e escolha um tipo de busca!"
							  , "Selecione", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}	
		});
	}

	private void getBotaoIncluirAction() {
		telaCliente.getTelaPesquisa().getButtonIncluir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(telaCliente.getComboBoxTipoCliente().getSelectedItem().toString().equals("Selecione")) {
					JOptionPane.showMessageDialog(null, "Selecione um tipo de cliente!", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	private void getTipoClienteAction() {
		telaCliente.getComboBoxTipoCliente().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String opcao = telaCliente.getComboBoxTipoCliente().getSelectedItem().toString();
				
					if(opcao.equals("Pessoa Física")) {						
						getControladorPessoaFisicaInstancia();
					}
					else if(opcao.equals("Pessoa Jurídica")) {
						getControladorPessoaJuridicaInstancia();	
					}
			}	
			
		});		
	}
	
	
	
	private void getSelecionarUmClienteTabela() {
		telaCliente.getTelaPesquisa().getJTableDadosCliente().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getClickCount() == 2) {
					System.out.println(telaCliente.getLabelPaginaCadastroCliente().getText());
					if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Busca - Pessoa Física")) {
						int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();
						getControladorPessoaFisicaInstancia().atribuicaoDeBuscaAosCampos(telaCliente.getBuscaExibicaoTableModelFisico(true).getCliente(linhaSelecionada));
						getControladorPessoaFisicaInstancia().botoesHabilitadosPosBusca(true);
						getControladorPessoaFisicaInstancia().getTelaClienteFisico().getTelaPesquisa().getTextFieldEntradaDado().setText(telaCliente.getTelaPesquisa().getTextFieldEntradaDado().getText());
						getControladorPessoaFisicaInstancia().getTelaClienteFisico().getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem(telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString());
						getControladorPessoaFisicaInstancia().getTelaClienteFisico().getTelaPesquisa().getJTableDadosCliente().setModel(telaCliente.getBuscaExibicaoTableModelFisico(true));;
						getControladorPessoaFisicaInstancia().getTelaClienteFisico().getBuscaExibicaoTableModel(true).setClienteArray(telaCliente.getBuscaExibicaoTableModelFisico(true).getClienteArray());
						//erro aqui....
						
					}
					else if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Busca - Pessoa Jurídica")) {
						int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();			
						getControladorPessoaJuridicaInstancia().atribuicaoDeBuscaAosCampos(telaCliente.getBuscaExibicaoTableModelJuridico(true).getCliente(linhaSelecionada));
						getControladorPessoaJuridicaInstancia().botoesHabilitadosPosBusca(true);
						getControladorPessoaJuridicaInstancia().getTelaClienteJuridico().getTelaPesquisa().getTextFieldEntradaDado().setText(telaCliente.getTelaPesquisa().getTextFieldEntradaDado().getText());
						getControladorPessoaJuridicaInstancia().getTelaClienteJuridico().getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem(telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString());
						getControladorPessoaJuridicaInstancia().getTelaClienteJuridico().getTelaPesquisa().getJTableDadosCliente().setModel(telaCliente.getBuscaExibicaoTableModelJuridico(true));
						getControladorPessoaJuridicaInstancia().getTelaClienteJuridico().getBuscaExibicaoTableModel(true).setClienteArray(telaCliente.getBuscaExibicaoTableModelJuridico(true).getClienteArray());
						//erro aqui....
					}
					
				}				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	public void atualizarTelaEMetodos(VisaoFramePrincipal frame) {
		framePrincipal = frame;
		telaCliente = new VisaoTelaCadastroCliente();
		adicionarTelaAtualizar();
		botoesDesablitadosInicialmente();
		addEvento();	
	}
	
	private void adicionarTelaAtualizar() {
		framePrincipal.getContentPane().removeAll();
		framePrincipal.setContentPane(telaCliente);
		framePrincipal.repaint();
		framePrincipal.validate();
	}
	
	public void inicializaTela() {
		telaCliente = new VisaoTelaCadastroCliente();
		adicionarTela();
	}
	
	private void adicionarTela() {
		framePrincipal.getContentPane().removeAll();
		framePrincipal.setContentPane(telaCliente);
		framePrincipal.setVisible(true);
		framePrincipal.setResizable(false);
		framePrincipal.setMinimumSize(new Dimension(1055, 720));
		framePrincipal.setMaximumSize(new Dimension(1055, 720));
		framePrincipal.setLocationRelativeTo(null);
		framePrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framePrincipal.repaint();
		framePrincipal.validate();
	}
	
	private void botoesDesablitadosInicialmente() {
		telaCliente.getTelaPesquisa().getButtonExcluir().setEnabled(false);
		telaCliente.getTelaPesquisa().getButtonAlterar().setEnabled(false);
		telaCliente.getTelaPesquisa().getButtonCancelar().setEnabled(false);
		telaCliente.getTelaPesquisa().getButtonConfirmar().setEnabled(false);
		telaCliente.getTelaPesquisa().getButtonIncluir().setEnabled(false);
	}
	
	private boolean buscaClienteJuridico(String tipoBusca, String valorBusca) {
		if(!tipoBusca.equals("Selecione")) {		
			if(!valorBusca.trim().equals("")) {
				if(tipoBusca.equals("Razão Social")) {
					DadosClientePessoaJuridica cliente = new DadosClientePessoaJuridica();
					telaCliente.getTelaPesquisa().getJTableDadosCliente().setModel(telaCliente.getBuscaExibicaoTableModelJuridico(false));//seta uma nova tabela, só pra exibição dos resultados da busca
					
					ModeloClientePessoaJuridica clientePessoa = new ModeloClientePessoaJuridica();
					
					for (int i = 0; i < cliente.getClientesJuridicos().size(); i++) {
						if(cliente.getClientesJuridicos().get(i).getRazaoSocial().contains(valorBusca)) {
							for (int j = 0; j < banco.consultarEndereco().size(); j++) {
								if (banco.consultarEndereco().get(j).getId_endereco() == banco.consultarClienteFisico().get(i).getId_endereco()) {
									clientePessoa = cliente.getClientesJuridicos().get(i);
									clientePessoa.setBairro(banco.consultarEndereco().get(j).getBairro());
									clientePessoa.setCep(banco.consultarEndereco().get(j).getCep());
									clientePessoa.setLogradouro(banco.consultarEndereco().get(j).getLogradouro());
									clientePessoa.setNumeroEndereco(banco.consultarEndereco().get(j).getNumeroEndereco());
									clientePessoa.setComplemento(banco.consultarEndereco().get(j).getComplemento());
									clientePessoa.setCidade(banco.consultarEndereco().get(j).getCidade());
									clientePessoa.setUf_estado(banco.consultarEndereco().get(j).getUf_estado());
									telaCliente.getBuscaExibicaoTableModelJuridico(true).addCliente(clientePessoa);
								}
							}
						}				
					}
					if(telaCliente.getBuscaExibicaoTableModelJuridico(true).getRowCount() > 0) {
						JOptionPane.showMessageDialog(null, "Busca finalizada, " + telaCliente.getBuscaExibicaoTableModelJuridico(true).getRowCount() + " clientes encontrados."
													  , "Busca", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum cliente encontrado."
								  , "Busca", JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
				}
				else if(tipoBusca.equals("CNPJ")) {
					DadosClientePessoaJuridica cliente = new DadosClientePessoaJuridica();
					telaCliente.getTelaPesquisa().getJTableDadosCliente().setModel(telaCliente.getBuscaExibicaoTableModelJuridico(false));//seta uma nova tabela, só pra exibição dos resultados da busca
					
					ModeloClientePessoaJuridica clientePessoa = new ModeloClientePessoaJuridica();
					
					for (int i = 0; i < cliente.getClientesJuridicos().size(); i++) {
						if(cliente.getClientesJuridicos().get(i).getCnpj().contains(valorBusca)) {
							for (int j = 0; j < banco.consultarEndereco().size(); j++) {
								if (banco.consultarEndereco().get(j).getId_endereco() == banco.consultarClienteFisico().get(i).getId_endereco()) {
									clientePessoa = cliente.getClientesJuridicos().get(i);
									clientePessoa.setBairro(banco.consultarEndereco().get(j).getBairro());
									clientePessoa.setCep(banco.consultarEndereco().get(j).getCep());
									clientePessoa.setLogradouro(banco.consultarEndereco().get(j).getLogradouro());
									clientePessoa.setNumeroEndereco(banco.consultarEndereco().get(j).getNumeroEndereco());
									clientePessoa.setComplemento(banco.consultarEndereco().get(j).getComplemento());
									clientePessoa.setCidade(banco.consultarEndereco().get(j).getCidade());
									clientePessoa.setUf_estado(banco.consultarEndereco().get(j).getUf_estado());
									telaCliente.getBuscaExibicaoTableModelJuridico(true).addCliente(clientePessoa);
								}
							}
						}				
					}	
					if(telaCliente.getBuscaExibicaoTableModelJuridico(true).getRowCount() > 0) {
						JOptionPane.showMessageDialog(null, "Busca finalizada, " + telaCliente.getBuscaExibicaoTableModelJuridico(true).getRowCount() + " clientes encontrados."
													  , "Busca", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum cliente encontrado."
								  , "Busca", JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Preencha o campo de busca!"
						  , "Selecione", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		}	
		else {
			JOptionPane.showMessageDialog(null, "Escolha um tipo de busca!"
					  , "Aviso", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	
	private boolean buscaClienteFisico(String tipoBusca, String valorBusca) {		
		if(!tipoBusca.equals("Selecione")) {		
			if(!valorBusca.trim().equals("")) {
				if(tipoBusca.equals("Nome")) {
					DadosClientePessoaFisica cliente = new DadosClientePessoaFisica();
					telaCliente.getTelaPesquisa().getJTableDadosCliente().setModel(telaCliente.getBuscaExibicaoTableModelFisico(false));//seta uma nova tabela, só pra exibição dos resultados da busca
					
					ModeloClientePessoaFisica clientePessoa = new ModeloClientePessoaFisica();
					
					for (int i = 0; i < cliente.getClientesFisicos().size(); i++) {
						if(cliente.getClientesFisicos().get(i).getNome().contains(valorBusca)) {
							for (int j = 0; j < banco.consultarEndereco().size(); j++) {
								if (banco.consultarEndereco().get(j).getId_endereco() == banco.consultarClienteFisico().get(i).getId_endereco()) {
									clientePessoa = cliente.getClientesFisicos().get(i);
									clientePessoa.setBairro(banco.consultarEndereco().get(j).getBairro());
									clientePessoa.setCep(banco.consultarEndereco().get(j).getCep());
									clientePessoa.setLogradouro(banco.consultarEndereco().get(j).getLogradouro());
									clientePessoa.setNumeroEndereco(banco.consultarEndereco().get(j).getNumeroEndereco());
									clientePessoa.setComplemento(banco.consultarEndereco().get(j).getComplemento());
									clientePessoa.setCidade(banco.consultarEndereco().get(j).getCidade());
									clientePessoa.setUf_estado(banco.consultarEndereco().get(j).getUf_estado());
									telaCliente.getBuscaExibicaoTableModelFisico(true).addCliente(clientePessoa);
								}
							}
						}				
					}
					if(telaCliente.getBuscaExibicaoTableModelFisico(true).getRowCount() > 0) {
						JOptionPane.showMessageDialog(null, "Busca finalizada, " + telaCliente.getBuscaExibicaoTableModelFisico(true).getRowCount() + " clientes encontrados."
													  , "Busca", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum cliente encontrado."
								  , "Busca", JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
				}
				else if(tipoBusca.equals("CPF")) {
					DadosClientePessoaFisica cliente = new DadosClientePessoaFisica();
					telaCliente.getTelaPesquisa().getJTableDadosCliente().setModel(telaCliente.getBuscaExibicaoTableModelFisico(false));//seta uma nova tabela, só pra exibição dos resultados da busca
					
					ModeloClientePessoaFisica clientePessoa = new ModeloClientePessoaFisica();
					
					for (int i = 0; i < cliente.getClientesFisicos().size(); i++) {
						if(cliente.getClientesFisicos().get(i).getCpf().contains(valorBusca)) {
							for (int j = 0; j < banco.consultarEndereco().size(); j++) {
								if (banco.consultarEndereco().get(j).getId_endereco() == banco.consultarClienteFisico().get(i).getId_endereco()) {
									clientePessoa = cliente.getClientesFisicos().get(i);
									clientePessoa.setBairro(banco.consultarEndereco().get(j).getBairro());
									clientePessoa.setCep(banco.consultarEndereco().get(j).getCep());
									clientePessoa.setLogradouro(banco.consultarEndereco().get(j).getLogradouro());
									clientePessoa.setNumeroEndereco(banco.consultarEndereco().get(j).getNumeroEndereco());
									clientePessoa.setComplemento(banco.consultarEndereco().get(j).getComplemento());
									clientePessoa.setCidade(banco.consultarEndereco().get(j).getCidade());
									clientePessoa.setUf_estado(banco.consultarEndereco().get(j).getUf_estado());
									telaCliente.getBuscaExibicaoTableModelFisico(true).addCliente(clientePessoa);
								}
							}
						}				
					}
					if(telaCliente.getBuscaExibicaoTableModelFisico(true).getRowCount() > 0) {
						JOptionPane.showMessageDialog(null, "Busca finalizada, " + telaCliente.getBuscaExibicaoTableModelFisico(true).getRowCount() + " clientes encontrados."
													  , "Busca", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum cliente encontrado."
								  , "Busca", JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Preencha o campo de busca!"
						  , "Selecione", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		}	
		else {
			JOptionPane.showMessageDialog(null, "Escolha um tipo de busca!"
					  , "Aviso", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	private void botoesHabilitadosPosBusca(boolean b) {
		telaCliente.getTelaPesquisa().getButtonExcluir().setEnabled(b);
		telaCliente.getTelaPesquisa().getButtonAlterar().setEnabled(b);
		telaCliente.getTelaPesquisa().getButtonCancelar().setEnabled(b);
		telaCliente.getTelaPesquisa().getButtonIncluir().setEnabled(!b);
	}	
	
	private void desabilitadosEHabilitadosInicialmente() {
		botoesDesablitadosEHabilitadosInicialmente();
	}
	
	private void botoesDesablitadosEHabilitadosInicialmente() {
		telaCliente.getTelaPesquisa().getButtonExcluir().setEnabled(false);
		telaCliente.getTelaPesquisa().getButtonAlterar().setEnabled(false);
		telaCliente.getTelaPesquisa().getButtonCancelar().setEnabled(false);
		telaCliente.getTelaPesquisa().getButtonConfirmar().setEnabled(false);
		telaCliente.getTelaPesquisa().getButtonIncluir().setEnabled(true);
		telaCliente.getTelaPesquisa().getButtonBuscar().setEnabled(true);
		telaCliente.getTelaPesquisa().getTextFieldEntradaDado().setText("");
		telaCliente.getTelaPesquisa().getJTableDadosCliente().setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"CPF/CNPJ", "Nome/Razão Social", "Endere\u00E7o", "Telefone"
				}
			)
		);
		telaCliente.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente");;
	}
	
	public ControladorTelaCadastroClientePessoaJuridica getControladorPessoaJuridicaInstancia() {
		if(controladorPessoaJuridicaInstancia == null) {
			controladorPessoaJuridicaInstancia = new ControladorTelaCadastroClientePessoaJuridica(framePrincipal);
		}
		return controladorPessoaJuridicaInstancia;
	}
	
	public ControladorTelaCadastroClientePessoaFisica getControladorPessoaFisicaInstancia() {
		if(controladorPessoaFisicaInstancia == null) {
			controladorPessoaFisicaInstancia = new ControladorTelaCadastroClientePessoaFisica(framePrincipal);
		}
		return controladorPessoaFisicaInstancia;
	}
}
