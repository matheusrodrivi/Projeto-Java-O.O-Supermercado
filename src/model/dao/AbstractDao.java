package model.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Cliente;
import model.Compra;
import model.ItemCompra;
import model.Produto;

abstract public class AbstractDao {
    public static boolean objetosRecuperados = false;

    final public void armazenarObjetos() {
        try {
			FileOutputStream arquivo = new FileOutputStream("C:/Temp/Objetos.bin");
			ObjectOutputStream oos = new ObjectOutputStream(arquivo);
            
            // Serializando objetos
            oos.writeObject( DaoCliente.getClientes() );
            oos.writeObject( DaoCompra.getCompras() );
            oos.writeObject( DaoItemCompra.getItensCompra() );
            oos.writeObject( DaoProduto.getProdutos() );
			
			oos.close();
		}
        catch(Exception erro) {
            System.out.println("Erro ao serializar objetos: " + erro.getMessage());
        }
    }

    public static void recuperarObjetos() {
        if (objetosRecuperados == false) {
            try {
                FileInputStream arquivo = new FileInputStream("C:/Temp/Objetos.bin");
                ObjectInputStream ois = new ObjectInputStream(arquivo);

                // Deserializando objetos e armazenando-os nos ArrayLists
                DaoCliente.incluirClientes( (Cliente[]) ois.readObject() );
                DaoCompra.incluirCompras( (Compra[]) ois.readObject() );
                DaoItemCompra.incluirItensCompra( (ItemCompra[]) ois.readObject() );
                DaoProduto.incluirProdutos( (Produto[]) ois.readObject() );
                
                ois.close();
                
                objetosRecuperados = true;
            }
            catch(Exception erro) {
                System.out.println("Erro ao deserializar objetos: " + erro.getMessage());
            }
        }
    } 
}
