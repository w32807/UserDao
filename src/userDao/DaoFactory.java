package userDao;

import persistence.ConnectionMaker;
import persistence.DConnectionMaker;

public class DaoFactory {

	public UserDao userDao() {
		return new UserDao(connectionMaker());
	}
	
	private ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
}
