package com.myproject.second.review.vo;

public class ReviewVO {
	private int reviewno;
	private int productno;
	private String image;
	private String content;
	private String id;

	public ReviewVO() {
	}

	public ReviewVO(int reviewno, int productno, String image, String content, String id) {
		super();
		this.reviewno = reviewno;
		this.productno = productno;
		this.image = image;
		this.content = content;
		this.id = id;
	}

	public int getReviewno() {
		return reviewno;
	}

	public void setReviewno(int reviewno) {
		this.reviewno = reviewno;
	}

	public int getProductno() {
		return productno;
	}

	public void setProductno(int productno) {
		this.productno = productno;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
