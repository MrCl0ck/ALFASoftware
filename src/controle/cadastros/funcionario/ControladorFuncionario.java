package controle.cadastros.funcionario;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.Banco;
import modelo.cadastros.dados.DadosClientePessoaFisica;
import modelo.cadastros.dados.DadosFuncionario;
import modelo.cadastros.funcionario.Cargo;
import modelo.cadastros.funcionario.ModeloFuncionario;
import modelo.cadastros.validacoes.ValidacaoFuncionario;
import visao.cadastros.cliente.VisaoFramePrincipal;
import visao.cadastros.funcionario.VisaoTelaCadastroFuncionario;

public class ControladorFuncionario {
	private VisaoFramePrincipal framePrincipal;
	private VisaoTelaCadastroFuncionario tela;
	private ModeloFuncionario funcionario_atual;
	private ModeloFuncionario funcionario_antigo;
	private ModeloFuncionario funcionario_exibicao;
	private Banco banco = new Banco();
	private ArrayList<Cargo> cargo  = banco.consultarCargo();

	public ControladorFuncionario(VisaoFramePrincipal frame) {
		framePrincipal = frame;
		inicializaTela();
		buttons_inicial();
		add_eventos();
		carregar_cargos();
		campos_bool(false);
	}

	private void carregar_cargos() {
		for (int i = 0; i < cargo.size(); i++) {
			tela.getComboBoxCargo().addItem(cargo.get(i).getNomeCargo());		    			  
		}	
	}

	private void campos_bool(boolean b) {
		tela.getValidacaoJTextFieldNome().setEnabled(b);
		tela.getFormattedTextFieldCPF().setEnabled(b);
		tela.getValidacaoJTextFieldRG().setEnabled(b);
		tela.getComboBoxEstadoRG().setEnabled(b);
		tela.getValidacaoJTextFieldOrgaoExpeditor().setEnabled(b);
		tela.getValidacaoJTextFieldNacionalidade().setEnabled(b);
		tela.getValidacaoJTextFieldNaturalidade().setEnabled(b);
		tela.getFormattedTextFieldDataNascimento().setEnabled(b);
		tela.getComboBoxSexo().setEnabled(b);;
		tela.getFormattedTextFieldTelefone().setEnabled(b);
		tela.getValidacaoTextFieldEmail().setEnabled(b);
		tela.getTextFieldCtps().setEnabled(b);
		tela.getFormattedTextFieldDataAdmissao().setEnabled(b);
		tela.getComboBoxCargo().setEnabled(b);
		tela.getButtonAdicionarCargo().setEnabled(b);
		tela.getButtonRemoverCargo().setEnabled(b);
		tela.getButtonAlterarCargo().setEnabled(b);
		tela.getValidacaoTextFieldSetor().setEnabled(b);
		tela.getValidacaoTextFieldSalario().setEnabled(b);
		tela.getTextFieldNomeUsuario().setEnabled(b);
		tela.getPasswordFieldSenhaUsuario().setEnabled(b);
		tela.getFormattedTextFieldCEP().setEnabled(b);
		tela.getValidacaoJTextFieldLogradouro().setEnabled(b);
		tela.getValidacaoJTextFieldComplemento().setEnabled(b);
		tela.getValidacaoJTextFieldNumero().setEnabled(b);
		tela.getValidacaoJTextFieldBairro().setEnabled(b);
		tela.getValidacaoJTextFieldCidade().setEnabled(b);
		tela.getComboBoxEstadoEndereco().setEnabled(b);
	}
	
