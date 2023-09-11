package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.compra.CtrlIncluirCompra;
import model.Cliente;
import model.Compra;
import model.ItemCompra;
import model.dao.DaoCliente;
import model.dao.DaoCompra;
import javax.swing.JComboBox;
import javax.swing.JList;

public class JanelaCompra extends AbstractViewer {

	private JPanel                         contentPane;
    private DefaultListModel<ItemCompra>   listaObjetos;
	private JList<ItemCompra>              lstItens;

	/**
	 * Create the frame.
	 */
	public JanelaCompra(CtrlIncluirCompra meuCtrl) {
		super(meuCtrl);
        setResizable(false);
		// Add icon image
		ImageIcon imgIcon = new ImageIcon("assets\\icon.png");
		setIconImage(imgIcon.getImage());

		setTitle("Compra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cliente:");
		lblNewLabel.setBounds(10, 25, 46, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox<Cliente> cbCliente = new JComboBox<Cliente>();
		cbCliente.setBounds(66, 21, 406, 22);
		contentPane.add(cbCliente);

        for (Cliente c : DaoCliente.getClientes()) {
            cbCliente.addItem(c);
        }

        lstItens = new JList<ItemCompra>();
		lstItens.setBounds(10, 50, 462, 168);
		contentPane.add(lstItens);

		// add scroll to lstItens
		JScrollPane scrollPane = new JScrollPane(lstItens);
		scrollPane.setBounds(10, 50, 462, 168);
		contentPane.add(scrollPane);
		
		JButton btOk = new JButton("Efetuar compra");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = (Cliente)cbCliente.getSelectedItem();
                
				CtrlIncluirCompra meuCtrl = (CtrlIncluirCompra)getMeuControlador();
				meuCtrl.incluirCompra(cliente);
			}
		});
		btOk.setBounds(175, 229, 132, 30);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlIncluirCompra meuCtrl = (CtrlIncluirCompra)getMeuControlador();
				meuCtrl.encerrar();
			}
		});
		btCancelar.setBounds(328, 229, 144, 30);
		contentPane.add(btCancelar);
		
		JButton btnNewButton = new JButton("Adicionar produto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                meuCtrl.abrirJanelaItem();
			}
		});
		btnNewButton.setBounds(10, 229, 144, 30);
		contentPane.add(btnNewButton);
	}

    public void exibirItens(ItemCompra[] conjItens) {
		this.listaObjetos = new DefaultListModel<ItemCompra>();
		for(int i = 0; i < conjItens.length; i++)
			this.listaObjetos.addElement(conjItens[i]);
		this.lstItens.setModel(this.listaObjetos);
	}
}
