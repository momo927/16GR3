package com.qhit.sbm.account.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.account.service.AccountService;
import com.qhit.sbm.account.service.Impl.AccountServiceImpl;
import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.common.service.CommonService;
import com.qhit.sbm.common.service.Impl.CommonServiceImpl;
import com.qhit.sbm.goods.bean.Goods;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/account")
public class AccountServlet extends HttpServlet {
	private CommonService commonService = new CommonServiceImpl();
	private AccountService accountService = new AccountServiceImpl();

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		switch (cmd) {
		case "getPageBean":
			getPageBean(request,response);
			break;
		case "getAccountByParam":
			gatAccountByParam(request,response);
			break;
		case "deleteAccount":
			deleteAccount(request,response);
			break; 
		case "updateAccount":
			updateAccount(request,response);
			break;
		case "addAccount":
			addAccount(request,response);
			break;
		default:
			break;
		}
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * 添加账单：
	 * 1，进入页面之前需要先查询所有的供应商：供应商模块（已完成）
	 * 2，根据提交的商品名称查询商品信息:商品模块(已完成)
	 * 3，根据商品信息和提交的交易数量来计算交易总额：账单模块
	 * 4,更新商品库存（可选）
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void addAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取goods对象
		Goods goods = (Goods) request.getAttribute("goods");
		//获取参数
		String businessNum = request.getParameter("businessNum");
		String providerId = request.getParameter("providerId");
		String isPayed = request.getParameter("isPayed");
		//添加参数到service中
		int row = accountService.addAccount(
				goods, 
				Integer.parseInt(businessNum), 
				Integer.parseInt(providerId), 
				Integer.parseInt(isPayed));
		//判断参数是否添加成功
		if(row > 0){
			//更新库存（getRequestDispatcher）
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("goods?cmd=updateStore");
			requestDispatcher.forward(request, response);
			
		}else{
			//添加失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('添加失败');</script>");
		}
		
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * 添加账单信息
	 * @throws IOException 
	 */
	private void updateAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String accountId = request.getParameter("accountId");
		String providerId = request.getParameter("providerId");
		String isPayed = request.getParameter("isPayed");
		int row=accountService.upDateAccountById(
				Integer.parseInt(accountId), 
				Integer.parseInt(providerId),
				Integer.parseInt(isPayed));
		if(row > 0){
			//更新成功
			response.sendRedirect("account?cmd=getPageBean&&p=1");
		}else{
			//更新失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('更新失败');</script>");
		}
		
		
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * 删除账单
	 * @throws IOException 
	 */
	private void deleteAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String accountId = request.getParameter("accountId");
		int row=accountService.deleteAccountById(Integer.parseInt(accountId));
		if(row > 0){
		//删除成功
			response.sendRedirect("account?cmd=getPageBean && p=1");
		}else{
			//删除失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('删除失败');</script>");
		}
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * 获取账单中的参数
	 * @throws IOException 
	 */
	private void gatAccountByParam(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String goodsName=request.getParameter("goodsName");
		String isPayed=request.getParameter("isPayed");
		List<String> wheres = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		if(goodsName != null && goodsName != ""){
			wheres.add("g.goodsName");
			values.add(goodsName);
		}
		if(isPayed != null && isPayed != ""){
			wheres.add("a.isPayed");
			values.add(isPayed);
		}
		//从pagebean中获取参数
		PageBean pageBean = accountService.gatPageBeanByParam(wheres, values);
		//放入session中
		request.getSession().setAttribute("pageBean", pageBean);
		//打印出
		PrintWriter out = response.getWriter();
		out.print("<script>location.href = 'jsp/admin_bill_list.jsp'</script>");
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * 分页
	 * @throws IOException 
	 */
	private void getPageBean(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		//在公共服务类中获取行数
		int count=commonService.getCount("t_account", null, null);
		//判断p是否为空
		String p=request.getParameter("p");
		if(p != null && p != ""){
			pageBean.setP(Integer.parseInt(p));
		}else{
			pageBean.setP(1);
		}
		pageBean=accountService.getPageBean(pageBean);
		//找出pagebean中data集合中的所有数据，保存数据到session
		System.out.println(pageBean.getData().size());
		request.getSession().setAttribute("pagebean", pageBean);
		//
		if(p !=null && p != ""){
			//有参数p  打印出
			PrintWriter out= response.getWriter();
			out.print("<script>location.href='jsp/admin_bill_list.jsp'</script>");
		}else{
			response.sendRedirect("jsp/admin_index.jsp");
		}
		
	}
	}


