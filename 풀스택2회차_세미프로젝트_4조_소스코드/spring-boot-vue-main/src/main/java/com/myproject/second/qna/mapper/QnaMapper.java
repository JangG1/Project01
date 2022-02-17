package com.myproject.second.qna.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.myproject.second.qna.vo.QnaVO;

@Mapper
public interface QnaMapper {
	@Select("select count(qnano) from s_qna where productno = #{productno}")
	int qnaCount(@Param("productno") int productno);

	@Select("select * from s_qna where productno = #{productno} order by qnano desc")
	List<QnaVO> findAllQna(@Param("productno") int productno);

	@Insert("insert into s_qna (qnano, productno, title, id) values (qna_seq.NEXTVAL, #{productno}, #{title}, #{id})")
	void addQna(@Param("productno") int productno, @Param("title") String title, @Param("id") String id);
}