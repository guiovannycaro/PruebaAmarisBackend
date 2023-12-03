package com.amaris.models;

public class Users {
	int iduser;
	int userId;
	int id;
	String title;
	String body;
	
	public Users() {
	}
	
	

	public Users(int iduser, int userId, int id, String title, String body) {
		super();
		this.iduser = iduser;
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
	}



	public int getIduser() {
		return iduser;
	}



	public void setIduser(int iduser) {
		this.iduser = iduser;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}



	@Override
	public String toString() {
		return "Users [iduser=" + iduser + ", userId=" + userId + ", id=" + id + ", title=" + title + ", body=" + body
				+ "]";
	}



	
}
