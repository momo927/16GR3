package com.qhit.lh.gr3.momo.t7.service.impl;

import java.util.List;

import com.qhit.lh.gr3.momo.t7.bean.Emp;
import com.qhit.lh.gr3.momo.t7.dao.BaseDao;
import com.qhit.lh.gr3.momo.t7.dao.impl.BaseDaoImpl;
import com.qhit.lh.gr3.momo.t7.service.BaseService;

;
 
/**
 * @author 王倩倩
 *TODO
 *2017年12月11日下午3:36:14
 */
public class BaseServiceImpl implements BaseService {
	private BaseDao baseDao = new BaseDaoImpl();
	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		baseDao.add(obj);
	}

	@Override
	public void delete(Object obj) {
		// TODO Auto-generated method stub
		baseDao.delete(obj);
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		baseDao.update(obj);
	}

	@Override
	public List<Object> getAll(String fromObject) {
		// TODO Auto-generated method stub
		return baseDao.getAll(fromObject);
	}

	@Override
	public Object getObjectById(Object object, int id) {
		// TODO Auto-generated method stub
		return baseDao.getObjectById(object, id);
	}

	@Override
	public List<Emp> getEmpByName(String name) {
		// TODO Auto-generated method stub
		return baseDao.getEmpByName(name);
	}

	@Override
	public List<Emp> getEmpBySex(String sex) {
		// TODO Auto-generated method stub
		return baseDao.getEmpBySex(sex);
	}

}
