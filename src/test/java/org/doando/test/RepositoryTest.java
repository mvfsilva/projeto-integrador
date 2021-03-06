package org.doando.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.doando.entity.PersonEntity;
import org.doando.repository.PersonRepository;
import org.doando.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Yago Ferreira
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RepositoryTest {

    private PersonRepository dao;
    private PersonEntity person;
    private String name;
    private String newName;
    private Session session;
    
    @Before
    public void setUp() {
        dao = new PersonRepository();
        person = new PersonEntity();
        name = "TestName";
        newName = "newName";
    }
    
    private void initialize() {
        session = HibernateUtils.getSession();
        session.beginTransaction();    	
        dao.setSession(session);
    }
    
    private void commit() {
    	session.getTransaction().commit();
    }
    
    private void cleanUp() {
    	session.flush();
    	session.close();
    }

    @Test
    public void when_1_insertingAPerson() {
        person.setName(name);
        initialize();
        dao.save(person);
        commit();
        assertTrue(dao.find(name).getName().equals(name));
        cleanUp();
    }

    @Test
    public void when_2_updatingAPerson() {
    	initialize();
        PersonEntity p = dao.find(name);
        p.setName(newName);
        dao.update(p);
        commit();
        assertTrue(dao.find(newName).getName().equals(newName));
        cleanUp();
    }
    
    @Test
    public void when_3_deletingAPerson() {
    	initialize();
        PersonEntity p = dao.find(newName);
        dao.delete(p);
        commit();
        List<PersonEntity> result = dao.find();
        assertTrue(result.isEmpty());
        cleanUp();
    }
    
}
