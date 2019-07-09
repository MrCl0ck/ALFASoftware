package controle.cadastros.produto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.w3c.dom.css.RGBColor;

import dao.Banco;
import modelo.cadastros.dados.DadosClientePessoaFisica;
import modelo.cadastros.dados.DadosProduto;
import modelo.cadastros.produto.ModeloProduto;
import modelo.cadastros.validacoes.ValidacaoProduto;
import visao.cadastros.cliente.VisaoFramePrincipal;
import visao.cadastros.produto.VisaoTelaCadastroProduto;

public class ControladorProduto {
	private VisaoFramePrincipal framePrincipal;
	private VisaoTelaCadastroProduto tela;
	private ModeloProduto produto_atual;
	private ModeloProduto produto_antigo;
	private ModeloProduto Produto_exibicao;
	
	private Banco banco = new Banco();

	public ControladorProduto(VisaoFramePrincipal frame) {
		framePrincipal = frame;
		inicializaTela();
		buttons_inicial();
		add_eventos();
		campos_bool(false);
	}

	private void campos_bool(boolean b) {
		tela.getTextFieldCodigo().setEnabled(b);
		tela.getTextFieldCodigoBarras().setEnabled(b);
		tela.getTextFieldDescricao().setEnabled(b);
		tela.getTextFieldValorCompra().setEnabled(b);
		tela.getTextFieldValorVenda().setEnabled(b);
		tela.getTextFieldLucro().setEnabled(b);
		
		tela.getComboBoxUnidade().setEnabled(b);
		tela.getButtonAdicionarUnidade().setEnabled(b);
		tela.getButtonRemoverUnidade().setEnabled(b);
		tela.getButtonAlterarUnidade().setEnabled(b);
		
		tela.getComboBoxTipo().setEnabled(b);
		tela.getButtonAdicionarTipo().setEnabled(b);
		tela.getButtonRemoverTipo().setEnabled(b);
		tela.getButtonAlterarTipo().setEnabled(b);
		
		tela.getTextFieldEstoqueMinimo().setEnabled(b);
		tela.getTextFieldEstoqueMaximo().setEnabled(b);
	}

	private void add_eventos() {
		getBotaoBuscarAction();
		getBotaoIncluirAction();
		getBotaoExcluirAction();
		getBotaoAlterarAction();
		getBotaoCancelarAction();
		getBotaoConfirmarAction();
		getBotaoFecharAction();
		getSelecionarUmProdutoTabela();
		getSelecionarUmProdutoTabelaTyped();
		getMaisUnidade();
		getMenosUnidade();
		getAlterarUnidade();
		getMaisTipo();
		getMenosTipo();
		getAlterarTipo();
		getLucroTip();
		getVendaTip();		
	}

