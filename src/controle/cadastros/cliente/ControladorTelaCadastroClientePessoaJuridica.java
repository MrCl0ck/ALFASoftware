package controle.cadastros.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import dao.Banco;
import modelo.cadastros.cliente.ModeloClientePessoaJuridica;
import modelo.cadastros.dados.DadosClientePessoaJuridica;
import modelo.cadastros.validacoes.ValidacaoClientePessoaJuridica;
import visao.cadastros.cliente.VisaoFramePrincipal;
import visao.cadastros.cliente.VisaoTelaCadastroClientePessoaJuridica;

public class ControladorTelaCadastroClientePessoaJuridica{
	private ModeloClientePessoaJuridica clienteAtual;
	private ModeloClientePessoaJuridica clienteExibicao;
	private ModeloClientePessoaJuridica clienteAntigo;
	private VisaoTelaCadastroClientePessoaJuridica telaClienteJuridico;
	private VisaoTelaCadastroClientePessoaJuridica tcj;
	private VisaoFramePrincipal framePrincipal;
	private ControladorTelaCadastroCliente controladorTelaCadastroCliente;
	private Banco banco = new Banco();
	
	public ControladorTelaCadastroClientePessoaJuridica(VisaoFramePrincipal frame) {
		framePrincipal = frame;
		inicializaTela();
		desabilitadosEHabilitadosInicialmente();
		addEventos();
	}
	
	public void addEventos() {
		getBotaoBuscarAction();
		getBotaoIncluirAction();
		getBotaoExcluirAction();
		getBotaoAlterarAction();
		getBotaoCancelarAction();
		getBotaoConfirmarAction();
		getBotaoFecharAction();
		getSelecionarUmClienteTabela();
		getSelecionarUmClienteTabelaTyped();
	}
	
