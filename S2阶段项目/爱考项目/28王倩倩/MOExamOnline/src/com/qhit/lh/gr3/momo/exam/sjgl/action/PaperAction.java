package com.qhit.lh.gr3.momo.exam.sjgl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.ListCellRenderer;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.momo.exam.common.bean.PageBean;
import com.qhit.lh.gr3.momo.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.momo.exam.sjgl.bean.Paper;
import com.qhit.lh.gr3.momo.exam.sjgl.bean.PaperClass;
import com.qhit.lh.gr3.momo.exam.sjgl.service.PaperService;
import com.qhit.lh.gr3.momo.exam.sjgl.service.PaperServiceImpl;
import com.qhit.lh.gr3.momo.exam.tkgl.bean.WrittenQuestion;
import com.qhit.lh.gr3.momo.exam.tkgl.service.QuestionService;
import com.qhit.lh.gr3.momo.exam.tkgl.service.QuestionServiceImpl;
import com.qhit.lh.gr3.momo.exam.tkgl.utils.RandomQuestionsUtils;
/**
 * 
 * @author 王倩倩
 *TODO
 *2018年1月9日上午9:49:02
 */
public class PaperAction extends ActionSupport {
private PaperService paperService = new PaperServiceImpl();
private List<Course> listCourses = new ArrayList<Course>();
private List<Paper> listPapers = new ArrayList<Paper>();
private QuestionService questionService = new QuestionServiceImpl();
//试题列表分页数据
private PageBean<Paper> pageBean = new PageBean<Paper>();
//指定页初始化为一
private int pageIndex = 1;
//条件参数
private Course course;
private Paper paper;
private int radioEasy,radioNormal,radioDiff,cbNormal,cbDiff;
private List<WrittenQuestion> listRE,listRN,listRD,listCE,listCN,listCD;
//选题集合
private String qids;
//开始考试的班级集合
private List<PaperClass> paperClass = new ArrayList<PaperClass>();

/**
 * 
 * @return
 * 获取试卷列表
 */

public String getPaperList(){
	//设置参数
	Map<String ,Object> parameter = new HashMap<String, Object>();
	System.out.println("hahahah"+parameter);
	if(course != null){
		parameter.put("csId", course.getCsId());
	}
	if(paper != null){
		parameter.put("pType", paper.getPtype());
		parameter.put("pState", paper.getPstate());
	}
	//查询题库列表数据
	pageBean =  paperService.getPaperLiat(pageBean, parameter, pageIndex);
	System.out.println(pageBean.getItems().size());
	System.out.println(pageBean);
	return "listPaper";
		
}
/**
* @return
* 随机组卷
*/
public String createByRandom(){
//1，查询所有类型的试题（随机的所有类型的）
		System.out.println("1,查询所有的类型的试题");
		listRE = questionService.getQuestionsByType(course.getCsId(), "单选", "简单");
		listRN = questionService.getQuestionsByType(course.getCsId(), "单选", "一般");
		listRD = questionService.getQuestionsByType(course.getCsId(), "单选", "困难");
		listCE = questionService.getQuestionsByType(course.getCsId(), "多选", "简单");
		listCN = questionService.getQuestionsByType(course.getCsId(), "多选", "一般");
		listCD = questionService.getQuestionsByType(course.getCsId(), "多选", "困难");
//2，随机获取试题集合
		System.out.println("2,随机获取试题集合");
		Set<WrittenQuestion> listQuestions = RandomQuestionsUtils.randomAllQuestions
				(listRE, listRN, listRD, listCD, listCN, listCD, 
						radioEasy,radioNormal,radioDiff,cbNormal,cbDiff);
		System.out.println("试题数量：" + listQuestions.size());
//3，设置试题和试卷的关系
		System.out.println("3，设置试题和试卷的关系");
		paper.setWrittenQuestions(listQuestions);
		
//4,设置课程添加关系
		paper.setCsId(course.getCsId());
		paper.setCourse(course);
//5,添加试卷
		System.out.println("4,添加试卷");
		paperService.createPaperRandom(paper);
	return "createRandom";
}


/**
 * @return
 * 结束考试
 */
public String endExam(){
	paperService.endExam(paper);
	return "endExam";
}

/**
 * @return
 * 开始考试
 */
public String startExam(){
	paperService.startExam(paperClass, paper);
	return "startExam";
}


/**
 * @return
 * 选题组卷
 */
public String createByChoose() {
	//设置试卷课程的关系
	paper.setCourse(course);
	//从session中获取已选试题集合
	String[] strs = qids.split(",");
	Set<String> setQs = new HashSet<>();
	for(int i=0;i<strs.length;i++) {
		if(strs[i] != null && strs[i] != "") {
			setQs.add(strs[i]);
		}
	}
	Set<WrittenQuestion> questions = new HashSet<>();
	for (String qid : setQs) {
		WrittenQuestion writtenQuestion = new WrittenQuestion();
		writtenQuestion.setQid(Integer.valueOf(qid));
		questions.add(writtenQuestion);
	}
	//设置试卷和试题集合的关系
	paper.setWrittenQuestions(questions);
	//创建试卷
	paperService.createByChoose(paper);
	
	return "createChoose";
}
	
	
	
	
	
	
	
	
	public List<Course> getListCourses() {
		return listCourses;
	}
	public void setListCourses(List<Course> listCourses) {
		this.listCourses = listCourses;
	}
	public List<Paper> getListPapers() {
		return listPapers;
	}
	public void setListPapers(List<Paper> listPapers) {
		this.listPapers = listPapers;
	}
	public PageBean<Paper> getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean<Paper> pageBean) {
		this.pageBean = pageBean;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	public PaperService getPaperService() {
		return paperService;
	}
	public void setPaperService(PaperService paperService) {
		this.paperService = paperService;
	}
	public QuestionService getQuestionService() {
		return questionService;
	}
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}
	public int getRadioEasy() {
		return radioEasy;
	}
	public void setRadioEasy(int radioEasy) {
		this.radioEasy = radioEasy;
	}
	public int getRadioNormal() {
		return radioNormal;
	}
	public void setRadioNormal(int radioNormal) {
		this.radioNormal = radioNormal;
	}
	public int getRadioDiff() {
		return radioDiff;
	}
	public void setRadioDiff(int radioDiff) {
		this.radioDiff = radioDiff;
	}
	public int getCbNormal() {
		return cbNormal;
	}
	public void setCbNormal(int cbNormal) {
		this.cbNormal = cbNormal;
	}
	public int getCbDiff() {
		return cbDiff;
	}
	public void setCbDiff(int cbDiff) {
		this.cbDiff = cbDiff;
	}
	public List<WrittenQuestion> getListRE() {
		return listRE;
	}
	public void setListRE(List<WrittenQuestion> listRE) {
		this.listRE = listRE;
	}
	public List<WrittenQuestion> getListRN() {
		return listRN;
	}
	public void setListRN(List<WrittenQuestion> listRN) {
		this.listRN = listRN;
	}
	public List<WrittenQuestion> getListRD() {
		return listRD;
	}
	public void setListRD(List<WrittenQuestion> listRD) {
		this.listRD = listRD;
	}
	public List<WrittenQuestion> getListCE() {
		return listCE;
	}
	public void setListCE(List<WrittenQuestion> listCE) {
		this.listCE = listCE;
	}
	public List<WrittenQuestion> getListCN() {
		return listCN;
	}
	public void setListCN(List<WrittenQuestion> listCN) {
		this.listCN = listCN;
	}
	public List<WrittenQuestion> getListCD() {
		return listCD;
	}
	public void setListCD(List<WrittenQuestion> listCD) {
		this.listCD = listCD;
	}
	public String getQids() {
		return qids;
	}
	public void setQids(String qids) {
		this.qids = qids;
	}
	public List<PaperClass> getPaperClass() {
		return paperClass;
	}
	public void setPaperClass(List<PaperClass> paperClass) {
		this.paperClass = paperClass;
	}


}
