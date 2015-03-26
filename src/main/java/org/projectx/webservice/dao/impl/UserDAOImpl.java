package org.projectx.webservice.dao.impl;

import org.projectx.webservice.Constants;
import org.projectx.webservice.dao.UserDAO;
import org.projectx.webservice.to.UserTO;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAOImpl extends BaseDAOImpl<UserTO, String> implements UserDAO{

	@Override
	public UserTO selectByUserName(String userName) {
		String hqlString = "from UserTO a where a.userName = '" + userName +"' and a.isDeleted = 'N'";
		return unique(hqlString, null);
	}

	@Override
	public void deleteByUserName(String userName) {
    	UserTO userTO = selectByUserName(userName);
    	userTO.setIsDeleted(Constants.FLAG_Y);
    	update(userTO);
	}

}
