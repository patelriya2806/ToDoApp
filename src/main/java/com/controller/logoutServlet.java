package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class logoutServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("logoutServlet called");
        System.out.println("logoutServlet called");

        // Invalidate the current session
        HttpSession session = req.getSession(false); // Avoid creating a new session
        if (session != null) {
            session.removeAttribute("username");
            session.removeAttribute("newUser");
            session.invalidate();
        }

        // Prevent caching
        res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        res.setHeader("Pragma", "no-cache"); // HTTP 1.0
        res.setDateHeader("Expires", 0); // Proxies

        // Redirect to login page
        res.sendRedirect("login.jsp");
    }
}
