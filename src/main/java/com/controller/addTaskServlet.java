package com.controller;

import com.dao.taskDAO;
import com.dao.userDAO;
import com.model.task;
import com.model.user;
import com.util.DBconnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addTask")
public class addTaskServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("addTaskServlet Called");
        HttpSession session = req.getSession();

        Connection conn = null;
        try {
            conn = DBconnection.getConnection();
            user newUser = (user)session.getAttribute("newUser");
            String email = newUser.getEmail();
            String taskInput = req.getParameter("taskInput");

            System.out.println("New Task from form: " + taskInput);

            userDAO user = new userDAO(conn);
            int user_id = user.getUserId(email);
            newUser.setUserId(user_id);

            System.out.println("DEBUG  addTaskServlet → email = " + email + ", userId = " + user_id + ", newTask = \"" + taskInput + "\"");
            System.out.println("Form recieved");

            taskDAO task = new taskDAO(conn);
            task.addTask(taskInput,user_id);
        }
        catch (SQLException e) {
            System.out.println("error : "+ e.getMessage());
            e.printStackTrace();
        }
//        req.getRequestDispatcher("dashboard").forward(req,res);
          res.sendRedirect("dashboard");
    }

}
