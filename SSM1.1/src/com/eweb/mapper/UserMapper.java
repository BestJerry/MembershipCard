package com.eweb.mapper;

import java.util.List;

import com.eweb.model.User;

public interface UserMapper {

	// ����ʱ���Ա���ȫ����ֵ
	int insert(User record);

	// ����ʱ���Բ���Ҫȫ����ֵ
	int insertSelective(User record);

	int deleteByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	User selectByPrimaryKey(Integer id);

	// ��ѯ�����û�
	List<User> getAllUser();
}