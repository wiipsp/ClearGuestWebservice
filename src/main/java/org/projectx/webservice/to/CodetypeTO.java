package org.projectx.webservice.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="TB_CODETYPE", uniqueConstraints={})
public class CodetypeTO extends BaseTO {

	private static final long serialVersionUID = 3299126057077733298L;

	@Id
	@GeneratedValue(generator = "codetype")
	@GenericGenerator(name = "codetype", strategy = "uuid") 
	@Column(name="CODETYPE_ID", unique = true, nullable = false, length = 33)  
	private String codetypeId;
	
	@Column(name="CODETYPE_DESC", nullable = true, length = 255)  
	private String codetypeDesc;

	public String getCodetypeId() {
		return codetypeId;
	}

	public void setCodetypeId(String codetypeId) {
		this.codetypeId = codetypeId;
	}

	public String getCodetypeDesc() {
		return codetypeDesc;
	}

	public void setCodetypeDesc(String codetypeDesc) {
		this.codetypeDesc = codetypeDesc;
	}
	
	
}
