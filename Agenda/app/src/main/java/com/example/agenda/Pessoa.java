package com.example.agenda;

public class Pessoa {

    int codigo;
    private String Nome;
    private String celular;
    private String valor;
    private String CPF;


    public Pessoa(int codigo, String nome, String celular, String valor, String CPF) {
        this.codigo = codigo;
        this.Nome = nome;
        this.celular = celular;
        this.valor = valor;
        this.CPF = CPF;
    }

    public Pessoa() {

    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getEmail() {
        return CPF;
    }

    public void setEmail(String CPF) {
        this.CPF = CPF;
    }

    public void setCPF(String string) {
    }



    public int getCPF() {
        return 0;
    }

}
