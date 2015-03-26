package org.projectx.webservice.dao;

import org.projectx.webservice.to.ClearGuestPwdTO;

public interface ClearGuestPwdDAO extends BaseDAO<ClearGuestPwdTO, String> {

	public ClearGuestPwdTO getLatestClearguestPwd();
}
