package com.example.demo1.DAO.DAOImplementation;
import com.example.demo1.Bean.Students;
import com.example.demo1.DAO.StudentsDAO;
import com.example.demo1.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentsDAOImplemention implements StudentsDAO {
    @Override
    public boolean addStudent(Students stuObj){
        try(Session session=HibernateSessionUtil.getSession()){
            Transaction transaction=session.beginTransaction();
            session.save(stuObj);
            transaction.commit();
            return true;
        }catch (HibernateException exception){
            System.out.println("Hibernate Exception");
            System.out.println(exception.getLocalizedMessage());
            return false;
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Students> getStudentList(){
        try(Session session=HibernateSessionUtil.getSession()){
            List<Students> studentsList = new ArrayList<>();
            for (final Object d : session.createQuery("from Students ").list()) {
                studentsList.add((Students) d);
            }
            return studentsList;
        }catch (HibernateException exception){
            System.out.println("Hibernate Exception");
            System.out.println(exception.getLocalizedMessage());
            return null;
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }
//
//    @Override
//    public
}
