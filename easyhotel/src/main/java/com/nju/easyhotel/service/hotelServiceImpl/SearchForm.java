package com.nju.easyhotel.service.hotelServiceImpl;

import java.util.Date;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.NotEmpty;

public class SearchForm {//搜索酒店时提及表单的Vo
	

	private String name;
	private Date startDate;
	private Date endDate;
	private String roomKind;   
	private int roomNum=1;
	private String sortCondition="rate";
    private String city;
    private String circle;

    public SearchForm() {
		super();
	}
	public SearchForm(String name, Date startDate, Date endDate, String roomKind, int roomNum,String city,String circle) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.roomKind = roomKind;
		this.roomNum = roomNum;	
		this.city=city;
		this.circle=circle;
	}
	public SearchForm(String name, Date startDate, Date endDate, String roomKind, int roomNum, String sortCondition,String city,String circle) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.roomKind = roomKind;
		this.roomNum = roomNum;
		this.sortCondition = sortCondition;
		this.city=city;
		this.circle=circle;
	}
	public String getSortCondition() {
		return sortCondition;
	}
	public void setSortCondition(String sortCondition) {
		this.sortCondition = sortCondition;
	}	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getRoomKind() {
		return roomKind;
	}
	public void setRoomKind(String roomKind) {
		this.roomKind = roomKind;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	 public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
    public String toString(){
	    return name+"; "+startDate+"; "+endDate+"; "+roomKind+"; "+roomNum;
    }
}
