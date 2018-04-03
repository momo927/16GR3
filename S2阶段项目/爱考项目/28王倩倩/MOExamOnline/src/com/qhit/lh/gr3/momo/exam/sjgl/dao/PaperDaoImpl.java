package com.qhit.lh.gr3.momo.exam.sjgl.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.qhit.lh.gr3.momo.exam.bjgl.bean.ClassInfo;
import com.qhit.lh.gr3.momo.exam.common.bean.PageBean;
import com.qhit.lh.gr3.momo.exam.common.dao.BaseDao;
import com.qhit.lh.gr3.momo.exam.sjgl.bean.Paper;
import com.qhit.lh.gr3.momo.exam.sjgl.bean.PaperClass;

/**
 * 
 * @author 王倩倩
 *TODO
 *2018年1月9日上午9:52:17
 */
public class PaperDaoImpl extends BaseDao implements PaperDao {

	@Override
	public PageBean<Paper> getPaperLiat(PageBean<Paper> pageBean, Map<String, Object> parameter, int pageIndex) {
		//hql语句
		StringBuffer hql = new StringBuffer();
		hql.append("select paper from Paper paper where 1 = 1");
		//设置参数
		if(parameter.get("csId") != null && (Integer)parameter.get("csId") > 0){
			hql.append(" and paper.csId = :csId");
		}
		if(parameter.get("pType") != null && !"".equals(parameter.get("pType"))){
			hql.append(" and paper.pType = :pType");
		}
		if(parameter.get("pState") != null && !"".equals(parameter.get("pState"))){
			hql.append(" and paper.pState = :pState");
		}
		//获取查询器
		Query query = getSession().createQuery(hql.toString());
		//设置参数
		if(parameter.get("csId") != null && (Integer)parameter.get("csId") > 0){
			query.setString("csId", (String) parameter.get("csId"));
		}
		if(parameter.get("pType") != null && !"".equals(parameter.get("pType"))){
			query.setString("pType", (String) parameter.get("pType"));
		}
		if(parameter.get("pState") != null && !"".equals(parameter.get("pState"))){
			query.setString("pState", (String) parameter.get("pState"));
		}
		//设置总记录数
		int count = query.list().size();
		pageBean.setTotalNumber(count);
		pageBean.setCurrentIndex(pageIndex);
		//当前页数据
		List<Paper> items = (List<Paper>) query.setFirstResult((pageBean.getCurrentIndex()-1)*pageBean.getPageSize())
				.setMaxResults(pageBean.getPageSize())
				.list();
		//设置pageBean的数据集合
		pageBean.setItems(items);
		//执行查询
		return pageBean;
	}

	@Override
	public void startExam(List<PaperClass> paperClasses) {
		// 开始考试
		//开启事务
		Transaction ts = getSession().beginTransaction();
		//打印数据的大小
		System.out.println("数据大小:"+ paperClasses.size());
		
		for(PaperClass paperClass : paperClasses){
			//设置班级与试卷的多对一关系
			Paper paper = (Paper) getSession().get(Paper.class, paperClass.getPid());
			ClassInfo classInfo = (ClassInfo) getSession().get(ClassInfo.class, paperClass.getCcode());
			paperClass.setPaper(paper);
			paperClass.setClassInfo(classInfo);
			//保存数据
			getSession().save(paperClass);
		}
		ts.commit();
	}

	@Override
	public void updateExam(Paper paper, String state) {
		// 考试结束
		//开启事务
		Transaction ts = getSession().beginTransaction();
		//hql语句
		String hql = "update Paper paper set paper.pstate = ? where paper.pid = ?";
		//获取查询器对象
		Query queryUpdate = getSession().createQuery(hql);
		//设置参数(索引为0)
		queryUpdate.setString(0, state);
		queryUpdate.setInteger(1, paper.getPid());
		//执行hql的曾删改调用的是executeUpdate方法；
		queryUpdate.executeUpdate();
		//提交
		ts.commit();
	}

	@Override
	public void createPaperRandom(Paper paper) {
		// 随机组卷
		//开启事务
		Transaction ts = getSession().beginTransaction();
		//执行
		getSession().save(paper);
		//提交事务
		ts.commit();
	}
	

	@Override
	public void createByChoose(Paper paper) {
		
		Transaction ts = getSession().beginTransaction();
		getSession().save(paper);
		ts.commit();
	}
	
	

}
