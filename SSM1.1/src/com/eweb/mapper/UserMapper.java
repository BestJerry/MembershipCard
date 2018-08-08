package com.eweb.mapper;

import java.util.List;

import com.eweb.model.User;

public interface UserMapper {

	// 插入时属性必须全部赋值
	int insert(User record);

	// 插入时属性不需要全部赋值
	int insertSelective(User record);

	int deleteByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	User selectByPrimaryKey(Integer id);

	// 查询所有用户
	List<User> getAllUser();
}