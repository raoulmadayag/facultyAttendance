package com.dbms.proj;
//STEP 1. Import required packages
import java.sql.*;
import java.util.Scanner;

public class UpdateFacultySched {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/facultyattendance";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
 
   public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   Connection conn = null;
   Statement stmt = null;
   
   try{
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connection Successful!");
      
      //accepting input from user
      System.out.println("Enter Faculty ID: ");
      String facultyID = sc.nextLine();
      
      System.out.println("Enter Subject Code: ");
      String subjectCode = sc.nextLine();
      
      System.out.println("Enter New Time: ");
      String facultyTime = sc.nextLine();
      
      System.out.println("Enter New Day: ");
      String facultyDay = sc.nextLine();
      
      System.out.println("Enter New Room: ");
      String facultyRoom = sc.nextLine();

      stmt = conn.createStatement();
      String sql = "UPDATE faculty_sched " +
                   "SET time ='" + facultyTime + "' ,day = '" + facultyDay 
                     + "' ,room ='" + facultyRoom + "' WHERE faculty_id ='" + facultyID + "' and code ='" + subjectCode + "'";
		stmt.executeUpdate(sql);

      // Now you can extract all the records
      // to see the updated records
      sql = "SELECT code, subject, time, day, room, faculty_id FROM faculty_sched";
      ResultSet rs = stmt.executeQuery(sql);

      while(rs.next()){
         //Retrieve by column name
         String code = rs.getString("code");
         String subject = rs.getString("subject");
         String time = rs.getString("time");
         String day = rs.getString("day");
         String room = rs.getString("room");
         String faculty_id = rs.getString("faculty_id");

         System.out.println("DataBase has been updated!");
         
      }
      rs.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }
}
}