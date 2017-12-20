package com.qhit.lh.momo.t1;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.momo.t1.bean.Dept;
import com.qhit.lh.momo.t1.bean.Emp;
import com.qhit.lh.momo.t1.bean.User;
import com.qhit.lh.momo.t1.service.BaseService;
import com.qhit.lh.momo.t1.service.impl.BaseServiceImpl;

/**
 * @author 王倩倩
 *TODO
 *2017年12月18日上午11:15:04
 */
public class DeptTest {
private BaseService baseService = new BaseServiceImpl();
	@Test
	public void add() {
		//声明并实例化对象
		Dept dept = new Dept();
		dept.setDeptName("123");
		dept.setAddress("河南");
		//添加人员
		Emp emp1 = new Emp();
		emp1.setEmpName("王国");
		emp1.setEmpSex("m");
		emp1.setBrithday("2017-09-27");
		emp1.setPhone("123456789");
		
		
		Emp emp2 = new Emp();
		emp2.setEmpName("王涛");
		emp2.setEmpSex("m");
		emp2.setBrithday("2017-09-27");
		emp2.setPhone("123456789");
		
		dept = (Dept) baseService.getObjectById(dept, 4);
		
		dept.getEmps().add(emp1);
		dept.getEmps().add(emp2);
	
		
		baseService.add(dept);
	}
	@Test
	public void addDept() {
		
		Dept dept = new Dept();
		dept.setDeptName("国防部");
		dept.setAddress("北京");
		//添加人员
		Emp emp = new Emp();
		emp.setEmpName("胡一天");
		emp.setEmpSex("m");
		emp.setBrithday("2017-12-12");
		emp.setPhone("1234665050");
		//分配用户
		User user = new User();
		user.setUserName("胡一天");
		user.setPassword("123456");
		//1-1
		emp.setUser(user);
		user.setEmp(emp);
		//1-n
		dept.getEmps().add(emp);
		//
		emp.setDept(dept);
		//
		baseService.add(dept);
		System.out.println(emp.toString());
	}
	
	@Test
	public void delete() {
		Dept dept = new Dept();
		dept = (Dept) baseService.getObjectById(dept, 3);
		baseService.delete(dept);
	}
	
	@Test
	public void update() {
		Dept dept = new Dept();
		dept = (Dept) baseService.getObjectById(dept, 4);
		dept.setDeptName("大使馆");
		baseService.update(dept);
	}
	
	@Test
	public void getAll() {
		/*Dept dept = new Dept();
         dept = (Dept) baseService.getObjectById(dept, 4);
		 for(Emp emp:dept.getEmps()){
			 System.out.println(dept.getDeptName()+":"+emp.getEmpName());
		}*/
		
		List<Object> list = baseService.getAll("from Dept");
		for(Object object : list){
			Dept dept = (Dept) object;
			System.out.println(dept.toString());
		}
	}

}
