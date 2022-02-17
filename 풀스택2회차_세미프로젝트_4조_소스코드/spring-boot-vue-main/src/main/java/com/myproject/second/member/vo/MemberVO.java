package com.myproject.second.member.vo;

public class MemberVO {
	private String id;
	private String nickname;
	private String password;
	private String name;
	private String tel;
	private String zipcode;
	private String address;
	private String detailaddr;
	private String email;
	private int point;
	private String authority;
	private String companyno;

	public MemberVO() {
	}

	public MemberVO(String id, String nickname, String password, String name, String tel, String zipcode,
			String address, String detailaddr, String email, int point, String authority, String companyno) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.password = password;
		this.name = name;
		this.tel = tel;
		this.zipcode = zipcode;
		this.address = address;
		this.detailaddr = detailaddr;
		this.email = email;
		this.point = point;
		this.authority = authority;
		this.companyno = companyno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailaddr() {
		return detailaddr;
	}

	public void setDetailaddr(String detailaddr) {
		this.detailaddr = detailaddr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getCompanyno() {
		return companyno;
	}

	public void setCompanyno(String companyno) {
		this.companyno = companyno;
	}

}