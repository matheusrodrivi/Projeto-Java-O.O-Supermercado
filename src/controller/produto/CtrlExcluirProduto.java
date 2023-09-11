package controller.produto;

import controller.AbstractCtrl;
import controller.ControllerException;
import model.Produto;
import model.dao.DaoProduto;
import viewer.JanelaProduto;

public class CtrlExcluirProduto extends AbstractCtrlProduto {
	
	private JanelaProduto janela;
	final private Produto produtoParaExcluir;

	public CtrlExcluirProduto(AbstractCtrl ctrlPai, Produto produto) throws ControllerException {
		super(ctrlPai);
		if(produto == null)
			throw new ControllerException("Não posso iniciar a funcionalidade de Exclusão do Cliente sem ter o objeto");
		this.produtoParaExcluir = produto;		
		janela.exibirProduto(this.produtoParaExcluir);
		janela.inabilitarCampos();
		janela.colocarMsgDeExclusao();
	}
	
	public void iniciar() {
		// O caso de uso Alterar Produto começa abrindo a janela
		// para o preenchimento dos dados da nova pessoa
		janela = new JanelaProduto(this);
		janela.setVisible(true);
	}

	public void efetivarOperacaoEmProduto(String codigoDeBarras, String nome, float precoAtual) {
		try {
			// Garantindo a persistência do objeto
			DaoProduto dao = new DaoProduto();
			DaoProduto.excluirProduto(this.produtoParaExcluir);
			dao.armazenarObjetos();

			this.encerrar();
		} catch (Exception e1) {
			janela.notificar(e1.getMessage());
		}

	}

	public void encerrar() {
		this.janela.setVisible(false);
		this.notificarEncerramentoAoCtrlPai();
	}
}
