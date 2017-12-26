package com.qhit.lh.gr3.momo.t7;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.momo.t7.bean.Dept;
import com.qhit.lh.gr3.momo.t7.bean.Emp;
import com.qhit.lh.gr3.momo.t7.bean.User;
import com.qhit.lh.gr3.momo.t7.service.BaseService;
import com.qhit.lh.gr3.momo.t7.service.impl.BaseServiceImpl;

public class DeptTest {
private BaseService baseService = new BaseServiceImpl();
	@Test
	public void add() {
		Dept dept = new Dept();
		dept.setDeptName("形象部");
		dept.setAddress("henan");
		//添加员工
		Emp emp = new Emp();
		emp.setEmpName("李易峰");
		emp.setEmpSex("男");
		emp.setBrithday("2017-12-12");
		emp.setPhone("123456");
		//分配用户
		User user = new User();
		user.setUserName("wangwang");
		user.setPassword("123456");
		//1-1
		emp.setUser(user);
		user.setEmp(emp);
		//
		dept.getEmps().add(emp);
		baseService.add(dept);
		
		
		
		
	}
	@Test
	public void delete() {
		Dept dept = new Dept();
		dept =(Dept) baseService.getObjectById(dept, 3);
		baseService.delete(dept);
	}
	@Test
	public void update() {
		Dept dept = new Dept();
		dept =(Dept) baseService.getObjectById(dept, 3);
		dept.setDeptName("空军部");
		baseService.update(dept);
	}
	@Test
	public void getAll() {
		List<Emp> list = baseService.getEmpByName("%王%");
		for(Emp emp : list){
			System.out.println(emp.getEmpId()+":"+emp.getEmpName());
		}
	}

}
