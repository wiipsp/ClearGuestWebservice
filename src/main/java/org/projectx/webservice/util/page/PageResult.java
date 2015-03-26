package org.projectx.webservice.util.page;

import java.util.List;

public class PageResult {  
	  
    private Page page;  
  
    private List<?> content;  
  
    /** 
     * The default constructor 
     */  
    public PageResult() {  
        super();  
    }  
  
    /** 
     * The constructor using fields 
     *  
     * @param page 
     * @param content 
     */  
    public PageResult(Page page, List<?> content) {  
        this.page = page;  
        this.content = content;  
    }  
  
    /** 
     * @return Returns the content. 
     */  
    public List<?> getContent() {  
        return content;  
    }  
  
    /** 
     * @return Returns the page. 
     */  
    public Page getPage() {  
        return page;  
    }  
  
    /** 
     * @param content 
     *            The content to set. 
     */  
    public void setContent(List<?> content) {  
        this.content = content;  
    }  
  
    /** 
     * @param page 
     *            The page to set. 
     */  
    public void setPage(Page page) {  
        this.page = page;  
    }  
}  