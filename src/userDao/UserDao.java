package userDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistence.ConnectionMaker;
import user.User;

public class UserDao {
	
	private ConnectionMaker connectionMaker;
	
	// connectionMaker를 만드는 책임을 클라이언트에게 떠넘긴다 (만들어서 주입받음)
	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException{
		Connection c = connectionMaker.makeConnection();
		
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
		Connection c = connectionMaker.makeConnection();
		
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
		Connection c = connectionMaker.makeConnection();
		PreparedStatement ps = c.prepareStatement("delete from users");
		
		ps.executeUpdate();
		
		int result = ps.executeUpdate();
		
		ps.close();
		c.close();
		System.out.println("result >> " + result);
	}
}
