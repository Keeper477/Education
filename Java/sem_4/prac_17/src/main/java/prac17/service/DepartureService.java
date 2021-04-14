package prac17.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import prac17.model.Departure;
import prac17.model.PostOffice;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Component
@RequiredArgsConstructor
public class DepartureService {
    private final SessionFactory sessionFactory;
    private Session session;


    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }
    public List<Departure> getDepartures() {return session.createQuery("select u from Departure u",
            Departure.class).getResultList();
    }

    public void addDeparture(Departure departure){
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(departure);
        transaction.commit();
    }

    public String deleteDeparture(int id){
        Transaction transaction = session.beginTransaction();
        Departure departure = session.find(Departure.class, id);
        if( departure == null){
            return "Departure is not found";
        }
        session.delete(departure);
        transaction.commit();
        return "Departure deleted";
    }
    public PostOffice getPostOfficeByDeparture(int postOfficeId) {
        return session.createQuery("FROM Departure where id = :id", Departure.class)
                .setParameter("id", postOfficeId).getSingleResult().getPostoffice();
    }

    public List<Departure> getSortedDeparturesByType(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Departure> departureCriteriaQuery = builder.createQuery(Departure.class);
        Root<Departure> root = departureCriteriaQuery.from(Departure.class);
        departureCriteriaQuery.select(root).orderBy(builder.asc(root.get("type")));
        Query<Departure> query = session.createQuery(departureCriteriaQuery);
        return query.getResultList();
    }

    public List<Departure> getSortedDeparturesByDepartureDate(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Departure> departureCriteriaQuery = builder.createQuery(Departure.class);
        Root<Departure> root = departureCriteriaQuery.from(Departure.class);
        departureCriteriaQuery.select(root).orderBy(builder.asc(root.get("departuredate")));
        Query<Departure> query = session.createQuery(departureCriteriaQuery);
        return query.getResultList();
    }

}
