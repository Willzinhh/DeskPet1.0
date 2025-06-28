<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>

<%
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
  response.setHeader("Pragma", "no-cache"); // HTTP 1.0
  response.setDateHeader("Expires", 0); // Proxies
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Pets</title>
  <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
  <link rel="stylesheet" href="<c:url value='/static/css/tableClientes.css' />">
</head>
<body>
<div class="dashboard-container">
  <div class="main-content">
    <h1>Pets</h1>
    <div style="display: flex; justify-content: space-between; flex-direction: row; align-items: center">
    <a href="Clientes?action=CADASTRAR" class="btn btn-primary">Novo Cliente</a>
    <a href="Dashbord" class="btn-primary">Voltar</a>
    </div>

      <div class="table-container">
      <table id="petsTable" class="display">
        <thead>
        <tr>
          <th>Nome</th>
          <th>Espécie</th>
          <th>Raça</th>
          <th>Sexo</th>
          <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pets}" var="pets">
          <tr>
            <td>${pets.nomepet}</td>
            <td>${pets.especie}</td>
            <td>${pets.raca}</td>
            <td>${pets.sexo}</td>
            <td>
              <form action="Pets" method="post">
                <input type="hidden" name="opcao" value="${pets.id}">
                <a href="Pets?action=EDITAR_PET&opcao=${pets.id}" class="btn-warning btn-sm" >Editar</a>
              </form>
              <form action="Pets" method="post">
                <input type="hidden" name="opcao" value="${pets.id}">
                <button type="submit" class="btn-danger btn-sm" name="action" value="EXCLUIR_PET" onclick="return confirm('Excluir cliente?')">Excluir</button>
              </form>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script>
  $(document).ready(function () {
    $('#petsTable').DataTable({
      language: {
        url: 'https://cdn.datatables.net/plug-ins/1.11.5/i18n/pt-BR.json'
      }
    });
  });
</script>
</body>
</html>
