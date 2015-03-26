package org.projectx.webservice.util.page;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class PageRowTag extends BodyTagSupport{
	private static final long serialVersionUID = 5913431038994741228L;
	private String leftHtml;
	private String rightHtml;
	private String id;
	private String column;
	private String style;
	
	private List<Map<String, String>> rowMap = new ArrayList<Map<String, String>>();

	@Override
	public int doStartTag() throws JspException {
		PageTableTag  pageTableTag = (PageTableTag)this.getParent().getParent();
//		rowMap = pageTableTag.getRowMap();
//		Map<String, String> row = new HashMap<String, String>();
//		row.put("leftHtml", StringUtil.returnEmptyWhenStrIsEmpty(leftHtml));
//		row.put("rightHtml", StringUtil.returnEmptyWhenStrIsEmpty(rightHtml));
//		row.put("id", id);
//		row.put("column", column);
//		row.put("style", style);
//		rowMap.add(row);
		return EVAL_BODY_AGAIN;
	}
	
//	@Override
//	public int doEndTag() throws JspException {
//		return SKIP_BODY;
//	}

	public String getLeftHtml() {
		return leftHtml;
	}

	public void setLeftHtml(String leftHtml) {
		this.leftHtml = leftHtml;
	}

	public String getRightHtml() {
		return rightHtml;
	}

	public void setRightHtml(String rightHtml) {
		this.rightHtml = rightHtml;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public List<Map<String, String>> getRowMap() {
		return rowMap;
	}

	public void setRowMap(List<Map<String, String>> rowMap) {
		this.rowMap = rowMap;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}
