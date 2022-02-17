package com.myproject.second.basket.vo;

public class BasketVO {
	private long basketidx;
	private String id;
	private int productno;
	private String option1;
	private String option2;
	private int amount;
	private String productname;
	private String imagename;
	private int price;
	private String seller;

	public BasketVO() {
	}

	public BasketVO(long basketidx, String id, int productno, String option1, String option2, int amount,
			String productname, String imagename, int price, String seller) {
		super();
		this.basketidx = basketidx;
		this.id = id;
		this.productno = productno;
		this.option1 = option1;
		this.option2 = option2;
		this.amount = amount;
		this.productname = productname;
		this.imagename = imagename;
		this.price = price;
		this.seller = seller;
	}

	public long getBasketidx() {
		return basketidx;
	}

	public void setBasketidx(long basketidx) {
		this.basketidx = basketidx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getProductno() {
		return productno;
	}

	public void setProductno(int productno) {
		this.productno = productno;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

}
