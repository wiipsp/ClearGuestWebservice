package org.projectx.webservice.service;

import javax.ws.rs.QueryParam;

public interface WechatSampleService {

	 
    public String test(@QueryParam("signature") String signature,@QueryParam("timestamp") String timestamp, @QueryParam("nonce") String nonce, @QueryParam("echostr") String echostr);  
}
