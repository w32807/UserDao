package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	
	public void add(User user) throws ClassNotFoundException, SQLException{
		Class.forName("org.h2.Driver");
		Connection c = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values (?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		int result = ps.executeUpdate();
		
		ps.close();
		c.close();
		System.out.println("result >> " + result);
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException{
		Class.forName("org.h2.Driver");
		Connection c = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return user;
	}
	
	public void delete() throws ClassNotFoundException, SQLException{
		Class.forName("org.h2.Driver");
		Connection c = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		PreparedStatement ps = c.prepareStatement("delete from users");
		
		ps.executeUpdate();
		
		int result = ps.executeUpdate();
		
		ps.close();
		c.close();
		System.out.println("result >> " + result);
	}
	
}
