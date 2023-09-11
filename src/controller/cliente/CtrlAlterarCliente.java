package controller.cliente;

import controller.AbstractCtrl;
import controller.ControllerException;
import model.Cliente;
import model.dao.DaoCliente;
import viewer.JanelaCliente;

public class CtrlAlterarCliente extends AbstractCtrlCliente {
	
	private JanelaCliente janela;
	final private Cliente clienteParaAlterar;

	//------------------------------------------------------------------------//

	public CtrlAlterarCliente(AbstractCtrl ctrlPai, Cliente cliente) throws ControllerException {
		super(ctrlPai);
		if(cliente == null)
			throw new ControllerException("Não posso iniciar a funcionalidade de Alteração do Cliente sem ter o objeto");
		this.clienteParaAlterar = cliente;		
		janela.exibirCliente(this.clienteParaAlterar);
	}
	
	//------------------------------------------------------------------------//

	public void iniciar() {
		janela = new JanelaCliente(this);
		janela.setVisible(true);
	}

	//------------------------------------------------------------------------//

	public void efetivarOperacaoEmCliente(String cpf, String nome, String endereco, String telefone) {
		try {
			this.clienteParaAlterar.setCpf(cpf);
			this.clienteParaAlterar.setNome(nome);
			this.clienteParaAlterar.setEndereco(endereco);
			this.clienteParaAlterar.setTelefone(telefone);;

			// Garantindo a persistência do objeto
			DaoCliente dao = new DaoCliente();
			DaoCliente.alterarCliente(this.clienteParaAlterar);
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

