package com.momo.t6.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.momo.t6.bean.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private User user;
	
	@Override
	public void validate() {
		//用户名验证
		if("".equals(user.getUname())){
			//有错误报出错误信息
			super.addFieldError("user.uname", getText("uname.empty"));
		}
		//密码验证
		if("".equals(user.getUpwd())){
			super.addFieldError("user.upwd", getText("upwd.empty"));
		}
			/**
			 * 数据格式化验证、数据有效性验证：
			 * 正则表达式（用户名、邮箱、手机号、密码）
			 * 由26个英文字母组成的字符串：^[A-Za-z]+$
			 *由数字和26个英文字母组成的字符串：^[A-Za-z0-9]+$
			 *手机号码：^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$
			 *Email地址：^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$
			 *身份证号(15位、18位数字)：^\d{15}|\d{18}$
			 *日期格式：^\d{4}-\d{1,2}-\d{1,2}
			 *腾讯QQ号：[1-9][0-9]{4,} (腾讯QQ号从10000开始)
			 * 
			 * 
			 */
		//设置验证的正则表达式格式
		Pattern pattern = Pattern.compile("^[A-Za-z]+$");
		Matcher matcher = pattern.matcher(user.getUname());
		//这个字符串与正则表达式不匹配（matcher 进行匹配的字符串，matches 匹配）
		if(!matcher.matches()){
			super.addFieldError("user.uname", getText("uname.formartError"));
		}
	}
	
	//登录action
	public String login() {
		
		return "loginSuccess";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
	
	
}
