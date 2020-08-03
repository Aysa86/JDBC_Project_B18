package com.day1;

import java.sql.*;

public class IteratingCountriesTask {
    public static void main(String[] args) throws SQLException {

        String connectionString = "jdbc:oracle:thin:@100.25.162.89:1521:XE";
        String userName = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionString, userName, password);

        Statement stmnt = conn.createStatement();

        ResultSet rs = stmnt.executeQuery("SELECT * FROM countries");

        while(rs.next() == true){
            System.out.println(rs.getString(1) + " " +
                               rs.getString(2) + " " +
                               rs.getInt(3) ); // this is getting region id as number(int), not string
        }
        rs.previous();




    }
}
