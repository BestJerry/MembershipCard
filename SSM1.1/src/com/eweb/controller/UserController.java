package com.eweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eweb.model.User;
import com.eweb.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 添加用户，User对象与前台属性绑定，属性名需一致，然后重定向直user/userList
	 */
	@RequestMapping(value = "/addUser")
	public String addUser(@ModelAttribute("myuser") User user) {

		System.out.println(user.getName());
		System.out.println(user.getPassword());
		userService.addUser(user);
		return "redirect:/user/userList";
		// return "displayDemo";
	}

	/**
	 * 查询所有用户，赋给uList，并存入model
	 */
	@RequestMapping("/userList")
	public String userList(Model model) {
		List<User> uList = userService.getAllUser();
		model.addAttribute("uList", uList);
		return "jsp/userList";
	}

	/**
	 * 查询User对象,根据id搜索数据库查找
	 */
	@RequestMapping("/showUser")
	public String showUser(@RequestParam Integer id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "jsp/showUser";
	}

	/**
	 * 转发到addUser.jsp
	 */
	@RequestMapping("/addUserUI")
	public String addUserUI() {
		return "insertDemo";
	}

	/**
	 * 更新用户
	 */
	@RequestMapping("/updateUser")
	public String updateUser(User user, Model model) {
		userService.updateUser(user);
		return "redirect:/user/userList";
	}

	/**
	 * 查询User对象,根据id搜索数据库查找
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam Integer id, Model model) {
		userService.deleteUser(id);
		return "redirect:/user/userList";
	}
}
