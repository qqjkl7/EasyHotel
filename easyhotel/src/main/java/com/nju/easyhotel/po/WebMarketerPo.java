package com.nju.easyhotel.po;

public class WebMarketerPo {
	private String id;
	private String account;
	private String password;
	
	public WebMarketerPo() {
		super();
	}
	public WebMarketerPo(String id, String account, String password) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
