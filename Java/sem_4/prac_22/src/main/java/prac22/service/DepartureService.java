package prac22.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import prac22.model.Departure;
import prac22.model.PostOffice;
import prac22.repositories.DepartureRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DepartureService {
    private final DepartureRepository departureRepository;

    @Autowired
    private EmailService emailService;

    @Transactional(readOnly = true)
    public List<Departure> getDepartures() { return departureRepository.findAll(); }

    @Transactional
    public void addDeparture(Departure departure){
        emailService.sendMail("Add new departure","Add new departure: " + departure.getType());
        departureRepository.save(departure);
    }

    @Transactional
    public String deleteDeparture(int id){
        if( departureRepository.existsById(id)){
            return "Departure deleted";
        }
        return "Departure is not found";
    }

    @Transactional(readOnly = true)
    public PostOffice getPostOfficeByDeparture(int postOfficeId) {
        return departureRepository.findById(postOfficeId).orElseThrow(() ->
                new IllegalStateException("Post with this id notfound")).getPostoffice();
    }

    @Transactional(readOnly = true)
    public List<Departure> getSortedDeparturesByType(){ return departureRepository.findAll(Sort.by("type")); }

    @Transactional(readOnly = true)
    public List<Departure> getSortedDeparturesByDepartureDate(){
        return departureRepository.findAll(Sort.by("departuredate"));
    }

}
