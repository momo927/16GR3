package com.qhit.sbm.common.bean;

import java.util.ArrayList;
import java.util.List;

import com.qhit.sbm.account.bean.AccountDetail;

public class PageBean {
		private int pagesize;
		private int p;
		private int count;
		private int pagetotal;
		private List Data;
		public PageBean() {
			//给pagebeansize赋值，初始化data集合
			
			pagesize=5;
			Data=new ArrayList<PageBean>();
		}
		public PageBean(int pagesize, int p, int count, int pagetotal, List data) {
			super();
			this.pagesize = pagesize;
			this.p = p;
			this.count = count;
			this.pagetotal = pagetotal;
			Data = data;
		}
		public int getPagesize() {
			return pagesize;
		}
		public void setPagesize(int pagesize) {
			this.pagesize = pagesize;
		}
		public int getP() {
			return p;
		}
		public void setP(int p) {
			//页数不小于最小，不大于最大
			if(p<1){
				p=1;
			}else if(p>pagetotal){
				p=pagesize;
			}else{
				p=p;
			}
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
			//总页数
			pagetotal = (int) (Math.ceil(count*1.0/pagesize));
		}
		public int getPagetotal() {
			return pagetotal;
		}
		public void setPagetotal(int pagetotal) {
			this.pagetotal = pagetotal;
		}
		public List getData() {
			return Data;
		}
		public void setData(List data) {
			Data = data;
		}
		
		/**
		 * 
		 * @param accountdetail
		 * 添加的集合
		 */
		public void addData(Object obj){
			Data.add(obj);
		}
		
		
		
		
}
