package com.example.demo.spring.mybatis.spring.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @author 周瑜
 */
public interface OrderMapper {

	@Select("select 'order'")
	String selectById();
}
