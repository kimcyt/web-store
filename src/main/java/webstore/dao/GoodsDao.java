package webstore.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import model.Good;
import webstore.utils.JdbcUtil;

public class GoodsDao {

	public List<Good> findAllGoods() {
		
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		
		String sql = "select * from goods";
		List<Good> allGoods = null;
		try {
			allGoods = qr.query(sql, new BeanListHandler<Good>(Good.class));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return allGoods;

	}

}
