package prac15.service;

import prac15.model.Departure;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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
            return "User is not found";
        }
        session.delete(departure);
        transaction.commit();
        return "User deleted";
    }
}
