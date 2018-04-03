package com.qhit.lh.gr3.momo.exam.common.dao;

import org.hibernate.Session;

import com.qhit.lh.gr3.momo.exam.common.utils.HibernateSessionFactory;

/**
 * 
 * @author 王倩倩
 *TODO
 *2017年12月28日上午10:20:45
 */
public class BaseDao {
////////////////////?
	public Session getSession(){
		return HibernateSessionFactory.getSession();
		
	}
}
