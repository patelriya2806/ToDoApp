package com.controller;

import com.dao.taskDAO;
import com.dao.userDAO;
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

@WebServlet("/addTask")
public class addTaskServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("addTaskServlet Called");

        HttpSession session = req.getSession();

        Connection conn = null;
        try {
            conn = DBconnection.getConnection();

            String email = (String)session.getAttribute("email");
            String taskInput = req.getParameter("taskInput");
            System.out.println("New Task from form: " + taskInput);
            userDAO user = new userDAO(conn);
            int user_id = user.getUserId(email);

            System.out.println("DEBUG  addTaskServlet → email = " + email
                    + ", userId = " + user_id
                    + ", newTask = \"" + taskInput + "\"");
            System.out.println("Form recieved");

            taskDAO task = new taskDAO(conn);

            task.addTask(taskInput,user_id);
        }
        catch (SQLException e) {
            System.out.println("error : "+ e.getMessage());
            e.printStackTrace();
        }
        res.sendRedirect("home.jsp");
    }

}
