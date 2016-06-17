package com.progen.service;

import java.util.ArrayList;
import java.util.List;

import com.progen.bean.UserBean;
import com.progen.bean.UserStatusBean;
import com.progen.pojo.UserStatusPojo;


public interface MainService {
	public UserBean userValidation(String username, String password);
	public ArrayList<UserBean> getUserList();
	public boolean registerUser(UserBean bean);
	public boolean validateRegisterEmailId(String emailid);
	public boolean saveStatus(List<UserStatusBean> beanlist);

	/*  This is for Getting data daily at time for sending mail*/
	public List<UserStatusBean>  getTodayStatus(java.sql.Date date);
}
