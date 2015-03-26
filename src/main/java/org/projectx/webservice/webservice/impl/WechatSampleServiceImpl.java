package org.projectx.webservice.webservice.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.jdom2.JDOMException;
import org.projectx.webservice.util.EncoderUtil;
import org.projectx.webservice.util.PropertiesUtil;
import org.projectx.webservice.util.PushManage;
import org.projectx.webservice.util.StringUtil;
import org.projectx.webservice.webservice.WechatSampleService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Scope("request")
@Path("/jersey")
public class WechatSampleServiceImpl implements WechatSampleService {

	// 子路径  
    @Path("getData")  
    @GET  
    public String test(@QueryParam("signature") String signature,@QueryParam("timestamp") String timestamp, @QueryParam("nonce") String nonce, @QueryParam("echostr") String echostr){  
		String token = PropertiesUtil.getPropertyValue("token");
		String[] array = {token, timestamp, nonce};
		Arrays.sort(array, String.CASE_INSENSITIVE_ORDER);
		String sha1 = EncoderUtil.encodeBySHA1(array[0]+array[1]+array[2]);
		if(StringUtil.isEqualTrim(sha1, signature)){
			return echostr;
		}else{
			return "error";
		}//@ContextHttpServletRequest request
    }
    
 // 子路径  
    @Path("getData")  
    @POST
    public void getMessage(@Context HttpServletRequest request, @Context HttpServletResponse response) throws IOException{  
		//String token = PropertiesUtil.getPropertyValue("token");
		response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");  
	    PrintWriter out = response.getWriter();  
	    try {  
	        InputStream is = request.getInputStream();  
	        PushManage push = new PushManage();  
	        String getXml = push.PushManageXml(is);  
	        System.out.println(getXml);
	        out.print(getXml);  
	    } catch (JDOMException e) {  
	        e.printStackTrace();  
	        out.print("");  
	    } catch (Exception e) {  
	        out.print("");  
	    } finally {   
	        if(out!=null) {   
	            out.flush();  
	            out.close();  
	        }  
	    }  
    }
    
}
