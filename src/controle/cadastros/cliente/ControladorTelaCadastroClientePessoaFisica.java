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
import modelo.cadastros.cliente.ModeloClientePessoaFisica;
import modelo.cadastros.dados.DadosClientePessoaFisica;
import modelo.cadastros.validacoes.ValidacaoClientePessoaFisica;
import visao.cadastros.cliente.VisaoFramePrincipal;
import visao.cadastros.cliente.VisaoTelaCadastroCliente;
import visao.cadastros.cliente.VisaoTelaCadastroClientePessoaFisica;

public class ControladorTelaCadastroClientePessoaFisica{
	private ModeloClientePessoaFisica clienteAtual;
	private ModeloClientePessoaFisica clienteExibicao;
	private ModeloClientePessoaFisica clienteAntigo;
	private VisaoTelaCadastroCliente principal;
	private Banco banco = new Banco();
	
	public ControladorTelaCadastroClientePessoaFisica(VisaoTelaCadastroCliente frame) {
		principal = frame;
		desabilitadosEHabilitadosInicialmente();
		limparCamposGeral();
		addEventos();
		//DadosClientePessoaFisica.setClientes();//carrega do banco de dados o arrylist atualizado
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
		if(principal.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Física"))
		{
			principal.getTelaPesquisa().getButtonAlterar().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {				
					if(principal.getTelaPesquisa().getJTableDadosCliente().getSelectedRow() != -1) {					
						principal.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Física - Alteração de cliente");
						int linhaSelecionada = principal.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();
						
						clienteAntigo = new ModeloClientePessoaFisica();
						clienteAntigo = principal.getTelaFisica().getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);
						
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
	}

	private void getBotaoExcluirAction() {
		principal.getTelaPesquisa().getButtonExcluir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				if(principal.getTelaPesquisa().getJTableDadosCliente().getSelectedRow() != -1) {					
					principal.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Física - Exclusão de cliente");
					int linhaSelecionada = principal.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
					ModeloClientePessoaFisica cliente = principal.getTelaFisica().getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);
					
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Deseja excluir o cliente de nome: '" + cliente.getNome() +"' ?", "Exclusão",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  principal.getTelaFisica().getBuscaExibicaoTableModel(true).removerCliente(linhaSelecionada);
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
				if(principal.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Física - Inclusão de cliente")) {
					capturarCampos();
					if(validacaoClienteCampos("Incluir") == true) {
						limparCamposGeral();
						desabilitadosEHabilitadosInicialmente();	
					}	
				}
				else if(principal.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Física - Alteração de cliente")) {
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
				if (principal.getLabelPaginaCadastroCliente().getText() != " Cadastro de Cliente") {
					//Object[] options = { "NÃO", "SIM" };
					//int opcao = JOptionPane.showOptionDialog(null, "Deseja retornar a tela de cadastro de clientes?", "Fechar",
					//		JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					//		null, options, options[0]);
					
					//if(opcao == 1) {
						//System.out.println("chegou até aqui");
				//		//chamarTelaCliente();
					//}	
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
				principal.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Física - Inclusão de cliente");
				camposHabilitadosAoIncluirOuAlterar(true);
				botoesHabilitadosEDesabilitadosAoIncluirOuAlterar(true);				
			}	
		});
		
	}

	public void botoesHabilitadosPosBusca(boolean b) {
		principal.getTelaPesquisa().getButtonExcluir().setEnabled(b);
		principal.getTelaPesquisa().getButtonAlterar().setEnabled(b);
		principal.getTelaPesquisa().getButtonCancelar().setEnabled(b);
		principal.getTelaPesquisa().getButtonIncluir().setEnabled(!b);
	}
	
	
	public void getSelecionarUmClienteTabelaTyped() {
		principal.getTelaPesquisa().getJTableDadosCliente().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Cancelar",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  clienteExibicao = new ModeloClientePessoaFisica();
				    	  int linhaSelecionada = principal.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
				    	  clienteExibicao = principal.getTelaFisica().getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
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
					    	  clienteExibicao = new ModeloClientePessoaFisica();
					    	  int linhaSelecionada = principal.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
					    	  clienteExibicao = principal.getTelaFisica().getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
					    	  atribuicaoDeBuscaAosCampos(clienteExibicao);
					      }
					}
					else {
						clienteExibicao = new ModeloClientePessoaFisica();
						int linhaSelecionada = principal.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
						clienteExibicao = principal.getTelaFisica().getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
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
					    	  clienteExibicao = new ModeloClientePessoaFisica();
					    	  int linhaSelecionada = principal.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
					    	  clienteExibicao = principal.getTelaFisica().getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
					    	  atribuicaoDeBuscaAosCampos(clienteExibicao);
					      }
					}
					else {
						clienteExibicao = new ModeloClientePessoaFisica();
						int linhaSelecionada = principal.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
						clienteExibicao = principal.getTelaFisica().getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
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
		principal.getTelaPesquisa().getJTableDadosCliente().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getClickCount() == 1) {
					if(principal.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Física - Inclusão de cliente")) {
						Object[] options = { "NÃO", "SIM" };
					      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Fechar",
					          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					              null, options, options[0]);
					      
					      if(opcao == 1) {
					    	  clienteExibicao = new ModeloClientePessoaFisica();
					    	  int linhaSelecionada = principal.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
					    	  clienteExibicao = principal.getTelaFisica().getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
					    	  atribuicaoDeBuscaAosCampos(clienteExibicao);
					      }
					}
					else {
						clienteExibicao = new ModeloClientePessoaFisica();
						int linhaSelecionada = principal.getTelaPesquisa().getJTableDadosCliente().getSelectedRow();					
						clienteExibicao = principal.getTelaFisica().getBuscaExibicaoTableModel(true).getCliente(linhaSelecionada);					
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
		principal.getTelaFisica().getComboBoxSituacaoCliente().setSelectedItem(cliente.getSituacao());
		principal.getTelaFisica().getValidacaoJTextFieldNome().setText(cliente.getNome());
		principal.getTelaFisica().getFormattedTextFieldDataNascimento().setText(cliente.getDataNascimento());
		principal.getTelaFisica().getComboBoxSexo().setSelectedItem(cliente.getSexo());
		principal.getTelaFisica().getFormattedTextFieldCPF().setText(cliente.getCpf());
		principal.getTelaFisica().getValidacaoJTextFieldRG().setText(cliente.getRg());
		principal.getTelaFisica().getComboBoxEstadoRG().setSelectedItem(cliente.getUfRg());
		principal.getTelaFisica().getValidacaoJTextFieldOrgaoExpeditor().setText(cliente.getOrgaoExpeditorRg());
		principal.getTelaFisica().getFormattedTextFieldCEP().setText(cliente.getCep());
		principal.getTelaFisica().getValidacaoJTextFieldLogradouro().setText(cliente.getLogradouro());
		principal.getTelaFisica().getValidacaoJTextFieldNumero().setText(cliente.getNumeroEndereco());
		principal.getTelaFisica().getValidacaoJTextFieldBairro().setText(cliente.getBairro());
		principal.getTelaFisica().getValidacaoJTextFieldComplemento().setText(cliente.getComplemento());
		principal.getTelaFisica().getValidacaoJTextFieldCidade().setText(cliente.getCidade());
		principal.getTelaFisica().getComboBoxEstadoEndereco().setSelectedItem(cliente.getUf_estado());
		principal.getTelaFisica().getFormattedTextFieldTelefone().setText(cliente.getTelefone());
		principal.getTelaFisica().getTextFieldEmail().setText(cliente.getEmail());
		principal.getTelaFisica().getTextFieldLimiteCredito().setText(String.valueOf(cliente.getLimiteCredito()));
		principal.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		principal.getTelaPesquisa().getTextFieldEntradaDado().setText("");
	}

