package br.cspi.dao;
import br.cspi.model.Cliente_Usuario;
import br.cspi.model.Clientes;
import br.cspi.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {

//            ALTERAR
        public String alterer(Clientes cliente, Integer id) {
            try {
                Connection conn = ConectarBancoDados.conectarBancoDados();
                PreparedStatement stmt = conn.prepareStatement("UPDATE clientes SET nome = ?, telefone = ?, cpf = ?, endereco = ? WHERE id = ?"
                );

                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getTelefone());
                stmt.setString(3,cliente.getCpf());
                stmt.setString(4, cliente.getEndereco());
                stmt.setInt(5, id);


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
                PreparedStatement stmt = conn.prepareStatement("delete from clientes where id = ?"
                );

                stmt.setInt(1, id);
                stmt.execute();

                if(stmt.getUpdateCount()<=0){
                    return "Nenhuem cliente exculuido";
                }


            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);

            }
            return "Excluido com sucesso";
        }

//            INSERIR
        public String inserir(Clientes cliente) {
            //conecta com banco
            //monta sql inserir
            //executa sql

            try {
                Connection conn = ConectarBancoDados.conectarBancoDados();
                PreparedStatement stmt = conn.prepareStatement("insert into clientes(nome, telefone,cpf, endereco, cliente_usuario_id) values(?, ?, ?, ?, ?)"
                );

                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getTelefone());
                stmt.setString(3, cliente.getCpf());
                stmt.setString(4, cliente.getEndereco());
                stmt.setInt(5, cliente.getCliente_usuario_id());

                stmt.execute();


            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("Erro ao inserir");
                throw new RuntimeException(e);


            }

            return "Inserido com Sucesso";
        }



//            GET Clientes
public ArrayList<Clientes> getClientes(int id) {
    ArrayList<Clientes> clientes = new ArrayList<>();


    try {
        Connection conn = ConectarBancoDados.conectarBancoDados();

        String sql = "SELECT * FROM clientes WHERE cliente_usuario_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id); // Aqui passamos o valor do id com segurança

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Clientes c = new Clientes();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setTelefone(rs.getString("telefone"));
            c.setCpf(rs.getString("cpf"));
            c.setEndereco(rs.getString("endereco"));
            c.setCliente_usuario_id(rs.getInt("cliente_usuario_id"));
            c.setData_criacao(rs.getTimestamp("data_criacao"));

            clientes.add(c);
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

    for (Clientes cliente : clientes) {
        System.out.println(cliente.getNome());
    }

    return clientes;
}

    public Clientes buscarUsuario(int id) {

        Clientes c = new Clientes();

        try {
            Connection conn = ConectarBancoDados.conectarBancoDados();

            String sql = "SELECT * FROM clientes WHERE cliente_usuario_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id); //
            ResultSet rs = stmt.executeQuery();

            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setTelefone(rs.getString("telefone"));
            c.setCpf(rs.getString("cpf"));
            c.setEndereco(rs.getString("endereco"));
            c.setCliente_usuario_id(rs.getInt("cliente_usuario_id"));
            c.setData_criacao(rs.getTimestamp("data_criacao"));



        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);

        }

        return c;
    }



}

