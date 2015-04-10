package org.projectx.webservice.util.page;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.projectx.webservice.util.JSONUtil;
import org.projectx.webservice.util.StringUtil;
import org.projectx.webservice.util.TagUtil;

public class PageTableTag extends BodyTagSupport{
	private static final long serialVersionUID = -4599673312748367438L;

	private Page pageModel;
	private String id;
	private String tableClass;
	private String headerClass;
	private String rowClass;
	private String contextPath;
	private String cellpadding;
	private String cellspacing;
	private String action;
	private String width;
	private String indexId;
	private String var;
	private List<Map<String, String>> columnMap = new ArrayList<Map<String, String>>();
//	private List<Map<String, String>> rowMap = new ArrayList<Map<String, String>>();

	@Override
	public int doStartTag() throws JspException {
		columnMap = new ArrayList<Map<String, String>>();
//		rowMap = new ArrayList<Map<String, String>>();
		StringBuilder content = new StringBuilder("\t\n");
		content.append("<table " + (StringUtil.isNullOrEmpty(cellpadding)? "" : ( "cellpadding='" + cellpadding + "'")) + (StringUtil.isNullOrEmpty(cellspacing)? "" : ( " cellspacing='" + cellspacing + "'")) + 
				(StringUtil.isNullOrEmpty(width)? "" : ( " width='" + width + "'")) + " class='");
		if(StringUtil.isNullOrBlank(tableClass)){
			content.append("pageTable");
		}else{
			content.append(tableClass);
		}
		content.append("' id='" + id + "'><tbody></tbody></table>");
		try {
			TagUtil.getInstance().write(this.pageContext.getOut(), content.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_AGAIN;
	}

	@Override
	public int doEndTag() throws JspException {
		StringBuilder content = new StringBuilder("\t\n");
		content.append("<script language=\"javascript\">\n")
			    .append("$(document).ready(function(){\n")
			    .append("var page = new Page('" + id + "', '" + action + "', " + JSONUtil.toJSON(pageModel) + ", '" + contextPath + "');\n")
			    .append("page.myPageCreatePageTitle = function(){\n\t")
			    .append("var pageObj = this;\n\t")
			    .append("var tr = $(\"<tr></tr>\");\n\t");
		content.append("var sortImgAsc = \"<img class='imgUrl' src='\"+this.contentPath+\"/images/asc.gif' alt='Asc' title='Asc'/>\";\n\t")
			    .append("var sortImgDesc = \"<img class='imgUrl' src='\"+this.contentPath+\"/images/desc.gif' alt='Desc' title='Desc'/>\";\n\t");
		int i = 0;
		for(Map<String, String> title : columnMap){
			content.append("var td" + i + " = $(\"<td" + (StringUtil.isNullOrEmpty(title.get("style"))? "" : (" style='" + title.get("style") + "'")) + 
					(StringUtil.isNullOrEmpty(title.get("width"))? "" : (" width='" + title.get("width") + "'")) + " class='");
		if(StringUtil.isNullOrEmpty(headerClass)){
			content.append("pageTitleRow'></td>\");\n\t");
		}else{
			content.append(headerClass+"'></td>\");\n\t");
		}
			if(StringUtil.isNullOrEmpty(title.get("sortColumn"))){
				content.append("var head" + i + " = $('<span>" + title.get("displayName") + "</span>');\n\t")
						.append("td" + i + ".append(head" + i + ");\n\t")
						.append("tr.append(td" + i + ");\n\t");
			}else{
				content.append("var head" + i + " = $(\"<span><u>" + title.get("displayName") + "</u></span>\").click(\n\t")
			    .append("function() {\n\t\t")
			    .append("pageObj.method = 0;\n\t\t")
			    .append("if(pageObj.page.indexColumn != '" + title.get("sortColumn") + "'){\n\t\t\t")
			    .append("pageObj.page.indexColumn = '" + title.get("sortColumn") + "';\n\t\t\t")
			    .append("pageObj.page.sortType = 'ASC';\n\t\t")
			    .append("}else{\n\t\t\t")
			    .append("pageObj.page.indexColumn = '" + title.get("sortColumn") + "';\n\t\t\t")
			    .append("if(pageObj.page.sortType == 'DESC'){\n\t\t\t\t")
			    .append("pageObj.page.sortType = 'ASC';\n\t\t\t")
			    .append("}else{\n\t\t\t\t")
			    .append("pageObj.page.sortType = 'DESC';\n\t\t\t")
			    .append("}\n\t\t")
			    .append("}\n\t\t")
			    .append("pageObj.showPage();\n\t")
			    .append("}).mouseover(function() {\n\t\t")
			    .append("$(this).addClass('pageSort');\n\t")
			    .append("}).mouseout(function() {\n\t\t")
			    .append("$(this).removeClass('pageSort');\n\t")
			    .append("}).data('column', '" + title.get("sortColumn") + "');\n\t")
			    .append("td" + i + ".append(head" + i + ");\n\t")
				.append("tr.append(td" + i + ");\n\t");
			}
			i++;
		}
		content.append("if(pageObj.page.sortType == 'DESC'){\n\t\t")
				.append("tr.find('span').filter(function (index) {\n\t\t\t")
				.append("return $(this).data('column') == pageObj.page.indexColumn;\n\t\t")
				.append("}).append(sortImgDesc);\n\t")
				.append("}else{\n\t\t")
				.append("tr.find('span').filter(function (index) {\n\t\t\t")
				.append("return $(this).data('column') == pageObj.page.indexColumn;\n\t\t")
				.append("}).append(sortImgAsc);\n\t")
				.append("}\n\t")
				.append("return tr;\n")
				.append("};\n\t")
				.append("\n")
				.append("page.myPageCreateTableData = function(content){\n\t")
				.append("var tdStr = \"\";\n\t")
				.append("var tableBody = new Array();\n\t")
				.append("if(content.length == 0){\n\t\t")
				.append("tdStr += \"<td colspan='" + columnMap.size() + "'" + (StringUtil.isNullOrEmpty(rowClass)? " class='rowData'" : (" class='" + rowClass + "'")) + ">" + 
						"No records found.&nbsp;" + "</td>\";\n\t\t")
				.append("tableBody[0] = '<tr>' + tdStr + '</tr>';\n\t")
				.append("}\n\t")
				.append("var " + var + ";\n\t")
				.append("var " + (StringUtil.isNullOrEmpty(indexId)? "indexId" : indexId) + ";\n\t")
				.append("for ( var i = 0; i < content.length; i++) {\n\t\t")
				.append((StringUtil.isNullOrEmpty(indexId)? "indexId" : indexId) + " = parseInt(i + 1) ;\n\t\t")
				.append(var + " = content[i] ;\n\t\t")
				.append("tdStr='';\n\t\t");
		for(Map<String, String> columnBody : columnMap){
			
			if(StringUtil.isNullOrEmpty(columnBody.get("tdBody").trim())){
				content.append("tdStr += \"<td>&nbsp;</td>\";\n\t\t");
			}else{
				content.append("tdStr += \"" + columnBody.get("tdBody") + "\";\n\t\t");
			}
		}
		content.append("tableBody[i] = '<tr>' + tdStr + '</tr>';\n\t")
				.append("}\n\t")
				.append("var str = $(tableBody.join(''));\n\t")
				.append("str.find(\"td\").addClass(\"" + (StringUtil.isNullOrEmpty(rowClass)? "rowData" : rowClass) + "\");\n\t")
				.append("return str;\n")
				.append("};\n")
				.append("page.showPage();\n")
			    .append("});\n")
			    .append(" </script> \t\n");
		try {
			TagUtil.getInstance().write(this.pageContext.getOut(), content.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	public Page getPageModel() {
		return pageModel;
	}

	public void setPageModel(Page pageModel) {
		this.pageModel = pageModel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List<Map<String, String>> getColumnMap() {
		return columnMap;
	}

	public void setColumnMap(List<Map<String, String>> columnMap) {
		this.columnMap = columnMap;
	}

//	public List<Map<String, String>> getRowMap() {
//		return rowMap;
//	}
//
//	public void setRowMap(List<Map<String, String>> rowMap) {
//		this.rowMap = rowMap;
//	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getTableClass() {
		return tableClass;
	}

	public void setTableClass(String tableClass) {
		this.tableClass = tableClass;
	}

	public String getHeaderClass() {
		return headerClass;
	}

	public void setHeaderClass(String headerClass) {
		this.headerClass = headerClass;
	}

	public String getRowClass() {
		return rowClass;
	}

	public void setRowClass(String rowClass) {
		this.rowClass = rowClass;
	}

	public String getCellpadding() {
		return cellpadding;
	}

	public void setCellpadding(String cellpadding) {
		this.cellpadding = cellpadding;
	}

	public String getCellspacing() {
		return cellspacing;
	}

	public void setCellspacing(String cellspacing) {
		this.cellspacing = cellspacing;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getIndexId() {
		return indexId;
	}

	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}
	
}
