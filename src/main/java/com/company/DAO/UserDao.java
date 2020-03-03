package com.company.DAO;

import com.company.Model.User;

import java.sql.*;

public class UserDao {
    private final static String url = "jdbc:postgresql://localhost:5432/";
    private final static String user = "postgres";
    private final static String password = "123";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to PostgreSQL is successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static boolean getUserByNamePassword(String name, String password) {
        String SQL = "select * from users where name =?,password=?";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(SQL);) {
            statement.setString(1, name);
            statement.setString(2, password);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
//                   return new User().builder().id(rs.getInt("id"))
//                            .name(rs.getString("name"))
//                            .build();
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
