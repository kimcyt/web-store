package webstore.domain;

import java.util.List;


final public class PageInfo {
	private final int currentPage;
	private final long totalItems;
	private final int totalPages;
	private final List<Goods> goodList;
	
	
	
	private PageInfo(int currentPage, long totalItems, int totalPages, List<Goods> goodList) {
		this.currentPage = currentPage;
		this.totalItems = totalItems;
		this.totalPages = totalPages;
		this.goodList = goodList;
	}
	
	public static PageInfo getPageInfo(int currentPage, long totalItems, List<Goods> goodList, int itemsPerPage) {
		int totalP = (int)Math.ceil(totalItems/itemsPerPage)+1;
		return new PageInfo(currentPage, totalItems, totalP, goodList);
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public long getTotalItems() {
		return totalItems;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public List<Goods> getGoodList() {
		return goodList;
	}
	
	
}
