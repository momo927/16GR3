package com.qhit.lh.momo.t1.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 王倩倩
 *TODO
 *2017年12月20日上午10:04:01
 */
public class Role {
      private int roleId;
      private String roleName;
      private String memo;
      //
      private Set<User> users = new HashSet<User>(0);
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(int roleId, String roleName, String memo) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.memo = memo;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "角色编号：" + roleId + ", 角色名称：" + roleName + ",描述：" + memo;
	}
      
}
