package org.projectx.webservice.util.page;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.projectx.webservice.util.StringUtil;



public class PageColumnTag extends BodyTagSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4137753346831608548L;
	
	private String sortColumn;
	private String displayName;
	private String style;
	private String width;
	
	private List<Map<String, String>> columnMap = new ArrayList<Map<String, String>>();
	
//	@Override
//	public int doAfterBody() throws JspException {
//		PageTableTag pageTableTag = (PageTableTag) this.getParent();
//		this.columnMap = pageTableTag.getColumnMap();
//		BodyContent bodyContent = getBodyContent();
//		String body = bodyContent.getString();
//		String aferBody = convertTOJSType(body);
//		Map<String, String> column = new HashMap<String, String>();
//		column.put("sortColumn", sortColumn);
//		column.put("displayName", displayName);
//		column.put("width", width);
//		column.put("style", StringUtil.returnEmptyWhenStrIsEmpty(style));
//		column.put("tdBody", aferBody);
//		columnMap.add(column);
//		return SKIP_BODY;
//	}
	
	private String convertTOJSType(String html){
		StringBuffer sb;
		html = html.replaceAll("\"", "'").replaceAll("\n", "").replaceAll("\t", "").replaceAll("&nbsp", "");
		while(html.indexOf("@{") != -1){
			sb = new StringBuffer();
			sb.append(html.substring(0,html.indexOf("@{")))
				.append("\" + ")
				.append(html.substring(html.indexOf("@{") + 2,html.indexOf("}",html.indexOf("@{"))))
				.append(" + \"")
				.append(html.substring(html.indexOf("}",html.indexOf("@{")) + 1));
			html = sb.toString();
		}
		return html;
	}

	@Override
	public int doEndTag() {
		PageTableTag pageTableTag = (PageTableTag) this.getParent();
		this.columnMap = pageTableTag.getColumnMap();
		BodyContent bodyContent = getBodyContent();
		String aferBody = "";
		if(bodyContent != null){
			String body = bodyContent.getString();
			aferBody = convertTOJSType(body);
		}
		Map<String, String> column = new HashMap<String, String>();
		column.put("sortColumn", sortColumn);
		column.put("displayName", displayName);
		column.put("width", width);
		column.put("style", StringUtil.returnEmptyWhenStrIsEmpty(style));
		column.put("tdBody", aferBody);
		columnMap.add(column);
		return EVAL_BODY_AGAIN;
	}

	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public List<Map<String, String>> getColumnMap() {
		return columnMap;
	}

	public void setColumnMap(List<Map<String, String>> columnMap) {
		this.columnMap = columnMap;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

}
