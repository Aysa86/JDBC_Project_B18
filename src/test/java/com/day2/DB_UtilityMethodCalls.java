package com.day2;



public class DB_UtilityMethodCalls {
    public static void main(String[] args) {

        DB_Utility.createConnection();
        DB_Utility.runQuery("Select * from Jobs");

        DB_Utility.displayAllData();
      //  System.out.println( "Column count is " + DB_Utility.getColumnCNT()); // Column count is 4
      //  System.out.println("Row count is " + DB_Utility.getRowCount()); // Row count is 19

       // System.out.println("Getting 3rd row of Jobs Table \n "
       // + DB_Utility.getRowDataAsList(3)); // [AD_ASST, Administration Assistant, 3000, 6000]

       // System.out.println("Getting 2nd column as a List \n "
      //  + DB_Utility.getColumnDataAsList(2)); // [President, Administration Vice President, Administration Assistant...

      //  System.out.println("Getting Job Title column as a List \n "
        //        + DB_Utility.getColumnDataAsList("Job_title"));

        System.out.println("Getting the data at 3rd row as Map : \n "
                   + DB_Utility.getRowMap(3));

    }
}
