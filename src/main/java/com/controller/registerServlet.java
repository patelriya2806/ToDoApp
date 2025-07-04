package com.controller;

import com.dao.userDAO;
import com.model.user;
import com.util.DBconnection;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
@WebServlet("/register")
public class registerServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            Connection conn = DBconnection.getConnection();
            user newUser = new user(username, email, password);
            userDAO user = new userDAO(conn);
            boolean isRegistered = user.register(newUser);
            if (isRegistered) {
                res.sendRedirect("login.jsp");
            }
            else{
                res.sendRedirect("register.jsp?error=already_exsists");
            }
        }
        catch(SQLException e){
            System.out.println("error : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
