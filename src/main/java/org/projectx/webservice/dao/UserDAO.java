package org.projectx.webservice.dao;

import org.projectx.webservice.to.UserTO;



public interface UserDAO extends BaseDAO<UserTO, String> {
    
	public UserTO selectByUserName(String userName);
	
	public void deleteByUserName(String userName);
	
}
