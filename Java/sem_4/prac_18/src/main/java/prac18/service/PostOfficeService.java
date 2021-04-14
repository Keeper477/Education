package prac18.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import prac18.model.PostOffice;
import prac18.repositories.PostOfficeRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostOfficeService {
    private final PostOfficeRepository postOfficeRepository;

    public List<PostOffice> getPostOffices() {return postOfficeRepository.findAll(); }

    public void addPostOffice(PostOffice postOffice){ postOfficeRepository.save(postOffice); }

    public String deletePostOffice(int id){
        if( postOfficeRepository.existsById(id)){
            return "Departure is not found";
        }
        return "Departure deleted";
    }

    public List<PostOffice> getSortedPostOfficesByName(){ return postOfficeRepository.findAll(Sort.by("name")); }

    public List<PostOffice> getSortedPostOfficesByCityName(){
        return postOfficeRepository.findAll(Sort.by("cityname"));
    }
}
