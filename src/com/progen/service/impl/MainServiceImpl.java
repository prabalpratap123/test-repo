package com.progen.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.progen.bean.UserBean;
import com.progen.bean.UserStatusBean;
import com.progen.cache.MasterCacheDao;
import com.progen.conversion.PojoToBeanConvertor;
import com.progen.dao.MainDao;
import com.progen.pojo.UserPojo;
import com.progen.pojo.UserStatusPojo;
import com.progen.service.MainService;



public class MainServiceImpl implements MainService{

	private MainDao mainDAO;
	private MasterCacheDao masterCache;
	@Autowired
	public void setMasterCache(MasterCacheDao masterCache) {
		this.masterCache = masterCache;
	}
	@Autowired
	public void setMainDAO(MainDao mainDAO) {
		this.mainDAO = mainDAO;
	}

	@Override
	public UserBean  userValidation(String userCode, String password) {
		System.out.println("serviec userCode="+userCode+"                  "+Integer.parseInt(userCode));
		UserPojo userPojo = mainDAO.userValidation(userCode);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(userPojo.getUSER_ID());
		System.out.println(userPojo.getFirstname());
		System.out.println(userPojo.getEmailId());
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		UserBean userBean = new UserBean();
		if(userPojo != null){
			if(userPojo.getPassword().equals(password)){
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				System.out.println(userPojo.getUSER_ID());
				System.out.println(userPojo.getFirstname());
				System.out.println(userPojo.getEmailId());
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				userBean.setFirstname(userPojo.getFirstname());
				userBean.setUSER_ID(userPojo.getUSER_ID());
				userBean.setActiveFrom(userPojo.getActiveFrom());
				userBean.setEmailId(userPojo.getEmailId());
				userBean.setStatus(userPojo.getStatus());
				userBean.setUSER_ID(userPojo.getUSER_ID());
				userBean.setUserType(userPojo.getUserType());
			}
		}
		return userBean;
	}

	@Override
	public ArrayList<UserBean> getUserList() {
		ArrayList<UserBean> userList = new ArrayList<UserBean>();
		for(UserPojo userPojo:mainDAO.getUserList()){
			userList.add(PojoToBeanConvertor.userPojoToBean(userPojo));
		}
		masterCache.populateUserList(userList);
		return userList;
	}

	@Override
	public boolean registerUser(UserBean bean) {
		return mainDAO.registerUser(bean);
	}

	@Override
	public boolean validateRegisterEmailId(String emailid) {
		return mainDAO.validateRegisterEmailId(emailid);
	}

	@Override
	public boolean saveStatus(List<UserStatusBean> beanlist) {
		return mainDAO.saveStatus(beanlist);
	}

	@Override
	public List<UserStatusBean> getTodayStatus(Date date) {
		List<UserStatusBean> statusList=new ArrayList<UserStatusBean>();

		for(UserStatusPojo po:mainDAO.getTodayStatus(date)){
			statusList.add(com.progen.conversion.PojoToBeanConvertor.userStatusPojoToBean(po));
		}
		masterCache.populateUserStatusList(statusList);
		return statusList;
	}

}
