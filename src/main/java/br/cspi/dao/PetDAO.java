package br.cspi.dao;
import br.cspi.model.Cliente_Usuario;
import br.cspi.model.Clientes;
import br.cspi.model.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {

//            ALTERAR
        public String alterer(Pet pet, Integer id) {
            try {
                Connection conn = ConectarBancoDados.conectarBancoDados();
                PreparedStatement stmt = conn.prepareStatement("UPDATE pet SET nomepet = ?, especie = ?, raca= ?, sexo = ? = ? WHERE id = ?"
                );

                stmt.setString(1, pet.getNomepet());
                stmt.setString(2, pet.getEspecie());
                stmt.setString(3, pet.getRaca());
                stmt.setString(4, pet.getSexo());
                stmt.setString(5, pet.getDescricao());
                stmt.setInt(6, id);


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
                PreparedStatement stmt = conn.prepareStatement("delete from pet where id = ?"
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
        public String inserir(ArrayList<Pet> pets, int cliente_id,int id) {
            //conecta com banco
            //monta sql inserir
            //executa sql


                try {
                    Connection conn = ConectarBancoDados.conectarBancoDados();
                    int i = 0;
                    for (Pet pet : pets) {

                        PreparedStatement stmt = conn.prepareStatement("insert into pet(nomepet, especie, raca, sexo, descricao, tutor_id, cliente_usuario_id) values(?, ?, ?, ?, ?, ?, ?)"
                        );
                        if(pets.get(i).getNomepet()==null){
                            break;
                        }

                        stmt.setString(1, pet.getNomepet());
                        stmt.setString(2, pet.getEspecie());
                        stmt.setString(3, pet.getRaca());
                        stmt.setString(4, pet.getSexo());
                        stmt.setString(5, pet.getDescricao());
                        stmt.setInt(6, cliente_id);
                        stmt.setInt(7, id );


                        stmt.execute();
                        i++;
                    }


                } catch (SQLException | ClassNotFoundException e) {
                    System.out.println("Erro ao inserir");
                    throw new RuntimeException(e);


                }


            return "Inserido com Sucesso";
        }

    public String adicionar(Pet pet, int cliente_id,int id) {
        //conecta com banco
        //monta sql inserir
        //executa sql


        try {
            Connection conn = ConectarBancoDados.conectarBancoDados();


                PreparedStatement stmt = conn.prepareStatement("insert into pet(nomepet, especie, raca, sexo, descricao, tutor_id, cliente_usuario_id) values(?, ?, ?, ?, ?, ?, ?)"
                );


                stmt.setString(1, pet.getNomepet());
                stmt.setString(2, pet.getEspecie());
                stmt.setString(3, pet.getRaca());
                stmt.setString(4, pet.getSexo());
                stmt.setString(5, pet.getDescricao());
                stmt.setInt(6, cliente_id);
                stmt.setInt(7, id );


                stmt.execute();

            }
            catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao inserir");
            throw new RuntimeException(e);


        }


        return "Inserido com Sucesso";
    }

//            GET Clientes
        public ArrayList<Pet> getPets(int id) {
            ArrayList<Pet> pets = new ArrayList<>();

            try {
                Connection conn = ConectarBancoDados.conectarBancoDados();

                String sql = "SELECT * FROM pet WHERE cliente_usuario_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id); // Aqui passamos o valor do id com segurança

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Pet c = new Pet();
                    c.setId(rs.getInt("id"));
                    c.setNomepet(rs.getString("nomepet"));
                    c.setEspecie(rs.getString("especie"));
                    c.setRaca(rs.getString("raca"));
                    c.setSexo(rs.getString("sexo"));
                    c.setDescricao(rs.getString("descricao"));
                    c.setTutor_id(rs.getInt("tutor_id"));

                    pets.add(c);

                }

            } catch (SQLException e) {
                System.out.println("Erro ao conectar");
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro ao conectar");
                ex.printStackTrace();
            }

            return pets;
        }
        
}

