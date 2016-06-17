package com.progen.dao.rdbms;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.progen.bean.UserBean;
import com.progen.bean.UserStatusBean;
import com.progen.dao.MainDao;
import com.progen.pojo.UserPojo;
import com.progen.pojo.UserStatusPojo;
import com.progen.util.PasswordGenerator;


public class MainDaoRdbms implements MainDao{

	private NamedParameterJdbcTemplate namedjdbcTemplate;
	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedjdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	@Override
	public UserPojo userValidation(String userCode) {System.out.println(userCode);

		return hibernateTemplate.get(UserPojo.class, Integer.parseInt(userCode));
	}

	@Override
	public ArrayList<UserPojo> getUserList() {
		return (ArrayList<UserPojo>) hibernateTemplate.findByCriteria(DetachedCriteria.forClass(UserPojo.class));
	}



	@Override
	public boolean registerUser(UserBean uBean) {
		String password=PasswordGenerator.generateRandomPassword(8);
		UserPojo userPojo = new UserPojo();
		userPojo.setEmailId(uBean.getEmailId());
		userPojo.setFirstname(uBean.getFirstname());
		userPojo.setContactNo(uBean.getContactNo());
		userPojo.setPassword(uBean.getPassword());
		userPojo.setUserType(uBean.getUserType());
		userPojo.setAddress(uBean.getAddress());
		userPojo.setStatus("active");
		userPojo.setActiveFrom(new Date(new java.util.Date().getTime()));
		try{
			hibernateTemplate.save(userPojo);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean validateRegisterEmailId(String emailid) {
		// TODO Auto-generated method stub
		ArrayList<UserPojo> list= (ArrayList<UserPojo>) hibernateTemplate.findByCriteria(DetachedCriteria.forClass(UserPojo.class).add(Restrictions.eq("emailId", emailid)));
		if(list.isEmpty()){
			list=null;
			return true;

		}else{
			list=null;
			return false;
		}
	}

	@Override
	public boolean saveStatus(List<UserStatusBean> beanlist) {
		boolean flag=false;
		for(UserStatusBean bean:beanlist){
			UserStatusPojo po=new UserStatusPojo();
			po.setDailyTaskId(bean.getDailyTaskId());
			po.setTaskDetail(bean.getTaskDetail());
			po.setTotalTime(bean.getTotalTime());
			po.setUserid(bean.getUserid());
			po.setCreatedDate(new Date(new java.util.Date().getTime()));
			po.setStatus(bean.getStatus());
			po.setDownTime(bean.getDownTime());
//			try{
				hibernateTemplate.save(po);

				flag= true;
//			}catch(Exception e){
//				flag= false;
//			}
	 }
		return flag;
	}

	@Override
	public List<UserStatusPojo> getTodayStatus(Date date) {
		List<UserStatusPojo> todayStatusList=	(List<UserStatusPojo>) hibernateTemplate.findByCriteria(DetachedCriteria.forClass(UserStatusPojo.class).add(Restrictions.eq("createdDate", date)));
		return todayStatusList;
	}
}
