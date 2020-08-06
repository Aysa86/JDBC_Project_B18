package com.day2;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DB_Utility {
// adding static field so we can access in all static methods
   private static Connection conn;
   private static ResultSet rs ;
   private static Statement stmnt;


    /**
     * cleaning up the resources
     */
    public static void destroy(){

        try{
            if(rs!=null){
                rs.close();
            }
            if(stmnt!=null){
                stmnt.close();
            }
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



   /*
   we want to store certain row data as a map
   give me number row 3 --->> Map<String, String> {region_id : 3, region_name : Asia}
    */

   /*
   columnIndex = the column you want to get a List out of
   return List of String that contains entire column data from 1st row to last row

    */
    public static List<String> getColumnDataAsList(int columnIndex){
        List<String> columnDataList = new ArrayList<>();
        try {
            rs.beforeFirst(); // moving the cursor to beforeFirst location
            while (rs.next()) {
                // getting the data from that column and adding to the List
                columnDataList.add(rs.getString(columnIndex));
            }
            rs.beforeFirst(); // moving the cursor to before first location after we are done
        }catch (SQLException e){
            System.out.println("Error while getColumnDataAsList");
            e.printStackTrace();
        }
        return columnDataList;
    }

    /*
   columnName = the column you want to get a List out of
   return List of String that contains entire column data from 1st row to last row

    */
    public static List<String> getColumnDataAsList(String columnName){
        List<String> columnDataList = new ArrayList<>();
        try {
            rs.beforeFirst(); // moving the cursor to beforeFirst location
            while (rs.next()) {
                // getting the data from that column and adding to the List
                columnDataList.add(rs.getString(columnName));
            }
            rs.beforeFirst(); // moving the cursor to before first location after we are done
        }catch (SQLException e){
            System.out.println("Error while getColumnDataAsList");
            e.printStackTrace();
        }
        return columnDataList;
    }

   public static int getRowCount(){
       int rowCount = 0;
       try {
           rs.last();
           rowCount = rs.getRow();
           // moving back the cursor to before first location just in case
           rs.beforeFirst();

       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
       return rowCount;
   }

   /*
   getting the entire row as List<String>
    */

    public static List<String> getRowDataAsList(int rowNum){
        List<String> rowDataList = new ArrayList<>();
        // how to move to that Row with rowNum
        try {
            rs.absolute(rowNum);
            // iterate over each and every column and add the value to the List
            for (int i = 1; i <= getColumnCNT(); i++){
                rowDataList.add(rs.getString(i));
            }
            // moving the cursor to before first location just in case
            rs.beforeFirst();
        } catch (SQLException e) {
            System.out.println("Error while getRowDataAsList");
            e.printStackTrace();
        }


        return rowDataList;
    }

    /*
    getting the data at that row with that column name


    rowNum = row number we want to get data from
    columnName = column name we want to get the data from the data
     */
    public static String getColumnDataAtRow(int rowNum, String columnName){
        // improve this method and check for valid rowNum and columnName
        // if invalid return emptyString
        String result = "";
        try {
            rs.absolute(rowNum);
            result = rs.getString(columnName);
        } catch (SQLException e) {
            System.out.println("Error while getColumnDataAtRow");
            e.printStackTrace();
        }
        return result;

    }




    /*
   getting single column cell value at certain row
   Ex: row 2 column 3 --> data

   rowNum = row number we want to get data from
   columnIndex = column index we want to get the data from the data in String
    */
    public static String getColumnDataAtRow(int rowNum, int columnIndex){
   // improve this method and check for valid rowNum and columnIndex
        // if invalid return emptyString
        String result = "";
        try {
            rs.absolute(rowNum);
           result = rs.getString(columnIndex);
        } catch (SQLException e) {
            System.out.println("Error while getColumnDataAtRow");
            e.printStackTrace();
        }
         return result;

    }


   /*
   a static method to display all the data in the result set
    */
    public static void displayAllData(){

        // get the first row data | without knowing the column names
        int columnCount = DB_Utility.getColumnCNT();
        // in order to get whole result cursor must be at before first location!!!
        try {
            // in order to start from the beginning, we should be at beforeFirst location
            rs.beforeFirst();
            while (rs.next() == true) { // row iteration

                for (int i = 1; i <= columnCount; i++) {       // column iteration
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println(); // adding a blank line for next line
            }
            // now the cursor is at after last location
            // move it back to before first location so we can have no issue calling the method again
            rs.beforeFirst();
        }catch (SQLException e){
            System.out.println("Error while getting all data");
            e.printStackTrace();
        }
    }

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

    /**
     * We want to store certian row data as a map
     * give me number 3 row  --->> Map<String,String>   {region_id : 3 , region_name : Asia}
     */
    public static Map<String,String> getRowMap( int rowNum ){

        Map<String,String> rowMap = new HashMap<>();
        try{
            rs.absolute(rowNum);
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int colNum = 1; colNum <= getColumnCNT() ; colNum++) {
                String colName = rsmd.getColumnName( colNum );
                String colValue= rs.getString( colNum ) ;
                rowMap.put(colName, colValue);
            }

        }catch (SQLException e){
            System.out.println("ERRROR AT ROW MAP FUNCTION");
            e.printStackTrace();
        }

        return rowMap;
    }



}
