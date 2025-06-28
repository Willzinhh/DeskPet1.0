package br.cspi.controller;


import br.cspi.model.Clientes;
import br.cspi.model.Pet;
import br.cspi.model.Usuario;
import br.cspi.service.ClientesService;

import br.cspi.service.PetsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Clientes")
    public class ClientesServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String action = req.getParameter("action");
            HttpSession session = req.getSession(false);
            System.out.println(action +     '1');


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
                case "EDITAR":

                    int idCliente = Integer.parseInt(req.getParameter("opcao"));;
                    mostrarFormularioEdicao(req, resp, idCliente);
                    break;
                case "LISTAR":
                    listarClientes(req, resp, idUsuario);
                    break;
                case "CADASTRAR":
                    mostrarFormularioCadastro(req, resp);
                    break;
                default:
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ação inválida");
            }
        }

        @Override
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

                case "CADASTRAR":
                    processarCadastro(req, resp);
                    break;
                case "EDITAR":
                    processarEdicao(req, resp);
                    break;
                case "EXCLUIR":
                    excluirCliente(req,resp,idCliente);
                    break;




                default:
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ação inválida para POST");
            }
        }

        // Métodos auxiliares

        private void listarClientes(HttpServletRequest req, HttpServletResponse resp, int idUsuario)
                throws ServletException, IOException {
            System.out.println("Listando Clientes");

            ArrayList<Clientes> clientes = new ClientesService().listarClientes(idUsuario);


            req.setAttribute("clientes", clientes);

            for (Clientes cliente : clientes) {
                System.out.println(cliente.toString());
                System.out.println("oi");
            }
            req.getRequestDispatcher("/WEB-INF/pages/tabelaClientes.jsp").forward(req, resp);
        }

        private void mostrarFormularioCadastro(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            HttpSession session = req.getSession(false);

            if (session == null || session.getAttribute("usuarioLogado") == null) {
                resp.sendRedirect("login.jsp");
                return;
            }

            Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
            int idUsuario = usuario.getCliente_usuario_id();



            req.setAttribute("idUsuario", idUsuario);
            req.getRequestDispatcher("WEB-INF/pages/cadastroCliente.jsp").forward(req, resp);
        }

        private void processarCadastro(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            int idUsuario = Integer.parseInt(req.getParameter("opcao"));

            System.out.println(idUsuario);

            Clientes c = new Clientes();

            c.setCliente_usuario_id(Integer.parseInt(req.getParameter("opcao")));
            c.setNome(req.getParameter("nome"));
            c.setTelefone(req.getParameter("telefone"));
            c.setCpf(req.getParameter("cpf"));
            c.setEndereco(req.getParameter("endereco"));



            // Arrays de pets
            String[] nomepet =req.getParameterValues("nomepet[]");
            ArrayList<Pet> pets = new ArrayList<>();

            if (nomepet != null) {
                String[] especie = req.getParameterValues("especie[]");
                String[] raca = req.getParameterValues("raca[]");
                String[] sexo = req.getParameterValues("sexo[]");
                String[] descricao = req.getParameterValues("descricao[]");

                // Aqui você cria o cliente e associa os pets
                for (int i = 0; i < nomepet.length; i++) {
                    Pet p = new Pet();
                    p.setNomepet(nomepet[i]);
                    p.setEspecie(especie[i]);
                    p.setRaca(raca[i]);
                    p.setSexo(sexo[i]);
                    p.setDescricao(descricao[i]);
                    pets.add(p);
                }
            }

            if (new ClientesService().cadastrarCliente(c, idUsuario)){
                System.out.println(" Cliente Cadastrado com sucesso!");
                if(nomepet == null ) {
                }
                else{
                    if (new PetsService().cadastrarPets(pets, c, idUsuario)) {
                        System.out.println(" Pets Cadastrado com sucesso!");
                        req.getRequestDispatcher("WEB-INF/pages/dashbord.jsp");

                    } else {
                        System.out.println("Erro ao cadastrar pets!");
                        req.getRequestDispatcher("WEB-INF/pages/cadastroCliente.jsp");
                    }
                }
            }
            else{
                 req.getRequestDispatcher("WEB-INF/pages/cadastroCliente.jsp");
            }
             req.getRequestDispatcher("WEB-INF/pages/dashbord.jsp").forward(req, resp);

        }

        private void mostrarFormularioEdicao(HttpServletRequest req, HttpServletResponse resp, int idCliente)
                throws ServletException, IOException {

            HttpSession session = req.getSession(false);

            if (session == null || session.getAttribute("usuarioLogado") == null) {
                resp.sendRedirect("login.jsp");
                return;
            }

            Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
            int idUsuario = usuario.getCliente_usuario_id();

            Clientes c = new ClientesService().buscarCliente(idCliente, idUsuario);
            System.out.println(c.getNome());


            req.setAttribute("cliente", c);
            req.getRequestDispatcher("WEB-INF/pages/editar.jsp").forward(req, resp);

        }

        private void processarEdicao(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            Clientes c = new Clientes();
            c.setId(Integer.parseInt(req.getParameter("opcao")));
            c.setNome(req.getParameter("nome"));
            c.setTelefone(req.getParameter("telefone"));
            c.setCpf(req.getParameter("cpf"));
            c.setEndereco(req.getParameter("endereco"));

            new ClientesService().editarCliente(c,c.getId());
            resp.sendRedirect("Clientes?action=LISTAR");
        }

        private void excluirCliente(HttpServletRequest req, HttpServletResponse resp, int idCliente)throws ServletException, IOException {
            System.out.println("Excluindo cliente");
            new ClientesService().excluirCliente(idCliente);
            resp.sendRedirect("Clientes?action=LISTAR");
        }
    }