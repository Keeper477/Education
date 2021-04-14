package prac19.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import prac19.model.PostOffice;
import prac19.repositories.PostOfficeRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class PostOfficeService {
    private final PostOfficeRepository postOfficeRepository;

    public List<PostOffice> getPostOffices() {
        log.info("Get all post offices");
        return postOfficeRepository.findAll();
    }

    public void addPostOffice(PostOffice postOffice){
        log.info("Add post office");
        postOfficeRepository.save(postOffice);
    }

    public String deletePostOffice(int id){
        if( postOfficeRepository.existsById(id)){
            log.debug("Delete post office");
            return "PostOffice deleted";
        }
        log.debug("Delete post office. Can not find post office");
        return "PostOffice is not found";
    }

    public List<PostOffice> getSortedPostOfficesByName(){
        log.info("Get sorted post office by name");
        return postOfficeRepository.findAll(Sort.by("name"));
    }

    public List<PostOffice> getSortedPostOfficesByCityName(){

        log.info("Get sorted post office by cityname");
        return postOfficeRepository.findAll(Sort.by("cityname"));
    }
}
