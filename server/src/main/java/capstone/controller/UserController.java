package capstone.controller;

import java.util.Collection;
import java.util.Vector;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import capstone.model.LoginData;
import capstone.model.users.Student;
import capstone.model.users.User;
import capstone.repository.AdminRepository;
import capstone.repository.StakeholderRepository;
import capstone.repository.StudentRepository;
import capstone.util.Constants;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private StudentRepository studentRepo;
	private StakeholderRepository stakeholderRepo;
	private AdminRepository adminRepo;
	
	
	public UserController(StudentRepository student, StakeholderRepository stakeholder, AdminRepository admin)
	{
		this.studentRepo = student;
		this.stakeholderRepo = stakeholder;
		this.adminRepo = admin;
	}
	
	@GetMapping("/all")
	@CrossOrigin(origins = "http://localhost:3000")
	public Collection<User> getUsers()
	{
		Collection<User> users = new Vector<>();
		users.addAll(studentRepo.findAll());
		users.addAll(stakeholderRepo.findAll());
		users.addAll(adminRepo.findAll());
		return users;
	}
	
	@GetMapping("/students")
	@CrossOrigin(origins = "http://localhost:3000")
	public Collection<Student> getStudents() {
		return studentRepo.findAll();
	}
	
	/* Login */
	
	@RequestMapping(value = "/login",consumes= "application/json",produces= "application/json", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:3000")
	public @ResponseBody String loginAttempt(@RequestBody LoginData logindata)
	{
		
		System.out.println("Received HTTP POST");
		System.out.println(logindata);
		System.out.println(logindata.getEmail());
		System.out.println(logindata.getPassword());
		
		String email = logindata.getEmail();
		return "student";
		/*if (studentRepo.findByEmail(email) != null) {
			return Constants.STUDENT;
		} else if (stakeholderRepo.findByEmail(email) != null) {
			return Constants.STAKEHOLDER;
		} else if (adminRepo.findByEmail(email) != null) {
			return Constants.ADMIN;
		} else {
			return Constants.EMPTY;
		}*/
		
		// check if username exists in database
		
		// check if username/password combo is valid
		
	}
	
	String encryptPassword(String textPassword)
	{
		String encryptedPassword;
		StrongPasswordEncryptor bte = new StrongPasswordEncryptor();
		encryptedPassword = bte.encryptPassword(textPassword);
		return encryptedPassword;
	}
	
	Boolean checkPassword(String plainPassword, String encryptedPassword)
	{
		StrongPasswordEncryptor bte = new StrongPasswordEncryptor();
		return bte.checkPassword(plainPassword,encryptedPassword);
	}
}
