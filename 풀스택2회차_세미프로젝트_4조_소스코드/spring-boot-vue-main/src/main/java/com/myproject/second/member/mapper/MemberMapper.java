package com.myproject.second.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myproject.second.member.vo.MemberVO;

@Mapper
public interface MemberMapper {
	@Select("SELECT * from s_member")
	List<MemberVO> findAll();

	@Select("SELECT name, tel, zipcode, address, detailaddr, point from s_member where id = #{id}")
	MemberVO getMemberInfo(@Param("id") String id);

	@Select("SELECT * from s_member where id = LOWER(#{id})")
	MemberVO findMember(@Param("id") String id);

	@Select("SELECT nickname from s_member where id = (SELECT sellerid from s_product where productno = #{productno})")
	String getNickname(@Param("productno") int productno);

	@Select("SELECT count(id) from s_member where UPPER(id) = UPPER(#{id})")
	int idCheck(@Param("id") String id);

	@Insert("insert into s_member ( id, nickname, password, name, tel, email, zipcode, address, detailaddr, authority) values ( LOWER(#{in.id}), #{in.nickname}, #{in.password}, #{in.name}, #{in.tel}, #{in.email}, #{in.zipcode}, #{in.address}, #{in.detailaddr}, #{in.authority})")
	void insertUser(@Param("in") MemberVO in);

	@Insert("insert into s_member ( id, nickname, password, name, tel, email, zipcode, address, detailaddr, authority, companyno) values ( LOWER(#{in.id}), #{in.nickname}, #{in.password}, #{in.name}, #{in.tel}, #{in.email}, #{in.zipcode}, #{in.address}, #{in.detailaddr}, #{in.authority}, #{in.companyno})")
	void insertSeller(@Param("in") MemberVO in);

	@Update("update s_member set point = point - #{point} where id = #{id}")
	void updatePoint(@Param("id") String id, @Param("point") int point);

	@Update("update s_member set nickname = #{nickname} where id = #{id}")
	void updateNickname(@Param("id") String id, @Param("nickname") String nickname);

	@Update("update s_member set password = #{password} where id = #{id}")
	void updatePassword(@Param("id") String id, @Param("password") String password);

	@Update("update s_member set tel = #{tel} where id = #{id}")
	void updateTel(@Param("id") String id, @Param("tel") String tel);

	@Update("update s_member set zipcode = #{zipcode}, address = #{address}, detailaddr = #{detailaddr} where id = #{id}")
	void updateAddress(@Param("id") String id, @Param("zipcode") String zipcode, @Param("address") String address,
			@Param("detailaddr") String detailaddr);

	@Delete("delete from s_member where id = #{id}")
	void deleteMember(@Param("id") String id);
}
