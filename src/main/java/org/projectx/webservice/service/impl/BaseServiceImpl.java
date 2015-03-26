package org.projectx.webservice.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.projectx.webservice.dao.BaseDAO;
import org.projectx.webservice.service.BaseService;
import org.projectx.webservice.to.BaseTO;
 
public abstract class BaseServiceImpl<M extends BaseTO, PK extends java.io.Serializable> implements BaseService<M, PK> {
    
	protected static Log log = LogFactory.getLog(BaseServiceImpl.class);
	
	public abstract BaseDAO<M, PK> getBaseDAO();

	@Override
    public M save(M model) {
        getBaseDAO().save(model);
        return model;
    }
    
    @Override
    public void merge(M model) {
        getBaseDAO().merge(model);
    }

    @Override
    public void saveOrUpdate(M model) {
        getBaseDAO().saveOrUpdate(model);
    }

    @Override
    public void update(M model) {
        getBaseDAO().update(model);
    }
    
    @Override
    public void delete(PK id) {
        getBaseDAO().delete(id);
    }

    @Override
    public void deleteObject(M model) {
        getBaseDAO().deleteObject(model);
    }

    @Override
    public M get(PK id) {
        return getBaseDAO().get(id);
    }

   
    
    @Override
    public int countAll() {
        return getBaseDAO().countAll();
    }

    @Override
    public List<M> listAll() {
        return getBaseDAO().listAll();
    }
    
}
