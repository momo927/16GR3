package com.qhit.lh.gr3.momo.exam.common.action;



import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.momo.exam.common.bean.User;
import com.qhit.lh.gr3.momo.exam.common.service.UserService;
import com.qhit.lh.gr3.momo.exam.common.service.UserServiceImpl;
/**
 * 
 * @author 王倩倩
 *TODO
 *2017年12月27日下午9:04:29
 */
public class UserAction extends ActionSupport {
	private User user;
	private UserService userService = new UserServiceImpl();
	/**
	 * 登录
	 * @return 
	 */
      public String loginUser(){
        user = userService.login(user);
       
        if(user != null){
        	//登录成功！将user对象保存到session对话中
        	System.out.println(user.toString());
        	ServletActionContext.getRequest().getSession().setAttribute("user", user);
        	return "loginSuccess";
        }else{
        	super.addActionError("用户名或密码错误!请重新登录！");
			return "loginFail";
        } 
      }
      /**
  	 * @return
  	 * 退出
  	 */
  	public String logout(){
  		//获取session对象，并销毁
  		ServletActionContext.getRequest().getSession().invalidate();
  		return "logout";
  }
      
      
      
      //
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
      
}
