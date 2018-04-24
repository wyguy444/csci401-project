package capstone.controller;



import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Vector;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import capstone.model.LoginData;
import capstone.model.PeerReviewData;
import capstone.model.Project;
import capstone.model.User;
import capstone.model.UserEmailsData;
import capstone.model.WeeklyReportData;
import capstone.repository.ProjectsRepository;
import capstone.service.EncryptPassword;
import capstone.session.UserSessionManager;
import capstone.sql.SQLDriver;
import mail.mailDriver;

@RestController
public class ProjectServiceController 
{
	private ProjectsRepository repository;
	private SQLDriver driver;
	public UserSessionManager usm;
	
	public ProjectServiceController(ProjectsRepository repository)
	{
		this.repository = repository;
		driver = new SQLDriver(5); // TODO: have this be configured as NUM_RANKED, not hard-coded
		driver.connect();
		
		usm = new UserSessionManager();
		
		
//		encryptUserPasswords();
	}
	
	@GetMapping("/projectsrep")
	@CrossOrigin(origins = "http://localhost:3000")
	public Collection<Project> projects()
	{
		repository.deleteAll();
		Vector<Project> projectsVector = driver.getProjectsTable(); 
		for (Project p: projectsVector)
		{
			repository.save(p);
		}
		return repository.findAll().stream()
				.collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/projectData",consumes= "application/json",produces= "application/json", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:3000")
	public @ResponseBody Project saveData(@RequestBody Project project)
	{
		System.out.println("Received HTTP POST");
		System.out.println(project);
		System.out.println(project.getProjectName());
		System.out.println(project.getMinSize());
		System.out.println(project.getMaxSize());
		System.out.println(project.getTechnologiesExpected());
		System.out.println(project.getBackgroundRequested());
		System.out.println(project.getDescription());

//	   String projectName = request.getParameter("projectName");
//	   int projectSize = Integer.valueOf(request.getParameter("projectSize"));
//	   String technologiesExpected = request.getParameter("technologiesExpected");
//	   String backgroundRequested = request.getParameter("backgroundRequested");
//	   String projectDescription = request.getParameter("projectDescription");

	   project.setProjectId((int)repository.count()); // TODO: fix
	   project.setStatusType("Pending Approval");
//	   
	   //add project to project repository
	   repository.save(project);
	   
	   driver.addProjectEntry(project);
	   							String timeStamp = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(new Date());
	   	
	   mailDriver maildriver = new mailDriver("csci401server", "drowssap$$$");
	   String reportConfirmation = "A new project proposal was submitted for " + project.getProjectName() +".\n\n"
															  + "TIME: " + timeStamp + "\n"
															  + "PROJECT NAME: " + project.getProjectName() + "\n"
															  + "PROJECT DESCRIPTION: " + project.getDescription() + "\n"
															  + "TECHNOLOGIES EXPECTED: "+ project.getTechnologiesExpected() + "\n"
															  + "BACKGROUND REQUESTED: " + project.getBackgroundRequested() + "\n\n"
															  + "For more information, visit the CSCI401 website or reply to this email.";
	   maildriver.sendEmail("New Project Proposal Submitted for " + project.getProjectName(), reportConfirmation, "csci401server@gmail.com");

	   
		return project; //new ResponseEntity<Boolean>(uiRequestProcessor.saveData(a),HttpStatus.OK);
	}
	//XXXXXXXXXXXX
	@RequestMapping(value = "/peerReviewForm",consumes= "application/json",produces= "application/json", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:3000")
	public @ResponseBody PeerReviewData peerReviewSubmissionAttempt(@RequestBody PeerReviewData peerreviewdata)
	{
		System.out.println("Received HTTP POST");
		String timeStamp = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(new Date());
		String timeCode = new SimpleDateFormat("MMddHHmmss").format(new Date());
//		timeCode.replaceAll(".", "");
		
		peerreviewdata.setId(Integer.parseInt(timeCode));
		System.out.println(peerreviewdata.getId());
		System.out.println(peerreviewdata.getUscidnumber());
		System.out.println(peerreviewdata.getUscusername());
		
		//use sql to send this data to weeklyreportstable
		driver.addPeerReviewEntry(peerreviewdata);
		mailDriver maildriver = new mailDriver("csci401server", "drowssap$$$");
		
		String reportConfirmation = "A peer review was submitted for " + peerreviewdata.getTeammateaddress() +".\n\n"
															  + "TIME: " + timeStamp + "\n"
															  + "USC USERNAME: " + peerreviewdata.getUscusername() + "\n"
															  + "USC ID: " + peerreviewdata.getUscidnumber() + "\n"
															  + "TEAM MEMBER NAME: " + peerreviewdata.getTeammateaddress() + "\n"
															  + "POSITIVE FEEDBACK: "+ peerreviewdata.getPositivefeedback() + "\n"
															  + "NEED IMPROVEMENT: " + peerreviewdata.getNegativefeedback() + "\n\n"
															  + "For more information, visit the CSCI401 website or reply to this email.";
																
		maildriver.sendEmail("Peer Review Submitted for " + peerreviewdata.getTeammateaddress(), reportConfirmation, "csci401server@gmail.com");
		maildriver.sendEmail("Peer Review Confirmation", reportConfirmation, peerreviewdata.getUscusername()+"@usc.edu");

		
		return peerreviewdata;
	}
	//XXXXXXXXXX
	
	//XXXXXXXXXXXX
		@RequestMapping(value = "/userInfoUpdate",consumes= "application/json",produces= "application/json", method = RequestMethod.POST)
		@CrossOrigin(origins = "http://localhost:3000")
		public @ResponseBody User userInfoUpdateAttempt(@RequestBody User userdata)
		{
			System.out.println("Received HTTP POST");
			String timeStamp = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(new Date());
			String timeCode = new SimpleDateFormat("MMddHHmmss").format(new Date());
//			timeCode.replaceAll(".", "");
			
			System.out.println(userdata.getUserId());
			System.out.println(userdata.getFirstName());
			System.out.println(userdata.getLastName());
			System.out.println(userdata.getSemester());
			System.out.println(userdata.getEmail());
			System.out.println(userdata.getUserType());
			
			driver.addUserInfoUpdate(userdata);
//			mailDriver maildriver = new mailDriver("csci401server", "drowssap$$$");
			return userdata;
		}
		//XXXXXXXXXX
		
		@RequestMapping(value = "/userProfileUpdate",consumes= "application/json",produces= "application/json", method = RequestMethod.POST)
		@CrossOrigin(origins = "http://localhost:3000")
		public @ResponseBody User userProfileUpdateAttempt(@RequestBody User userdata)
		{
			System.out.println("Received HTTP POST");
			
			System.out.println(userdata.getFirstName());
			System.out.println(userdata.getLastName());
			System.out.println(userdata.getPhone());
			System.out.println(userdata.getEmail());
			
			driver.updateUserProfile(userdata);
//			mailDriver maildriver = new mailDriver("csci401server", "drowssap$$$");
			return userdata;
		}		
	
		//XXXXXXXXXXXX
		@RequestMapping(value = "/projectApprovalAttempt",consumes= "application/json",produces= "application/json", method = RequestMethod.POST)
		@CrossOrigin(origins = "http://localhost:3000")
		public @ResponseBody String projectApprovalAttempt(@RequestBody String projectlist)
		{
			System.out.println("Received HTTP POST");
			System.out.println(projectlist);
			Vector<String> projectNames = new Vector<String>();
			Vector<String> approvalStatus = new Vector<String>();
			
			while(projectlist.length() > 30)
			{
				int startindex = projectlist.indexOf("name");
				int endindex = projectlist.indexOf("minSize");
				if(startindex == -1 || endindex == -1)
				{
					break;
				}
				String dirtyString = projectlist.substring(startindex, endindex);
				dirtyString = dirtyString.replace('"', ' ');
				dirtyString = dirtyString.replace(':', ' ');
				dirtyString = dirtyString.replace(',', ' ');
				dirtyString = dirtyString.replaceAll("name", " ");
				dirtyString = dirtyString.trim();
//				System.out.println(dirtyString);
				projectNames.add(dirtyString);
								
				int startindex2 = projectlist.indexOf("status");
				int endindex2 = projectlist.indexOf("dueDate");
				if(startindex2 == -1 || endindex2 == -1)
				{
					break;
				}
				String dirtyString2 = projectlist.substring(startindex2, endindex2);
				dirtyString2 = dirtyString2.replace('"', ' ');
				dirtyString2 = dirtyString2.replace(':', ' ');
				dirtyString2 = dirtyString2.replace(',', ' ');
				dirtyString2 = dirtyString2.replaceAll("status", " ");
				dirtyString2 = dirtyString2.trim();
//				System.out.println(dirtyString2);
				approvalStatus.add(dirtyString2);
				
				int trimindex = projectlist.indexOf("projectDescription");
				trimindex = trimindex +30;
				if(trimindex < projectlist.length())
				{
					projectlist = projectlist.substring(trimindex, projectlist.length()-1);
				}
				else
				{
					break;
				}
				
			}
			
			String timeStamp = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(new Date());
			String timeCode = new SimpleDateFormat("MMddHHmmss").format(new Date());
//			timeCode.replaceAll(".", "");
			Vector<String> approvedProjects = new Vector<String>();
			for(int i=0; i<approvalStatus.size(); i++)
			{
				if(approvalStatus.get(i).equals("Approved"))
				{
					approvedProjects.add(projectNames.get(i));
					System.out.println(projectNames.get(i));
				}
			}
			
			for(String s : approvedProjects)
			{
				driver.updateProjectStatus(s, 2);
			}

			return "OK";
		}
		//XXXXXXXXXX
	
	
	
	@RequestMapping(value = "/weeklyReportForm",consumes= "application/json",produces= "application/json", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:3000")
	public @ResponseBody WeeklyReportData weeklyReportSubmissionAttempt(@RequestBody WeeklyReportData weeklyreportdata)
	{
		System.out.println("Received HTTP POST");
		String timeStamp = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(new Date());
		String timeCode = new SimpleDateFormat("MMddHHmmss").format(new Date());
//		timeCode.replaceAll(".", "");
		
		weeklyreportdata.setId(Integer.parseInt(timeCode));
		System.out.println(weeklyreportdata.getId());
		System.out.println(weeklyreportdata.getName());
		System.out.println(weeklyreportdata.getUscusername());
		
		//use sql to send this data to weeklyreportstable
		driver.addWeeklyReportEntry(weeklyreportdata);
		mailDriver maildriver = new mailDriver("csci401server", "drowssap$$$");
		
		String reportConfirmation = weeklyreportdata.getName() + " submitted a weekly report.\n\n"
															  + "TIME: " + timeStamp + "\n"
															  + "USC USERNAME: " + weeklyreportdata.getUscusername() + "\n"
															  + "PROJECT NAME: " + weeklyreportdata.getProject() + "\n\n"
															  + "For more information, visit the CSCI401 website or reply to this email.";
																
		maildriver.sendEmail("Weekly Report Submitted by " + weeklyreportdata.getName(), reportConfirmation, "csci401server@gmail.com");
		maildriver.sendEmail("Weekly Report Confirmation", reportConfirmation, weeklyreportdata.getUscusername()+"@usc.edu");

		
		return weeklyreportdata;
	}

	
	
	@RequestMapping(value = "/StudentRegistrationAttempt",consumes= "application/json",produces= "application/json", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:3000")
	public @ResponseBody UserEmailsData weeklyReportSubmissionAttempt(@RequestBody UserEmailsData emailsdata)
	{
		System.out.println("Received HTTP POST");
//		System.out.println(emailsdata.getEmails());
		
		String[] emailsArray = emailsdata.getEmails().split("\n");
		
		mailDriver maildriver = new mailDriver("csci401server", "drowssap$$$");
		
		for(String e : emailsArray)
		{
			maildriver.sendEmail("401 Platform Invite", "Congratulations! \nPlease sign up using the following link. \n \nlocalhost:3000/register/", e);
			System.out.println("Sent invite to: " + e);
		}
		
//		use sql to send this data to users table
//		driver.adduser(user email); //preferably do this when the user goes to the link in the email
		
		
		return emailsdata;
	}
	
	
	//////
	@RequestMapping(value = "/projectRankingsSubmitAttempt",consumes= "application/json",produces= "application/json", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:3000")
	
	public @ResponseBody String projectRankingsSubmitAttempt(@RequestBody String rankingdata, HttpServletRequest request)
	{
		System.out.println("Received HTTP POST");
		System.out.println(rankingdata);
		int emailIndex = rankingdata.indexOf("email");
		String emailStr = rankingdata.substring(emailIndex, rankingdata.length()-1);
		System.out.println("THE EMAIL IS = " + emailStr);
		//STEPS
		//HOW TO GET USERID WITH NEW JWT SYSTEM??
		//GET STUDENT ID
		//GET PROJECT ID OF ALL PROJECTS RANKED
		//ADD ENTRY WITH STUDENTID, PROJECTID, RANK INTO PROJECTRANKINGS TABLE.
		
		
//		String addr = request.getHeader(HttpHeaders.ORIGIN);
//		User u1 = usm.getUser(addr);
		Vector<String> rankingsIds = new Vector<String>();
		int n=20;	
		while(rankingdata.indexOf("projectId") != -1)
		{
				int startindex = rankingdata.indexOf("projectId");
				int endindex = rankingdata.indexOf("stakeholderId");
				if(startindex == -1 || endindex == -1)
				{
					break;
				}
				String dirtyString = rankingdata.substring(startindex, endindex);
//				System.out.println("SUBSTRING string WAS : " + dirtyString);
				dirtyString = dirtyString.replace('"', ' ');
				dirtyString = dirtyString.replace(':', ' ');
				dirtyString = dirtyString.replace(',', ' ');
				dirtyString = dirtyString.replaceAll("projectId", " ");
//				System.out.println("dirty string WAS : " + dirtyString);
				dirtyString = dirtyString.substring(0, 6);
				dirtyString = dirtyString.trim();
//				System.out.println("project id WAS : " + dirtyString);
				rankingsIds.add(dirtyString);
				int trimindex = rankingdata.indexOf("adminComments");
				if(trimindex == -1)
				{
					break;
				}
				trimindex = trimindex +22;
//				if(trimindex < rankingdata.length())
				{
//					System.out.println("Trimming ......!");
					rankingdata = rankingdata.substring(trimindex, rankingdata.length()-1);
//					System.out.println("TRIMMED NOW IS - " + rankingdata);
				}
//				else
//				{
//					break;
//				}
				n--;
		}
		
		for(String s : rankingsIds)
		{
			System.out.println("ProjectId : " + s);
		}
				
				
		//get user from addr using usm
		//find projects from sqldriver and then populate projectRankings table with 5 entries

//		int studentNumber = driver.getRankingsTableCount();
//		studentNumber = studentNumber/5;
//		studentNumber++;
//		System.out.println("STUDENT NUMBER ADDED= "+ studentNumber);
		//find rankingtable count divide by 5 and add 1 to get next student number

		//get a list of all projects
//		Vector<Project> allProjects = driver.getAllProjects();
//
//		//find the ordered list of rankings
//		
//		for(Project p : allProjects)
//		{
//				driver.addProjectRankingEntry(0, p.getProjectId()+1, 5);
//		}
		
		
//		mailDriver maildriver = new mailDriver("csci401server", "drowssap$$$");
		
		
//		maildriver.sendEmail("Project Rankings Submitted!", "Hi "+ u1.getFirstName() + " " + u1.getLastName() + ", \nWe have received your project rankings. \n\nYou will be assigned a project shortly.", u1.getEmail());
		
//		use sql to send this data to users table
//		driver.adduser(user email); //preferably do this when the user goes to the link in the email
		//get all projects as a vector using driver
		//and then get values for 5 proper entries and then send them in through a function
		//in driver which you should call 5 times.
		
		return rankingdata;
	}
	
	//////
	
	//////
	
	@RequestMapping(value = "/logoutAttempt",consumes= "application/json",produces= "application/json", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:3000")
	public @ResponseBody String logoutAttempt(@RequestBody String email, HttpServletRequest request)
	{
		String addr = request.getHeader(HttpHeaders.ORIGIN);
		System.out.println("Received HTTP POST");
		System.out.println(email);
		System.out.println(addr);
		if(usm.logoutUser(addr))
		{
			return "LoggedOut";
		}
		else
		{
			return "Failed";
		}
	}
	
	//////
	@RequestMapping(value = "/loginAttempt",consumes= "application/json",produces= "application/json", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:3000")
	public @ResponseBody String loginAttempt(@RequestBody LoginData logindata, HttpServletRequest request)
	{
		System.out.println("Received HTTP POST");
		System.out.println(logindata);
		System.out.println(logindata.getEmail());
		String addr = request.getHeader(HttpHeaders.ORIGIN);
		System.out.println(addr);
		//CASE 1
		//DOES USERNAME EXIST?
		if(driver.doesExist(logindata.getEmail()))
		{
			System.out.println("USER EMAIL EXISTS, CHECKING PASSWORD...");
			//IF IT DOES, CHECK IF USERNAME PASSWORD COMBO IS VALID
			String encryptedPassword = driver.getEncryptedPassword(logindata.getEmail());
			if(EncryptPassword.checkPassword(logindata.getPassword(), encryptedPassword))
			{
				if(driver.confirmLoginAttempt(logindata.getEmail(), encryptedPassword))
					{
						for(User ux : usm.getActiveUsers())
						{
							System.out.println("IP WAS = "+ ux.getIpAddress());
							if(ux.getIpAddress().equals(addr))
							{
								System.out.println("A login already exists from this origin.");
								return "MultipleLogins";
							}
						}
						System.out.println("LOGIN SUCCESSFUL");
						//NOTE: hardcoded localhost and 3000 for now, it should actually 
						//get that from the POST request.
						usm.loginUser(logindata.getEmail(), addr);
						User u1 = usm.getUser(addr);
						System.out.println("RETURNING USERTYPE = " + u1.getUserType());
						return u1.getUserType();
					}
			}		
			else
			{
				System.out.println("INVALID PASSWORD");
			}
		}
		else
		{
			System.out.println("INVALID USERNAME : DOES NOT EXIST");
		}
		

		return null; //new ResponseEntity<Boolean>(uiRequestProcessor.saveData(a),HttpStatus.OK);
	}

	//////
//	@RequestMapping(value = "/getProjectByUser",consumes= "application/json",produces= "application/json", method = RequestMethod.POST)
//	@CrossOrigin(origins = "http://localhost:3000")
//	public @ResponseBody Project getProjectByUser(@RequestBody String name, HttpServletRequest request)
//	{
//		System.out.println("Received HTTP POST");
//		String addr = request.getHeader(HttpHeaders.ORIGIN);
//		System.out.println(addr);
//		User user = usm.getUser(addr);
//		if (user==null) {
//			return null;
//		}
//		Vector<Project> allProjects = driver.getAllProjects();
//		System.out.println(user.getFirstName()); 
////		System.out.println(user.getProjectNumber());
//		for (Project p: allProjects) {
//			if (p.getProjectId()==user.getProjectNumber()) {
//				System.out.println(p.getProjectId());
//				return p;
//			}
//		}
//		return null; //new ResponseEntity<Boolean>(uiRequestProcessor.saveData(a),HttpStatus.OK);
//	}

	//////
	@RequestMapping(value = "/loggedInUser",consumes= "application/json",produces= "application/json", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:3000")
	public @ResponseBody User loggedInUser(@RequestBody String email)
	{
		System.out.println("Received HTTP POST: loggedInUser");
		
		User user = driver.getUserByEmail(email);
		System.out.println(user.getFirstName());
		return user;
		
//		String addr = request.getHeader(HttpHeaders.ORIGIN);
//		System.out.println(addr);
//		User user = usm.getUser(addr);
//		if (user != null) {
//			return user;
//		}
//		return null; //new ResponseEntity<Boolean>(uiRequestProcessor.saveData(a),HttpStatus.OK);
	}	
	
	void encryptUserPasswords()
	{
		Vector<User> allUsers = driver.getAllUsers();
		for(User u: allUsers)
		{
			System.out.println("INITIAL PASSWORD = " + u.getPassword());
			System.out.println("INITIAL EMAIL = " + u.getEmail());
			String encryptedPass = EncryptPassword.encryptPassword(u.getPassword());
			System.out.println("ENCRYPTEDPASS= " + encryptedPass);
			driver.updatePassword(u.getEmail(), encryptedPass);
		}
	}
	
		
}

	

