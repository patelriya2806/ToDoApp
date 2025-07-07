package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
