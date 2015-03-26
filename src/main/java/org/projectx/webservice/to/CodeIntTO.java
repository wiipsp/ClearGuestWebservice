package org.projectx.webservice.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="TB_CODE_INT", uniqueConstraints={@UniqueConstraint(columnNames={"CODETYPE_ID", "CODE_ID"})})
public class CodeIntTO extends BaseTO {
	
	private static final long serialVersionUID = 4702081922831470328L;

	@Id
	@GeneratedValue(generator = "codeInt")
	@GenericGenerator(name = "codeInt", strategy = "uuid") 
	@Column(name="CODE_INT_ID", unique = true, nullable = false, length = 33)
	private String codeIntId;
	
	@ManyToOne()
    @JoinColumn(name="CODETYPE_ID")
	private CodetypeTO codetypeTO;
	
	@Column(name="CODE_ID", nullable = false, length = 33)
	private String codeId;
	
	@Column(name="CODE_DESC",length = 255)
	private String codeDesc;
	
	@Column(name="CODE_SEQ")
	private int codeSeq;

	public String getCodeIntId() {
		return codeIntId;
	}

	public void setCodeIntId(String codeIntId) {
		this.codeIntId = codeIntId;
	}

	public CodetypeTO getCodetypeTO() {
		return codetypeTO;
	}

	public void setCodetypeTO(CodetypeTO codetypeTO) {
		this.codetypeTO = codetypeTO;
	}

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}

	public int getCodeSeq() {
		return codeSeq;
	}

	public void setCodeSeq(int codeSeq) {
		this.codeSeq = codeSeq;
	}
	
}
