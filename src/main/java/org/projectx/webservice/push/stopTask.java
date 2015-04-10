package org.projectx.webservice.push;

import java.io.IOException;

import com.gexin.rp.sdk.http.IGtPush;

public class stopTask {
	static String appId = "";
	static String appkey = "";
	static String master = "";
	static String TaskId="";
	static String host = null;

	public static void main(String[] args) throws IOException,
			InterruptedException {
		stopTask();
	}

	public static void stopTask() throws IOException, InterruptedException {
			IGtPush push = new IGtPush(host, appkey, master);
			boolean result = push.stop(TaskId);
			System.out.println(result);
	}
}