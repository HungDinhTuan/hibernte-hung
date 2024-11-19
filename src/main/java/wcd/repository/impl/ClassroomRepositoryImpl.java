package wcd.repository.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import wcd.entity.Classroom;
import wcd.repository.ClassroomRepository;
import wcd.util.HibernateUtil;

import java.util.List;

public class ClassroomRepositoryImpl implements ClassroomRepository {

    @Override
    public List<Classroom> findAll() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Classroom", Classroom.class).list();
        }
    }

    @Override
    public void save(Classroom classroom) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(classroom);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Classroom findById(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Classroom.class, id);
        }
    }

    @Override
    public void delete(int id) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Classroom classroom = session.get(Classroom.class, id);
            if (classroom != null) {
                session.delete(classroom);
                transaction.commit();
            }
        }catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Classroom classroom = session.get(Classroom.class, id);
            if (classroom != null) {
                session.update(classroom);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Classroom> findByClassroomName(String classroomName) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery();
        }
    }
}
