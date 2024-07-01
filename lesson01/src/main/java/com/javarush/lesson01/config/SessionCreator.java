package com.javarush.lesson01.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class SessionCreator {

    private final SessionFactory sessionFactory;

    @SneakyThrows
    public SessionCreator(ApplicationProperties applicationProperties) {
        Configuration configuration = new Configuration();        //1. hibernate.properties
        configuration.addProperties(applicationProperties);
        sessionFactory = configuration.buildSessionFactory();
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
//
//    public void beginTransactional() {
//        if (levelBox.get() == null) {
//            levelBox.set(new AtomicInteger(0));
//        }
//        AtomicInteger level = levelBox.get();
//        if (level.getAndIncrement() == 0) {
//            Session session = getSession();
//            sessionBox.set(session);
//            session.beginTransaction();
//        }
////        log.info(">>> start level: {} session={}", level.get(), sessionBox.get());
//    }
//
//
//    public void endTransactional() {
//        AtomicInteger level = levelBox.get();
//        Session session = sessionBox.get();
////        log.info("\t\tcheck tx: {} session={}", level.get(), session);
//
//        if (level.decrementAndGet() == 0) {
//            sessionBox.remove();
//            try {
//                session.getTransaction().commit();
//                session.close();
//            } catch (RuntimeException e) {
//                session.getTransaction().rollback();
//                session.close();
//                throw e;
//            }
//        }
////        log.info("<<< end level: {} session={}", level.get(), session);
//
//    }
//
//
    public void close() {
        sessionFactory.close();
    }

}