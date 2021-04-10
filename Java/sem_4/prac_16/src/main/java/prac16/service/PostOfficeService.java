package prac16.service;

import prac16.model.PostOffice;
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

    public String deletePostOffice(int id){
        Transaction transaction = session.beginTransaction();
        PostOffice postOffice = session.find(PostOffice.class, id);
        if( postOffice == null){
            return "PostOffice is not found";
        }
        session.delete(postOffice);
        transaction.commit();
        return "PostOffice deleted";
    }
}
