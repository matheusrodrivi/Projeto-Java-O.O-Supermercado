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
import controller.produto.AbstractCtrlProduto;
import controller.produto.CtrlIncluirProduto;
import model.Produto;
import model.dao.DaoProduto;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class JanelaProduto extends AbstractViewer {
    // String nome, float precoAtual
	private JPanel     contentPane;
	private JTextField tfNome;
	private JTextField tfPreco;
	
	/**
	 * Create the frame.
	 */
	public JanelaProduto(AbstractCtrlProduto meuCtrl) {
		super(meuCtrl);
        setResizable(false);
		// Add icon image
		ImageIcon imgIcon = new ImageIcon("assets\\icon.png");
		setIconImage(imgIcon.getImage());
		
		setTitle("Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(38, 14, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfNome = new JTextField();
		tfNome.setBounds(84, 11, 193, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Preço:");
		lblNewLabel_1.setBounds(38, 54, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfPreco = new JTextField();
		tfPreco.setBounds(84, 51, 193, 20);
		contentPane.add(tfPreco);
		tfPreco.setColumns(10);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome  = tfNome.getText();
				String aux = tfPreco.getText();
                float preco = 0;

                try {
                    preco = Float.parseFloat(aux);
                } 
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Preço inválido");
                    return;
                }
				
				AbstractCtrlProduto meuControlador = (AbstractCtrlProduto)getMeuControlador();				
				meuControlador.efetivarOperacaoEmProduto("", nome, preco);
			}
		});
		btOk.setBounds(38, 118, 89, 23);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbstractCtrlProduto meuControlador = (AbstractCtrlProduto)getMeuControlador();				
				meuControlador.encerrar();
			}
		});
		btCancelar.setBounds(188, 118, 89, 23);
		contentPane.add(btCancelar);
	}
	
	/**
	 * Pega um objeto Cliente e o exibe na Janela
	 * @param a referência para o Cliente a ser exibido
	 */
	public void exibirProduto(Produto c) {
		this.tfNome.setText(c.getNome());
		this.tfPreco.setText(Float.toString(c.getPrecoAtual()));
	}
	
	/**
	 * Inabilita os campos da janela
	 */
	public void inabilitarCampos() {
		this.tfNome.setEnabled(false);
		this.tfPreco.setEnabled(false);
	}
	
	/**
	 * Coloca a mensagem de exclusão na janela
	 */
	public void colocarMsgDeExclusao() {
		JLabel lblNewLabel_4 = new JLabel("Deseja excluir este produto?");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(38, 86, 239, 21);
		contentPane.add(lblNewLabel_4);
	}
}

