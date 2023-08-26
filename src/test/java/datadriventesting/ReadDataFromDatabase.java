package datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabase
{
	public static void main(String[] args) throws SQLException
	{
		//Step1: Create an instance of JDBC  Driver
		Driver dbDriver=new Driver();
		
		//Step2: Register Driver
		DriverManager.registerDriver(dbDriver);
		
		//Step3: Establish database connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel","root","root");
		//mysql JDBC url
		
		
		//Step4: Create Statement
		Statement statement=connection.createStatement();
		
		//step5: Execute query to fetch data
		ResultSet result=statement.executeQuery("select * from employees;");
		
		while(result.next()) {
			System.out.println(result.getInt("id")+"\t"+result.getString("name")+"\t"+result.getInt("salary")+"\t"+result.getString("phone"));
		}
		
		//step6: close database connection
		connection.close();

	}

}
