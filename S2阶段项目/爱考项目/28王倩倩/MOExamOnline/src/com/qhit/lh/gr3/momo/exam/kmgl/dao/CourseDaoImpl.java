package com.qhit.lh.gr3.momo.exam.kmgl.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.qhit.lh.gr3.momo.exam.common.dao.BaseDao;
import com.qhit.lh.gr3.momo.exam.kmgl.bean.Course;

/**
 * 
 * @author 王倩倩
 *TODO
 *2018年1月9日上午10:21:14
 */
public class CourseDaoImpl extends BaseDao implements CourseDao {

	@Override
	public List<Course> getCourseList(Map<String, Object> parameter) {
		//hql语句
		StringBuffer hql = new StringBuffer();
		hql.append("select course from Course course where 1 = 1");
		//拼接hql语句
		if(parameter.get("major") != null && !"".equals(parameter.get("major"))){
			hql.append(" and course.major = :major");
		}
		if(parameter.get("stage") != null && !"".equals(parameter.get("stage"))){
			hql.append(" and course.stage = :stage");
		}
		//获取查询器
		Query query = getSession().createQuery(hql.toString());
		//设置参数
		if(parameter.get("major") != null && !"".equals(parameter.get("major"))){
			query.setString("major", (String) parameter.get("major"));
		}
		if(parameter.get("stage") != null && !"".equals(parameter.get("stage"))){
			query.setString("stage", (String) parameter.get("stage"));
		}
		//返回执行查询
		return query.list();
	}

}