	private void limpar_campos() {
		tela.getLabelCadastroDeFuncionrio().setText(" Cadastro de Funcionário");
		tela.getValidacaoJTextFieldNome().setText("");
		tela.getFormattedTextFieldCPF().setText("");
		tela.getValidacaoJTextFieldRG().setText("");
		tela.getComboBoxEstadoRG().setSelectedItem("Selecione");
		tela.getValidacaoJTextFieldOrgaoExpeditor().setText("");
		tela.getValidacaoJTextFieldNacionalidade().setText("");
		tela.getValidacaoJTextFieldNaturalidade().setText("");
		tela.getFormattedTextFieldDataNascimento().setText("");
		tela.getComboBoxSexo().setSelectedItem("Selecione");
		tela.getFormattedTextFieldTelefone().setText("");
		tela.getValidacaoTextFieldEmail().setText("");
		tela.getTextFieldCtps().setText("");
		tela.getFormattedTextFieldDataAdmissao().setText("");
		tela.getComboBoxCargo().setSelectedItem("Selecione");
		tela.getValidacaoTextFieldSetor().setText("");
		tela.getValidacaoTextFieldSalario().setText("");
		tela.getTextFieldNomeUsuario().setText("");
		tela.getPasswordFieldSenhaUsuario().setText("");
		tela.getFormattedTextFieldCEP().setText("");
		tela.getValidacaoJTextFieldLogradouro().setText("");
		tela.getValidacaoJTextFieldComplemento().setText("");
		tela.getValidacaoJTextFieldNumero().setText("");
		tela.getValidacaoJTextFieldBairro().setText("");
		tela.getValidacaoJTextFieldCidade().setText("");
		tela.getComboBoxEstadoEndereco().setSelectedItem("Selecione");
	}

	private void buttons_inicial() {
		tela.getTelaPesquisa().getButtonExcluir().setEnabled(false);
		tela.getTelaPesquisa().getButtonAlterar().setEnabled(false);
		tela.getTelaPesquisa().getButtonCancelar().setEnabled(false);
		tela.getTelaPesquisa().getButtonConfirmar().setEnabled(false);
		tela.getTelaPesquisa().getButtonIncluir().setEnabled(true);
		tela.getTelaPesquisa().getButtonBuscar().setEnabled(true);		
	}
	
	private void inicializaTela() {
		framePrincipal.getContentPane().removeAll();
		framePrincipal.setContentPane(getTela());
		framePrincipal.setVisible(true);
		framePrincipal.setResizable(false);
		framePrincipal.setMinimumSize(new Dimension(1107, 720));
		framePrincipal.setMaximumSize(new Dimension(1107, 720));
		framePrincipal.setLocationRelativeTo(null);
		framePrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framePrincipal.repaint();
		framePrincipal.validate();
	}
	
	public VisaoTelaCadastroFuncionario getTela() {
		if(tela==null) {
			tela = new VisaoTelaCadastroFuncionario();
		}
		return tela;
	}
	
	private void buttons_inc_alt() {
		tela.getTelaPesquisa().getButtonIncluir().setEnabled(false);
		tela.getTelaPesquisa().getButtonExcluir().setEnabled(false);
		tela.getTelaPesquisa().getButtonAlterar().setEnabled(false);
		tela.getTelaPesquisa().getButtonCancelar().setEnabled(true);
		tela.getTelaPesquisa().getButtonConfirmar().setEnabled(true);
	}

	public void add_eventos() {
			getBotaoBuscarAction();
			getBotaoIncluirAction();
			getBotaoExcluirAction();
			getBotaoAlterarAction();
			getBotaoCancelarAction();
			getBotaoConfirmarAction();
			getBotaoFecharAction();
			getSelecionarUmFuncionarioTabela();
			getSelecionarUmFuncionarioTabelaTyped();
			getMaisCargo();
			getMenosCargo();
			getAlterarCargo();
	}

