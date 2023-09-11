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
import controller.compra.CtrlIncluirCompra;
import controller.produto.AbstractCtrlProduto;
import controller.produto.CtrlIncluirProduto;
import model.Cliente;
import model.Produto;
import model.dao.DaoProduto;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class JanelaItemCompra extends AbstractViewer {
    // String nome, float precoAtual
	private JPanel     contentPane;
	JComboBox<Produto> cbProduto;
	private JTextField tfQuantidade;
	
	/**
	 * Create the frame.
	 */
	public JanelaItemCompra(CtrlIncluirCompra meuCtrl) {
		super(meuCtrl);
        setResizable(false);
		// Add icon image
		ImageIcon imgIcon = new ImageIcon("assets\\icon.png");
		setIconImage(imgIcon.getImage());
		
		setTitle("Adicionar Item");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 309, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Produto");
		lblNewLabel.setBounds(10, 31, 49, 14);
		contentPane.add(lblNewLabel);
        
		cbProduto = new JComboBox<Produto>();
		cbProduto.setBounds(105, 27, 179, 22);
		contentPane.add(cbProduto);

        for (Produto produto : DaoProduto.getProdutos()) {
            cbProduto.addItem(produto);
        }
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade");
		lblNewLabel_1.setBounds(10, 74, 120, 14);
		contentPane.add(lblNewLabel_1);
		
		tfQuantidade = new JTextField();
		tfQuantidade.setBounds(105, 71, 179, 20);
		contentPane.add(tfQuantidade);
		tfQuantidade.setColumns(10);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto produto  = (Produto)cbProduto.getSelectedItem();
				String aux = tfQuantidade.getText();
                int quantidade = 0;

                try {
                    quantidade = Integer.parseInt(aux);
                } 
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Preço inválido");
                    return;
                }
							
				meuCtrl.adicionarItem(produto, quantidade);
			}
		});
		btOk.setBounds(10, 118, 89, 23);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				meuCtrl.fechar();
			}
		});
		btCancelar.setBounds(195, 118, 89, 23);
		contentPane.add(btCancelar);
	}
}


