package com.progen.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DailyTaskMaster")
public class UserStatusPojo implements Serializable {
	private static final long serialVersionUID = -194237939897943255L;


		@Id
		@GeneratedValue
		@Column(name="taskId")
		private Integer taskId;

		@Column(name="userid")
		private Integer userid;

		@Column(name="downTime")
		private Integer downTime;


		@Column(name="DailyTaskId",nullable=false)
		private String dailyTaskId;

		@Column(name="taskDetail")
		private String taskDetail;

		@Column(name="totalTime",nullable=false,unique=true)
		private Integer totalTime;

		@Column(name="updateddate")
		private String updateddate;


		@Column(name="createdDate",columnDefinition = "Date default SYSDATE")
		private Date createdDate;

		@Column(name="status")
		private String status;


		public UserStatusPojo(){
			super();
		}



		public Integer getTaskId() {
			return taskId;
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

		public Integer getDownTime() {
			return downTime;
		}



		public void setDownTime(Integer downTime) {
			this.downTime = downTime;
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


