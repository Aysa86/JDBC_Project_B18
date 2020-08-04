package com.day2;

import java.sql.*;

public class DB_Utility {
// adding static field so we can access in all static methods
   private static Connection conn;
   private static ResultSet rs = null;
   /*
   a static method to get the column count of the current ResultSet
        getColumnCNT()
    */
    public static int getColumnCNT(){
       int columnCount = 0;
        ResultSetMetaData rsmd = null;
        try {
            rsmd = rs.getMetaData();
            columnCount = rsmd.getColumnCount();
        } catch (SQLException throwables) {
            System.out.println("Error while counting the columns");
            throwables.printStackTrace();
        }


        return columnCount;
    }

   /*
    a static method to create a connection
    with valid url, username and password
     */

    public static void createConnection(){

        String connectionString = "jdbc:oracle:thin:@100.25.162.89:1521:XE";
        String userName = "hr";
        String password = "hr";

        try {
            conn = DriverManager.getConnection(connectionString, userName, password);
            System.out.println("Connection successful");
        } catch (SQLException throwables) {
            System.out.println("Connection has failed");
            throwables.printStackTrace();
        }



    }

    /*
    a static method to get the ResultSet object
    with valid connection by executing query
     */
    public static ResultSet runQuery(String query){

        try {
            Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmnt.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

      return rs;
    }

}
