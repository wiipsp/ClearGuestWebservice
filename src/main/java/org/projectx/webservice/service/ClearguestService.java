package org.projectx.webservice.service;

import javax.ws.rs.QueryParam;

public interface ClearguestService {

	public String pushClearguestPwd(@QueryParam("password") String password);
}
