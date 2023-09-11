package controller.cliente;

import model.Cliente;

import model.dao.DaoCliente;
import viewer.JanelaCliente;

public class CtrlIncluirCliente extends AbstractCtrlCliente {
	
	private JanelaCliente janela;

	//------------------------------------------------------------------------//

	public CtrlIncluirCliente(CtrlManterClientes ctrlPai) {
		super(ctrlPai);
	}

	//------------------------------------------------------------------------//

	public void iniciar() {
		// O caso de uso Incluir Pessoa começa abrindo a janela
		// para o preenchimento dos dados da nova pessoa
		janela = new JanelaCliente(this);
		janela.setVisible(true);
	}

	//------------------------------------------------------------------------//

	public void efetivarOperacaoEmCliente(String cpf, String nome, String endereco, String telefone) {
		try {
			// Instanciando um objeto Cliente
			Cliente c = new Cliente(cpf, nome, endereco, telefone);

			// Garantindo a persistência do objeto
			DaoCliente dao = new DaoCliente();
			DaoCliente.incluirCliente(c);
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

