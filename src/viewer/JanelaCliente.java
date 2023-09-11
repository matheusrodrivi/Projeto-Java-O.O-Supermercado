package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.AbstractCtrl;
import controller.cliente.AbstractCtrlCliente;
import controller.cliente.CtrlIncluirCliente;
import model.Cliente;
import model.dao.DaoCliente;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class JanelaCliente extends AbstractViewer {
    // String cpf, String nome, String endereco, String telefone
	private JPanel     contentPane;
	private JTextField tfCpf;
	private JTextField tfNome;
	private JTextField tfEndereco;
	private JTextField tfTelefone;
	
	/**
	 * Create the frame.
	 */
	public JanelaCliente(AbstractCtrlCliente meuCtrl) {
		super(meuCtrl);
        setResizable(false);
		// Add icon image
		ImageIcon imgIcon = new ImageIcon("assets\\icon.png");
		setIconImage(imgIcon.getImage());
		
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(91, 29, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(185, 26, 159, 20);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(91, 68, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfNome = new JTextField();
		tfNome.setBounds(185, 65, 159, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Endereço:");
		lblNewLabel_2.setBounds(91, 110, 71, 14);
		contentPane.add(lblNewLabel_2);
		
		tfEndereco = new JTextField();
		tfEndereco.setBounds(185, 107, 159, 20);
		contentPane.add(tfEndereco);
		tfEndereco.setColumns(10);

        JLabel lblNewLabel_2_1 = new JLabel("Telefone:");
		lblNewLabel_2_1.setBounds(91, 149, 71, 14);
		contentPane.add(lblNewLabel_2_1);
		
		tfTelefone = new JTextField();
		tfTelefone.setColumns(10);
		tfTelefone.setBounds(185, 146, 159, 20);
		contentPane.add(tfTelefone);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf  = tfCpf.getText();
				String nome = tfNome.getText();
				String telefone = tfTelefone.getText();
				String endereco  = tfEndereco.getText();
				
				AbstractCtrlCliente meuControlador = (AbstractCtrlCliente)getMeuControlador();				
				meuControlador.efetivarOperacaoEmCliente(cpf, nome, endereco, telefone);
			}
		});
		btOk.setBounds(91, 216, 89, 23);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbstractCtrlCliente meuControlador = (AbstractCtrlCliente)getMeuControlador();				
				meuControlador.encerrar();
			}
		});
		btCancelar.setBounds(255, 216, 89, 23);
		contentPane.add(btCancelar);
	}
	
	/**
	 * Pega um objeto Cliente e o exibe na Janela
	 * @param a referência para o Cliente a ser exibido
	 */
	public void exibirCliente(Cliente c) {
		this.tfCpf.setText(c.getCpf());
		this.tfNome.setText(c.getNome());
		this.tfTelefone.setText(c.getTelefone());
		this.tfEndereco.setText(c.getEndereco());
	}
	
	/**
	 * Inabilita os campos da janela
	 */
	public void inabilitarCampos() {
		this.tfCpf.setEnabled(false);
		this.tfNome.setEnabled(false);
		this.tfTelefone.setEnabled(false);
		this.tfEndereco.setEnabled(false);
		
	}
	
	/**
	 * Coloca a mensagem de exclusão na janela
	 */
	public void colocarMsgDeExclusao() {
		JLabel lblNewLabel_4 = new JLabel("Deseja excluir este Cliente?");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(91, 184, 199, 21);
		contentPane.add(lblNewLabel_4);
	}
}
