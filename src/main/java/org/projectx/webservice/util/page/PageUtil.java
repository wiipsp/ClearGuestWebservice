package org.projectx.webservice.util.page;

import org.projectx.webservice.util.StringUtil;

  
/** 
 * @author peiliang 
 * 
 */  
public class PageUtil {  
      
	public static String SORT_TYPE_ASC = "ASC";
	public static String SORT_TYPE_DESC = "DESC";
      
    /** 
     * Use the origin page to create a new page 
     * @param page 
     * @param totalRecords 
     * @return 
     */  
    public static Page createPage(Page page, int totalRecords){  
    	if(page == null){
    		page = new Page();
    	}
        return createPage(page.getEveryPage(), page.getCurrentPage(), totalRecords, page.getHasGetLastPage(), page.getIndexColumn(), page.getSortType());  
    }  
      
    /**   
     * the basic page utils not including exception handler 
     * @param everyPage 
     * @param currentPage 
     * @param totalRecords 
     * @return page 
     */  
    public static Page createPage(int everyPage, int currentPage, int totalRecords, boolean hasGetLastPage, String indexColumn, String sortType){  
        everyPage = getEveryPage(everyPage);  
        int totalPage = getTotalPage(everyPage, totalRecords);  
        currentPage = getCurrentPage(currentPage, totalPage, hasGetLastPage);  
        int beginIndex = getBeginIndex(everyPage, currentPage);  
        boolean hasNextPage = hasNextPage(currentPage, totalPage);  
        boolean hasPrePage = hasPrePage(currentPage);  
        indexColumn = getIndexColumn(indexColumn);
        sortType =  getSortType(sortType);
        return new Page(hasPrePage, hasNextPage, false,
                        everyPage, totalPage,   
                        currentPage, beginIndex, indexColumn, sortType, totalRecords);  
    }  
      
    private static int getEveryPage(int everyPage){  
        return everyPage == 0 ? 10 : everyPage;  
    }  
    
    private static int getTotalPage(int everyPage, int totalRecords){  
        int totalPage = 0;  
          
        if(totalRecords % everyPage == 0)
            totalPage = totalRecords / everyPage;   
        else
            totalPage = totalRecords / everyPage + 1 ;  
          
        return totalPage;  
    }  
      
    private static int getCurrentPage(int currentPage, int totalPage, boolean hasGetLastPage){  
    	if(hasGetLastPage){
    		return totalPage;
    	}
    	if(totalPage == 0){
			return totalPage;
		}
		if(currentPage > totalPage){
			return totalPage;
		}else{
			return currentPage <= 0 ? 1 : currentPage;
		}
    }  
      
    public static int getBeginIndex(int everyPage, int currentPage){  
        int  beginIndex =  (currentPage - 1) * everyPage;
        if(beginIndex < 0){
        	return 0;
        }else{
        	return beginIndex;
        }
    }  
      
    private static boolean hasPrePage(int currentPage){  
        return currentPage <= 1 ? false : true;   
    }  
      
    private static boolean hasNextPage(int currentPage, int totalPage){  
        return currentPage >= totalPage || totalPage == 0 ? false : true;  
    }  
      
    private static String getIndexColumn(String indexColumn){
    	return StringUtil.isNullOrBlank(indexColumn)? null : indexColumn;
    }
    
    private static String getSortType(String sortType){
    	return StringUtil.isNullOrBlank(sortType)? SORT_TYPE_ASC : sortType;
    }
  
}  
