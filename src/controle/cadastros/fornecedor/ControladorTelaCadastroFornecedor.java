package controle.cadastros.fornecedor;

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
import modelo.cadastros.dados.DadosFornecedorPessoaFisica;
import modelo.cadastros.dados.DadosFornecedorPessoaJuridica;
import modelo.cadastros.fornecedor.ModeloFornecedorFisica;
import modelo.cadastros.fornecedor.ModeloFornecedorJuridica;
import modelo.cadastros.validacoes.ValidacaoFornecedorPessoaFisica;
import modelo.cadastros.validacoes.ValidacaoFornecedorPessoaJuridica;
import visao.cadastros.cliente.VisaoFramePrincipal;
import visao.cadastros.fornecedor.VisaoTelaCadastroFornecedor;

public class ControladorTelaCadastroFornecedor {

	private VisaoFramePrincipal framePrincipal;
	private VisaoTelaCadastroFornecedor telaFornecedor;
	private ModeloFornecedorJuridica fornecedor_exibicao_J;
	private ModeloFornecedorJuridica fornecedor_atual_J;
	private ModeloFornecedorJuridica fornecedor_antigo_J;
	private ModeloFornecedorFisica fornecedor_exibicao_F;
	private ModeloFornecedorFisica fornecedor_atual_F;
	private ModeloFornecedorFisica fornecedor_antigo_F;
	private Banco banco = new Banco();

	public ControladorTelaCadastroFornecedor(VisaoFramePrincipal frame) {
		framePrincipal = frame;
		inicializaTela();
		inicial_limpeza_geral();
		addEvento();
	}

	public void addEvento() {
		getTipoFornecedorAction();
		getBotaoBuscarAction();
		getBotaoIncluirAction();
		getBotaoExcluirAction();
		getBotaoAlterarAction();
		getBotaoCancelarAction();
		getBotaoConfirmarAction();
		getBotaoFecharAction();
		getSelecionarUmFornecedorTabela();
		getSelecionarUmFornecedorTabelaTyped();
	}

