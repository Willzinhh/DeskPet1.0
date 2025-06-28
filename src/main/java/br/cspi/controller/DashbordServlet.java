package br.cspi.controller;


import br.cspi.model.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/Dashbord")
public class DashbordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("usuarioLogado") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        int idUsuario = usuario.getCliente_usuario_id();

        req.getRequestDispatcher("/WEB-INF/pages/dashbord.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = req.getParameter("action");
        System.out.println(action);

        switch (action){

            case "CADASTRAR":
                resp.sendRedirect("Clientes?action=CADASTRAR");
                break;
            case "LISTAR":
               resp.sendRedirect("Clientes?action=LISTAR");
                break;
            case "LISTAR_PET":
                resp.sendRedirect("Pet?action=LISTAR_PET");

            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ação inválida");
        }


    }
}
