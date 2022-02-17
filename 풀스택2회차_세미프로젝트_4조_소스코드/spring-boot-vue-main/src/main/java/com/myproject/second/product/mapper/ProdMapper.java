package com.myproject.second.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myproject.second.product.vo.ProdVO;

@Mapper
public interface ProdMapper {
	@Select("select * from s_product")
	List<ProdVO> findAllProduct();

	@Select("select * from s_product where productno = #{productno}")
	ProdVO findProduct(int productno);

	@Select("select s_product.productno, s_product.productname, s_product.ptype, s_product.imagename, s_product.price, s_product.sellerid, s_member.nickname from s_product left join s_member on s_product.sellerid = s_member.id where UPPER(productname) like UPPER(#{productname}) or UPPER(ptype) like UPPER(#{productname}) order by s_product.productno")
	List<ProdVO> searchProduct(@Param("productname") String productname);

	@Select("select count(productno) from s_product where price >= #{min} and price <= #{max} and (UPPER(productname) like UPPER(#{productname}) or UPPER(ptype) like UPPER(#{productname}))")
	int getCount(@Param("productname") String productname, @Param("min") int min, @Param("max") int max);

	@Select("select s_product.productno, s_product.productname, s_product.ptype, s_product.imagename, s_product.price, s_product.sellerid, s_member.nickname from s_product left join s_member on s_product.sellerid = s_member.id where price >= #{min} and price <= #{max} and (UPPER(productname) like UPPER(#{productname}) or UPPER(ptype) like UPPER(#{productname})) order by s_product.productno")
	List<ProdVO> searchMinMaxProduct(@Param("productname") String productname, @Param("min") int min,
			@Param("max") int max);

	@Select("select * from s_product where sellerid = #{sellerid} order by productno")
	List<ProdVO> findSalesList(String sellerid);

	@Select("select option1 from s_product where productno = #{productno}")
	String findOption1(int productno);

	@Select("select option2 from s_product where productno = #{productno}")
	String findOption2(int productno);

	@Select("select s_product.productno, s_product.imagename, sum(s_order.totalprice) tot from s_product left join s_order on s_product.productno = s_order.productno where sellerid = (select sellerid from s_product where productno = #{productno}) and s_product.productno != #{productno} group by s_product.productno,s_product.imagename order by tot desc")
	List<ProdVO> findAllProductImage(int productno);

	@Select("select prod_seq.currval from dual")
	int getProductNo();

	@Insert("insert into s_product(productno, sellerid, productname, ptype, imagename, price, option1, option2, regdate, detailimagename, amount) values (prod_seq.nextval, #{in.sellerid}, #{in.productname}, #{in.ptype}, #{in.imagename}, #{in.price}, #{in.option1}, #{in.option2}, to_char(sysdate, 'yyyy.mm.dd hh24:mi'), #{in.detailimagename}, #{in.amount})")
	@Options(useGeneratedKeys = true, keyProperty = "result.productno", keyColumn = "productno")
	int insertProduct(@Param("in") ProdVO in, @Param("result") ProdVO result);

	@Update("update s_product set productname = #{in.productname}, ptype = #{in.ptype}, price = #{in.price}, option1 = #{in.option1}, option2 = #{in.option2}, imagename = #{in.imagename}, detailimagename = #{in.detailimagename}, amount= #{in.amount} where productno = #{in.productno}")
	int updateProduct(@Param("in") ProdVO in, @Param("result") ProdVO result);
	
	@Select("select count(productno) from s_product where sellerid = #{sellerid}")
	int haveProduct(@Param("sellerid") String sellerid);

	@Update("update s_product set onsale = #{onsaleValue} where productno = #{productno}")
	int onSaleProduct(@Param("onsaleValue") String onsale, @Param("productno") int productno);

	@Select("Select * from s_product where LOWER(productname) like '%'||#{name}||'%' order by productno")
	List<ProdVO> findByName(@Param("name") String name);

	@Select("Select * from s_product where productno = #{productno}")
	List<ProdVO> findByNo(@Param("productno") int productno);

	@Update("Update s_product set amount = amount - #{amount} where productno = #{productno}")
	void updateAmount(@Param("productno") int produtno, @Param("amount") int amount);
}
