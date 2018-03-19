package com.qhit.lh.gr3.momo.exam.common.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.qhit.lh.gr3.momo.exam.common.bean.User;
import com.qhit.lh.gr3.momo.exam.common.utils.Constants;

public class LoginIntercept extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("登录校验拦截器执行");
		//获取session中的user对象
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		//判断user对象是否登录
		if(user == null ){
			//未登录
			return Constants.VIEW_LOGIN;
		}
		return arg0.invoke();
	}

}
