package prac24.service;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import prac24.model.PostOffice;
import prac24.repositories.PostOfficeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class PostOfficeTest {
    @MockBean
    private PostOfficeRepository postOfficeRepository;

    @Captor
    private ArgumentCaptor<PostOffice> captor;
    private PostOfficeService postOfficeService;

    @Autowired
    public void setPostOfficeService(PostOfficeService postOfficeService) {
        this.postOfficeService = postOfficeService;
    }
    private final List<PostOffice> posts = new ArrayList<>();

    @Before
    public void setUp(){
        PostOffice post1 =new PostOffice();
        post1.setId(0);
        post1.setCityName("Moscow");
        post1.setName("Kek");

        PostOffice post2 =new PostOffice();
        post2.setId(1);
        post2.setCityName("SPB");
        post2.setName("Hello");

        posts.add(post1);
        posts.add(post2);

        when(postOfficeRepository.findAll()).thenReturn(posts);
    }

    @Test
    public void whenGetPostOffices(){
        List<PostOffice> fetched = postOfficeService.getPostOffices();

        verify(postOfficeRepository, times(1)).findAll();
        Assertions.assertEquals(posts.size(), fetched.size());
    }

    @Test
    public void addPostOffice(){
        PostOffice post3 =new PostOffice();
        post3.setId(3);
        post3.setCityName("Mos");
        post3.setName("Name");
        postOfficeService.addPostOffice(post3);

        verify(postOfficeRepository).save(captor.capture());
        PostOffice captured = captor.getValue();
        Assertions.assertEquals(post3.getName(), captured.getName());
        Assertions.assertEquals(post3.getCityName(), captured.getCityName());
        Assertions.assertEquals(post3.getId(), captured.getId());
    }

    @Test
    public void whenDelete() {
        PostOffice post4 =new PostOffice();
        post4.setId(3);
        post4.setCityName("Rim");
        post4.setName("PePe");
        postOfficeService.addPostOffice(post4);

        verify(postOfficeRepository).save(captor.capture());
        PostOffice captured = captor.getValue();
        System.out.println(captured.getId());

        when(postOfficeRepository.findById(captured.getId()))
                .thenReturn(Optional.of(captured));
        when(postOfficeRepository.existsById(captured.getId()))
                .thenReturn(true);

        postOfficeService.deletePostOffice(captured.getId());

        Assertions.assertEquals(postOfficeService.getPostOffices().size(), 0);
    }
}
