package com.qhit.lh.momo.t1.bean;

/**
 * @author 王倩倩
 *TODO
 *2017年12月18日上午9:35:34
 */
public class User  implements java.io.Serializable {


    // Fields    

     private Integer userId;
     private String userName;
     private String password;
     
     //1--1
     private Emp emp;


    // Constructors

    /** default constructor */
    public User() {
    }

    
    /** full constructor */
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

   
    public User(Integer userId, String userName, String password, Emp emp) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.emp = emp;
	}


	// Property accessors

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }


	public Emp getEmp() {
		return emp;
	}


	public void setEmp(Emp emp) {
		this.emp = emp;
	}


	@Override
	public String toString() {
		return "用户id：" + userId + ", 用户名字：" + userName + ", 密码：" + password ;
	}
   








}