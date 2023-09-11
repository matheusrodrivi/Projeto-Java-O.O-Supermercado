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

import controller.cliente.CtrlManterClientes;
import model.Cliente;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaManterCliente extends AbstractViewer {

	private JPanel                      contentPane;
	private DefaultListModel<Cliente>   listaObjetos;
	private JList<Cliente>              lstClientes; 

	/**
	 * Create the frame.
	 */
	public JanelaManterCliente(CtrlManterClientes ctrl) {
		super(ctrl);
        setResizable(false);
		// Add icon image
		ImageIcon imgIcon = new ImageIcon("assets\\icon.png");
		setIconImage(imgIcon.getImage());

		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		lstClientes = new JList<Cliente>();
		lstClientes.setBounds(24, 11, 382, 191);
		contentPane.add(lstClientes);

        // add scroll to lstClientes
        JScrollPane scrollPane = new JScrollPane(lstClientes);
        scrollPane.setBounds(24, 11, 382, 191);
        contentPane.add(scrollPane);
		
		JButton btIncluir = new JButton("Incluir");
		btIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlManterClientes ctrl = (CtrlManterClientes)getMeuControlador();
				ctrl.iniciarIncluirCliente();
			}
		});
		btIncluir.setBounds(24, 213, 89, 30);
		contentPane.add(btIncluir);
		
		JButton btAlterar = new JButton("Alterar");
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente selecionado = (Cliente) lstClientes.getSelectedValue();
				if(selecionado == null) {
					JOptionPane.showMessageDialog(null, "Selecione um cliente");
					return;
				}
				CtrlManterClientes ctrl = (CtrlManterClientes)getMeuControlador();
				ctrl.iniciarAlterarCliente(selecionado);
			}
		});
		btAlterar.setBounds(123, 213, 89, 30);
		contentPane.add(btAlterar);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente selecionado = (Cliente) lstClientes.getSelectedValue();
				if(selecionado == null) {
					JOptionPane.showMessageDialog(null, "Selecione um cliente");
					return;
				}
				CtrlManterClientes ctrl = (CtrlManterClientes)getMeuControlador();
				ctrl.iniciarExcluirCliente(selecionado);
			}
		});
		btExcluir.setBounds(222, 213, 89, 30);
		contentPane.add(btExcluir);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlManterClientes ctrl = (CtrlManterClientes)getMeuControlador();
				ctrl.encerrar();
			}
		});
		btSair.setBounds(321, 213, 89, 30);
		contentPane.add(btSair);
	}
	
	public void exibirClientes(Cliente[] conjClientes) {
		this.listaObjetos = new DefaultListModel<Cliente>();
		for(int i = 0; i < conjClientes.length; i++)
			this.listaObjetos.addElement(conjClientes[i]);
		this.lstClientes.setModel(this.listaObjetos);
	}
}
