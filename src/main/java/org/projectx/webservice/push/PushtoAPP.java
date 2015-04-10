package org.projectx.webservice.push;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.projectx.webservice.Constants;
import org.projectx.webservice.service.ClearGuestPwdService;
import org.projectx.webservice.to.ClearGuestPwdTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;

@Component("pushtoAPP")
public class PushtoAPP {
	protected static Log log = LogFactory.getLog(PushtoAPP.class);
	
	@Autowired
	@Qualifier("clearGuestPwdService")
	private ClearGuestPwdService clearGuestPwdService;
	
	public String notificationPwdToApp(){
		ClearGuestPwdTO clearGuestPwdTO = clearGuestPwdService.getLatestClearguestPwd();
        String content = clearGuestPwdTO.getPassword();
        IGtPush push = new IGtPush(Constants.PUSH_APP_HOST, Constants.PUSH_APP_KEY, Constants.PUSH_APP_MASTER);
		TransmissionTemplate template;
		try {
			push.connect();
			template = transmissionTemplate(content);
			AppMessage message = new AppMessage();
			message.setData(template);

			message.setOffline(true);
			message.setOfflineExpireTime(1 * 1000 * 3600);

			List<String> appIdList = new ArrayList<String>();
			List<String> phoneTypeList = new ArrayList<String>();
			appIdList.add(Constants.PUSH_APP_ID);
//			phoneTypeList.add("ANDROID");
//			phoneTypeList.add("IOS");
			message.setAppIdList(appIdList);
//			message.setPhoneTypeList(phoneTypeList);
			
			IPushResult ret = push.pushMessageToApp(message,"任务别名可为空");
			log.info(ret.getResponse().toString());
			return ret.getResponse().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public TransmissionTemplate transmissionTemplate(String content)
			throws Exception {
		TransmissionTemplate template = new TransmissionTemplate();
		template.setAppId(Constants.PUSH_APP_ID);
		template.setAppkey(Constants.PUSH_APP_KEY);
		template.setTransmissionType(2);
		template.setTransmissionContent(content);
		template.setPushInfo("", 1, "Clear-Guest密码送到", "default", "payload", "", "", "");
		return template;
	}

	public static LinkTemplate linkTemplateDemo() throws Exception {
		LinkTemplate template = new LinkTemplate();
		template.setAppId(Constants.PUSH_APP_ID);
		template.setAppkey(Constants.PUSH_APP_KEY);
		template.setTitle("标题");
		template.setText("内容");
		template.setLogo("icon.png");
		template.setLogoUrl("");
		template.setIsRing(true);
		template.setIsVibrate(true);
		template.setIsClearable(true);
		template.setUrl("http://www.baidu.com");
//		template.setPushInfo("actionLocKey", 1, "message", "sound", "payload",
//				"locKey", "locArgs", "launchImage",1);
		return template;
	}
	
	

}