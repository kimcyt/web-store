package admin.dao;
  
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import webstore.domain.Admins;
import webstore.domain.Goods;
import webstore.utils.JdbcUtil;

public class AdminsDao {
	private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	private String sql = "";
	
	private boolean verifyPassword(String accountId, String password) throws SQLException {
		sql = "select password from admins where accountId=?";
		List<Admins> admins = qr.query(sql, new BeanListHandler<Admins>(Admins.class), accountId);
		if(!admins.isEmpty()) {
			Admins user = admins.get(0);
			System.out.println("onrecord:"+user.getPassword()+"  input:"+ password);
			if(user.getPassword().equals(password)) {
				System.out.println("matched");
				return true;
			}
		}
		return false;
			
	}
	
	public boolean updatePassword(String accountId, String oldPwd, String newPwd) throws SQLException {
		if(this.verifyPassword(accountId, oldPwd)) {
			sql = "update admins set password=? where accountId=?";
			qr.update(sql, newPwd, accountId);
			return true;
		}
		return false;
	}
}
