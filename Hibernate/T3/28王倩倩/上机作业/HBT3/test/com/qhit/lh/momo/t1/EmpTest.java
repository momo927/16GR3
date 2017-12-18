package com.qhit.lh.momo.t1;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.momo.t1.bean.Dept;
import com.qhit.lh.momo.t1.bean.Emp;
import com.qhit.lh.momo.t1.bean.User;
import com.qhit.lh.momo.t1.service.BaseService;
import com.qhit.lh.momo.t1.service.impl.BaseServiceImpl;

public class EmpTest {
private BaseService baseService = new BaseServiceImpl();
	@Test
	public void add() {
		//声明并实例化对象
		Emp emp = new Emp();
		emp.setEmpName("李薇");
		emp.setEmpSex("f");
		emp.setBrithday("2017-09-27");
		emp.setPhone("123456789");
		//emp.setDeptId(2);
		
		//分配一个用户
		User user = new User();
		user.setUserName("liwei");
		user.setPassword("123456");
		//分配所属部门
		Dept dept = new Dept();
		dept = (Dept) baseService.getObjectById(dept, 3);
		//一对一
		emp.setUser(user);
		user.setEmp(emp);
		//多对一
		emp.setDept(dept);
		
		baseService.add(emp);
	
	}
	@Test
	public void delete() {
		//声明并实例化对象
		Emp emp = new Emp();
		emp = (Emp) baseService.getObjectById(emp, 4);
		baseService.delete(emp);
		
		
		
	}
	
	@Test
	public void update() {
		//声明并实例化对象
		Emp emp = new Emp();
		emp = (Emp) baseService.getObjectById(emp, 6);
		emp.setEmpName("王达康");
		emp.setEmpSex("m");
		emp.setBrithday("2017-09-27");
		emp.setPhone("123456789");
		
		
		//分配一个用户
		User user = new User();
		user = (User) baseService.getObjectById(user, 6);
		user.setUserName("王王王");
		user.setPassword("123456");
		//分配所属部门
		Dept dept = new Dept();
		dept = (Dept) baseService.getObjectById(dept, 3);
		//一对一
		emp.setUser(user);
		user.setEmp(emp);
		//多对一
		emp.setDept(dept);
		
		baseService.update(emp);
	}
	
	
	@Test
	public void getAll() {
   
    List<Object> list = baseService.getAll("from Emp");
    for(Object object : list){
    	Emp emp = (Emp) object;
    	System.out.println(emp.toString());
    	
    }
		
	}
}
