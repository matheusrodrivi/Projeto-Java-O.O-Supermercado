package controller;

abstract public class AbstractCtrl {

	// ATRIBUTOS
	final private AbstractCtrl ctrlPai;
	private AbstractCtrl ctrlFilho;
	
	// MÉTODOS
	public AbstractCtrl(AbstractCtrl ctrlPai) {
		super();
		this.ctrlPai = ctrlPai;
		if(ctrlPai != null)
			ctrlPai.iniciarCtrlFilho(this);
		else
			this.iniciar();
	}

	//------------------------------------------------------------------------//

	final public AbstractCtrl getCtrlPai() {
		return this.ctrlPai;
	}
	
	//------------------------------------------------------------------------//

	public AbstractCtrl getCtrlFilho() {
		return ctrlFilho;
	}

	//------------------------------------------------------------------------//

	private void iniciarCtrlFilho(AbstractCtrl ctrlFilho) {
		if(this.ctrlFilho == null) {
			this.ctrlFilho = ctrlFilho;
			this.ctrlFilho.iniciar();
		}
	}

	//------------------------------------------------------------------------//

	private void encerrarCtrlFilho(AbstractCtrl ctrl) {
		if(this.ctrlFilho == ctrl)
			this.ctrlFilho = null;
	}

	//------------------------------------------------------------------------//

	public void notificarEncerramentoAoCtrlPai() {
		this.ctrlPai.encerrarCtrlFilho(this);
		this.ctrlPai.retomarExecucao();
	}
	
	//------------------------------------------------------------------------//

	abstract public void iniciar();

	//------------------------------------------------------------------------//

	abstract public void encerrar();

	//------------------------------------------------------------------------//

	public void retomarExecucao() {
	};
}
