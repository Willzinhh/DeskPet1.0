package br.cspi.service;

import br.cspi.dao.UsuarioDAO;
import br.cspi.model.Usuario;

public class LoginService {

    public Usuario autenticar(String email, String senha) {
        UsuarioDAO u = new UsuarioDAO();
        for (Usuario usuario : u.getUsuarios()) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;

            }
        }



        return null;
    }



}
