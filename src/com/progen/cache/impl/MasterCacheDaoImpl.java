package com.progen.cache.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.progen.bean.UserBean;
import com.progen.bean.UserStatusBean;
import com.progen.cache.MasterCacheDao;
import com.progen.conversion.PojoToBeanConvertor;
import com.progen.pojo.UserPojo;
import com.progen.util.Singleton;




public class MasterCacheDaoImpl implements MasterCacheDao
{
	private static PrimaryCache cache=null;

	/***************************************************************************************************
	 * @author prabal
	 * @createdDate 2016-05-17
	 * @param ArrayList<UserPojo> userList
	 * This method populate the data from the database and hold it to the beans of TeacherMasterBean
	 * (non-Javadoc)
	 * @see  com.progen.cache.impl.cache.MasterCacheDao#populateUserList(List<UserBean> userList)
	 * @return boolean -true
	 ****************************************************************************************************/





	@Override
	public boolean populateUserList(List<UserBean> userList) {
		 cache=Singleton.getInstance();
		 ArrayList<UserBean> userBeanList=new ArrayList<UserBean>();
		 Map<Integer,UserBean>  userBeanMap=new HashMap<Integer, UserBean>();
		 for(UserBean userBean:userList){
			 userBeanMap.put(userBean.getUSER_ID(), userBean);
			 userBeanList.add(userBean);
		 }

		 cache.setUserList(userBeanList);
		 cache.setUserBeanMap(userBeanMap);

		return true;
	}

	@Override
	public boolean populateUserStatusList(List<UserStatusBean> userStList) {
		 cache=Singleton.getInstance();
		 cache.setUserstList(userStList);
		return true;
	}






}
