package demo.mapper;

import java.util.List;

import demo.model.User;

public interface UserMapper {
	String findAge(String id);

	List<User> getAllUser();

	User queryByPrimaryKey(int userId);

	int insertUser(User user);
}
