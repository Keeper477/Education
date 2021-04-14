package prac22.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import prac22.model.PostOffice;
import prac22.repositories.PostOfficeRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostOfficeService {
    private final PostOfficeRepository postOfficeRepository;

    @Autowired
    private EmailService emailService;

    @Transactional(readOnly = true)
    public List<PostOffice> getPostOffices() { return postOfficeRepository.findAll(); }

    @Transactional
    public void addPostOffice(PostOffice postOffice){
        emailService.sendMail("Add new post office","Add new post office: " + postOffice.getName());
        postOfficeRepository.save(postOffice);
    }

    @Transactional
    public String deletePostOffice(int id){
        if( postOfficeRepository.existsById(id)){
            return "PostOffice deleted";
        }
        return "PostOffice is not found";
    }

    @Transactional(readOnly = true)
    public List<PostOffice> getSortedPostOfficesByName(){ return postOfficeRepository.findAll(Sort.by("name")); }

    @Transactional(readOnly = true)
    public List<PostOffice> getSortedPostOfficesByCityName(){
        return postOfficeRepository.findAll(Sort.by("cityname"));
    }
}
