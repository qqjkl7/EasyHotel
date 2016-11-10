package com.nju.easyhotel.dao;


import java.util.Date;
import java.util.List;

import com.nju.easyhotel.po.HotelPo;

public interface HotelDao {

	List<HotelPo> searchHotel(
			 String name
			,Date startDate
			,Date endDate
			,String roomKind
			,int roomNum
			,String sortCondition);
	HotelPo  getHotel(String hotelId);
	DaoOpMsg  deleteHotel(String hotelId);
	DaoOpMsg  insertHotel(HotelPo hotelPo);
	DaoOpMsg  modifyHotel(HotelPo hotelPo);
}