	private void getVendaTip() {
		tela.getTextFieldValorVenda().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {				
							
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				double resultado = venda_to_lucro();
				if (resultado<0) {
					tela.getTextFieldLucro().setForeground(Color.RED);
				}
				else {
					tela.getTextFieldLucro().setForeground(Color.GREEN);
				}
				tela.getTextFieldLucro().setText(String.valueOf(resultado));	
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
	}

	private void getLucroTip() {
		tela.getTextFieldLucro().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
								
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				double resultado = lucro_to_venda();
				if (resultado<0) {
					tela.getTextFieldLucro().setForeground(Color.RED);
				}
				else {
					tela.getTextFieldLucro().setForeground(Color.GREEN);
				}
				tela.getTextFieldValorVenda().setText(String.valueOf(resultado));
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
	}

	private void getAlterarTipo() {
		tela.getButtonAlterarTipo().addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tipo_antigo = tela.getComboBoxTipo().getSelectedItem().toString();
				String novo_tipo = JOptionPane.showInputDialog(null, "Insira o novo nome do tipo: ", "Alterar Tipo", JOptionPane.WARNING_MESSAGE);
				
				if(novo_tipo != null && novo_tipo.trim().isEmpty() == false && novo_tipo != tipo_antigo && !tipo_antigo.equals("Selecione")
						&& !novo_tipo.equals("Selecione")) {	    	  
					
					if(banco.atualizar("tipo", "nome", tipo_antigo,"nome='" + novo_tipo +  "'") == true) {
						tela.getComboBoxTipo().removeItem(tipo_antigo);
						tela.getComboBoxTipo().addItem(novo_tipo);
						tela.getComboBoxTipo().setSelectedItem(novo_tipo);
					}
					else {
						System.out.println("Erro ao atualizar tipo...");
					}			    	  
				}
				else {
					JOptionPane.showMessageDialog(null, "Preencha o campo corretamente!", "Info", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
	}

	private void getMenosTipo() {
		tela.getButtonRemoverTipo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		}); 
		
	}

	private void getMaisTipo() {
		tela.getButtonAdicionarTipo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String novo_tipo = JOptionPane.showInputDialog(null, "Insira o nome do novo tipo: ", "Adicionar Tipo", JOptionPane.WARNING_MESSAGE);
				
				if(novo_tipo != null && novo_tipo.trim().isEmpty() == false && !novo_tipo.equals("Selecione")) {
					boolean achou = false;
					
					for (int i = 0; i < tela.getComboBoxTipo().getItemCount(); i++) {
						if (novo_tipo.equals(tela.getComboBoxTipo().getItemAt(i).toString())) {
							achou = true;
							break;
						}
					}
					
					if(achou == false) {
						tela.getComboBoxTipo().addItem(novo_tipo);
						tela.getComboBoxTipo().setSelectedItem(novo_tipo);
					}
					else {
						JOptionPane.showMessageDialog(null, "Esse tipo já existe!", "Info", JOptionPane.INFORMATION_MESSAGE);
					}
				}		
				
			}
		});
	}

	private void getAlterarUnidade() {
		tela.getButtonAlterarUnidade().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String unidade_antigo = tela.getComboBoxUnidade().getSelectedItem().toString();
				String novo_unidade = JOptionPane.showInputDialog(null, "Insira o novo nome do unidade: ", "Alterar Unidade", JOptionPane.WARNING_MESSAGE);
				
				if(novo_unidade != null && novo_unidade.trim().isEmpty() == false && novo_unidade != unidade_antigo && !unidade_antigo.equals("Selecione")
						&& !novo_unidade.equals("Selecione")) {
					
					
					if(banco.atualizar("unidade", "nome", unidade_antigo,"nome='" + novo_unidade +  "'") == true) {
						tela.getComboBoxUnidade().removeItem(unidade_antigo);
						tela.getComboBoxUnidade().addItem(novo_unidade);
						tela.getComboBoxUnidade().setSelectedItem(novo_unidade);
					}
					else {
						System.out.println("Erro ao atualizar unidade...");
					}			    	  
				}
				else {
					JOptionPane.showMessageDialog(null, "Preencha o campo corretamente!", "Info", JOptionPane.INFORMATION_MESSAGE);
				}			
			}
		});
	}

	private void getMenosUnidade() {
		tela.getButtonRemoverUnidade().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	private void getMaisUnidade() {
		tela.getButtonAdicionarUnidade().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String novo_unidade = JOptionPane.showInputDialog(null, "Insira o nome do novo unidade: ", "Adicionar Unidade", JOptionPane.WARNING_MESSAGE);
				
				if(novo_unidade != null && novo_unidade.trim().isEmpty() == false && !novo_unidade.equals("Selecione")) {
					boolean achou = false;
					
					for (int i = 0; i < tela.getComboBoxUnidade().getItemCount(); i++) {
						if (novo_unidade.equals(tela.getComboBoxUnidade().getItemAt(i).toString())) {
							achou = true;
							break;
						}
					}
					
					if(achou == false) {
						tela.getComboBoxUnidade().addItem(novo_unidade);
						tela.getComboBoxUnidade().setSelectedItem(novo_unidade);
					}
					else {
						JOptionPane.showMessageDialog(null, "Esse unidade já existe!", "Info", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		
	}

	private void getSelecionarUmProdutoTabelaTyped() {
		tela.getTelaPesquisa().getJTableDados().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(tela.getLabelCadastroDeProduto().getText().contains(" Cadastro de Produto - Incluir")) {
						if(tela.getLabelCadastroDeProduto().getText().equals(" Cadastro de Produto - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o Produto selecionado o procedimento de inclusão é descartado, deseja cancelar?", "Cancelar",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
									null, options, options[0]);
							
							if(opcao == 1) {
								Produto_exibicao = new ModeloProduto();
								int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
								Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
								atribuicao_busca_campos(Produto_exibicao);
							}
						}
						else {
							Produto_exibicao = new ModeloProduto();
							int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
							Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
							atribuicao_busca_campos(Produto_exibicao);
						}
					}
					else if(tela.getLabelCadastroDeProduto().getText().contains(" Cadastro de Produto - Alterar")) {
						if(tela.getLabelCadastroDeProduto().getText().equals(" Cadastro de Produto - Alterar")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o Produto selecionado o procedimento de alteração é descartado, deseja cancelar?", "Cancelar",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
									null, options, options[0]);
							
							if(opcao == 1) {
								Produto_exibicao = new ModeloProduto();
								int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
								Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
								atribuicao_busca_campos(Produto_exibicao);
							}
						}
						else {
							Produto_exibicao = new ModeloProduto();
							int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
							Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
							atribuicao_busca_campos(Produto_exibicao);
						}
					}
					else {
						Produto_exibicao = new ModeloProduto();
						int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
						Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
						atribuicao_busca_campos(Produto_exibicao);
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					if(tela.getLabelCadastroDeProduto().getText().contains(" Cadastro de Produto - Incluir")) {
						if(tela.getLabelCadastroDeProduto().getText().equals(" Cadastro de Produto - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o Produto selecionado o procedimento de inclusão é descartado, deseja cancelar?", "Cancelar",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
									null, options, options[0]);
							
							if(opcao == 1) {
								Produto_exibicao = new ModeloProduto();
								int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
								Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
								atribuicao_busca_campos(Produto_exibicao);
							}
						}
						else {
							Produto_exibicao = new ModeloProduto();
							int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
							Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
							atribuicao_busca_campos(Produto_exibicao);
						}
					}
					else if(tela.getLabelCadastroDeProduto().getText().contains(" Cadastro de Produto - Alterar")) {
						if(tela.getLabelCadastroDeProduto().getText().equals(" Cadastro de Produto - Alterar")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o Produto selecionado o procedimento de alteração é descartado, deseja cancelar?", "Cancelar",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
									null, options, options[0]);
							
							if(opcao == 1) {
								Produto_exibicao = new ModeloProduto();
								int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
								Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
								atribuicao_busca_campos(Produto_exibicao);
							}
						}
						else {
							Produto_exibicao = new ModeloProduto();
							int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
							Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
							atribuicao_busca_campos(Produto_exibicao);
						}
					}
					else {
						Produto_exibicao = new ModeloProduto();
						int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
						Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
						atribuicao_busca_campos(Produto_exibicao);
					}
				}
				else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					if(tela.getLabelCadastroDeProduto().getText().contains(" Cadastro de Produto - Incluir")) {
						if(tela.getLabelCadastroDeProduto().getText().equals(" Cadastro de Produto - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o Produto selecionado o procedimento de inclusão é descartado, deseja cancelar?", "Cancelar",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
									null, options, options[0]);
							
							if(opcao == 1) {
								Produto_exibicao = new ModeloProduto();
								int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
								Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
								atribuicao_busca_campos(Produto_exibicao);
							}
						}
						else {
							Produto_exibicao = new ModeloProduto();
							int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
							Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
							atribuicao_busca_campos(Produto_exibicao);
						}
					}
					else if(tela.getLabelCadastroDeProduto().getText().contains(" Cadastro de Produto - Alterar")) {
						if(tela.getLabelCadastroDeProduto().getText().equals(" Cadastro de Produto - Alterar")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o Produto selecionado o procedimento de alteração é descartado, deseja cancelar?", "Cancelar",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
									null, options, options[0]);
							
							if(opcao == 1) {
								Produto_exibicao = new ModeloProduto();
								int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
								Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
								atribuicao_busca_campos(Produto_exibicao);
							}
						}
						else {
							Produto_exibicao = new ModeloProduto();
							int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
							Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
							atribuicao_busca_campos(Produto_exibicao);
						}						
					}
					else {
						Produto_exibicao = new ModeloProduto();
						int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
						Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
						atribuicao_busca_campos(Produto_exibicao);
					}
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
	}

	private void getSelecionarUmProdutoTabela() {
		tela.getTelaPesquisa().getJTableDados().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {//ESSE
				if(e.getClickCount() == 1) {
					if(tela.getLabelCadastroDeProduto().getText().contains(" Cadastro de Produto - Incluir")) {
						if(tela.getLabelCadastroDeProduto().getText().equals(" Cadastro de Produto - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de inclusão é cancelado, deseja cancelar?", "Fechar",
									JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
									null, options, options[0]);
							
							if(opcao == 1) {
								tela.getLabelCadastroDeProduto().setText(" Cadastro de Produto");
								Produto_exibicao = new ModeloProduto();
								int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
								Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
								atribuicao_busca_campos(Produto_exibicao);
							}
						}
						else {
							Produto_exibicao = new ModeloProduto();
							int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
							Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
							atribuicao_busca_campos(Produto_exibicao);
						}						
					}
					else if(tela.getLabelCadastroDeProduto().getText().contains(" Cadastro de Produto")) {
						if(tela.getLabelCadastroDeProduto().getText().equals(" Cadastro de Produto - Alterar")) {
						Object[] options = { "NÃO", "SIM" };
					      int opcao = JOptionPane.showOptionDialog(null, "Ao exibir o cliente selecionado o procedimento de alteração é descartado, deseja cancelar?", "Fechar",
					          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					              null, options, options[0]);
					      
					      if(opcao == 1) {
					    	  tela.getLabelCadastroDeProduto().setText(" Cadastro de Produto");
					    	  Produto_exibicao = new ModeloProduto();
					    	  int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
					    	  Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
					    	  atribuicao_busca_campos(Produto_exibicao);
					      }
						}
						else {
							Produto_exibicao = new ModeloProduto();
							int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
							Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
							atribuicao_busca_campos(Produto_exibicao);
						}
					}
					else {
						Produto_exibicao = new ModeloProduto();
						int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
						Produto_exibicao = tela.get_busca_table_model(true).getProduto(linhaSelecionada);					
						atribuicao_busca_campos(Produto_exibicao);
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
				if(tela.getLabelCadastroDeProduto().getText().equals(" Cadastro de Produto - Alterar")) {
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Confirma a alteração dos dados do Produto tratado?", "Confirmar",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  capturar_campos();
				    	  if(validacao("Alterar")==true) {
				    		  limpar_campos();
				    		  campos_bool(false);
				    		  buttons_inc_alt();				    		  
				    		  tela.getTelaPesquisa().getJTableDados().setModel(tela.get_busca_table_model(false));
				    	  }
				      }
				}
				else if (tela.getLabelCadastroDeProduto().getText().equals(" Cadastro de Produto - Incluir")) {
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Confirma a inclusão dos dados do Produto tratado?", "Confirmar",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  capturar_campos();
				    	  if(validacao("Incluir")==true) {
				    		  limpar_campos();
				    		  campos_bool(false);
				    		  buttons_inicial();
				    	  }
				      }
				}
			}


		});
	}
	
	private void getBotaoExcluirAction() {
		tela.getTelaPesquisa().getButtonExcluir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tela.getTelaPesquisa().getJTableDados().getSelectedRow() != -1) {					
					int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();					
					ModeloProduto Produto = tela.get_busca_table_model(true).getProduto(linhaSelecionada);
					
					Object[] options = { "NÃO", "SIM" };
				      int opcao = JOptionPane.showOptionDialog(null, "Deseja excluir o Produto de nome: '" + Produto.getDescricao() +"' ?", "Exclusão",
				          JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				              null, options, options[0]);
				      
				      if(opcao == 1) {
				    	  tela.get_busca_table_model(true).remover_tabela(linhaSelecionada);
				    	  String codigo = Produto.getCodigo();
				    	  String id = banco.consultar("produto", "codigo" , codigo, "ENDERECO_id");////skenaskenasease
				    	  
				    	  if(new DadosClientePessoaFisica().bancoDeDadosExcluir(codigo, id) == true) {
				    		  limpar_campos();
				    		  campos_bool(false);
				    	  }				    	  
				      }										
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecione um Produto da lista exibida pela busca!"
							  , "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}

	private void getBotaoCancelarAction() {
		tela.getTelaPesquisa().getButtonCancelar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tela.getLabelCadastroDeProduto().getText().equals(" Cadastro de Produto - Alterar")) {
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
				else if (tela.getLabelCadastroDeProduto().getText().equals(" Cadastro de Produto - Incluir")) {
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
					tela.getLabelCadastroDeProduto().setText(" Cadastro de Produto - Alterar");
					
					produto_antigo = new ModeloProduto();
					produto_antigo = tela.get_busca_table_model(true).getProduto(linhaSelecionada);
					
					atribuicao_busca_campos(produto_antigo);
					campos_bool(true);
					buttons_inc_alt();					
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecione um Produto da lista exibida pela busca!"
							, "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}

	private void getBotaoIncluirAction() {
		tela.getTelaPesquisa().getButtonIncluir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.getLabelCadastroDeProduto().setText(" Cadastro de Produto - Incluir");
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

	private void inicializaTela() {
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
	
	public VisaoTelaCadastroProduto getTela() {
		if(tela==null) {
			tela = new VisaoTelaCadastroProduto();
		}
		return tela;
	}
	
	
	private void limpar_campos() {
		tela.getLabelCadastroDeProduto().setText(" Cadastro de Produto");
		tela.getTextFieldCodigo().setText("");
		tela.getTextFieldCodigoBarras().setText("");
		tela.getTextFieldDescricao().setText("");
		tela.getTextFieldValorCompra().setText("");
		tela.getTextFieldValorVenda().setText("");
		tela.getTextFieldLucro().setText("");
		tela.getComboBoxUnidade().setSelectedItem("Selecione");
		tela.getComboBoxTipo().setSelectedItem("Selecione");
		tela.getTextFieldEstoqueMinimo().setText("");
		tela.getTextFieldEstoqueMaximo().setText("");
	}
	

	private void buttons_inicial() {
		tela.getTelaPesquisa().getButtonExcluir().setEnabled(false);
		tela.getTelaPesquisa().getButtonAlterar().setEnabled(false);
		tela.getTelaPesquisa().getButtonCancelar().setEnabled(false);
		tela.getTelaPesquisa().getButtonConfirmar().setEnabled(false);
		tela.getTelaPesquisa().getButtonIncluir().setEnabled(true);
		tela.getTelaPesquisa().getButtonBuscar().setEnabled(true);		
	}
	
	private void buttons_inc_alt() {
		tela.getTelaPesquisa().getButtonIncluir().setEnabled(false);
		tela.getTelaPesquisa().getButtonExcluir().setEnabled(false);
		tela.getTelaPesquisa().getButtonAlterar().setEnabled(false);
		tela.getTelaPesquisa().getButtonCancelar().setEnabled(true);
		tela.getTelaPesquisa().getButtonConfirmar().setEnabled(true);
	}

	
	
	private void atribuicao_busca_campos(ModeloProduto produto) {
		tela.getTextFieldCodigo().setText(produto.getCodigo());
		tela.getTextFieldCodigoBarras().setText(produto.getCodigoDeBarras());
		tela.getTextFieldDescricao().setText(produto.getDescricao());
		tela.getTextFieldValorCompra().setText(String.valueOf(produto.getValorDaCompra()));
		tela.getTextFieldValorVenda().setText(String.valueOf(produto.getValorDaVenda()));
		tela.getTextFieldLucro().setText(String.valueOf(produto.getLucro()));
		tela.getComboBoxUnidade().setSelectedItem(produto.getUnidade().getUnidadeNome());
		tela.getComboBoxTipo().setSelectedItem(produto.getTipo().getTipoNome());
		tela.getTextFieldEstoqueMinimo().setText(String.valueOf(produto.getEstoqueMinimo()));
		tela.getTextFieldEstoqueMaximo().setText(String.valueOf(produto.getEstoqueMaximo()));
	}
	
	private boolean validacao(String string) {
		ValidacaoProduto Produto;
		
		if(string.equals("Alterar")) {
			DadosProduto Produto_salvo = new DadosProduto();
			String id_end;
			
			int linhaSelecionada = tela.getTelaPesquisa().getJTableDados().getSelectedRow();
			
			produto_antigo = new ModeloProduto();
			produto_antigo = tela.get_busca_table_model(true).getProduto(linhaSelecionada);
			
			Produto = new ValidacaoProduto(produto_atual);
			id_end = banco.consultar("produto", "codigo" , produto_atual.getCodigo(), "codigo");
			
			if(Produto.isRes_val_geral() == true) {					
				
				Produto_salvo.bancoDeDadosAlterar(produto_atual, produto_antigo.getCodigo(), id_end, produto_atual.getCodigo());
				
				return true;
			}			
					
		}
		
		else if(string.equals("Incluir")) {
			DadosProduto Produto_salvo = new DadosProduto();
			
			Produto = new ValidacaoProduto(produto_atual);
			Produto.validarCódigo_barras();
			
			if(Produto.isRes_val_geral() == true && Produto.isResult_codigos() == true) {
				
				Produto_salvo.bancoDeDadosIncluir(produto_atual);
				
				return true;
			}
		}
		
		
		return false;
	}

	private void capturar_campos() {
		produto_atual = new ModeloProduto();
		
		//GERAL
		produto_atual.setCodigo(tela.getTextFieldCodigo().getText());
		produto_atual.setCodigoDeBarras(tela.getTextFieldCodigoBarras().getText());
		produto_atual.setDescricao(tela.getTextFieldDescricao().getText());
		try {
			produto_atual.setValorDaCompra(Double.parseDouble(tela.getTextFieldValorCompra().getText()));			
		} catch (NumberFormatException e) {
			produto_atual.setValorDaCompra(-1);
		}
		try {
			produto_atual.setValorDaVenda(Double.parseDouble(tela.getTextFieldValorVenda().getText()));			
		} catch (NumberFormatException e) {
			produto_atual.setValorDaVenda(-1);
		}
		try {
			produto_atual.setLucro(Double.parseDouble(tela.getTextFieldLucro().getText()));			
		} catch (NumberFormatException e) {
			produto_atual.setLucro(-1);
		}
		
		produto_atual.getUnidade().setUnidadeNome(tela.getComboBoxUnidade().getSelectedItem().toString());
		produto_atual.getTipo().setTipoNome(tela.getComboBoxTipo().getSelectedItem().toString());		
		
		try {
			produto_atual.setEstoqueMinimo(Integer.parseInt(tela.getTextFieldEstoqueMinimo().getText()));			
		} catch (NumberFormatException e) {
			produto_atual.setEstoqueMinimo(-1);
		}
		
		try {
			produto_atual.setEstoqueMaximo(Integer.parseInt(tela.getTextFieldEstoqueMaximo().getText()));			
		} catch (NumberFormatException e) {
			produto_atual.setEstoqueMaximo(-1);
		}
		
	}
	
	private boolean busca(String tipo_b, String val_b) {
		if(tipo_b.equals("Código de produto")) {
			DadosProduto Produto_banco = new DadosProduto();
			tela.getTelaPesquisa().getJTableDados().setModel(tela.get_busca_table_model(false));//seta uma nova tabela, só pra exibição dos resultados da busca
			
			ModeloProduto Produto = new ModeloProduto();
			
			for (int i = 0; i < Produto_banco.getProdutos().size(); i++) {
				if(Produto_banco.getProdutos().get(i).getCodigo().contains(val_b)) {
					Produto = Produto_banco.getProdutos().get(i);
					tela.get_busca_table_model(true).add_tabela(Produto);
				}				
			}
			if(tela.get_busca_table_model(true).getRowCount() == 0) {
				JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum cliente encontrado."
						  , "Busca", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		}
		else if(tipo_b.equals("Código de barras")) {
			DadosProduto Produto_banco = new DadosProduto();
			tela.getTelaPesquisa().getJTableDados().setModel(tela.get_busca_table_model(false));//seta uma nova tabela, só pra exibição dos resultados da busca
			
			ModeloProduto Produto = new ModeloProduto();
			
			for (int i = 0; i < Produto_banco.getProdutos().size(); i++) {
				if(Produto_banco.getProdutos().get(i).getCodigoDeBarras().contains(val_b)) {
					Produto = Produto_banco.getProdutos().get(i);
					tela.get_busca_table_model(true).add_tabela(Produto);
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
	
	
	private double lucro_to_venda() {
		double lucro = 0;
		try {
			lucro = Double.parseDouble(tela.getTextFieldLucro().getText());			
		} catch (NumberFormatException e) {
			lucro = 0;
		}
		double compra = 0;
		try {
			compra = Double.parseDouble(tela.getTextFieldValorCompra().getText());			
		} catch (NumberFormatException e) {
			compra = 0;
		}
		double venda=0;		
		if(compra!=0&&lucro!=0) {
			venda = compra + ((lucro/100.0)*compra);			
		}
		
		return venda;
	}
	
	private double venda_to_lucro() {
		double venda = 0;
		try {
			venda = Double.parseDouble(tela.getTextFieldValorVenda().getText());			
		} catch (NumberFormatException e) {
			venda = 0;
		}		
		double compra = 0;
		try {
			compra = Double.parseDouble(tela.getTextFieldValorCompra().getText());			
		} catch (NumberFormatException e) {
			compra = 0;
		}
		double lucro = 0;
		if(compra!=0&&venda!=0) {
			lucro = ((venda-compra)/compra)*100;			
		}
		
		return lucro;
	}
}
