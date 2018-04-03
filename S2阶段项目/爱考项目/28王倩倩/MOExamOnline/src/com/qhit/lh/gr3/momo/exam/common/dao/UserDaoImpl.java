package com.qhit.lh.gr3.momo.exam.common.dao;

import java.util.List;

import org.hibernate.Query;

import com.qhit.lh.gr3.momo.exam.common.bean.User;

/**
 * 
 * @author 王倩倩
 *TODO
 *2017年12月27日下午9:00:03
 */
public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User login(User user) {
		//hql语句
		
		String hql = "select user from User user where user.name = ? and user.pwd = ? and user.role = ?";
		//创建查询器
		Query query = getSession().createQuery(hql);
		query.setString(0, user.getName());
		query.setString(1, user.getPwd());
		query.setInteger(2, user.getRole());
		
		List<User> list =(List<User>)query.list();
		if(list != null && list.size()==1){
			//登录成功
			return list.get(0);
		}
		return null;
		
		
		
	}
	}

