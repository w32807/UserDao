package userDao;

import persistence.DConnectionMaker;

public class DaoFactory {

	public UserDao userDao() {
		return new UserDao(new DConnectionMaker());
	}
}
