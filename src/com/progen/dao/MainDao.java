package com.progen.dao;

import java.util.ArrayList;
import java.util.List;

import com.progen.bean.UserBean;
import com.progen.bean.UserStatusBean;
import com.progen.pojo.UserPojo;
import com.progen.pojo.UserStatusPojo;


public interface MainDao {
	public UserPojo userValidation(String userCode);
	public ArrayList<UserPojo> getUserList();
	public boolean registerUser(UserBean bean);
	public boolean validateRegisterEmailId(String emailid);
	public boolean saveStatus(List<UserStatusBean> beanlist);


	/*  This is for Getting data daily at time for sending mail*/
	public List<UserStatusPojo>  getTodayStatus(java.sql.Date date);
}
