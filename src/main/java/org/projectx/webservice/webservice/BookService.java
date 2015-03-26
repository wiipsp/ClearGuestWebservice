package org.projectx.webservice.webservice;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.ws.rs.PathParam;

import org.projectx.webservice.to.UserTO;




public interface BookService {

	public String helloWorld();
	
	public List<UserTO>  getUsers();
	
	public Vector<HashMap<String,String>> getData(@PathParam("layerName") String layerName,@PathParam("queryText") String queryText);
	
	 public UserTO getUsersByIdForXML();
}
