package com.example.agenda;

public class Pessoa {

    private  int codigo;
    private String Nome;
    private  String celular;
    private String telefone;
    private String email;
    private String endereco;


    public Pessoa(int codigo, String nome, String celular, String telefone, String email, String endereco) {
        this.codigo = codigo;
        Nome = nome;
        this.celular = celular;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Pessoa(String nome, String celular, String telefone, String email, String endereco) {
        Nome = nome;
        this.celular = celular;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
