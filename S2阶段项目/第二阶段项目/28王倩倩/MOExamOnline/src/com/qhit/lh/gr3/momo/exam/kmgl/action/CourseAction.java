package com.qhit.lh.gr3.momo.exam.kmgl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.momo.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.momo.exam.kmgl.service.CourseService;
import com.qhit.lh.gr3.momo.exam.kmgl.service.CourseServiceImpl;
/**
 * 
 * @author 王倩倩
 *TODO
 *2018年1月9日上午10:22:22
 */
public class CourseAction extends ActionSupport {
	private CourseService courseService = new CourseServiceImpl();
	private List<Course> listCourses =new ArrayList<Course>();
	private Course course;
	
	public String getCourseJson(){
		//设置参数
		Map<String, Object > parameter = new HashMap<String, Object>();
		if(course != null){
			parameter.put("major", course.getMajor());
			parameter.put("stage", course.getStage());
		}
		//查询题库列表数据
		listCourses = courseService.getCourseList(parameter);
		System.out.println("异步请求"+listCourses.size());
		return "ListCourseJson";
		
	}
	
	
	////
	public List<Course> getListCourses(){
		return listCourses;
		
	}
	public Course getCourse(){
		return course;
		
	}
	public void setListCourses(List<Course> listCourses) {
		this.listCourses = listCourses;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
}