	private void getAlterarCargo() {
		tela.getButtonAlterarCargo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cargo_antigo = tela.getComboBoxCargo().getSelectedItem().toString();
			    String novo_cargo = JOptionPane.showInputDialog(null, "Insira o novo nome do cargo: ", "Alterar Cargo", JOptionPane.WARNING_MESSAGE);
			      
			      if(novo_cargo != null && novo_cargo.trim().isEmpty() == false && novo_cargo != cargo_antigo && !cargo_antigo.equals("Selecione")
			    		  && !novo_cargo.equals("Selecione")) {
			    	  
			    	  
			    	  if(banco.atualizar("cargo", "nome", cargo_antigo,"nome='" + novo_cargo +  "'") == true) {
			    		  tela.getComboBoxCargo().removeItem(cargo_antigo);
			    		  tela.getComboBoxCargo().addItem(novo_cargo);
			    		  tela.getComboBoxCargo().setSelectedItem(novo_cargo);
			    	  }
			    	  else {
			    		  System.out.println("Erro ao atualizar cargo...");
			    	  }			    	  
			      }
			      else {
			    	  JOptionPane.showMessageDialog(null, "Preencha o campo corretamente!", "Info", JOptionPane.INFORMATION_MESSAGE);
			      }
			    	  
			}
		});
	}

	private void getMenosCargo() {
		tela.getButtonRemoverCargo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			    String cargo_removido = tela.getComboBoxCargo().getSelectedItem().toString();
			   
			    Object[] options = { "NÃO", "SIM" };
				int opcao = JOptionPane.showOptionDialog(null, "Essa ação é irreversível. Deseja remover o cargo: '"+cargo_removido+"'?", "Remover",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						null, options, options[0]);
				
				if (opcao==1) {
					String id = "";
					for (int i = 0; i < cargo.size(); i++) {
						if(cargo.get(i).getNomeCargo() == cargo_removido) {
							id = String.valueOf(cargo.get(i).getId());
							break;
						}
					}					
					//ERRO AO EXCLUIR O CARGO
//					if (banco.excluir("cargo", "id", id)) {
//						tela.getComboBoxCargo().removeItem(cargo_removido);
//					}
//					else{
//						System.out.println("Erro ao remover cargo...");
//					}
				}
			      
			}		
		});
	}