	private void getBotaoAlterarAction() {
		tcj.getTelaPesquisa().getButtonAlterar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				if(tcj.getTelaPesquisa().getJTableDadosCliente().getSelectedRow() != -1) {					
					tcj.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Jurídica - Alteração de cliente");
					int linhaSelecionada = tcj.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
					ModeloClientePessoaJuridica cliente = tcj.getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);
					
					clienteAntigo = new ModeloClientePessoaJuridica();
					clienteAntigo = cliente;
					atribuicaoDeBuscaAosCampos(clienteAntigo);					
					
					camposHabilitadosAoIncluirOuAlterar(true);
					botoesHabilitadosEDesabilitadosAoIncluirOuAlterar(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente da lista exibida pela busca"
							  , "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
	}

	private void getBotaoExcluirAction() {
		tcj.getTelaPesquisa().getButtonExcluir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				if(tcj.getTelaPesquisa().getJTableDadosCliente().getSelectedRow() != -1) {					
					tcj.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Jurídica - Exclusão de cliente");
					int linhaSelecionada = tcj.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
					ModeloClientePessoaJuridica cliente = tcj.getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);
					
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Deseja excluir o cliente de Razão Social: '" + cliente.getRazaoSocial() +"' ?", "Exclusão",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  tcj.getBuscaExibicaoTableModel(true).removerCliente(linhaSelecionada);
				    	  String cnpjBusca = cliente.getCnpj();
				    	  String idBusca = banco.consultar("cliente", "cnpj" , cnpjBusca, "ENDERECO_id");
				    	  if(new DadosClientePessoaJuridica().bancoDeDadosExcluir(cnpjBusca, idBusca) == true) {
				
				    		  limparCamposGeral();
				    		  desabilitadosEHabilitadosInicialmente();
				    	  }				    	  
				      }										
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente da lista exibida pela busca!"
							  , "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
//				camposHabilitadosAoIncluirOuAlterar(true);
//				botoesHabilitadosEDesabilitadosAoIncluirOuAlterar(true);
			}
		});
	}

	private void getBotaoCancelarAction() {
		tcj.getTelaPesquisa().getButtonCancelar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "NÃO", "SIM" };
			      int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar o procedimento atual?", "Cancelamento",
			          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			              null, options, options[0]);
			      
			      if(opcao == 1) {
			    	  limparCamposGeral();
			    	  desabilitadosEHabilitadosInicialmente();
			      }	
			}
		});
	}

	private void getBotaoConfirmarAction() {
		tcj.getTelaPesquisa().getButtonConfirmar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "Fazer validação Regex para os campos especiais e validação geral pros campos!", "Validação", JOptionPane.INFORMATION_MESSAGE);
				if(tcj.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Inclusão de cliente")) {
					capturarCampos();
					if(validacaoClienteCampos("Incluir") == true) {
						limparCamposGeral();
						desabilitadosEHabilitadosInicialmente();	
					}	
				}
				else if(tcj.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Exclusão de cliente")) {
					
				}
				else if(tcj.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Alteração de cliente")) {
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Confirma a alteração dos dados do cliente tratado?", "Confirmar",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  capturarCampos();
							if(validacaoClienteCampos("Alterar") == true) {
								limparCamposGeral();
								desabilitadosEHabilitadosInicialmente();	
							}
				      }	
				}
					
			}
		});
	}

	private void getBotaoFecharAction() {
		tcj.getTelaPesquisa().getButtonFechar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "NÃO", "SIM" };
			      int opcao = JOptionPane.showOptionDialog(null, "Deseja retornar a tela de cadastro de clientes?", "Fechar",
			          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			              null, options, options[0]);
			      
			      if(opcao == 1) {
			    	  getControladorTelaCadastroCliente(framePrincipal);
			      }			
			}
		});
	}

	private void getBotaoBuscarAction() {
		tcj.getTelaPesquisa().getButtonBuscar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(buscaNoArrayToTabela() == true) {
					botoesHabilitadosPosBusca(true);					
				}				
			}
		});				
	}
	
	private void getBotaoIncluirAction() {
		tcj.getTelaPesquisa().getButtonIncluir().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tcj.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Jurídica - Inclusão de cliente");
				camposHabilitadosAoIncluirOuAlterar(true);
				botoesHabilitadosEDesabilitadosAoIncluirOuAlterar(true);
				
			}	
		});
		
	}
	
	public void inicializaTela() {		
		getTelaClienteJuridico();
		adicionarTela();
		tcj = telaClienteJuridico;//uma variavel nova que igualei a original da tela, pra nao ter que escrever isso tudo na hora de alterar :P
	}
	
	public VisaoTelaCadastroClientePessoaJuridica getTelaClienteJuridico() {
		if(telaClienteJuridico == null) {
			telaClienteJuridico = new VisaoTelaCadastroClientePessoaJuridica();
		}
		return telaClienteJuridico;
	}
	
	private void adicionarTela() {
		framePrincipal.getContentPane().removeAll();
		framePrincipal.setContentPane(telaClienteJuridico);
		framePrincipal.repaint();
		framePrincipal.validate();
	}
	
	private void desabilitadosEHabilitadosInicialmente() {
		botoesDesablitadosEHabilitadosInicialmente();
		camposDesabilitadosInicialmente();
	}
	
	private void botoesDesablitadosEHabilitadosInicialmente() {
		tcj.getTelaPesquisa().getButtonExcluir().setEnabled(false);
		tcj.getTelaPesquisa().getButtonAlterar().setEnabled(false);
		tcj.getTelaPesquisa().getButtonCancelar().setEnabled(false);
		tcj.getTelaPesquisa().getButtonConfirmar().setEnabled(false);
		tcj.getTelaPesquisa().getButtonIncluir().setEnabled(true);
		tcj.getTelaPesquisa().getButtonBuscar().setEnabled(true);
	}
	
	public void botoesHabilitadosEDesabilitadosAoIncluirOuAlterar(boolean b) {
		tcj.getTelaPesquisa().getButtonConfirmar().setEnabled(b);
		tcj.getTelaPesquisa().getButtonCancelar().setEnabled(b);
		tcj.getTelaPesquisa().getButtonIncluir().setEnabled(!b);
		tcj.getTelaPesquisa().getButtonExcluir().setEnabled(!b);
		tcj.getTelaPesquisa().getButtonAlterar().setEnabled(!b);
	}		
	
	private void camposDesabilitadosInicialmente() {
		tcj.getComboBoxSituacaoCliente().setEnabled(false);
		tcj.getValidacaoGeralJTextFieldRazaoSocial().setEnabled(false);
		tcj.getValidacaoJTextFieldCnpj().setEnabled(false);
		tcj.getValidacaoGeralJTextFieldRepresentante().setEnabled(false);
		tcj.getValidacaoJTextFieldInscricaoEstadual().setEnabled(false);
		tcj.getComboBoxUfInscricaoEstadual().setEnabled(false);
		tcj.getFormattedTextFieldCEP().setEnabled(false);
		tcj.getValidacaoGeralJTextFieldLogradouro().setEnabled(false);
		tcj.getValidacaoGeralJTextFieldNumero().setEnabled(false);
		tcj.getValidacaoGeralJTextFieldBairro().setEnabled(false);
		tcj.getValidacaoGeralJTextFieldComplemento().setEnabled(false);
		tcj.getValidacaoGeralJTextFieldCidade().setEnabled(false);
		tcj.getComboBoxEstadoEndereco().setEnabled(false);
		tcj.getFormattedTextFieldTelefone().setEnabled(false);
		tcj.getValidacaoJTextFieldEmail().setEnabled(false);
		tcj.getValidacaoJTextFieldLimiteCredito().setEnabled(false);
	}
	
	public void camposHabilitadosAoIncluirOuAlterar(boolean b) {
		tcj.getComboBoxSituacaoCliente().setEnabled(b);
		tcj.getValidacaoGeralJTextFieldRazaoSocial().setEnabled(b);
		tcj.getValidacaoJTextFieldCnpj().setEnabled(b);
		tcj.getValidacaoGeralJTextFieldRepresentante().setEnabled(b);
		tcj.getValidacaoJTextFieldInscricaoEstadual().setEnabled(b);
		tcj.getComboBoxUfInscricaoEstadual().setEnabled(b);
		tcj.getFormattedTextFieldCEP().setEnabled(b);
		tcj.getValidacaoGeralJTextFieldLogradouro().setEnabled(b);
		tcj.getValidacaoGeralJTextFieldNumero().setEnabled(b);
		tcj.getValidacaoGeralJTextFieldBairro().setEnabled(b);
		tcj.getValidacaoGeralJTextFieldComplemento().setEnabled(b);
		tcj.getValidacaoGeralJTextFieldCidade().setEnabled(b);
		tcj.getComboBoxEstadoEndereco().setEnabled(b);
		tcj.getFormattedTextFieldTelefone().setEnabled(b);
		tcj.getValidacaoJTextFieldEmail().setEnabled(b);
		tcj.getValidacaoJTextFieldLimiteCredito().setEnabled(b);
	}
	
	private void limparCamposGeral() {
		tcj.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Jurídica");
		tcj.getComboBoxSituacaoCliente().setSelectedIndex(0);
		tcj.getValidacaoGeralJTextFieldRazaoSocial().setText("");
		tcj.getValidacaoJTextFieldCnpj().setText("");
		tcj.getValidacaoGeralJTextFieldRepresentante().setText("");
		tcj.getValidacaoJTextFieldInscricaoEstadual().setText("");
		tcj.getComboBoxUfInscricaoEstadual().setSelectedIndex(0);
		tcj.getFormattedTextFieldCEP().setText("");
		tcj.getValidacaoGeralJTextFieldLogradouro().setText("");
		tcj.getValidacaoGeralJTextFieldNumero().setText("");
		tcj.getValidacaoGeralJTextFieldBairro().setText("");
		tcj.getValidacaoGeralJTextFieldComplemento().setText("");
		tcj.getValidacaoGeralJTextFieldCidade().setText("");
		tcj.getComboBoxEstadoEndereco().setSelectedIndex(0);
		tcj.getFormattedTextFieldTelefone().setText("");
		tcj.getValidacaoJTextFieldEmail().setText("");
		tcj.getValidacaoJTextFieldLimiteCredito().setText("");
		tcj.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		tcj.getTelaPesquisa().getTextFieldEntradaDado().setText("");
		tcj.getTelaPesquisa().getJTableDadosCliente().setModel(tcj.getBuscaExibicaoTableModel(false));
	}	

	private void limparCampos() {
		tcj.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Jurídica");
		tcj.getComboBoxSituacaoCliente().setSelectedIndex(0);
		tcj.getValidacaoGeralJTextFieldRazaoSocial().setText("");
		tcj.getValidacaoJTextFieldCnpj().setText("");
		tcj.getValidacaoGeralJTextFieldRepresentante().setText("");
		tcj.getValidacaoJTextFieldInscricaoEstadual().setText("");
		tcj.getComboBoxUfInscricaoEstadual().setSelectedIndex(0);
		tcj.getFormattedTextFieldCEP().setText("");
		tcj.getValidacaoGeralJTextFieldLogradouro().setText("");
		tcj.getValidacaoGeralJTextFieldNumero().setText("");
		tcj.getValidacaoGeralJTextFieldBairro().setText("");
		tcj.getValidacaoGeralJTextFieldComplemento().setText("");
		tcj.getValidacaoGeralJTextFieldCidade().setText("");
		tcj.getComboBoxEstadoEndereco().setSelectedIndex(0);
		tcj.getFormattedTextFieldTelefone().setText("");
		tcj.getValidacaoJTextFieldEmail().setText("");
		tcj.getValidacaoJTextFieldLimiteCredito().setText("");
		tcj.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		tcj.getTelaPesquisa().getTextFieldEntradaDado().setText("");
		tcj.getTelaPesquisa().getJTableDadosCliente().setModel(tcj.getBuscaExibicaoTableModel(false));
	}
	
	public void botoesHabilitadosPosBusca(boolean b) {
		tcj.getTelaPesquisa().getButtonExcluir().setEnabled(b);
		tcj.getTelaPesquisa().getButtonAlterar().setEnabled(b);
		tcj.getTelaPesquisa().getButtonCancelar().setEnabled(b);
		tcj.getTelaPesquisa().getButtonIncluir().setEnabled(!b);
	}
	
	public void getSelecionarUmClienteTabelaTyped() {
		tcj.getTelaPesquisa().getJTableDadosCliente().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Cancelar",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  clienteExibicao = new ModeloClientePessoaJuridica();
				    	  int linhaSelecionada = tcj.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
				    	  clienteExibicao = tcj.getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
				    	  atribuicaoDeBuscaAosCampos(clienteExibicao);
				      }
				}			
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					if(tcj.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Inclusão de cliente")) {
						Object[] options = { "NÃO", "SIM" };
					      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Cancelar",
					          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					              null, options, options[0]);
					      
					      if(opcao == 1) {
					    	  clienteExibicao = new ModeloClientePessoaJuridica();
					    	  int linhaSelecionada = tcj.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
					    	  clienteExibicao = tcj.getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
					    	  atribuicaoDeBuscaAosCampos(clienteExibicao);
					      }
					}
					else {
						clienteExibicao = new ModeloClientePessoaJuridica();
						int linhaSelecionada = tcj.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
						clienteExibicao = tcj.getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
						atribuicaoDeBuscaAosCampos(clienteExibicao);
					}
				}
				else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					if(tcj.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Inclusão de cliente")) {
						Object[] options = { "NÃO", "SIM" };
					      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Cancelar",
					          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					              null, options, options[0]);
					      
					      if(opcao == 1) {
					    	  clienteExibicao = new ModeloClientePessoaJuridica();
					    	  int linhaSelecionada = tcj.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
					    	  clienteExibicao = tcj.getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
					    	  atribuicaoDeBuscaAosCampos(clienteExibicao);
					      }
					}
					else {
						clienteExibicao = new ModeloClientePessoaJuridica();
						int linhaSelecionada = tcj.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
						clienteExibicao = tcj.getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
						atribuicaoDeBuscaAosCampos(clienteExibicao);
					}
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
									
			}
		});
	}
	
	private void getSelecionarUmClienteTabela() {
		tcj.getTelaPesquisa().getJTableDadosCliente().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getClickCount() == 1) {
					if(tcj.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Inclusão de cliente")) {
						Object[] options = { "NÃO", "SIM" };
					      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Fechar",
					          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					              null, options, options[0]);
					      
					      if(opcao == 1) {
					    	  clienteExibicao = new ModeloClientePessoaJuridica();
					    	  int linhaSelecionada = tcj.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
					    	  clienteExibicao = tcj.getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
					    	  atribuicaoDeBuscaAosCampos(clienteExibicao);
					      }
					}
					else {
						clienteExibicao = new ModeloClientePessoaJuridica();
						int linhaSelecionada = tcj.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
						clienteExibicao = tcj.getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
						atribuicaoDeBuscaAosCampos(clienteExibicao);
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
	
	public void atribuicaoDeBuscaAosCampos(ModeloClientePessoaJuridica cliente) {
		tcj.getComboBoxSituacaoCliente().setSelectedItem(cliente.getSituacao());
		tcj.getValidacaoGeralJTextFieldRazaoSocial().setText(cliente.getRazaoSocial());
		tcj.getValidacaoJTextFieldCnpj().setText(cliente.getCnpj());
		tcj.getValidacaoGeralJTextFieldRepresentante().setText(cliente.getRepresentante());
		tcj.getValidacaoJTextFieldInscricaoEstadual().setText(cliente.getInscricaoEstadual());
		tcj.getComboBoxUfInscricaoEstadual().setSelectedItem(cliente.getInscricaoEstadualUF());
		tcj.getFormattedTextFieldCEP().setText(cliente.getCep());
		tcj.getValidacaoGeralJTextFieldLogradouro().setText(cliente.getLogradouro());
		tcj.getValidacaoGeralJTextFieldNumero().setText(cliente.getNumeroEndereco());
		tcj.getValidacaoGeralJTextFieldBairro().setText(cliente.getBairro());
		tcj.getValidacaoGeralJTextFieldComplemento().setText(cliente.getComplemento());
		tcj.getValidacaoGeralJTextFieldCidade().setText(cliente.getCidade());
		tcj.getComboBoxEstadoEndereco().setSelectedItem(cliente.getUf_estado());
		tcj.getFormattedTextFieldTelefone().setText(cliente.getTelefone());
		tcj.getValidacaoJTextFieldEmail().setText(cliente.getEmail());
		tcj.getValidacaoJTextFieldLimiteCredito().setText(String.valueOf(cliente.getLimiteCredito()));
		tcj.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		tcj.getTelaPesquisa().getTextFieldEntradaDado().setText("");
	}

	private boolean buscaNoArrayToTabela() {
		String tipoBusca, valorBusca;
		
		tipoBusca = tcj.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString();
		valorBusca = tcj.getTelaPesquisa().getTextFieldEntradaDado().getText();
		
		if(!tipoBusca.equals("Selecione")) {		
			if(!valorBusca.trim().equals("")) {
				if(tipoBusca.equals("Razão Social")) {
					DadosClientePessoaJuridica cliente = new DadosClientePessoaJuridica();
					tcj.getTelaPesquisa().getJTableDadosCliente().setModel(tcj.getBuscaExibicaoTableModel(false));//seta uma nova tabela, só pra exibição dos resultados da busca
					
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
									tcj.getBuscaExibicaoTableModel(true).addCliente(clientePessoa);
								}
							}
						}				
					}
					if(tcj.getBuscaExibicaoTableModel(true).getRowCount() > 0) {
						//JOptionPane.showMessageDialog(null, "Busca finalizada, " + tcj.getBuscaExibicaoTableModel(true).getRowCount() + " clientes encontrados.", "Busca", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum cliente encontrado."
								  , "Busca", JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
				}
				else if(tipoBusca.equals("CNPJ")) {
					DadosClientePessoaJuridica cliente = new DadosClientePessoaJuridica();
					tcj.getTelaPesquisa().getJTableDadosCliente().setModel(tcj.getBuscaExibicaoTableModel(false));//seta uma nova tabela, só pra exibição dos resultados da busca
					
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
									tcj.getBuscaExibicaoTableModel(true).addCliente(clientePessoa);
								}
							}
						}				
					}	
					if(tcj.getBuscaExibicaoTableModel(true).getRowCount() > 0) {
						//JOptionPane.showMessageDialog(null, "Busca finalizada, " + tcj.getBuscaExibicaoTableModel(true).getRowCount() + " clientes encontrados.", "Busca", JOptionPane.INFORMATION_MESSAGE);
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
	
	private void capturarCampos() {
		clienteAtual = new ModeloClientePessoaJuridica();
		this.clienteAtual.setSituacao(tcj.getComboBoxSituacaoCliente().getSelectedItem().toString());
		this.clienteAtual.setRazaoSocial(tcj.getValidacaoGeralJTextFieldRazaoSocial().getText());
		this.clienteAtual.setCnpj(tcj.getValidacaoJTextFieldCnpj().getText());
		this.clienteAtual.setRepresentante(tcj.getValidacaoGeralJTextFieldRepresentante().getText());
		this.clienteAtual.setInscricaoEstadual(tcj.getValidacaoJTextFieldInscricaoEstadual().getText());
		this.clienteAtual.setInscricaoEstadualUF(tcj.getComboBoxUfInscricaoEstadual().getSelectedItem().toString());
		
		try {
			this.clienteAtual.setLimiteCredito(Double.parseDouble(tcj.getValidacaoJTextFieldLimiteCredito().getText()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			this.clienteAtual.setLimiteCredito(-1);
			//System.out.println(cliente.getLimiteCredito());
		}
						
		this.clienteAtual.setCep(tcj.getFormattedTextFieldCEP().getText());
		this.clienteAtual.setLogradouro(tcj.getValidacaoGeralJTextFieldLogradouro().getText());
		this.clienteAtual.setNumeroEndereco(tcj.getValidacaoGeralJTextFieldNumero().getText());
		this.clienteAtual.setBairro(tcj.getValidacaoGeralJTextFieldBairro().getText());
		this.clienteAtual.setComplemento(tcj.getValidacaoGeralJTextFieldComplemento().getText());
		this.clienteAtual.setCidade(tcj.getValidacaoGeralJTextFieldCidade().getText());
		this.clienteAtual.setUf_estado(tcj.getComboBoxEstadoEndereco().getSelectedItem().toString());
		this.clienteAtual.setTelefone(tcj.getFormattedTextFieldTelefone().getText());
		this.clienteAtual.setEmail(tcj.getValidacaoJTextFieldEmail().getText());
	}
	
	private boolean validacaoClienteCampos(String b) {
		ValidacaoClientePessoaJuridica clienteJ;
		
		if(b.equals("Alterar")) {
			DadosClientePessoaJuridica clienteSalvo = new DadosClientePessoaJuridica();
			String id_end;
			
			clienteJ = new ValidacaoClientePessoaJuridica(clienteAtual);
			id_end = banco.consultar("cliente", "cnpj" , clienteAntigo.getCnpj(), "ENDERECO_id");
			
			if(clienteJ.isResultadoValidacaoTodosCamposGeral() == true) {					
				
				clienteSalvo.bancoDeDadosAlterar(clienteAtual, clienteAntigo.getCnpj(), id_end);
				
				return true;
			}			
					
		}
		
		else if(b.equals("Incluir")) {
			DadosClientePessoaJuridica clienteSalvo = new DadosClientePessoaJuridica();
			
			clienteJ = new ValidacaoClientePessoaJuridica(clienteAtual);
			clienteJ .validarCNPJ();
			
			if(clienteJ.isResultadoValidacaoTodosCamposGeral() == true && clienteJ.isResultadoValidacaoCnpjEInscricaoEstadual() == true) {
				
				clienteSalvo.bancoDeDadosIncluir(clienteAtual);
				
				return true;
			}
		}
		
		
		return false;
	}
	
	public ControladorTelaCadastroCliente getControladorTelaCadastroCliente(VisaoFramePrincipal frame) {
		if(controladorTelaCadastroCliente == null) {
			controladorTelaCadastroCliente = new ControladorTelaCadastroCliente(frame);
		}		
		return controladorTelaCadastroCliente;				
	}
}
