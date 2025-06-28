package br.cspi.service;

import br.cspi.dao.Cliente_UsuarioDAO;
import br.cspi.dao.UsuarioDAO;
import br.cspi.model.Cliente_Usuario;
import br.cspi.model.Usuario;

import java.util.Objects;

public class CadastrarService {

    public boolean cadastrar(Usuario usuario, Cliente_Usuario cliente) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Cliente_UsuarioDAO clienteDAO = new Cliente_UsuarioDAO();

        boolean criar = true;
        int id = 0;
        boolean cnpj = true;

        if (cliente.getCnpj()==null){
            cnpj = false;
        }

        for (Cliente_Usuario clientes : clienteDAO.getClientes()){
            if (clientes.getCpf().equals(cliente.getCpf())){
                criar = false;
            }
            else if (!cnpj) {
                if (clientes.getCnpj().equals(cliente.getCnpj())) {
                    criar = false;
                }
            }
        }
        
        for (Usuario usuarios : usuarioDAO.getUsuarios()){
            if (usuarios.getEmail().equals(usuario.getEmail())){
                criar = false;
            }
        }
        
        clienteDAO.inserir(cliente);

        for (Cliente_Usuario clientes : clienteDAO.getClientes()){
            if (clientes.getCpf().equals(cliente.getCpf())){
                id = clientes.getId();

            }
        }
        usuario.setCliente_usuario_id(id);
        usuarioDAO.inserir(usuario);



        return true;
    }
}
