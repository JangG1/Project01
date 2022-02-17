package com.myproject.second.main.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.myproject.second.main.vo.MainVO;

@Mapper
public interface  MainMapper {
    @Select("SELECT imagename, productname, productno, price FROM s_product")
//	@Select("select * from mytable order by dbms_random.value")
    List<MainVO> findAll();
    
//    @Select("SELECT * FROM mytable where image = #{image}")
//    MainVO findByImage(String image);
    
//    @Insert("INSERT INTO mytable (name, age) values (#{name}, #{age})")
//    void save(@Param("name") String name, @Param("age") int age);
}
