//package controle.cadastros;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.util.ArrayList;
//import java.util.Vector;
//
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
//
//import dao.Banco;
//import modelo.cadastros.cliente.ModeloClientePessoaFisica;
//import visao.cadastros.cliente.VisaoFramePrincipal;
//import visao.cadastros.cliente.VisaoTelaCadastroClientePessoaFisica;
//import visao.VisaoTelaPesquisa;
//
//public class ControladorBD {
//	private VisaoFramePrincipal framePrincipal;
//	private VisaoTelaCadastroClientePessoaFisica telaClienteFisico;
//
//	ModeloClientePessoaFisica modeloClienteFisico = new ModeloClientePessoaFisica();
//	Banco banco = new Banco();
//	
//	int sinalizador = 0;
//	String cpf;//precisa no controlador
//	String id_end;//precisa no controlador
//
//	private void getBotaoExcluirAction() {
//		
//		getTelaClienteFisico().getTelaPesquisa().getButtonExcluir().addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {//precisa no controlador
//				int linha = getTelaClienteFisico().getTelaPesquisa().getJTableDadosCliente().getSelectedRow();
//				String cpf = (String) getTelaClienteFisico().getTelaPesquisa().getJTableDadosCliente().getValueAt(linha, 0);
//				String id = banco.consultar("cliente", "cpf" , cpf, "ENDERECO_id");
//				banco.excluir("cliente", "cpf", cpf);
//				banco.excluir("endereco", "id", id);
//			}
//		});
//		
//		
//	}
//	private void getBotaoBuscarAction() {
//		getTelaClienteFisico().getTelaPesquisa().getButtonBuscar().addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {//PRECISA NO CONTROLADOR
//				if (getTelaClienteFisico().getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem()
//						.equals("Nome")) {
//
//					String nome = getTelaClienteFisico().getTelaPesquisa().getTextFieldEntradaDado().getText();
//					int id;
//
//					for (int i = 0; i < banco.consultarClienteFisico().size(); i++) {
//						if (banco.consultarClienteFisico().get(i).getNome().contains(nome)) {
//							id = banco.consultarClienteFisico().get(i).getId_endereco();
//							for (int j = 0; j < banco.consultarEndereco().size(); j++) {
//								if (banco.consultarEndereco().get(i).getId_endereco() == id) {
//									getTelaClienteFisico().getTelaPesquisa().getDefaultTableModel()
//											.addRow(new Object[] { banco.consultarClienteFisico().get(i).getCpf(),
//													banco.consultarClienteFisico().get(i).getNome(),
//													banco.consultarEndereco().get(i).getLogradouro(),
//													banco.consultarClienteFisico().get(i).getTelefone() });
//
//									break;
//								}
//							}
//
//						}
//					}
//
//				}
//
//				else if (getTelaClienteFisico().getTelaPesquisa().getComboBoxTipoPesquisa().getSelectedItem()
//						.equals("CPF")) {
//					String cpf = getTelaClienteFisico().getTelaPesquisa().getTextFieldEntradaDado().getText();
//					int id;
//
//					for (int i = 0; i < banco.consultarClienteFisico().size(); i++) {//PRECISA NO CONTROLADOR
//						if (banco.consultarClienteFisico().get(i).getCpf().contains(cpf)) {
//							id = banco.consultarClienteFisico().get(i).getId_endereco();
//							for (int j = 0; j < banco.consultarEndereco().size(); j++) {
//								if (banco.consultarEndereco().get(i).getId_endereco() == id) {
//									getTelaClienteFisico().getTelaPesquisa().getDefaultTableModel()
//											.addRow(new Object[] { banco.consultarClienteFisico().get(i).getCpf(),
//													banco.consultarClienteFisico().get(i).getNome(),
//													banco.consultarEndereco().get(i).getLogradouro(),
//													banco.consultarClienteFisico().get(i).getTelefone() });
//
//									break;
//								}
//							}
//
//						}
//					}
//				}
//			}
//		});
//	}
//
//	private boolean verificar() {//validação cliente físico
//		try {
//			modeloClienteFisico.setCpf(getTelaClienteFisico().getFormattedTextFieldCPF().getText());
//			modeloClienteFisico
//					.setDataNascimento(getTelaClienteFisico().getFormattedTextFieldDataNascimento().getText());
//			modeloClienteFisico
//					.setLimiteCredito(Double.parseDouble(getTelaClienteFisico().getTextFieldLimiteCredito().getText()));
//			modeloClienteFisico.setNome(getTelaClienteFisico().getFormattedTextFieldNome().getText());
//			modeloClienteFisico.setOrgaoExpeditorRg(
//					getTelaClienteFisico().getValidacaoJTextFieldOrgaoExpeditor().getSelectedItem().toString());
//			modeloClienteFisico.setRg(getTelaClienteFisico().getValidacaoJTextFieldRG().getText());
//			modeloClienteFisico.setSexo(getTelaClienteFisico().getComboBoxSexo().getSelectedItem().toString());
//			modeloClienteFisico
//					.setSituaca(getTelaClienteFisico().getComboBoxSituacaoCliente().getSelectedItem().toString());
//			modeloClienteFisico.setUfRg(getTelaClienteFisico().getComboBoxEstadoRG().getSelectedItem().toString());
//			modeloClienteFisico.setBairro(getTelaClienteFisico().getFormattedTextFieldBairro().getText());
//			modeloClienteFisico.setCep((getTelaClienteFisico().getFormattedTextFieldCEP().getText()));
//			modeloClienteFisico.setCidade(getTelaClienteFisico().getFormattedTextFieldCidade().getText());
//			modeloClienteFisico.setComplemento(getTelaClienteFisico().getFormattedTextFieldComplemento().getText());
//			modeloClienteFisico.setEmail(getTelaClienteFisico().getTextFieldEmail().getText());
//			modeloClienteFisico.setLogradouro(getTelaClienteFisico().getFormattedTextFieldLogradouro().getText());
//			modeloClienteFisico.setNumeroEndereco(getTelaClienteFisico().getFormattedTextFieldNumero().getText());
//			modeloClienteFisico.setTelefone(getTelaClienteFisico().getFormattedTextFieldTelefone().getText());
//			modeloClienteFisico
//					.setUf_estado(getTelaClienteFisico().getComboBoxEstadoEndereco().getSelectedItem().toString());
//
//			return true;
//
//		} catch (Exception e) {
//			return false;
//		}
//	}
//	
//	public void atualiza(String cpf, String id) {
//		if (verificar() == true) {
//			banco.atualizar("cliente", "cpf", cpf, "situacao='" + modeloClienteFisico.getSituacao() + "',nome='" + modeloClienteFisico.getNome() + "',cpf='" + modeloClienteFisico.getCpf() + "',datanasc='" + modeloClienteFisico.getDataNascimento() + "',sexo='" + modeloClienteFisico.getSexo() + "',rg='" + modeloClienteFisico.getRg() + "',uf_rg='" + modeloClienteFisico.getUfRg() + "',orgaoexpedidor='" + modeloClienteFisico.getOrgaoExpeditorRg() + "',telefone='" + modeloClienteFisico.getTelefone() + "',email='" + modeloClienteFisico.getEmail() + "',limitecredito='" + modeloClienteFisico.getLimiteCredito() + "'");
//			banco.atualizar("endereco", "id", id, "cep='" + modeloClienteFisico.getCep() + "',logradouro='" + modeloClienteFisico.getLogradouro() + "',numero='" + modeloClienteFisico.getNumeroEndereco() + "',bairro='" + modeloClienteFisico.getBairro() + "',complemento='" + modeloClienteFisico.getComplemento() + "',cidade='" + modeloClienteFisico.getCidade() + "',uf='" + modeloClienteFisico.getUf_estado() + "'");
//		}else {
//			JOptionPane.showMessageDialog(null, "Campos Invalidos ou não preenchido!");
//		}
//	}
//
//	public VisaoTelaCadastroClientePessoaFisica getTelaClienteFisico() {
//		if (telaClienteFisico == null) {
//			telaClienteFisico = new VisaoTelaCadastroClientePessoaFisica();
//		}
//		return telaClienteFisico;
//	}
//}
//
