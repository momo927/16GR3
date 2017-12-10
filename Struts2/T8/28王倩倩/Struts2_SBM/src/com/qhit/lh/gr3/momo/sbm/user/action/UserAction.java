package com.qhit.lh.gr3.momo.sbm.user.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.momo.sbm.user.bean.User;
import com.qhit.lh.gr3.momo.sbm.user.service.UserService;
import com.qhit.lh.gr3.momo.sbm.user.service.impl.UserServiceImpl;
	
/**
 * @author 王倩倩
 *TODO
 *2017年12月10日上午10:22:15
 */
public class UserAction extends ActionSupport{
	private User user;
	private List<User> users = new ArrayList<User>();
	private UserService userservice = new UserServiceImpl();
	//上传
	private File userPhoto;
	private String userPhotoFileName;
	private String userPhotoContentType;
	
	
	public String login() throws SQLException{
		//没有登录
		boolean islogin = false;
		//获取用户名和密码
		user = userservice.doLogin(user.getUserName(), user.getUserPassword()); 
		//判断用户名和密码是否为空
		if(user != null){
			//不为空   通过sessoin放入user中
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
		}else{
			super.addFieldError("loginFile", "用户名或密码错误!" );
		}
		return "loginSuccess";
	}
	
	    /**
	     * @throws FileNotFoundException 
	     * 上传文件
	     * 
	     */
	public String uploadPhoto() throws FileNotFoundException{
		//输入流  读取上传文件
		InputStream is = new FileInputStream(userPhoto);
		//头像相对路径
		String path = ServletActionContext.getServletContext().getRealPath("/")+"upload";
		String pic = "upload"+userPhotoFileName;
		//设置到user对象中，方便添加用户的时候插入数据
		user.setPic(pic);
		//创建一个文件夹来放头像相对路径
		File file = new File(path);
		//判断文件夹是否存在
		if(!file.exists()){//创建文件夹失败
			//重新创建子目录
			file.mkdirs();
		}
		//输出流输出文件
		OutputStream os = new FileOutputStream(path+"/"+userPhotoFileName);
		//读取的字节大小
		byte[] b =new byte[8096];
		int len = 0;
		//如果读取的上传数据不等于0
		try {
			while((len = is.read(b))!=-1){
				os.write(b, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			super.addFieldError("uploadFile", "文件未找到!");
		}
		return "uploadPhotoSuccess";
	}
	//添加用户action
	   public String add() throws SQLException{
		   int row=userservice.addUser(user);
		   if(row >0){
			   return "addSuccess";
		   }else{
			   super.addFieldError("addFail", "添加失败！");
		   }
		return "addFail";
	   }
	   //全部用户action
	   public String getAll() throws SQLException{
		   users = userservice.getAllUser();
		
		return "listUser";
	   }

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public File getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(File userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getUserPhotoFileName() {
		return userPhotoFileName;
	}

	public void setUserPhotoFileName(String userPhotoFileName) {
		this.userPhotoFileName = userPhotoFileName;
	}

	public String getUserPhotoContentType() {
		return userPhotoContentType;
	}

	public void setUserPhotoContentType(String userPhotoContentType) {
		this.userPhotoContentType = userPhotoContentType;
	} 
	
	   
	   
	
}
