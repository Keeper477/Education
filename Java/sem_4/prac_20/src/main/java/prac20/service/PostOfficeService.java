package prac20.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import prac20.model.PostOffice;
import prac20.repositories.PostOfficeRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class PostOfficeService {
    private final PostOfficeRepository postOfficeRepository;

    public List<PostOffice> getPostOffices() { return postOfficeRepository.findAll(); }

    public void addPostOffice(PostOffice postOffice){ postOfficeRepository.save(postOffice); }

    public String deletePostOffice(int id){
        if( postOfficeRepository.existsById(id)){
            return "PostOffice deleted";
        }
        return "PostOffice is not found";
    }

    public List<PostOffice> getSortedPostOfficesByName(){ return postOfficeRepository.findAll(Sort.by("name")); }

    public List<PostOffice> getSortedPostOfficesByCityName(){
        return postOfficeRepository.findAll(Sort.by("cityname"));
    }
}
