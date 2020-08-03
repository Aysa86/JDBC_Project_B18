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

        // moving the cursor freely between rows

        //rs.previous(); we are at the first row, this will move us to beforeFirst row, we don't have it
        //System.out.println(rs.getString("country_id") + " " + rs.getString("country_name"));

        // moving to the last row directly
        rs.last();
        System.out.println(rs.getString("country_id") + " " + rs.getString("country_name"));

        // moving to the first row directly
        rs.first();
        System.out.println(rs.getString("country_id") + " " + rs.getString("country_name"));

        rs.absolute(5); // will move cursor directly to the 5th row
        System.out.println(rs.getString("country_id") + " " + rs.getString("country_name")); // canada

        // move to before first row location
        rs.beforeFirst();


        // move to after last row location
        rs.afterLast();











    }
}
