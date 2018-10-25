/**
 * This class provides a REST service coupled with the data in the table
 * Users for performance and future purposes.
 */
package com.iic.formapp.controller;

/**
 * @author franciscogarcia
 *
 */
 
import java.util.List;

import com.iic.formapp.model.User;
import com.iic.formapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class UserController {
 
	@Autowired
	UserService userService;
 
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> getAllUsers(Model model) {
 
		List<User> listOfUsers = userService.getAllUsers();
		model.addAttribute("user", new User());
		model.addAttribute("listOfUsers", listOfUsers);
		return listOfUsers;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllUsers";
	}
 
	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void getUserById(@PathVariable int id) {
		userService.getUser(id);
	}
 
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
 
	}
 
	@RequestMapping(value = "/addUser", method = RequestMethod.PUT, headers = "Accept=application/json")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user); 
 
	}	
 
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
 
 
	}	
}
 