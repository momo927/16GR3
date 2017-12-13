package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.momo.t2.bean.Dept;
import com.qhit.lh.gr3.momo.t2.bean.User;
import com.qhit.lh.gr3.momo.t2.service.BaseService;
import com.qhit.lh.gr3.momo.t2.service.impl.BaseServiceImpl;



/**
 * @author 王倩倩
 *TODO
 *2017年12月12日下午10:18:00
 */
public class UserTest {
	private BaseService baseService = new BaseServiceImpl();
	@Test
	public void add() {
		//声明并实例化
		User user = new User();
		user.setUserName("521");
		user.setUserSex("f");
		user.setBrithday("2017-12-12");
		user.setAddress("154");
		user.setPhone("12345679252");
		user.setDeptId(7);
		//分配一个账户
		Dept dept = new Dept();
		dept.setDeptName("521");
		dept.setPassword("123456");
		//建立一对一关系
		dept.setUser(user);
		user.setDept(dept);
		//
		baseService.add(user);
				
		
		
		
	}
	@Test
	public void delete() {
		//声明并实例化对象
		User user = new User();
		//查找id
		user = (User) baseService.getObjectById(user, 1);
		baseService.delete(user);
		
		
	}
	@Test
	public void update() {
		//声明并实例化
				User user = new User();
				user.setUserId(10);
				user.setUserName("haha");
				user.setUserSex("m");
				user.setBrithday("2017-12-12");
				user.setAddress("521");
				user.setPhone("12345679252");
				//分配一个账户
				Dept dept = new Dept();
				dept.setDeptId(10);
				dept.setDeptName("000");
				dept.setPassword("123456");
				//建立一对一关系
				dept.setUser(user);
				user.setDept(dept);
				//
				baseService.add(user);
		
		
	}
	@Test
	public void getAll() {
		List<Object> list = baseService.getAll("from User");
		for(Object object : list){
			User user = (User) object;
			System.out.println(user.toString());
		}
	}

}
