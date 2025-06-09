package br.cspi.controller;

import br.cspi.model.Pet;
import br.cspi.model.Usuario;
import br.cspi.service.PetsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Pets")
public class PetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        HttpSession session = req.getSession(false);
        System.out.println(action+"1");

        if (session == null || session.getAttribute("usuarioLogado") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        int idUsuario = usuario.getCliente_usuario_id();

        if (action == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ação não informada");
            return;

        }

        switch (action) {
            case "EDITAR_PET":

                int idPet = Integer.parseInt(req.getParameter("opcao"));;
                mostrarFormularioEdicao(req, resp, idPet);
                break;
            case "LISTAR_PET":
                listarPets(req, resp, idUsuario);
                break;
            case "ADICIONAR":
                int idCliente = Integer.parseInt(req.getParameter("opcao"));;
                mostrarFormAdicao(req, resp, idCliente);
                break;


            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ação inválida");
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        int idCliente = Integer.parseInt(req.getParameter("opcao"));
        System.out.println(action + "3");

        if (action == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ação não informada");
            return;
        }
        System.out.println(action + "4");

        switch (action) {


            case "EDITAR_PET":
                processarEdicao(req, resp);
                break;
            case "EXCLUIR_PET":
                excluirPet(req,resp,idCliente);
                break;
            case "ADICIONAR":
                System.out.println("adicionar");
                processarAdicao(req, resp, idCliente);
                break;



            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ação inválida para POST");
        }
    }

    private void listarPets(HttpServletRequest req, HttpServletResponse resp, int idUsuario)
            throws ServletException, IOException {
        System.out.println("Listando Clientes");

        ArrayList<Pet> pets = new PetsService().listarPets(idUsuario);

        for (Pet pet : pets) {
            System.out.println(pet.getNomepet());

        }
        req.setAttribute("pets", pets);
        req.getRequestDispatcher("/WEB-INF/pages/tabelaPets.jsp").forward(req, resp);
    }


    private void mostrarFormularioEdicao(HttpServletRequest req, HttpServletResponse resp, int idPet)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("usuarioLogado") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        int idUsuario = usuario.getCliente_usuario_id();

        Pet p = new PetsService().buscarPet(idPet, idUsuario);
        System.out.println(p.getNomepet());


        req.setAttribute("pet", p);
        req.getRequestDispatcher("WEB-INF/pages/editarPet.jsp").forward(req, resp);

    }

    private void processarEdicao(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Pet p = new Pet();
        p.setId(Integer.parseInt(req.getParameter("opcao")));
        p.setNomepet(req.getParameter("nomepet"));
        p.setEspecie(req.getParameter("especie"));
        p.setRaca(req.getParameter("raca"));
        p.setSexo(req.getParameter("sexo"));
        p.setDescricao(req.getParameter("descricao"));


        new PetsService().editarPet(p,p.getId());
        resp.sendRedirect("Pets?action=LISTAR_PET");
    }

    private void excluirPet(HttpServletRequest req, HttpServletResponse resp, int idPet)throws ServletException, IOException {
        System.out.println("Excluindo cliente");
        new PetsService().excluirPet(idPet);
        resp.sendRedirect("Pets?action=LISTAR_PET");
    }
    private void mostrarFormAdicao(HttpServletRequest req,HttpServletResponse resp, int idCliente)throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("usuarioLogado") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        int idUsuario = usuario.getCliente_usuario_id();




        req.setAttribute("idCliente", idCliente);
        req.setAttribute("idUsuario", idUsuario);
        req.getRequestDispatcher("WEB-INF/pages/addPet.jsp").forward(req, resp);
    }

        private void processarAdicao(HttpServletRequest req,HttpServletResponse resp, int idCliente)throws ServletException, IOException {
        int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));

        Pet p = new Pet();



        p.setNomepet(req.getParameter("nomepet"));
        p.setEspecie(req.getParameter("especie"));
        p.setRaca(req.getParameter("raca"));
        p.setSexo(req.getParameter("sexo"));
        p.setDescricao(req.getParameter("descricao"));


            System.out.println(p.getNomepet()+p.getEspecie()+p.getRaca()+p.getSexo());

        new PetsService().adicionarPets(p, idCliente, idUsuario);
        resp.sendRedirect("Pets?action=LISTAR_PET");
    };
}


