package model;

import java.util.HashMap;

public class Category {
	private Integer NO;
	private String name;
	private static HashMap<Integer, String> categories;
	
	public Category() {
		super();
	}
	
	public Category(Integer no, String name) {
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
		Category.categories = categories;
	}



	static {
		categories = new HashMap<Integer, String>();
		categories.put(1, "Office Supplies");
		categories.put(2, "Furniture");
		categories.put(3, "Fresh Produce");
		categories.put(4, "Books and Audio");
		categories.put(5, "Fashion Design");
	}
	
	public static HashMap<Integer, String> getCategories(){
		return categories;
	}
	
}




