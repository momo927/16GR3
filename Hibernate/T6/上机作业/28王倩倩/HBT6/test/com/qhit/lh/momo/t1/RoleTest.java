package com.qhit.lh.momo.t1;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.momo.t1.bean.Role;
import com.qhit.lh.momo.t1.bean.User;
import com.qhit.lh.momo.t1.service.BaseService;
import com.qhit.lh.momo.t1.service.impl.BaseServiceImpl;

/**
 * @author 王倩倩
 *TODO
 *2017年12月20日上午10:21:13
 */
public class RoleTest {
private BaseService baseService = new BaseServiceImpl();

	@Test
	public void add() {
		//添加角色
		Role role = new Role();
		role.setRoleName("主席");
		role.setMemo("漯河大学");
		//获取账号
		User user = new User();
		user.setUserName("张盼");
		user.setPassword("123456");
		//user = (User) baseService.getObjectById(user, 1);
		//建立角色与账户关系
		role.getUsers().add(user);
		
		//
		baseService.add(role);
		
		
	}
	@Test
	public void delete() {
		//
		Role role = new Role(); 
		role = (Role) baseService.getObjectById(role, 3);
		baseService.delete(role);
	}
	@Test
	public void update() {
		Role role = new Role();
		role = (Role) baseService.getObjectById(role, 1);
		role.setRoleName("管理员大人");
		baseService.update(role);
	}
	@Test
	public void getAll() {
		List<Object> list = baseService.getAll("from Role"); 
		for (Object object : list) {
			Role role = (Role) object;
			System.out.println(role.toString());
		}
	}

}
