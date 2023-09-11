package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Compra implements Serializable {
    // Constantes
    final public static int TAM_NOTA_FISCAL = 13;

    // Atributos
    private String notaFiscal;
    private LocalDateTime data;
    private Cliente cliente;
    private ArrayList<ItemCompra> itens;

    // Construtor
    public Compra(String notaFiscal, Cliente cliente, ArrayList<ItemCompra> itens) throws Exception {
        this.setNotaFiscal(notaFiscal);
        this.setData();
        this.setCliente(cliente);
        this.setItens(itens);
    }

    // Getters e Setters
    public String getNotaFiscal() {
        return notaFiscal;
    }
    public void setNotaFiscal(String notaFiscal) throws Exception {
        this.notaFiscal = notaFiscal;
    }

    public LocalDateTime getData() {
        return data;
    }
    public void setData() throws Exception {
        this.data = LocalDateTime.now();
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) throws Exception {
        this.cliente = cliente;
    }

    public ArrayList<ItemCompra> getItens() {
        return itens;
    }
    public void setItens(ArrayList<ItemCompra> itens) throws Exception {
        this.itens = itens;
    }

    // Métodos
    public float getValorTotal() {
        float valorTotal = 0;
        for (ItemCompra item : this.getItens()) {
            valorTotal += item.getPrecoTotal();
        }
        return valorTotal;
    }
}
