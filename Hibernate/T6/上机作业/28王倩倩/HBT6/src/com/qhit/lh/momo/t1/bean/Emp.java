package com.qhit.lh.momo.t1.bean;



/**
 * @author 王倩倩
 *TODO
 *2017年12月18日上午9:37:50
 */
public class Emp  implements java.io.Serializable {


    // Fields    

     private Integer empId;
     private String empName;
     private String empSex;
     private String brithday;
     private String phone;
     private Integer deptId;
     //1--1
     private User user;
     //n--1
     private Dept dept;
     

    // Constructors

    /** default constructor */
    public Emp() {
    }

	/** minimal constructor */
    public Emp(String empName, String empSex, String brithday, String phone) {
        this.empName = empName;
        this.empSex = empSex;
        this.brithday = brithday;
        this.phone = phone;
    }
    
    /** full constructor */
    public Emp(String empName, String empSex, String brithday, String phone, Integer deptId) {
        this.empName = empName;
        this.empSex = empSex;
        this.brithday = brithday;
        this.phone = phone;
        this.deptId = deptId;
    }

   
    // Property accessors

    public Integer getEmpId() {
        return this.empId;
    }
    
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return this.empName;
    }
    
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpSex() {
        return this.empSex;
    }
    
    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public String getBrithday() {
        return this.brithday;
    }
    
    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDeptId() {
        return this.deptId;
    }
    
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "员工编号：" + empId + ", 员工名字：" + empName + ", 员工性别：" + empSex + ", 出生日期：" + brithday
				+ ", 手机号：" + phone + ", 部门id：" + deptId ;
	}
   








}