package admin.service;

import java.sql.SQLException;
import java.util.List;

import admin.dao.GoodsDao;
import webstore.domain.Categories;
import webstore.domain.Goods;
import webstore.domain.PageInfo;

public class GoodsService {
	
	private GoodsDao goodsDao = new GoodsDao();

	public List<Categories> getAllCategories() throws SQLException{
		return goodsDao.findAllCategories();
	}
	
	public Goods getCurrentGood(String gid) throws SQLException {
		return goodsDao.findCurrentGood(gid);
	}
	
	public List<Goods> getAllGoods() throws SQLException {
		return goodsDao.findAllGoods();
	}
	
	public void addGood(String name, String image, String price, String cato, String sale) throws SQLException {
		goodsDao.addGood(name, image, price, cato, sale);
	}
	
	public void updateGood(String gId, String name, String image, String price, String cato, String sale) throws SQLException {
		goodsDao.updateGood(gId, name, image, price, cato, sale);
	}
	
	public void deleteGood(String gid) throws SQLException {
		goodsDao.deleteGood(gid);
	}

	public PageInfo getPageInfo(String pageNum, String itemsPerPage) throws SQLException {
		return goodsDao.getPageInfo(pageNum, itemsPerPage);
	}

	public PageInfo getCategoryPageInfo(String category, String pageNum, String itemsPerPage) throws NumberFormatException, SQLException {
		return goodsDao.getPageInfoInCategory(category, pageNum, itemsPerPage);
	}



}
