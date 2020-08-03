package com.day1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GettingMoreInfoAboutResultSet {
    public static void main(String[] args) throws SQLException {

        String connectionString = "jdbc:oracle:thin:@100.25.162.89:1521:XE";
        String userName = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionString, userName, password);
        Statement stmnt = conn.createStatement();
        ResultSet rs = stmnt.executeQuery("SELECT * FROM employees");

        // resultSetMetadata is data about the ResultSet like column count, column name
        // any many more info about the ResultSet itself
       // getMetaData() will return ResultSetMetaData object
        ResultSetMetaData rsmd = rs.getMetaData();
        // counting how many column we have in our ResultSet object
      int columnCount = rsmd.getColumnCount();
        System.out.println("Column count = " + columnCount);

        // finding out column name according to index
        String secondColumnName = rsmd.getColumnName(2);
        System.out.println("Name of second column name = " + secondColumnName);

        // how to list all the column name in the resultSet
        // u know how many column we have using getColumnCount method
        // u know how to get column name from index getColumnName method



        // the whole table of employees
        for (int i = 1; i <= columnCount; i++){
            //System.out.println( "Number " + i + " Column name is: " + rsmd.getColumnName(i));

            // to print in one line
            System.out.print(rsmd.getColumnName(i) + "\t");
        }
        System.out.println("#################################");

        // store the column names in the list
        List<String> columnNameList = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++){
            columnNameList.add(rsmd.getColumnName(i));

        }
        System.out.println("Column name list: "+columnNameList);


        // getting column count we need ResultSetMetaData object
        // getting row count
        // we will use rs.last() to move to last row then call rs.getRow() method
        // and that will be the row count of entire ResultSet


        //  --- cleaning up ---
        rs.close();
        stmnt.close();
        conn.close();









    }
}
