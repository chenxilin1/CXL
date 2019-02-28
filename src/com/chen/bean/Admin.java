package com.chen.bean;

public class Admin {
  private int userID;
  private String userName;
  private String userPw;
  
  
  public Admin(){}
  public Admin( String userName, String userPw) {
		super();
		this.userName = userName;
		this.userPw = userPw;
	}
  
public int getUserID() {
	return userID;
}
public void setUserID(int userID) {
	this.userID = userID;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserPw() {
	return userPw;
}
public void setUserPw(String userPw) {
	this.userPw = userPw;
}
@Override
public String toString() {
	return "admin [userID=" + userID + ", userName=" + userName + ", userPw="
			+ userPw + "]";
}
  
}
