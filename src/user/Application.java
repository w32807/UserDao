package user;

import java.sql.SQLException;

import userDao.DaoFactory;
import userDao.UserDao;

public class Application {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// dao���� ������ִ� ���丮�� ����� ���丮�� ȣ���ϱ⸸ ��
		UserDao dao = new DaoFactory().userDao();
		dao.delete();
		dao.add(new User("aaa", "�����", "1234"));
		
		System.out.println(dao.get("aaa"));
	}
}
