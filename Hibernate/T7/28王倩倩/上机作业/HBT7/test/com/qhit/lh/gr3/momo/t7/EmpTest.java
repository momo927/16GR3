package com.qhit.lh.gr3.momo.t7;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
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
		emp.setEmpName("孤独患者");
		emp.setEmpSex("女");
		emp.setBrithday("2017-12-23");
		emp.setPhone("123456");
		//
		User user = new User();
		user.setUserName("592");
		user.setPassword("123456");
		//
		Dept dept =new Dept();
		dept = (Dept) baseService.getObjectById(dept,2);
		//
		user.setEmp(emp);
		emp.setUser(user);
		//
		emp.setDept(dept);
		baseService.add(emp);
		System.out.println(emp.toString());
	}
	@Test
	public void delete() {
		Emp emp = new Emp();
		emp = (Emp) baseService.getObjectById(emp, 7);
		baseService.delete(emp);
	}
	@Test
	public void update() {
		Emp emp = new Emp();
		emp = (Emp) baseService.getObjectById(emp, 8);
		emp.setEmpName("zhangsan");
		emp.setEmpSex("m");
		baseService.update(emp);
	}
	@Test
	public void gatAll() {
		List<Object> list =baseService.getAll("from Emp");
		for(Object object : list){
			Emp emp = (Emp) object;
			System.out.println(emp.toString());
			
			
		}
		
	}
	
}
