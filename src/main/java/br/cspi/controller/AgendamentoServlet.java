package br.cspi.controller;

import br.cspi.dao.AgendamentoDAO;
import br.cspi.model.Agendamento;
import br.cspi.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;


@WebServlet("Agenda")
public class AgendamentoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);


        if (session == null || session.getAttribute("usuarioLogado") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        int idUsuario = usuario.getCliente_usuario_id();

        List<Agendamento> agendamentos = new AgendamentoDAO().getAgendamentos( idUsuario); // buscar no banco ou criar lista

        for (Agendamento agendamento : agendamentos) {
            System.out.println(agendamento.getStatus());
        }

        req.setAttribute("agendamentos", agendamentos);
        req.getRequestDispatcher("/WEB-INF/pages/agenda.jsp").forward(req, resp);
    }


}
