package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserUniqueId {
	
		@Id @GeneratedValue
		int id;
		String email;
		String uniqueid;
		
		public UserUniqueId(String email, String uniqueid) {
			super();
			this.email = email;
			this.uniqueid = uniqueid;
		}
		public UserUniqueId() {
			super();
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getUniqueid() {
			return uniqueid;
		}
		public void setUniqueid(String uniqueid) {
			this.uniqueid = uniqueid;
		}
		
		
		
}