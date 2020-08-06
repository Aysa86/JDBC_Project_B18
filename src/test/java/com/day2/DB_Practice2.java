package com.day2;

import oracle.net.jdbc.TNSAddress.SOException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Practice2 {

    public static void main(String[] args) throws SQLException {

        // print out all data from Jobs Table

        DB_Utility.createConnection();

        ResultSet rs = DB_Utility.runQuery("Select * From Regions");

        // this method call is displaying the data of the ResultSet
        DB_Utility.displayAllData();

        // move ResultSet cursor to second row
       // rs.absolute(2);

        DB_Utility.runQuery("Select * from Locations");

        DB_Utility.displayAllData();
        System.out.println( DB_Utility.getColumnDataAtRow(2,2));

        System.out.println(DB_Utility.getColumnDataAtRow(3,"State_province"));

        System.out.println( DB_Utility.getRowDataAsList(4));

        System.out.println(DB_Utility.getColumnDataAsList(2));

        System.out.println(DB_Utility.getColumnDataAsList("City"));


       // get the first row data | without knowing the column names
       // int columnCount = DB_Utility.getColumnCNT();
         // in order to get whole result cursor must be at before first location!!!
       // while (rs.next() == true){ // row iteration

        //    for (int i = 1; i <= columnCount; i++){       // column iteration
          //      System.out.print(rs.getString(i) + "\t");
         //  }
          //  System.out.println(); // adding a blank line for next line}





    }

}
