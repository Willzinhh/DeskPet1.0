package br.cspi.service;

import br.cspi.dao.ClientesDAO;
import br.cspi.dao.PetDAO;
import br.cspi.model.Clientes;
import br.cspi.model.Pet;

import java.util.ArrayList;

public class PetsService {

    public ArrayList<Pet> listarPets(int idUsuario) {
        PetDAO dao = new PetDAO();

        return dao.getPets(idUsuario);
    }

    public boolean cadastrarPets(ArrayList<Pet> pets, Clientes cliente, int idUsuario ) {
        System.out.println("OIOIOIOI");
        PetDAO dao = new PetDAO();
        ClientesDAO cdao = new ClientesDAO();
        int clienteId = 0;

        for (Pet p: pets){
            System.out.println(p.getNomepet()+ p.getEspecie()+p.getRaca());
        }

        for (Clientes c: cdao.getClientes(idUsuario)) {
            if (c.getCpf().equals(cliente.getCpf())) {
                clienteId = c.getId();
            }
        }

        dao.inserir(pets, clienteId, idUsuario);
        return true;
    }

    public void excluirPet(int idPet){
        PetDAO dao = new PetDAO();
        dao.excluir(idPet);
    }

    public boolean editarPet(Pet pet, int idPet){

        PetDAO dao = new PetDAO();



        dao.alterer(pet, idPet);
        return true;
    }

    public Pet buscarPet(int idPet, int idUsuario){
        PetDAO dao = new PetDAO();

        for (Pet pet : dao.getPets(idUsuario)) {
            if(pet.getId() == idPet){
                return pet;
            }
        }
        return null;
    }

    public void adicionarPets(Pet pets,int idCliente, int idUsuario) {
        PetDAO dao = new PetDAO();
        dao.adicionar(pets, idCliente, idUsuario);
    }

}
