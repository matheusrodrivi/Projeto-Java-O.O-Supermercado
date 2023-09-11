package controller;

import controller.cliente.CtrlManterClientes;
import controller.compra.CtrlIncluirCompra;
import controller.produto.CtrlManterProdutos;
import model.dao.AbstractDao;
import viewer.JanelaPrincipal;

public class CtrlPrograma extends AbstractCtrl {

	//----------------------------------------------------------------------//

	public CtrlPrograma() {
		super(null);
	}

	//----------------------------------------------------------------------//

	public void iniciar() {
		AbstractDao.recuperarObjetos();
		// Abro a janela principal
		JanelaPrincipal janela = new JanelaPrincipal(this);
		janela.setVisible(true);
	}

	//----------------------------------------------------------------------//

	public void encerrar() {
		System.exit(0);
	}
	
	//----------------------------------------------------------------------//

	public void iniciarManterProdutos() {
		new CtrlManterProdutos(this);
	}

	//----------------------------------------------------------------------//

	public void iniciarManterClientes() {
		new CtrlManterClientes(this);
	}

	//----------------------------------------------------------------------//

	public void iniciarIncluirCompra() {
		new CtrlIncluirCompra(this);
	}

	//----------------------------------------------------------------------//
	
	public static void main(String[] args) {
		new CtrlPrograma();
	}

	//----------------------------------------------------------------------//
}