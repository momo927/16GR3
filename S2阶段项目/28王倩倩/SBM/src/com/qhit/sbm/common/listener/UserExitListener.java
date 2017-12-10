package com.qhit.sbm.common.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.qhit.sbm.user.bean.User;

public class UserExitListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session初始化！！！");

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session销毁！！！");
		
		//获取session对象
		HttpSession session=arg0.getSession();
		//在session获取user对象
		User user = (User) session.getAttribute("user");
		//获取application对象
		ServletContext application=session.getServletContext();
		//获取在线用户集合
		List<User> users=(List<User>) application.getAttribute("online");
		//从在线集合中删除当前退出的用户
		users.remove(user);
		//更新application对象中在线用户集合
		application.setAttribute("online", users);
		
	}

}
