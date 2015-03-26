package org.projectx.webservice.to;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="TB_CLEARGUEST_PWD", uniqueConstraints={})
public class ClearGuestPwdTO extends BaseTO {

	private static final long serialVersionUID = -979503764718059229L;

	@Id
	@GeneratedValue(generator = "clearGuestPwd")    
	@GenericGenerator(name = "clearGuestPwd", strategy = "uuid")   
	@Column(name="CLEARGUEST_PWD_ID", unique = true, nullable = false, length = 33)  
	private String clearGuestPwdId;
	
	@Column(name="PASSWORD", nullable = false, length = 30)  
	private String password;
	
	@Column(name="CLEARGUEST_DATE", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date clearGuestDate;

	public String getClearGuestPwdId() {
		return clearGuestPwdId;
	}

	public void setClearGuestPwdId(String clearGuestPwdId) {
		this.clearGuestPwdId = clearGuestPwdId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getClearGuestDate() {
		return clearGuestDate;
	}

	public void setClearGuestDate(Date clearGuestDate) {
		this.clearGuestDate = clearGuestDate;
	}
	
}
