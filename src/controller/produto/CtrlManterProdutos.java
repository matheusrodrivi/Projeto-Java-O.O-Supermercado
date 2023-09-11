package controller.produto;

import controller.AbstractCtrl;
import controller.ControllerException;
import controller.CtrlPrograma;
import model.Produto;
import model.dao.DaoProduto;
import viewer.JanelaManterProduto;

public class CtrlManterProdutos extends AbstractCtrl {
	
	private JanelaManterProduto janela;

	//------------------------------------------------------------------------//

	public CtrlManterProdutos(CtrlPrograma ctrlPai) {
		super(ctrlPai);
	}

	//------------------------------------------------------------------------//

	public void iniciar() {
		janela = new JanelaManterProduto(this);
		this.atualizarListaDeProdutos();
		janela.setVisible(true);
	}

	//------------------------------------------------------------------------//

	public void encerrar() {
		this.janela.setVisible(false);
		this.notificarEncerramentoAoCtrlPai();
	}
	
	//------------------------------------------------------------------------//

	public void atualizarListaDeProdutos() {
		Produto[] conjProdutos;
		try {
			conjProdutos = (Produto[])DaoProduto.getProdutos();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		janela.exibirProdutos(conjProdutos);		
	}
	
	//----------------------------------------------------------------------//

	public void retomarExecucao() {
		this.atualizarListaDeProdutos();			
	}

	//----------------------------------------------------------------------//

	public void iniciarIncluirProduto() {
		new CtrlIncluirProduto(this);
	}

	//----------------------------------------------------------------------//

	public void iniciarAlterarProduto(Produto selecionado) {
		try {
			new CtrlAlterarProduto(this, selecionado);
		} catch (ControllerException e) {
			e.printStackTrace();
		}
	}

	//----------------------------------------------------------------------//

	public void iniciarExcluirProduto(Produto selecionado) {
		try {
			new CtrlExcluirProduto(this, selecionado);
		} catch (ControllerException e) {
			e.printStackTrace();
		}
	}

}

