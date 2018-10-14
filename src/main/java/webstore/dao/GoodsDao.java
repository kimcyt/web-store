package webstore.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import webstore.domain.Goods;
import webstore.utils.JdbcUtil;

public class GoodsDao {

	public List<Goods> findAllGoods() {
		
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		
		String sql = "select * from goods";
		List<Goods> allGoods = null;
		try {
			allGoods = qr.query(sql, new BeanListHandler<Goods>(Goods.class));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return allGoods;

	}

}
