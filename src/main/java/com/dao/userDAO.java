package com.dao;

import com.model.user;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDAO {
    private Connection conn = null;

    public userDAO(Connection conn) {
        this.conn = conn;
    }

    public int getUserId(String email) throws SQLException {
        String query = "select id from users where email = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1,email);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            int userId = rs.getInt("id");
            return userId;
        }
        return 0;
    }

    public String authenticate(String email, String password) throws SQLException {
        String query = "select * from users where email = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (rs.getString("email").equals(email)) {
                boolean check = BCrypt.checkpw(password, rs.getString("password"));
                if (check) {
                    user newUser = new user();
                    newUser.setEmail(rs.getString("email"));
                    String username = rs.getString("username");
                    return username;
                }
            }
        }
        return null;
    }

    public boolean register(user user) throws SQLException {
        String username = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();

        String query1 = "select * from users where email = ?";
        PreparedStatement ps1 = conn.prepareStatement(query1);
        ps1.setString(1, email);
        ResultSet rs = ps1.executeQuery();
        if (rs.next()) {
            return false;
        }
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

        String query = "insert into users(username,email,password) values (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, email);
        ps.setString(3, hashed);
        ps.executeUpdate();

        System.out.println("user registered successfully");
        return true;
    }

}
