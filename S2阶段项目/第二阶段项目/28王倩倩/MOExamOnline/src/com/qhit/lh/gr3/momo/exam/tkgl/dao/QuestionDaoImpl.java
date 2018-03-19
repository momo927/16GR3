package com.qhit.lh.gr3.momo.exam.tkgl.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.qhit.lh.gr3.momo.exam.common.bean.PageBean;
import com.qhit.lh.gr3.momo.exam.common.dao.BaseDao;
import com.qhit.lh.gr3.momo.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.momo.exam.tkgl.bean.WrittenQuestion;

/**
 * 
 * @author 王倩倩
 *TODO
 *2018年1月2日下午8:14:07
 * @param 
 */
public class QuestionDaoImpl extends BaseDao implements QuestionDao {
	/**
	 * 题库列表
	 */
	@Override
	public List<Course> getCourseInfo(Map parameter) {
		//hql
		StringBuffer hql = new StringBuffer();
		hql.append("select course from Course course where 1 = 1 " );
		//拼接hql
		if(parameter.get("major") != null && !"".equals(parameter.get("major"))){
			hql.append(" and course.major = :major");
		}
		if(parameter.get("stage") != null && !"".equals(parameter.get("stage"))){
			hql.append(" and course.stage = :stage");
        }
		//通过session获取查询器
		Query query = getSession().createQuery(hql.toString());
		//设置参数
		if(parameter.get("major") != null && !"".equals(parameter.get("major"))){
			query.setString("major", (String) parameter.get("major"));
		}
		if(parameter.get("stage") != null && !"".equals(parameter.get("stage"))){
			query.setString("stage", (String) parameter.get("stage"));
		}
		//执行查询
		return query.list();
	
	}
	/**
	 * 笔试题列表分页数据
	 */
	@Override
	public PageBean<WrittenQuestion> getWrittenList(PageBean<WrittenQuestion> pageBean, Course course, int pageIndex) {
	
		//hql语句(hql查的是对象与对象中的属性（实体类中的），，sql查询的是数据库表中的字段)
		StringBuffer hql = new StringBuffer();
		hql.append("select w from WrittenQuestion w where w.csId = :csId " );
		//通过session获取查询器
		Query query = getSession().createQuery(hql.toString());
		//设置分页查询参数
		query.setInteger("csId", course.getCsId());
		//总记录数
		int count = query.list().size();
		pageBean.setTotalNumber(count);
		pageBean.setCurrentIndex(pageIndex);
		//当前页数据
		List<WrittenQuestion> items = query.setFirstResult((pageBean.getCurrentIndex()-1)*pageBean.getPageSize())
				.setMaxResults(pageBean.getPageSize())
				.list();
		//设置pageBean的数据集合
		pageBean.setItems(items);
		return pageBean;
	}
	/**
	 * 添加笔试题
	 */
	@Override
	public void addWrittenQuestion(WrittenQuestion writtenQuestion) {
		//开启事务
		Transaction ts =getSession().beginTransaction();
		//执行添加
		long id = (long) getSession().save(writtenQuestion);
		//提交事务
		ts.commit();
	}
	/**
	 *
	 * 根据id查询试题
	 */
	@Override
	public WrittenQuestion getWrittenQuestionById(WrittenQuestion writtenQuestion) {
		
		return (WrittenQuestion) getSession().get(WrittenQuestion.class, writtenQuestion.getQid());
	
	}
	/**
	 * 
	 * 更新数据
	 */
	@Override
	public void updateWrittenQuestion(WrittenQuestion writtenQuestion) {
		//清除session中的缓存对象
		getSession().clear();
		//开启事务
		Transaction ts = getSession().beginTransaction();
		//执行
		getSession().update(writtenQuestion);
		//提交事务
		ts.commit();
		
		
		
	}
	/**
	 * 
	 * 批量导入笔试题
	 */
	@Override
	public void inportWrittenQuestions(List<WrittenQuestion> listWQuestions) {
		//开启事务
		Transaction ts = getSession().beginTransaction();
		//循环出试题，添加试题
		for(WrittenQuestion writtenQuestion : listWQuestions){
			//执行添加
			getSession().save(writtenQuestion);
		}
		//提交事务
		ts.commit();
		
	}
	/**
	 * 获取试题数
	 */
	@Override
	public int getQuestionsMax(int csId, String qtype, String degree) {
			Criteria criteria = getSession().createCriteria(WrittenQuestion.class)
					.add(Restrictions.eq("csId", csId))
					.add(Restrictions.eq("qtype", qtype))
					.add(Restrictions.eq("degree", degree));
			
			ProjectionList projectionList = Projections.projectionList()
					.add(Projections.count("qid"));
			
			criteria.setProjection(projectionList);
			long num = (long) criteria.list().get(0);
			return (int)num;
		}
	
	
	/**
	 * 获取试题集合
	 */
	@Override
	public List<WrittenQuestion> getQuestionsByType(int csId, String qtype, String degree) {
		// QBC查询(根据课程ID，类型，阶段查询)
		Criteria criteria = getSession().createCriteria(WrittenQuestion.class)
							.add(Restrictions.eq("csId", csId))
							.add(Restrictions.eq("qtype", qtype))
							.add(Restrictions.eq("degree", degree));
		
		return criteria.list();
	}
	}


