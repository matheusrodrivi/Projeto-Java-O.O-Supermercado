package viewer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.AbstractCtrl;

public class AbstractViewer extends JFrame {
	
	final private AbstractCtrl meuControlador;
	
	public AbstractViewer(AbstractCtrl meuControlador) {
		this.meuControlador = meuControlador;
	}

	public AbstractCtrl getMeuControlador() {
		return this.meuControlador;
	}
	
	public void notificar(String txt) {
		JOptionPane.showMessageDialog(null, txt);		
	}

	public boolean perguntar(String txt) {
		Object[] options = {"Sim", "Não"};
		int resposta = JOptionPane.showOptionDialog(null, txt, "Confirmation",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		return (resposta == JOptionPane.YES_OPTION);
	}
}

