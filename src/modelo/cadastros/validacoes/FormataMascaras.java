package modelo.cadastros.validacoes;
/**
 * 
 * @author Murilo Silva Santana
 * 
 * @edited Fl·via de Jesus Correia
 * */
import java.text.ParseException;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class FormataMascaras {
	private MaskFormatter mascara;
	private String string;
	
	// construtor padr„o
	void formataMascara(String formato, int opcao) {
		if(opcao == 1) {
			try{
				mascara =  new MaskFormatter(formato);
			}catch(ParseException exc){
				System.out.println(exc.getMessage());
				exc.printStackTrace();
			}
		}else if(opcao == 2){
			try{
				mascara = new MaskFormatter("*******************************************************************");
				mascara.setValidCharacters(" ‡·‚„ÈÍÌÛÙ˙abcÁdefghijklmnopqrstuvwxyz¿¡¬√… Õ”‘⁄ABC«DEFGHIJKLMNOPQRSTUVWXYZ");
			}catch(ParseException exc){
				System.out.println(exc.getMessage());
				exc.printStackTrace();
			}
			
		}
		else if(opcao == 3){
			try{
				mascara = new MaskFormatter("*******************************************************************");
				mascara.setValidCharacters(" 0123456789‡·‚„ÈÍÌÛÙ˙abcÁdefghijklmnopqrstuvwxyz¿¡¬√… Õ”‘⁄ABC«DEFGHIJKLMNOPQRSTUVWXYZ");
			}catch(ParseException exc){
				System.out.println(exc.getMessage());
				exc.printStackTrace();
			}
		}
		
	}
	
	// construtor que recebe uma String para o formato da m·scara
	// retorna a m·scara com o formato inserido pelo usu·rio
	
	//retorna m·scara CNPJ
	public DefaultFormatterFactory getCNPJ() {
		formataMascara("###.###.###/####-##", 1);
		return new DefaultFormatterFactory(mascara);
	}	
	
	// retorna m·scara CPF
	public DefaultFormatterFactory getCPF() {
		formataMascara("###.###.###-##", 1);
		return new DefaultFormatterFactory(mascara);
	}
	
	// retorna m·scara RG
	public DefaultFormatterFactory getRG() {
		formataMascara("##.###.###-##", 1);
		return new DefaultFormatterFactory(mascara);
	}
	
	// retorna m·scara telefone
	public DefaultFormatterFactory getTelefone() {
		formataMascara("(##) ####-####", 1);
		return new DefaultFormatterFactory(mascara);
	}
	
	// retorna m·scara CEP
	public DefaultFormatterFactory getCEP() {
		formataMascara("##.###-###", 1);
		return new DefaultFormatterFactory(mascara);
	}	
	
	public DefaultFormatterFactory getInscricaoEstadual() {///OBSSSSSS
		formataMascara("###.###.###.###", 1);
		return new DefaultFormatterFactory(mascara);
	}
	
	// retorna m·scara Data
	public DefaultFormatterFactory getData() {///OBSSSSSS
		formataMascara("##/##/####", 1);
		return new DefaultFormatterFactory(mascara);
	}
	
	//retorna m·scara para nome 
	public DefaultFormatterFactory getNome() {
		formataMascara("", 2);
		return new DefaultFormatterFactory(mascara);
	}
	
	//retorna qualquer campo de endereÁo
	public DefaultFormatterFactory getEndereco() {
		formataMascara("", 3);
		return new DefaultFormatterFactory(mascara);
	}
}
