package org.projectx.webservice.service;


import org.projectx.webservice.to.ClearGuestPwdTO;

public interface ClearGuestPwdService extends BaseService<ClearGuestPwdTO, String>{
	public ClearGuestPwdTO getLatestClearguestPwd();
}
