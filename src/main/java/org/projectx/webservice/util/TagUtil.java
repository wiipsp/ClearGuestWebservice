package org.projectx.webservice.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

public class TagUtil{
	private static TagUtil tagUtils = null;
	
	public static TagUtil getInstance(){
		if(tagUtils == null)
			tagUtils = new TagUtil();
		return tagUtils;
	}
	
	public void write(JspWriter out, String text) throws IOException{
		out.print(text);
	}
	
	public String getServletContextName(PageContext ctx){
		return getRequest(ctx).getContextPath();
	}
	
	public HttpServletRequest getRequest(PageContext ctx){
		return ((HttpServletRequest) ctx.getRequest());
	}
	
	public void handleProperties(StringBuffer prop, String key, String value){
		if(StringUtil.isNotEmpty(value))
			prop .append(" ").append(key) .append("=\"")
				 .append(value) .append("\"");
	}
}
