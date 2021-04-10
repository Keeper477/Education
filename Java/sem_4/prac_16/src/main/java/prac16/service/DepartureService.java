package prac16.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import prac16.model.Departure;
import prac16.model.PostOffice;

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
}
