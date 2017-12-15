package com.dbms.proj;


//STEP 1. Import required packages
import java.sql.*;
import java.util.Scanner;

public class AddFacultyInfo {
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
  //STEP 2: Register JDBC driver
  Class.forName("com.mysql.jdbc.Driver");

  //STEP 3: Open a connection
  System.out.println("Connecting to a selected database...");
  conn = DriverManager.getConnection(DB_URL, USER, PASS);
  System.out.println("Connection successful!");
  
  //STEP 4: Execute a query
  System.out.println("Add record to faculty info table");
  
  System.out.println("Enter faculty ID: ");
  int deptId = sc.nextInt(); sc.nextLine();
  System.out.println("Enter first name: ");
  String firstName = sc.nextLine(); 
  System.out.println("Enter last name: ");
  String lastName = sc.nextLine(); 
  System.out.println("Enter address: ");
  String facultyAddress = sc.nextLine(); 
  System.out.println("Enter phone no. : ");
  String phone = sc.nextLine(); 
  System.out.println("Enter department ID: ");
  int departmentId = sc.nextInt();  
         
  stmt = conn.createStatement();
  
  String sql = "INSERT INTO faculty_info(faculty_id, first_name, last_name, address, phone_no, dept_id) VALUES (?,?,?,?,?,?)";
  // create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setInt(1, deptId);
			preparedStmt.setString(2, firstName); 
			preparedStmt.setString(3, lastName);
			preparedStmt.setString(4, facultyAddress);
			preparedStmt.setString(5, phone);
			preparedStmt.setInt(6, departmentId);
				
	 preparedStmt.execute();
	 System.out.println("A row has been added!");
  	
    //System.out.println(sql);
  //stmt.executeUpdate(sql);

}catch(SQLException se){
  se.printStackTrace();
  //Handle errors for JDBC
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
}//end try
}//end main
}//end JDBCExample
