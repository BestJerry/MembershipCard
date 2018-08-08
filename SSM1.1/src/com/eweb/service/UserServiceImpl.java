package com.eweb.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eweb.mapper.UserMapper;
import com.eweb.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	public UserMapper userMapper;

	// @Override
	// public String findAge(String id) {
	// // TODO Auto-generated method stub
	// String age = userMapper.findAge(id);
	// return age;
	// }

	@Override
	public List<User> getAllUser() {
		return userMapper.getAllUser();
	}

	@Override
	public User getUserById(int userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int addUser(User user) {
		return userMapper.insertSelective(user);
	}

	@Override
	public int updateUser(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public int deleteUser(Integer id) {
		return userMapper.deleteByPrimaryKey(id);

	}

}