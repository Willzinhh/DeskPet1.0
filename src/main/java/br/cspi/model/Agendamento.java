package br.cspi.model;

import java.sql.Timestamp;

public class Agendamento {

    private int id;
    private int pet_id;
    private int tutor_id;
    private int servico_id;
    private Timestamp data_hora;
    private double valor;
    private boolean pagamento_efetuado;
    private String status;
    private int cliente_usuario_id;


    /// GET & SET  ///
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public int getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(int tutor_id) {
        this.tutor_id = tutor_id;
    }

    public int getServico_id() {
        return servico_id;
    }

    public void setServico_id(int servico_id) {
        this.servico_id = servico_id;
    }

    public Timestamp getData_hora() {
        return data_hora;
    }

    public void setData_hora(Timestamp data_hora) {
        this.data_hora = data_hora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isPagamento_efetuado() {
        return pagamento_efetuado;
    }

    public void setPagamento_efetuado(boolean pagamento_efetuado) {
        this.pagamento_efetuado = pagamento_efetuado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCliente_usuario_id() {
        return cliente_usuario_id;
    }

    public void setCliente_usuario_id(int cliente_usuario_id) {
        this.cliente_usuario_id = cliente_usuario_id;
    }

    /// //////////////////////////// ///
}
