package org.projectx.webservice.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="TB_USER_ROLE", uniqueConstraints={})
public class UserRoleTO extends BaseTO {
	private static final long serialVersionUID = 3462254823944853911L;

	@Id
	@GeneratedValue(generator = "userRole")
	@GenericGenerator(name = "userRole", strategy = "uuid") 
	@Column(name="USER_ROLE_ID", unique = true, nullable = false, length = 33)  
	private String userRoleID;
	
	@ManyToOne()
    @JoinColumn(name="USER_ID") 
	private UserTO userTO;
	
	@ManyToOne()
    @JoinColumn(name="ROLE_ID") 
	private RoleTO roleTO;


	public String getUserRoleID() {
		return userRoleID;
	}

	public void setUserRoleID(String userRoleID) {
		this.userRoleID = userRoleID;
	}

	public UserTO getUserTO() {
		return userTO;
	}

	public void setUserTO(UserTO userTO) {
		this.userTO = userTO;
	}

	public RoleTO getRoleTO() {
		return roleTO;
	}

	public void setRoleTO(RoleTO roleTO) {
		this.roleTO = roleTO;
	}
	
	
}
