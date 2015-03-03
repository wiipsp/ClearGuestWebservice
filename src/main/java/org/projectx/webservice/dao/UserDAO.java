package org.projectx.webservice.dao;

import org.projectx.webservice.mapper.UserMapper;
import org.projectx.webservice.to.UserTO;



public class UserDAO extends BaseDAO implements UserMapper{

	public UserTO selectByUserId(int id) {
		return getSqlSession().getMapper(UserMapper.class).selectByUserId(id);
	}

	public void insertUser(UserTO user) {
		getSqlSession().getMapper(UserMapper.class).insertUser(user);
	}

	public void updateUser(UserTO user){
		getSqlSession().getMapper(UserMapper.class).updateUser(user);
	}

	public void deleteUserByid(int id){
		getSqlSession().getMapper(UserMapper.class).deleteUserByid(id);
	}
	
	public UserTO selectByUserName(String name){
		return getSqlSession().getMapper(UserMapper.class).selectByUserName(name);
	}

	public Integer getUserCount() {
		return getSqlSession().getMapper(UserMapper.class).getUserCount();
	}

}
