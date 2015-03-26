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
@Table(name="TB_USER", uniqueConstraints={})
public class UserTO extends BaseTO {

	private static final long serialVersionUID = -7777513375969317954L;
	
	@Id
	@GeneratedValue(generator = "user")
	@GenericGenerator(name = "user", strategy = "uuid") 
	@Column(name="USER_ID", unique = true, nullable = false, length = 33)  
	private String userId;
	
	@Column(name = "USER_NAME", unique = true, nullable = false, length = 32)
	private String userName;
	
	@Column(name = "USER_ALIAS", nullable = false, length = 32)
	private String userAlias;
	
	@Column(name = "USER_PWD", nullable = false, length = 255)
	private String userPwd;
	
	@Column(name = "WECHAT_ID", length = 30)
	private String wechatId;
	
	@Column(name = "WECHAT_NAME", length = 32)
	private String wechatName;
	
	@Column(name = "QQ_NUMBER", length = 12)
	private String qqNumber;
	
	@Column(name = "SEX", length = 1)
	private String sex;
	
	@Column(name = "BIRTH_DT")
	@Temporal(TemporalType.DATE)
	private Date birthDt;
	
	@Column(name = "PHONE_NO", length = 15)
	private String phoneNo;
	
	@Column(name = "EMAIL", length = 255)
	private String email;
	
	@Column(name = "IS_INFORM", length = 1)
	private String isInform;
	
	@Column(name = "TRAVEL_DEST", length = 1000)
	private String travelDest;
	
	@Column(name = "MUSICIAN", length = 1000)
	private String musician;
	
	@Column(name = "MOVIES", length = 1000)
	private String movies;
	
	public UserTO() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getWechatId() {
		return wechatId;
	}

	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}

	public String getWechatName() {
		return wechatName;
	}

	public void setWechatName(String wechatName) {
		this.wechatName = wechatName;
	}

	public String getQqNumber() {
		return qqNumber;
	}

	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthDt() {
		return birthDt;
	}

	public void setBirthDt(Date birthDt) {
		this.birthDt = birthDt;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsInform() {
		return isInform;
	}

	public void setIsInform(String isInform) {
		this.isInform = isInform;
	}

	public String getTravelDest() {
		return travelDest;
	}

	public void setTravelDest(String travelDest) {
		this.travelDest = travelDest;
	}

	public String getMusician() {
		return musician;
	}

	public void setMusician(String musician) {
		this.musician = musician;
	}

	public String getMovies() {
		return movies;
	}

	public void setMovies(String movies) {
		this.movies = movies;
	}
	
}
