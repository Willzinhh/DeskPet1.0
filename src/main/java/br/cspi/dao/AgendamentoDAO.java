package br.cspi.dao;

import br.cspi.model.Agendamento;
import br.cspi.model.Clientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AgendamentoDAO {


    //            ALTERAR
    public String alterer(Agendamento agendamento, Integer id) {
        try {
            Connection conn = ConectarBancoDados.conectarBancoDados();
            PreparedStatement stmt = conn.prepareStatement("UPDATE agendamento SET pet_id = ?, tutor_id = ?, servico_id = ?, data_hora = ?, valor = ?, pagamento_efetuado = ?, status = ? WHERE id = ?"
            );

            stmt.setInt(1, agendamento.getPet_id());
            stmt.setInt(2, agendamento.getTutor_id());
            stmt.setInt(3, agendamento.getServico_id());
            stmt.setTimestamp(4, agendamento.getData_hora());
            stmt.setDouble(5, agendamento.getValor());
            stmt.setBoolean(6, agendamento.isPagamento_efetuado());
            stmt.setString(7, agendamento.getStatus());
            stmt.setInt(8, id);


            stmt.execute();


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);

        }

        return "Alterado com Sucesso";
    }

    //            EXCLUIR
    public String excluir(int id) {
        try {

//
            Connection conn = ConectarBancoDados.conectarBancoDados();
            PreparedStatement stmt = conn.prepareStatement("delete from agendamento where id = ?"
            );

            stmt.setInt(1, id);
            stmt.execute();

            if(stmt.getUpdateCount()<=0){
                return "Nenhuem Agendamento exculuido";
            }


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);

        }
        return "Excluido com sucesso";
    }

    //            INSERIR
    public String inserir(Agendamento agendamento) {
        //conecta com banco
        //monta sql inserir
        //executa sql

        try {
            Connection conn = ConectarBancoDados.conectarBancoDados();
            PreparedStatement stmt = conn.prepareStatement("insert into agendamento(pet_id, tutor_id, servico_id, data_hora, valor, pagamento_efetuado, status) values(?, ?, ?, ?, ?, ?, ?)"
            );

            stmt.setInt(1, agendamento.getPet_id());
            stmt.setInt(2, agendamento.getTutor_id());
            stmt.setInt(3, agendamento.getServico_id());
            stmt.setTimestamp(4, agendamento.getData_hora());
            stmt.setDouble(5, agendamento.getValor());
            stmt.setBoolean(6, agendamento.isPagamento_efetuado());
            stmt.setString(7, agendamento.getStatus());

            stmt.execute();


        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao inserir");
            throw new RuntimeException(e);


        }

        return "Inserido com Sucesso";
    }



    //            GET Agendamentos
    public ArrayList<Agendamento> getAgendamentos(int id) {
        ArrayList<Agendamento> agendamentos = new ArrayList<>();


        try {
            Connection conn = ConectarBancoDados.conectarBancoDados();

            String sql = "SELECT * FROM agendamento WHERE cliente_usuario_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id); // Aqui passamos o valor do id com segurança

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Agendamento a  = new Agendamento();

                a.setPet_id(rs.getInt("pet_id"));
                a.setTutor_id(rs.getInt("tutor_id"));
                a.setServico_id(rs.getInt("servico_id"));
                a.setData_hora(rs.getTimestamp("data_hora"));
                a.setValor(rs.getDouble("valor"));
                a.setPagamento_efetuado(rs.getBoolean("pagamento_efetuado"));
                a.setStatus(rs.getString("status"));

                agendamentos.add(a);

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro ao conectar");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao conectar");
            ex.printStackTrace();
        }


        return agendamentos;
    }
}
