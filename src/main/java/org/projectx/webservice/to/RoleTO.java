package org.projectx.webservice.to;

public class RoleTO extends BaseTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2966632093942177582L;

	private String roleId;
	private String roleName;
	private String roleDesc;
	private String promotionId;
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
	public String getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}

}
