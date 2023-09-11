package controller.cliente;

import controller.AbstractCtrl;
import controller.ControllerException;
import model.Cliente;
import model.dao.DaoCliente;
import viewer.JanelaCliente;

public class CtrlExcluirCliente extends AbstractCtrlCliente {
	
	private JanelaCliente janela;
	final private Cliente clienteParaExcluir;

	public CtrlExcluirCliente(AbstractCtrl ctrlPai, Cliente cliente) throws ControllerException {
		super(ctrlPai);
		if(cliente == null)
			throw new ControllerException("Não posso iniciar a funcionalidade de Exclusão do Cliente sem ter o objeto");
		this.clienteParaExcluir = cliente;		
		janela.exibirCliente(this.clienteParaExcluir);
		janela.inabilitarCampos();
		janela.colocarMsgDeExclusao();
	}
	
	public void iniciar() {
		// O caso de uso Alterar Cliente começa abrindo a janela
		// para o preenchimento dos dados da nova pessoa
		janela = new JanelaCliente(this);
		janela.setVisible(true);
	}

	public void efetivarOperacaoEmCliente(String cpf, String nome, String endereco, String telefone) {
		try {
			// Garantindo a persistência do objeto
			DaoCliente dao = new DaoCliente();
			DaoCliente.excluirCliente(this.clienteParaExcluir);
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
