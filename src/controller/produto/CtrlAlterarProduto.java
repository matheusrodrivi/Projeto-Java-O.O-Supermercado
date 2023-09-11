package controller.produto;

import controller.AbstractCtrl;
import controller.ControllerException;
import model.Produto;
import model.dao.DaoProduto;
import viewer.JanelaProduto;

public class CtrlAlterarProduto extends AbstractCtrlProduto {
	
	private JanelaProduto janela;
	final private Produto produtoParaAlterar;

	//------------------------------------------------------------------------//

	public CtrlAlterarProduto(AbstractCtrl ctrlPai, Produto produto) throws ControllerException {
		super(ctrlPai);
		if(produto == null)
			throw new ControllerException("Não posso iniciar a funcionalidade de Alteração do Cliente sem ter o objeto");
		this.produtoParaAlterar = produto;		
		janela.exibirProduto(this.produtoParaAlterar);
	}
	
	//------------------------------------------------------------------------//

	public void iniciar() {
		janela = new JanelaProduto(this);
		janela.setVisible(true);
	}

	//------------------------------------------------------------------------//

	public void efetivarOperacaoEmProduto(String codigoDeBarras, String nome, float precoAtual) {
		try {
			this.produtoParaAlterar.setCodigoDeBarras(codigoDeBarras);
			this.produtoParaAlterar.setNome(nome);
			this.produtoParaAlterar.setPrecoAtual(precoAtual);

			// Garantindo a persistência do objeto
			DaoProduto dao = new DaoProduto();
			DaoProduto.alterarProduto(this.produtoParaAlterar);
			dao.armazenarObjetos();

			this.encerrar();
		} catch (Exception e1) {
			janela.notificar(e1.getMessage());
		}

	}

	//------------------------------------------------------------------------//

	public void encerrar() {
		this.janela.setVisible(false);
		this.notificarEncerramentoAoCtrlPai();
	}
}

