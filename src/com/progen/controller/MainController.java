package com.progen.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.progen.bean.UserBean;
import com.progen.bean.UserStatusBean;
import com.progen.quartz.QuartzSchedulerCronExpressionExample;
import com.progen.service.MainService;
import com.progen.util.ExcelCreator;

@Controller
public class MainController {
	static final Logger logger = Logger.getLogger(MainController.class); // register class with logger


	public MainService mainService;

	@Autowired
	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}



	/********************************************************************************************************
	 * @author prabal
	 * It is used to save the  data to the cache
	 *
	 ********************************************************************************************************/
	@PostConstruct
	public void populateMasterCache(){
		try{
		logger.info("@@@@@@@@@@@@@@@@@@@@@@    populateMasterCache  ##################################3");
		ExcelCreator c=new ExcelCreator();
		logger.info("date="+new java.sql.Date(new Date().getTime()));
		mainService.getTodayStatus(new java.sql.Date(new Date().getTime()));
		mainService.getUserList();
		}catch(Exception e){

		}

	}



	@RequestMapping(value="welcome")
	public String welcome() throws Exception{
//		QuartzSchedulerCronExpressionExample.startScheduler();
		logger.info("####################    show login page   ################################");  // implement required logging method
		return "login";
	}


	@RequestMapping(value="login")
	public  String login(HttpSession session,HttpServletRequest request,String userCode, String password,ModelMap map){
		try {
			System.out.println("userCode="+userCode+"            password="+password);

			String msg="Invalid";
			logger.info("####################    Enter in Login action   ################################ userId=");  // implement required logging method
			UserBean userBean = mainService.userValidation(userCode, password);
			if(userBean.getStatus().equalsIgnoreCase("active")){
				msg="adminHome";
//				session=request.getSession(true);
				System.out.println("SesId="+session.getId());
				session.setAttribute("userStatus", "true");
				session.setAttribute("userId", userBean.getUSER_ID());
				session.setAttribute("UserName", userBean.getFirstname());
				session.setAttribute("MobileNo", userBean.getContactNo());
				session.setAttribute("Status", userBean.getStatus());
				session.setAttribute("UseType", userBean.getUserType());
				logger.info("    Login successfull   sessionId="+session.getId());  // implement required logging method
			}
			return msg;
		} catch (Exception e) {
			logger.error("  Exception  Enter in Login action   ",e);  // implement required logging method
			return "exceptionPage";
		}
	}
	@RequestMapping(value="logout")
	public String logout(HttpSession session){

		logger.info("    Logut action Enter    userId="+session.getAttribute("userId"));
		session.invalidate();
		logger.info("    Logut action successfull   ");
		return "redirect:welcome?login";
	}

	@RequestMapping(value="adminHome")
	public String adminHome(HttpSession session,HttpServletRequest request,ModelMap map){

		logger.info("    adminHome action Enter   SesId="+session.getId());
//		System.out.println("SesId="+session.getId());
//		map.put("session", session);
		if(session == null){
			logger.info("    Session Expire   "+session.getAttribute("userStatus"));
			return "redirect:welcome";
		}else{
				logger.info("  Return adminHome   "+session.getAttribute("userStatus"));
				return "adminHome";
		}
	}



	@RequestMapping(value="adminManageUser")
	public ModelAndView adminManageUser(HttpSession session,ModelMap map,HttpServletRequest request){
		logger.info(" Enter into   adminManageUser  request   userId="+session.getAttribute("userId"));
		System.out.println(session.getAttribute("userStatus"));
		System.out.println("SesId="+session.getId());
		map.addAttribute("userList",mainService.getUserList());
		map.put("session", session);
		return  new ModelAndView("adminManageUser");
	}



	@RequestMapping(value="page/{pagenum}",method=RequestMethod.GET)
	public String page(HttpSession session,@PathVariable("pagenum") String pagenum ,HttpServletRequest request,ModelMap map){
		System.out.println("SesId="+session.getId());
		map.put("session", session);
		logger.info(" Enter into   page/"+pagenum+"  request   userId="+session.getAttribute("userId"));
		return "page"+pagenum;
	}




	/*    this is for  registration process  */
	@RequestMapping(value="registrationPage")
	public ModelAndView getRegistrationPage(HttpSession session,HttpServletRequest request,ModelMap map){

		map.put("session", session);
		logger.info(" Enter into   registrationPage  request   userId="+session.getAttribute("userId"));
		System.out.println("SesId="+session.getId());
		return  new ModelAndView("registrationPage","Userpojo",new UserBean());
	}


	@RequestMapping(value="regitrationProcess",method=RequestMethod.POST)
	public  ModelAndView getRegistrationProcess(HttpSession session,UserBean userBean,HttpServletRequest req,ModelMap map){
		session=req.getSession(false);
		map.put("session", session);
		logger.info(" Enter into   regitrationProcess  request   userId="+session.getAttribute("userId"));
		System.out.println("SesId="+session.getId());
		boolean flag=mainService.registerUser(userBean);
		logger.info(" process return "+flag);
		if(flag){
			return new ModelAndView("adminHome","message","User Register Successfully.");
		}else{
			return new ModelAndView("exceptionPage","message","Something went wrong User is not  Register Successfully.");
		}
	}


	@RequestMapping(value="validateRegisterEmailId")
	public @ResponseBody String validateRegisterEmailId(HttpSession session,String emailId,HttpServletRequest request,ModelMap map){

		map.put("session", session);
		logger.info(" Enter into validateRegisterEmailId   userId="+session.getAttribute("userId"));
		System.out.println("SesId="+session.getId());
		boolean flag=mainService.validateRegisterEmailId(emailId);
		logger.info(" return flag of validateRegisterEmailId "+flag);
		if(flag){
			return "";
		}else{
			return "This email id allready exist please Select another Email.";
		}
	}

	@RequestMapping(value="statusPage")
	public  ModelAndView statusPage(HttpSession session,HttpServletRequest request,ModelMap map){

		map.put("session", session);
		map.put("userId", session.getAttribute("userId"));
		logger.info(" Enter into statusPage   userId="+session.getAttribute("userId"));
		System.out.println("SesId="+session.getId());
		return new ModelAndView("statusPage","userId",session.getAttribute("userId"));
	}



	@RequestMapping(value="savestatus1/{taskIds}/{tskDtl}/{tskTtime}/{userId}/{downtime}/{tskStatus}",method=RequestMethod.GET)
	public  @ResponseBody String statusPage1(HttpSession session,ModelMap map,HttpServletRequest request,@PathVariable String[] taskIds,@PathVariable String[] tskDtl,@PathVariable String[] tskTtime,@PathVariable String userId,@PathVariable String downtime,@PathVariable String[] tskStatus){
//
		map.put("session", session);
		List<UserStatusBean>  userStList=new ArrayList<UserStatusBean>();
		logger.info(" Enter into savestatus1   userId="+session.getAttribute("userId"));
		System.out.println("SesId="+session.getId());
		for(int i=0;i<taskIds.length;i++){
			UserStatusBean usBean=new UserStatusBean();
			usBean.setDailyTaskId(taskIds[i]);
			usBean.setTaskDetail(tskDtl[i]);
			usBean.setUserid(Integer.parseInt(userId));
			usBean.setTotalTime(Integer.parseInt(tskTtime[i]));
			usBean.setDownTime(Integer.parseInt(downtime));
			usBean.setStatus(tskStatus[i]);
			userStList.add(usBean);
		}
		boolean flag=false;
		flag=mainService.saveStatus(userStList);
		if(flag){
			logger.info(" return process savestatus1 "+flag);
			return "";
		}
		else{
			logger.info(" return process savestatus1 "+flag );
			return "Status not saved Please try again.";
		}

	}













	@RequestMapping(value="savestatus",method=RequestMethod.POST)
	public  @ResponseBody String statusPage(HttpSession session,ModelMap map,HttpServletRequest request,ArrayList<String> taskIds,ArrayList<String> taskDescs,String userId,ArrayList<String> totalTimes,String downTime){
		List<UserStatusBean>  userStList=new ArrayList<UserStatusBean>();

		map.put("session", session);
		logger.info(" Enter into savestatus usrid="+userId +"  userId="+session.getAttribute("userId"));
		for(int i=0;i<taskDescs.size();i++){
			UserStatusBean usBean=new UserStatusBean();

			System.out.println("#######################################################");
			System.out.println("taskId="+taskDescs.get(i));
			System.out.println("desc="+taskIds.get(i));
			System.out.println("totalTimes="+totalTimes.get(i));
			usBean.setDailyTaskId(taskIds.toString().split(",")[i]);
			usBean.setTaskDetail(taskDescs.get(i));
			usBean.setUserid(Integer.parseInt(userId));
			usBean.setTotalTime(Integer.parseInt(totalTimes.get(i)));
			userStList.add(usBean);
			System.out.println("#######################################################");
		}
		boolean flag=mainService.saveStatus(userStList);
		logger.info(" return process savestatus usrid="+userId +"   and flag="+flag);
		if(flag){
			return "";
		}
		else{
			return "Status not saved Please try again.";
		}
	}

	@RequestMapping(value="getStatus1")
	@ResponseBody
	public String   getStatus11(HttpServletRequest request,ModelMap map, HttpSession session){

		map.put("session", session);
		logger.info("Enter into getStatus1   userId="+session.getAttribute("userId"));
		ExcelCreator c=new ExcelCreator();
		List<UserStatusBean> statusList=mainService.getTodayStatus(new java.sql.Date(new Date().getTime()));
		c.setStatusList(statusList);
		c.cretaeExcel();
		return "true";
	}

//	@RequestMapping(value="getStatus")
//	@ResponseBody
//	public String   getStatus(){
//		List<UserStatusBean> statusList=mainService.getTodayStatus(new java.sql.Date(new Date().getTime()));
//		ExcelCreator ecreator=new ExcelCreator();
//		ecreator.setStatusList(statusList);
//
//		cretaeExcel("Daily Status Task List","5-May-2016");
//		int count=1;
//		for(UserStatusBean st:statusList){
//			 row = spreadsheet.createRow(count++);
//		      Cell cell = row.createCell(0);
//		      Cell cell1 = row.createCell(1);
//		      Cell cell2 = row.createCell(2);
//		      Cell cell3 = row.createCell(3);
//		      Cell cell4 = row.createCell(4);
//		      Cell cell5 = row.createCell(5);
//		      System.out.println(st.getTaskDetail());
//		      cell.setCellValue(st.getUserid());
//		      cell1.setCellValue(st.getDailyTaskId());
//		      cell2.setCellValue(st.getTaskDetail());
//		      cell3.setCellValue(st.getTotalTime());
//		      cell4.setCellValue(st.getDownTime());
//		      cell5.setCellValue("");
//		}
//		saveExcel();
//		return null;
//	}

}


