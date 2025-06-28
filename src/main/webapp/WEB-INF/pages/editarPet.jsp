<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
  <title>Editar Pet</title>
  <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/geral.css"/>" />
</head>
<body>
<div class="cadastro-container">
  <div class="login-header">
    <h1>Editar Pet</h1>
    <p>Atualize as informações do pet abaixo</p>
  </div>

  <form action="Pets" method="post">
    //oioio
    <!-- Campos ocultos com ação e ID do pet -->
    <input type="hidden" name="action" value="EDITAR_PET" />
    <input type="hidden" name="opcao" value="${pet.id}" />

    <div class="form-group">
      <label for="nomepet">Nome do Pet:</label>
      <input type="text" id="nomepet" name="nomepet" value="${pet.nomepet}" required />
    </div>

    <div class="form-group">
      <label for="especie">Espécie:</label>
      <input type="text" id="especie" name="especie" value="${pet.especie}" required />
    </div>

    <div class="form-group">
      <label for="raca">Raça:</label>
      <input type="text" id="raca" name="raca" value="${pet.raca}" required />
    </div>

    <div class="form-group">
      <label for="sexo">Sexo:</label>
      <select id="sexo" name="sexo" required>
        <option value="Macho"
                <c:if test="${pet.sexo == 'Macho'}">selected</c:if>>Macho</option>
        <option value="Fêmea"
                <c:if test="${pet.sexo == 'Fêmea'}">selected</c:if>>Fêmea</option>
      </select>
    </div>

    <div class="form-group">
      <label for="descricao">Descrição:</label>
      <input type="text" id="descricao" name="descricao" value="${pet.descricao}" required />
    </div>

    <button type="submit" name="action" value="EDITAR_PET" class="cadastro-button">Salvar Alterações</button>
    <div class="register-link">
      <a href="${pageContext.request.contextPath}/Pets?action=LISTAR_PET">Cancelar</a>
    </div>
  </form>
</div>
</body>
</html>
