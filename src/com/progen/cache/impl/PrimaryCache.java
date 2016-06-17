package com.progen.cache.impl;

import java.util.List;
import java.util.Map;

import com.progen.bean.UserBean;
import com.progen.bean.UserStatusBean;

public class PrimaryCache
{

	/* ***************** this is for getting the batch list  ************* */
	private List<UserBean> userList=null;
	private List<UserStatusBean> userstList=null;
//	private ArrayList<HoliDaysMasterBean> holidayList=null;


	private Map<Integer, UserBean> userMap=null;
//	private Map<String,HoliDaysMasterBean> holidays=null;





	public List<UserBean> getUserList() {
		return userList;
	}

	public void setUserList(List<UserBean> userList) {
		this.userList = userList;
	}






	public List<UserStatusBean> getUserstList() {
		return userstList;
	}

	public void setUserstList(List<UserStatusBean> userstList) {
		this.userstList = userstList;
	}

	public Map<Integer, UserBean> getUserBeanMap() {
		return userMap;
	}

	public void setUserBeanMap(Map<Integer, UserBean> userMap) {
		this.userMap = userMap;
	}






}
