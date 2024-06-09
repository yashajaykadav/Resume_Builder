package minipro;

import java.sql.DriverManager;

public class DataBaseCon{
	public java.sql.Connection con;

	public void DataBase()throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ResumeBuilder","root","");

		System.out.println("Connected!");
	}
}