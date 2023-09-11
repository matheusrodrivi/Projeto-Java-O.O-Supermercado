package controller.cliente;

import controller.AbstractCtrl;
import controller.ControllerException;
import controller.CtrlPrograma;
import model.Cliente;
import model.dao.DaoCliente;
import viewer.JanelaManterCliente;

public class CtrlManterClientes extends AbstractCtrl {
	
	private JanelaManterCliente janela;

	//------------------------------------------------------------------------//

	public CtrlManterClientes(CtrlPrograma ctrlPai) {
		super(ctrlPai);
	}

	//------------------------------------------------------------------------//

	public void iniciar() {
		janela = new JanelaManterCliente(this);
		this.atualizarListaDeClientes();
		janela.setVisible(true);
	}

	//------------------------------------------------------------------------//

	public void encerrar() {
		this.janela.setVisible(false);
		this.notificarEncerramentoAoCtrlPai();
	}
	
	//------------------------------------------------------------------------//

	public void atualizarListaDeClientes() {
		Cliente[] conjClientes;
		try {
			conjClientes = (Cliente[])DaoCliente.getClientes();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		janela.exibirClientes(conjClientes);		
	}
	
	//----------------------------------------------------------------------//

	public void retomarExecucao() {
		this.atualizarListaDeClientes();			
	}

	//----------------------------------------------------------------------//

	public void iniciarIncluirCliente() {
		new CtrlIncluirCliente(this);
	}

	//----------------------------------------------------------------------//

	public void iniciarAlterarCliente(Cliente selecionado) {
		try {
			new CtrlAlterarCliente(this, selecionado);
		} catch (ControllerException e) {
			e.printStackTrace();
		}
	}

	//----------------------------------------------------------------------//

	public void iniciarExcluirCliente(Cliente selecionado) {
		try {
			new CtrlExcluirCliente(this, selecionado);
		} catch (ControllerException e) {
			e.printStackTrace();
		}
	}

}
