package com.qhit.lh.gr3.momo.t7.service;

import java.util.List;

import com.qhit.lh.gr3.momo.t7.bean.Emp;

/**
 * @author 王倩倩
 *TODO
 *2017年12月12日下午8:35:33
 */
public interface BaseService {
	/**
	 * 
	 * @param obj
	 * 增
	 */
    public void add(Object obj);
    /**
     * 
     * @param obj
     * 删
     */
    public void delete(Object obj);
    /**
     * 
     * @param obj
     * 改
     */
    public void update(Object obj);
    /**
     * 
     * @param fromObject
     * @return
     * 查
     */
    public List<Object> getAll(String fromObject);
    /**
     * 
     * @param object
     * @param id
     * @return
     * 根据id查询
     */
    public Object getObjectById(Object object,int id);
    /**
     * 
     * @param name
     * @return
     * 模糊查寻员工名字
     */
    public List<Emp> getEmpByName(String name);
    /**
     * 
     * @param sex
     * @return
     * 根据性别查员工
     */
    public List<Emp> getEmpBySex(String sex);

}
