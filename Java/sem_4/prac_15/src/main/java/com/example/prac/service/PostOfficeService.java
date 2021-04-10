package com.example.prac.service;

import com.example.prac.model.PostOffice;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
@RequiredArgsConstructor
public class PostOfficeService {
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }
    public List<PostOffice> getPostOffices() {return session.createQuery("select u from PostOffice u",
            PostOffice.class).getResultList();
    }

    public void addPostOffice(PostOffice postOffice){
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(postOffice);
        transaction.commit();
    }

    public String deletePostOffice(String name){
        Transaction transaction = session.beginTransaction();
        PostOffice postOffice = session.find(PostOffice.class, name);
        if( postOffice == null){
            return "User is not found";
        }
        session.delete(postOffice);
        transaction.commit();
        return "User deleted";
    }
}
