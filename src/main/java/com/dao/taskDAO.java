package com.dao;

import com.model.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class taskDAO {
    private Connection conn=null;

    public taskDAO(Connection conn){
        this.conn= conn;
    }

    public void addTask(String newTask, int user_id) throws SQLException {
        String sql = "insert into tasks(user_id, `text`) values( ? , ?)";
        if(user_id != 0) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user_id);
            ps.setString(2, newTask);
            ps.executeUpdate();
            System.out.println("task added");
        } else {
            System.out.println("email not found");
        }

    }

    public List<String> fetchAllTasks(String email) throws SQLException {
        List<String> tasks=new ArrayList<>();

        userDAO user = new userDAO(conn);
        int user_id = user.getUserId(email);
        String query = "select * from tasks where user_id=? ";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, user_id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            tasks.add(rs.getString("text"));
        }
        return tasks;
    }

    public void deleteTask(int task_id) throws SQLException {

    }

    public void fetchTaskId(String task) throws SQLException {

    }

    public boolean taskStatus(String task_id) throws SQLException {
        return false;
    }

    public boolean updateTask(){
        return false;
    }
}
