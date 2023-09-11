package viewer;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.produto.CtrlManterProdutos;
import model.Produto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaManterProduto extends AbstractViewer {

	private JPanel                      contentPane;
	private DefaultListModel<Produto>   listaObjetos;
	private JList<Produto>              lstProdutos; 

	/**
	 * Create the frame.
	 */
	public JanelaManterProduto(CtrlManterProdutos ctrl) {
		super(ctrl);
        setResizable(false);
		// Add icon image
		ImageIcon imgIcon = new ImageIcon("assets\\icon.png");
		setIconImage(imgIcon.getImage());

		setTitle("Cadastro de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		lstProdutos = new JList<Produto>();
		lstProdutos.setBounds(24, 11, 382, 191);
		contentPane.add(lstProdutos);

		// add scroll to lstProdutos
		JScrollPane scrollPane = new JScrollPane(lstProdutos);
		scrollPane.setBounds(24, 11, 382, 191);
		contentPane.add(scrollPane);

		JButton btIncluir = new JButton("Incluir");
		btIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlManterProdutos ctrl = (CtrlManterProdutos)getMeuControlador();
				ctrl.iniciarIncluirProduto();
			}
		});
		btIncluir.setBounds(24, 213, 89, 30);
		contentPane.add(btIncluir);
		
		JButton btAlterar = new JButton("Alterar");
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto selecionado = (Produto) lstProdutos.getSelectedValue();
				if(selecionado == null) {
					JOptionPane.showMessageDialog(null, "Selecione um produto");
					return;
				}
				CtrlManterProdutos ctrl = (CtrlManterProdutos)getMeuControlador();
				ctrl.iniciarAlterarProduto(selecionado);
			}
		});
		btAlterar.setBounds(123, 213, 89, 30);
		contentPane.add(btAlterar);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto selecionado = (Produto) lstProdutos.getSelectedValue();
				if(selecionado == null) {
					JOptionPane.showMessageDialog(null, "Selecione um produto");
					return;
				}
				CtrlManterProdutos ctrl = (CtrlManterProdutos)getMeuControlador();
				ctrl.iniciarExcluirProduto(selecionado);
			}
		});
		btExcluir.setBounds(222, 213, 89, 30);
		contentPane.add(btExcluir);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlManterProdutos ctrl = (CtrlManterProdutos)getMeuControlador();
				ctrl.encerrar();
			}
		});
		btSair.setBounds(321, 213, 89, 30);
		contentPane.add(btSair);
	}
	
	public void exibirProdutos(Produto[] conjProdutos) {
		this.listaObjetos = new DefaultListModel<Produto>();
		for(int i = 0; i < conjProdutos.length; i++)
			this.listaObjetos.addElement(conjProdutos[i]);
		this.lstProdutos.setModel(this.listaObjetos);
	}
}

