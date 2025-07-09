<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.model.user"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>To‑Do – Tasks</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Custom styles -->
    <link rel="stylesheet" href="styleHome.css">


</head>
<body class="d-flex flex-column min-vh-100">
<script src = "scriptHome.js" ></script>
<%
    user currentUser = (user) session.getAttribute("user");
    if (currentUser == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!-- Main content -->
<main class="container d-flex justify-content-center align-items-center flex-grow-1" style="min-height: 100vh;">

    <div class="task-card shadow-lg rounded-4 p-4 mx-auto">
        <h1 class="mb-4 text-center fw-bold">My ToDos</h1>

        <!-- Add task -->
        <form id="taskForm" class="input-group mb-4" autocomplete="off" action="${pageContext.request.contextPath}/addTask" method="post">
            <input id="taskInput" type="text" class="form-control" name="taskInput" placeholder="Add a new task…" required>
            <button class="btn btn-primary" type="submit"><i class="bi bi-plus-lg me-1"></i>Add</button>
        </form>

        <%
            List<String> tasks = (List<String>) request.getAttribute("tasks");
        %>

        <!-- Task list -->
        <ul id="taskList" class="list-group">
            <!-- Example static task -->
            <li class="list-group-item d-flex align-items-center">
                <input class="form-check-input me-2" type="checkbox">
                <span class="flex-grow-1">Sample Task</span>
                <form action="delete" method="get">
                <button class="btn btn-sm btn-outline-danger delete-btn ms-2" title="Delete"><i class="bi bi-trash"></i></button>
                </form>
            </li>
            <% if (tasks != null) {
                for (String task : tasks) { %>
            <li class="list-group-item d-flex align-items-center">
                <input class="form-check-input me-2" type="checkbox">
                <span class="flex-grow-1"><%= task %></span>
                <form action="delete" method="post">
                    <button class="btn btn-sm btn-outline-danger delete-btn ms-2" title="Delete">
                        <i class="bi bi-trash"></i>
                    </button>
                </form>
            </li>
            <%   }
            } else { %>
            <li class="list-group-item text-muted">No tasks to display.</li>
            <% } %>
        </ul>
    </div>
</main>

<!-- Bottom nav -->
<nav class="navbar fixed-bottom bg-light border-top">
    <div class="container-fluid justify-content-around px-0">
        <a href="dashboard" class="nav-link text-center active">
            <i class="bi bi-house-door-fill fs-4 d-block"></i>
            <small>Home</small>
        </a>
        <a href="profile.jsp" class="nav-link text-center">
            <i class="bi bi-person fs-4 d-block"></i>
            <small>Profile</small>
        </a>
    </div>
</nav>

</body>
</html>
