package com.day3;


import com.cybertek.jdbc.utility.DB_Utility;


public class SpartanDB_Practice {
    public static void main(String[] args) {

        //String url = "jdbc:oracle:thin:@100.25.162.89:1521:XE";
        //DB_Utility.createConnection(url, "SP", "SP");

        DB_Utility.createConnection();


        // Run query "SELECT * FROM SPARTANS"
        DB_Utility.runQuery("Select * from Spartans");

        //1. Display all data in console
       // DB_Utility.displayAllData();


        //2. Print column count
       System.out.println( "Column Count is " + DB_Utility.getColumnCNT()  );

       //3. Print row count
       System.out.println("Row count is " + DB_Utility.getRowCount() );

       //4. Print out 3rd row data as a list
        System.out.println("3rd row data as list \n" + DB_Utility.getRowDataAsList(3) );

        //5. Print out 2nd column data as a list
        System.out.println("2nd column as a list \n" + DB_Utility.getColumnDataAsList(2));

        //6, Print out Name column data as a list
        System.out.println("Name column as a list \n" + DB_Utility.getColumnDataAsList("Name"));

        //7, Print out 4th row as a Map
        System.out.println("4th row as a Map \n" + DB_Utility.getRowMap(4));

        // 8, Print out the data at row 5, column 1
        System.out.println("Data at row 5, 1st column data \n" + DB_Utility.getColumnDataAtRow(5, 1));

       // 9, Print out the data at row 53, phone column
        System.out.println("Data at row 53 Phone column : --> " + DB_Utility.getColumnDataAtRow(53, "PHONE"));

        //10. Print out all the data as List of Map

        // we are storing each row as map object
        // and we have 100 row, so can store this 100 map objects into one Collection
        // --> List of these Map object List< Map<String, String> >
        System.out.println("All the data as List of Map \n" + DB_Utility.getAllDataAsListOfMap());


       // DB_Utility.createConnection("dev");
        DB_Utility.createConnection("test");

        DB_Utility.destroy();


    }

}
