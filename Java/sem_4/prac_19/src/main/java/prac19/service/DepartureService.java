package prac19.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import prac19.model.Departure;
import prac19.model.PostOffice;
import prac19.repositories.DepartureRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class DepartureService {
    private final DepartureRepository departureRepository;

    public List<Departure> getDepartures() {
        log.info("Get all departures");
        return departureRepository.findAll();
    }

    public void addDeparture(Departure departure){
        log.info("Add departure");
        departureRepository.save(departure);
    }

    public String deleteDeparture(int id){
        if( departureRepository.existsById(id)){
            log.debug("Delete departure");
            return "Departure deleted";
        }
        log.debug("Delete departure. Can not find departure");
        return "Departure is not found";
    }
    public PostOffice getPostOfficeByDeparture(int postOfficeId) {
        log.info("Get post office by departure");
        return departureRepository.findById(postOfficeId).orElseThrow(() ->
                new IllegalStateException("Post with this id notfound")).getPostoffice();
    }

    public List<Departure> getSortedDeparturesByType(){
        log.info("Get sorted departures by type");
        return departureRepository.findAll(Sort.by("type"));
    }

    public List<Departure> getSortedDeparturesByDepartureDate(){
        log.info("Get sorted departures by departure date");
        return departureRepository.findAll(Sort.by("departuredate"));
    }

}
