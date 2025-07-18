<%@ page import="com.model.user" %><%--
  Created by IntelliJ IDEA.
  User: rbp23
  Date: 10-07-2025
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Custom styles -->
    <link rel="stylesheet" href="styleHome.css">
</head>
<body>
<!-- Main content -->
<main class="container d-flex flex-column justify-content-center align-items-center" style="min-height: 100vh;">

    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

        user newUser = (user)session.getAttribute("newUser");
        if (newUser!=null) {
        String username = newUser.getUsername();
    %>
    <div class="task-card shadow-lg rounded-4 p-4 mx-auto">
        <h1 class="mb-4 text-center fw-bold">Profile</h1>
        <h2>Hello <%= username%></h2>
        <p><b> Registered email : </b><%= newUser.getEmail()%></p>

        <!-- Spacer to push the button down -->
        <div class="flex-grow-1"></div>

        <form action="logout" method="post">
        <button type="submit" class="btn btn-primary btn-lg">Logout</button>
        </form>
    </div>
    <% } else {
            response.sendRedirect("login.jsp");
    %>
<%--    <div class="alert alert-danger">User not logged in.</div>--%>
    <%  }  %>
</main>
<!-- Bottom nav -->
<nav class="navbar fixed-bottom bg-light border-top">
    <div class="container-fluid justify-content-around px-0">
        <a href="dashboard" class="nav-link text-center">
            <i class="bi bi-house-door fs-4 d-block"></i>
            <small>Home</small>
        </a>
        <a href="profile.jsp" class="nav-link text-center active">
            <i class="bi bi-person-fill fs-4 d-block"></i>
            <small>Profile</small>
        </a>
    </div>
</nav>
</body>
</html>
