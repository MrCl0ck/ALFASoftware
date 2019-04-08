package controle.cadastros.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import dao.Banco;
import modelo.cadastros.cliente.ModeloClientePessoaFisica;
import modelo.cadastros.dados.DadosClientePessoaFisica;
import modelo.cadastros.validacoes.ValidacaoClientePessoaFisica;
import visao.cadastros.cliente.VisaoFramePrincipal;
import visao.cadastros.cliente.VisaoTelaCadastroClientePessoaFisica;

public class ControladorTelaCadastroClientePessoaFisica{
	private ModeloClientePessoaFisica clienteAtual;
	private ModeloClientePessoaFisica clienteExibicao;
	private ModeloClientePessoaFisica clienteAntigo;
	private VisaoFramePrincipal framePrincipal;
	private VisaoTelaCadastroClientePessoaFisica telaClienteFisico;
	private VisaoTelaCadastroClientePessoaFisica tcf;
	private ControladorTelaCadastroCliente controladorTelaCadastroCliente;
	private Banco banco = new Banco();
	
	public ControladorTelaCadastroClientePessoaFisica(VisaoFramePrincipal frame) {
		framePrincipal = frame;
		inicializaTela();
		desabilitadosEHabilitadosInicialmente();
		addEventos();
		DadosClientePessoaFisica.setClientes();//carrega do banco de dados o arrylist atualizado
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
		tcf.getTelaPesquisa().getButtonAlterar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				if(tcf.getTelaPesquisa().getJTableDadosCliente().getSelectedRow() != -1) {					
					tcf.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Física - Alteração de cliente");
					int linhaSelecionada = tcf.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();
					
					clienteAntigo = new ModeloClientePessoaFisica();
					clienteAntigo = tcf.getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);
	
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
		tcf.getTelaPesquisa().getButtonExcluir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				if(tcf.getTelaPesquisa().getJTableDadosCliente().getSelectedRow() != -1) {					
					tcf.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Física - Exclusão de cliente");
					int linhaSelecionada = tcf.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
					ModeloClientePessoaFisica cliente = tcf.getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);
					
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Deseja excluir o cliente de nome: '" + cliente.getNome() +"' ?", "Exclusão",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  tcf.getBuscaExibicaoTableModel(true).removerCliente(linhaSelecionada);
				    	  String cpf = cliente.getCpf();
				    	  String id = banco.consultar("cliente", "cpf" , cpf, "ENDERECO_id");;
				    	  
				    	  if(new DadosClientePessoaFisica().bancoDeDadosExcluir(cpf, id) == true) {
				    		  limparCamposGeral();
				    		  desabilitadosEHabilitadosInicialmente();
				    	  }				    	  
				      }										
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente da lista exibida pela busca!"
							  , "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}

