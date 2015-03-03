package org.projectx.webservice.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.projectx.webservice.mapper.BaseMapper;

public class BaseDAO extends SqlSessionDaoSupport implements BaseMapper{
//	public String getSeqBySeqName(String seqName) {
//		String selectSeqSql = "select "+seqName+".nextval as id FROM dual";
//		return getSqlSession().getMapper(BaseMapper.class).getSeqBySeqName(selectSeqSql);
//	}
}
