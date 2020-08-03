package com.day1;

import java.sql.*;

public class IteratingCountriesTaskMovingBackward {
    public static void main(String[] args) throws SQLException {

        String connectionString = "jdbc:oracle:thin:@100.25.162.89:1521:XE";
        String userName = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionString, userName, password);
// if we create statement in this way, it will generate a forward only result
        // we can only move forward with next() and can't move backward with previous


        //ResultSet.TYPE_SCROLL_INSENSITIVE ==> makes the resultSet be able to move forward and backward
       // ResultSet.CONCUR_READ_ONLY makes ResultSet read only and that's all we need
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT * FROM countries");

        rs.next();
        System.out.println(rs.getString("country_id") + " " + rs.getString("country_name"));

        rs.next();
        System.out.println(rs.getString("country_id") + " " + rs.getString("country_name"));

        // to go to previous row
        rs.previous();
        System.out.println(rs.getString("country_id") + " " + rs.getString("country_name"));

    }
}
