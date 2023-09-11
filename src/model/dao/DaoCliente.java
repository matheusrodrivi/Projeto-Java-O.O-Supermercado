package model.dao;

import java.util.ArrayList;

import model.Cliente;

public class DaoCliente extends AbstractDao {
    // Atributos estáticos
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    // Métodos
    // Inclui uma lista de clientes na lista estática
    public static void incluirClientes(Cliente[] novaLista) throws Exception {
        for (int i = 0; i < novaLista.length; i++) {
            DaoCliente.clientes.add(novaLista[i]);
        }
    }

    // Inclui um cliente na lista estática
    public static void incluirCliente(Cliente novoCliente) throws Exception {
        DaoCliente.clientes.add(novoCliente);
    }

    // Retorna uma cópia da lista de clientes
    public static Cliente[] getClientes() {
        Cliente[] copia = new Cliente[DaoCliente.getNumClientes()];
		for(int i = 0; i < copia.length; i++)
			copia[i] = DaoCliente.getClienteIndice(i);
		return copia;
    }

    // Retorna o número de clientes cadastrados
    public static int getNumClientes() {
        return DaoCliente.clientes.size();
    }

    // Retorna o cliente de um determinado índice
    public static Cliente getClienteIndice(int indice) {
        return DaoCliente.clientes.get(indice);
    }

    // Retorna o cliente de um determinado CPF
    public static Cliente getClienteCpf(String cpf) {
        for (Cliente cliente : DaoCliente.clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    // Exclui um cliente
    public static void excluirCliente(Cliente cliente) {
        DaoCliente.clientes.remove(cliente);
    }

    // Altera um cliente
    public static void alterarCliente(Cliente clienteAntigo) throws Exception {
        if (!DaoCliente.clientes.contains(clienteAntigo))
            throw new Exception("Cliente não encontrado!");
    }
}
