package com.qhit.lh.gr3.momo.exam.kmgl.dao;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.momo.exam.kmgl.bean.Course;

/**
 * 
 * @author 王倩倩
 *TODO
 *2018年1月9日上午10:21:19
 */
public interface CourseDao {
	/**
	 * 
	 * @param parameter
	 * @return
	 * 查询所有科目
	 */
public List<Course> getCourseList(Map<String,Object> parameter);
}
