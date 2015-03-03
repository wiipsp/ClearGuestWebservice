package org.projectx.webservice.mapper;


import org.projectx.webservice.to.UserTO;


public interface UserMapper extends BaseMapper {
	
	public UserTO selectByUserId(int userId);
	
	public void insertUser(UserTO user);
	
	public void updateUser(UserTO user);
	
	public void deleteUserByid(int id);
	
	public UserTO selectByUserName(String name);
	
	public Integer getUserCount();
}