//	boolean achou = false;
//	  
//	ArrayList<Cargo> cargo = banco.consultarCargo(); 
//	  for (int i = 0; i < cargo.size(); i++) {
//		  if(novo_cargo.equals(cargo.get(i).getNomeCargo())) {
//			  achou = true;
//			  break;
//		  }
//	  }
//	  
//	  if(achou == false) {
//		  banco.inserir("cargo", "`nome`", novo_cargo);
//		  tela.getComboBoxCargo().addItem(novo_cargo);
//		  tela.getComboBoxCargo().setSelectedItem(novo_cargo);
//	  }
//	  else {
//		  JOptionPane.showMessageDialog(null, "Esse cargo já existe!", "Info", JOptionPane.INFORMATION_MESSAGE);
//	  }
	
	private void getMaisCargo() {
		tela.getButtonAdicionarCargo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			    String novo_cargo = JOptionPane.showInputDialog(null, "Insira o nome do novo cargo: ", "Adicionar Cargo", JOptionPane.WARNING_MESSAGE);
			      
			      if(novo_cargo != null && novo_cargo.trim().isEmpty() == false) {
			    	  boolean achou = false;
			    	  
			    	  for (int i = 0; i < tela.getComboBoxCargo().getItemCount(); i++) {
			    		  if (novo_cargo.equals(tela.getComboBoxCargo().getItemAt(i).toString())) {
			    			  achou = true;
			    			  break;
			    		  }
			    	  }
			    	  
			    	  if(achou == false) {
			    		  tela.getComboBoxCargo().addItem(novo_cargo);
			    		  tela.getComboBoxCargo().setSelectedItem(novo_cargo);
			    	  }
			    	  else {
			    		  JOptionPane.showMessageDialog(null, "Esse cargo já existe!", "Info", JOptionPane.INFORMATION_MESSAGE);
			    	  }
			      }
			}
		});
	}

	private void getSelecionarUmFuncionarioTabelaTyped() {
		tela.getTelaPesquisa().getJTableDados().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(tela.getLabelCadastroDeFuncionrio().getText().contains(" Cadastro de Funcionário - Incluir")) {
						if(tela.getLabelCadastroDeFuncionrio().getText().equals(" Cadastro de Funcionário - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o funcionário selecionado o procedimento de inclusão é descartado, deseja cancelar?", "Cancelar",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
									null, options, options[0]);
							
							if(opcao == 1) {
								funcionario_exibicao = new ModeloFuncionario();
								int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
								funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
								atribuicao_busca_campos(funcionario_exibicao);
							}
						}
						else {
							funcionario_exibicao = new ModeloFuncionario();
							int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
							funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
							atribuicao_busca_campos(funcionario_exibicao);
						}
					}
					else if(tela.getLabelCadastroDeFuncionrio().getText().contains(" Cadastro de Funcionário - Alterar")) {
						if(tela.getLabelCadastroDeFuncionrio().getText().equals(" Cadastro de Funcionário - Alterar")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o funcionário selecionado o procedimento de alteração é descartado, deseja cancelar?", "Cancelar",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
									null, options, options[0]);
							
							if(opcao == 1) {
								funcionario_exibicao = new ModeloFuncionario();
								int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
								funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
								atribuicao_busca_campos(funcionario_exibicao);
							}
						}
						else {
							funcionario_exibicao = new ModeloFuncionario();
							int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
							funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
							atribuicao_busca_campos(funcionario_exibicao);
						}
					}
					else {
						funcionario_exibicao = new ModeloFuncionario();
						int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
						funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
						atribuicao_busca_campos(funcionario_exibicao);
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					if(tela.getLabelCadastroDeFuncionrio().getText().contains(" Cadastro de Funcionário - Incluir")) {
						if(tela.getLabelCadastroDeFuncionrio().getText().equals(" Cadastro de Funcionário - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o funcionário selecionado o procedimento de inclusão é descartado, deseja cancelar?", "Cancelar",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
									null, options, options[0]);
							
							if(opcao == 1) {
								funcionario_exibicao = new ModeloFuncionario();
								int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
								funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
								atribuicao_busca_campos(funcionario_exibicao);
							}
						}
						else {
							funcionario_exibicao = new ModeloFuncionario();
							int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
							funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
							atribuicao_busca_campos(funcionario_exibicao);
						}
					}
					else if(tela.getLabelCadastroDeFuncionrio().getText().contains(" Cadastro de Funcionário - Alterar")) {
						if(tela.getLabelCadastroDeFuncionrio().getText().equals(" Cadastro de Funcionário - Alterar")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o funcionário selecionado o procedimento de alteração é descartado, deseja cancelar?", "Cancelar",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
									null, options, options[0]);
							
							if(opcao == 1) {
								funcionario_exibicao = new ModeloFuncionario();
								int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
								funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
								atribuicao_busca_campos(funcionario_exibicao);
							}
						}
						else {
							funcionario_exibicao = new ModeloFuncionario();
							int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
							funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
							atribuicao_busca_campos(funcionario_exibicao);
						}
					}
					else {
						funcionario_exibicao = new ModeloFuncionario();
						int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
						funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
						atribuicao_busca_campos(funcionario_exibicao);
					}
				}
				else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					if(tela.getLabelCadastroDeFuncionrio().getText().contains(" Cadastro de Funcionário - Incluir")) {
						if(tela.getLabelCadastroDeFuncionrio().getText().equals(" Cadastro de Funcionário - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o funcionário selecionado o procedimento de inclusão é descartado, deseja cancelar?", "Cancelar",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
									null, options, options[0]);
							
							if(opcao == 1) {
								funcionario_exibicao = new ModeloFuncionario();
								int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
								funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
								atribuicao_busca_campos(funcionario_exibicao);
							}
						}
						else {
							funcionario_exibicao = new ModeloFuncionario();
							int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
							funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
							atribuicao_busca_campos(funcionario_exibicao);
						}
					}
					else if(tela.getLabelCadastroDeFuncionrio().getText().contains(" Cadastro de Funcionário - Alterar")) {
						if(tela.getLabelCadastroDeFuncionrio().getText().equals(" Cadastro de Funcionário - Alterar")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o funcionário selecionado o procedimento de alteração é descartado, deseja cancelar?", "Cancelar",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
									null, options, options[0]);
							
							if(opcao == 1) {
								funcionario_exibicao = new ModeloFuncionario();
								int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
								funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
								atribuicao_busca_campos(funcionario_exibicao);
							}
						}
						else {
							funcionario_exibicao = new ModeloFuncionario();
							int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
							funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
							atribuicao_busca_campos(funcionario_exibicao);
						}						
					}
					else {
						funcionario_exibicao = new ModeloFuncionario();
						int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
						funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
						atribuicao_busca_campos(funcionario_exibicao);
					}
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
	}

	private void getSelecionarUmFuncionarioTabela() {
		tela.getTelaPesquisa().getJTableDados().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {//ESSE
				if(e.getClickCount() == 1) {
					if(tela.getLabelCadastroDeFuncionrio().getText().contains(" Cadastro de Funcionário - Incluir")) {
						if(tela.getLabelCadastroDeFuncionrio().getText().equals(" Cadastro de Funcionário - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Fechar",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
									null, options, options[0]);
							
							if(opcao == 1) {
								tela.getLabelCadastroDeFuncionrio().setText(" Cadastro de Funcionário");
								funcionario_exibicao = new ModeloFuncionario();
								int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
								funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
								atribuicao_busca_campos(funcionario_exibicao);
							}
						}
						else {
							funcionario_exibicao = new ModeloFuncionario();
							int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
							funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
							atribuicao_busca_campos(funcionario_exibicao);
						}						
					}
					else if(tela.getLabelCadastroDeFuncionrio().getText().contains(" Cadastro de Funcionário")) {
						if(tela.getLabelCadastroDeFuncionrio().getText().equals(" Cadastro de Funcionário - Alterar")) {
						Object[] options = { "NÃO", "SIM" };
					      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de alteração é descartado, deseja cancelar?", "Fechar",
					          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					              null, options, options[0]);
					      
					      if(opcao == 1) {
					    	  tela.getLabelCadastroDeFuncionrio().setText(" Cadastro de Funcionário");
					    	  funcionario_exibicao = new ModeloFuncionario();
					    	  int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
					    	  funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
					    	  atribuicao_busca_campos(funcionario_exibicao);
					      }
						}
						else {
							funcionario_exibicao = new ModeloFuncionario();
							int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
							funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
							atribuicao_busca_campos(funcionario_exibicao);
						}
					}
					else {
						funcionario_exibicao = new ModeloFuncionario();
						int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
						funcionario_exibicao = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);					
						atribuicao_busca_campos(funcionario_exibicao);
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
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
	}

	private void getBotaoFecharAction() {
		tela.getTelaPesquisa().getButtonFechar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				framePrincipal.dispose();				
			}
		});
	}

	private void getBotaoConfirmarAction() {
		tela.getTelaPesquisa().getButtonConfirmar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tela.getLabelCadastroDeFuncionrio().getText().equals(" Cadastro de Funcionário - Alterar")) {
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Confirma a alteração dos dados do funcionário tratado?", "Confirmar",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  capturar_campos();
				    	  if(validacao("Alterar")==true) {
				    		  limpar_campos();
				    		  campos_bool(false);
				    		  buttons_inc_alt();
				    		  tela.get_busca_table_model(true).fireTableDataChanged();
				    		  tela.repaint();
				    		  tela.validate();
				    		  //tela.getTelaPesquisa().getJTableDados().setModel(tela.get_busca_table_model(false));
				    	  }
				      }
				}
				else if (tela.getLabelCadastroDeFuncionrio().getText().equals(" Cadastro de Funcionário - Incluir")) {
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Confirma a inclusão dos dados do funcionário tratado?", "Confirmar",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  capturar_campos();
				    	  if(validacao("Incluir")==true) {
				    		  limpar_campos();
				    		  buttons_inicial();
				    	  }
				      }
				}
			}


		});
	}
	
	private void atribuicao_busca_campos(ModeloFuncionario funcionario_exibicao) {
		tela.getValidacaoJTextFieldNome().setText(funcionario_exibicao.getNome());
		tela.getFormattedTextFieldCPF().setText(funcionario_exibicao.getCpf());
		tela.getValidacaoJTextFieldRG().setText(funcionario_exibicao.getRg());
		tela.getComboBoxEstadoRG().setSelectedItem(funcionario_exibicao.getUfRg());
		tela.getValidacaoJTextFieldOrgaoExpeditor().setText(funcionario_exibicao.getOrgaoExpeditor());
		tela.getValidacaoJTextFieldNacionalidade().setText(funcionario_exibicao.getNacionalidade());
		tela.getValidacaoJTextFieldNaturalidade().setText(funcionario_exibicao.getNaturalidade());
		tela.getFormattedTextFieldDataNascimento().setText(funcionario_exibicao.getDataDeNascimento());
		tela.getComboBoxSexo().setSelectedItem(funcionario_exibicao.getSexo());
		tela.getFormattedTextFieldTelefone().setText(funcionario_exibicao.getTelefone());
		tela.getValidacaoTextFieldEmail().setText(funcionario_exibicao.getEmail());
		tela.getTextFieldCtps().setText(funcionario_exibicao.getCtps());
		tela.getFormattedTextFieldDataAdmissao().setText(funcionario_exibicao.getDataDeAdmissao());
		tela.getComboBoxCargo().setSelectedItem(funcionario_exibicao.getCargo());
		tela.getValidacaoTextFieldSetor().setText(funcionario_exibicao.getSetor());
		tela.getValidacaoTextFieldSalario().setText(String.valueOf(funcionario_exibicao.getSalario()));
		tela.getTextFieldNomeUsuario().setText(funcionario_exibicao.getNomeDeUsuario());
		tela.getPasswordFieldSenhaUsuario().setText(funcionario_exibicao.getSenha());
		tela.getFormattedTextFieldCEP().setText(funcionario_exibicao.getCep());
		tela.getValidacaoJTextFieldLogradouro().setText(funcionario_exibicao.getLogradouro());
		tela.getValidacaoJTextFieldComplemento().setText(funcionario_exibicao.getComplemento());
		tela.getValidacaoJTextFieldNumero().setText(funcionario_exibicao.getNumeroEndereco());
		tela.getValidacaoJTextFieldBairro().setText(funcionario_exibicao.getBairro());
		tela.getValidacaoJTextFieldCidade().setText(funcionario_exibicao.getCidade());
		tela.getComboBoxEstadoEndereco().setSelectedItem(funcionario_exibicao.getUf_estado());
	}
	
	private boolean validacao(String string) {
		ValidacaoFuncionario funcionario;
		
		if(string.equals("Alterar")) {
			DadosFuncionario funcionario_salvo = new DadosFuncionario();
			String id_end;
			
			int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();
			
			funcionario_antigo = new ModeloFuncionario();
			funcionario_antigo = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);
			
			funcionario = new ValidacaoFuncionario(funcionario_atual);
			id_end = banco .consultar("funcionario", "cpf" , funcionario_atual.getCpf(), "ENDERECO_id");
			
			if(funcionario.isResultadoValidacaoTodosCamposGeral() == true) {					
				
				funcionario_salvo.bancoDeDadosAlterar(funcionario_atual, funcionario_antigo.getCpf(), id_end, funcionario_atual.getCargo().getNomeCargo());
				
				return true;
			}			
					
		}
		
		else if(string.equals("Incluir")) {
			DadosFuncionario funcionario_salvo = new DadosFuncionario();
			
			funcionario = new ValidacaoFuncionario(funcionario_atual);
			funcionario.validarCPF();
			
			if(funcionario.isResultadoValidacaoTodosCamposGeral() == true && funcionario.isResultadoValidacaoCpf() == true) {
				
				funcionario_salvo.bancoDeDadosIncluir(funcionario_atual);
				
				return true;
			}
		}
		
		
		return false;
	}

	private void capturar_campos() {
		funcionario_atual = new ModeloFuncionario();
		
		//DADOS PESSOAIS
		funcionario_atual.setNome(tela.getValidacaoJTextFieldNome().getText());
		funcionario_atual.setCpf(tela.getFormattedTextFieldCPF().getText());
		funcionario_atual.setRg(tela.getValidacaoJTextFieldRG().getText());
		funcionario_atual.setUfRg(tela.getComboBoxEstadoRG().getSelectedItem().toString());
		funcionario_atual.setOrgaoExpeditor(tela.getValidacaoJTextFieldOrgaoExpeditor().getText());
		funcionario_atual.setNacionalidade(tela.getValidacaoJTextFieldNacionalidade().getText());
		funcionario_atual.setNaturalidade(tela.getValidacaoJTextFieldNaturalidade().getText());
		funcionario_atual.setDataDeNascimento(tela.getFormattedTextFieldDataNascimento().getText());
		funcionario_atual.setSexo(tela.getComboBoxSexo().getSelectedItem().toString());
		funcionario_atual.setTelefone(tela.getFormattedTextFieldTelefone().getText());
		funcionario_atual.setEmail(tela.getValidacaoTextFieldEmail().getText());
		
		//DADOS DO CARGO
		funcionario_atual.setCtps(tela.getTextFieldCtps().getText());
		funcionario_atual.setDataDeAdmissao(tela.getFormattedTextFieldDataAdmissao().getText());
		funcionario_atual.getCargo().setNomeCargo((tela.getComboBoxCargo().getSelectedItem().toString()));
		funcionario_atual.setSetor(tela.getValidacaoTextFieldSetor().getText());
		
		try {
			funcionario_atual.setSalario(Double.parseDouble(tela.getValidacaoTextFieldSalario().getText()));			
		} catch (NumberFormatException e) {
			funcionario_atual.setSalario(-1);
		}
		
		funcionario_atual.setNomeDeUsuario(tela.getTextFieldNomeUsuario().getText());
		funcionario_atual.setSenha(tela.getPasswordFieldSenhaUsuario().getText());
		
		
		//ENDEREÇO
		funcionario_atual.setCep(tela.getFormattedTextFieldCEP().getText());
		funcionario_atual.setLogradouro(tela.getValidacaoJTextFieldLogradouro().getText());
		funcionario_atual.setComplemento(tela.getValidacaoJTextFieldComplemento().getText());
		funcionario_atual.setNumeroEndereco(tela.getValidacaoJTextFieldNumero().getText());
		funcionario_atual.setBairro(tela.getValidacaoJTextFieldBairro().getText());
		funcionario_atual.setCidade(tela.getValidacaoJTextFieldCidade().getText());
		funcionario_atual.setUf_estado(tela.getComboBoxEstadoEndereco().getSelectedItem().toString());
		
	}
	
	private void getBotaoExcluirAction() {
		tela.getTelaPesquisa().getButtonExcluir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tela.getTelaPesquisa().getJTableDados().getSelectedRow() != -1) {					
					int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
					ModeloFuncionario funcionario = tela.get_busca_table_model(true).getFuncionario(linhaSelecionada);
					
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Deseja excluir o funcionário de nome: '" + funcionario.getNome() +"' ?", "Exclusão",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  tela.get_busca_table_model(true).remover_tabela(linhaSelecionada);
				    	  String cpf = funcionario.getCpf();
				    	  String id = banco.consultar("cliente", "cpf" , cpf, "ENDERECO_id");;
				    	  
				    	  if(new DadosClientePessoaFisica().bancoDeDadosExcluir(cpf, id) == true) {
				    		  limpar_campos();
				    		  campos_bool(false);
				    	  }				    	  
				      }										
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecione um funcionário da lista exibida pela busca!"
							  , "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}

	private void getBotaoCancelarAction() {
		tela.getTelaPesquisa().getButtonCancelar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tela.getLabelCadastroDeFuncionrio().getText().equals(" Cadastro de Funcionário - Alterar")) {
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar a alteração atual?", "Cancelamento",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  campos_bool(false);
				    	  buttons_busca();
				    	  limpar_campos();
				      }
				}
				else if (tela.getLabelCadastroDeFuncionrio().getText().equals(" Cadastro de Funcionário - Incluir")) {
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar a inclusão atual?", "Cancelamento",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  campos_bool(false);
				    	  buttons_inicial();
				    	  limpar_campos();
				      }
				}
				else {
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar a busca atual?", "Cancelamento",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  campos_bool(false);
				    	  buttons_inicial();
				    	  limpar_campos();
				    	  tela.getTelaPesquisa().getJTableDados().setModel(tela.get_busca_table_model(false));				    	  
				      }
				}
			}
		});
	}

	private void getBotaoAlterarAction() {
		tela.getTelaPesquisa().getButtonAlterar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();
				if (tela.getTelaPesquisa().getJTableDados().getSelectedRow() != -1) {
					tela.getLabelCadastroDeFuncionrio().setText(" Cadastro de Funcionário - Alterar");
					atribuicao_busca_campos(tela.get_busca_table_model(true).getFuncionario(linhaSelecionada));
					campos_bool(true);
					buttons_inc_alt();					
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecione um funcionário da lista exibida pela busca!"
							, "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}

	private void getBotaoIncluirAction() {
		tela.getTelaPesquisa().getButtonIncluir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.getLabelCadastroDeFuncionrio().setText(" Cadastro de Funcionário - Incluir");
				campos_bool(true);
				buttons_inc_alt();
			}
		});
	}	
	
	private void getBotaoBuscarAction() {
		tela.getTelaPesquisa().getButtonBuscar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String tipo_b, val_b;
				
				tipo_b = tela.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString();
				val_b = tela.getTelaPesquisa().getTextFieldEntradaDado().getText();
				
				if(!val_b.trim().equals("") && !tipo_b.equals("Selecione")) {
					if (busca(tipo_b, val_b) == true) {
						buttons_busca();						
					};
				}
				else {
					JOptionPane.showMessageDialog(null, "Preencha o campo de busca e escolha um tipo de busca!"
							  , "Selecione", JOptionPane.INFORMATION_MESSAGE);
				}
			}


		});
	}
	
	private boolean busca(String tipo_b, String val_b) {
		if(tipo_b.equals("Nome")) {
			DadosFuncionario funcionario_banco = new DadosFuncionario();
			tela.getTelaPesquisa().getJTableDados().setModel(tela.get_busca_table_model(false));//seta uma nova tabela, só pra exibição dos resultados da busca
			
			ModeloFuncionario funcionario = new ModeloFuncionario();
			
			for (int i = 0; i < funcionario_banco.getFuncionarios().size(); i++) {
				if(funcionario_banco.getFuncionarios().get(i).getNome().contains(val_b)) {
					for (int j = 0; j < banco.consultarEndereco().size(); j++) {
						if (banco.consultarEndereco().get(j).getId_endereco() == banco.consultarClienteFisico().get(i).getId_endereco()) {
							funcionario = funcionario_banco.getFuncionarios().get(i);
							funcionario.setBairro(banco.consultarEndereco().get(j).getBairro());
							funcionario.setCep(banco.consultarEndereco().get(j).getCep());
							funcionario.setLogradouro(banco.consultarEndereco().get(j).getLogradouro());
							funcionario.setNumeroEndereco(banco.consultarEndereco().get(j).getNumeroEndereco());
							funcionario.setComplemento(banco.consultarEndereco().get(j).getComplemento());
							funcionario.setCidade(banco.consultarEndereco().get(j).getCidade());
							funcionario.setUf_estado(banco.consultarEndereco().get(j).getUf_estado());
							tela.get_busca_table_model(true).add_tabela(funcionario);
						}
					}
				}				
			}
			if(tela.get_busca_table_model(true).getRowCount() == 0) {
				JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum cliente encontrado."
						  , "Busca", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		}
		else if(tipo_b.equals("CPF")) {
			DadosFuncionario funcionario_banco = new DadosFuncionario();
			tela.getTelaPesquisa().getJTableDados().setModel(tela.get_busca_table_model(false));//seta uma nova tabela, só pra exibição dos resultados da busca
			
			ModeloFuncionario funcionario = new ModeloFuncionario();
			
			for (int i = 0; i < funcionario_banco.getFuncionarios().size(); i++) {
				if(funcionario_banco.getFuncionarios().get(i).getCpf().contains(val_b)) {
					for (int j = 0; j < banco.consultarEndereco().size(); j++) {
						if (banco.consultarEndereco().get(j).getId_endereco() == banco.consultarClienteFisico().get(i).getId_endereco()) {
							funcionario = funcionario_banco.getFuncionarios().get(i);
							funcionario.setBairro(banco.consultarEndereco().get(j).getBairro());
							funcionario.setCep(banco.consultarEndereco().get(j).getCep());
							funcionario.setLogradouro(banco.consultarEndereco().get(j).getLogradouro());
							funcionario.setNumeroEndereco(banco.consultarEndereco().get(j).getNumeroEndereco());
							funcionario.setComplemento(banco.consultarEndereco().get(j).getComplemento());
							funcionario.setCidade(banco.consultarEndereco().get(j).getCidade());
							funcionario.setUf_estado(banco.consultarEndereco().get(j).getUf_estado());
							tela.get_busca_table_model(true).add_tabela(funcionario);
						}
					}
				}				
			}	
			if(tela.get_busca_table_model(true).getRowCount() == 0) {
				JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum cliente encontrado."
						  , "Busca", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		}	
		
		return true;
	}
	
	private void buttons_busca() {
		tela.getTelaPesquisa().getButtonExcluir().setEnabled(true);
		tela.getTelaPesquisa().getButtonAlterar().setEnabled(true);
		tela.getTelaPesquisa().getButtonCancelar().setEnabled(true);
		tela.getTelaPesquisa().getButtonConfirmar().setEnabled(!true);
		tela.getTelaPesquisa().getButtonIncluir().setEnabled(!true);
	}
}
