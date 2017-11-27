package com.jay.t03.convertor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class Mydate extends StrutsTypeConverter {
	
	
	//请求中获取参数进行转换
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		//实例化日期格式
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//
		try {
			Date v=sdf.parse(arg1[0]);
			return v;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	//转换成字符串
	@Override
	public String convertToString(Map arg0, Object arg1) {
		//实例化日期格式
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date v=(Date) arg1;
		return sdf.format(v);
		
	}

}
