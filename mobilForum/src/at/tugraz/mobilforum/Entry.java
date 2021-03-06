package at.tugraz.mobilforum;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Entry {
	
	String username;
	String userpicture;
	String usersignature;
	String entrytext;
	String uploadedImageURI;
	java.util.Date date;
	int rating;
	int userid;
	
	
	public Entry(){
		
		this.username = "";
		this.userpicture = "";
		this.usersignature = "";
		this.entrytext = "";
		this.uploadedImageURI = "";
		this.date = new Date();
		this.rating = 0;
	}

	public Entry(String username, String userpicture, String usersignature, 
			String entrytext, long date, int rating, String time){
		this.username = username;
		this.userpicture = userpicture;
		this.usersignature = usersignature;
		this.entrytext = entrytext;
		this.date = new Date(date);    
		this.rating = rating;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpicture() {
		return userpicture;
	}
	public void setUserpicture(String userpicture) {
		this.userpicture = userpicture;
	}
	public String getUsersignature() {
		return usersignature;
	}
	public void setUsersignature(String usersignature) {
		this.usersignature = usersignature;
	}
	public String getEntrytext() {
		return entrytext;
	}
	public void setEntrytext(String entrytext) {
		this.entrytext = entrytext;
	}
	public String getDate() {
		DateFormat df = new SimpleDateFormat("dd.MM.yy",Locale.getDefault()); 
	    return df.format(this.date);
	}
	
	public long getLongDate(){
		return this.date.getTime();
	}
	
	public void setDate(long date){
		this.date = new Date(date);
	}
	
	public String getTime() {
		DateFormat df = new SimpleDateFormat("hh:mm",Locale.getDefault()); 
	    return df.format(this.date);
	}
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String toString(){
		return this.username + this.userpicture + this.getEntrytext() + this.getRating() + this.getUsersignature();
	}

	public String getUploadedImageURI() {
		return uploadedImageURI;
	}

	public void setUploadedImageURI(String uploadedImageURI) {
		this.uploadedImageURI = uploadedImageURI;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
}
