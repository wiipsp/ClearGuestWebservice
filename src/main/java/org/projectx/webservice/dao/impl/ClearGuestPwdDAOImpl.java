package org.projectx.webservice.dao.impl;

import org.projectx.webservice.dao.ClearGuestPwdDAO;
import org.projectx.webservice.to.ClearGuestPwdTO;
import org.springframework.stereotype.Repository;

@Repository("clearGuestPwdDAO")
public class ClearGuestPwdDAOImpl extends BaseDAOImpl<ClearGuestPwdTO, String> implements ClearGuestPwdDAO {

	@Override
	public ClearGuestPwdTO getLatestClearguestPwd() {
		String hqlString = "from ClearGuestPwdTO a order by a.createDt desc";
		return unique(hqlString, null);
	}
}
