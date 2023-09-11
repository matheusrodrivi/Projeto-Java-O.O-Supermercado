package model.dao;

import java.util.ArrayList;

import model.Compra;

public class DaoCompra extends AbstractDao {
    // Atributos estáticos
    private static ArrayList<Compra> compras = new ArrayList<Compra>();

    // Métodos
    // Inclui uma lista de compras na lista estática
    public static void incluirCompras(Compra[] novaLista) throws Exception {
        for (int i = 0; i < novaLista.length; i++) {
            DaoCompra.compras.add(novaLista[i]);
        }
    }

    // Inclui compra na lista estática
    public static void incluirCompra(Compra novaCompra) throws Exception {
        DaoCompra.compras.add(novaCompra);
    }

    // Retorna uma cópia da lista de compras
    public static Compra[] getCompras() {
        Compra[] copia = new Compra[DaoCompra.getNumCompras()];
        for(int i = 0; i < copia.length; i++)
            copia[i] = DaoCompra.getCompraIndice(i);
        return copia;
    }

    // Retorna o número de compras cadastradas
    public static int getNumCompras() {
        return DaoCompra.compras.size();
    }

    // Retorna a compra de um determinado índice
    public static Compra getCompraIndice(int indice) {
        return DaoCompra.compras.get(indice);
    }

    // Retorna a compra de uma determinada nota fiscal
    public static Compra getCompraNotaFiscal(String notaFiscal) {
        for (Compra compra : DaoCompra.compras) {
            if (compra.getNotaFiscal().equals(notaFiscal)) {
                return compra;
            }
        }
        return null;
    }

    // Exclui uma compra
    public static void excluirCompra(Compra compra) throws Exception {
        if (DaoCompra.compras.contains(compra))
            DaoCompra.compras.remove(compra);
        else
            throw new Exception("Compra não encontrada!");
    }
}
