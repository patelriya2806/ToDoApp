<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Register</title>

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(to right, #74ebd5, #ACB6E5);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .card {
            width: 100%;
            max-width: 450px;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 5px 20px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>

<div class="card bg-white">
    <h3 class="text-center mb-4">Create Account</h3>

    <form action="register" method="post" onsubmit="return validateForm()">

        <div class="mb-3">
            <label for="name" class="form-label">Full Name</label>
            <input type="text" class="form-control" id="username" name="username" required placeholder="Enter your full name">
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Email address</label>
            <input type="email" class="form-control" id="email" name="email" required placeholder="Enter your email">
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password" required placeholder="Create a password">
        </div>

        <div class="mb-3">
            <label for="confirm" class="form-label">Confirm Password</label>
            <input type="password" class="form-control" id="confirm" name="confirm" required placeholder="Re-enter password">
            <div id="passwordError" class="text-danger small mt-1" style="display: none;">
                Password do not match.
            </div>
        </div>

        <%
            String error = request.getParameter("error");
            if("already_exsist".equals(error)) {
        %>
        <p class="font-weight-normal text-danger">Email already Registered</p>
        <% } %>

        <div class="d-grid mb-3">
            <button type="submit" class="btn btn-primary">Register</button>
        </div>

        <div class="text-center">
            <small>Already have an account? <a href="login.jsp" class="text-decoration-none">Login here</a></small>
        </div>
    </form>
</div>

<!-- Bootstrap 5 JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function validateForm() {
        const pass = document.getElementById("password").value;
        const confirm = document.getElementById("confirm").value;
        const errorDiv = document.getElementById("passwordError");

        if (pass !== confirm) {
            errorDiv.style.display = "block";
            return false; // prevent form submit
        } else {
            errorDiv.style.display = "none";
            return true;
        }
    }
</script>

</body>
</html>