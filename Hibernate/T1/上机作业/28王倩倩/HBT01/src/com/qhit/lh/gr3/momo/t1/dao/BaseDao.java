package com.qhit.lh.gr3.momo.t1.dao;

import java.util.List;

/**
 * @author 王倩倩
 *TODO
 *2017年12月11日下午3:36:06
 */
public interface BaseDao {
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
}
