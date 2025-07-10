package com.controller;

import com.dao.taskDAO;
import com.util.DBconnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/delete")
public class deleteTaskServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String)session.getAttribute("username");
        int id = Integer.parseInt(req.getParameter("taskId"));
        try {
            Connection conn = DBconnection.getConnection();
            taskDAO task = new taskDAO(conn);
            boolean isDeleted = task.deleteTask(id);
            if(isDeleted) {
                res.sendRedirect("dashboard");
            }
            else {
                res.sendRedirect("error");
            }
        }
        catch (SQLException e) {
            System.out.println("error : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
