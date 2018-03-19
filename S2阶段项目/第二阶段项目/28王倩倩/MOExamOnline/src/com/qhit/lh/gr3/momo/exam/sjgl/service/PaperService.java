package com.qhit.lh.gr3.momo.exam.sjgl.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.momo.exam.common.bean.PageBean;
import com.qhit.lh.gr3.momo.exam.sjgl.bean.Paper;
import com.qhit.lh.gr3.momo.exam.sjgl.bean.PaperClass;

/**
 * 
 * @author 王倩倩
 *TODO
 *2018年1月9日上午9:52:11
 */
public interface PaperService {
	/**
	 * 
	 * @param pageBean
	 * @param parameter
	 * @param pageIndex
	 * @return
	 * 查询试卷列表
	 * 
	 */
public PageBean<Paper> getPaperLiat(PageBean<Paper> pageBean, Map<String ,Object> parameter,int pageIndex );

/**
* 开始考试
* @param paperClass
*/
public void startExam(List<PaperClass> paperClasses,Paper paper);

/**
* 
* @param paper
* @param state
* 结束考试（更新试卷和考试状态）
*/
//public void updateExam(Paper paper, String state);

/**
* 
* @param paper
* 随机组卷
*/
public void createPaperRandom(Paper paper);
/**
 * 创建选择
 * @param paper
 */
public void createByChoose(Paper paper);

/**
 * 结束考试
 * @param paper
 */
public void endExam(Paper paper);


}
