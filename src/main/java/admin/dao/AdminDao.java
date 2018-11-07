package admin.dao;
import java.sql.SQLException;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import model.Admin;
import webstore.utils.HibernateSession;

public class AdminDao {
	private String hql = "";
	private Session session = HibernateSession.createSession();
	
	public Admin verifyPassword(String accountId, String password) throws SQLException {
		try {
//			session.beginTransaction();
//			hql = "select new Admin(a.accountId, a.password) from Admin a where accountId=:id";
//			List<Admin> admins = session.createQuery(hql).setParameter("id", accountId).list();
			Admin admin = session.get(Admin.class, accountId);
			if(admin!=null) {
//				Admin admin = admins.get(0);
				if(admin.getPassword().equals(password)) {
					return admin;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			
			System.out.println("error occurred in admins dao");
		} finally {
			//clean up resources
			session.close();
		}
		return null;
	}
}
