package com.myproject.second.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myproject.second.order.vo.OrderVO;
import com.myproject.second.product.vo.ProdVO;

@Mapper
public interface OrderMapper {
	@Select("Select * from s_order where id = #{id}")
	List<OrderVO> getAllOrderList(@Param("id") String id);

	@Select("Select s_order.orderidx, s_order.productno, s_order.selectedoption, s_order.totalprice, s_order.orderdate, s_order.state, s_order.seller, s_product.productname, s_product.imagename from s_order left join s_product on s_order.productno = s_product.productno where s_order.id = #{id} and TO_CHAR(s_order.orderdate, 'YYYYMMDD') >= #{startdate} and TO_CHAR(s_order.orderdate, 'YYYYMMDD') <= #{enddate} and UPPER(s_product.productname) like UPPER(#{productname}) and s_order.state in ('결제 완료', '배송중', '배송 완료') order by s_order.orderdate desc")
	List<OrderVO> getOrderList(@Param("id") String id, @Param("startdate") String startdate,
			@Param("enddate") String enddate, @Param("productname") String productname);

	@Select("Select s_order.orderidx, s_order.productno, s_order.selectedoption, s_order.totalprice, s_order.orderdate, s_order.state, s_order.seller, s_product.productname, s_product.imagename from s_order left join s_product on s_order.productno = s_product.productno where s_order.id = #{id} and TO_CHAR(s_order.orderdate, 'YYYYMMDD') >= #{startdate} and TO_CHAR(s_order.orderdate, 'YYYYMMDD') <= #{enddate} and UPPER(s_product.productname) like UPPER(#{productname}) and s_order.state in ('취소 완료', '취소 요청', '환불 완료', '환불 요청') order by s_order.orderdate desc")
	List<OrderVO> getCancelList(@Param("id") String id, @Param("startdate") String startdate,
			@Param("enddate") String enddate, @Param("productname") String productname);

	@Insert("insert into s_order values (order_seq.NEXTVAL, #{order.id}, #{order.productno}, #{order.selectedoption}, #{order.amount}, #{order.totalprice}, sysdate, '결제 완료', #{order.ordermethod}, #{order.seller}, #{order.dname}, #{order.dtel}, #{order.dzipcode}, #{order.daddress}, #{order.ddetailaddr})")
	void insertOrder(@Param("order") OrderVO orderVO);

	@Select("select s_order.orderidx, s_order.productno, s_product.productname, s_order.totalprice, s_order.amount, s_order.orderdate, s_order.state from s_order left join s_product on s_order.productno = s_product.productno where s_product.sellerid = #{sellerid} order by s_order.orderidx desc")
	List<OrderVO> getSellList(@Param("sellerid") String sellerid);

	@Update("update s_order set state = #{state} where orderidx = #{orderidx}")
	void updateOrder(@Param("orderidx") long orderidx, @Param("state") String state);

	@Select("select count(orderidx) from s_order where id = #{id} and state in ('결제완료', '배송중', '취소 요청')")
	int haveOrder(@Param("id") String id);
	
	@Select("select * from s_order left join s_product on s_product.productno = s_order.productno where s_product.productname like '%'||#{name}||'%' and s_product.sellerid = #{id} order by s_order.orderidx desc")
//	@Select("Select * from s_order where LOWER(productname) like '%'||#{name}||'%' order by productno")
	List<OrderVO> findByName(@Param("name") String name, @Param("id") String id);
	
	
	@Select("select * from s_order left join s_product on s_product.productno = s_order.productno where s_product.productno = #{productno} and s_product.sellerid = #{id} order by s_order.orderidx desc")
	List<OrderVO> findByNo(@Param("productno") int productno, @Param("id") String id);
}
