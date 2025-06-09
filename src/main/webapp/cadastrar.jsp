<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: willi
  Date: 25/05/2025
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Usuário e Cliente</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/geral.css"/>">
</head>
<body>
<div class="cadastro-container">

    <div class="titulo">
    <h1>Cadastro de Usuário e Cliente   </h1>
    <a class="register-link " href="index.jsp">Voltar</a>
    </div>
    <form action="cadastrar" method="POST">
        <!-- Seção de Dados do Usuário -->
        <div class="form-section">
            <h2>Dados de Acesso</h2>

            <div class="form-group">
                <label for="email" class="required">E-mail:</label>
                <input type="email" id="email" name="email" required>
            </div>

            <div class="form-group">
                <label for="senha" class="required">Senha:</label>
                <input type="password" id="senha" name="senha" required>
            </div>

            <div class="form-group">
                <label for="confirmar_senha" class="required">Confirmar Senha:</label>
                <input type="password" id="confirmar_senha" name="confirmar_senha" required>
            </div>

        </div>

        <!-- Seção de Dados Pessoais -->
        <div class="form-section">
            <h2>Dados Pessoais</h2>

            <div class="form-group">
                <label for="nome" class="required">Nome Completo:</label>
                <input type="text" id="nome" name="nome" required>
            </div>

            <div class="form-group">
                <label for="cpf">CPF:</label>
                <input type="text" id="cpf" name="cpf" placeholder="000.000.000-00">
            </div>

            <div class="form-group">
                <label for="telefone" class="required">Telefone:</label>
                <input type="tel" id="telefone" name="telefone" required>
            </div>

            <div class="form-group">
                <label for="endereco">Endereço:</label>
                <textarea id="endereco" name="endereco" rows="3"></textarea>
            </div>
        </div>

        <!-- Seção de Dados Empresariais -->
        <div class="form-section">
            <h2>Dados Empresariais (Opcional)</h2>

            <div class="form-group">
                <label for="cnpj">CNPJ:</label>
                <input type="text" id="cnpj" name="cnpj" placeholder="00.000.000/0000-00">
            </div>

            <div class="form-group">
                <label for="nome_empresa">Nome da Empresa:</label>
                <input type="text" id="nome_empresa" name="nome_empresa">
            </div>

            <div class="form-group">
                <label for="plano">Plano:</label>
                <select id="plano" name="plano">
                    <option value="">Selecione um plano</option>
                    <option value="Básico">Básico</option>
                    <option value="Intermediário">Intermediário</option>
                    <option value="Premium">Premium</option>
                </select>
            </div>
        </div>

        <button class="cadastro-button" type="submit" name="cadastrar" value="CADASTRAR">Cadastrar</button>
    </form>
</div>

<script>
    // Validação básica do formulário
    document.querySelector('form').addEventListener('submit', function(e) {
        const senha = document.getElementById('senha').value;
        const confirmarSenha = document.getElementById('confirmar_senha').value;

        if (senha !== confirmarSenha) {
            alert('As senhas não coincidem!');
            e.preventDefault();
        }

        // Aqui você pode adicionar mais validações conforme necessário
    });
</script>
</body>
</html>
