package maggi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class User {
	private Scanner sc;
	private Connection con;
	public User(Scanner sc2, Connection con2) {
		this.sc=sc;
	 	this.con=con;
	}
	
public void registration() {
		System.out.println("Full Name: ");
		String full_name=sc.nextLine();
		System.out.println("Email :");
		String email=sc.nextLine();
		System.out.println("Password: ");
		String password=sc.nextLine();
		
		String query="INSERT INTO user{full_name,email,password} VALUES(?,?,?)";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, full_name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			int affectedRows = preparedStatement.executeUpdate();
			if(affectedRows>0) {
				System.out.println("Registration Successfull");
			}else {
				System.out.println("Registration Failed");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}	
	}
}
