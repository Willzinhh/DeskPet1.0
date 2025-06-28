<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }
        .navbar {
            background-color: #4CAF50;
            padding: 15px 20px;
            color: white;
            text-align: center;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: calc(100vh - 60px);
        }
        .card {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            width: 300px;
            text-align: center;
        }
        .card h2 {
            margin-bottom: 30px;
            color: #333;
        }
        .btn {
            display: block;
            width: 100%;
            padding: 12px;
            margin: 10px 10px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
            transition: background 0.3s;
        }
        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<div class="navbar">
    <h1>Dashboard</h1>
</div>

<div class="container">
    <div style="position: absolute; top: 10px; right: 10px;">
        <form action="Logout" method="get">
            <button type="submit" class="btn btn-danger" style="background-color: #dc3545; color: white; padding: 8px 12px; border: none; border-radius: 4px; cursor: pointer;">
                Logout
            </button>
        </form>
    </div>
    <div class="card">
        <h2>Menu Principal</h2>
        <form action="Dashbord" method="post" style="display: flex; flex-direction: column; justify-content: center; align-items: center">
            <a class="btn" href="Clientes?action=CADASTRAR" type="submit" >Cadastrar Cliente</a>
            <a class="btn" href="Clientes?action=LISTAR" type="submit"  >Mostrar Clientes</a>
            <a class="btn" href="Pets?action=LISTAR_PET" type="submit"  >Mostrar Pets</a>
            <a class="btn" href="Agenda" type="submit"  >Agenda</a>
        </form>
    </div>
</div>




</body>
</html>

