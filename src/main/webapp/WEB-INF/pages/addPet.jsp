<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Adicionar Pet</title>
  <style>
    body {
      margin: 0;
      font-family: 'Segoe UI', sans-serif;
      background-color: #f0f2f5;
    }

    .container {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .form-card {
      background-color: #fff;
      padding: 40px;
      border-radius: 12px;
      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
      width: 400px;
    }

    .form-card h2 {
      text-align: center;
      margin-bottom: 24px;
      color: #333;
    }

    label {
      display: block;
      margin-top: 12px;
      margin-bottom: 6px;
      color: #333;
      font-weight: 500;
    }

    input[type="text"],
    select,
    textarea {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 8px;
      box-sizing: border-box;
      font-size: 14px;
    }

    textarea {
      resize: vertical;
    }

    .btn {
      display: block;
      width: 100%;
      padding: 12px;
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 8px;
      font-size: 16px;
      cursor: pointer;
      margin-top: 20px;
    }

    .btn:hover {
      background-color: #45a049;
    }

    .back-link {
      display: block;
      text-align: center;
      margin-top: 15px;
      color: #555;
      text-decoration: none;
    }

    .back-link:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
<div class="container">
  <div class="form-card">
    <h2>Adicionar Pet</h2>
    <form action="Pets" method="post">
      <input type="hidden" name="action" value="ADICIONAR">
      <input type="hidden" name="idUsuario" value="${idUsuario}">
      <input type="hidden" name="opcao" value="${idCliente}">

      <label for="nomePet">Nome do Pet</label>
      <input type="text" id="nomePet" name="nomepet" required>

      <label for="especie">Espécie</label>
      <input type="text" id="especie" name="especie" required>

      <label for="raca">Raça</label>
      <input type="text" id="raca" name="raca" required>

      <label for="sexo">Sexo</label>
      <select id="sexo" name="sexo" required>
        <option value="">Selecione</option>
        <option value="Macho">Macho</option>
        <option value="Fêmea">Fêmea</option>
      </select>

      <label for="descricao">Descrição</label>
      <textarea id="descricao" name="descricao" rows="3"></textarea>

      <button type="submit" name="action" value="ADICIONAR" class="btn">Salvar Pet</button>
    </form>

    <a href="${pageContext.request.contextPath}/Clientes?action=LISTAR" class="back-link">Voltar</a>
  </div>
</div>
</body>
</html>
