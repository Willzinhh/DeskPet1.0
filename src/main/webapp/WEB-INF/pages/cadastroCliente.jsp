<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Cadastro de Cliente e Pets</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
    }
    .container {
      max-width: 700px;
      margin: 40px auto;
      padding: 30px;
      background-color: white;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    h2, h3 {
      margin-top: 0;
      color: #333;
    }
    label {
      font-weight: bold;
      margin-top: 10px;
      display: block;
    }
    input, select {
      width: 100%;
      padding: 10px;
      margin-top: 5px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }
    .pet-entry {
      background-color: #f9f9f9;
      border: 1px solid #ccc;
      padding: 15px;
      margin-bottom: 15px;
      border-radius: 8px;
    }
    button, input[type="submit"] {
      padding: 12px 20px;
      border: none;
      border-radius: 5px;
      color: #fff;
      cursor: pointer;
      font-size: 16px;
    }
    button {
      background-color: #2196F3;
      margin-right: 10px;
    }
    button:hover {
      background-color: #1976D2;
    }
    input[type="submit"] {
      background-color: #4CAF50;
    }
    input[type="submit"]:hover {
      background-color: #45A049;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Cadastro de Cliente</h2>
  <div style="display: flex; justify-content: space-between; flex-direction: row; align-items: center">
    <a href="###" class=""></a>
    <a href="Dashbord" class="btn-primary">Voltar</a>
  </div>

  <form action="Clientes" method="post">

    <input type="hidden" name="opcao" value="${idUsuario}">

    <label>Nome:</label>
    <input type="text" name="nome" required>

    <label>Telefone:</label>
    <input type="text" name="telefone">

    <label>CPF:</label>
    <input type="text" name="cpf">

    <label>Endereço:</label>
    <input type="text" name="endereco">

    <h3>Pets</h3>
    <div id="petsContainer"></div>
    <button type="button" onclick="addPetField()">Adicionar Pet</button>

    <br><br>
    <input type="submit" name="action" value="CADASTRAR">
  </form>
</div>

<script>
  function addPetField() {
    const petDiv = document.createElement('div');
    petDiv.classList.add("pet-entry");
    petDiv.innerHTML = `
      <label>Nome do Pet:</label>
      <input type="text" name="nomepet[]" required>

      <label>Espécie:</label>
      <input type="text" name="especie[]" required>

      <label>Raça:</label>
      <input type="text" name="raca[]" required>

      <label>Sexo:</label>
      <select name="sexo[]" required>
        <option value="macho">Macho</option>
        <option value="femea">Fêmea</option>
      </select>

      <label>Descrição:</label>
      <input type="text" name="descricao[]">

      <button type="button" onclick="this.parentElement.remove()">Remover Pet</button>
    `;
    document.getElementById('petsContainer').appendChild(petDiv);
  }
</script>
</body>
</html>
