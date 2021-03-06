package com.qhit.lh.momo.t1.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Dept entity. @author MyEclipse Persistence Tools
 */

public class Dept  implements java.io.Serializable {


    // Fields    

     private Integer deptId;
     private String deptName;
     private String address;
     //一对多·
     private Set<Emp> emps = new HashSet<Emp>();


    // Constructors

    /** default constructor */
    public Dept() {
    }

    
    /** full constructor */
    public Dept(String deptName, String address) {
        this.deptName = deptName;
        this.address = address;
    }

   
    // Property accessors

    public Integer getDeptId() {
        return this.deptId;
    }
    
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return this.deptName;
    }
    
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }


	

	public Set<Emp> getEmps() {
		return emps;
	}


	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}


	@Override
	public String toString() {
		return "部门id：" + deptId + ", 部门名字：" + deptName + ", 部门地址：" + address;
	}
   








}