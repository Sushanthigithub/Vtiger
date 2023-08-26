package datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyDatabase {

	public static void main(String[] args) throws SQLException {
		// Step1: Create an instance of JDBC Driver
		Driver dbDriver = new Driver();

		// Step2: Register Driver
		DriverManager.registerDriver(dbDriver);

		// Step3: Establish database connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel", "root", "root");
		// mysql JDBC url

		// Step4: Create Statement
		Statement statement = connection.createStatement();
		
		//step5: Execute query to update database
		int result=statement.executeUpdate("insert into employees(id,name,salary,phone)"+
		                                     " values(105,'EFG',55000,'9876501234');");
		if(result==1)
		   System.out.println("Database Updated Successfully");
		else
			System.out.println("Database Modification Failed");
		
		//step6:close database connection
		connection.close();
	}

}
