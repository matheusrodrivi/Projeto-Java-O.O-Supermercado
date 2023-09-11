package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrlPrograma;

public class JanelaPrincipal extends AbstractViewer {

	private JPanel 		  contentPane;

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal(CtrlPrograma meuCtrl) {
		super(meuCtrl);
		setResizable(false);
		// Add icon image
		ImageIcon imgIcon = new ImageIcon("assets\\icon.png");
		setIconImage(imgIcon.getImage());
		
		setTitle("Supermercado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btCliente = new JButton("Cliente");
		btCliente.setFocusable(false);
		btCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlPrograma ctrl = (CtrlPrograma)getMeuControlador();
				ctrl.iniciarManterClientes();
			}
		});
		btCliente.setBounds(37, 79, 89, 38);
		contentPane.add(btCliente);
		
		JButton btCompra = new JButton("Compra");
		btCompra.setFocusable(false);
		btCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlPrograma ctrl = (CtrlPrograma)getMeuControlador();
				ctrl.iniciarIncluirCompra();
			}
		});
		btCompra.setBounds(160, 79, 89, 38);
		contentPane.add(btCompra);
		
		JButton btProduto = new JButton("Produto");
		btProduto.setFocusable(false);
		btProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlPrograma ctrl = (CtrlPrograma)getMeuControlador();
				ctrl.iniciarManterProdutos();
			}
		});
		btProduto.setBounds(283, 79, 89, 38);
		contentPane.add(btProduto);
		
		JButton btSair = new JButton("Sair");
		btSair.setFocusable(false);
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlPrograma ctrl = (CtrlPrograma)getMeuControlador();
				ctrl.encerrar();
			}
		});
		btSair.setBounds(160, 167, 89, 29);
		contentPane.add(btSair);
	}
}

