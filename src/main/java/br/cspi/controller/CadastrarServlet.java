package br.cspi.controller;

import br.cspi.model.Cliente_Usuario;
import br.cspi.model.Usuario;
import br.cspi.service.CadastrarService;
import br.cspi.service.LoginService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("cadastrar")
public class CadastrarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("cadastrar.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Executando CadastrarServlet");

        Cliente_Usuario c = new Cliente_Usuario();
        Usuario u = new Usuario();

        c.setNome(req.getParameter("nome"));
        c.setCpf(req.getParameter("cpf"));
        c.setCnpj(req.getParameter("cnpj"));
        c.setEndereco(req.getParameter("endereco"));
        c.setTelefone(req.getParameter("telefone"));
        c.setNome_empresa(req.getParameter("nome_empresa"));
        c.setPlano(req.getParameter("plano"));
        u.setEmail(req.getParameter("email"));
        u.setSenha(req.getParameter("senha"));

        System.out.println(c.getNome() + " " + c.getCpf() + " " + c.getCnpj() + " " + c.getEndereco()
        + " " + c.getTelefone() + " " + c.getNome_empresa() + " " + c.getPlano()
        + " " + u.getEmail() + " " + u.getSenha());

        RequestDispatcher dispatcher;

        if (new CadastrarService().cadastrar(u, c)){
            dispatcher = req.getRequestDispatcher("login.jsp");
            dispatcher.forward(req, resp);
        }
        else {
            dispatcher = req.getRequestDispatcher("cadastrar.jsp");
            dispatcher.forward(req, resp);
        }


    }
}
