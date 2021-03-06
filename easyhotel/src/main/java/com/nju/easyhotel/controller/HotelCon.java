package com.nju.easyhotel.controller;
//这个类负责处理酒店搜索、酒店详细信息、酒店添加，酒店评价的请求
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nju.easyhotel.service.HotelService;
import com.nju.easyhotel.service.RoomService;
import com.nju.easyhotel.service.hotelServiceImpl.SearchForm;
import com.nju.easyhotel.tools.IntegerEditor;
import com.nju.easyhotel.vo.HotelVo;

@Controller
@RequestMapping(value="/easyhotel/hotel")//所有匹配.../EasyHotel/hotel的url都会执行这个类中的方法
public class HotelCon {

	@Autowired
	private HotelService hotelService;
	@Autowired
	private RoomService roomService;
	@InitBinder  //表单绑定配置初始化
	protected void initBinder(WebDataBinder binder) {  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));     
	}
	//处理展示"酒店详细信息页面"的请求，当url为.../easyhotel/hotel/detail/xx时执行这个方法
	@RequestMapping(value="/detail/{hotelId}",method = RequestMethod.GET)
	public String showHotelDeatil(@PathVariable String hotelId,Model model){
		//System.out.println(hotelId);
		model.addAttribute("hotel", hotelService.getHotel(hotelId));
		model.addAttribute("rooms", roomService.getAllRoomsByHotel(hotelId));
		return "hotelDetail";
	}
	//处理"展示酒店搜索界面"的请求，当url为.../easyhotel/hotel/search时执行这个方法
	@RequestMapping(value="/search",method = RequestMethod.GET)
	public String showSearchPage(SearchForm form){	
		return "hotelSearch";
	}

	//处理"酒店搜索"请求,当url为.../easyhotel/hotel/searchResultList时执行这个方法
	@RequestMapping(value="/searchResultList",method = RequestMethod.GET)
	public String processSearch(SearchForm form, Model model){
		//form.setCity("南京");		
		//form.setCircle("鼓楼区");
System.out.println(form.getCircle()+form.getName()+form.getStartDate());
		model.addAttribute("hotelList",hotelService.searchHotel(form));
		return "hotelSearch";
	}

	@RequestMapping(value="/comment",method = RequestMethod.PUT)
	public String commentHotel(){
		if(hotelService.commentHotel()==1)
		    return "";
		else 
			return "error";
	}
	@RequestMapping(value="/add",method = RequestMethod.PUT)
	public String addHotel(){

		return "";
	}
	@RequestMapping(value="/delete/{hotelId}",method = RequestMethod.DELETE)
	public String deleteHotel(){
		return "";
	}
	@RequestMapping(value="/modify",method = RequestMethod.DELETE)
	public String modifyHotel(){
		return "";
	}
}
