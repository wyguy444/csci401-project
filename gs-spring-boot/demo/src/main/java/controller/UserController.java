package controller;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.User;
import service.UserService;

@RestController
@Controller
//@RequestMapping ("/users")
public class UserController
{
	@Autowired
	UserService us;
	
	@RequestMapping ("users/all")
	@ResponseBody
	public Hashtable<String, User> getAll()
	{
		return us.getAll();
	}
	
	@RequestMapping ("/users/" + "{id}")
	@ResponseBody
	public User getUser(@PathVariable("id") String id)
	{
		System.out.println(id);
		System.out.println(us.getUser(id));
		return us.getUser(id);
	}
	
	@RequestMapping ("/user")
	public String user (Model model)
	{
		User u = new User();
		u.setFirstName("Shantanu");
		u.setLastName("Gupta");
		u.setEmail("shantang@usc.edu");
		u.setPassword("08e7c3fq9");
		u.setPhone("2132455631");
		u.setProjectNumber(27);
		u.setUSC_ID("1628742631");
		u.setSemester("Spring 2018");
		u.setYear("Senior");
		model.addAttribute("user", u);
		return "userView";
	}
	
	@ResponseBody
	@RequestMapping ("/")
	String entry()
	{
		return "Welcome to the CSCI401 Portal!";
	}
}