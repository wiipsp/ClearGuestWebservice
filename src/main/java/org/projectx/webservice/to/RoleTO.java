package org.projectx.webservice.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="TB_ROLE", uniqueConstraints={})
public class RoleTO extends BaseTO{

	private static final long serialVersionUID = 2966632093942177582L;

	@Id
	@GeneratedValue(generator = "role")
	@GenericGenerator(name = "role", strategy = "uuid") 
	@Column(name="ROLE_ID", unique = true, nullable = false, length = 33)  
	private String roleId;
	
	@Column(name = "ROLE_NAME", nullable = false, length = 32)
	private String roleName;
	
	@Column(name = "ROLE_DESC", nullable = true, length = 255)
	private String roleDesc;
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

}
