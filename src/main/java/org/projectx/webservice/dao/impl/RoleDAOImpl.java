package org.projectx.webservice.dao.impl;

import org.projectx.webservice.dao.RoleDAO;
import org.projectx.webservice.to.RoleTO;
import org.springframework.stereotype.Repository;

@Repository("roleDAO")
public class RoleDAOImpl extends BaseDAOImpl<RoleTO, String> implements RoleDAO {


}
