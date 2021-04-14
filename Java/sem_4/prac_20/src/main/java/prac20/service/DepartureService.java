package prac20.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import prac20.model.Departure;
import prac20.model.PostOffice;
import prac20.repositories.DepartureRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class DepartureService {
    private final DepartureRepository departureRepository;

    public List<Departure> getDepartures() { return departureRepository.findAll(); }

    public void addDeparture(Departure departure){ departureRepository.save(departure); }

    public String deleteDeparture(int id){
        if( departureRepository.existsById(id)){
            return "Departure deleted";
        }
        return "Departure is not found";
    }
    public PostOffice getPostOfficeByDeparture(int postOfficeId) {
        return departureRepository.findById(postOfficeId).orElseThrow(() ->
                new IllegalStateException("Post with this id notfound")).getPostoffice();
    }

    public List<Departure> getSortedDeparturesByType(){ return departureRepository.findAll(Sort.by("type")); }

    public List<Departure> getSortedDeparturesByDepartureDate(){
        return departureRepository.findAll(Sort.by("departuredate"));
    }

}
