package controller.compra;

import java.lang.reflect.Array;
import java.util.ArrayList;

import controller.AbstractCtrl;
import controller.CtrlPrograma;
import model.Cliente;
import model.Compra;
import model.ItemCompra;
import model.Produto;
import model.dao.DaoCompra;
import viewer.JanelaCompra;
import viewer.JanelaItemCompra;

public class CtrlIncluirCompra extends AbstractCtrl {
	//
	// ATRIBUTOS
	//
	private JanelaCompra janela;
    private JanelaItemCompra janelaItem;
    private ArrayList<ItemCompra> itens = new ArrayList<ItemCompra>();

	//
	// MÉTODOS
	//
	
	//------------------------------------------------------------------------//

	public CtrlIncluirCompra(CtrlPrograma ctrlPai) {
		super(ctrlPai);
	}

	//------------------------------------------------------------------------//

	public void iniciar() {
		// O caso de uso Incluir Compra começa abrindo a janela
		// para o preenchimento dos dados da nova pessoa
		janela = new JanelaCompra(this);
		janela.setVisible(true);
	}

	//------------------------------------------------------------------------//

	public void incluirCompra(Cliente cliente) {
		try {
			// Perguntar se o cliente vai querer CPF na nota fiscal
			boolean cpfNaNota = janela.perguntar("Deseja CPF na nota fiscal?");

            // Gerar nota fiscal
            float total = 0;
            String notaFiscal = "==========NOTA FISCAL==========\n";
            notaFiscal += "Cliente: " + cliente.getNome() + "\n";
			if (cpfNaNota)
            	notaFiscal += "CPF: " + cliente.getCpf() + "\n";
            notaFiscal += "-------------------------------\n";
            notaFiscal += "ITENS:\n";
            for (ItemCompra item : itens) {
                total += item.getProduto().getPrecoAtual() * item.getQuantidade();
                notaFiscal += item + "\n";
            }
			notaFiscal += String.format("\n TOTAL: R$ %.2f\n", total);
            notaFiscal += "===============================\n";


			Compra c = new Compra(notaFiscal, cliente, itens);
			janela.notificar(notaFiscal);
			
			DaoCompra dao = new DaoCompra();
			DaoCompra.incluirCompra(c);
			dao.armazenarObjetos();
			
			this.encerrar();
		} catch (Exception e1) {
			janela.notificar(e1.getMessage());
		}
	}

    public void adicionarItem(Produto produto, int quantidade) {
        try {
            ItemCompra item = new ItemCompra(quantidade, produto);
            itens.add(item);
            janela.exibirItens(itens.toArray(new ItemCompra[itens.size()]));
            janela.notificar("Item adicionado com sucesso!");
            janelaItem.dispose();
        } 
        catch (Exception e1) {
            janela.notificar(e1.getMessage());
        }
    }

    public void abrirJanelaItem() {
        janelaItem = new JanelaItemCompra(this);
        janelaItem.setVisible(true);
    }

    public void fechar() {
        janelaItem.dispose();
    }

	//------------------------------------------------------------------------//

	public void encerrar() {
		this.janela.setVisible(false);
		this.notificarEncerramentoAoCtrlPai();
	}
}
