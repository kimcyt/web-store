package admin.service;
      
import java.sql.SQLException;

import admin.dao.AdminsDao;

public class AdminsService {
	private AdminsDao AdminsDao = new AdminsDao();
	
	public boolean updatePassword(String accountId, String oldPwd, String newPwd) throws SQLException {
		return AdminsDao.updatePassword(accountId, oldPwd, newPwd);
	}
}
