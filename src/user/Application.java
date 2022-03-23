package user;

import java.sql.SQLException;

import userDao.NUserDao;
import userDao.UserDao;

public class Application {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao dao = new NUserDao();
		dao.delete();
		dao.add(new User("aaa", "ภๅฟ๘มุ", "1234"));
		
		System.out.println(dao.get("aaa"));
	}
}
