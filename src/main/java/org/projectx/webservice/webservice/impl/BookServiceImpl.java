package org.projectx.webservice.webservice.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.projectx.webservice.to.UserTO;
import org.projectx.webservice.webservice.BookService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
  
@Service
@Scope("request")  
@Path("/test") 
public class BookServiceImpl implements BookService{
//	@Autowired
//	private AddrQueryDAO addrQueryDAO;
//
//	public AddrQueryDAO getAddrQueryDAO() {
//		return addrQueryDAO;
//	}
//
//	public void setAddrQueryDAO(AddrQueryDAO addrQueryDAO) {
//		this.addrQueryDAO = addrQueryDAO;
//	}
	//外部传过来的参数  
    @QueryParam("id") String userId;  
    
	@GET  
    @Produces(MediaType.TEXT_PLAIN)  
    public String helloWorld() {  
        String ret = "Hello World!";  
        return ret;  
    }  
      
    // 子路径  
    @Path("getUsers")     
    @GET  
    @Produces( {MediaType.APPLICATION_XML })  
    public List<UserTO>  getUsers() {  
        List<UserTO> users = new ArrayList<UserTO>();  
//        users = addrQueryDAO.getUser();
//        for (long i = 1; i < 5; i++) {  
//            User user = new User();  
//            user.userId=(i);  
//            user.userName=("yuhan" + i);  
//            user.nickName=("supben" + i);  
//            users.add(user);  
//        }    
        return users;  
    }    
      
    // 子路径  
    @Path("getData")  
    @GET  
    @Produces( {MediaType.APPLICATION_JSON })  
    public Vector<HashMap<String,String>> getData(@QueryParam("layerName") String layerName,@QueryParam("queryText") String queryText){  
//    Object[] resultArray = null;
		return null;
    }  
    
    @Path("getUserXmlById")  
    @GET  
    @Produces( {MediaType.APPLICATION_XML })  
    public UserTO getUsersByIdForXML(){  
    	 UserTO user = new UserTO();  
//         user = addrQueryDAO.getUserById(userId);
         return user;  
    }  
    
}
