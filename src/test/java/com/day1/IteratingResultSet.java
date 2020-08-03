package com.day1;

import java.sql.*;

public class IteratingResultSet {
    public static void main(String[] args) throws SQLException {
        String connectionString = "jdbc:oracle:thin:@100.25.162.89:1521:XE";
        String userName = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionString, userName, password);

        Statement stmnt = conn.createStatement();

        ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS");

        // as long as rs.next() return true, I know I have next row to print the data
        // we will keep looping as long as rs.next() return true

        while (rs.next() == true){
            System.out.println(rs.getString("Region_id") + " " + rs.getString("Region_name"));
        }

       /* rs.next(); // currently we are at the first row
        System.out.println(rs.getString("Region_id") + " " + rs.getString("Region_name"));

        rs.next(); // currently we are at the second row
        System.out.println(rs.getString(1) + " " + rs.getString(2));

        rs.next(); // currently we are at the third row
        System.out.println(rs.getString("Region_id") + " " + rs.getString("Region_name"));

        rs.next(); // currently we are at the forth row
        System.out.println(rs.getString(1) + " " + rs.getString(2));


        System.out.println(rs.next()); //  return false, we don't have fifth row*/

    }
}
