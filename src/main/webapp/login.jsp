<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: willi--%>
<%--  Date: 25/05/2025--%>
<%--  Time: 21:15--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login - Sistema</title>
  <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/geral.css"/>">
</head>
<body>;
<c:if test="${not empty msg}">
  <h3 style=" justify-content: center; align-items: center; color: #ff0000; margin: 20px 0;">${msg}</h3>
</c:if>
<div class="login-container">
  <div class="login-header">
    <h1>Bem-vindo de volta</h1>
    <p>Faça login para acessar sua conta</p>
  </div>





  <form id="loginForm" action="login" method="POST">
    <div class="form-group">
      <label for="email">E-mail</label>
      <input type="email" id="email" name="email" required placeholder="Digite seu e-mail">
    </div>

    <div class="form-group">
      <label for="senha">Senha</label>
      <input type="password" id="senha" name="senha" required placeholder="Digite sua senha">
    </div>


    <button type="submit" value="LOGAR" name="login" class="login-button">Entrar</button>
  </form>

  <div class="register-link">
    Não tem uma conta? <a href="cadastrar">Cadastre-se</a>
  </div>
</div>

</body>
</html>


<%--<!DOCTYPE html>--%>
<%--<html lang="pt-br">--%>
<%--<head>--%>
<%--  <meta charset="UTF-8" />--%>
<%--  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>--%>
<%--  <title>DeskPet Login</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--<h2>Hello World DeskPet</h2>--%>

<%--<form action="login" method="post">--%>
<%--  <label for="Email">--%>
<%--    <b>Login:</b>--%>
<%--  </label>--%>
<%--  <input type="email" placeholder="E-mail" name="email" required>--%>

<%--  <br>--%>
<%--  <br>--%>

<%--  <label for="Senha">--%>
<%--    <b>Senha:</b>--%>
<%--  </label>--%>
<%--  <input type="password" placeholder="Senha" name="senha" required>--%>
<%--  <br>--%>
<%--  <br>--%>
<%--  <button type="submit" value="LOGAR" name="login">Logar</button>--%>
<%--  <a href="cadastrar">Cadastre-se</a>--%>
<%--</form>--%>

<%--<c></c>--%>
<%--<c:if test="${not empty msg}">--%>
<%--<h2>${msg}</h2>--%>
<%--</c:if>--%>

<%--</body>--%>
<%--</html>--%>

