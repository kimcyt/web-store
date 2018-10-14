package webstore.domain;

import java.util.HashMap;

public class Categories {
	private Integer NO;
	private String name;
	private static HashMap<Integer, String> categories;
	
	public Categories() {
		super();
	}
	
	public Categories(Integer no, String name) {
		this.NO = no;
		this.name = name;
	}
	
	
	
	public Integer getNO() {
		return NO;
	}

	public void setNO(Integer nO) {
		NO = nO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void setCategories(HashMap<Integer, String> categories) {
		Categories.categories = categories;
	}



	static {
		categories = new HashMap<Integer, String>();
		categories.put(1, "Office Supplies");
		categories.put(2, "Furniture");
		categories.put(3, "Fresh Produce");
		categories.put(4, "Books Audio");
		categories.put(5, "Fashion Designs");
	}
	
	public static HashMap<Integer, String> getCategories(){
		return categories;
	}
	
}




