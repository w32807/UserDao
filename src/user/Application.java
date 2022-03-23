package user;

import java.sql.SQLException;

import persistence.NConnectionMaker;
import userDao.UserDao;

public class Application {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao dao = new UserDao(new NConnectionMaker());
		dao.delete();
		dao.add(new User("aaa", "ภๅฟ๘มุ", "1234"));
		
		System.out.println(dao.get("aaa"));
	}
}
