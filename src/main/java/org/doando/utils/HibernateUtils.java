package org.doando.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Yago Ferreira
 */
public class HibernateUtils {

    private static SessionFactory sessionFactory;

    private static SessionFactory getInstance() {
        if (sessionFactory == null) {
            AnnotationConfiguration configuration = new AnnotationConfiguration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

    public static Session getSession() throws HibernateException {
        return getInstance().openSession();
    }
}
