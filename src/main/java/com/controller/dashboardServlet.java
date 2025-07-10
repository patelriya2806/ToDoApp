package com.controller;

import com.dao.taskDAO;
import com.dao.userDAO;
import com.model.task;
import com.model.user;
import com.util.DBconnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/dashboard")
public class dashboardServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        user newUser = (user)session.getAttribute("newUser");
        try {
            Connection conn = DBconnection.getConnection();
            String email = newUser.getEmail();

            taskDAO task = new taskDAO(conn);

            List<task> taskList = task.fetchAllTasks(email);
            req.setAttribute("taskList", taskList);
            for(task t : taskList){
                System.out.println(t);
            }
            RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
            rd.forward(req, res);
        }
        catch (SQLException e) {
            System.out.println("error : " + e.getMessage());
            e.printStackTrace();
        }
    }

}
