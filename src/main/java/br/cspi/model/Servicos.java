package br.cspi.model;

import java.util.Date;

public class Servicos {

    private int id;
    private String nome;
    private String descricao;
    private double valor;
    private int cliente_usuario_id;

    /// GET & SET  ///

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCliente_usuario_id() {
        return cliente_usuario_id;
    }

    public void setCliente_usuario_id(int cliente_usuario_id) {
        this.cliente_usuario_id = cliente_usuario_id;
    }


    /// //////////////////////////// ///


}
