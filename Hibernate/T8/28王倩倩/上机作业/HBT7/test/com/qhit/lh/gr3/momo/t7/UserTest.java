package com.qhit.lh.gr3.momo.t7;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.qhit.lh.gr3.momo.t7.bean.User;
import com.qhit.lh.gr3.momo.t7.utils.HibernateSessionFactory;
/**
 * 
 * @author 王倩倩
 *TODO
 *2017年12月25日下午10:02:45
 */
public class UserTest {

	@Test
	public void login() {
		//获取session对象
		Session session = HibernateSessionFactory.getSession();
		//通过session对象创建criteria条件查询器
		Criteria criteria = session.createCriteria(User.class)
				.add(Restrictions.eq("userName", "123"))
				.add(Restrictions.eq("password", "123"));
		//通过criteria条件查询器进行查询
		List<User> list = criteria.list();
		//判断list中是否有此值
		if(list != null && list.size() > 0){
			System.out.println("登录成功！！！");
		}else{
			System.out.println("登录失败！！！");
		}
	}

}
