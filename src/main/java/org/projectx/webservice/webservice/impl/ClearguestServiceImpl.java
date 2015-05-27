package org.projectx.webservice.webservice.impl;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.projectx.webservice.push.PushtoAPP;
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
	
	@Autowired
	@Qualifier("pushtoAPP")
	private PushtoAPP pushtoAPP;
	
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
	public String getLatestClearguestPwd(@Context HttpServletRequest request, @Context HttpServletResponse response) {
    	response.setCharacterEncoding("UTF-8");
    	ClearGuestPwdTO clearGuestPwdTO = clearGuestPwdService.getLatestClearguestPwd();
    	return DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA).format(clearGuestPwdTO.getClearGuestDate()) + "#" + clearGuestPwdTO.getPassword();
	}
    
 // 子路径  
    @Path("notificationLatestClearguestPwd")
    @GET  
	public String notificationLatestClearguestPwd() {
    	return pushtoAPP.notificationPwdToApp();
	}

}
