package br.com.mercadinho.model.excecoes;

public class VerificacaoEmailException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 469525175990900393L;
	
	public VerificacaoEmailException(String msg){
		super(msg);
	}

}
