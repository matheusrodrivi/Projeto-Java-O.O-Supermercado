package model;

import java.io.Serializable;

public class Cliente implements Serializable {
	// Constantes
	final public static int TAM_CPF = 14;
	final public static int TAM_MIN_NOME = 2;
	final public static int TAM_MAX_NOME = 40;
    final public static int TAM_ENDERECO = 50;
    final public static int TAM_TELEFONE = 14;

	// Atributos
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;

    // Construtor
    public Cliente(String cpf, String nome, String endereco, String telefone) throws Exception {
        this.setCpf(cpf);
        this.setNome(nome);
        this.setEndereco(endereco);
        this.setTelefone(telefone);
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) throws Exception {
    	Cliente.validarCpf(cpf);
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) throws Exception {
    	Cliente.validarNome(nome);
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) throws Exception {
        Cliente.validarEndereco(endereco);
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) throws Exception {
        Cliente.validarTelefone(telefone);
        this.telefone = telefone;
    }
    
    // Validações
    public static void validarCpf(String cpf) throws Exception {
		if(cpf == null)
			throw new Exception("O cpf não pode ser nulo!");
		if(cpf.length() != TAM_CPF)
			throw new Exception("O cpf deve ter " + TAM_CPF + " caracteres!");
		for(int i = 0; i < TAM_CPF; i++) {
			char c = cpf.charAt(i);
			switch(i) {
				case 3:
				case 7: 
					if(c != '.')
						throw new Exception("Na posição " + i + " deve aparecer um '.' no cpf!");
					break;
				case 11:
					if(c != '-')
						throw new Exception("Na posição " + i + " deve aparecer um '-' no cpf!");;
					break;
				default: 
					if(!Character.isDigit(c))
						throw new Exception("Na posição " + i + " deve aparecer dígito !");;
			}
		}
	}
    
    public static void validarNome(String nome) throws Exception {
		if(nome == null)
			throw new Exception("O nome não pode ser nulo!");
		if(nome.length() < TAM_MIN_NOME || nome.length() > TAM_MAX_NOME)
			throw new Exception("O nome deve ter entre " + TAM_MIN_NOME + " e " + TAM_MAX_NOME + " caracteres!");
		for(int i = 0; i < nome.length(); i++) {
			char c = nome.charAt(i);
			if( !Character.isAlphabetic(c) && !Character.isSpaceChar(c))
				throw new Exception("O nome deve ter conter somentes letras e espaço em branco!");
		}
	}

    public static void validarEndereco(String endereco) throws Exception {
        if(endereco == null)
            throw new Exception("O endereço não pode ser nulo!");
        if(endereco.length() > TAM_ENDERECO)
            throw new Exception("O endereço deve ter no máximo " + TAM_ENDERECO + " caracteres!");
    }

    public static void validarTelefone(String telefone) throws Exception {
        if(telefone == null)
            throw new Exception("O telefone não pode ser nulo!");
        if(telefone.length() != TAM_TELEFONE)
            throw new Exception("O telefone deve ter " + TAM_TELEFONE + " caracteres!");
        for(int i = 0; i < TAM_TELEFONE; i++) {
            char c = telefone.charAt(i);
            switch(i) {
                case 0:
                    if(c != '(')
                        throw new Exception("Na posição " + i + " deve aparecer um '(' no telefone!");
                    break;
                case 3:
                    if(c != ')')
                        throw new Exception("Na posição " + i + " deve aparecer um ')' no telefone!");
                    break;
                case 9:
                    if(c != '-')
                        throw new Exception("Na posição " + i + " deve aparecer um '-' no telefone!");
                    break;
                default:
                    if(!Character.isDigit(c))
                        throw new Exception("Na posição " + i + " deve aparecer dígito !");
            }
        }
    }

    // Métodos
    public String toString() {
        return this.getNome() + " - " + this.getCpf() + " - " + this.getEndereco() + " - " + this.getTelefone();
    }
}
