package com.myproject.second.qna.vo;

import java.sql.Date;

public class QnaVO {
	private int qnano;
	private int productno;
	private String state;
	private String title;
	private String answer;
	private String id;
	private Date regdate;

	public QnaVO() {
	}

	public QnaVO(int qnano, int productno, String state, String title, String answer, String id, Date regdate) {
		super();
		this.qnano = qnano;
		this.productno = productno;
		this.state = state;
		this.title = title;
		this.answer = answer;
		this.id = id;
		this.regdate = regdate;
	}

	public int getQnano() {
		return qnano;
	}

	public void setQnano(int qnano) {
		this.qnano = qnano;
	}

	public int getProductno() {
		return productno;
	}

	public void setProductno(int productno) {
		this.productno = productno;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

}
