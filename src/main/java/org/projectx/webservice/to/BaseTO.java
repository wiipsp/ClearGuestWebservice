package org.projectx.webservice.to;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.JOINED)
public class BaseTO implements Serializable{
	private static final long serialVersionUID = 6357663834393139105L;
	
	
	public BaseTO() {
	}
	
	@Column(name = "IS_DELETED", nullable = false, length = 1)
	private String isDeleted;
	
	@Column(name = "CREATE_BY", nullable = false, length = 15)
	private String createBy;
	
	@Column(name = "CREATE_DT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDt;
	
	@Column(name = "UPDATE_BY", nullable = false, length = 15)
	private String updateBy;
	
	@Column(name = "UPDATE_DT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDt;
	
	@Column(name = "VERSION_NO", nullable = false)
	private int versionNo;

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public int getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}
	
	
}
