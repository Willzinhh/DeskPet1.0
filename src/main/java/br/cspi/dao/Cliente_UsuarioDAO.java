package br.cspi.dao;
import br.cspi.model.Cliente_Usuario;
import br.cspi.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cliente_UsuarioDAO {

//            ALTERAR
        public String alterer(Cliente_Usuario clienteUsuario, Integer id) {
            try {
                Connection conn = ConectarBancoDados.conectarBancoDados();
                PreparedStatement stmt = conn.prepareStatement("UPDATE cliente_usuario SET nome = ?, cpf = ?,cnpj = ?, telefone = ?, endereco = ?, nome_empresa = ?, plano = ? WHERE id = ?"
                );

                stmt.setString(1, clienteUsuario.getNome());
                stmt.setString(2, clienteUsuario.getCpf());
                stmt.setString(3, clienteUsuario.getCnpj());
                stmt.setString(4, clienteUsuario.getTelefone());
                stmt.setString(5, clienteUsuario.getEndereco());
                stmt.setString(6, clienteUsuario.getNome_empresa());
                stmt.setString(7, clienteUsuario.getPlano());
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
                PreparedStatement stmt = conn.prepareStatement("delete from cliente_usuario where id = ?"
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
        public String inserir(Cliente_Usuario clienteUsuario) {
            //conecta com banco
            //monta sql inserir
            //executa sql

            try {
                Connection conn = ConectarBancoDados.conectarBancoDados();
                PreparedStatement stmt = conn.prepareStatement("insert into cliente_usuario(nome, cpf, cnpj, telefone, endereco, nome_empresa, plano) values(?, ?, ?, ?, ?, ?, ?)"
                );

                stmt.setString(1, clienteUsuario.getNome());
                stmt.setString(2, clienteUsuario.getCpf());
                stmt.setString(3, clienteUsuario.getCnpj());
                stmt.setString(4, clienteUsuario.getTelefone());
                stmt.setString(5, clienteUsuario.getEndereco());
                stmt.setString(6, clienteUsuario.getNome_empresa());
                stmt.setString(7, clienteUsuario.getPlano());

                stmt.execute();


            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("Erro ao inserir");
                throw new RuntimeException(e);


            }

            return "Inserido com Sucesso";
        }

//            GET Clientes
        public ArrayList<Cliente_Usuario> getClientes() {
            ArrayList<Cliente_Usuario> clienteUsuarios = new ArrayList<>();

            try {
                Connection conn = ConectarBancoDados.conectarBancoDados();

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * from cliente_usuario");

                while (rs.next()) {
                    Cliente_Usuario c = new Cliente_Usuario();
                    c.setId(rs.getInt("id"));
                    c.setNome(rs.getString("nome"));
                    c.setTelefone(rs.getString("telefone"));
                    c.setEndereco(rs.getString("endereco"));
                    c.setCpf(rs.getString("cpf"));

                    clienteUsuarios.add(c);

                }

            } catch (SQLException e) {
                System.out.println("Erro ao conectar");
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro ao conectar");
                ex.printStackTrace();
            }

            return clienteUsuarios;
        }


    public List<Cliente_Usuario> listarTodos() {
    return null;
    }
}

