package telephonedirectory;
import java.sql.*;

public class TelephoneDirectory {
	
	public static void main(String args[]) throws Exception
	{
		createtable();	
		insert();
		retrive();

	}
	
	public static void retrive() throws Exception{
		try {
			Connection con = getConnection();
			Statement st= con.createStatement();
			ResultSet rs = st.executeQuery("select * from information where id=1");
			
			rs.next();
			int id=rs.getInt("Id");
			String name = rs.getString("Name");
			int phone_no = rs.getInt("phone_nO");
			String city = rs.getString("City");
			
			System.out.println(id+" "+name+" "+phone_no+" "+city);
			
			
			rs.close();
			con.close();
			
		}catch(Exception e) {
			System.out.println("Insert Exception: "+ e.getMessage());
		}finally{
			System.out.println("Information Inserted");
		}
	}
	
	public static void insert() throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement inserted = con.prepareStatement("INSERT INTO telephonedir (name, phoneno, city) VALUES('ramesh', 1236598587, 'JNK')");
			inserted.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Insert Exception: "+ e.getMessage());
		}finally{
			System.out.println("Information Inserted");
		}
	}
	

	
	public static void createtable() throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS telephonedir(id int NOT NULL AUTO_INCREMENT, name varchar(50), phoneno int(10), city varchar(50), PRIMARY KEY(id))");
			create.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("CreateTabe Exception: "+ e.getMessage());
		}finally{
			System.out.println("Table created");
		}
	}
	
	
	
	public static Connection getConnection() throws Exception{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/telephonedirectory","username","password");
			System.out.println("Connected");
			return con;
		}catch(Exception e){
			System.out.println("Connection Exception: "+e.getMessage());
		}
		return null;
	}

}
