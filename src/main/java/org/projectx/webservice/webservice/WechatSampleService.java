package org.projectx.webservice.webservice;

import javax.ws.rs.QueryParam;

public interface WechatSampleService {

	 
    public String test(@QueryParam("signature") String signature,@QueryParam("timestamp") String timestamp, @QueryParam("nonce") String nonce, @QueryParam("echostr") String echostr);  
}
