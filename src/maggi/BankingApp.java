package maggi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class BankingApp {
private final static String url="jdbc:mysql://localhost:3306//bank_db";
private final static String username="root";
private final static String password="root";
	public static void main(String[] args) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			Connection con=DriverManager.getConnection(url,username,password);
			Scanner sc=new Scanner(System.in);

			User user=new User(sc,con);
			user.registration();
		}
		 catch (Exception e) {
			System.out.println(e);
		}
	

	}
}
