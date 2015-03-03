package org.projectx.webservice.dao;

import org.projectx.webservice.mapper.RoleMapper;

public class RoleDAO extends BaseDAO implements RoleMapper{

	public Integer getRoleCount() {
		return getSqlSession().getMapper(RoleMapper.class).getRoleCount();
	}

}
