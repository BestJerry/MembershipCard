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
	 * ����û���User������ǰ̨���԰󶨣���������һ�£�Ȼ���ض���ֱuser/userList
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
	 * ��ѯ�����û�������uList��������model
	 */
	@RequestMapping("/userList")
	public String userList(Model model) {
		List<User> uList = userService.getAllUser();
		model.addAttribute("uList", uList);
		return "jsp/userList";
	}

	/**
	 * ��ѯUser����,����id�������ݿ����
	 */
	@RequestMapping("/showUser")
	public String showUser(@RequestParam Integer id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "jsp/showUser";
	}

	/**
	 * ת����addUser.jsp
	 */
	@RequestMapping("/addUserUI")
	public String addUserUI() {
		return "insertDemo";
	}

	/**
	 * �����û�
	 */
	@RequestMapping("/updateUser")
	public String updateUser(User user, Model model) {
		userService.updateUser(user);
		return "redirect:/user/userList";
	}

	/**
	 * ��ѯUser����,����id�������ݿ����
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam Integer id, Model model) {
		userService.deleteUser(id);
		return "redirect:/user/userList";
	}
}
