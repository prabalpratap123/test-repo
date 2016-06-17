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
@Table(name="prg_user_master")
public class UserPojo implements Serializable {
	private static final long serialVersionUID = -194237939897943255L;


		@Id
		@GeneratedValue
		@Column(name="USER_ID")
		private Integer USER_ID;

		@Column(name="FIRST_NAME",nullable=false)
		private String firstname;

		@Column(name="LAST_NAME")
		private String lastname;

		@Column(name="EMAIL_ID",nullable=false,unique=true)
		private String emailId;

		@Column(name="ADDRESS")
		private String address;

		@Column(name="CONTACT_NO",nullable=false)
		private String contactNo;


		@Column(name="PASSWORD",nullable=false)
		private String password;

		@Column(name="USER_TYPE",nullable=false)
		private String userType;

		@Column(name="ACTIVE_FROM")
		private Date activeFrom;

		@Column(name="ACTIVE_TO")
		private Date activeTo;

		@Column(name="STATUS")
		private String status;

		public UserPojo(){
			super();
		}

		public Integer getUSER_ID() {
			return USER_ID;
		}

		public void setUSER_ID(Integer uSER_ID) {
			USER_ID = uSER_ID;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getContactNo() {
			return contactNo;
		}

		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
		}


		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getUserType() {
			return userType;
		}

		public void setUserType(String userType) {
			this.userType = userType;
		}



		public Date getActiveFrom() {
			return activeFrom;
		}

		public void setActiveFrom(Date activeFrom) {
			this.activeFrom = activeFrom;
		}

		public Date getActiveTo() {
			return activeTo;
		}

		public void setActiveTo(Date activeTo) {
			this.activeTo = activeTo;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}



	}


