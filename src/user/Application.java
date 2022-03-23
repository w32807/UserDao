package user;

import java.sql.SQLException;

import userDao.DaoFactory;
import userDao.UserDao;

public class Application {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// dao들을 만들어주는 팩토리를 만들고 팩토리를 호출하기만 함
		UserDao dao = new DaoFactory().userDao();
		dao.delete();
		dao.add(new User("aaa", "장원준", "1234"));
		
		System.out.println(dao.get("aaa"));
	}
}
