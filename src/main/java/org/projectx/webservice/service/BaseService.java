package org.projectx.webservice.service;

import java.util.List;

import org.projectx.webservice.to.BaseTO;


public interface BaseService<M extends BaseTO, PK extends java.io.Serializable> {
    
    public M save(M model);

    public void saveOrUpdate(M model);
    
    public void update(M model);
    
    public void merge(M model);

    public void delete(PK id);

    public void deleteObject(M model);

    public M get(PK id);
    
    public int countAll();
    
    public List<M> listAll();
    
}
