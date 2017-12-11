package com.qhit.sbm.goods.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.goods.bean.Goods;
import com.qhit.sbm.goods.service.GoodsService;
import com.qhit.sbm.goods.service.Impl.GoodsServiceImpl;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/goods")
public class GoodsServlet extends HttpServlet {
	private GoodsService goodsservice= new GoodsServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		String cmd=request.getParameter("cmd");
		switch (cmd) {
		case "getGoodsInfoByName":
			getGoodsInfoByName(request,response);
			break;
		case "updateStore":
			updateStore(request,response);
			break;

		default:
			break;
		}
	}

	private void updateStore(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Goods goods=(Goods)request.getAttribute("goods");
		String businessNum = request.getParameter("businessNum");
		int num=goods.getGoodsNum() + Integer.parseInt(businessNum);
		int row=goodsservice.updateStore(num, goods.getGoodsId());
		response.sendRedirect("account?cmd=getPageBean&p=1");
		
	}

	private void getGoodsInfoByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String goodsName=request.getParameter("goodsName");
		//通过服务类调用参数
		Goods goods = goodsservice.getGoodsInfoByName(goodsName);
		if(goods != null){
			//有商品     直接添加，没有商品     提示
			request.setAttribute("goods", goods);
			RequestDispatcher requestdispatcher=request.getRequestDispatcher("account?cmd=addAccount");
			requestdispatcher.forward(request, response);
		}else{
			PrintWriter out=response.getWriter();
			out.print("<script>alert('商品查询失败，请先添加商品！');</script>");
		}
	}

}
