package org.projectx.webservice.dao;

import java.util.List;

import org.projectx.webservice.to.BaseTO;


public interface BaseDAO<M extends BaseTO, PK extends java.io.Serializable> {
    
    public PK save(M model);

    public void saveOrUpdate(M model);
    
    public void update(M model);
    
    public void merge(M model);

    public void delete(PK id);

    public void deleteObject(M model);

    public M get(PK id);
    
    public int countAll();

    public <T> List<T> list(final String hql, final int pn, final int pageSize, final Object[] paramlist);
    
    public List<M> listAll();

    public List<M> listAll(int pn, int pageSize);
    
    boolean exists(PK id);
    
    public void flush();
    
    public void clear();

    public int getVersionNo(PK id);


}
