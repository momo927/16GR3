package com.qhit.lh.gr3.momo.exam.kmgl.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.momo.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.momo.exam.kmgl.dao.CourseDao;
import com.qhit.lh.gr3.momo.exam.kmgl.dao.CourseDaoImpl;

/**
 * 
 * @author 王倩倩
 *TODO
 *2018年1月9日上午10:21:02
 */
public class CourseServiceImpl implements CourseService {
private CourseDao courseDao = new CourseDaoImpl();
	@Override
	public List<Course> getCourseList(Map<String, Object> parameter) {
		// TODO Auto-generated method stub
		return courseDao.getCourseList(parameter);
	}

}
