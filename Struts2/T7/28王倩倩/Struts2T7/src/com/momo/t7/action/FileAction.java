package com.momo.t7.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.coyote.http11.OutputFilter;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
  /**
   * 
   * @author 王倩倩
   *TODO
   *2017年12月6日上午8:53:34
   */
public class FileAction extends ActionSupport {
	private String username; 		 //用户名
	private File uploadFile;  		 //上传的文件
	private String userremark;			//备注
	private String uploadFileFileName;   //上传文件的文件名
	private String uploadFileContentType;//上传文件类型
	
	 /**
	  * 
	  * @return
	  * 处理上传的业务
	  *   
	  */
		public String upload(){
			//判断上传文件是否为空
			if(uploadFile != null){
			
				try {
					//输入流读取上传文件
					InputStream is = new FileInputStream(uploadFile);
					//上传之前创建保存的文件夹
					String savePath = ServletActionContext.getServletContext().getRealPath("/")+"upload";    
					File file = new File(savePath);
					//判断文件夹是否存在
					if(!file.exists()){//如果文件不存在
						//重建新的子目录
						file.mkdirs();
					}
					//写，输出流输出文件
					OutputStream os = new FileOutputStream(savePath+"/"+uploadFileFileName);
					byte[] buffer = new byte[8096];
					//声明一个长度
					int len = 0;
					//如果读取的上传数据不等于0
					while((len = is.read(buffer)) != -1){
						//???
						os.write(buffer, 0, len);
						
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					super.addFieldError("uploadFile", "文件未找到!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					super.addFieldError("uploadFile", "文件未找到!");
				}
			}else{
				//文件没找到
				super.addFieldError("uploadFile", "文件未找到!");
			}
			
			return "uploadSuccess";
			
		}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getUserremark() {
		return userremark;
	}

	public void setUserremark(String userremark) {
		this.userremark = userremark;
	}
	
}
	
	

