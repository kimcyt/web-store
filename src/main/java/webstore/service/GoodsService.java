package webstore.service;

import java.sql.SQLException;
import java.util.List;

import admin.dao.GoodsDao;
import webstore.domain.Goods;

public class GoodsService {
	//service call dao to get data
	public List<Goods> getAllGoods() throws SQLException {
		
		GoodsDao goodsDao = new GoodsDao();
	
		return goodsDao.findAllGoods();
	}


}