	private void getBotaoCancelarAction() {
		tcf.getTelaPesquisa().getButtonCancelar().addActionListener(new ActionListener() {
			
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
		tcf.getTelaPesquisa().getButtonConfirmar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "Fazer validação Regex para os campos especiais e validação geral pros campos!", "Validação", JOptionPane.INFORMATION_MESSAGE);
				if(tcf.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Física - Inclusão de cliente")) {
					capturarCampos();
					if(validacaoClienteCampos("Incluir") == true) {
						limparCamposGeral();
						desabilitadosEHabilitadosInicialmente();	
					}	
				}
				else if(tcf.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Física - Alteração de cliente")) {
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
		tcf.getTelaPesquisa().getButtonFechar().addActionListener(new ActionListener() {
			
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
		tcf.getTelaPesquisa().getButtonBuscar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(buscaNoArrayToTabela() == true) {
					botoesHabilitadosPosBusca(true);					
				}				
			}
		});				
	}
	
	private void getBotaoIncluirAction() {
		tcf.getTelaPesquisa().getButtonIncluir().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tcf.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Física - Inclusão de cliente");
				camposHabilitadosAoIncluirOuAlterar(true);
				botoesHabilitadosEDesabilitadosAoIncluirOuAlterar(true);
				
			}	
		});
		
	}

	public void botoesHabilitadosPosBusca(boolean b) {
		tcf.getTelaPesquisa().getButtonExcluir().setEnabled(b);
		tcf.getTelaPesquisa().getButtonAlterar().setEnabled(b);
		tcf.getTelaPesquisa().getButtonCancelar().setEnabled(b);
		tcf.getTelaPesquisa().getButtonIncluir().setEnabled(!b);
	}
	
	
	public void getSelecionarUmClienteTabelaTyped() {
		tcf.getTelaPesquisa().getJTableDadosCliente().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Cancelar",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  clienteExibicao = new ModeloClientePessoaFisica();
				    	  int linhaSelecionada = tcf.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
				    	  clienteExibicao = tcf.getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
				    	  atribuicaoDeBuscaAosCampos(clienteExibicao);
				      }
				}			
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					if(tcf.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Inclusão de cliente")) {
						Object[] options = { "NÃO", "SIM" };
					      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Cancelar",
					          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					              null, options, options[0]);
					      
					      if(opcao == 1) {
					    	  clienteExibicao = new ModeloClientePessoaFisica();
					    	  int linhaSelecionada = tcf.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
					    	  clienteExibicao = tcf.getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
					    	  atribuicaoDeBuscaAosCampos(clienteExibicao);
					      }
					}
					else {
						clienteExibicao = new ModeloClientePessoaFisica();
						int linhaSelecionada = tcf.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
						clienteExibicao = tcf.getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
						atribuicaoDeBuscaAosCampos(clienteExibicao);
					}
				}
				else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					if(tcf.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Inclusão de cliente")) {
						Object[] options = { "NÃO", "SIM" };
					      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Cancelar",
					          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					              null, options, options[0]);
					      
					      if(opcao == 1) {
					    	  clienteExibicao = new ModeloClientePessoaFisica();
					    	  int linhaSelecionada = tcf.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
					    	  clienteExibicao = tcf.getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
					    	  atribuicaoDeBuscaAosCampos(clienteExibicao);
					      }
					}
					else {
						clienteExibicao = new ModeloClientePessoaFisica();
						int linhaSelecionada = tcf.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
						clienteExibicao = tcf.getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
						atribuicaoDeBuscaAosCampos(clienteExibicao);
					}
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
									
			}
		});
	}
	public void getSelecionarUmClienteTabela() {
		tcf.getTelaPesquisa().getJTableDadosCliente().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getClickCount() == 1) {
					if(tcf.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Física - Inclusão de cliente")) {
						Object[] options = { "NÃO", "SIM" };
					      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Fechar",
					          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					              null, options, options[0]);
					      
					      if(opcao == 1) {
					    	  clienteExibicao = new ModeloClientePessoaFisica();
					    	  int linhaSelecionada = tcf.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
					    	  clienteExibicao = tcf.getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
					    	  atribuicaoDeBuscaAosCampos(clienteExibicao);
					      }
					}
					else {
						clienteExibicao = new ModeloClientePessoaFisica();
						int linhaSelecionada = tcf.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
						clienteExibicao = tcf.getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
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
	
	public void atribuicaoDeBuscaAosCampos(ModeloClientePessoaFisica cliente) {
		tcf.getComboBoxSituacaoCliente().setSelectedItem(cliente.getSituacao());
		tcf.getValidacaoJTextFieldNome().setText(cliente.getNome());
		tcf.getFormattedTextFieldDataNascimento().setText(cliente.getDataNascimento());
		tcf.getComboBoxSexo().setSelectedItem(cliente.getSexo());
		tcf.getFormattedTextFieldCPF().setText(cliente.getCpf());
		tcf.getValidacaoJTextFieldRG().setText(cliente.getRg());
		tcf.getComboBoxEstadoRG().setSelectedItem(cliente.getUfRg());
		tcf.getValidacaoJTextFieldOrgaoExpeditor().setText(cliente.getOrgaoExpeditorRg());
		tcf.getFormattedTextFieldCEP().setText(cliente.getCep());
		tcf.getValidacaoJTextFieldLogradouro().setText(cliente.getLogradouro());
		tcf.getValidacaoJTextFieldNumero().setText(cliente.getNumeroEndereco());
		tcf.getValidacaoJTextFieldBairro().setText(cliente.getBairro());
		tcf.getValidacaoJTextFieldComplemento().setText(cliente.getComplemento());
		tcf.getValidacaoJTextFieldCidade().setText(cliente.getCidade());
		tcf.getComboBoxEstadoEndereco().setSelectedItem(cliente.getUf_estado());
		tcf.getFormattedTextFieldTelefone().setText(cliente.getTelefone());
		tcf.getTextFieldEmail().setText(cliente.getEmail());
		tcf.getTextFieldLimiteCredito().setText(String.valueOf(cliente.getLimiteCredito()));
		tcf.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		tcf.getTelaPesquisa().getTextFieldEntradaDado().setText("");
	}

	private boolean buscaNoArrayToTabela() {
		String tipoBusca, valorBusca;
		
		tipoBusca = tcf.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString();
		valorBusca = tcf.getTelaPesquisa().getTextFieldEntradaDado().getText();
		
		if(!tipoBusca.equals("Selecione")) {		
			if(!valorBusca.trim().equals("")) {
				if(tipoBusca.equals("Nome")) {
					DadosClientePessoaFisica cliente = new DadosClientePessoaFisica();
					tcf.getTelaPesquisa().getJTableDadosCliente().setModel(tcf.getBuscaExibicaoTableModel(false));//seta uma nova tabela, só pra exibição dos resultados da busca
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
									tcf.getBuscaExibicaoTableModel(true).addCliente(clientePessoa);
								}
							}
						}				
					}
					if(tcf.getBuscaExibicaoTableModel(true).getRowCount() > 0) {
						//JOptionPane.showMessageDialog(null, "Busca finalizada, " + tcf.getBuscaExibicaoTableModel(true).getRowCount() + " clientes encontrados.", "Busca", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum cliente encontrado."
								  , "Busca", JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
				}
				else if(tipoBusca.equals("CPF")) {
					DadosClientePessoaFisica cliente = new DadosClientePessoaFisica();
					tcf.getTelaPesquisa().getJTableDadosCliente().setModel(tcf.getBuscaExibicaoTableModel(false));//seta uma nova tabela, só pra exibição dos resultados da busca
					
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
									tcf.getBuscaExibicaoTableModel(true).addCliente(clientePessoa);
								}
							}
						}				
					}	
					if(tcf.getBuscaExibicaoTableModel(true).getRowCount() > 0) {
						//JOptionPane.showMessageDialog(null, "Busca finalizada, " + tcf.getBuscaExibicaoTableModel(true).getRowCount() + " clientes encontrados.", "Busca", JOptionPane.INFORMATION_MESSAGE);
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

	public void inicializaTela() {		
		getTelaClienteFisico();
		adicionarTela();
		tcf = getTelaClienteFisico();//uma variavel nova que igualei a original da tela, pra nao ter que escrever isso tudo na hora de alterar :P
	}
	
	public VisaoTelaCadastroClientePessoaFisica getTelaClienteFisico() {
		if(telaClienteFisico == null) {
			telaClienteFisico = new VisaoTelaCadastroClientePessoaFisica();
		}
		return telaClienteFisico;
	}
	
	private void adicionarTela() {
		framePrincipal.getContentPane().removeAll();
		framePrincipal.setContentPane(getTelaClienteFisico());
		framePrincipal.repaint();
		framePrincipal.validate();
	}
	
	private void desabilitadosEHabilitadosInicialmente() {
		botoesDesablitadosEHabilitadosInicialmente();
		camposDesabilitadosInicialmente();
	}
	
	private void botoesDesablitadosEHabilitadosInicialmente() {
		tcf.getTelaPesquisa().getButtonExcluir().setEnabled(false);
		tcf.getTelaPesquisa().getButtonAlterar().setEnabled(false);
		tcf.getTelaPesquisa().getButtonCancelar().setEnabled(false);
		tcf.getTelaPesquisa().getButtonConfirmar().setEnabled(false);
		tcf.getTelaPesquisa().getButtonIncluir().setEnabled(true);
		tcf.getTelaPesquisa().getButtonBuscar().setEnabled(true);
	}
	
	public void botoesHabilitadosEDesabilitadosAoIncluirOuAlterar(boolean b) {
		tcf.getTelaPesquisa().getButtonConfirmar().setEnabled(b);
		tcf.getTelaPesquisa().getButtonCancelar().setEnabled(b);
		tcf.getTelaPesquisa().getButtonIncluir().setEnabled(!b);
		tcf.getTelaPesquisa().getButtonExcluir().setEnabled(!b);
		tcf.getTelaPesquisa().getButtonAlterar().setEnabled(!b);
	}		
	
	private void camposDesabilitadosInicialmente() {
		tcf.getComboBoxSituacaoCliente().setEnabled(false);
		tcf.getValidacaoJTextFieldNome().setEnabled(false);
		tcf.getFormattedTextFieldDataNascimento().setEnabled(false);
		tcf.getComboBoxSexo().setEnabled(false);
		tcf.getFormattedTextFieldCPF().setEnabled(false);
		tcf.getValidacaoJTextFieldRG().setEnabled(false);
		tcf.getComboBoxEstadoRG().setEnabled(false);
		tcf.getValidacaoJTextFieldOrgaoExpeditor().setEnabled(false);
		tcf.getFormattedTextFieldCEP().setEnabled(false);
		tcf.getValidacaoJTextFieldLogradouro().setEnabled(false);
		tcf.getValidacaoJTextFieldNumero().setEnabled(false);
		tcf.getValidacaoJTextFieldBairro().setEnabled(false);
		tcf.getValidacaoJTextFieldComplemento().setEnabled(false);
		tcf.getValidacaoJTextFieldCidade().setEnabled(false);
		tcf.getComboBoxEstadoEndereco().setEnabled(false);
		tcf.getFormattedTextFieldTelefone().setEnabled(false);
		tcf.getTextFieldEmail().setEnabled(false);
		tcf.getTextFieldLimiteCredito().setEnabled(false);
		tcf.getTelaPesquisa().getJTableDadosCliente().setModel(tcf.getBuscaExibicaoTableModel(false));
	}
	
	public void camposHabilitadosAoIncluirOuAlterar(boolean b) {
		tcf.getComboBoxSituacaoCliente().setEnabled(b);
		tcf.getValidacaoJTextFieldNome().setEnabled(b);
		tcf.getFormattedTextFieldDataNascimento().setEnabled(b);
		tcf.getComboBoxSexo().setEnabled(b);
		tcf.getFormattedTextFieldCPF().setEnabled(b);
		tcf.getValidacaoJTextFieldRG().setEnabled(b);
		tcf.getComboBoxEstadoRG().setEnabled(b);
		tcf.getValidacaoJTextFieldOrgaoExpeditor().setEnabled(b);
		tcf.getFormattedTextFieldCEP().setEnabled(b);
		tcf.getValidacaoJTextFieldLogradouro().setEnabled(b);
		tcf.getValidacaoJTextFieldNumero().setEnabled(b);
		tcf.getValidacaoJTextFieldBairro().setEnabled(b);
		tcf.getValidacaoJTextFieldComplemento().setEnabled(b);
		tcf.getValidacaoJTextFieldCidade().setEnabled(b);
		tcf.getComboBoxEstadoEndereco().setEnabled(b);
		tcf.getFormattedTextFieldTelefone().setEnabled(b);
		tcf.getTextFieldEmail().setEnabled(b);
		tcf.getTextFieldLimiteCredito().setEnabled(b);
	}
	
	private void limparCamposGeral() {
		tcf.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Física");
		tcf.getComboBoxSituacaoCliente().setSelectedIndex(0);
		tcf.getValidacaoJTextFieldNome().setText("");
		tcf.getFormattedTextFieldDataNascimento().setText("");
		tcf.getComboBoxSexo().setSelectedIndex(0);
		tcf.getFormattedTextFieldCPF().setText("");
		tcf.getValidacaoJTextFieldRG().setText("");
		tcf.getComboBoxEstadoRG().setSelectedIndex(0);
		tcf.getValidacaoJTextFieldOrgaoExpeditor().setText("");
		tcf.getFormattedTextFieldCEP().setText("");
		tcf.getValidacaoJTextFieldLogradouro().setText("");
		tcf.getValidacaoJTextFieldNumero().setText("");
		tcf.getValidacaoJTextFieldBairro().setText("");
		tcf.getValidacaoJTextFieldComplemento().setText("");
		tcf.getValidacaoJTextFieldCidade().setText("");
		tcf.getComboBoxEstadoEndereco().setSelectedIndex(0);
		tcf.getFormattedTextFieldTelefone().setText("");
		tcf.getTextFieldEmail().setText("");
		tcf.getTextFieldLimiteCredito().setText("");
		tcf.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		tcf.getTelaPesquisa().getTextFieldEntradaDado().setText("");
		tcf.getTelaPesquisa().getJTableDadosCliente().setModel(tcf.getBuscaExibicaoTableModel(false));
	}
	
	private void limparCampos() {
		tcf.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Física");
		tcf.getComboBoxSituacaoCliente().setSelectedIndex(0);
		tcf.getValidacaoJTextFieldNome().setText("");
		tcf.getFormattedTextFieldDataNascimento().setText("");
		tcf.getComboBoxSexo().setSelectedIndex(0);
		tcf.getFormattedTextFieldCPF().setText("");
		tcf.getValidacaoJTextFieldRG().setText("");
		tcf.getComboBoxEstadoRG().setSelectedIndex(0);
		tcf.getValidacaoJTextFieldOrgaoExpeditor().setText("");
		tcf.getFormattedTextFieldCEP().setText("");
		tcf.getValidacaoJTextFieldLogradouro().setText("");
		tcf.getValidacaoJTextFieldNumero().setText("");
		tcf.getValidacaoJTextFieldBairro().setText("");
		tcf.getValidacaoJTextFieldComplemento().setText("");
		tcf.getValidacaoJTextFieldCidade().setText("");
		tcf.getComboBoxEstadoEndereco().setSelectedIndex(0);
		tcf.getFormattedTextFieldTelefone().setText("");
		tcf.getTextFieldEmail().setText("");
		tcf.getTextFieldLimiteCredito().setText("");
		tcf.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		tcf.getTelaPesquisa().getTextFieldEntradaDado().setText("");
		tcf.getTelaPesquisa().getJTableDadosCliente().setModel(tcf.getBuscaExibicaoTableModel(false));
	}
	
	private void capturarCampos() {
		clienteAtual = new ModeloClientePessoaFisica();
		
		this.clienteAtual.setSituacao(tcf.getComboBoxSituacaoCliente().getSelectedItem().toString());
		this.clienteAtual.setNome(tcf.getValidacaoJTextFieldNome().getText());
		this.clienteAtual.setDataNascimento(tcf.getFormattedTextFieldDataNascimento().getText());
		this.clienteAtual.setSexo(tcf.getComboBoxSexo().getSelectedItem().toString());
		this.clienteAtual.setCpf(tcf.getFormattedTextFieldCPF().getText());
		this.clienteAtual.setRg(tcf.getValidacaoJTextFieldRG().getText());
		this.clienteAtual.setUfRg(tcf.getComboBoxEstadoRG().getSelectedItem().toString());
		this.clienteAtual.setOrgaoExpeditorRg(tcf.getValidacaoJTextFieldOrgaoExpeditor().getText());
		
		try {
			this.clienteAtual.setLimiteCredito(Double.parseDouble(tcf.getTextFieldLimiteCredito().getText()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			this.clienteAtual.setLimiteCredito(-1);
			//System.out.println(cliente.getLimiteCredito());
		}
						
		this.clienteAtual.setCep(tcf.getFormattedTextFieldCEP().getText());
		this.clienteAtual.setLogradouro(tcf.getValidacaoJTextFieldLogradouro().getText());
		this.clienteAtual.setNumeroEndereco(tcf.getValidacaoJTextFieldNumero().getText());
		this.clienteAtual.setBairro(tcf.getValidacaoJTextFieldBairro().getText());
		this.clienteAtual.setComplemento(tcf.getValidacaoJTextFieldComplemento().getText());
		this.clienteAtual.setCidade(tcf.getValidacaoJTextFieldCidade().getText());
		this.clienteAtual.setUf_estado(tcf.getComboBoxEstadoEndereco().getSelectedItem().toString());
		this.clienteAtual.setTelefone(tcf.getFormattedTextFieldTelefone().getText());
		this.clienteAtual.setEmail(tcf.getTextFieldEmail().getText());
	}
	
	private boolean validacaoClienteCampos(String b) {
		ValidacaoClientePessoaFisica clienteF;
		
		if(b.equals("Alterar")) {
			DadosClientePessoaFisica clienteSalvo = new DadosClientePessoaFisica();
			String id_end;
				
			clienteF = new ValidacaoClientePessoaFisica(clienteAtual);
			id_end = banco.consultar("cliente", "cpf" , clienteAntigo.getCpf(), "ENDERECO_id");
			
			if(clienteF.isResultadoValidacaoTodosCamposGeral() == true) {					
				
				clienteSalvo.bancoDeDadosAlterar(clienteAtual, clienteAntigo.getCpf(), id_end);
				
				return true;
			}			
		}
		
		else if(b.equals("Incluir")) {
			DadosClientePessoaFisica clienteSalvo = new DadosClientePessoaFisica();
			
			clienteF = new ValidacaoClientePessoaFisica(clienteAtual);
			clienteF.validarCPF();
			
			if(clienteF.isResultadoValidacaoTodosCamposGeral() == true && clienteF.isResultadoValidacaoCpfRg() == true) {
				
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
