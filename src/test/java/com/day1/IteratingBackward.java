package com.day1;

import java.sql.*;

public class IteratingBackward {
    public static void main(String[] args) throws SQLException {

        String connectionString = "jdbc:oracle:thin:@100.25.162.89:1521:XE";
        String userName = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionString, userName, password);
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT * FROM regions");

//  first move to the after last location
        //  then keep moving to previous row as long as there is more row above \
        rs.afterLast();

//        rs.previous();
//        System.out.println(rs.getString(1) + " " + rs.getString(2));
        while ( rs.previous()==true ){
            System.out.println(rs.getString(1) + " " + rs.getString(2));
        }
        System.out.println("----------- more moving ----------");
        // how to move to second row from here
        rs.absolute(2);
        System.out.println("currently I should be at 2nd row "+rs.getRow());
        System.out.println(rs.getString(1) + " " + rs.getString(2));

        rs.first();
        System.out.println(rs.getString(1) + " " + rs.getString(2));
        rs.last();
        System.out.println(rs.getString(1) + " " + rs.getString(2));

        // how do I know which number I am right now at this location
        // getRow() method return the row number
        System.out.println("rs.getRow() =  " + rs.getRow());

        // there is no count method in ResultSet
        // so in order to get the row count of the resultSet
        // just return the last row number by moving cursor to last row and call getRow() method








    }
}
