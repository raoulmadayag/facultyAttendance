package com.dbms.proj;

//STEP 1. Import required packages
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class AddUpdateFacultyAttendance {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/facultyattendance";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection successful!");

			// STEP 4: Execute a query
			System.out.println("Add record to faculty attendance table");
			System.out.println("Enter log ID: ");
			int logid = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter login time: ");
			String loginTime = sc.nextLine();
			System.out.println("Enter logout time: ");
			String logoutTime = sc.nextLine();
			System.out.println("Enter date(yyyy-mm-dd): ");
			String logDate = sc.nextLine();
			System.out.println("Enter subject code: ");
			String subjCode = sc.nextLine();

			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date date = sdf1.parse(logDate);
			java.sql.Date date2 = new java.sql.Date(date.getTime());
			

			String sql = "INSERT INTO faculty_attendance(log_id, log_in, log_out, date, code) VALUES (?,?,?,?,?)";
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setInt(1, logid);
			preparedStmt.setString(2, loginTime);
			preparedStmt.setString(3, logoutTime);
			preparedStmt.setDate(4, date2);
			preparedStmt.setString(5, subjCode);

			// execute the preparedstatement
			preparedStmt.execute();
			System.out.println("A row has been added!");

		} catch (SQLException se) {
			se.printStackTrace();
			// Handle errors for JDBC
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	}// end main
}// end JDBCExample
