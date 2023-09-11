package model.dao;

import java.util.ArrayList;

import model.ItemCompra;

public class DaoItemCompra extends AbstractDao {
    // Atributos estáticos
    private static ArrayList<ItemCompra> itensCompra = new ArrayList<ItemCompra>();

    // Métodos
    // Inclui uma lista de itensCompra na lista estática
    public static void incluirItensCompra(ItemCompra[] novaLista) throws Exception {
        for (int i = 0; i < novaLista.length; i++) {
            DaoItemCompra.itensCompra.add(novaLista[i]);
        }
    }

    // Inclui um itemCompra na lista estática
    public static void incluirItemCompra(ItemCompra novoItemCompra) throws Exception {
        DaoItemCompra.itensCompra.add(novoItemCompra);
    }

    // Retorna uma cópia da lista de itensCompra
    public static ItemCompra[] getItensCompra() {
        ItemCompra[] copia = new ItemCompra[DaoItemCompra.getNumItensCompra()];
        for(int i = 0; i < copia.length; i++)
            copia[i] = DaoItemCompra.getItemCompraIndice(i);
        return copia;
    }

    // Retorna o número de itensCompra cadastrados
    public static int getNumItensCompra() {
        return DaoItemCompra.itensCompra.size();
    }

    // Retorna o itemCompra de um determinado índice
    public static ItemCompra getItemCompraIndice(int indice) {
        return DaoItemCompra.itensCompra.get(indice);
    }

    // Exclui um itemCompra
    public static void excluirItemCompra(ItemCompra itemCompra) throws Exception {
        if (DaoItemCompra.itensCompra.contains(itemCompra))
            DaoItemCompra.itensCompra.remove(itemCompra);
        else
            throw new Exception("ItemCompra não encontrado!");
    }
}
