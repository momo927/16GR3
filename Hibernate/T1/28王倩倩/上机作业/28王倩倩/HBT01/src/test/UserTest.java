package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.momo.t1.bean.User;
import com.qhit.lh.gr3.momo.t1.service.BaseService;
import com.qhit.lh.gr3.momo.t1.service.impl.BaseServiceImpl;

/**
 * @author 王倩倩
 *TODO
 *2017年12月11日下午4:17:47
 */
public class UserTest {
	//声明service
	private BaseService baseService = new BaseServiceImpl();
	@Test
	public void addUse() {
		//声明并实例化对象
		User user = new User();
		user.setUname("hello");
		user.setUpwd("123456");
		//操作
		baseService.add(user);
	}
	@Test
	public void deldteUser() {
		//声明并实例化对象
		User user = new User();
		user.setUid(1);
		baseService.delete(user);
	}
	@Test
	public void updateUser() {
		//声明并实例化对象
		User user = new User();
		user.setUid(1);
		user.setUname("ooo");
		user.setUpwd("123456");
		baseService.update(user);
	}
	@Test
	public void getAll() {
		List<Object> list = baseService.getAll("from User");
		//循环出list中的数据
		for(Object object : list){
			//用对象接收数据
			User user = (User)object;
			//输出数据
			System.out.println(user.toString());
			
		}
		
	}

}
