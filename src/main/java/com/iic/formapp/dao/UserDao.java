/**
 * 
 */
package com.iic.formapp.dao;

/**
 * @author franciscogarcia
 *
 */

import java.util.List;

import com.iic.formapp.model.User;
 
public interface UserDao {
	
	public List<User> getAllUsers();
 
	public User getUser(int id);
 
	public User addUser(User user);
 
	public void updateUser(User user) ;
 
	public void deleteUser(int id) ;
}