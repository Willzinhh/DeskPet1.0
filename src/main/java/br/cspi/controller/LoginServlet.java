package br.cspi.controller;

import br.cspi.dao.Cliente_UsuarioDAO;
import br.cspi.model.Cliente_Usuario;
import br.cspi.model.Usuario;
import br.cspi.service.LoginService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Executando LoginServlet");

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");



        System.out.println("Email: " + email + "\nSenha: " + senha);


        RequestDispatcher dispatcher;


        Usuario usuario = new LoginService().autenticar(email, senha);
        HttpSession session = req.getSession(); // Cria a sessão
        session.setAttribute("usuarioLogado", usuario);
        if(usuario != null) {



            resp.sendRedirect("Dashbord");
        }
        else{
            req.setAttribute("msg", "Email ou senha incorretos");
            dispatcher = req.getRequestDispatcher("login.jsp");
            dispatcher.forward(req, resp);
        }

    }

    //    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Executando LoginServlet");
//
//        PrintWriter out = resp.getWriter();
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Login Servlet</title>");
//        out.println("</head>");
//        out.println("<body>");
//
//            out.println("<h1>Lista de Usuarios</h1>");
//
//            for(Usuario u : new UsuarioService().getUsuarios()){
//                out.println("<h3>");
//                out.println("Email: "+u.getEmail()+"<br>");
//                out.println("Senha: "+u.getSenha()+"<br>");
//                out.println("</h3>");
//
//            }
//
//        out.println("</body>");
//        out.println("</html>");

    }

