package com.momo.t5.action;


import java.sql.SQLException;
import java.util.List;

import com.momo.t5.bean.User;
import com.momo.t5.service.UserService;
import com.momo.t5.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
        private User user;
        private List<User> userlist;
        private UserService userservice = new UserServiceImpl();
        
        
        /**
         * 
         * @return
         * 添加
         */
     public String add(){
    	 try {
			userservice.addUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
		return "toAll";
    	 
     }
     /**
      * 
      * @return
      * 删除
      */
     public String delect(){
    	 try {
			userservice.delectUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toAll";
    	 
     }
     /**
      * 
      * @return
      * 修改
      */
     public String update(){
    	 try {
			userservice.updateUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toAll";
    	 
     }
     /**
      * 
      * @return
      * 先查询当前用户信息，再跳转到修改页面
      */
     public String toupdate(){
    	 try {
			user = userservice.getUserByid(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "toUpdate";
    	 
     }
     /**
      * 
      * @return
      * 查询所有用户
      */
     public String getAll(){
    	 try {
			userlist = userservice.getAallUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "getAllUser";
		}
		return "userlist";
    	 
     }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
     
     
     
}
