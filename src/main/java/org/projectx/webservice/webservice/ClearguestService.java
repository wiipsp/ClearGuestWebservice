package org.projectx.webservice.webservice;

import javax.ws.rs.QueryParam;

public interface ClearguestService {

	public String pushClearguestPwd(@QueryParam("password") String password);
}
