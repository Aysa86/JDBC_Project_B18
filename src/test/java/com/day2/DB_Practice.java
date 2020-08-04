package com.day2;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DB_Practice {
    public static void main(String[] args) throws SQLException {

        // print out all data from Jobs Table

        DB_Utility.createConnection();

        ResultSet rs = DB_Utility.runQuery("Select * From Jobs");

        // iterate over the ResultSet
        rs.next();
        // get first 2 column
       // System.out.println(rs.getString(1));

        while (rs.next()){
            System.out.println(rs.getString(1));
        }


        System.out.println("columnCount = " + DB_Utility.getColumnCNT());
        
        

        // what if we want to print out everything in the ResultSet
        // without knowing the column names
        // System.out.println(rs.getString(1) .. 2.. 3.. 4);

        //get the first row data | without knowing the column names
        int columnCount = DB_Utility.getColumnCNT();
        rs.first();

        for (int i = 1; i <= columnCount; i++){
            System.out.print(rs.getString(i) + "\t");
        }

    }
}
