package com.progen.cache;

import java.util.List;

import com.progen.bean.UserBean;
import com.progen.bean.UserStatusBean;
import com.progen.pojo.UserPojo;


public interface MasterCacheDao {
	public boolean populateUserList(List <UserBean> userList);
	public boolean populateUserStatusList(List <UserStatusBean> userStList);
	/*public boolean populateHolidaysList(ArrayList<HoliDaysMasterPojo> holiDaysList);
	*/
}
