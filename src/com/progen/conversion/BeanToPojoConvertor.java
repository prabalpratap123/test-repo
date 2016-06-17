package com.progen.conversion;

import java.util.ArrayList;

import com.progen.bean.UserBean;
import com.progen.pojo.UserPojo;


public class BeanToPojoConvertor {

	public static UserPojo userBeanToPojo(UserBean uBean){
		UserPojo userPojo = new UserPojo();
		userPojo.setEmailId(uBean.getEmailId());
		userPojo.setFirstname(uBean.getFirstname());
		userPojo.setContactNo(uBean.getContactNo());
		userPojo.setPassword(uBean.getPassword());
		userPojo.setUserType(uBean.getUserType());
		userPojo.setAddress(uBean.getAddress());
		return userPojo;
	}
}
