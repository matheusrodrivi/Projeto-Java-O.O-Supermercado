package model;

import java.io.Serializable;

public class Produto implements Serializable{
    // Constantes
    final public static int TAM_CODIGO_DE_BARRAS = 5;
    final public static int TAM_MIN_NOME = 2;
    final public static int TAM_MAX_NOME = 40;

    // Atributos
    private String codigoDeBarras;
    private String nome;
    private float precoAtual;

    // Construtor
    public Produto(String codigoDeBarras, String nome, float precoAtual) throws Exception {
        this.setCodigoDeBarras(codigoDeBarras);
        this.setNome(nome);
        this.setPrecoAtual(precoAtual);
    }

    // Getters e Setters
    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }
    public void setCodigoDeBarras(String codigoDeBarras) throws Exception {
        Produto.validarCodigoDeBarras(codigoDeBarras);
        this.codigoDeBarras = codigoDeBarras;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) throws Exception {
        Produto.validarNome(nome);
        this.nome = nome;
    }

    public float getPrecoAtual() {
        return precoAtual;
    }
    public void setPrecoAtual(float precoAtual) throws Exception {
        Produto.validarPrecoAtual(precoAtual);
        this.precoAtual = precoAtual;
    }

    // Validações
    public static void validarCodigoDeBarras(String codigoDeBarras) throws Exception {
        if(codigoDeBarras == null)
            throw new Exception("Código de barras não pode ser nulo");
        if(codigoDeBarras.length() != TAM_CODIGO_DE_BARRAS)
            throw new Exception("Código de barras deve ter " + TAM_CODIGO_DE_BARRAS + " caracteres");
        for(int i = 0; i < codigoDeBarras.length(); i++) {
            if(!Character.isDigit(codigoDeBarras.charAt(i)))
                throw new Exception("Código de barras deve conter apenas dígitos");
        }
    }

    public static void validarNome(String nome) throws Exception {
        if(nome == null)
            throw new Exception("Nome não pode ser nulo");
        if(nome.length() < TAM_MIN_NOME)
            throw new Exception("Nome deve ter pelo menos " + TAM_MIN_NOME + " caracteres");
        if(nome.length() > TAM_MAX_NOME)
            throw new Exception("Nome deve ter no máximo " + TAM_MAX_NOME + " caracteres");
    }

    public static void validarPrecoAtual(float precoAtual) throws Exception {
        if(precoAtual < 0)
            throw new Exception("Preço atual não pode ser negativo");
    }

    // Métodos
    public String toString() {
        return this.getNome() + " - " + "R$ " + String.format("%.2f", this.getPrecoAtual()) + " - " + this.getCodigoDeBarras();
    }
}
