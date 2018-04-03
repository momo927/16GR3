package com.qhit.lh.gr3.momo.exam.tkgl.dao;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.momo.exam.common.bean.PageBean;
import com.qhit.lh.gr3.momo.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.momo.exam.tkgl.bean.WrittenQuestion;

/**
 * 
 * @author 王倩倩
 *TODO
 *2018年1月2日下午8:14:15
 */
public interface QuestionDao {
	
	/**
	 * 获取试题集合
	 * @param csId
	 * @param qtype
	 * @param degree
	 * @return
	 */
	public List<WrittenQuestion> getQuestionsByType(int csId,String qtype,String degree);
	/**
	 * 
	 * @param paramter
	 * @return
	 * 题库管理
	 * 题库列表
	 * 
	 * 
	 */
     public List<Course> getCourseInfo(Map parameter);
     /**
      * 
      * @param PageBean
      * @param course
      * @param PageIndex
      * @return
      * 笔试题列表分页数据
      */
     public PageBean<WrittenQuestion> getWrittenList(PageBean<WrittenQuestion> ageBean,Course course,int pageIndex);
     /**
      * 
      * @param writtenQuestion
      * 添加笔试题
      */
     public void addWrittenQuestion(WrittenQuestion writtenQuestion);
     /**
      * 
      * @param writtenQuestion
      * @return
      * 根据id查询试题
      */
     public WrittenQuestion getWrittenQuestionById(WrittenQuestion writtenQuestion);
     /**
      * 
      * @param writtenQuestion
      * 更新数据
      */
     public void updateWrittenQuestion(WrittenQuestion writtenQuestion);
     /**
      * 
      * @param listWQuestions
      * 批量导入笔试题
      */
     public void inportWrittenQuestions(List<WrittenQuestion> listWQuestions);
     /**
  	 * @return
  	 * 获取题目数
  	 */
  	public int getQuestionsMax(int csId,String qtype,String degree);
     
     
     
}
