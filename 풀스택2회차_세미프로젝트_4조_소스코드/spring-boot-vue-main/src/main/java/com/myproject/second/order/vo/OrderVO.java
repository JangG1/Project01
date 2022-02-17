package com.myproject.second.order.vo;

import java.sql.Date;

public class OrderVO {
	private long orderidx;
	private String id;
	private int productno;
	private String selectedoption;
	private int totalprice;
	private int amount;
	private Date orderdate;
	private String state;
	private String ordermethod;
	private String seller;
	private String dname;
	private String dtel;
	private String dzipcode;
	private String daddress;
	private String ddetailaddr;
	private String productname;
	private String imagename;
	private String startdate;
	private String enddate;

	public OrderVO() {
	}

	public OrderVO(long orderidx, String id, int productno, String selectedoption, int totalprice, int amount,
			Date orderdate, String state, String ordermethod, String seller, String dname, String dtel, String dzipcode,
			String daddress, String ddetailaddr, String productname, String imagename, String startdate,
			String enddate) {
		super();
		this.orderidx = orderidx;
		this.id = id;
		this.productno = productno;
		this.selectedoption = selectedoption;
		this.totalprice = totalprice;
		this.amount = amount;
		this.orderdate = orderdate;
		this.state = state;
		this.ordermethod = ordermethod;
		this.seller = seller;
		this.dname = dname;
		this.dtel = dtel;
		this.dzipcode = dzipcode;
		this.daddress = daddress;
		this.ddetailaddr = ddetailaddr;
		this.productname = productname;
		this.imagename = imagename;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public long getOrderidx() {
		return orderidx;
	}

	public void setOrderidx(long orderidx) {
		this.orderidx = orderidx;
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

	public String getSelectedoption() {
		return selectedoption;
	}

	public void setSelectedoption(String selectedoption) {
		this.selectedoption = selectedoption;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOrdermethod() {
		return ordermethod;
	}

	public void setOrdermethod(String ordermethod) {
		this.ordermethod = ordermethod;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDtel() {
		return dtel;
	}

	public void setDtel(String dtel) {
		this.dtel = dtel;
	}

	public String getDzipcode() {
		return dzipcode;
	}

	public void setDzipcode(String dzipcode) {
		this.dzipcode = dzipcode;
	}

	public String getDaddress() {
		return daddress;
	}

	public void setDaddress(String daddress) {
		this.daddress = daddress;
	}

	public String getDdetailaddr() {
		return ddetailaddr;
	}

	public void setDdetailaddr(String ddetailaddr) {
		this.ddetailaddr = ddetailaddr;
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

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

}