package admin.dao;
import java.sql.SQLException;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Admin;
import webstore.utils.HibernateUtils;

public class AdminDao {

	public Admin verifyPassword(String accountId, String password) throws SQLException {
		Session session = HibernateUtil.getInstance().getCurrentSession();
		Transaction transaction = null;
		try {
//			session.beginTransaction();
//			hql = "select new Admin(a.accountId, a.password) from Admin a where accountId=:id";
//			List<Admin> admins = session.createQuery(hql).setParameter("id", accountId).list();
	
			transaction = session.beginTransaction();
			Admin admin = session.get(Admin.class, accountId);
			if(admin!=null) {
//				Admin admin = admins.get(0);
				if(admin.getPassword().equals(password)) {
					return admin;
				}
			}
			transaction.commit();
		} catch(Exception e) {
			if (transaction!=null) 
				transaction.rollback();
			System.out.println("error occurred in admins dao");
			e.printStackTrace();
		} 
		return null;
	}
}
	
