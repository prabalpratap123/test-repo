package com.progen.conversion;

import java.util.ArrayList;

import com.progen.bean.UserBean;
import com.progen.bean.UserStatusBean;
import com.progen.pojo.UserPojo;
import com.progen.pojo.UserStatusPojo;


public class PojoToBeanConvertor {

	public static UserBean userPojoToBean(UserPojo userPojo){
		UserBean userBean = new UserBean();
		System.out.println(userPojo.getFirstname());
		userBean.setEmailId(userPojo.getEmailId());
		userBean.setFirstname(userPojo.getFirstname());
		userBean.setContactNo(userPojo.getContactNo());
		userBean.setPassword(userPojo.getPassword());
		userBean.setUserType(userPojo.getUserType());
		userBean.setAddress(userPojo.getAddress());
		userBean.setUSER_ID(userPojo.getUSER_ID());
		userBean.setActiveFrom(userPojo.getActiveFrom());
		userBean.setActiveTo(userPojo.getActiveTo());
		return userBean;
	}


	public static UserStatusBean userStatusPojoToBean(UserStatusPojo stPojo){
		UserStatusBean userBean = new UserStatusBean();
		System.out.println(stPojo.getTaskDetail());
		System.out.println(stPojo.getDailyTaskId());
		System.out.println(stPojo.getCreatedDate());
		System.out.println(stPojo.getStatus());
		userBean.setCreatedDate(stPojo.getCreatedDate());
		userBean.setDailyTaskId(stPojo.getDailyTaskId());
		userBean.setDownTime(stPojo.getDownTime());
		userBean.setTaskDetail(stPojo.getTaskDetail());
		userBean.setTaskId(stPojo.getTaskId());
		userBean.setTotalTime(stPojo.getTotalTime());
		userBean.setUserid(stPojo.getUserid());
		userBean.setStatus(stPojo.getStatus());
		return userBean;
	}
}
