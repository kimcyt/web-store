package webstore.service;

import java.sql.SQLException;
import java.util.List;

import admin.dao.GoodsDao;
import model.Good;

public class GoodsService {
	//service call dao to get data
	public List<Good> getAllGoods() throws SQLException {
		
		GoodsDao goodsDao = new GoodsDao();
	
		return goodsDao.findAllGoods();
	}


}
