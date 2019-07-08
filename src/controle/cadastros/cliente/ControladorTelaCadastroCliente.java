package controle.cadastros.cliente;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import modelo.cadastros.validacoes.ValidacaoClientePessoaFisica;
import modelo.cadastros.validacoes.ValidacaoClientePessoaJuridica;
import visao.cadastros.cliente.VisaoFramePrincipal;
import visao.cadastros.cliente.VisaoTelaCadastroCliente;

public class ControladorTelaCadastroCliente{
	private VisaoFramePrincipal framePrincipal;	
	private VisaoTelaCadastroCliente telaCliente;
	private ModeloClientePessoaJuridica cliente_exibicao_J;
	private ModeloClientePessoaJuridica cliente_atual_J;
	private ModeloClientePessoaJuridica cliente_antigo_J;	
	private ModeloClientePessoaFisica cliente_exibicao_F;
	private ModeloClientePessoaFisica cliente_atual_F;
	private ModeloClientePessoaFisica cliente_antigo_F;	
	private Banco banco = new Banco();

	public ControladorTelaCadastroCliente(VisaoFramePrincipal frame) {
		framePrincipal = frame;
		inicializaTela();
		inicial_limpeza_geral();
		addEvento();
	}

	public void addEvento() {
			getTipoClienteAction();
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
	
	public void getSelecionarUmClienteTabelaTyped() {
		telaCliente.getTelaPesquisa().getJTableDados().addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Pessoa Jurídica")) {
						if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
						      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Cancelar",
						          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						              null, options, options[0]);
						      
						      if(opcao == 1) {
						    	  cliente_exibicao_J = new ModeloClientePessoaJuridica();
						    	  int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
						    	  cliente_exibicao_J = telaCliente.getBuscaExibicaoTableModelJuridico(true).getCliente(linhaSelecionada);					
						    	  atribuicao_busca_campos_J(cliente_exibicao_J);
						      }
						}
						else {
							cliente_exibicao_J = new ModeloClientePessoaJuridica();
							int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
							cliente_exibicao_J = telaCliente.getBuscaExibicaoTableModelJuridico(true).getCliente(linhaSelecionada);					
							atribuicao_busca_campos_J(cliente_exibicao_J);
						}						
					}
					else if (telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Pessoa Física")) {
						if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Física - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
						      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Cancelar",
						          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						              null, options, options[0]);
						      
						      if(opcao == 1) {
						    	  cliente_exibicao_F = new ModeloClientePessoaFisica();
						    	  int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
						    	  cliente_exibicao_F = telaCliente.getBuscaExibicaoTableModelFisico(true).getCliente(linhaSelecionada);					
						    	  atribuicao_busca_campos_F(cliente_exibicao_F);
						      }
						}
						else {
							cliente_exibicao_F = new ModeloClientePessoaFisica();
							int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
							cliente_exibicao_F = telaCliente.getBuscaExibicaoTableModelFisico(true).getCliente(linhaSelecionada);					
							atribuicao_busca_campos_F(cliente_exibicao_F);
						}
					}
				}			
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					if (telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Pessoa Jurídica")) {
						if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
						      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Cancelar",
						          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						              null, options, options[0]);
						      
						      if(opcao == 1) {
						    	  cliente_exibicao_J = new ModeloClientePessoaJuridica();
						    	  int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
						    	  cliente_exibicao_J = telaCliente.getBuscaExibicaoTableModelJuridico(true).getCliente(linhaSelecionada);					
						    	  atribuicao_busca_campos_J(cliente_exibicao_J);
						      }
						}
						else {
							cliente_exibicao_J = new ModeloClientePessoaJuridica();
							int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
							cliente_exibicao_J = telaCliente.getBuscaExibicaoTableModelJuridico(true).getCliente(linhaSelecionada);					
							atribuicao_busca_campos_J(cliente_exibicao_J);
						}
					}
					else if (telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Pessoa Física")) {
						if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Física - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
						      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Cancelar",
						          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						              null, options, options[0]);
						      
						      if(opcao == 1) {
						    	  cliente_exibicao_F = new ModeloClientePessoaFisica();
						    	  int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
						    	  cliente_exibicao_F = telaCliente.getBuscaExibicaoTableModelFisico(true).getCliente(linhaSelecionada);					
						    	  atribuicao_busca_campos_F(cliente_exibicao_F);
						      }
						}
						else {
							cliente_exibicao_F = new ModeloClientePessoaFisica();
							int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
							cliente_exibicao_F = telaCliente.getBuscaExibicaoTableModelFisico(true).getCliente(linhaSelecionada);					
							atribuicao_busca_campos_F(cliente_exibicao_F);
						}
					}
					
				}
				else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Pessoa Jurídica")) {
						if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Cancelar",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
									null, options, options[0]);
							
							if(opcao == 1) {
								cliente_exibicao_J = new ModeloClientePessoaJuridica();
								int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
								cliente_exibicao_J = telaCliente.getBuscaExibicaoTableModelJuridico(true).getCliente(linhaSelecionada);					
								atribuicao_busca_campos_J(cliente_exibicao_J);
							}
						}
						else {
							cliente_exibicao_J = new ModeloClientePessoaJuridica();
							int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
							cliente_exibicao_J = telaCliente.getBuscaExibicaoTableModelJuridico(true).getCliente(linhaSelecionada);					
							atribuicao_busca_campos_J(cliente_exibicao_J);
						}						
					}
					else if (telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Pessoa Física")) {
						if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Física - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
						      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Cancelar",
						          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						              null, options, options[0]);
						      
						      if(opcao == 1) {
						    	  cliente_exibicao_F = new ModeloClientePessoaFisica();
						    	  int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
						    	  cliente_exibicao_F = telaCliente.getBuscaExibicaoTableModelFisico(true).getCliente(linhaSelecionada);					
						    	  atribuicao_busca_campos_F(cliente_exibicao_F);
						      }
						}
						else {
							cliente_exibicao_F = new ModeloClientePessoaFisica();
							int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
							cliente_exibicao_F = telaCliente.getBuscaExibicaoTableModelFisico(true).getCliente(linhaSelecionada);					
							atribuicao_busca_campos_F(cliente_exibicao_F);
						}
					}
				}
			}
			

			@Override
			public void keyPressed(KeyEvent e) {
									
			}
		});				
	}
	
	private void getBotaoConfirmarAction() {
		telaCliente.getTelaPesquisa().getButtonConfirmar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "Fazer validação Regex para os campos especiais e validação geral pros campos!", "Validação", JOptionPane.INFORMATION_MESSAGE);
				if(telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Pessoa Jurídica")) {
					if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Incluir")) {
						Object[] options = { "NÃO", "SIM" };
					      int opcao = JOptionPane.showOptionDialog(null, "Confirma a inclusão dos dados do cliente tratado?", "Confirmar",
					          JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
					              null, options, options[0]);
					      
					      if(opcao == 1) {
					    	  capturar_campos_juridico();
					    	  if(validacao_cliente_campos_J("Incluir") == true) {
					    		  limpar_campos_juridico();
					    		  campos_inicial_juridico();	
					    		  inicial_buttons_fj();
					    	  }						    	  
					      }
					}
					else if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Alterar")) {
						Object[] options = { "NÃO", "SIM" };
						int opcao = JOptionPane.showOptionDialog(null, "Confirma a alteração dos dados do cliente tratado?", "Confirmar",
								JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
								null, options, options[0]);
						
						if(opcao == 1) {
							capturar_campos_juridico();
							if(validacao_cliente_campos_J("Alterar") == true) {
								limpar_campos_juridico();
								campos_inicial_juridico();
								inicial_buttons_fj();
								telaCliente.getTelaPesquisa().getJTableDados().setModel(telaCliente.getBuscaExibicaoTableModelJuridico(false));
							}
						}	
					}
					
				}
				else if (telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Pessoa Física")){
					if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Física - Incluir")) {
						Object[] options = { "NÃO", "SIM" };
					      int opcao = JOptionPane.showOptionDialog(null, "Confirma a inclusão do dados do cliente tratado?", "Confirmar",
					          JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
					              null, options, options[0]);
					      
					      if(opcao == 1) {
					    	  capturar_campos_fisico();
					    	  if(validacao_cliente_campos_F("Incluir") == true) {
					    		  limpar_campos_fisico();
					    		  campos_inicial_fisico();
					    		  inicial_buttons_fj();
					    	  }						    	  
					      }						
					}
					else if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Física - Alterar")) {
						Object[] options = { "NÃO", "SIM" };
					      int opcao = JOptionPane.showOptionDialog(null, "Confirma a alteração dos dados do cliente tratado?", "Confirmar",
					          JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
					              null, options, options[0]);
					      
					      if(opcao == 1) {
					    	  capturar_campos_fisico();
								if(validacao_cliente_campos_F("Alterar") == true) {
									limpar_campos_fisico();
									campos_inicial_fisico();
									inicial_buttons_fj();
									telaCliente.getTelaPesquisa().getJTableDados().setModel(telaCliente.getBuscaExibicaoTableModelFisico(false));
								}
					      }	
					}
				}
					
			}
		});
	}

	private void getBotaoAlterarAction() {
		telaCliente.getTelaPesquisa().getButtonAlterar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Busca")) {
					int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();
					if (telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow() != -1) {
						if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Busca - Pessoa Física")) {
							tela_fisico();
							atribuicao_busca_campos_F(telaCliente.getBuscaExibicaoTableModelFisico(true).getCliente(linhaSelecionada));						
							telaCliente.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Física - Alterar");											
							incluir_alterar_campos_f(true);
							incluir_alterar_buttons(true);
						}
						else if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Busca - Pessoa Jurídica")) {
							tela_juridico();
							atribuicao_busca_campos_J(telaCliente.getBuscaExibicaoTableModelJuridico(true).getCliente(linhaSelecionada));						
							telaCliente.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Jurídica - Alterar");											
							incluir_alterar_campos_j(true);
							incluir_alterar_buttons(true);					
						}						
					}
					else {
						JOptionPane.showMessageDialog(null, "Selecione um cliente da lista exibida pela busca!"
								, "Aviso", JOptionPane.INFORMATION_MESSAGE);
					}
				}	
				else if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica")) {
					if(telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow() != -1) {					
						telaCliente.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Jurídica - Alterar");
						int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
						ModeloClientePessoaJuridica cliente = telaCliente.getBuscaExibicaoTableModelJuridico(true).getCliente(linhaSelecionada);
						
						cliente_antigo_J = new ModeloClientePessoaJuridica();
						cliente_antigo_J = cliente;
						atribuicao_busca_campos_J(cliente_antigo_J);					
						
						incluir_alterar_campos_j(true);
						incluir_alterar_buttons(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Selecione um cliente da lista exibida pela busca"
								  , "Aviso", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else if (telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Física")) {
					if(telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow() != -1) {					
						telaCliente.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Física - Alterar");
						int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();
						
						cliente_antigo_F = new ModeloClientePessoaFisica();
						cliente_antigo_F = telaCliente.getBuscaExibicaoTableModelFisico(true).getCliente(linhaSelecionada);
						
						atribuicao_busca_campos_F(cliente_antigo_F);					
						incluir_alterar_campos_f(true);
						incluir_alterar_buttons(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Selecione um cliente da lista exibida pela busca"
								, "Aviso", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}

		});
		
	}

	private void atribuicao_busca_campos_J(ModeloClientePessoaJuridica cliente_antigo_J) {
		telaCliente.getTelaJuridica().getComboBoxSituacaoCliente().setSelectedItem(cliente_antigo_J.getSituacao());
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldRazaoSocial().setText(cliente_antigo_J.getRazaoSocial());
		telaCliente.getTelaJuridica().getValidacaoJTextFieldCnpj().setText(cliente_antigo_J.getCnpj());
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldRepresentante().setText(cliente_antigo_J.getRepresentante());
		telaCliente.getTelaJuridica().getValidacaoJTextFieldInscricaoEstadual().setText(cliente_antigo_J.getInscricaoEstadual());
		telaCliente.getTelaJuridica().getComboBoxUfInscricaoEstadual().setSelectedItem(cliente_antigo_J.getInscricaoEstadualUF());
		telaCliente.getTelaJuridica().getFormattedTextFieldCEP().setText(cliente_antigo_J.getCep());
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldLogradouro().setText(cliente_antigo_J.getLogradouro());
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldNumero().setText(cliente_antigo_J.getNumeroEndereco());
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldBairro().setText(cliente_antigo_J.getBairro());
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldComplemento().setText(cliente_antigo_J.getComplemento());
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldCidade().setText(cliente_antigo_J.getCidade());
		telaCliente.getTelaJuridica().getComboBoxEstadoEndereco().setSelectedItem(cliente_antigo_J.getUf_estado());
		telaCliente.getTelaJuridica().getFormattedTextFieldTelefone().setText(cliente_antigo_J.getTelefone());
		telaCliente.getTelaJuridica().getValidacaoJTextFieldEmail().setText(cliente_antigo_J.getEmail());
		telaCliente.getTelaJuridica().getValidacaoJTextFieldLimiteCredito().setText(String.valueOf(cliente_antigo_J.getLimiteCredito()));
		telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		telaCliente.getTelaPesquisa().getTextFieldEntradaDado().setText("");		
	}
	
	private void getBotaoExcluirAction() {
		telaCliente.getTelaPesquisa().getButtonExcluir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Busca"))
				{
					if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Busca - Pessoa Física")) {
						exclusaoFisico();
						limpar_campos_fisico();
					}
					else if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Busca - Pessoa Jurídica")) {
						exclusaoJuridico();
						limpar_campos_juridico();
					}
				}
				else if(telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Pessoa Física")) {
					if(telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow() != -1) {					
						//telaCliente.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Física - Exclusão de cliente");
						int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
						ModeloClientePessoaFisica cliente = telaCliente.getBuscaExibicaoTableModelFisico(true).getCliente(linhaSelecionada);
						
						Object[] options = { "NÃO", "SIM" };
					      int opcao = JOptionPane.showOptionDialog(null, "Deseja excluir o cliente de nome: '" + cliente.getNome() +"' ?", "Exclusão",
					          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					              null, options, options[0]);
					      
					      if(opcao == 1) {
					    	  telaCliente.getBuscaExibicaoTableModelFisico(true).removerCliente(linhaSelecionada);
					    	  String cpf = cliente.getCpf();
					    	  String id = banco.consultar("cliente", "cpf" , cpf, "ENDERECO_id");;
					    	  
					    	  if(new DadosClientePessoaFisica().bancoDeDadosExcluir(cpf, id) == true) {
					    		  limpar_campos_fisico();
					    		  //campos_inicial_fisico();
					    	  }				    	  
					      }										
					}
					else {
						JOptionPane.showMessageDialog(null, "Selecione um cliente da lista exibida pela busca!"
								  , "Aviso", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else if(telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Pessoa Jurídica")) {
					if(telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow() != -1) {					
						//telaCliente.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Jurídica - Exclusão de cliente");
						int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
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
					    		  limpar_campos_juridico();
					    		  //campos_inicial_juridico();
					    	  }				    	  
					      }										
					}
					else {
						JOptionPane.showMessageDialog(null, "Selecione um cliente da lista exibida pela busca!"
								  , "Aviso", JOptionPane.INFORMATION_MESSAGE);
					}
				}
					
			}
		});
	}
	
	public void exclusaoFisico() {
		int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
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
		    		  inicial_limpeza_geral();
		    	  }	
		      }
	}
	
	public void exclusaoJuridico() {
		int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
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
	    		  inicial_limpeza_geral();
	    	  }				    	  
	      }	
	}

	private void getBotaoCancelarAction() {
		telaCliente.getTelaPesquisa().getButtonCancelar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente"))
				{
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar a busca atual?", "Cancelamento",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  inicial_limpeza_geral();
				      }
				}
				else if(telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Pessoa Física")) {
					if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Física")) {
						Object[] options = { "NÃO", "SIM" };
					      int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar o procedimento atual?", "Cancelamento",
					          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					              null, options, options[0]);
					      
					      if(opcao == 1) {
					    	  limpar_campos_fisico();
					    	  inicial_buttons_fj();
					    	  campos_inicial_fisico();
					    	  telaCliente.getTelaPesquisa().getJTableDados().setModel(telaCliente.getBuscaExibicaoTableModelFisico(false));
					      }	
					}
					else if(telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Pessoa Física - Alterar")){
						Object[] options = { "NÃO", "SIM" };
						int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar o procedimento atual?", "Cancelamento",
								JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
								null, options, options[0]);
						
						if(opcao == 1) {
							limpar_campos_fisico();
							campos_inicial_fisico();
							botoes_habilitados_pos_busca(true);
						}
					}
					else {
						Object[] options = { "NÃO", "SIM" };
						int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar o procedimento atual?", "Cancelamento",
								JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
								null, options, options[0]);
						
						if(opcao == 1) {
							limpar_campos_fisico();
							campos_inicial_fisico();
						}						
					}
				}
				else if(telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Pessoa Jurídica")) {
					if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica")) {
						Object[] options = { "NÃO", "SIM" };
						int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar o procedimento atual?", "Cancelamento",
								JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
								null, options, options[0]);
						
						if(opcao == 1) {
							limpar_campos_juridico();
							inicial_buttons_fj();
							campos_inicial_juridico();
							telaCliente.getTelaPesquisa().getJTableDados().setModel(telaCliente.getBuscaExibicaoTableModelJuridico(false));
						}						
					}
					else if(telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Pessoa Jurídica - Alterar")){
						Object[] options = { "NÃO", "SIM" };
						int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar o procedimento atual?", "Cancelamento",
								JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
								null, options, options[0]);
						
						if(opcao == 1) {
							limpar_campos_juridico();
							campos_inicial_juridico();
							botoes_habilitados_pos_busca(true);
						}
					}	
					else {
						Object[] options = { "NÃO", "SIM" };
						int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar o procedimento atual?", "Cancelamento",
								JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
								null, options, options[0]);
						
						if(opcao == 1) {
							limpar_campos_juridico();
							campos_inicial_juridico();
							//antes de fazer a limpeza dos butoes ver se tem clientes  mostrando na tabela de busca.
							//inicial_buttons_fj();
						}
					}
					
				}
				else {
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar a busca atual?", "Cancelamento",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  inicial_limpeza_geral();
				      }
				}
			}
		});
	}

	private void getBotaoFecharAction() {		
			telaCliente.getTelaPesquisa().getButtonFechar().addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {				
					if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente"))
					{
						framePrincipal.dispose();		
					}
					else{
						Object[] options = { "NÃO", "SIM" };
						int opcao = JOptionPane.showOptionDialog(null, "Deseja retornar a tela de cadastro de clientes?", "Fechar",
								JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
								null, options, options[0]);
						
						if(opcao == 1) {
							chamarTelaCliente();
						}
					}
				}			
			});
		
	}	
	
	private void getBotaoBuscarAction() {
		telaCliente.getTelaPesquisa().getButtonBuscar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente"))
				{
					String tipoBusca;
					
					tipoBusca = telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString();
					
					if(tipoBusca == "Nome" || tipoBusca == "CPF") {
						if(busca_banco_fisico() == true) {
							tela_fisico();
							botoes_habilitados_pos_busca(true);					
						}
					}
					else if(tipoBusca == "Razão Social" || tipoBusca == "CNPJ") {
						if(busca_banco_juridico() == true) {
							tela_juridico();
							telaCliente.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Jurídica");
							botoes_habilitados_pos_busca(true);									
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Preencha o campo de busca e escolha um tipo de busca!"
								  , "Selecione", JOptionPane.INFORMATION_MESSAGE);
					}
				}	
				else if (telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Pessoa Física")) {
					if(busca_banco_fisico() == true) {
						telaCliente.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Física");
						botoes_habilitados_pos_busca(true);					
					}	
				}
				else if (telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Pessoa Jurídica")) {
					if(busca_banco_juridico() == true) {
						telaCliente.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Jurídica");
						botoes_habilitados_pos_busca(true);					
					}	
				}
			}
		});
	}

	private void getBotaoIncluirAction() {
		telaCliente.getTelaPesquisa().getButtonIncluir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente"))
				{
					if(telaCliente.getComboBoxTipoCliente().getSelectedItem().toString().equals("Selecione")) {
						JOptionPane.showMessageDialog(null, "Selecione um tipo de cliente!", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Física")) {
					telaCliente.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Física - Incluir");
					incluir_alterar_campos_f(true);
					incluir_alterar_buttons(true);	
				}
				else if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica")) {
					telaCliente.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Jurídica - Incluir");
					incluir_alterar_campos_j(true);
					incluir_alterar_buttons(true);	
				}
			}
		});
	}
	
	private void getTipoClienteAction() {
		telaCliente.getComboBoxTipoCliente().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente"))
				{
					String opcao = telaCliente.getComboBoxTipoCliente().getSelectedItem().toString();
					
						if(opcao.equals("Pessoa Física")) {							
							tela_fisico();
						}
						else if(opcao.equals("Pessoa Jurídica")) {
							tela_juridico();
						}
				}	
			}
		});		
	}
	
	
	
	private void getSelecionarUmClienteTabela() {
		telaCliente.getTelaPesquisa().getJTableDados().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente")) {
					if(e.getClickCount() == 1) {
						System.out.println(telaCliente.getLabelPaginaCadastroCliente().getText());
						if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Busca - Pessoa Física")) {
							int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();
							//						getControladorPessoaFisicaInstancia().atribuicaoDeBuscaAosCampos(telaCliente.getBuscaExibicaoTableModelFisico(true).getCliente(linhaSelecionada));
							//						getControladorPessoaFisicaInstancia().botoesHabilitadosPosBusca(true);
							//						getControladorPessoaFisicaInstancia().getTelaClienteFisico().getTelaPesquisa().getTextFieldEntradaDado().setText(telaCliente.getTelaPesquisa().getTextFieldEntradaDado().getText());
							//						getControladorPessoaFisicaInstancia().getTelaClienteFisico().getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem(telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString());
							//						getControladorPessoaFisicaInstancia().getTelaClienteFisico().getTelaPesquisa().getJTableDadosCliente().setModel(telaCliente.getBuscaExibicaoTableModelFisico(true));;
							//						getControladorPessoaFisicaInstancia().getTelaClienteFisico().getBuscaExibicaoTableModel(true).setClienteArray(telaCliente.getBuscaExibicaoTableModelFisico(true).getClienteArray());
							//erro aqui....
							
						}
						else if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Busca - Pessoa Jurídica")) {
							int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();			
							//						getControladorPessoaJuridicaInstancia().atribuicaoDeBuscaAosCampos(telaCliente.getBuscaExibicaoTableModelJuridico(true).getCliente(linhaSelecionada));
							//						getControladorPessoaJuridicaInstancia().botoesHabilitadosPosBusca(true);
							//						getControladorPessoaJuridicaInstancia().getTelaClienteJuridico().getTelaPesquisa().getTextFieldEntradaDado().setText(telaCliente.getTelaPesquisa().getTextFieldEntradaDado().getText());
							//						getControladorPessoaJuridicaInstancia().getTelaClienteJuridico().getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem(telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString());
							//						getControladorPessoaJuridicaInstancia().getTelaClienteJuridico().getTelaPesquisa().getJTableDadosCliente().setModel(telaCliente.getBuscaExibicaoTableModelJuridico(true));
							//						getControladorPessoaJuridicaInstancia().getTelaClienteJuridico().getBuscaExibicaoTableModel(true).setClienteArray(telaCliente.getBuscaExibicaoTableModelJuridico(true).getClienteArray());
							//erro aqui....
						}	
					}						
				}
				else if(telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Pessoa Física")) {
					if(e.getClickCount() == 1) {
						if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Física - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
						      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Fechar",
						          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						              null, options, options[0]);
						      
						      if(opcao == 1) {
						    	  telaCliente.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Física - Alterar");
						    	  cliente_exibicao_F = new ModeloClientePessoaFisica();
						    	  int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
						    	  cliente_exibicao_F = telaCliente.getBuscaExibicaoTableModelFisico(true).getCliente(linhaSelecionada);					
						    	  atribuicao_busca_campos_F(cliente_exibicao_F);
						      }
						}
						else {
							cliente_exibicao_F = new ModeloClientePessoaFisica();
							int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
							cliente_exibicao_F = telaCliente.getBuscaExibicaoTableModelFisico(true).getCliente(linhaSelecionada);					
							atribuicao_busca_campos_F(cliente_exibicao_F);
						}
							
					}
				}
				else if(telaCliente.getLabelPaginaCadastroCliente().getText().contains(" Cadastro de Cliente - Pessoa Jurídica")) {
					if(e.getClickCount() == 1) {
						if(telaCliente.getLabelPaginaCadastroCliente().getText().equals(" Cadastro de Cliente - Pessoa Jurídica - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
						      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Fechar",
						          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						              null, options, options[0]);
						      
						      if(opcao == 1) {
						    	  telaCliente.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Jurídica - Alterar");
						    	  cliente_atual_J = new ModeloClientePessoaJuridica();
						    	  int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
						    	  cliente_atual_J = telaCliente.getBuscaExibicaoTableModelJuridico(true).getCliente(linhaSelecionada);
						    	  atribuicao_busca_campos_J(cliente_atual_J);
						      }
						}
						else {
							cliente_atual_J = new ModeloClientePessoaJuridica();
							int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();					
							cliente_atual_J = telaCliente.getBuscaExibicaoTableModelJuridico(true).getCliente(linhaSelecionada);					
							atribuicao_busca_campos_J(cliente_atual_J);
						}
					}
				}				
			}
			
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
	}
	
	public void inicializaTela() {
		framePrincipal.getContentPane().removeAll();
		framePrincipal.setContentPane(getTela());
		framePrincipal.setVisible(true);
		framePrincipal.setResizable(false);
		framePrincipal.setMinimumSize(new Dimension(1055, 720));
		framePrincipal.setMaximumSize(new Dimension(1055, 720));
		framePrincipal.setLocationRelativeTo(null);
		framePrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framePrincipal.repaint();
		framePrincipal.validate();
	}
	
	public VisaoTelaCadastroCliente getTela() {
		if(telaCliente==null) {
			telaCliente = new VisaoTelaCadastroCliente();
		}
		return telaCliente;
	}
	
	private boolean buscaClienteJuridico(String tipoBusca, String valorBusca) {
		if(!tipoBusca.equals("Selecione")) {		
			if(!valorBusca.trim().equals("")) {
				if(tipoBusca.equals("Razão Social")) {
					DadosClientePessoaJuridica cliente = new DadosClientePessoaJuridica();
					telaCliente.getTelaPesquisa().getJTableDados().setModel(telaCliente.getBuscaExibicaoTableModelJuridico(false));//seta uma nova tabela, só pra exibição dos resultados da busca
					
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
					telaCliente.getTelaPesquisa().getJTableDados().setModel(telaCliente.getBuscaExibicaoTableModelJuridico(false));//seta uma nova tabela, só pra exibição dos resultados da busca
					
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
					telaCliente.getTelaPesquisa().getJTableDados().setModel(telaCliente.getBuscaExibicaoTableModelFisico(false));//seta uma nova tabela, só pra exibição dos resultados da busca
					
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
									break;
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
					telaCliente.getTelaPesquisa().getJTableDados().setModel(telaCliente.getBuscaExibicaoTableModelFisico(false));//seta uma nova tabela, só pra exibição dos resultados da busca
					
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
									break;
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
	
	private void botoes_habilitados_pos_busca(boolean b) {
		telaCliente.getTelaPesquisa().getButtonExcluir().setEnabled(b);
		telaCliente.getTelaPesquisa().getButtonAlterar().setEnabled(b);
		telaCliente.getTelaPesquisa().getButtonCancelar().setEnabled(b);
		telaCliente.getTelaPesquisa().getButtonConfirmar().setEnabled(!b);
		telaCliente.getTelaPesquisa().getButtonIncluir().setEnabled(!b);
	}	
	
	private void inicial_limpeza_geral() {
		inicial_buttons_geral();
		limpar_campos_geral();
	}
	
	private void inicial_buttons_geral() {
		telaCliente.getTelaPesquisa().getButtonExcluir().setEnabled(false);
		telaCliente.getTelaPesquisa().getButtonAlterar().setEnabled(false);
		telaCliente.getTelaPesquisa().getButtonCancelar().setEnabled(false);
		telaCliente.getTelaPesquisa().getButtonConfirmar().setEnabled(false);
		telaCliente.getTelaPesquisa().getButtonIncluir().setEnabled(false);		
	}
	
	public void chamarTelaCliente() {
		telaCliente.remove(2);
		telaCliente.add(telaCliente.getPanel());
		inicial_limpeza_geral();	
		telaCliente.repaint();
		telaCliente.validate();
	}
	
	public void tela_fisico() {
		telaCliente.remove(2);
		telaCliente.add(telaCliente.getTelaFisica());
		limpar_campos_fisico();
		campos_inicial_fisico();
		inicial_buttons_fj();
		if(telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().getItemCount()>3) {
			telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().removeItem("Razão Social");
			telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().removeItem("CNPJ");
		}
		telaCliente.repaint();
		telaCliente.validate();
	}
	
	public void tela_juridico() {
		telaCliente.removePanel();
		telaCliente.add(telaCliente.getTelaJuridica());
		limpar_campos_juridico();
		campos_inicial_juridico();
		inicial_buttons_fj();
		if(telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().getItemCount()>3) {
			telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().removeItem("CPF");
			telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().removeItem("Nome");			
		}
		telaCliente.repaint();
		telaCliente.validate();
	}
	
	private void campos_inicial_juridico() {
		telaCliente.getTelaJuridica().getComboBoxSituacaoCliente().setEnabled(false);
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldRazaoSocial().setEnabled(false);
		telaCliente.getTelaJuridica().getValidacaoJTextFieldCnpj().setEnabled(false);
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldRepresentante().setEnabled(false);
		telaCliente.getTelaJuridica().getValidacaoJTextFieldInscricaoEstadual().setEnabled(false);
		telaCliente.getTelaJuridica().getComboBoxUfInscricaoEstadual().setEnabled(false);
		telaCliente.getTelaJuridica().getFormattedTextFieldCEP().setEnabled(false);
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldLogradouro().setEnabled(false);
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldNumero().setEnabled(false);
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldBairro().setEnabled(false);
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldComplemento().setEnabled(false);
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldCidade().setEnabled(false);
		telaCliente.getTelaJuridica().getComboBoxEstadoEndereco().setEnabled(false);
		telaCliente.getTelaJuridica().getFormattedTextFieldTelefone().setEnabled(false);
		telaCliente.getTelaJuridica().getValidacaoJTextFieldEmail().setEnabled(false);
		telaCliente.getTelaJuridica().getValidacaoJTextFieldLimiteCredito().setEnabled(false);	
	}
	
	private void limpar_campos_geral() {
		telaCliente.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente");
		telaCliente.getComboBoxTipoCliente().setSelectedItem("Selecione");
		telaCliente.getTelaPesquisa().getTextFieldEntradaDado().setText("");
		telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		telaCliente.getTelaPesquisa().getJTableDados().setModel(new DefaultTableModel(
				new Object[][] {
//					{null, null, null, null},
//					{null, null, null, null},
//					{null, null, null, null},
//					{null, null, null, null},
//					{null, null, null, null},
//					{null, null, null, null},
//					{null, null, null, null},
//					{null, null, null, null},
//					{null, null, null, null},
//					{null, null, null, null},
//					{null, null, null, null},
//					{null, null, null, null},
//					{null, null, null, null},
				},
				new String[] {
					"CPF/CNPJ", "Nome/Razão Social", "Endere\u00E7o", "Telefone"
				}
			)
		);
		if (telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().getItemCount()<=3) {
			telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().removeAllItems();
			telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().addItem("Selecione");
			telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().addItem("Nome");
			telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().addItem("Razão Social");
			telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().addItem("CNPJ");
			telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().addItem("CPF");
		}
	}
	
	private void incluir_alterar_campos_j(boolean b) {
		telaCliente.getTelaJuridica().getComboBoxSituacaoCliente().setEnabled(b);
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldRazaoSocial().setEnabled(b);
		telaCliente.getTelaJuridica().getValidacaoJTextFieldCnpj().setEnabled(b);
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldRepresentante().setEnabled(b);
		telaCliente.getTelaJuridica().getValidacaoJTextFieldInscricaoEstadual().setEnabled(b);
		telaCliente.getTelaJuridica().getComboBoxUfInscricaoEstadual().setEnabled(b);
		telaCliente.getTelaJuridica().getFormattedTextFieldCEP().setEnabled(b);
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldLogradouro().setEnabled(b);
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldNumero().setEnabled(b);
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldBairro().setEnabled(b);
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldComplemento().setEnabled(b);
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldCidade().setEnabled(b);
		telaCliente.getTelaJuridica().getComboBoxEstadoEndereco().setEnabled(b);
		telaCliente.getTelaJuridica().getFormattedTextFieldTelefone().setEnabled(b);
		telaCliente.getTelaJuridica().getValidacaoJTextFieldEmail().setEnabled(b);
		telaCliente.getTelaJuridica().getValidacaoJTextFieldLimiteCredito().setEnabled(b);
	}
	
	public void limpar_pesquisa_juridico() {
		telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		telaCliente.getTelaPesquisa().getTextFieldEntradaDado().setText("");
		telaCliente.getTelaPesquisa().getJTableDados().setModel(telaCliente.getBuscaExibicaoTableModelJuridico(false));	
	}
	
	private void limpar_campos_juridico() {
		telaCliente.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Jurídica");
		telaCliente.getTelaJuridica().getComboBoxSituacaoCliente().setSelectedIndex(0);
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldRazaoSocial().setText("");
		telaCliente.getTelaJuridica().getValidacaoJTextFieldCnpj().setText("");
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldRepresentante().setText("");
		telaCliente.getTelaJuridica().getValidacaoJTextFieldInscricaoEstadual().setText("");
		telaCliente.getTelaJuridica().getComboBoxUfInscricaoEstadual().setSelectedIndex(0);
		telaCliente.getTelaJuridica().getFormattedTextFieldCEP().setText("");
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldLogradouro().setText("");
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldNumero().setText("");
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldBairro().setText("");
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldComplemento().setText("");
		telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldCidade().setText("");
		telaCliente.getTelaJuridica().getComboBoxEstadoEndereco().setSelectedIndex(0);
		telaCliente.getTelaJuridica().getFormattedTextFieldTelefone().setText("");
		telaCliente.getTelaJuridica().getValidacaoJTextFieldEmail().setText("");
		telaCliente.getTelaJuridica().getValidacaoJTextFieldLimiteCredito().setText("");	
	}

	private void inicial_buttons_fj() {
		telaCliente.getTelaPesquisa().getButtonExcluir().setEnabled(false);
		telaCliente.getTelaPesquisa().getButtonAlterar().setEnabled(false);
		telaCliente.getTelaPesquisa().getButtonCancelar().setEnabled(false);
		telaCliente.getTelaPesquisa().getButtonConfirmar().setEnabled(false);
		telaCliente.getTelaPesquisa().getButtonIncluir().setEnabled(true);
		telaCliente.getTelaPesquisa().getButtonBuscar().setEnabled(true);
	}
	
	public void incluir_alterar_buttons(boolean b) {
		telaCliente.getTelaPesquisa().getButtonConfirmar().setEnabled(b);
		telaCliente.getTelaPesquisa().getButtonCancelar().setEnabled(b);
		telaCliente.getTelaPesquisa().getButtonIncluir().setEnabled(!b);
		telaCliente.getTelaPesquisa().getButtonExcluir().setEnabled(!b);
		telaCliente.getTelaPesquisa().getButtonAlterar().setEnabled(!b);
	}		
	
	private void campos_inicial_fisico() {
		telaCliente.getTelaFisica().getComboBoxSituacaoCliente().setEnabled(false);
		telaCliente.getTelaFisica().getValidacaoJTextFieldNome().setEnabled(false);
		telaCliente.getTelaFisica().getFormattedTextFieldDataNascimento().setEnabled(false);
		telaCliente.getTelaFisica().getComboBoxSexo().setEnabled(false);
		telaCliente.getTelaFisica().getFormattedTextFieldCPF().setEnabled(false);
		telaCliente.getTelaFisica().getValidacaoJTextFieldRG().setEnabled(false);
		telaCliente.getTelaFisica().getComboBoxEstadoRG().setEnabled(false);
		telaCliente.getTelaFisica().getValidacaoJTextFieldOrgaoExpeditor().setEnabled(false);
		telaCliente.getTelaFisica().getFormattedTextFieldCEP().setEnabled(false);
		telaCliente.getTelaFisica().getValidacaoJTextFieldLogradouro().setEnabled(false);
		telaCliente.getTelaFisica().getValidacaoJTextFieldNumero().setEnabled(false);
		telaCliente.getTelaFisica().getValidacaoJTextFieldBairro().setEnabled(false);
		telaCliente.getTelaFisica().getValidacaoJTextFieldComplemento().setEnabled(false);
		telaCliente.getTelaFisica().getValidacaoJTextFieldCidade().setEnabled(false);
		telaCliente.getTelaFisica().getComboBoxEstadoEndereco().setEnabled(false);
		telaCliente.getTelaFisica().getFormattedTextFieldTelefone().setEnabled(false);
		telaCliente.getTelaFisica().getTextFieldEmail().setEnabled(false);
		telaCliente.getTelaFisica().getTextFieldLimiteCredito().setEnabled(false);
	}
	
	public void limpar_pesquisa_fisico() {
		telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		telaCliente.getTelaPesquisa().getTextFieldEntradaDado().setText("");
		telaCliente.getTelaPesquisa().getJTableDados().setModel(telaCliente.getBuscaExibicaoTableModelFisico(false));
	}
	
	public void incluir_alterar_campos_f(boolean b) {
		telaCliente.getTelaFisica().getComboBoxSituacaoCliente().setEnabled(b);
		telaCliente.getTelaFisica().getValidacaoJTextFieldNome().setEnabled(b);
		telaCliente.getTelaFisica().getFormattedTextFieldDataNascimento().setEnabled(b);
		telaCliente.getTelaFisica().getComboBoxSexo().setEnabled(b);
		telaCliente.getTelaFisica().getFormattedTextFieldCPF().setEnabled(b);
		telaCliente.getTelaFisica().getValidacaoJTextFieldRG().setEnabled(b);
		telaCliente.getTelaFisica().getComboBoxEstadoRG().setEnabled(b);
		telaCliente.getTelaFisica().getValidacaoJTextFieldOrgaoExpeditor().setEnabled(b);
		telaCliente.getTelaFisica().getFormattedTextFieldCEP().setEnabled(b);
		telaCliente.getTelaFisica().getValidacaoJTextFieldLogradouro().setEnabled(b);
		telaCliente.getTelaFisica().getValidacaoJTextFieldNumero().setEnabled(b);
		telaCliente.getTelaFisica().getValidacaoJTextFieldBairro().setEnabled(b);
		telaCliente.getTelaFisica().getValidacaoJTextFieldComplemento().setEnabled(b);
		telaCliente.getTelaFisica().getValidacaoJTextFieldCidade().setEnabled(b);
		telaCliente.getTelaFisica().getComboBoxEstadoEndereco().setEnabled(b);
		telaCliente.getTelaFisica().getFormattedTextFieldTelefone().setEnabled(b);
		telaCliente.getTelaFisica().getTextFieldEmail().setEnabled(b);
		telaCliente.getTelaFisica().getTextFieldLimiteCredito().setEnabled(b);
	}
	
	private void limpar_campos_fisico() {
		telaCliente.getLabelPaginaCadastroCliente().setText(" Cadastro de Cliente - Pessoa Física");
		telaCliente.getTelaFisica().getComboBoxSituacaoCliente().setSelectedIndex(0);
		telaCliente.getTelaFisica().getValidacaoJTextFieldNome().setText("");
		telaCliente.getTelaFisica().getFormattedTextFieldDataNascimento().setText("");
		telaCliente.getTelaFisica().getComboBoxSexo().setSelectedIndex(0);
		telaCliente.getTelaFisica().getFormattedTextFieldCPF().setText("");
		telaCliente.getTelaFisica().getValidacaoJTextFieldRG().setText("");
		telaCliente.getTelaFisica().getComboBoxEstadoRG().setSelectedIndex(0);
		telaCliente.getTelaFisica().getValidacaoJTextFieldOrgaoExpeditor().setText("");
		telaCliente.getTelaFisica().getFormattedTextFieldCEP().setText("");
		telaCliente.getTelaFisica().getValidacaoJTextFieldLogradouro().setText("");
		telaCliente.getTelaFisica().getValidacaoJTextFieldNumero().setText("");
		telaCliente.getTelaFisica().getValidacaoJTextFieldBairro().setText("");
		telaCliente.getTelaFisica().getValidacaoJTextFieldComplemento().setText("");
		telaCliente.getTelaFisica().getValidacaoJTextFieldCidade().setText("");
		telaCliente.getTelaFisica().getComboBoxEstadoEndereco().setSelectedIndex(0);
		telaCliente.getTelaFisica().getFormattedTextFieldTelefone().setText("");
		telaCliente.getTelaFisica().getTextFieldEmail().setText("");
		telaCliente.getTelaFisica().getTextFieldLimiteCredito().setText("");
	}
	
	private boolean busca_banco_fisico() {
		String tipoBusca, valorBusca;
		
		tipoBusca = telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString();
		valorBusca = telaCliente.getTelaPesquisa().getTextFieldEntradaDado().getText();
		
		if(!tipoBusca.equals("Selecione")) {		
			if(!valorBusca.trim().equals("")) {
				if(tipoBusca.equals("Nome")) {
					DadosClientePessoaFisica cliente = new DadosClientePessoaFisica();
					telaCliente.getTelaPesquisa().getJTableDados().setModel(telaCliente.getBuscaExibicaoTableModelFisico(false));//seta uma nova tabela, só pra exibição dos resultados da busca
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
						//JOptionPane.showMessageDialog(null, "Busca finalizada, " + telaCliente.getBuscaExibicaoTableModel(true).getRowCount() + " clientes encontrados.", "Busca", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum cliente encontrado."
								  , "Busca", JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
				}
				else if(tipoBusca.equals("CPF")) {
					DadosClientePessoaFisica cliente = new DadosClientePessoaFisica();
					telaCliente.getTelaPesquisa().getJTableDados().setModel(telaCliente.getBuscaExibicaoTableModelFisico(false));//seta uma nova tabela, só pra exibição dos resultados da busca
					
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
						//JOptionPane.showMessageDialog(null, "Busca finalizada, " + telaCliente.getBuscaExibicaoTableModel(true).getRowCount() + " clientes encontrados.", "Busca", JOptionPane.INFORMATION_MESSAGE);
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
	
	private boolean busca_banco_juridico() {
		String tipoBusca, valorBusca;
		
		tipoBusca = telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString();
		valorBusca = telaCliente.getTelaPesquisa().getTextFieldEntradaDado().getText();
		
		if(!tipoBusca.equals("Selecione")) {		
			if(!valorBusca.trim().equals("")) {
				if(tipoBusca.equals("Razão Social")) {
					DadosClientePessoaJuridica cliente = new DadosClientePessoaJuridica();
					telaCliente.getTelaPesquisa().getJTableDados().setModel(telaCliente.getBuscaExibicaoTableModelJuridico(false));//seta uma nova tabela, só pra exibição dos resultados da busca
					
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
									break;
								}
							}
						}				
					}
					if(telaCliente.getBuscaExibicaoTableModelJuridico(true).getRowCount() > 0) {
						//JOptionPane.showMessageDialog(null, "Busca finalizada, " + telaCliente.getBuscaExibicaoTableModel(true).getRowCount() + " clientes encontrados.", "Busca", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum cliente encontrado."
								  , "Busca", JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
				}
				else if(tipoBusca.equals("CNPJ")) {
					DadosClientePessoaJuridica cliente = new DadosClientePessoaJuridica();
					telaCliente.getTelaPesquisa().getJTableDados().setModel(telaCliente.getBuscaExibicaoTableModelJuridico(false));//seta uma nova tabela, só pra exibição dos resultados da busca
					
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
									break;
								}
							}
						}				
					}	
					if(telaCliente.getBuscaExibicaoTableModelJuridico(true).getRowCount() > 0) {
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
	
	public void atribuicao_busca_campos_F(ModeloClientePessoaFisica cliente) {
		telaCliente.getTelaFisica().getComboBoxSituacaoCliente().setSelectedItem(cliente.getSituacao());
		telaCliente.getTelaFisica().getValidacaoJTextFieldNome().setText(cliente.getNome());
		telaCliente.getTelaFisica().getFormattedTextFieldDataNascimento().setText(cliente.getDataNascimento());
		telaCliente.getTelaFisica().getComboBoxSexo().setSelectedItem(cliente.getSexo());
		telaCliente.getTelaFisica().getFormattedTextFieldCPF().setText(cliente.getCpf());
		telaCliente.getTelaFisica().getValidacaoJTextFieldRG().setText(cliente.getRg());
		telaCliente.getTelaFisica().getComboBoxEstadoRG().setSelectedItem(cliente.getUfRg());
		telaCliente.getTelaFisica().getValidacaoJTextFieldOrgaoExpeditor().setText(cliente.getOrgaoExpeditorRg());
		telaCliente.getTelaFisica().getFormattedTextFieldCEP().setText(cliente.getCep());
		telaCliente.getTelaFisica().getValidacaoJTextFieldLogradouro().setText(cliente.getLogradouro());
		telaCliente.getTelaFisica().getValidacaoJTextFieldNumero().setText(cliente.getNumeroEndereco());
		telaCliente.getTelaFisica().getValidacaoJTextFieldBairro().setText(cliente.getBairro());
		telaCliente.getTelaFisica().getValidacaoJTextFieldComplemento().setText(cliente.getComplemento());
		telaCliente.getTelaFisica().getValidacaoJTextFieldCidade().setText(cliente.getCidade());
		telaCliente.getTelaFisica().getComboBoxEstadoEndereco().setSelectedItem(cliente.getUf_estado());
		telaCliente.getTelaFisica().getFormattedTextFieldTelefone().setText(cliente.getTelefone());
		telaCliente.getTelaFisica().getTextFieldEmail().setText(cliente.getEmail());
		telaCliente.getTelaFisica().getTextFieldLimiteCredito().setText(String.valueOf(cliente.getLimiteCredito()));
		//telaCliente.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		//telaCliente.getTelaPesquisa().getTextFieldEntradaDado().setText("");
	}
	
	private void capturar_campos_juridico() {
		cliente_atual_J = new ModeloClientePessoaJuridica();
		this.cliente_atual_J.setSituacao(telaCliente.getTelaJuridica().getComboBoxSituacaoCliente().getSelectedItem().toString());
		this.cliente_atual_J.setRazaoSocial(telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldRazaoSocial().getText());
		this.cliente_atual_J.setCnpj(telaCliente.getTelaJuridica().getValidacaoJTextFieldCnpj().getText());
		this.cliente_atual_J.setRepresentante(telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldRepresentante().getText());
		this.cliente_atual_J.setInscricaoEstadual(telaCliente.getTelaJuridica().getValidacaoJTextFieldInscricaoEstadual().getText());
		this.cliente_atual_J.setInscricaoEstadualUF(telaCliente.getTelaJuridica().getComboBoxUfInscricaoEstadual().getSelectedItem().toString());
		
		try {
			this.cliente_atual_J.setLimiteCredito(Double.parseDouble(telaCliente.getTelaJuridica().getValidacaoJTextFieldLimiteCredito().getText()));
		} catch (NumberFormatException e) {
			//e.printStackTrace();
			this.cliente_atual_J.setLimiteCredito(-1);
			//System.out.println(cliente.getLimiteCredito());
		}
						
		this.cliente_atual_J.setCep(telaCliente.getTelaJuridica().getFormattedTextFieldCEP().getText());
		this.cliente_atual_J.setLogradouro(telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldLogradouro().getText());
		this.cliente_atual_J.setNumeroEndereco(telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldNumero().getText());
		this.cliente_atual_J.setBairro(telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldBairro().getText());
		this.cliente_atual_J.setComplemento(telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldComplemento().getText());
		this.cliente_atual_J.setCidade(telaCliente.getTelaJuridica().getValidacaoGeralJTextFieldCidade().getText());
		this.cliente_atual_J.setUf_estado(telaCliente.getTelaJuridica().getComboBoxEstadoEndereco().getSelectedItem().toString());
		this.cliente_atual_J.setTelefone(telaCliente.getTelaJuridica().getFormattedTextFieldTelefone().getText());
		this.cliente_atual_J.setEmail(telaCliente.getTelaJuridica().getValidacaoJTextFieldEmail().getText());
	}
	
	private void capturar_campos_fisico() {
		cliente_atual_F = new ModeloClientePessoaFisica();
		
		this.cliente_atual_F.setSituacao(telaCliente.getTelaFisica().getComboBoxSituacaoCliente().getSelectedItem().toString());
		this.cliente_atual_F.setNome(telaCliente.getTelaFisica().getValidacaoJTextFieldNome().getText());
		this.cliente_atual_F.setDataNascimento(telaCliente.getTelaFisica().getFormattedTextFieldDataNascimento().getText());
		this.cliente_atual_F.setSexo(telaCliente.getTelaFisica().getComboBoxSexo().getSelectedItem().toString());
		this.cliente_atual_F.setCpf(telaCliente.getTelaFisica().getFormattedTextFieldCPF().getText());
		this.cliente_atual_F.setRg(telaCliente.getTelaFisica().getValidacaoJTextFieldRG().getText());
		this.cliente_atual_F.setUfRg(telaCliente.getTelaFisica().getComboBoxEstadoRG().getSelectedItem().toString());
		this.cliente_atual_F.setOrgaoExpeditorRg(telaCliente.getTelaFisica().getValidacaoJTextFieldOrgaoExpeditor().getText());
		
		try {
			this.cliente_atual_F.setLimiteCredito(Double.parseDouble(telaCliente.getTelaFisica().getTextFieldLimiteCredito().getText()));
		} catch (NumberFormatException e) {
			//e.printStackTrace();
			this.cliente_atual_F.setLimiteCredito(-1);
			//System.out.println(cliente.getLimiteCredito());
		}
						
		this.cliente_atual_F.setCep(telaCliente.getTelaFisica().getFormattedTextFieldCEP().getText());
		this.cliente_atual_F.setLogradouro(telaCliente.getTelaFisica().getValidacaoJTextFieldLogradouro().getText());
		this.cliente_atual_F.setNumeroEndereco(telaCliente.getTelaFisica().getValidacaoJTextFieldNumero().getText());
		this.cliente_atual_F.setBairro(telaCliente.getTelaFisica().getValidacaoJTextFieldBairro().getText());
		this.cliente_atual_F.setComplemento(telaCliente.getTelaFisica().getValidacaoJTextFieldComplemento().getText());
		this.cliente_atual_F.setCidade(telaCliente.getTelaFisica().getValidacaoJTextFieldCidade().getText());
		this.cliente_atual_F.setUf_estado(telaCliente.getTelaFisica().getComboBoxEstadoEndereco().getSelectedItem().toString());
		this.cliente_atual_F.setTelefone(telaCliente.getTelaFisica().getFormattedTextFieldTelefone().getText());
		this.cliente_atual_F.setEmail(telaCliente.getTelaFisica().getTextFieldEmail().getText());
	}
	
	private boolean validacao_cliente_campos_J(String b) {
		ValidacaoClientePessoaJuridica clienteJ;
		
		if(b.equals("Alterar")) {
			DadosClientePessoaJuridica clienteSalvo = new DadosClientePessoaJuridica();
			
			String id_end;
			int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();
			ModeloClientePessoaJuridica cliente = telaCliente.getBuscaExibicaoTableModelJuridico(true).getCliente(linhaSelecionada);
			
			cliente_antigo_J = new ModeloClientePessoaJuridica();
			cliente_antigo_J = cliente;
			
			clienteJ = new ValidacaoClientePessoaJuridica(cliente_atual_J);
			id_end = banco.consultar("cliente", "cnpj" , cliente_antigo_J.getCnpj(), "ENDERECO_id");
			
			if(clienteJ.isResultadoValidacaoTodosCamposGeral() == true) {					
				
				clienteSalvo.bancoDeDadosAlterar(cliente_atual_J, cliente_antigo_J.getCnpj(), id_end);
				
				return true;
			}			
					
		}
		
		else if(b.equals("Incluir")) {
			DadosClientePessoaJuridica clienteSalvo = new DadosClientePessoaJuridica();
			
			clienteJ = new ValidacaoClientePessoaJuridica(cliente_atual_J);
			clienteJ .validarCNPJ();
			
			if(clienteJ.isResultadoValidacaoTodosCamposGeral() == true && clienteJ.isResultadoValidacaoCnpjEInscricaoEstadual() == true) {
				
				clienteSalvo.bancoDeDadosIncluir(cliente_atual_J);
				
				return true;
			}
		}
		
		
		return false;
	}
	
	private boolean validacao_cliente_campos_F(String b) {
		ValidacaoClientePessoaFisica clienteF;
		
		if(b.equals("Alterar")) {
			DadosClientePessoaFisica clienteSalvo = new DadosClientePessoaFisica();
			String id_end;
			
			int linhaSelecionada = telaCliente.getTelaPesquisa().getJTableDados().getSelectedRow();
			
			cliente_antigo_F = new ModeloClientePessoaFisica();
			cliente_antigo_F = telaCliente.getBuscaExibicaoTableModelFisico(true).getCliente(linhaSelecionada);
				
			clienteF = new ValidacaoClientePessoaFisica(cliente_atual_F);
			id_end = banco.consultar("cliente", "cpf" , cliente_antigo_F.getCpf(), "ENDERECO_id");
			
			if(clienteF.isResultadoValidacaoTodosCamposGeral() == true) {					
				
				clienteSalvo.bancoDeDadosAlterar(cliente_atual_F, cliente_antigo_F.getCpf(), id_end);
				
				return true;
			}			
		}
		
		else if(b.equals("Incluir")) {
			DadosClientePessoaFisica clienteSalvo = new DadosClientePessoaFisica();
			
			clienteF = new ValidacaoClientePessoaFisica(cliente_atual_F);
			clienteF.validarCPF();
			
			if(clienteF.isResultadoValidacaoTodosCamposGeral() == true && clienteF.isResultadoValidacaoCpfRg() == true) {
				
				clienteSalvo.bancoDeDadosIncluir(cliente_atual_F);
				
				return true;
			}
		}
		
		
		return false;
	}
	
}
