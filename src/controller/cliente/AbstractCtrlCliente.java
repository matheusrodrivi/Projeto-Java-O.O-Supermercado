package controller.cliente;

import controller.AbstractCtrl;

abstract public class AbstractCtrlCliente extends AbstractCtrl {

	//------------------------------------------------------------------------//

	public AbstractCtrlCliente(AbstractCtrl ctrlPai)  {
		super(ctrlPai);
	}
	
	//------------------------------------------------------------------------//

	abstract public void efetivarOperacaoEmCliente(String cpf, String nome, String endereco, String telefone);
	
	//------------------------------------------------------------------------//
}

