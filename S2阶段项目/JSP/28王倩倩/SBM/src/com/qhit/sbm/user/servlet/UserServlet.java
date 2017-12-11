package com.qhit.sbm.user.servlet;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.service.UserService;
import com.qhit.sbm.user.service.Impl.UserServiceImpl;
import com.qhit.sbm.utils.CommonUtil;
import com.qhit.sbm.utils.IDUtil;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private UserService userservice= new UserServiceImpl();
	private boolean isOnline;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数cmd
		String cmd=request.getParameter("cmd");
		switch (cmd) {
		case "login":
			doLogin(request,response);
			break;
		case "exit":
			doExit(request,response);
			break;
		case "uploadPic":
			uploadPic(request,response);
			break;
		case "addUser":
			addUser(request,response);
			break;

		default:
			break;
		}
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * 添加用户
	 * @throws IOException 
	 */
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取用户参数
		
		String userName = (String) request.getAttribute("userName");
		String userPassWord = (String) request.getAttribute("userPassWord");
		String userSex = (String) request.getAttribute("userSex");
		String userAge = (String) request.getAttribute("userAge");//int
		String phone = (String) request.getAttribute("phone");
		String address = (String) request.getAttribute("address");
		String type =(String) request.getAttribute("type");//int
		
		String pic = (String) request.getAttribute("pic");
		User user=new User(
				userName, 
				userPassWord, 
				userSex,
				Integer.parseInt(userAge),
				phone,
				address,
				pic, 
				Integer.parseInt(type));
		int row=userservice.addUser(user);
		PrintWriter out = response.getWriter();
		if(row > 0){
			response.sendRedirect("jsp/userinfo.jsp?pic="+pic);
		}else{
			out.print("<script>alert('添加失败！请重试！');</script>");
		}
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * 上传用户头像
	 * @throws ServletException 
	 * @throws IOException 
	 */
	private void uploadPic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//实例化对象
		SmartUpload smartUpload=new SmartUpload();
		//初始化上传文件对象
		smartUpload.initialize(getServletConfig(), request, response);
		//设置允许上传类型
		smartUpload.setAllowedFilesList("png,jpg,jpeg,gif");
		//设置文件的大小（5M）
		smartUpload.setMaxFileSize(1024*1024*5);
		try {
			//上传
			smartUpload.upload();
			//保存文件
			String realPath = request.getRealPath("/")+"/";//项目路径
			String filePath = CommonUtil.FILE_USER_PIC_PHOTO_PATH;
			java.io.File file = new java.io.File(realPath+filePath);
			if(!file.exists()){
				file.mkdirs();
			}
			//图片保存的名称
			String picName= IDUtil.getUUID();
			//图片的后缀名
			//123456789
			com.jspsmart.upload.File picFile = smartUpload.getFiles().getFile(0);
			String picFileExt = picFile.getFileExt();
			//最终获取到的文件相对路径
			String picPath = filePath+picName+"."+picFileExt;
			//保存文件
			picFile.saveAs(realPath+picPath);
		   /**
			*头像上传成功，之后根据表单提交的数据和获取头像图片的存储路径插入数据表中：
			*因为需要之前表单的所有的数据所以需要用到请求转发
			*添加用户头像的路径到request对象中，转发出去
			*/
			Request srequest = smartUpload.getRequest();
			request.setAttribute("userName", srequest.getParameter("userName"));
			request.setAttribute("userPassword", srequest.getParameter("userPassword"));
			request.setAttribute("userSex", srequest.getParameter("userSex"));
			request.setAttribute("userAge", srequest.getParameter("userAge"));
			request.setAttribute("telephone", srequest.getParameter("telephone"));
			request.setAttribute("address", srequest.getParameter("address"));
			request.setAttribute("type", srequest.getParameter("type"));
			request.setAttribute("pic", picPath);
			RequestDispatcher rDispatcher = request.getRequestDispatcher("user?cmd=addUser");
			rDispatcher.forward(request, response);
		} catch (SmartUploadException e) {
			//异常处理
			out.print("<script>alert('上传头像失败，请检查图片格式和大小');</script>");
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * 
	 * 退出
	 * @throws IOException 
	 */

	private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//登录失败
		request.getSession().invalidate();
		PrintWriter out = response.getWriter();
		//复制的jsp头地址
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		//显示
		out.print("<script>window.top.location.href='"+basePath+"'</script>");
	}
	
	/***
	 * 
	 * @param request
	 * @param response
	 * 登录
	 * @throws IOException 
	 */
	
	private void doLogin(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		boolean isOnline=false;
		//获取用户名和密码
		String userName=request.getParameter("userName");
		String passWord=request.getParameter("passWord");
		//从服务类中获取登录用户
		User user=userservice.doLogin(userName, passWord);
		
	if(user != null){
			//登录成功，将信息放入session会话中
			request.getSession().setAttribute("user", user);
			//获取user的在用户集合
			List<User> users=(List<User>) request.getServletContext().getAttribute("online");
			//遍历
			for(User user2 : users){
				//判断用户是否登录
			if(user2.getUserid() == user.getUserid()){
					//用户以登录 跳转到在线集合
					isOnline =true;
					break;
					}	
					}
			
			if(isOnline){
				//有在线集合跳转
				response.sendRedirect("jsp/admin_index.jsp");
					
			}else{
					//把当前用户添加到users集合中
					users.add(user);
					//更新在线用户集合
					request.getServletContext().setAttribute("online", users);
					//跳转
					response.sendRedirect("jsp/admin_index.jsp");
			}
	}else{
			//登录失败
			response.sendRedirect("index.jsp?loginMsg=failed");
			
	}
			
		
		
	}

}
