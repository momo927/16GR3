package com.jay.t02;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Interceptor extends AbstractInterceptor {

	private static final ActionInvocation invocation = null;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("拦截开始。。。。。。");
		String result=invocation.invoke();
		System.out.println("返回："+result);
		return result;
	}

}
