/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.projetoIntegrador.business;

import com.ads.projetoIntegrador.dao.IAbstractDAO;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Yago Ferreira
 * @param <T>
 * @param <IdType>
 */
public interface IBusinessManager<T extends Serializable, IdType extends Serializable> {

    public void validate(T t) throws IllegalArgumentException;

    public IAbstractDAO<T, IdType> getDAO();

    public T find(IdType id);

    public List<T> find();

    public List<T> find(String namedQuery, Map<String, Object> params);
    
    public void save(T t);

    public void update(T t);

    public void delete(T t);
}
