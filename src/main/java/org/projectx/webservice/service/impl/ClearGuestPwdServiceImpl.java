package org.projectx.webservice.service.impl;

import org.projectx.webservice.dao.BaseDAO;
import org.projectx.webservice.dao.ClearGuestPwdDAO;
import org.projectx.webservice.service.ClearGuestPwdService;
import org.projectx.webservice.to.ClearGuestPwdTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("clearGuestPwdService")
public class ClearGuestPwdServiceImpl extends BaseServiceImpl<ClearGuestPwdTO, String> implements ClearGuestPwdService {
	
	@Autowired
	@Qualifier("clearGuestPwdDAO")
	private ClearGuestPwdDAO clearGuestPwdDAO;

	@Override
	public BaseDAO<ClearGuestPwdTO, String> getBaseDAO() {
		return clearGuestPwdDAO;
	}

	@Override
	public ClearGuestPwdTO getLatestClearguestPwd() {
		return clearGuestPwdDAO.getLatestClearguestPwd();
	}
	
}
