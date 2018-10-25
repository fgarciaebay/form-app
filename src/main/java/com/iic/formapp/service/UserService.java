/**
 * 
 */
package com.iic.formapp.service;

/**
 * @author franciscogarcia
 *
 */
import java.util.List;

import javax.transaction.Transactional;
 
import com.iic.formapp.dao.UserDao;
import com.iic.formapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
	

	@Autowired
	UserDao userDao;

	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Transactional
	public User getUser(int id) {
		return userDao.getUser(id);
	}

	@Transactional
	public User addUser(User user) {
		userDao.addUser(user);
		return user;
	}

	@Transactional
	public User updateUser(User user) {
		userDao.updateUser(user);
		return user;
	}

	@Transactional
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}
}

