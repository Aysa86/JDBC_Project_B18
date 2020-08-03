package com.day1;

import java.sql.*;

public class DB_Connection {
    public static void main(String[] args) throws SQLException {


        // connection --> statement --> result test

        // driver manager is used to get the connection
       // the IP address is the IP address of EC2 instance that have Oracle database
        // This is known as connection string or url
        // it has few parts:
        // "jdbc" - making jdbc connection, always starts with this
        // oracle - the database vendor (RDBMS) name we are trying to connect
        // thin - 1 type of oracle driver we are using(downloaded using pom dependency)
        // @100.25.162.89 - my IP address
        // 1521 - port number of your server, usually 1521 for oracle, 3306 for MySql database
        // XE - SID name unique identifier for the database we are connecting
        //  In a nutshell , see it as a full address of your database you can use to make connection
        String connectionString = "jdbc:oracle:thin:@100.25.162.89:1521:XE";
        String userName = "hr";
        String password = "hr";


        // JDBC ship with JDK, and has a lot of pre-written codes to work with database
        // everything we do below comes from java.sql package

        // creating connection object using DriverManager's static method connection
        Connection conn = DriverManager.getConnection(connectionString, userName, password);



        // creating statement object using the connection we have established
        Statement stmnt = conn.createStatement();

        // resultSet object is what we use to store the actual result we get from query
       ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS");

       // resultSet comes with a cursor used to navigate between rows
        // initially the cursor is at before first location(right before the first row)
        // in order to come to the first row we need to move the cursor
        // next() method is used to move the cursor and return the result as boolean

        rs.next(); // currently we are at the very first row

        // getting the column data we use multiple get methods available in ResultSet
        // print out region id and region name, both as String


        System.out.println( "first column value using index --> " + rs.getString(1));
        System.out.println( "first column value using column_name --> " + rs.getString("Region_id"));

        // printing out second column data

        System.out.println("second column value using index --> " + rs.getString(2));
        System.out.println( "second column value using column_name --> " + rs.getString("Region_name"));

        // printing next row and getting second row of data

        rs.next();
        System.out.println("first column value using index --> " + rs.getString(1));
        System.out.println( "first column value using column_name --> " + rs.getString("Region_id"));

        System.out.println("second column value using index --> " + rs.getString(2));
        System.out.println( "second column value using column_name --> " + rs.getString("Region_name"));


        // order we created
        // connection --> statement --> resultSet

        // order when we close
        // resultSet --> statement --> connection

        // it's always good practice to close the resources once finish using them
        rs.close();
        stmnt.close();
        conn.close();


        System.out.println("The end");
    }
}