package com.qhit.lh.gr3.momo.exam.tkgl.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.momo.exam.common.bean.PageBean;
import com.qhit.lh.gr3.momo.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.momo.exam.tkgl.bean.WrittenQuestion;
import com.qhit.lh.gr3.momo.exam.tkgl.service.QuestionService;
import com.qhit.lh.gr3.momo.exam.tkgl.service.QuestionServiceImpl;
import com.qhit.lh.gr3.momo.exam.tkgl.utils.PoiReaderExcel;

/**
 * 
 * @author 王倩倩
 *TODO
 *2018年1月2日下午8:10:15
 */
public class QuestionAction extends ActionSupport {
   private QuestionService questionService = new QuestionServiceImpl();
		  private Course course;//科目
		  private String major;//专业
		  private String stage;//阶段
		  private List<Course> listCourse = new ArrayList<Course>();
		  //笔试题对象
		  private WrittenQuestion writtenQuestion;
		  //试题列表分页数据
		  private PageBean<WrittenQuestion> pageBean = new PageBean<>();
		  //指定页,初始化为1
		  private int pageIndex = 1;       
		  //导入试题集合
		  private List<WrittenQuestion> listWQuestions = new ArrayList<>();
		  //导入文件对象
		  private File questionfile;
		  
		  private int radioEasyMax,radioNormalMax,radioDiffMax,cbEasyMax,cbNormalMax,cbDiffMax;
		  
    public String getCourseInfo(){
    	//设置参数
    	//1.声明一个参数集合
    	Map<String, String> parameters = new HashMap<String, String>();
    	//2.判断专业阶段不为空
    	if(major != null && !"".equals(major)){
    		//major不为空放入参数集合中
    		parameters.put("major", major);
    	}
    	if(stage != null && !"".equals(stage)){
    		parameters.put("stage", stage);
    	}
    	//3.查询题库列表数据（从服务类中获取 集合接收）
    	listCourse = questionService.getCourseInfo(parameters);
    	//4.打印出数据长度
    	System.out.println(listCourse.size());
    	//5.返回数据集合
		return "listCourse";
    }
    
    public String getQuestionMax(){
    	radioEasyMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "单选", "简单");
		radioNormalMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "单选", "一般");
		radioDiffMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "单选", "困难");
		cbEasyMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "多选", "简单");
		cbNormalMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "多选", "一般");
		cbDiffMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "多选", "困难");
		
		return "getQuestionMax";
	}
    /**
     * 
     * @return
     * 获取试题列表
     */
    public String getWrittenList(){
    	pageBean = questionService.getWrittenList(pageBean, course, pageIndex);
    	System.out.println("数据大小："+pageBean.getItems().size());
		return "listWritten";
    	
    }
    /**
     * 
     * @return
     * 添加笔试题
     */
    public String addWrittenQuestion(){
    	//打印试题题目数
    	System.out.println(writtenQuestion.getCsId());
    	//设置课程试题的关联
    	writtenQuestion.setCourse(course);
    	questionService.addWrittenQuestion(writtenQuestion);
		return "addWrittenQuestion";
    	
    }
    /**
     * 
     * @return
     * 根据试题编号查询试题
     */
    public String getWrittenQuestionById(){
    	writtenQuestion = questionService.getWrittenQuestionById(writtenQuestion);
		return "getWrittenQuestionById";
    	
    }
    /**
     * 
     * @return
     * 更新数据
     */
    public String updateWrittenQuestion(){
    	//设置关联
    	writtenQuestion.setCourse(course);
    	questionService.updateWrittenQuestion(writtenQuestion);
		return "updateWrittenQuestion";
    	
    }
    /**
     * 
     * @return
     * 批量导入笔试题
     * @throws FileNotFoundException 
     * 
     */
    public String inportWrittenQuestions() throws FileNotFoundException{
    	//上传文件（用Struts2）
    	if(questionfile != null){
    		//1.(通过输入流)上传到服务器
    		FileInputStream is = new FileInputStream(questionfile);
    		//2.读取excel文件中的数据,获取试题对象集合（poi）需要导入POI包
    		listWQuestions = PoiReaderExcel.readerExcel(is, course);
    		//3.批量添加到数据库（用hibernate）
    		questionService.inportWrittenQuestions(listWQuestions);
    	}else{
    		//上传文件失败，不做
    		System.out.println("123456789失败");
    	}
		return "inportWrittenQuestions";
    	
    }
    
    
    
    
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public List<Course> getListCourse() {
		return listCourse;
	}

	public void setListCourse(List<Course> listCourse) {
		this.listCourse = listCourse;
	}
	public WrittenQuestion getWrittenQuestion() {
		return writtenQuestion;
	}
	public void setWrittenQuestion(WrittenQuestion writtenQuestion) {
		this.writtenQuestion = writtenQuestion;
	}
	public PageBean<WrittenQuestion> getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean<WrittenQuestion> pageBean) {
		this.pageBean = pageBean;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public List<WrittenQuestion> getListWQuestions() {
		return listWQuestions;
	}
	public void setListWQuestions(List<WrittenQuestion> listWQuestions) {
		this.listWQuestions = listWQuestions;
	}
	public File getQuestionfile() {
		return questionfile;
	}
	public void setQuestionfile(File questionfile) {
		this.questionfile = questionfile;
	}

	
		  
}
