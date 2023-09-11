package controller.produto;

import controller.AbstractCtrl;

abstract public class AbstractCtrlProduto extends AbstractCtrl {

	//------------------------------------------------------------------------//

	public AbstractCtrlProduto(AbstractCtrl ctrlPai)  {
		super(ctrlPai);
	}
	
	//------------------------------------------------------------------------//

	abstract public void efetivarOperacaoEmProduto(String codigoDeBarras, String nome, float precoAtual);
	
	//------------------------------------------------------------------------//
}

