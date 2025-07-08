package com.controller;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

import com.dao.userDAO;
import com.model.user;
import com.util.DBconnection;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/login")
public class loginServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{

        System.out.println("loginServlet called ");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            Connection conn = DBconnection.getConnection();

            userDAO user = new userDAO(conn);
            String username = user.authenticate(email,password);
            if(username!=null){
                HttpSession session = req.getSession();
                user newUser = new user();
                newUser.setEmail(email);
                newUser.setName(username);
                session.setAttribute("user", newUser);
                res.sendRedirect("dashboard");
            }
            else{
                res.sendRedirect("login.jsp?error=invalid");
            }

        } catch (SQLException e){
            System.out.println("error : "+ e.getMessage());
            e.printStackTrace();
        }
    }
}
