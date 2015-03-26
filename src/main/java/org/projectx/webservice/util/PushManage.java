package org.projectx.webservice.util;

import java.io.IOException;  
import java.io.InputStream;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.List;  
import org.jdom2.Document;  
import org.jdom2.Element;  
import org.jdom2.JDOMException;  
import org.jdom2.input.SAXBuilder;  
import org.jdom2.output.XMLOutputter;  
  
public class PushManage {  
      
    public String PushManageXml(InputStream is) throws JDOMException {  
  
        String returnStr = ""; // 反回Servlet字符�? 
        String toName = ""; // �?��者微信号  
        String fromName = ""; // 发�?方帐号（�?��OpenID�? 
        String type = ""; // 请求类型  
        String con = ""; // 消息内容(接收)  
          
        try {  
  
            SAXBuilder sax = new SAXBuilder();  
            Document doc = sax.build(is);  
            // 获得文件的根元素  
            Element root = doc.getRootElement();  
  
            // 获得根元素的第一级子节点  
            List list = root.getChildren();  
            for (int j = 0; j < list.size(); j++) {  
                // 获得结点  
                Element first = (Element) list.get(j);  
                System.out.println(first.getName()+"   :    "+first.getValue());
                if (first.getName().equals("ToUserName")) {  
                    toName = first.getValue().trim();  
                } else if (first.getName().equals("FromUserName")) {  
                    fromName = first.getValue().trim();  
                } else if (first.getName().equals("MsgType")) {  
                    type = first.getValue().trim();  
                } else if (first.getName().equals("Content")) {  
                    con = first.getValue().trim();  
                }
            }  
        } catch (IOException e) {  
            //异常  
        }  
          
        returnStr = getBackXMLTypeText(toName,fromName,"输入�?"+con);  
          
        return returnStr;  
    }  
      
  
    /** 
     * 编译文本信息 
     *  
     * @author xiaowu 
     * @since 2013-9-27 
     * @param toName 
     * @param FromName 
     * @param content 
     * @return 
     */  
    private String getBackXMLTypeText(String toName, String fromName,  
            String content) {  
    	 System.out.println(toName+"   :    "+fromName+":"+content);
        String returnStr = "";  
  
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");  
        String times = format.format(new Date());  
  
        Element rootXML = new Element("xml");  
  
        rootXML.addContent(new Element("ToUserName").setText(fromName));  
        rootXML.addContent(new Element("FromUserName").setText(toName));  
        rootXML.addContent(new Element("CreateTime").setText(times));  
        rootXML.addContent(new Element("MsgType").setText("text"));  
        rootXML.addContent(new Element("Content").setText(content));  
  
        Document doc = new Document(rootXML);  
  
        XMLOutputter XMLOut = new XMLOutputter();  
        returnStr = XMLOut.outputString(doc);  
  
        return returnStr;  
    }  
  
  
}  
