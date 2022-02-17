package com.myproject.second.product.vo;

public class ProdVO {
	private int productno;
	private String productname;
	private String ptype;
	private String imagename;
	private int price;
	private String option1;
	private String option2;
	private int amount;
	private String regdate;
	private String sellerid;
	private String detailimagename;
	private String onsale;
	private String nickname;
	private int min;
	private int max;

	public ProdVO() {
	}

	public ProdVO(int productno, String productname, String ptype, String imagename, int price, String option1,
			String option2, int amount, String regdate, String sellerid, String detailimagename, String onsale,
			String nickname, int min, int max) {
		super();
		this.productno = productno;
		this.productname = productname;
		this.ptype = ptype;
		this.imagename = imagename;
		this.price = price;
		this.option1 = option1;
		this.option2 = option2;
		this.amount = amount;
		this.regdate = regdate;
		this.sellerid = sellerid;
		this.detailimagename = detailimagename;
		this.onsale = onsale;
		this.nickname = nickname;
		this.min = min;
		this.max = max;
	}

	public int getProductno() {
		return productno;
	}

	public void setProductno(int productno) {
		this.productno = productno;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getSellerid() {
		return sellerid;
	}

	public void setSellerid(String sellerid) {
		this.sellerid = sellerid;
	}

	public String getDetailimagename() {
		return detailimagename;
	}

	public void setDetailimagename(String detailimagename) {
		this.detailimagename = detailimagename;
	}

	public String getOnsale() {
		return onsale;
	}

	public void setOnsale(String onsale) {
		this.onsale = onsale;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

}
