package com.progen.bean;

import java.sql.Date;

public class UserStatusBean {

		private Integer taskId;
		private Integer userid;
		private Integer downTime;
		private String dailyTaskId;
		private String taskDetail;
		private Integer totalTime;
		private String updateddate;
		private Date createdDate;
		private String status;

		public Integer getTaskId() {
			return taskId;
		}

		public Integer getDownTime() {
			return downTime;
		}

		public void setDownTime(Integer downTime) {
			this.downTime = downTime;
		}



		public void setTaskId(Integer taskId) {
			this.taskId = taskId;
		}



		public Integer getUserid() {
			return userid;
		}



		public void setUserid(Integer userid) {
			this.userid = userid;
		}



		public String getDailyTaskId() {
			return dailyTaskId;
		}



		public void setDailyTaskId(String dailyTaskId) {
			this.dailyTaskId = dailyTaskId;
		}



		public String getTaskDetail() {
			return taskDetail;
		}



		public void setTaskDetail(String taskDetail) {
			this.taskDetail = taskDetail;
		}



		public Integer getTotalTime() {
			return totalTime;
		}



		public void setTotalTime(Integer totalTime) {
			this.totalTime = totalTime;
		}



		public String getUpdateddate() {
			return updateddate;
		}



		public void setUpdateddate(String updateddate) {
			this.updateddate = updateddate;
		}



		public Date getCreatedDate() {
			return createdDate;
		}



		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}



	}


