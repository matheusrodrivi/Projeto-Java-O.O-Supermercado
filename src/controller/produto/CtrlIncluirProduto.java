package controller.produto;

import model.Produto;
import model.dao.DaoProduto;
import viewer.JanelaProduto;

public class CtrlIncluirProduto extends AbstractCtrlProduto {
	
	private JanelaProduto janela;

	//------------------------------------------------------------------------//

	public CtrlIncluirProduto(CtrlManterProdutos ctrlPai) {
		super(ctrlPai);
	}

	//------------------------------------------------------------------------//

	public void iniciar() {
		// O caso de uso Incluir Pessoa começa abrindo a janela
		// para o preenchimento dos dados da nova pessoa
		janela = new JanelaProduto(this);
		janela.setVisible(true);
	}

	//------------------------------------------------------------------------//

	public void efetivarOperacaoEmProduto(String codigoDeBarras, String nome, float precoAtual) {
		try {
			// Instanciando um objeto Produto
			if (DaoProduto.estaVazia())
				codigoDeBarras = "00000";
			else
				codigoDeBarras = String.format("%05d", Integer.parseInt(DaoProduto.getUltimoProduto().getCodigoDeBarras()) + 1);

			Produto c = new Produto(codigoDeBarras, nome, precoAtual);

			// Garantindo a persistência do objeto
			DaoProduto dao = new DaoProduto();
			DaoProduto.incluirProduto(c);
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


