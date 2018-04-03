package com.qhit.lh.gr3.momo.exam.sjgl.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.momo.exam.common.bean.PageBean;
import com.qhit.lh.gr3.momo.exam.sjgl.bean.Paper;
import com.qhit.lh.gr3.momo.exam.sjgl.bean.PaperClass;
import com.qhit.lh.gr3.momo.exam.sjgl.dao.PaperDao;
import com.qhit.lh.gr3.momo.exam.sjgl.dao.PaperDaoImpl;

/**
 * 
 * @author 王倩倩
 *TODO
 *2018年1月9日上午9:52:05
 */
public class PaperServiceImpl implements PaperService {
private PaperDao paperDao = new PaperDaoImpl();
	@Override
	public PageBean<Paper> getPaperLiat(PageBean<Paper> pageBean, Map<String, Object> parameter, int pageIndex) {
	
		return paperDao.getPaperLiat(pageBean, parameter, pageIndex);
	}
	
	
	@Override
	public void startExam(List<PaperClass> paperClasses,Paper paper) {
		paperDao.startExam(paperClasses);
		paperDao.updateExam(paper, "考试中");
		
	}
	@Override
	public void createPaperRandom(Paper paper) {
		paperDao.createPaperRandom(paper);
		
	}

	@Override
	public void createByChoose(Paper paper) {
		paperDao.createByChoose(paper);
		
	}

	@Override
	public void endExam(Paper paper) {
		paperDao.updateExam(paper, "考试结束");
		
	}

}
