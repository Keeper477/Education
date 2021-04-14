package prac17.service;

import org.hibernate.query.Query;
import prac17.model.PostOffice;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    public List<PostOffice> getSortedPostOfficesByName(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PostOffice> postOfficeCriteriaQuery = builder.createQuery(PostOffice.class);
        Root<PostOffice> root = postOfficeCriteriaQuery.from(PostOffice.class);
        postOfficeCriteriaQuery.select(root).orderBy(builder.asc(root.get("name")));
        Query<PostOffice> query = session.createQuery(postOfficeCriteriaQuery);
        return query.getResultList();
    }

    public List<PostOffice> getSortedPostOfficesByCityName(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PostOffice> postOfficeCriteriaQuery = builder.createQuery(PostOffice.class);
        Root<PostOffice> root = postOfficeCriteriaQuery.from(PostOffice.class);
        postOfficeCriteriaQuery.select(root).orderBy(builder.asc(root.get("cityname")));
        Query<PostOffice> query = session.createQuery(postOfficeCriteriaQuery);
        return query.getResultList();
    }
}