	public void getSelecionarUmFornecedorTabelaTyped() {
		telaFornecedor.getTelaPesquisa().getJTableDados().addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
							.contains(" Cadastro de Fornecedor - Pessoa Jurídica")) {
						if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
								.equals(" Cadastro de Fornecedor - Pessoa Jurídica - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null,
									"Ao exibir o fornecedor selecionado o procedimento de inclusão é cancelado, deseja cancelar?",
									"Cancelar", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
									options[0]);

							if (opcao == 1) {
								fornecedor_exibicao_J = new ModeloFornecedorJuridica();
								int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
								fornecedor_exibicao_J = telaFornecedor.getBuscaExibicaoTableModelJuridico(true).getFornecedor(linhaSelecionada);
								atribuicao_busca_campos_J(fornecedor_exibicao_J);
							}
						} else {
							fornecedor_exibicao_J = new ModeloFornecedorJuridica();
							int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
							fornecedor_exibicao_J = telaFornecedor.getBuscaExibicaoTableModelJuridico(true)
									.getFornecedor(linhaSelecionada);
							atribuicao_busca_campos_J(fornecedor_exibicao_J);
						}
					} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
							.contains(" Cadastro de Fornecedor - Pessoa Física")) {
						if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
								.equals(" Cadastro de Fornecedor - Pessoa Física - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null,
									"Ao exibir o fornecedor selecionado o procedimento de inclusão é cancelado, deseja cancelar?",
									"Cancelar", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
									options[0]);

							if (opcao == 1) {
								fornecedor_exibicao_F = new ModeloFornecedorFisica();
								int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
								fornecedor_exibicao_F = telaFornecedor.getBuscaExibicaoTableModelFisico(true)
										.getFornecedor(linhaSelecionada);
								atribuicao_busca_campos_F(fornecedor_exibicao_F);
							}
						} else {
							fornecedor_exibicao_F = new ModeloFornecedorFisica();
							int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
							fornecedor_exibicao_F = telaFornecedor.getBuscaExibicaoTableModelFisico(true)
									.getFornecedor(linhaSelecionada);
							atribuicao_busca_campos_F(fornecedor_exibicao_F);
						}
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
							.contains(" Cadastro de Fornecedor - Pessoa Jurídica")) {
						if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
								.equals(" Cadastro de Fornecedor - Pessoa Jurídica - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null,
									"Ao exibir o fornecedor selecionado o procedimento de inclusão é cancelado, deseja cancelar?",
									"Cancelar", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
									options[0]);

							if (opcao == 1) {
								fornecedor_exibicao_J = new ModeloFornecedorJuridica();
								int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
								fornecedor_exibicao_J = telaFornecedor.getBuscaExibicaoTableModelJuridico(true)
										.getFornecedor(linhaSelecionada);
								atribuicao_busca_campos_J(fornecedor_exibicao_J);
							}
						} else {
							fornecedor_exibicao_J = new ModeloFornecedorJuridica();
							int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
							fornecedor_exibicao_J = telaFornecedor.getBuscaExibicaoTableModelJuridico(true)
									.getFornecedor(linhaSelecionada);
							atribuicao_busca_campos_J(fornecedor_exibicao_J);
						}
					} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
							.contains(" Cadastro de Fornecedor - Pessoa Física")) {
						if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
								.equals(" Cadastro de Fornecedor - Pessoa Física - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null,
									"Ao exibir o fornecedor selecionado o procedimento de inclusão é cancelado, deseja cancelar?",
									"Cancelar", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
									options[0]);

							if (opcao == 1) {
								fornecedor_exibicao_F = new ModeloFornecedorFisica();
								int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
								fornecedor_exibicao_F = telaFornecedor.getBuscaExibicaoTableModelFisico(true)
										.getFornecedor(linhaSelecionada);
								atribuicao_busca_campos_F(fornecedor_exibicao_F);
							}
						} else {
							fornecedor_exibicao_F = new ModeloFornecedorFisica();
							int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
							fornecedor_exibicao_F = telaFornecedor.getBuscaExibicaoTableModelFisico(true)
									.getFornecedor(linhaSelecionada);
							atribuicao_busca_campos_F(fornecedor_exibicao_F);
						}
					}

				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
							.contains(" Cadastro de Fornecedor - Pessoa Jurídica")) {
						if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
								.equals(" Cadastro de Fornecedor - Pessoa Jurídica - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null,
									"Ao exibir o fornecedor selecionado o procedimento de inclusão é cancelado, deseja cancelar?",
									"Cancelar", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
									options[0]);

							if (opcao == 1) {
								fornecedor_exibicao_J = new ModeloFornecedorJuridica();
								int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
								fornecedor_exibicao_J = telaFornecedor.getBuscaExibicaoTableModelJuridico(true)
										.getFornecedor(linhaSelecionada);
								atribuicao_busca_campos_J(fornecedor_exibicao_J);
							}
						} else {
							fornecedor_exibicao_J = new ModeloFornecedorJuridica();
							int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
							fornecedor_exibicao_J = telaFornecedor.getBuscaExibicaoTableModelJuridico(true)
									.getFornecedor(linhaSelecionada);
							atribuicao_busca_campos_J(fornecedor_exibicao_J);
						}
					} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
							.contains(" Cadastro de Fornecedor - Pessoa Física")) {
						if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
								.equals(" Cadastro de Fornecedor - Pessoa Física - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null,
									"Ao exibir o fornecedor selecionado o procedimento de inclusão é cancelado, deseja cancelar?",
									"Cancelar", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
									options[0]);

							if (opcao == 1) {
								fornecedor_exibicao_F = new ModeloFornecedorFisica();
								int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
								fornecedor_exibicao_F = telaFornecedor.getBuscaExibicaoTableModelFisico(true)
										.getFornecedor(linhaSelecionada);
								atribuicao_busca_campos_F(fornecedor_exibicao_F);
							}
						} else {
							fornecedor_exibicao_F = new ModeloFornecedorFisica();
							int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
							fornecedor_exibicao_F = telaFornecedor.getBuscaExibicaoTableModelFisico(true)
									.getFornecedor(linhaSelecionada);
							atribuicao_busca_campos_F(fornecedor_exibicao_F);
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
		telaFornecedor.getTelaPesquisa().getButtonConfirmar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(null, "Fazer validação Regex para os campos
				// especiais e validação geral pros campos!", "Validação",
				// JOptionPane.INFORMATION_MESSAGE);
				if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
						.contains(" Cadastro de Fornecedor - Pessoa Jurídica")) {
					if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
							.equals(" Cadastro de Fornecedor - Pessoa Jurídica - Incluir")) {
						Object[] options = { "NÃO", "SIM" };
						int opcao = JOptionPane.showOptionDialog(null,
								"Confirma a inclusão dos dados do fornecedor tratado?", "Confirmar",
								JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

						if (opcao == 1) {
							capturar_campos_juridico();
							if (validacao_fornecedor_campos_J("Incluir") == true) {
								limpar_campos_juridico();
								campos_inicial_juridico();
								inicial_buttons_fj();
							}
						}
					} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
							.equals(" Cadastro de Fornecedor - Pessoa Jurídica - Alterar")) {
						Object[] options = { "NÃO", "SIM" };
						int opcao = JOptionPane.showOptionDialog(null,
								"Confirma a alteração dos dados do fornecedor tratado?", "Confirmar",
								JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

						if (opcao == 1) {
							capturar_campos_juridico();
							if (validacao_fornecedor_campos_J("Alterar") == true) {
								limpar_campos_juridico();
								campos_inicial_juridico();
								inicial_buttons_fj();
								telaFornecedor.getTelaPesquisa().getJTableDados()
										.setModel(telaFornecedor.getBuscaExibicaoTableModelJuridico(false));
							}
						}
					}

				} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
						.contains(" Cadastro de Fornecedor - Pessoa Física")) {
					if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
							.equals(" Cadastro de Fornecedor - Pessoa Física - Incluir")) {
						Object[] options = { "NÃO", "SIM" };
						int opcao = JOptionPane.showOptionDialog(null,
								"Confirma a inclusão do dados do fornecedor tratado?", "Confirmar",
								JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

						if (opcao == 1) {
							capturar_campos_fisico();
							if (validacao_fornecedor_campos_F("Incluir") == true) {
								limpar_campos_fisico();
								campos_inicial_fisico();
								inicial_buttons_fj();
							}
						}
					} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
							.equals(" Cadastro de Fornecedor - Pessoa Física - Alterar")) {
						Object[] options = { "NÃO", "SIM" };
						int opcao = JOptionPane.showOptionDialog(null,
								"Confirma a alteração dos dados do fornecedor tratado?", "Confirmar",
								JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

						if (opcao == 1) {
							capturar_campos_fisico();
							if (validacao_fornecedor_campos_F("Alterar") == true) {
								limpar_campos_fisico();
								campos_inicial_fisico();
								inicial_buttons_fj();
								telaFornecedor.getTelaPesquisa().getJTableDados()
										.setModel(telaFornecedor.getBuscaExibicaoTableModelFisico(false));
							}
						}
					}
				}

			}
		});
	}

	private void getBotaoAlterarAction() {
		telaFornecedor.getTelaPesquisa().getButtonAlterar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText().contains(" Cadastro de Fornecedor - Busca")) {
					int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
					if (telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow() != -1) {
						if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
								.equals(" Cadastro de Fornecedor - Busca - Pessoa Física")) {
							tela_fisico();
							atribuicao_busca_campos_F(
									telaFornecedor.getBuscaExibicaoTableModelFisico(true).getFornecedor(linhaSelecionada));
							telaFornecedor.getLabelPaginaCadastroFornecedor()
									.setText(" Cadastro de Fornecedor - Pessoa Física - Alterar");
							incluir_alterar_campos_f(true);
							incluir_alterar_buttons(true);
						} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
								.equals(" Cadastro de Fornecedor - Busca - Pessoa Jurídica")) {
							tela_juridico();
							atribuicao_busca_campos_J(
									telaFornecedor.getBuscaExibicaoTableModelJuridico(true).getFornecedor(linhaSelecionada));
							telaFornecedor.getLabelPaginaCadastroFornecedor()
									.setText(" Cadastro de Fornecedor - Pessoa Jurídica - Alterar");
							incluir_alterar_campos_j(true);
							incluir_alterar_buttons(true);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Selecione um fornecedor da lista exibida pela busca", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
						.equals(" Cadastro de Fornecedor - Pessoa Jurídica")) {
					if (telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow() != -1) {
						telaFornecedor.getLabelPaginaCadastroFornecedor()
								.setText(" Cadastro de Fornecedor - Pessoa Jurídica - Alterar");
						int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
						ModeloFornecedorJuridica fornecedor = telaFornecedor.getBuscaExibicaoTableModelJuridico(true)
								.getFornecedor(linhaSelecionada);

						fornecedor_antigo_J = new ModeloFornecedorJuridica();
						fornecedor_antigo_J = fornecedor;
						atribuicao_busca_campos_J(fornecedor_antigo_J);

						incluir_alterar_campos_j(true);
						incluir_alterar_buttons(true);
					} else {
						JOptionPane.showMessageDialog(null, "Selecione um fornecedor da lista exibida pela busca", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
						.equals(" Cadastro de Fornecedor - Pessoa Física")) {
					if (telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow() != -1) {
						telaFornecedor.getLabelPaginaCadastroFornecedor()
								.setText(" Cadastro de Fornecedor - Pessoa Física - Alterar");
						int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();

						fornecedor_antigo_F = new ModeloFornecedorFisica();
						fornecedor_antigo_F = telaFornecedor.getBuscaExibicaoTableModelFisico(true)
								.getFornecedor(linhaSelecionada);

						atribuicao_busca_campos_F(fornecedor_antigo_F);
						incluir_alterar_campos_f(true);
						incluir_alterar_buttons(true);
					} else {
						JOptionPane.showMessageDialog(null, "Selecione um fornecedor da lista exibida pela busca", "Aviso",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}

		});

	}

	private void atribuicao_busca_campos_J(ModeloFornecedorJuridica fornecedor_antigo_J) {
		telaFornecedor.getTelaJuridica().getComboBoxSituacaoFornecedor().setSelectedItem(fornecedor_antigo_J.getSituacao());
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoRazaoSocial().setText(fornecedor_antigo_J.getRazaoSocial());
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoCnpj().setText(fornecedor_antigo_J.getCnpj());
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoContatar()
				.setText(fornecedor_antigo_J.getRepresentante());
		telaFornecedor.getTelaJuridica().getFormattedTextFieldCep().setText(fornecedor_antigo_J.getCep());
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoLogradouro().setText(fornecedor_antigo_J.getLogradouro());
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoNumero().setText(fornecedor_antigo_J.getNumeroEndereco());
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoBairro().setText(fornecedor_antigo_J.getBairro());
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoComplemento()
				.setText(fornecedor_antigo_J.getComplemento());
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoCidade().setText(fornecedor_antigo_J.getCidade());
		telaFornecedor.getTelaJuridica().getComboBoxUfEndereco().setSelectedItem(fornecedor_antigo_J.getUf_estado());
		telaFornecedor.getTelaJuridica().getFormattedTextFieldTelefone().setText(fornecedor_antigo_J.getTelefone());
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoEmail().setText(fornecedor_antigo_J.getEmail());
		telaFornecedor.getTelaJuridica().getFormattedTextFieldRamoAtividade().setText(fornecedor_antigo_J.getRamoAtividade());
		telaFornecedor.getTelaJuridica().getFormattedTextFieldFax().setText(fornecedor_antigo_J.getFax());
		telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		telaFornecedor.getTelaPesquisa().getTextFieldEntradaDado().setText("");
	}

	private void getBotaoExcluirAction() {
		telaFornecedor.getTelaPesquisa().getButtonExcluir().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText().contains(" Cadastro de Fornecedor - Busca")) {
					if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
							.equals(" Cadastro de Fornecedor - Busca - Pessoa Física")) {
						exclusaoFisico();
						limpar_campos_fisico();
					} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
							.equals(" Cadastro de Fornecedor - Busca - Pessoa Jurídica")) {
						exclusaoJuridico();
						limpar_campos_juridico();
					}
				} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
						.contains(" Cadastro de Fornecedor - Pessoa Física")) {
					if (telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow() != -1) {
						// telaFornecedor.getLabelPaginaCadastroFornecedor().setText(" Cadastro de Fornecedor -
						// Pessoa Física - Exclusão de fornecedor");
						int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
						ModeloFornecedorFisica fornecedor = telaFornecedor.getBuscaExibicaoTableModelFisico(true)
								.getFornecedor(linhaSelecionada);

						Object[] options = { "NÃO", "SIM" };
						int opcao = JOptionPane.showOptionDialog(null,
								"Deseja excluir o fornecedor de nome: '" + fornecedor.getNome() + "' ?", "Exclusão",
								JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

						if (opcao == 1) {
							telaFornecedor.getBuscaExibicaoTableModelFisico(true).removerFornecedor(linhaSelecionada);
							String cpf = fornecedor.getCpf();
							String id = banco.consultar("fornecedor", "cpf", cpf, "ENDERECO_id");
							;

							if (new DadosFornecedorPessoaFisica().bancoDeDadosExcluir(cpf, id) == true) {
								limpar_campos_fisico();
								// campos_inicial_fisico();
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Selecione um fornecedor da lista exibida pela busca!",
								"Aviso", JOptionPane.INFORMATION_MESSAGE);
					}
				} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
						.contains(" Cadastro de Fornecedor - Pessoa Jurídica")) {
					if (telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow() != -1) {
						// telaFornecedor.getLabelPaginaCadastroFornecedor().setText(" Cadastro de Fornecedor -
						// Pessoa Jurídica - Exclusão de fornecedor");
						int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
						ModeloFornecedorJuridica fornecedor = telaFornecedor.getBuscaExibicaoTableModelJuridico(true)
								.getFornecedor(linhaSelecionada);

						Object[] options = { "NÃO", "SIM" };
						int opcao = JOptionPane.showOptionDialog(null,
								"Deseja excluir o fornecedor de Razão Social: '" + fornecedor.getRazaoSocial() + "' ?",
								"Exclusão", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);

						if (opcao == 1) {
							telaFornecedor.getBuscaExibicaoTableModelJuridico(true).removerFornecedor(linhaSelecionada);
							String cnpjBusca = fornecedor.getCnpj();
							String idBusca = banco.consultar("fornecedor", "cnpj", cnpjBusca, "ENDERECO_id");
							if (new DadosFornecedorPessoaJuridica().bancoDeDadosExcluir(cnpjBusca, idBusca) == true) {
								limpar_campos_juridico();
								// campos_inicial_juridico();
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Selecione um fornecedor da lista exibida pela busca!",
								"Aviso", JOptionPane.INFORMATION_MESSAGE);
					}
				}

			}
		});
	}

	public void exclusaoFisico() {
		int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
		ModeloFornecedorFisica fornecedor = telaFornecedor.getBuscaExibicaoTableModelFisico(true)
				.getFornecedor(linhaSelecionada);

		Object[] options = { "NÃO", "SIM" };
		int opcao = JOptionPane.showOptionDialog(null,
				"Deseja excluir o fornecedor de nome: '" + fornecedor.getNome() + "' ?", "Exclusão",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

		if (opcao == 1) {
			telaFornecedor.getBuscaExibicaoTableModelFisico(true).removerFornecedor(linhaSelecionada);
			String cpf = fornecedor.getCpf();
			String id = banco.consultar("fornecedor", "cpf", cpf, "ENDERECO_id");
			;

			if (new DadosFornecedorPessoaFisica().bancoDeDadosExcluir(cpf, id) == true) {
				inicial_limpeza_geral();
			}
		}
	}

	public void exclusaoJuridico() {
		int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
		ModeloFornecedorJuridica fornecedor = telaFornecedor.getBuscaExibicaoTableModelJuridico(true)
				.getFornecedor(linhaSelecionada);

		Object[] options = { "NÃO", "SIM" };
		int opcao = JOptionPane.showOptionDialog(null,
				"Deseja excluir o fornecedor de Razão Social: '" + fornecedor.getRazaoSocial() + "' ?", "Exclusão",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

		if (opcao == 1) {
			telaFornecedor.getBuscaExibicaoTableModelJuridico(true).removerFornecedor(linhaSelecionada);
			String cnpjBusca = fornecedor.getCnpj();
			String idBusca = banco.consultar("fornecedor", "cnpj", cnpjBusca, "ENDERECO_id");
			if (new DadosFornecedorPessoaJuridica().bancoDeDadosExcluir(cnpjBusca, idBusca) == true) {
				inicial_limpeza_geral();
			}
		}
	}

	private void getBotaoCancelarAction() {
		telaFornecedor.getTelaPesquisa().getButtonCancelar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText().equals(" Cadastro de Fornecedor")) {
					Object[] options = { "NÃO", "SIM" };
					int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar a busca atual?", "Cancelamento",
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

					if (opcao == 1) {
						inicial_limpeza_geral();
					}
				} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
						.contains(" Cadastro de Fornecedor - Pessoa Física")) {
					if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
							.equals(" Cadastro de Fornecedor - Pessoa Física")) {
						Object[] options = { "NÃO", "SIM" };
						int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar o procedimento atual?",
								"Cancelamento", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);

						if (opcao == 1) {
							limpar_campos_fisico();
							inicial_buttons_fj();
							campos_inicial_fisico();
							telaFornecedor.getTelaPesquisa().getJTableDados()
									.setModel(telaFornecedor.getBuscaExibicaoTableModelFisico(false));
						}
					} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
							.contains(" Cadastro de Fornecedor - Pessoa Física - Alterar")) {
						Object[] options = { "NÃO", "SIM" };
						int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar o procedimento atual?",
								"Cancelamento", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);

						if (opcao == 1) {
							limpar_campos_fisico();
							campos_inicial_fisico();
							botoes_habilitados_pos_busca(true);
						}
					} else {
						Object[] options = { "NÃO", "SIM" };
						int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar o procedimento atual?",
								"Cancelamento", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);

						if (opcao == 1) {
							limpar_campos_fisico();
							campos_inicial_fisico();
						}
					}
				} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
						.contains(" Cadastro de Fornecedor - Pessoa Jurídica")) {
					if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
							.equals(" Cadastro de Fornecedor - Pessoa Jurídica")) {
						Object[] options = { "NÃO", "SIM" };
						int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar o procedimento atual?",
								"Cancelamento", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);

						if (opcao == 1) {
							limpar_campos_juridico();
							inicial_buttons_fj();
							campos_inicial_juridico();
							telaFornecedor.getTelaPesquisa().getJTableDados()
									.setModel(telaFornecedor.getBuscaExibicaoTableModelJuridico(false));
						}
					} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
							.contains(" Cadastro de Fornecedor - Pessoa Jurídica - Alterar")) {
						Object[] options = { "NÃO", "SIM" };
						int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar o procedimento atual?",
								"Cancelamento", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);

						if (opcao == 1) {
							limpar_campos_juridico();
							campos_inicial_juridico();
							botoes_habilitados_pos_busca(true);
						}
					} else {
						Object[] options = { "NÃO", "SIM" };
						int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar o procedimento atual?",
								"Cancelamento", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
								options[0]);

						if (opcao == 1) {
							limpar_campos_juridico();
							campos_inicial_juridico();
							// antes de fazer a limpeza dos butoes ver se tem fornecedors mostrando na tabela
							// de busca.
							// inicial_buttons_fj();
						}
					}

				} else {
					Object[] options = { "NÃO", "SIM" };
					int opcao = JOptionPane.showOptionDialog(null, "Deseja cancelar a busca atual?", "Cancelamento",
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

					if (opcao == 1) {
						inicial_limpeza_geral();
					}
				}
			}
		});
	}

	private void getBotaoFecharAction() {
		telaFornecedor.getTelaPesquisa().getButtonFechar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText().equals(" Cadastro de Fornecedor")) {
					framePrincipal.dispose();
				} else {
					Object[] options = { "NÃO", "SIM" };
					int opcao = JOptionPane.showOptionDialog(null, "Deseja retornar a tela de cadastro de fornecedores?",
							"Fechar", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
							options[0]);

					if (opcao == 1) {
						chamarTelaFornecedor();
					}
				}
			}
		});

	}

	private void getBotaoBuscarAction() {
		telaFornecedor.getTelaPesquisa().getButtonBuscar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText().equals(" Cadastro de Fornecedor")) {
					String tipoBusca;

					tipoBusca = telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString();

					if (tipoBusca == "Nome" || tipoBusca == "CPF") {
						if (busca_banco_fisico() == true) {
							tela_fisico();
							botoes_habilitados_pos_busca(true);
						}
					} else if (tipoBusca == "Razão Social" || tipoBusca == "CNPJ") {
						if (busca_banco_juridico() == true) {
							tela_juridico();
							telaFornecedor.getLabelPaginaCadastroFornecedor()
									.setText(" Cadastro de Fornecedor - Pessoa Jurídica");
							botoes_habilitados_pos_busca(true);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Preencha o campo de busca e escolha um tipo de busca!",
								"Selecione", JOptionPane.INFORMATION_MESSAGE);
					}
				} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
						.contains(" Cadastro de Fornecedor - Pessoa Física")) {
					if (busca_banco_fisico() == true) {
						telaFornecedor.getLabelPaginaCadastroFornecedor().setText(" Cadastro de Fornecedor - Pessoa Física");
						botoes_habilitados_pos_busca(true);
					}
				} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
						.contains(" Cadastro de Fornecedor - Pessoa Jurídica")) {
					if (busca_banco_juridico() == true) {
						telaFornecedor.getLabelPaginaCadastroFornecedor().setText(" Cadastro de Fornecedor - Pessoa Jurídica");
						botoes_habilitados_pos_busca(true);
					}
				}
			}
		});
	}

	private void getBotaoIncluirAction() {
		telaFornecedor.getTelaPesquisa().getButtonIncluir().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText().equals(" Cadastro de Fornecedor")) {
					if (telaFornecedor.getComboBoxTipoFornecedor().getSelectedItem().toString().equals("Selecione")) {
						JOptionPane.showMessageDialog(null, "Selecione um tipo de fornecedor!", "ERRO",
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
						.equals(" Cadastro de Fornecedor - Pessoa Física")) {
					telaFornecedor.getLabelPaginaCadastroFornecedor()
							.setText(" Cadastro de Fornecedor - Pessoa Física - Incluir");
					incluir_alterar_campos_f(true);
					incluir_alterar_buttons(true);
				} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
						.equals(" Cadastro de Fornecedor - Pessoa Jurídica")) {
					telaFornecedor.getLabelPaginaCadastroFornecedor()
							.setText(" Cadastro de Fornecedor - Pessoa Jurídica - Incluir");
					incluir_alterar_campos_j(true);
					incluir_alterar_buttons(true);
				}
			}
		});
	}

	private void getTipoFornecedorAction() {
		telaFornecedor.getComboBoxTipoFornecedor().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText().equals(" Cadastro de Fornecedor")) {
					String opcao = telaFornecedor.getComboBoxTipoFornecedor().getSelectedItem().toString();

					if (opcao.equals("Pessoa Física")) {
						tela_fisico();
					} else if (opcao.equals("Pessoa Jurídica")) {
						tela_juridico();
					}
				}
			}
		});
	}

	private void getSelecionarUmFornecedorTabela() {
		telaFornecedor.getTelaPesquisa().getJTableDados().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText().equals(" Cadastro de Fornecedor")) {
					if (e.getClickCount() == 1) {
						System.out.println(telaFornecedor.getLabelPaginaCadastroFornecedor().getText());
						if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
								.equals(" Cadastro de Fornecedor - Busca - Pessoa Física")) {
							int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
							// getControladorPessoaFisicaInstancia().atribuicaoDeBuscaAosCampos(telaFornecedor.getBuscaExibicaoTableModelFisico(true).getFornecedor(linhaSelecionada));
							// getControladorPessoaFisicaInstancia().botoesHabilitadosPosBusca(true);
							// getControladorPessoaFisicaInstancia().getTelaFornecedorFisico().getTelaPesquisa().getTextFieldEntradaDado().setText(telaFornecedor.getTelaPesquisa().getTextFieldEntradaDado().getText());
							// getControladorPessoaFisicaInstancia().getTelaFornecedorFisico().getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem(telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString());
							// getControladorPessoaFisicaInstancia().getTelaFornecedorFisico().getTelaPesquisa().getJTableDadosFornecedor().setModel(telaFornecedor.getBuscaExibicaoTableModelFisico(true));;
							// getControladorPessoaFisicaInstancia().getTelaFornecedorFisico().getBuscaExibicaoTableModel(true).setFornecedorArray(telaFornecedor.getBuscaExibicaoTableModelFisico(true).getFornecedorArray());
							// erro aqui....

						} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
								.equals(" Cadastro de Fornecedor - Busca - Pessoa Jurídica")) {
							int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
							// getControladorPessoaJuridicaInstancia().atribuicaoDeBuscaAosCampos(telaFornecedor.getBuscaExibicaoTableModelJuridico(true).getFornecedor(linhaSelecionada));
							// getControladorPessoaJuridicaInstancia().botoesHabilitadosPosBusca(true);
							// getControladorPessoaJuridicaInstancia().getTelaFornecedorJuridico().getTelaPesquisa().getTextFieldEntradaDado().setText(telaFornecedor.getTelaPesquisa().getTextFieldEntradaDado().getText());
							// getControladorPessoaJuridicaInstancia().getTelaFornecedorJuridico().getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem(telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString());
							// getControladorPessoaJuridicaInstancia().getTelaFornecedorJuridico().getTelaPesquisa().getJTableDadosFornecedor().setModel(telaFornecedor.getBuscaExibicaoTableModelJuridico(true));
							// getControladorPessoaJuridicaInstancia().getTelaFornecedorJuridico().getBuscaExibicaoTableModel(true).setFornecedorArray(telaFornecedor.getBuscaExibicaoTableModelJuridico(true).getFornecedorArray());
							// erro aqui....
						}
					}
				} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
						.contains(" Cadastro de Fornecedor - Pessoa Física")) {
					if (e.getClickCount() == 1) {
						if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
								.equals(" Cadastro de Fornecedor - Pessoa Física - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null,
									"Ao exibir o fornecedor selecionado o procedimento de inclusão é cancelado, deseja cancelar?",
									"Fechar", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
									options[0]);

							if (opcao == 1) {
								telaFornecedor.getLabelPaginaCadastroFornecedor()
										.setText(" Cadastro de Fornecedor - Pessoa Física - Alterar");
								fornecedor_exibicao_F = new ModeloFornecedorFisica();
								int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
								fornecedor_exibicao_F = telaFornecedor.getBuscaExibicaoTableModelFisico(true)
										.getFornecedor(linhaSelecionada);
								atribuicao_busca_campos_F(fornecedor_exibicao_F);
							}
						} else {
							fornecedor_exibicao_F = new ModeloFornecedorFisica();
							int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
							fornecedor_exibicao_F = telaFornecedor.getBuscaExibicaoTableModelFisico(true)
									.getFornecedor(linhaSelecionada);
							atribuicao_busca_campos_F(fornecedor_exibicao_F);
						}

					}
				} else if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
						.contains(" Cadastro de Fornecedor - Pessoa Jurídica")) {
					if (e.getClickCount() == 1) {
						if (telaFornecedor.getLabelPaginaCadastroFornecedor().getText()
								.equals(" Cadastro de Fornecedor - Pessoa Jurídica - Incluir")) {
							Object[] options = { "NÃO", "SIM" };
							int opcao = JOptionPane.showOptionDialog(null,
									"Ao exibir o fornecedor selecionado o procedimento de inclusão é cancelado, deseja cancelar?",
									"Fechar", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
									options[0]);

							if (opcao == 1) {
								telaFornecedor.getLabelPaginaCadastroFornecedor()
										.setText(" Cadastro de Fornecedor - Pessoa Jurídica - Alterar");
								fornecedor_atual_J = new ModeloFornecedorJuridica();
								int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
								fornecedor_atual_J = telaFornecedor.getBuscaExibicaoTableModelJuridico(true)
										.getFornecedor(linhaSelecionada);
								atribuicao_busca_campos_J(fornecedor_atual_J);
							}
						} else {
							fornecedor_atual_J = new ModeloFornecedorJuridica();
							int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
							fornecedor_atual_J = telaFornecedor.getBuscaExibicaoTableModelJuridico(true)
									.getFornecedor(linhaSelecionada);
							atribuicao_busca_campos_J(fornecedor_atual_J);
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

	public VisaoTelaCadastroFornecedor getTela() {
		if (telaFornecedor == null) {
			telaFornecedor = new VisaoTelaCadastroFornecedor();
		}
		return telaFornecedor;
	}

	private boolean buscaFornecedorJuridico(String tipoBusca, String valorBusca) {
		if (!tipoBusca.equals("Selecione")) {
			if (!valorBusca.trim().equals("")) {
				if (tipoBusca.equals("Razão Social")) {
					DadosFornecedorPessoaJuridica fornecedor = new DadosFornecedorPessoaJuridica();
					telaFornecedor.getTelaPesquisa().getJTableDados()
							.setModel(telaFornecedor.getBuscaExibicaoTableModelJuridico(false));// seta uma nova tabela, só
																								// pra exibição dos
																								// resultados da busca

					ModeloFornecedorJuridica fornecedorPessoa = new ModeloFornecedorJuridica();

					for (int i = 0; i < fornecedor.getFornecedoresJuridicos().size(); i++) {
						if (fornecedor.getFornecedoresJuridicos().get(i).getRazaoSocial().contains(valorBusca)) {
							for (int j = 0; j < banco.consultarEndereco().size(); j++) {
								if (banco.consultarEndereco().get(j).getId_endereco() == banco.consultarFornecedorFisico()
										.get(i).getId_endereco()) {
									fornecedorPessoa = fornecedor.getFornecedoresJuridicos().get(i);
									fornecedorPessoa.setBairro(banco.consultarEndereco().get(j).getBairro());
									fornecedorPessoa.setCep(banco.consultarEndereco().get(j).getCep());
									fornecedorPessoa.setLogradouro(banco.consultarEndereco().get(j).getLogradouro());
									fornecedorPessoa
											.setNumeroEndereco(banco.consultarEndereco().get(j).getNumeroEndereco());
									fornecedorPessoa.setComplemento(banco.consultarEndereco().get(j).getComplemento());
									fornecedorPessoa.setCidade(banco.consultarEndereco().get(j).getCidade());
									fornecedorPessoa.setUf_estado(banco.consultarEndereco().get(j).getUf_estado());
									telaFornecedor.getBuscaExibicaoTableModelJuridico(true).addFornecedor(fornecedorPessoa);
								}
							}
						}
					}
					if (telaFornecedor.getBuscaExibicaoTableModelJuridico(true).getRowCount() > 0) {
						JOptionPane.showMessageDialog(null,
								"Busca finalizada, "
										+ telaFornecedor.getBuscaExibicaoTableModelJuridico(true).getRowCount()
										+ " fornecedor encontrados.",
								"Busca", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum fornecedor encontrado.", "Busca",
								JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
				} else if (tipoBusca.equals("CNPJ")) {
					DadosFornecedorPessoaJuridica fornecedor = new DadosFornecedorPessoaJuridica();
					telaFornecedor.getTelaPesquisa().getJTableDados()
							.setModel(telaFornecedor.getBuscaExibicaoTableModelJuridico(false));// seta uma nova tabela, só
																								// pra exibição dos
																								// resultados da busca

					ModeloFornecedorJuridica fornecedorPessoa = new ModeloFornecedorJuridica();

					for (int i = 0; i < fornecedor.getFornecedoresJuridicos().size(); i++) {
						if (fornecedor.getFornecedoresJuridicos().get(i).getCnpj().contains(valorBusca)) {
							for (int j = 0; j < banco.consultarEndereco().size(); j++) {
								if (banco.consultarEndereco().get(j).getId_endereco() == banco.consultarFornecedorFisico()
										.get(i).getId_endereco()) {
									fornecedorPessoa = fornecedor.getFornecedoresJuridicos().get(i);
									fornecedorPessoa.setBairro(banco.consultarEndereco().get(j).getBairro());
									fornecedorPessoa.setCep(banco.consultarEndereco().get(j).getCep());
									fornecedorPessoa.setLogradouro(banco.consultarEndereco().get(j).getLogradouro());
									fornecedorPessoa
											.setNumeroEndereco(banco.consultarEndereco().get(j).getNumeroEndereco());
									fornecedorPessoa.setComplemento(banco.consultarEndereco().get(j).getComplemento());
									fornecedorPessoa.setCidade(banco.consultarEndereco().get(j).getCidade());
									fornecedorPessoa.setUf_estado(banco.consultarEndereco().get(j).getUf_estado());
									telaFornecedor.getBuscaExibicaoTableModelJuridico(true).addFornecedor(fornecedorPessoa);
								}
							}
						}
					}
					if (telaFornecedor.getBuscaExibicaoTableModelJuridico(true).getRowCount() > 0) {
						JOptionPane.showMessageDialog(null,
								"Busca finalizada, "
										+ telaFornecedor.getBuscaExibicaoTableModelJuridico(true).getRowCount()
										+ " fornecedores encontrados.",
								"Busca", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum fornecedor encontrado.", "Busca",
								JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Preencha o campo de busca!", "Selecione",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Escolha um tipo de busca!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		return true;
	}

	private boolean buscaFornecedorFisico(String tipoBusca, String valorBusca) {
		if (!tipoBusca.equals("Selecione")) {
			if (!valorBusca.trim().equals("")) {
				if (tipoBusca.equals("Nome")) {
					DadosFornecedorPessoaFisica fornecedor = new DadosFornecedorPessoaFisica();
					telaFornecedor.getTelaPesquisa().getJTableDados()
							.setModel(telaFornecedor.getBuscaExibicaoTableModelFisico(false));// seta uma nova tabela, só
																							// pra exibição dos
																							// resultados da busca

					ModeloFornecedorFisica fornecedorPessoa = new ModeloFornecedorFisica();

					for (int i = 0; i < fornecedor.getFornecedoresFisicos().size(); i++) {
						if (fornecedor.getFornecedoresFisicos().get(i).getNome().contains(valorBusca)) {
							for (int j = 0; j < banco.consultarEndereco().size(); j++) {
								if (banco.consultarEndereco().get(j).getId_endereco() == banco.consultarFornecedorFisico()
										.get(i).getId_endereco()) {
									fornecedorPessoa = fornecedor.getFornecedoresFisicos().get(i);
									fornecedorPessoa.setBairro(banco.consultarEndereco().get(j).getBairro());
									fornecedorPessoa.setCep(banco.consultarEndereco().get(j).getCep());
									fornecedorPessoa.setLogradouro(banco.consultarEndereco().get(j).getLogradouro());
									fornecedorPessoa
											.setNumeroEndereco(banco.consultarEndereco().get(j).getNumeroEndereco());
									fornecedorPessoa.setComplemento(banco.consultarEndereco().get(j).getComplemento());
									fornecedorPessoa.setCidade(banco.consultarEndereco().get(j).getCidade());
									fornecedorPessoa.setUf_estado(banco.consultarEndereco().get(j).getUf_estado());
									telaFornecedor.getBuscaExibicaoTableModelFisico(true).addFornecedor(fornecedorPessoa);
									break;
								}
							}
						}
					}
					if (telaFornecedor.getBuscaExibicaoTableModelFisico(true).getRowCount() > 0) {
						JOptionPane.showMessageDialog(null,
								"Busca finalizada, " + telaFornecedor.getBuscaExibicaoTableModelFisico(true).getRowCount()
										+ " fornecedores encontrados.",
								"Busca", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum fornecedor encontrado.", "Busca",
								JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
				} else if (tipoBusca.equals("CPF")) {
					DadosFornecedorPessoaFisica fornecedor = new DadosFornecedorPessoaFisica();
					telaFornecedor.getTelaPesquisa().getJTableDados()
							.setModel(telaFornecedor.getBuscaExibicaoTableModelFisico(false));// seta uma nova tabela, só
																							// pra exibição dos
																							// resultados da busca

					ModeloFornecedorFisica fornecedorPessoa = new ModeloFornecedorFisica();

					for (int i = 0; i < fornecedor.getFornecedoresFisicos().size(); i++) {
						if (fornecedor.getFornecedoresFisicos().get(i).getCpf().contains(valorBusca)) {
							for (int j = 0; j < banco.consultarEndereco().size(); j++) {
								if (banco.consultarEndereco().get(j).getId_endereco() == banco.consultarFornecedorFisico()
										.get(i).getId_endereco()) {
									fornecedorPessoa = fornecedor.getFornecedoresFisicos().get(i);
									fornecedorPessoa.setBairro(banco.consultarEndereco().get(j).getBairro());
									fornecedorPessoa.setCep(banco.consultarEndereco().get(j).getCep());
									fornecedorPessoa.setLogradouro(banco.consultarEndereco().get(j).getLogradouro());
									fornecedorPessoa
											.setNumeroEndereco(banco.consultarEndereco().get(j).getNumeroEndereco());
									fornecedorPessoa.setComplemento(banco.consultarEndereco().get(j).getComplemento());
									fornecedorPessoa.setCidade(banco.consultarEndereco().get(j).getCidade());
									fornecedorPessoa.setUf_estado(banco.consultarEndereco().get(j).getUf_estado());
									telaFornecedor.getBuscaExibicaoTableModelFisico(true).addFornecedor(fornecedorPessoa);
									break;
								}
							}
						}
					}
					if (telaFornecedor.getBuscaExibicaoTableModelFisico(true).getRowCount() > 0) {
						JOptionPane.showMessageDialog(null,
								"Busca finalizada, " + telaFornecedor.getBuscaExibicaoTableModelFisico(true).getRowCount()
										+ " fornecedores encontrados.",
								"Busca", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum fornecedor encontrado.", "Busca",
								JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Preencha o campo de busca!", "Selecione",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Escolha um tipo de busca!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		return true;
	}

	private void botoes_habilitados_pos_busca(boolean b) {
		telaFornecedor.getTelaPesquisa().getButtonExcluir().setEnabled(b);
		telaFornecedor.getTelaPesquisa().getButtonAlterar().setEnabled(b);
		telaFornecedor.getTelaPesquisa().getButtonCancelar().setEnabled(b);
		telaFornecedor.getTelaPesquisa().getButtonConfirmar().setEnabled(!b);
		telaFornecedor.getTelaPesquisa().getButtonIncluir().setEnabled(!b);
	}

	private void inicial_limpeza_geral() {
		inicial_buttons_geral();
		limpar_campos_geral();
	}

	private void inicial_buttons_geral() {
		telaFornecedor.getTelaPesquisa().getButtonExcluir().setEnabled(false);
		telaFornecedor.getTelaPesquisa().getButtonAlterar().setEnabled(false);
		telaFornecedor.getTelaPesquisa().getButtonCancelar().setEnabled(false);
		telaFornecedor.getTelaPesquisa().getButtonConfirmar().setEnabled(false);
		telaFornecedor.getTelaPesquisa().getButtonIncluir().setEnabled(false);
	}

	public void chamarTelaFornecedor() {
		telaFornecedor.remove(2);
		telaFornecedor.add(telaFornecedor.getPanel());
		inicial_limpeza_geral();
		telaFornecedor.repaint();
		telaFornecedor.validate();
	}

	public void tela_fisico() {
		telaFornecedor.remove(2);
		telaFornecedor.add(telaFornecedor.getTelaFisica());
		limpar_campos_fisico();
		campos_inicial_fisico();
		inicial_buttons_fj();
		if (telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().getItemCount() > 3) {
			telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().removeItem("Razão Social");
			telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().removeItem("CNPJ");
		}
		telaFornecedor.repaint();
		telaFornecedor.validate();
	}

	public void tela_juridico() {
		telaFornecedor.remove(2);
		telaFornecedor.add(telaFornecedor.getTelaJuridica());
		limpar_campos_juridico();
		campos_inicial_juridico();
		inicial_buttons_fj();
		if (telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().getItemCount() > 3) {
			telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().removeItem("CPF");
			telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().removeItem("Nome");
		}
		telaFornecedor.repaint();
		telaFornecedor.validate();
	}

	private void campos_inicial_juridico() {
		telaFornecedor.getTelaJuridica().getComboBoxSituacaoFornecedor().setEnabled(false);
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoRazaoSocial().setEnabled(false);
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoCnpj().setEnabled(false);
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoContatar().setEnabled(false);
		telaFornecedor.getTelaJuridica().getFormattedTextFieldCep().setEnabled(false);
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoLogradouro().setEnabled(false);
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoNumero().setEnabled(false);
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoBairro().setEnabled(false);
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoComplemento().setEnabled(false);
		telaFornecedor.getTelaJuridica().getFormattedTextFieldRamoAtividade().setEnabled(false);
		telaFornecedor.getTelaJuridica().getFormattedTextFieldFax().setEnabled(false);
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoCidade().setEnabled(false);
		telaFornecedor.getTelaJuridica().getComboBoxUfEndereco().setEnabled(false);
		telaFornecedor.getTelaJuridica().getFormattedTextFieldTelefone().setEnabled(false);
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoEmail().setEnabled(false);
	}

	private void limpar_campos_geral() {
		telaFornecedor.getLabelPaginaCadastroFornecedor().setText(" Cadastro de Fornecedor");
		telaFornecedor.getComboBoxTipoFornecedor().setSelectedItem("Selecione");
		telaFornecedor.getTelaPesquisa().getTextFieldEntradaDado().setText("");
		telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		telaFornecedor.getTelaPesquisa().getJTableDados().setModel(new DefaultTableModel(new Object[][] {
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
//				{null, null, null, null},
		}, new String[] { "CPF/CNPJ", "Nome/Razão Social", "Endereço", "Telefone" }));
		if (telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().getItemCount() <= 3) {
			telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().removeAllItems();
			telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().addItem("Selecione");
			telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().addItem("Nome");
			telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().addItem("Razão Social");
			telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().addItem("CNPJ");
			telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().addItem("CPF");
		}
	}

	private void incluir_alterar_campos_j(boolean b) {
		telaFornecedor.getTelaJuridica().getComboBoxSituacaoFornecedor().setEnabled(b);
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoRazaoSocial().setEnabled(b);
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoCnpj().setEnabled(b);
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoContatar().setEnabled(b);
		telaFornecedor.getTelaJuridica().getFormattedTextFieldCep().setEnabled(b);
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoLogradouro().setEnabled(b);
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoNumero().setEnabled(b);
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoBairro().setEnabled(b);
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoComplemento().setEnabled(b);
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoCidade().setEnabled(b);
		telaFornecedor.getTelaJuridica().getComboBoxUfEndereco().setEnabled(b);
		telaFornecedor.getTelaJuridica().getFormattedTextFieldTelefone().setEnabled(b);
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoEmail().setEnabled(b);
		telaFornecedor.getTelaJuridica().getFormattedTextFieldRamoAtividade().setEnabled(b);
		telaFornecedor.getTelaJuridica().getFormattedTextFieldFax().setEnabled(b);
	}

	public void limpar_pesquisa_juridico() {
		telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		telaFornecedor.getTelaPesquisa().getTextFieldEntradaDado().setText("");
		telaFornecedor.getTelaPesquisa().getJTableDados().setModel(telaFornecedor.getBuscaExibicaoTableModelJuridico(false));
	}

	private void limpar_campos_juridico() {
		telaFornecedor.getLabelPaginaCadastroFornecedor().setText(" Cadastro de Fornecedor - Pessoa Jurídica");
		telaFornecedor.getTelaJuridica().getComboBoxSituacaoFornecedor().setSelectedIndex(0);
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoRazaoSocial().setText("");
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoCnpj().setText("");
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoContatar().setText("");
		telaFornecedor.getTelaJuridica().getFormattedTextFieldCep().setText("");
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoLogradouro().setText("");
		telaFornecedor.getTelaJuridica().getFormattedTextFieldFax().setText("");
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoNumero().setText("");
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoBairro().setText("");
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoComplemento().setText("");
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoCidade().setText("");
		telaFornecedor.getTelaJuridica().getComboBoxUfEndereco().setSelectedIndex(0);
		telaFornecedor.getTelaJuridica().getFormattedTextFieldTelefone().setText("");
		telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoEmail().setText("");
		telaFornecedor.getTelaJuridica().getFormattedTextFieldRamoAtividade().setText("");
		telaFornecedor.getTelaJuridica().getFormattedTextFieldFax().setText("");
	}

	private void inicial_buttons_fj() {
		telaFornecedor.getTelaPesquisa().getButtonExcluir().setEnabled(false);
		telaFornecedor.getTelaPesquisa().getButtonAlterar().setEnabled(false);
		telaFornecedor.getTelaPesquisa().getButtonCancelar().setEnabled(false);
		telaFornecedor.getTelaPesquisa().getButtonConfirmar().setEnabled(false);
		telaFornecedor.getTelaPesquisa().getButtonIncluir().setEnabled(true);
		telaFornecedor.getTelaPesquisa().getButtonBuscar().setEnabled(true);
	}

	public void incluir_alterar_buttons(boolean b) {
		telaFornecedor.getTelaPesquisa().getButtonConfirmar().setEnabled(b);
		telaFornecedor.getTelaPesquisa().getButtonCancelar().setEnabled(b);
		telaFornecedor.getTelaPesquisa().getButtonIncluir().setEnabled(!b);
		telaFornecedor.getTelaPesquisa().getButtonExcluir().setEnabled(!b);
		telaFornecedor.getTelaPesquisa().getButtonAlterar().setEnabled(!b);
	}

	private void campos_inicial_fisico() {
		telaFornecedor.getTelaFisica().getComboBoxSituacaoFornecedor().setEnabled(false);
		telaFornecedor.getTelaFisica().getFormattedTextFieldNome().setEnabled(false);
		telaFornecedor.getTelaFisica().getFormattedTextFieldDataNascimento().setEnabled(false);
		telaFornecedor.getTelaFisica().getComboBoxSexo().setEnabled(false);
		telaFornecedor.getTelaFisica().getFormattedTextFieldCPF().setEnabled(false);
		telaFornecedor.getTelaFisica().getValidacaoJTextFieldRG().setEnabled(false);
		telaFornecedor.getTelaFisica().getComboBoxEstadoRG().setEnabled(false);
		telaFornecedor.getTelaFisica().getValidacaoJTextFieldOrgaoExpeditor().setEnabled(false);
		telaFornecedor.getTelaFisica().getFormattedTextFieldCEP().setEnabled(false);
		telaFornecedor.getTelaFisica().getFormattedTextFieldLogradouro().setEnabled(false);
		telaFornecedor.getTelaFisica().getFormattedTextFieldNumero().setEnabled(false);
		telaFornecedor.getTelaFisica().getFormattedTextFieldBairro().setEnabled(false);
		telaFornecedor.getTelaFisica().getFormattedTextFieldComplemento().setEnabled(false);
		telaFornecedor.getTelaFisica().getFormattedTextFieldCidade().setEnabled(false);
		telaFornecedor.getTelaFisica().getComboBoxEstadoEndereco().setEnabled(false);
		telaFornecedor.getTelaFisica().getFormattedTextFieldTelefone().setEnabled(false);
		telaFornecedor.getTelaFisica().getTextFieldEmail().setEnabled(false);
		telaFornecedor.getTelaFisica().getFormattedTextFieldRamoAtividade().setEnabled(false);
		telaFornecedor.getTelaFisica().getFormattedTextFieldFax().setEnabled(false);
	}

	public void limpar_pesquisa_fisico() {
		telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		telaFornecedor.getTelaPesquisa().getTextFieldEntradaDado().setText("");
		telaFornecedor.getTelaPesquisa().getJTableDados().setModel(telaFornecedor.getBuscaExibicaoTableModelFisico(false));
	}

	public void incluir_alterar_campos_f(boolean b) {
		telaFornecedor.getTelaFisica().getComboBoxSituacaoFornecedor().setEnabled(b);
		telaFornecedor.getTelaFisica().getFormattedTextFieldNome().setEnabled(b);
		telaFornecedor.getTelaFisica().getFormattedTextFieldDataNascimento().setEnabled(b);
		telaFornecedor.getTelaFisica().getComboBoxSexo().setEnabled(b);
		telaFornecedor.getTelaFisica().getFormattedTextFieldCPF().setEnabled(b);
		telaFornecedor.getTelaFisica().getValidacaoJTextFieldRG().setEnabled(b);
		telaFornecedor.getTelaFisica().getComboBoxEstadoRG().setEnabled(b);
		telaFornecedor.getTelaFisica().getValidacaoJTextFieldOrgaoExpeditor().setEnabled(b);
		telaFornecedor.getTelaFisica().getFormattedTextFieldCEP().setEnabled(b);
		telaFornecedor.getTelaFisica().getFormattedTextFieldLogradouro().setEnabled(b);
		telaFornecedor.getTelaFisica().getFormattedTextFieldNumero().setEnabled(b);
		telaFornecedor.getTelaFisica().getFormattedTextFieldBairro().setEnabled(b);
		telaFornecedor.getTelaFisica().getFormattedTextFieldComplemento().setEnabled(b);
		telaFornecedor.getTelaFisica().getFormattedTextFieldCidade().setEnabled(b);
		telaFornecedor.getTelaFisica().getComboBoxEstadoEndereco().setEnabled(b);
		telaFornecedor.getTelaFisica().getFormattedTextFieldTelefone().setEnabled(b);
		telaFornecedor.getTelaFisica().getTextFieldEmail().setEnabled(b);
		telaFornecedor.getTelaFisica().getFormattedTextFieldRamoAtividade().setEnabled(b);
		telaFornecedor.getTelaFisica().getFormattedTextFieldFax().setEnabled(b);
	}

	private void limpar_campos_fisico() {
		telaFornecedor.getLabelPaginaCadastroFornecedor().setText(" Cadastro de Fornecedor - Pessoa Física");
		telaFornecedor.getTelaFisica().getComboBoxSituacaoFornecedor().setSelectedIndex(0);
		telaFornecedor.getTelaFisica().getFormattedTextFieldNome().setText("");
		telaFornecedor.getTelaFisica().getFormattedTextFieldDataNascimento().setText("");
		telaFornecedor.getTelaFisica().getComboBoxSexo().setSelectedIndex(0);
		telaFornecedor.getTelaFisica().getFormattedTextFieldCPF().setText("");
		telaFornecedor.getTelaFisica().getValidacaoJTextFieldRG().setText("");
		telaFornecedor.getTelaFisica().getComboBoxEstadoRG().setSelectedIndex(0);
		telaFornecedor.getTelaFisica().getValidacaoJTextFieldOrgaoExpeditor().setText("");
		telaFornecedor.getTelaFisica().getFormattedTextFieldCEP().setText("");
		telaFornecedor.getTelaFisica().getFormattedTextFieldLogradouro().setText("");
		telaFornecedor.getTelaFisica().getFormattedTextFieldNumero().setText("");
		telaFornecedor.getTelaFisica().getFormattedTextFieldBairro().setText("");
		telaFornecedor.getTelaFisica().getFormattedTextFieldComplemento().setText("");
		telaFornecedor.getTelaFisica().getFormattedTextFieldCidade().setText("");
		telaFornecedor.getTelaFisica().getComboBoxEstadoEndereco().setSelectedIndex(0);
		telaFornecedor.getTelaFisica().getFormattedTextFieldTelefone().setText("");
		telaFornecedor.getTelaFisica().getTextFieldEmail().setText("");
		telaFornecedor.getTelaFisica().getFormattedTextFieldRamoAtividade().setText("");
		telaFornecedor.getTelaFisica().getFormattedTextFieldFax().setText("");
	}

	private boolean busca_banco_fisico() {
		String tipoBusca, valorBusca;

		tipoBusca = telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString();
		valorBusca = telaFornecedor.getTelaPesquisa().getTextFieldEntradaDado().getText();

		if (!tipoBusca.equals("Selecione")) {
			if (!valorBusca.trim().equals("")) {
				if (tipoBusca.equals("Nome")) {
					DadosFornecedorPessoaFisica fornecedor = new DadosFornecedorPessoaFisica();
					telaFornecedor.getTelaPesquisa().getJTableDados()
							.setModel(telaFornecedor.getBuscaExibicaoTableModelFisico(false));// seta uma nova tabela, só
																							// pra exibição dos
																							// resultados da busca
					ModeloFornecedorFisica fornecedorPessoa = new ModeloFornecedorFisica();

					for (int i = 0; i < fornecedor.getFornecedoresFisicos().size(); i++) {
						if (fornecedor.getFornecedoresFisicos().get(i).getNome().contains(valorBusca)) {
							for (int j = 0; j < banco.consultarEndereco().size(); j++) {
								if (banco.consultarEndereco().get(j).getId_endereco() == banco.consultarFornecedorFisico()
										.get(i).getId_endereco()) {
									fornecedorPessoa = fornecedor.getFornecedoresFisicos().get(i);
									fornecedorPessoa.setBairro(banco.consultarEndereco().get(j).getBairro());
									fornecedorPessoa.setCep(banco.consultarEndereco().get(j).getCep());
									fornecedorPessoa.setLogradouro(banco.consultarEndereco().get(j).getLogradouro());
									fornecedorPessoa
											.setNumeroEndereco(banco.consultarEndereco().get(j).getNumeroEndereco());
									fornecedorPessoa.setComplemento(banco.consultarEndereco().get(j).getComplemento());
									fornecedorPessoa.setCidade(banco.consultarEndereco().get(j).getCidade());
									fornecedorPessoa.setUf_estado(banco.consultarEndereco().get(j).getUf_estado());
									telaFornecedor.getBuscaExibicaoTableModelFisico(true).addFornecedor(fornecedorPessoa);
								}
							}
						}
					}
					if (telaFornecedor.getBuscaExibicaoTableModelFisico(true).getRowCount() > 0) {
						// JOptionPane.showMessageDialog(null, "Busca finalizada, " +
						// telaFornecedor.getBuscaExibicaoTableModel(true).getRowCount() + " fornecedores
						// encontrados.", "Busca", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum fornecedor encontrado.", "Busca",
								JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
				} else if (tipoBusca.equals("CPF")) {
					DadosFornecedorPessoaFisica fornecedor = new DadosFornecedorPessoaFisica();
					telaFornecedor.getTelaPesquisa().getJTableDados()
							.setModel(telaFornecedor.getBuscaExibicaoTableModelFisico(false));// seta uma nova tabela, só
																							// pra exibição dos
																							// resultados da busca

					ModeloFornecedorFisica fornecedorPessoa = new ModeloFornecedorFisica();

					for (int i = 0; i < fornecedor.getFornecedoresFisicos().size(); i++) {
						if (fornecedor.getFornecedoresFisicos().get(i).getCpf().contains(valorBusca)) {
							for (int j = 0; j < banco.consultarEndereco().size(); j++) {
								if (banco.consultarEndereco().get(j).getId_endereco() == banco.consultarFornecedorFisico()
										.get(i).getId_endereco()) {
									fornecedorPessoa = fornecedor.getFornecedoresFisicos().get(i);
									fornecedorPessoa.setBairro(banco.consultarEndereco().get(j).getBairro());
									fornecedorPessoa.setCep(banco.consultarEndereco().get(j).getCep());
									fornecedorPessoa.setLogradouro(banco.consultarEndereco().get(j).getLogradouro());
									fornecedorPessoa
											.setNumeroEndereco(banco.consultarEndereco().get(j).getNumeroEndereco());
									fornecedorPessoa.setComplemento(banco.consultarEndereco().get(j).getComplemento());
									fornecedorPessoa.setCidade(banco.consultarEndereco().get(j).getCidade());
									fornecedorPessoa.setUf_estado(banco.consultarEndereco().get(j).getUf_estado());
									telaFornecedor.getBuscaExibicaoTableModelFisico(true).addFornecedor(fornecedorPessoa);
								}
							}
						}
					}
					if (telaFornecedor.getBuscaExibicaoTableModelFisico(true).getRowCount() > 0) {
						// JOptionPane.showMessageDialog(null, "Busca finalizada, " +
						// telaFornecedor.getBuscaExibicaoTableModel(true).getRowCount() + " fornecedors
						// encontrados.", "Busca", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum fornecedor encontrado.", "Busca",
								JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Preencha o campo de busca!", "Selecione",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Escolha um tipo de busca!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		return true;
	}

	private boolean busca_banco_juridico() {
		String tipoBusca, valorBusca;

		tipoBusca = telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem().toString();
		valorBusca = telaFornecedor.getTelaPesquisa().getTextFieldEntradaDado().getText();

		if (!tipoBusca.equals("Selecione")) {
			if (!valorBusca.trim().equals("")) {
				if (tipoBusca.equals("Razão Social")) {
					DadosFornecedorPessoaJuridica fornecedor = new DadosFornecedorPessoaJuridica();
					telaFornecedor.getTelaPesquisa().getJTableDados()
							.setModel(telaFornecedor.getBuscaExibicaoTableModelJuridico(false));// seta uma nova tabela, só
																								// pra exibição dos
																								// resultados da busca

					ModeloFornecedorJuridica fornecedorPessoa = new ModeloFornecedorJuridica();

					for (int i = 0; i < fornecedor.getFornecedoresJuridicos().size(); i++) {
						if (fornecedor.getFornecedoresJuridicos().get(i).getRazaoSocial().contains(valorBusca)) {
							for (int j = 0; j < banco.consultarEndereco().size(); j++) {
								if (banco.consultarEndereco().get(j).getId_endereco() == banco.consultarFornecedorJuridico()
										.get(i).getId_endereco()) {
									fornecedorPessoa = fornecedor.getFornecedoresJuridicos().get(i);
									fornecedorPessoa.setBairro(banco.consultarEndereco().get(j).getBairro());
									fornecedorPessoa.setCep(banco.consultarEndereco().get(j).getCep());
									fornecedorPessoa.setLogradouro(banco.consultarEndereco().get(j).getLogradouro());
									fornecedorPessoa
											.setNumeroEndereco(banco.consultarEndereco().get(j).getNumeroEndereco());
									fornecedorPessoa.setComplemento(banco.consultarEndereco().get(j).getComplemento());
									fornecedorPessoa.setCidade(banco.consultarEndereco().get(j).getCidade());
									fornecedorPessoa.setUf_estado(banco.consultarEndereco().get(j).getUf_estado());
									telaFornecedor.getBuscaExibicaoTableModelJuridico(true).addFornecedor(fornecedorPessoa);
									break;
								}
							}
						}
					}
					if (telaFornecedor.getBuscaExibicaoTableModelJuridico(true).getRowCount() > 0) {
						// JOptionPane.showMessageDialog(null, "Busca finalizada, " +
						// telaFornecedor.getBuscaExibicaoTableModel(true).getRowCount() + " fornecedores
						// encontrados.", "Busca", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum fornecedor encontrado.", "Busca",
								JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
				} else if (tipoBusca.equals("CNPJ")) {
					DadosFornecedorPessoaJuridica fornecedor = new DadosFornecedorPessoaJuridica();
					telaFornecedor.getTelaPesquisa().getJTableDados()
							.setModel(telaFornecedor.getBuscaExibicaoTableModelJuridico(false));// seta uma nova tabela, só
																								// pra exibição dos
																								// resultados da busca

					ModeloFornecedorJuridica fornecedorPessoa = new ModeloFornecedorJuridica();

					for (int i = 0; i < fornecedor.getFornecedoresJuridicos().size(); i++) {
						if (fornecedor.getFornecedoresJuridicos().get(i).getCnpj().contains(valorBusca)) {
							for (int j = 0; j < banco.consultarEndereco().size(); j++) {
								if (banco.consultarEndereco().get(j).getId_endereco() == banco.consultarFornecedorJuridico()
										.get(i).getId_endereco()) {
									fornecedorPessoa = fornecedor.getFornecedoresJuridicos().get(i);
									fornecedorPessoa.setBairro(banco.consultarEndereco().get(j).getBairro());
									fornecedorPessoa.setCep(banco.consultarEndereco().get(j).getCep());
									fornecedorPessoa.setLogradouro(banco.consultarEndereco().get(j).getLogradouro());
									fornecedorPessoa
										.setNumeroEndereco(banco.consultarEndereco().get(j).getNumeroEndereco());
									fornecedorPessoa.setComplemento(banco.consultarEndereco().get(j).getComplemento());
									fornecedorPessoa.setCidade(banco.consultarEndereco().get(j).getCidade());
									fornecedorPessoa.setUf_estado(banco.consultarEndereco().get(j).getUf_estado());
									telaFornecedor.getBuscaExibicaoTableModelJuridico(true).addFornecedor(fornecedorPessoa);
									break;
								}
							}
						}
					}
					if (telaFornecedor.getBuscaExibicaoTableModelJuridico(true).getRowCount() > 0) {
						// JOptionPane.showMessageDialog(null, "Busca finalizada, " +
						// principal.getBuscaExibicaoTableModel(true).getRowCount() + " fornecedores
						// encontrados.", "Busca", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Busca finalizada, nenhum fornecedor encontrado.", "Busca",
								JOptionPane.INFORMATION_MESSAGE);
						return false;
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Preencha o campo de busca!", "Selecione",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Escolha um tipo de busca!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}

		return true;
	}

	public void atribuicao_busca_campos_F(ModeloFornecedorFisica fornecedor) {
		telaFornecedor.getTelaFisica().getComboBoxSituacaoFornecedor().setSelectedItem(fornecedor.getSituacao());
		telaFornecedor.getTelaFisica().getFormattedTextFieldNome().setText(fornecedor.getNome());
		telaFornecedor.getTelaFisica().getFormattedTextFieldDataNascimento().setText(fornecedor.getDataNascimento());
		telaFornecedor.getTelaFisica().getComboBoxSexo().setSelectedItem(fornecedor.getSexo());
		telaFornecedor.getTelaFisica().getFormattedTextFieldCPF().setText(fornecedor.getCpf());
		telaFornecedor.getTelaFisica().getValidacaoJTextFieldRG().setText(fornecedor.getRg());
		telaFornecedor.getTelaFisica().getComboBoxEstadoRG().setSelectedItem(fornecedor.getUfRg());
		telaFornecedor.getTelaFisica().getValidacaoJTextFieldOrgaoExpeditor().setText(fornecedor.getOrgaoExpeditorRg());
		telaFornecedor.getTelaFisica().getFormattedTextFieldCEP().setText(fornecedor.getCep());
		telaFornecedor.getTelaFisica().getFormattedTextFieldLogradouro().setText(fornecedor.getLogradouro());
		telaFornecedor.getTelaFisica().getFormattedTextFieldNumero().setText(fornecedor.getNumeroEndereco());
		telaFornecedor.getTelaFisica().getFormattedTextFieldBairro().setText(fornecedor.getBairro());
		telaFornecedor.getTelaFisica().getFormattedTextFieldComplemento().setText(fornecedor.getComplemento());
		telaFornecedor.getTelaFisica().getFormattedTextFieldCidade().setText(fornecedor.getCidade());
		telaFornecedor.getTelaFisica().getComboBoxEstadoEndereco().setSelectedItem(fornecedor.getUf_estado());
		telaFornecedor.getTelaFisica().getFormattedTextFieldTelefone().setText(fornecedor.getTelefone());
		telaFornecedor.getTelaFisica().getTextFieldEmail().setText(fornecedor.getEmail());
		telaFornecedor.getTelaFisica().getFormattedTextFieldRamoAtividade().setText(fornecedor.getRamoAtividade());
		telaFornecedor.getTelaFisica().getFormattedTextFieldFax().setText(fornecedor.getFax());
		// telaFornecedor.getTelaPesquisa().getComboBoxTipoPesquisa().setSelectedItem("Selecione");
		// telafornecedor.getTelaPesquisa().getTextFieldEntradaDado().setText("");
	}

	private void capturar_campos_juridico() {
		fornecedor_atual_J = new ModeloFornecedorJuridica();
		this.fornecedor_atual_J
				.setSituacao(telaFornecedor.getTelaJuridica().getComboBoxSituacaoFornecedor().getSelectedItem().toString());
		this.fornecedor_atual_J
				.setRazaoSocial(telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoRazaoSocial().getText());
		this.fornecedor_atual_J.setCnpj(telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoCnpj().getText());
		this.fornecedor_atual_J
				.setRepresentante(telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoContatar().getText());
		this.fornecedor_atual_J.setCep(telaFornecedor.getTelaJuridica().getFormattedTextFieldCep().getText());
		this.fornecedor_atual_J
				.setLogradouro(telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoLogradouro().getText());
		this.fornecedor_atual_J
				.setNumeroEndereco(telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoNumero().getText());
		this.fornecedor_atual_J.setBairro(telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoBairro().getText());
		this.fornecedor_atual_J
				.setComplemento(telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoComplemento().getText());
		this.fornecedor_atual_J.setCidade(telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoCidade().getText());
		this.fornecedor_atual_J
				.setUf_estado(telaFornecedor.getTelaJuridica().getComboBoxUfEndereco().getSelectedItem().toString());
		this.fornecedor_atual_J.setTelefone(telaFornecedor.getTelaJuridica().getFormattedTextFieldTelefone().getText());
		this.fornecedor_atual_J.setEmail(telaFornecedor.getTelaJuridica().getValidacaoGeralCamposTextoEmail().getText());
		this.fornecedor_atual_J.setRamoAtividade(telaFornecedor.getTelaJuridica().getFormattedTextFieldRamoAtividade().getText());
		this.fornecedor_atual_J.setFax(telaFornecedor.getTelaJuridica().getFormattedTextFieldFax().getText());
	}

	private void capturar_campos_fisico() {
		fornecedor_atual_F = new ModeloFornecedorFisica();

		this.fornecedor_atual_F
				.setSituacao(telaFornecedor.getTelaFisica().getComboBoxSituacaoFornecedor().getSelectedItem().toString());
		this.fornecedor_atual_F.setNome(telaFornecedor.getTelaFisica().getFormattedTextFieldNome().getText());
		this.fornecedor_atual_F
				.setDataNascimento(telaFornecedor.getTelaFisica().getFormattedTextFieldDataNascimento().getText());
		this.fornecedor_atual_F.setSexo(telaFornecedor.getTelaFisica().getComboBoxSexo().getSelectedItem().toString());
		this.fornecedor_atual_F.setCpf(telaFornecedor.getTelaFisica().getFormattedTextFieldCPF().getText());
		this.fornecedor_atual_F.setRg(telaFornecedor.getTelaFisica().getValidacaoJTextFieldRG().getText());
		this.fornecedor_atual_F.setUfRg(telaFornecedor.getTelaFisica().getComboBoxEstadoRG().getSelectedItem().toString());
		this.fornecedor_atual_F
				.setOrgaoExpeditorRg(telaFornecedor.getTelaFisica().getValidacaoJTextFieldOrgaoExpeditor().getText());
		this.fornecedor_atual_F.setCep(telaFornecedor.getTelaFisica().getFormattedTextFieldCEP().getText());
		this.fornecedor_atual_F.setLogradouro(telaFornecedor.getTelaFisica().getFormattedTextFieldLogradouro().getText());
		this.fornecedor_atual_F.setNumeroEndereco(telaFornecedor.getTelaFisica().getFormattedTextFieldNumero().getText());
		this.fornecedor_atual_F.setBairro(telaFornecedor.getTelaFisica().getFormattedTextFieldBairro().getText());
		this.fornecedor_atual_F.setComplemento(telaFornecedor.getTelaFisica().getFormattedTextFieldComplemento().getText());
		this.fornecedor_atual_F.setCidade(telaFornecedor.getTelaFisica().getFormattedTextFieldCidade().getText());
		this.fornecedor_atual_F
				.setUf_estado(telaFornecedor.getTelaFisica().getComboBoxEstadoEndereco().getSelectedItem().toString());
		this.fornecedor_atual_F.setTelefone(telaFornecedor.getTelaFisica().getFormattedTextFieldTelefone().getText());
		this.fornecedor_atual_F.setEmail(telaFornecedor.getTelaFisica().getTextFieldEmail().getText());
		this.fornecedor_atual_F.setRamoAtividade(telaFornecedor.getTelaFisica().getFormattedTextFieldRamoAtividade().getText());
		this.fornecedor_atual_F.setFax(telaFornecedor.getTelaFisica().getFormattedTextFieldFax().getText());
	}

	private boolean validacao_fornecedor_campos_J(String b) {
		ValidacaoFornecedorPessoaJuridica fornecedorJ;

		if (b.equals("Alterar")) {
			DadosFornecedorPessoaJuridica fornecedorSalvo = new DadosFornecedorPessoaJuridica();

			String id_end;
			int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();
			ModeloFornecedorJuridica fornecedor = telaFornecedor.getBuscaExibicaoTableModelJuridico(true)
					.getFornecedor(linhaSelecionada);

			fornecedor_antigo_J = new ModeloFornecedorJuridica();
			fornecedor_antigo_J = fornecedor;

			fornecedorJ = new ValidacaoFornecedorPessoaJuridica(fornecedor_atual_J);
			id_end = banco.consultar("fornecedor", "cnpj", fornecedor_antigo_J.getCnpj(), "ENDERECO_id");

			if (fornecedorJ.isResultadoValidacaoTodosCamposGeral() == true) {

				fornecedorSalvo.bancoDeDadosAlterar(fornecedor_atual_J, fornecedor_antigo_J.getCnpj(), id_end);

				return true;
			}

		}

		else if (b.equals("Incluir")) {
			DadosFornecedorPessoaJuridica fornecedorSalvo = new DadosFornecedorPessoaJuridica();

			fornecedorJ = new ValidacaoFornecedorPessoaJuridica(fornecedor_atual_J);
			fornecedorJ.validarCNPJ();

			if (fornecedorJ.isResultadoValidacaoTodosCamposGeral() == true
					&& fornecedorJ.isResultadoValidacaoCnpjEInscricaoEstadual() == true) {

				fornecedorSalvo.bancoDeDadosIncluir(fornecedor_atual_J);

				return true;
			}
		}

		return false;
	}

	private boolean validacao_fornecedor_campos_F(String b) {
		ValidacaoFornecedorPessoaFisica fornecedorF;

		if (b.equals("Alterar")) {
			DadosFornecedorPessoaFisica fornecedorSalvo = new DadosFornecedorPessoaFisica();
			String id_end;

			int linhaSelecionada = telaFornecedor.getTelaPesquisa().getJTableDados().getSelectedRow();

			fornecedor_antigo_F = new ModeloFornecedorFisica();
			fornecedor_antigo_F = telaFornecedor.getBuscaExibicaoTableModelFisico(true).getFornecedor(linhaSelecionada);

			fornecedorF = new ValidacaoFornecedorPessoaFisica(fornecedor_atual_F);
			id_end = banco.consultar("fornecedor", "cpf", fornecedor_antigo_F.getCpf(), "ENDERECO_id");

			if (fornecedorF.isResultadoValidacaoTodosCamposGeral() == true) {

				fornecedorSalvo.bancoDeDadosAlterar(fornecedor_atual_F, fornecedor_antigo_F.getCpf(), id_end);

				return true;
			}
		}

		else if (b.equals("Incluir")) {
			DadosFornecedorPessoaFisica fornecedorSalvo = new DadosFornecedorPessoaFisica();

			fornecedorF = new ValidacaoFornecedorPessoaFisica(fornecedor_atual_F);
			fornecedorF.validarCPF();

			if (fornecedorF.isResultadoValidacaoTodosCamposGeral() == true
					&& fornecedorF.isResultadoValidacaoCpfRg() == true) {

				fornecedorSalvo.bancoDeDadosIncluir(fornecedor_atual_F);

				return true;
			}
		}

		return false;
	}

}
