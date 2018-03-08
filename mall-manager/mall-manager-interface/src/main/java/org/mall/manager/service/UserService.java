package org.mall.manager.service;

import org.mall.manager.pojo.User;

public interface UserService {

	/**
	 * 登录
	 */
	boolean login(User user);
	
	/**
	 * 注册
	 */
	boolean signUp(User user);
	
}