	private boolean buscaNoArrayToTabela() {
		String tipoBusca, valorBusca;
		
		tipoBusca = principal.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString();
		valorBusca = principal.getTelaPesquisa().getTextFieldEntradaDado().getText();
		
		if(!tipoBusca.equals("Selecione")) {		
			if(!valorBusca.trim().equals("")) {
				if(tipoBusca.equals("Nome")) {
					DadosClientePessoaFisica cliente = new DadosClientePessoaFisica();
					principal.getTelaPesquisa().getJTableDadosCliente().setModel(principal.getTelaFisica().getBuscaExibicaoTableModel(false));//seta uma nova tabela, só pra exibição dos resultados da busca
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
									principal.getTelaFisica().getBuscaExibicaoTableModel(true).addCliente(clientePessoa);
								}
							}
						}				
					}
					if(principal.getTelaFisica().getBuscaExibicaoTableModel(true).getRowCount() > 0) {
						//JOptionPane.showMessageDialog(null, "Busca finalizada, " + principal.getBuscaExibicaoTableModel(true).getRowCount() + " clientes encontrados.", "Busca", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum cliente encontrado."
								  , "Busca", JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
				}
				else if(tipoBusca.equals("CPF")) {
					DadosClientePessoaFisica cliente = new DadosClientePessoaFisica();
					principal.getTelaPesquisa().getJTableDadosCliente().setModel(principal.getTelaFisica().getBuscaExibicaoTableModel(false));//seta uma nova tabela, só pra exibição dos resultados da busca
					
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
									principal.getTelaFisica().getBuscaExibicaoTableModel(true).addCliente(clientePessoa);
								}
							}
						}				
					}	
					if(principal.getTelaFisica().getBuscaExibicaoTableModel(true).getRowCount() > 0) {
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
		principal.getTelaFisica().getComboBoxSituacaoCliente().setEnabled(false);
		principal.getTelaFisica().getValidacaoJTextFieldNome().setEnabled(false);
		principal.getTelaFisica().getFormattedTextFieldDataNascimento().setEnabled(false);
		principal.getTelaFisica().getComboBoxSexo().setEnabled(false);
		principal.getTelaFisica().getFormattedTextFieldCPF().setEnabled(false);
		principal.getTelaFisica().getValidacaoJTextFieldRG().setEnabled(false);
		principal.getTelaFisica().getComboBoxEstadoRG().setEnabled(false);
		principal.getTelaFisica().getValidacaoJTextFieldOrgaoExpeditor().setEnabled(false);
		principal.getTelaFisica().getFormattedTextFieldCEP().setEnabled(false);
		principal.getTelaFisica().getValidacaoJTextFieldLogradouro().setEnabled(false);
		principal.getTelaFisica().getValidacaoJTextFieldNumero().setEnabled(false);
		principal.getTelaFisica().getValidacaoJTextFieldBairro().setEnabled(false);
		principal.getTelaFisica().getValidacaoJTextFieldComplemento().setEnabled(false);
		principal.getTelaFisica().getValidacaoJTextFieldCidade().setEnabled(false);
		principal.getTelaFisica().getComboBoxEstadoEndereco().setEnabled(false);
		principal.getTelaFisica().getFormattedTextFieldTelefone().setEnabled(false);
		principal.getTelaFisica().getTextFieldEmail().setEnabled(false);
		principal.getTelaFisica().getTextFieldLimiteCredito().setEnabled(false);
		principal.getTelaPesquisa().getJTableDadosCliente().setModel(principal.getTelaFisica().getBuscaExibicaoTableModel(false));
	}
	
	public void camposHabilitadosAoIncluirOuAlterar(boolean b) {
		principal.getTelaFisica().getComboBoxSituacaoCliente().setEnabled(b);
		principal.getTelaFisica().getValidacaoJTextFieldNome().setEnabled(b);
		principal.getTelaFisica().getFormattedTextFieldDataNascimento().setEnabled(b);
		principal.getTelaFisica().getComboBoxSexo().setEnabled(b);
		principal.getTelaFisica().getFormattedTextFieldCPF().setEnabled(b);
		principal.getTelaFisica().getValidacaoJTextFieldRG().setEnabled(b);
		principal.getTelaFisica().getComboBoxEstadoRG().setEnabled(b);
		principal.getTelaFisica().getValidacaoJTextFieldOrgaoExpeditor().setEnabled(b);
		principal.getTelaFisica().getFormattedTextFieldCEP().setEnabled(b);
		principal.getTelaFisica().getValidacaoJTextFieldLogradouro().setEnabled(b);
		principal.getTelaFisica().getValidacaoJTextFieldNumero().setEnabled(b);
		principal.getTelaFisica().getValidacaoJTextFieldBairro().setEnabled(b);
		principal.getTelaFisica().getValidacaoJTextFieldComplemento().setEnabled(b);
		principal.getTelaFisica().getValidacaoJTextFieldCidade().setEnabled(b);
		principal.getTelaFisica().getComboBoxEstadoEndereco().setEnabled(b);
		principal.getTelaFisica().getFormattedTextFieldTelefone().setEnabled(b);
		principal.getTelaFisica().getTextFieldEmail().setEnabled(b);
		principal.getTelaFisica().getTextFieldLimiteCredito().setEnabled(b);
	}
	
	private void limparCamposGeral() {
		principal.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Física");
		principal.getTelaFisica().getComboBoxSituacaoCliente().setSelectedIndex(0);
		principal.getTelaFisica().getValidacaoJTextFieldNome().setText("");
		principal.getTelaFisica().getFormattedTextFieldDataNascimento().setText("");
		principal.getTelaFisica().getComboBoxSexo().setSelectedIndex(0);
		principal.getTelaFisica().getFormattedTextFieldCPF().setText("");
		principal.getTelaFisica().getValidacaoJTextFieldRG().setText("");
		principal.getTelaFisica().getComboBoxEstadoRG().setSelectedIndex(0);
		principal.getTelaFisica().getValidacaoJTextFieldOrgaoExpeditor().setText("");
		principal.getTelaFisica().getFormattedTextFieldCEP().setText("");
		principal.getTelaFisica().getValidacaoJTextFieldLogradouro().setText("");
		principal.getTelaFisica().getValidacaoJTextFieldNumero().setText("");
		principal.getTelaFisica().getValidacaoJTextFieldBairro().setText("");
		principal.getTelaFisica().getValidacaoJTextFieldComplemento().setText("");
		principal.getTelaFisica().getValidacaoJTextFieldCidade().setText("");
		principal.getTelaFisica().getComboBoxEstadoEndereco().setSelectedIndex(0);
		principal.getTelaFisica().getFormattedTextFieldTelefone().setText("");
		principal.getTelaFisica().getTextFieldEmail().setText("");
		principal.getTelaFisica().getTextFieldLimiteCredito().setText("");
		principal.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		principal.getTelaPesquisa().getTextFieldEntradaDado().setText("");
		principal.getTelaPesquisa().getJTableDadosCliente().setModel(principal.getTelaFisica().getBuscaExibicaoTableModel(false));
	}
	
	private void limparCampos() {
		principal.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Física");
		principal.getTelaFisica().getComboBoxSituacaoCliente().setSelectedIndex(0);
		principal.getTelaFisica().getValidacaoJTextFieldNome().setText("");
		principal.getTelaFisica().getFormattedTextFieldDataNascimento().setText("");
		principal.getTelaFisica().getComboBoxSexo().setSelectedIndex(0);
		principal.getTelaFisica().getFormattedTextFieldCPF().setText("");
		principal.getTelaFisica().getValidacaoJTextFieldRG().setText("");
		principal.getTelaFisica().getComboBoxEstadoRG().setSelectedIndex(0);
		principal.getTelaFisica().getValidacaoJTextFieldOrgaoExpeditor().setText("");
		principal.getTelaFisica().getFormattedTextFieldCEP().setText("");
		principal.getTelaFisica().getValidacaoJTextFieldLogradouro().setText("");
		principal.getTelaFisica().getValidacaoJTextFieldNumero().setText("");
		principal.getTelaFisica().getValidacaoJTextFieldBairro().setText("");
		principal.getTelaFisica().getValidacaoJTextFieldComplemento().setText("");
		principal.getTelaFisica().getValidacaoJTextFieldCidade().setText("");
		principal.getTelaFisica().getComboBoxEstadoEndereco().setSelectedIndex(0);
		principal.getTelaFisica().getFormattedTextFieldTelefone().setText("");
		principal.getTelaFisica().getTextFieldEmail().setText("");
		principal.getTelaFisica().getTextFieldLimiteCredito().setText("");
		principal.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		principal.getTelaPesquisa().getTextFieldEntradaDado().setText("");
		principal.getTelaPesquisa().getJTableDadosCliente().setModel(principal.getTelaFisica().getBuscaExibicaoTableModel(false));
	}
	
	private void capturarCampos() {
		clienteAtual = new ModeloClientePessoaFisica();
		
		this.clienteAtual.setSituacao(principal.getTelaFisica().getComboBoxSituacaoCliente().getSelectedItem().toString());
		this.clienteAtual.setNome(principal.getTelaFisica().getValidacaoJTextFieldNome().getText());
		this.clienteAtual.setDataNascimento(principal.getTelaFisica().getFormattedTextFieldDataNascimento().getText());
		this.clienteAtual.setSexo(principal.getTelaFisica().getComboBoxSexo().getSelectedItem().toString());
		this.clienteAtual.setCpf(principal.getTelaFisica().getFormattedTextFieldCPF().getText());
		this.clienteAtual.setRg(principal.getTelaFisica().getValidacaoJTextFieldRG().getText());
		this.clienteAtual.setUfRg(principal.getTelaFisica().getComboBoxEstadoRG().getSelectedItem().toString());
		this.clienteAtual.setOrgaoExpeditorRg(principal.getTelaFisica().getValidacaoJTextFieldOrgaoExpeditor().getText());
		
		try {
			this.clienteAtual.setLimiteCredito(Double.parseDouble(principal.getTelaFisica().getTextFieldLimiteCredito().getText()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			this.clienteAtual.setLimiteCredito(-1);
			//System.out.println(cliente.getLimiteCredito());
		}
						
		this.clienteAtual.setCep(principal.getTelaFisica().getFormattedTextFieldCEP().getText());
		this.clienteAtual.setLogradouro(principal.getTelaFisica().getValidacaoJTextFieldLogradouro().getText());
		this.clienteAtual.setNumeroEndereco(principal.getTelaFisica().getValidacaoJTextFieldNumero().getText());
		this.clienteAtual.setBairro(principal.getTelaFisica().getValidacaoJTextFieldBairro().getText());
		this.clienteAtual.setComplemento(principal.getTelaFisica().getValidacaoJTextFieldComplemento().getText());
		this.clienteAtual.setCidade(principal.getTelaFisica().getValidacaoJTextFieldCidade().getText());
		this.clienteAtual.setUf_estado(principal.getTelaFisica().getComboBoxEstadoEndereco().getSelectedItem().toString());
		this.clienteAtual.setTelefone(principal.getTelaFisica().getFormattedTextFieldTelefone().getText());
		this.clienteAtual.setEmail(principal.getTelaFisica().getTextFieldEmail().getText());
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
	
	public void chamarTelaCliente() {
		principal.removeTelaFisica();
		principal.add(principal.getPanel());
		principal.getComboBoxTipoCliente().setSelectedItem("Selecione");
		principal.getTelaPesquisa().getButtonExcluir().setEnabled(false);
		principal.getTelaPesquisa().getButtonAlterar().setEnabled(false);
		principal.getTelaPesquisa().getButtonCancelar().setEnabled(false);
		principal.getTelaPesquisa().getButtonConfirmar().setEnabled(false);
		principal.getTelaPesquisa().getButtonIncluir().setEnabled(true);
		principal.getTelaPesquisa().getButtonBuscar().setEnabled(true);
		principal.getTelaPesquisa().getTextFieldEntradaDado().setText("");
		principal.getTelaPesquisa().getJTableDadosCliente().setModel(new DefaultTableModel(
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
		principal.repaint();
		principal.revalidate();
	}
}
