
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Cliente</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/geral.css"/>" />
</head>
<body>
<div class="cadastro-container" style="margin-top: 60px">
    <div class="login-header">
        <h1>Editar Cliente</h1>
        <p>Atualize as informações do cliente abaixo</p>
    </div>

    <form action="Clientes" method="post">
        <!-- Ação e ID do cliente -->
        <input type="hidden" name="action" value="EDITAR" />
        <input type="hidden" name="opcao" value="${cliente.id}" />

        <div class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="${cliente.nome}" required />
        </div>

        <div class="form-group">
            <label for="telefone">Telefone:</label>
            <input type="text" id="telefone" name="telefone" value="${cliente.telefone}" required />
        </div>

        <div class="form-group">
            <label for="cpf">CPF:</label>
            <input type="text" id="cpf" name="cpf" value="${cliente.cpf}" required />
        </div>

        <div class="form-group">
            <label for="endereco">Endereço:</label>
            <input type="text" id="endereco" name="endereco" value="${cliente.endereco}" required />
        </div>

        <button type="submit" class="cadastro-button" name="action" value="EDITAR">Salvar Alterações</button>
        <div class="register-link">
            <a href="${pageContext.request.contextPath}/Clientes?action=LISTAR">Cancelar</a>
        </div>
    </form>
</div>
</body>
</html>
