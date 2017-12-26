package com.qhit.lh.gr3.momo.t7;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.qhit.lh.gr3.momo.t7.bean.Dept;
import com.qhit.lh.gr3.momo.t7.bean.Emp;
import com.qhit.lh.gr3.momo.t7.bean.User;
import com.qhit.lh.gr3.momo.t7.service.BaseService;
import com.qhit.lh.gr3.momo.t7.service.impl.BaseServiceImpl;
import com.qhit.lh.gr3.momo.t7.utils.HibernateSessionFactory;

public class EmpTest {
private BaseService baseService = new BaseServiceImpl();
	@Test
	public void add() {
		Emp emp = new Emp();
		emp.setEmpName("momo1");
		emp.setEmpSex("女");
		emp.setBrithday("2017-12-23");
		emp.setPhone("123456");
		//
		User user = new User();
		user.setUserName("592");
		user.setPassword("123456");
		//
		Dept dept =new Dept();
		dept = (Dept) baseService.getObjectById(dept,3);
		//
		user.setEmp(emp);
		emp.setUser(user);
		//
		emp.setDept(dept);
		dept.getEmps().add(emp);
		baseService.add(emp);
		System.out.println(emp.toString());
	}
	@Test
	public void delete() {
		Emp emp = new Emp();
		emp = (Emp) baseService.getObjectById(emp, 8);
		baseService.delete(emp);
	}
	@Test
	public void update() {
		Emp emp = new Emp();
		emp = (Emp) baseService.getObjectById(emp, 6);
		emp.setEmpName("zhn");
		emp.setEmpSex("m");
		baseService.update(emp);
	}
	
	
	@Test       
	public void gatAll() {
		List<Object> list =baseService.getAll("from Emp");
		for(Object object : list){
			Emp emp = (Emp) object;
			System.out.println("show ----  time");
			System.out.println(emp.toString());
			
			
		}
		
	}
	@Test
	public void getEmpLikeName(){
		//获取session对象
		Session session = HibernateSessionFactory.getSession();
		//通过session创建criteria条件查询器
		Criteria criteria = session.createCriteria(Emp.class)
				.add(Restrictions.like("empName", "王%"));
		//通过criteria条件查询器进行查询
		List<Emp> list = criteria.list();
		for(Emp emp : list){
			System.out.println(emp.getEmpId()+":"+emp.getEmpName());
		}
	}
	
	@Test
	public void getEmpLikeSex(){
		//获取session对象
		Session session = HibernateSessionFactory.getSession();
		//通过session对象创建criteria条件查询器
		Criteria criteria = session.createCriteria(Emp.class)
				.add(Restrictions.like("empName", "王%"))
				.add(Restrictions.like("empSex", "m"));
		//通过criteria条件查询器进行查询
		List<Emp> list = criteria.list();
		//遍历查询
		for(Emp emp : list){
			System.out.println(emp.getEmpName()+"::::::"+emp.getEmpSex());
		}
	}
	///////////   已改正、、因为少写一个多对一配置，
	//erroe有错误
	@Test
	public void getEmpByName(){
		//获取session对象
		Session session = HibernateSessionFactory.getSession();
		//通过session对象创建criteria条件查询器
		Criteria criteria = session.createCriteria(Emp.class)
				.setFetchMode("dept",FetchMode.JOIN)
				.createAlias("dept", "d")
				.add(Restrictions.eq("d.deptName", "董事会"));
		
		//通过criteria条件查询器进行查询
	    List<Emp> list = criteria.list();
		//遍历查询
		for(Emp emp : list){
			System.out.println(emp.getEmpId()+":"+emp.getEmpName());
		}
	}
	
	@Test
	public void getEmpBySel(){
		//获取session对象、
		Session session = HibernateSessionFactory.getSession();
		//通过session创建criteria条件查询器
		Criteria criteria = session.createCriteria(Dept.class)
				.setFetchMode("emps", FetchMode.JOIN)
				.createAlias("emps", "e");
		//设置分组条件和查询结果
		ProjectionList projectionList = Projections.projectionList()
				.add(Projections.groupProperty("deptId"))
				.add(Projections.groupProperty("deptName"))
				.add(Projections.groupProperty("address"))
				.add(Projections.count("e.empId"));
		//关联条件查询和结果
		criteria.setProjection(projectionList);
		//通过criteria进行条件查询
		List<Object[]> list = criteria.list();
		//遍历查询
		for(Object[] object : list){
			System.out.println(object[0]+":"+object[1]+":"+object[2]);
			     
		}
	}
	
}
