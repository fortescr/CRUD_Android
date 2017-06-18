package com.fortes.model;

import java.io.Serializable;

/**
 * Created by  Rodrigo Fortes
 */

public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    private String email;
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String uf;

    public Contato() {
    }

    public Contato(int id, String nome, String email, String cep, String logradouro, String numero, String bairro, String complemento, String cidade, String uf) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Contato(String nome, String email, String cep, String logradouro, String numero, String bairro, String complemento, String cidade, String uf) {
        this.nome = nome;
        this.email = email;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
