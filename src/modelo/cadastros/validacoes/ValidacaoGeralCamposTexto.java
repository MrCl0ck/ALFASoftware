package modelo.cadastros.validacoes;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.swing.JTextField;

public class ValidacaoGeralCamposTexto extends JTextField{
	public ValidacaoGeralCamposTexto(String campo) {
		this.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evento) {
				switch (campo) {
					case "1":{//VALIDAÇÃO PARA CAMPOS QUE CONTÉM CARACTERES ALFABÉTICOS COM ACENTO, TAMBÉM CONTÉM ESPAÇO
						validaTextoTodosCaracteresTyping(evento);
						break;						
					}
					case "2": {//VALIDAÇÃO PARA CAMPOS QUE CONTÉM CARACTERES ALFABÉTICOS COM ACENTO, TAMBÉM CONTÉM ESPAÇO, também números
						validaRGTyping(evento);
						break;
					}
					case "3":{
						validaCpfTyping(evento);
						break;
					}					
					case "4":{
						validaCnpjTyping(evento);
						break;
					}				
					case "5":{
						validaInscricaoEstadualTyping(evento);
						break;
					}
					case "6":{//VALIDAÇÃO PARA CAMPOS QUE CONTÉM CARACTERES ALFABÉTICOS COM ACENTO, TAMBÉM CONTÉM ESPAÇO, também números
						break;
					}
					case "7":{
						validaTodosCaracteresAlfaNumericosEAlgunsTyping(evento);
						break;
					}
					case "8":{
						validaNumeroEnderecoTyping(evento);
						break;
					}
					case "9":{
						validaEmail(evento);
						break;
					}
					case "10":{
						validaLimiteCreditoTyping(evento);
						break;
					}
					default:
						break;
				}
			}

			@Override
			public void keyPressed(java.awt.event.KeyEvent evento) {
				if(evento.getModifiers() == Event.CTRL_MASK){
					if(evento.getKeyCode() == KeyEvent.VK_V){
						evento.consume();
					}
				}
			}
		});
	}

	private void validaTextoTodosCaracteresTyping(KeyEvent evento) {
		String permitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzáàâãéèêíîïóôõöúùûçñÁÀÂÃÉÊÈÍÎÏÓÔÕÖÚÙÛÜÇÑ "; 
		
		if(!permitidos.contains(evento.getKeyChar()+"")) {
			evento.consume(); 			
		}		
	}
	
	
	private void validaRGTyping(KeyEvent evento) {
		String permitidos = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ./-"; 
		String stringRg = evento.getKeyChar()+"";
		
		if(!permitidos.contains(stringRg)) {
			evento.consume(); 			
		}
	}
	
	private void validaLimiteCreditoTyping(KeyEvent evento) {
		String permitidos = "0123456789,"; 
		String stringLimite = evento.getKeyChar()+"";
		
		if(!permitidos.contains(stringLimite)) {
			evento.consume(); 			
		}
		if((evento.getKeyChar()== ',' && getText().length() == 0) || count(',', getText()) > 0  && evento.getKeyChar()== ',') {
			evento.consume(); 
		}
	}
	
	private static int count(char caracter ,String str){ //Method account characters
		int n = 0;
		for (int i = 0; i < str.length(); i++){
			if(str.charAt(i) == caracter){
				n++;
			}
		}
		return n;
	}
	
	private void validaCpfTyping(KeyEvent evento) {
		String permitidos = "0123456789"; 
		String stringCPF = evento.getKeyChar()+"";
		
		if(!permitidos.contains(stringCPF)) {
			evento.consume(); 			
		}
		if(getText().length() > 10) {
			evento.consume();
		}		
	}
	
	private void validaCnpjTyping(KeyEvent evento) {
		String permitidos = "0123456789"; 
		String stringCPNJ = evento.getKeyChar()+"";
		
		if(!permitidos.contains(stringCPNJ)) {
			evento.consume(); 			
		}
		if(getText().length() > 14) {
			evento.consume();
		}		
	}
	
	private void validaInscricaoEstadualTyping(KeyEvent evento) {
		String permitidos = "0123456789"; 
		String stringInscricaoEstadual = evento.getKeyChar()+"";
		
		if(!permitidos.contains(stringInscricaoEstadual)) {
			evento.consume(); 			
		}
		if(getText().length() > 14) {
			evento.consume();
		}		
	}
	
	private void validaNumeroEnderecoTyping(KeyEvent evento) {
		String permitidos = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; 
		String stringNumeroEndereco = evento.getKeyChar()+"";
		
		if(!permitidos.contains(stringNumeroEndereco)) {
			evento.consume(); 			
		}
	}
	
	private void validaTodosCaracteresAlfaNumericosEAlgunsTyping(KeyEvent evento) {
		String permitidos = "ºª,.0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzáàâãéèêíîïóôõöúùûçñÁÀÂÃÉÊÈÍÎÏÓÔÕÖÚÙÛÜÇÑ "; 
		String stringDigitada = evento.getKeyChar()+"";
		
		if(!permitidos.contains(stringDigitada)) {
			evento.consume(); 			
		}
	}
	
	private void validaEmail(KeyEvent evento) {
		String permitidos = ".@0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzáàâãéèêíîïóôõöúùûçñÁÀÂÃÉÊÈÍÎÏÓÔÕÖÚÙÛÜÇÑ"; 
		String stringDigitada = evento.getKeyChar()+"";
		
		if(!permitidos.contains(stringDigitada)) {
			evento.consume(); 			
		}
	}
	
	/**
     * Locale Brasileiro
     */
    private static final Locale BRAZIL = new Locale("pt","BR");
    /**
     * Sï¿½mbolos especificos do Real Brasileiro
     */
    private static final DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
    /**
     * Mascara de dinheiro para Real Brasileiro
     */
    public static final DecimalFormat DINHEIRO_REAL = new DecimalFormat("###,###,##0.00");
     
    /**
     * Mascara texto com formatacao monetaria
     * @param valor Valor a ser mascarado
     * @param moeda Padrao monetario a ser usado
     * @return Valor mascarado de acordo com o padrao especificado
     */
    public static String mascaraDinheiro(double valor, DecimalFormat moeda){
        return moeda.format(valor);
    }
    
    
}
