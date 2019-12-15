package ru.shara.application.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.shara.application.model.Role;
import ru.shara.application.model.User;

import java.sql.SQLException;
import java.util.List;


@Repository
public class RoleDaoImpl implements RoleDao{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){ this.sessionFactory = sessionFactory;}

    @Transactional
    public Role getUserRole(String role) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Role WHERE role= :role");
        query.setParameter("role", role);
        Role userRole = (Role) query.uniqueResult();
        transaction.commit();
        session.close();
        return userRole;
    }

    public Role getRoleById(Long id) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Role WHERE id= :id");
        query.setParameter("id", id);
        Role userRole = (Role) query.uniqueResult();
        transaction.commit();
        session.close();
        return userRole;
    }
}
