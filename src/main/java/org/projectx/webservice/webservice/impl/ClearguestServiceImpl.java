package org.projectx.webservice.webservice.impl;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.projectx.webservice.service.ClearGuestPwdService;
import org.projectx.webservice.to.ClearGuestPwdTO;
import org.projectx.webservice.webservice.ClearguestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("request")
@Path("/clearguest")
public class ClearguestServiceImpl implements ClearguestService {

	@Autowired
	@Qualifier("clearGuestPwdService")
	private ClearGuestPwdService clearGuestPwdService;
	
	// 子路径  
    @Path("pushClearguestPwd")
    @GET  
	public String pushClearguestPwd(@QueryParam("password") String password) {
    	ClearGuestPwdTO clearGuestPwdTO = new ClearGuestPwdTO();
    	clearGuestPwdTO.setPassword(password);
    	clearGuestPwdTO.setClearGuestDate(new Date());
    	clearGuestPwdService.save(clearGuestPwdTO);
    	return "sucess";
	}
    
    // 子路径  
    @Path("getLatestClearguestPwd")
    @GET  
	public String getLatestClearguestPwd() {
    	ClearGuestPwdTO clearGuestPwdTO = clearGuestPwdService.getLatestClearguestPwd();
    	return clearGuestPwdTO.getPassword();
	}

}
