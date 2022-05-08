package net.javaguides.sms.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class MysqlCon{
    public static void main(String[] args) throws SQLException {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila",
                    "root",
                    "password");
            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery("select * from staff");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                }
            }
            con.close();

        } catch (SQLException e) {
            throw new SQLException();
        }
    }
}