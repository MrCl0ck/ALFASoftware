package controle.cadastros.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.Banco;
import modelo.cadastros.cliente.ModeloClientePessoaJuridica;
import modelo.cadastros.dados.DadosClientePessoaJuridica;
import modelo.cadastros.validacoes.ValidacaoClientePessoaJuridica;
import visao.cadastros.cliente.VisaoFramePrincipal;
import visao.cadastros.cliente.VisaoTelaCadastroCliente;
import visao.cadastros.cliente.VisaoTelaCadastroClientePessoaJuridica;

public class ControladorTelaCadastroClientePessoaJuridica{
	private ModeloClientePessoaJuridica clienteAtual;
	private ModeloClientePessoaJuridica clienteExibicao;
	private ModeloClientePessoaJuridica clienteAntigo;
	private VisaoTelaCadastroCliente principal;
	private Banco banco = new Banco();
	
	public ControladorTelaCadastroClientePessoaJuridica(VisaoTelaCadastroCliente frame) {
		principal = frame;
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
		principal.getTelaPesquisa().getButtonAlterar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				if(principal.getTelaPesquisa().getJTableDados().getSelectedRow() != -1) {					
					principal.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Jurídica - Alteração de cliente");
					int linhaSelecionada = principal.getTelaPesquisa().getJTableDados().getSelectedRow();					
					ModeloClientePessoaJuridica cliente = principal.getTelaJuridica().getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);
					
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
		principal.getTelaPesquisa().getButtonExcluir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				if(principal.getTelaPesquisa().getJTableDados().getSelectedRow() != -1) {					
					principal.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Jurídica - Exclusão de cliente");
					int linhaSelecionada = principal.getTelaPesquisa().getJTableDados().getSelectedRow();					
					ModeloClientePessoaJuridica cliente = principal.getTelaJuridica().getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);
					
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Deseja excluir o cliente de Razão Social: '" + cliente.getRazaoSocial() +"' ?", "Exclusão",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  principal.getTelaJuridica().getBuscaExibicaoTableModel(true).removerCliente(linhaSelecionada);
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
		principal.getTelaPesquisa().getButtonCancelar().addActionListener(new ActionListener() {
			
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
		principal.getTelaPesquisa().getButtonConfirmar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "Fazer validação Regex para os campos especiais e validação geral pros campos!", "Validação", JOptionPane.INFORMATION_MESSAGE);
				if(principal.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Inclusão de cliente")) {
					capturarCampos();
					if(validacaoClienteCampos("Incluir") == true) {
						limparCamposGeral();
						desabilitadosEHabilitadosInicialmente();	
					}	
				}
				else if(principal.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Exclusão de cliente")) {
					
				}
				else if(principal.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Alteração de cliente")) {
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
		principal.getTelaPesquisa().getButtonFechar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "NÃO", "SIM" };
			      int opcao = JOptionPane.showOptionDialog(null, "Deseja retornar a tela de cadastro de clientes?", "Fechar",
			          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			              null, options, options[0]);
			      
			      if(opcao == 1) {
			    	  principal.removeTelaFisica();
			    	  principal.add(principal.getPanel());
			    	  principal.repaint();
			    	  principal.validate();
			    	  principal.getComboBoxTipoCliente().setSelectedItem("Selecione");
			    	  principal.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente");
			      }			
			}
		});
	}

	private void getBotaoBuscarAction() {
		principal.getTelaPesquisa().getButtonBuscar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(buscaNoArrayToTabela() == true) {
					botoesHabilitadosPosBusca(true);					
				}				
			}
		});				
	}
	
	private void getBotaoIncluirAction() {
		principal.getTelaPesquisa().getButtonIncluir().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				principal.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Jurídica - Inclusão de cliente");
				camposHabilitadosAoIncluirOuAlterar(true);
				botoesHabilitadosEDesabilitadosAoIncluirOuAlterar(true);
				
			}	
		});
		
	}
	
	private void desabilitadosEHabilitadosInicialmente() {
		botoesDesablitadosEHabilitadosInicialmente();
		camposDesabilitadosInicialmente();
	}
	
	private void botoesDesablitadosEHabilitadosInicialmente() {
		principal.getTelaPesquisa().getButtonExcluir().setEnabled(false);
		principal.getTelaPesquisa().getButtonAlterar().setEnabled(false);
		principal.getTelaPesquisa().getButtonCancelar().setEnabled(false);
		principal.getTelaPesquisa().getButtonConfirmar().setEnabled(false);
		principal.getTelaPesquisa().getButtonIncluir().setEnabled(true);
		principal.getTelaPesquisa().getButtonBuscar().setEnabled(true);
	}
	
	public void botoesHabilitadosEDesabilitadosAoIncluirOuAlterar(boolean b) {
		principal.getTelaPesquisa().getButtonConfirmar().setEnabled(b);
		principal.getTelaPesquisa().getButtonCancelar().setEnabled(b);
		principal.getTelaPesquisa().getButtonIncluir().setEnabled(!b);
		principal.getTelaPesquisa().getButtonExcluir().setEnabled(!b);
		principal.getTelaPesquisa().getButtonAlterar().setEnabled(!b);
	}		
	
	private void camposDesabilitadosInicialmente() {
		principal.getTelaJuridica().getComboBoxSituacaoCliente().setEnabled(false);
		principal.getTelaJuridica().getValidacaoGeralJTextFieldRazaoSocial().setEnabled(false);
		principal.getTelaJuridica().getValidacaoJTextFieldCnpj().setEnabled(false);
		principal.getTelaJuridica().getValidacaoGeralJTextFieldRepresentante().setEnabled(false);
		principal.getTelaJuridica().getValidacaoJTextFieldInscricaoEstadual().setEnabled(false);
		principal.getTelaJuridica().getComboBoxUfInscricaoEstadual().setEnabled(false);
		principal.getTelaJuridica().getFormattedTextFieldCEP().setEnabled(false);
		principal.getTelaJuridica().getValidacaoGeralJTextFieldLogradouro().setEnabled(false);
		principal.getTelaJuridica().getValidacaoGeralJTextFieldNumero().setEnabled(false);
		principal.getTelaJuridica().getValidacaoGeralJTextFieldBairro().setEnabled(false);
		principal.getTelaJuridica().getValidacaoGeralJTextFieldComplemento().setEnabled(false);
		principal.getTelaJuridica().getValidacaoGeralJTextFieldCidade().setEnabled(false);
		principal.getTelaJuridica().getComboBoxEstadoEndereco().setEnabled(false);
		principal.getTelaJuridica().getFormattedTextFieldTelefone().setEnabled(false);
		principal.getTelaJuridica().getValidacaoJTextFieldEmail().setEnabled(false);
		principal.getTelaJuridica().getValidacaoJTextFieldLimiteCredito().setEnabled(false);
	}
	
	public void camposHabilitadosAoIncluirOuAlterar(boolean b) {
		principal.getTelaJuridica().getComboBoxSituacaoCliente().setEnabled(b);
		principal.getTelaJuridica().getValidacaoGeralJTextFieldRazaoSocial().setEnabled(b);
		principal.getTelaJuridica().getValidacaoJTextFieldCnpj().setEnabled(b);
		principal.getTelaJuridica().getValidacaoGeralJTextFieldRepresentante().setEnabled(b);
		principal.getTelaJuridica().getValidacaoJTextFieldInscricaoEstadual().setEnabled(b);
		principal.getTelaJuridica().getComboBoxUfInscricaoEstadual().setEnabled(b);
		principal.getTelaJuridica().getFormattedTextFieldCEP().setEnabled(b);
		principal.getTelaJuridica().getValidacaoGeralJTextFieldLogradouro().setEnabled(b);
		principal.getTelaJuridica().getValidacaoGeralJTextFieldNumero().setEnabled(b);
		principal.getTelaJuridica().getValidacaoGeralJTextFieldBairro().setEnabled(b);
		principal.getTelaJuridica().getValidacaoGeralJTextFieldComplemento().setEnabled(b);
		principal.getTelaJuridica().getValidacaoGeralJTextFieldCidade().setEnabled(b);
		principal.getTelaJuridica().getComboBoxEstadoEndereco().setEnabled(b);
		principal.getTelaJuridica().getFormattedTextFieldTelefone().setEnabled(b);
		principal.getTelaJuridica().getValidacaoJTextFieldEmail().setEnabled(b);
		principal.getTelaJuridica().getValidacaoJTextFieldLimiteCredito().setEnabled(b);
	}
	
	private void limparCamposGeral() {
		principal.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Jurídica");
		principal.getTelaJuridica().getComboBoxSituacaoCliente().setSelectedIndex(0);
		principal.getTelaJuridica().getValidacaoGeralJTextFieldRazaoSocial().setText("");
		principal.getTelaJuridica().getValidacaoJTextFieldCnpj().setText("");
		principal.getTelaJuridica().getValidacaoGeralJTextFieldRepresentante().setText("");
		principal.getTelaJuridica().getValidacaoJTextFieldInscricaoEstadual().setText("");
		principal.getTelaJuridica().getComboBoxUfInscricaoEstadual().setSelectedIndex(0);
		principal.getTelaJuridica().getFormattedTextFieldCEP().setText("");
		principal.getTelaJuridica().getValidacaoGeralJTextFieldLogradouro().setText("");
		principal.getTelaJuridica().getValidacaoGeralJTextFieldNumero().setText("");
		principal.getTelaJuridica().getValidacaoGeralJTextFieldBairro().setText("");
		principal.getTelaJuridica().getValidacaoGeralJTextFieldComplemento().setText("");
		principal.getTelaJuridica().getValidacaoGeralJTextFieldCidade().setText("");
		principal.getTelaJuridica().getComboBoxEstadoEndereco().setSelectedIndex(0);
		principal.getTelaJuridica().getFormattedTextFieldTelefone().setText("");
		principal.getTelaJuridica().getValidacaoJTextFieldEmail().setText("");
		principal.getTelaJuridica().getValidacaoJTextFieldLimiteCredito().setText("");
		principal.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		principal.getTelaPesquisa().getTextFieldEntradaDado().setText("");
		principal.getTelaPesquisa().getJTableDados().setModel(principal.getTelaJuridica().getBuscaExibicaoTableModel(false));
	}	
	
	public void botoesHabilitadosPosBusca(boolean b) {
		principal.getTelaPesquisa().getButtonExcluir().setEnabled(b);
		principal.getTelaPesquisa().getButtonAlterar().setEnabled(b);
		principal.getTelaPesquisa().getButtonCancelar().setEnabled(b);
		principal.getTelaPesquisa().getButtonIncluir().setEnabled(!b);
	}
	
	public void getSelecionarUmClienteTabelaTyped() {
		principal.getTelaPesquisa().getJTableDados().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Cancelar",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  clienteExibicao = new ModeloClientePessoaJuridica();
				    	  int linhaSelecionada = principal.getTelaPesquisa().getJTableDados().getSelectedRow();					
				    	  clienteExibicao = principal.getTelaJuridica().getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
				    	  atribuicaoDeBuscaAosCampos(clienteExibicao);
				      }
				}			
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					if(principal.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Inclusão de cliente")) {
						Object[] options = { "NÃO", "SIM" };
					      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Cancelar",
					          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					              null, options, options[0]);
					      
					      if(opcao == 1) {
					    	  clienteExibicao = new ModeloClientePessoaJuridica();
					    	  int linhaSelecionada = principal.getTelaPesquisa().getJTableDados().getSelectedRow();					
					    	  clienteExibicao = principal.getTelaJuridica().getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
					    	  atribuicaoDeBuscaAosCampos(clienteExibicao);
					      }
					}
					else {
						clienteExibicao = new ModeloClientePessoaJuridica();
						int linhaSelecionada = principal.getTelaPesquisa().getJTableDados().getSelectedRow();					
						clienteExibicao = principal.getTelaJuridica().getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
						atribuicaoDeBuscaAosCampos(clienteExibicao);
					}
				}
				else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					if(principal.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Inclusão de cliente")) {
						Object[] options = { "NÃO", "SIM" };
					      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Cancelar",
					          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					              null, options, options[0]);
					      
					      if(opcao == 1) {
					    	  clienteExibicao = new ModeloClientePessoaJuridica();
					    	  int linhaSelecionada = principal.getTelaPesquisa().getJTableDados().getSelectedRow();					
					    	  clienteExibicao = principal.getTelaJuridica().getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
					    	  atribuicaoDeBuscaAosCampos(clienteExibicao);
					      }
					}
					else {
						clienteExibicao = new ModeloClientePessoaJuridica();
						int linhaSelecionada = principal.getTelaPesquisa().getJTableDados().getSelectedRow();					
						clienteExibicao = principal.getTelaJuridica().getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
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
		principal.getTelaPesquisa().getJTableDados().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getClickCount() == 1) {
					if(principal.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Inclusão de cliente")) {
						Object[] options = { "NÃO", "SIM" };
					      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Fechar",
					          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					              null, options, options[0]);
					      
					      if(opcao == 1) {
					    	  clienteExibicao = new ModeloClientePessoaJuridica();
					    	  int linhaSelecionada = principal.getTelaPesquisa().getJTableDados().getSelectedRow();					
					    	  clienteExibicao = principal.getTelaJuridica().getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
					    	  atribuicaoDeBuscaAosCampos(clienteExibicao);
					      }
					}
					else {
						clienteExibicao = new ModeloClientePessoaJuridica();
						int linhaSelecionada = principal.getTelaPesquisa().getJTableDados().getSelectedRow();					
						clienteExibicao = principal.getTelaJuridica().getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
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
		principal.getTelaJuridica().getComboBoxSituacaoCliente().setSelectedItem(cliente.getSituacao());
		principal.getTelaJuridica().getValidacaoGeralJTextFieldRazaoSocial().setText(cliente.getRazaoSocial());
		principal.getTelaJuridica().getValidacaoJTextFieldCnpj().setText(cliente.getCnpj());
		principal.getTelaJuridica().getValidacaoGeralJTextFieldRepresentante().setText(cliente.getRepresentante());
		principal.getTelaJuridica().getValidacaoJTextFieldInscricaoEstadual().setText(cliente.getInscricaoEstadual());
		principal.getTelaJuridica().getComboBoxUfInscricaoEstadual().setSelectedItem(cliente.getInscricaoEstadualUF());
		principal.getTelaJuridica().getFormattedTextFieldCEP().setText(cliente.getCep());
		principal.getTelaJuridica().getValidacaoGeralJTextFieldLogradouro().setText(cliente.getLogradouro());
		principal.getTelaJuridica().getValidacaoGeralJTextFieldNumero().setText(cliente.getNumeroEndereco());
		principal.getTelaJuridica().getValidacaoGeralJTextFieldBairro().setText(cliente.getBairro());
		principal.getTelaJuridica().getValidacaoGeralJTextFieldComplemento().setText(cliente.getComplemento());
		principal.getTelaJuridica().getValidacaoGeralJTextFieldCidade().setText(cliente.getCidade());
		principal.getTelaJuridica().getComboBoxEstadoEndereco().setSelectedItem(cliente.getUf_estado());
		principal.getTelaJuridica().getFormattedTextFieldTelefone().setText(cliente.getTelefone());
		principal.getTelaJuridica().getValidacaoJTextFieldEmail().setText(cliente.getEmail());
		principal.getTelaJuridica().getValidacaoJTextFieldLimiteCredito().setText(String.valueOf(cliente.getLimiteCredito()));
		principal.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		principal.getTelaPesquisa().getTextFieldEntradaDado().setText("");
	}

	private boolean buscaNoArrayToTabela() {
		String tipoBusca, valorBusca;
		
		tipoBusca = principal.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString();
		valorBusca = principal.getTelaPesquisa().getTextFieldEntradaDado().getText();
		
		if(!tipoBusca.equals("Selecione")) {		
			if(!valorBusca.trim().equals("")) {
				if(tipoBusca.equals("Razão Social")) {
					DadosClientePessoaJuridica cliente = new DadosClientePessoaJuridica();
					principal.getTelaPesquisa().getJTableDados().setModel(principal.getTelaJuridica().getBuscaExibicaoTableModel(false));//seta uma nova tabela, só pra exibição dos resultados da busca
					
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
									principal.getTelaJuridica().getBuscaExibicaoTableModel(true).addCliente(clientePessoa);
								}
							}
						}				
					}
					if(principal.getTelaJuridica().getBuscaExibicaoTableModel(true).getRowCount() > 0) {
						//JOptionPane.showMessageDialog(null, "Busca finalizada, " + principal.getBuscaExibicaoTableModel(true).getRowCount() + " clientes encontrados.", "Busca", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum cliente encontrado."
								  , "Busca", JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
				}
				else if(tipoBusca.equals("CNPJ")) {
					DadosClientePessoaJuridica cliente = new DadosClientePessoaJuridica();
					principal.getTelaPesquisa().getJTableDados().setModel(principal.getTelaJuridica().getBuscaExibicaoTableModel(false));//seta uma nova tabela, só pra exibição dos resultados da busca
					
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
									principal.getTelaJuridica().getBuscaExibicaoTableModel(true).addCliente(clientePessoa);
								}
							}
						}				
					}	
					if(principal.getTelaJuridica().getBuscaExibicaoTableModel(true).getRowCount() > 0) {
						//JOptionPane.showMessageDialog(null, "Busca finalizada, " + principal.getBuscaExibicaoTableModel(true).getRowCount() + " clientes encontrados.", "Busca", JOptionPane.INFORMATION_MESSAGE);
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
		this.clienteAtual.setSituacao(principal.getTelaJuridica().getComboBoxSituacaoCliente().getSelectedItem().toString());
		this.clienteAtual.setRazaoSocial(principal.getTelaJuridica().getValidacaoGeralJTextFieldRazaoSocial().getText());
		this.clienteAtual.setCnpj(principal.getTelaJuridica().getValidacaoJTextFieldCnpj().getText());
		this.clienteAtual.setRepresentante(principal.getTelaJuridica().getValidacaoGeralJTextFieldRepresentante().getText());
		this.clienteAtual.setInscricaoEstadual(principal.getTelaJuridica().getValidacaoJTextFieldInscricaoEstadual().getText());
		this.clienteAtual.setInscricaoEstadualUF(principal.getTelaJuridica().getComboBoxUfInscricaoEstadual().getSelectedItem().toString());
		
		try {
			this.clienteAtual.setLimiteCredito(Double.parseDouble(principal.getTelaJuridica().getValidacaoJTextFieldLimiteCredito().getText()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			this.clienteAtual.setLimiteCredito(-1);
			//System.out.println(cliente.getLimiteCredito());
		}
						
		this.clienteAtual.setCep(principal.getTelaJuridica().getFormattedTextFieldCEP().getText());
		this.clienteAtual.setLogradouro(principal.getTelaJuridica().getValidacaoGeralJTextFieldLogradouro().getText());
		this.clienteAtual.setNumeroEndereco(principal.getTelaJuridica().getValidacaoGeralJTextFieldNumero().getText());
		this.clienteAtual.setBairro(principal.getTelaJuridica().getValidacaoGeralJTextFieldBairro().getText());
		this.clienteAtual.setComplemento(principal.getTelaJuridica().getValidacaoGeralJTextFieldComplemento().getText());
		this.clienteAtual.setCidade(principal.getTelaJuridica().getValidacaoGeralJTextFieldCidade().getText());
		this.clienteAtual.setUf_estado(principal.getTelaJuridica().getComboBoxEstadoEndereco().getSelectedItem().toString());
		this.clienteAtual.setTelefone(principal.getTelaJuridica().getFormattedTextFieldTelefone().getText());
		this.clienteAtual.setEmail(principal.getTelaJuridica().getValidacaoJTextFieldEmail().getText());
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
	
	public void chamarTelaCliente() {
		principal.removeTelaFisica();
		principal.add(principal.getPanel());
		principal.getComboBoxTipoCliente().setSelectedItem("Selecione");
		principal.remove(principal.getTelaPesquisa());
		principal.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente");		
		principal.getTelaPesquisa().getButtonExcluir().setEnabled(false);
		principal.getTelaPesquisa().getButtonAlterar().setEnabled(false);
		principal.getTelaPesquisa().getButtonCancelar().setEnabled(false);
		principal.getTelaPesquisa().getButtonConfirmar().setEnabled(false);
		principal.getTelaPesquisa().getButtonIncluir().setEnabled(true);
		principal.getTelaPesquisa().getButtonBuscar().setEnabled(true);
		principal.getTelaPesquisa().getTextFieldEntradaDado().setText("");
		principal.getTelaPesquisa().getJTableDados().setModel(new DefaultTableModel(
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
		principal.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente");
		principal.repaint();
		principal.validate();
	}
}
