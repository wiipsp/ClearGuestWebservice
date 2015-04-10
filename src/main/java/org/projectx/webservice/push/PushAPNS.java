package org.projectx.webservice.push;

import org.projectx.webservice.Constants;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.APNTemplate;

/**
 * IPushResult pushMessageToSingle(SingleMessage message, Target target)
 * 
 * @author Kevin
 * 
 */
public class PushAPNS {

	static String dt = "";

	public static void main(String[] args) {
		apnpush();
	}

	public static void apnpush() {
		IGtPush p = new IGtPush(Constants.PUSH_APP_HOST, Constants.PUSH_APP_KEY, Constants.PUSH_APP_MASTER);
		APNTemplate template = new APNTemplate();
		template.setPushInfo("", 2, "", "");

		 SingleMessage SingleMessage = new SingleMessage();
		 SingleMessage.setData(template);
		 IPushResult ret = p.pushAPNMessageToSingle(Constants.PUSH_APP_ID, dt, SingleMessage);
		 System.out.println(ret.getResponse());

//		ListMessage lm = new ListMessage();
//		lm.setData(template);
//		String contentId = p.getAPNContentId(appId, lm);
//		List<String> dtl = new ArrayList<String>();
//		dtl.add(dt);
//		System.setProperty("gexin.rp.sdk.pushlist.needDetails", "true");
//		IPushResult ret = p.pushAPNMessageToList(appId, contentId, dtl);
//		System.out.println(ret.getResponse());
	}
}
