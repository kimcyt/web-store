package model;


public class Good {
	private Integer gId;
	private String name;
	private String image;
	private Double price;
	private Integer category;
	private Integer onsale;

	public Good() {
		super();
	}

	public Good(String name, String image, Double price, Integer category, Integer onsale) {
		this.name = name;
		this.image = image;
		this.price = price;
		this.category = category;
		this.onsale = onsale;
	}
	
	public Integer getgId() {
		return gId;
	}

	public void setgId(Integer gId) {
		this.gId = gId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Integer getOnsale() {
		return onsale;
	}

	public void setOnsale(Integer onsale) {
		this.onsale = onsale;
	}

	@Override
	public String toString() {
		return "Goods [gId=" + gId + ", name=" + name + ", image=" + image + ", price=" + price + ", category="
				+ category + ", onsale=" + onsale + "]";
	}
}
