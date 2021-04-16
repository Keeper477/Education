package prac24.service;


import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import prac24.model.Departure;
import prac24.repositories.DepartureRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DepartureTest {
    @MockBean
    private DepartureRepository departureRepository;

    @Captor
    private ArgumentCaptor<Departure> captor;
    private DepartureService departureService;

    @Autowired
    public void setDepartureService(DepartureService departureService) {
        this.departureService = departureService;
    }

    private final List<Departure> departures = new ArrayList<>();

    @Before
    public void setUp() {
        Departure departure1 = new Departure();
        departure1.setId(0);
        departure1.setDepartureDate("13/09/2021");
        departure1.setPostoffice_id(1);
        departure1.setType("Hm");

        Departure departure2 = new Departure();
        departure2.setId(1);
        departure2.setDepartureDate("12/09/2021");
        departure2.setPostoffice_id(1);
        departure2.setType("nehm");

        departures.add(departure1);
        departures.add(departure2);

        when(departureRepository.findAll())
                .thenReturn(departures);
    }

    @Test
    public void whenGetDepartures() {
        List<Departure> fetched = departureService.getDepartures();

        verify(departureRepository, times(1))
                .findAll();
        Assertions.assertEquals(departures.size(), fetched.size());
    }

    @Test
    public void addDeparture() {
        Departure departure = new Departure();
        departure.setId(1);
        departure.setDepartureDate("13/09/2021");
        departure.setPostoffice_id(1);
        departure.setType("Hm");
        departureService.addDeparture(departure);

        verify(departureRepository).save(captor.capture());
        Departure captured = captor.getValue();
        Assertions.assertEquals(departure.getDepartureDate(), captured.getDepartureDate());
        Assertions.assertEquals(departure.getId(), captured.getId());
        Assertions.assertEquals(departure.getType(), captured.getType());
        Assertions.assertEquals(departure.getPostoffice_id(), captured.getPostoffice_id());
    }

    @Test
    public void whenDelete() {
        Departure departure = new Departure();
        departure.setId(1);
        departure.setDepartureDate("13/09/2021");
        departure.setPostoffice_id(1);
        departure.setType("Hm");
        departureService.addDeparture(departure);

        verify(departureRepository).save(captor.capture());
        Departure captured = captor.getValue();
        System.out.println(captured.getId());

        when(departureRepository.findById(captured.getId()))
                .thenReturn(Optional.of(captured));
        when(departureRepository.existsById(captured.getId()))
                .thenReturn(true);

        departureService.deleteDeparture(captured.getId());

        Assertions.assertEquals(departureService.getDepartures().size(), 0);
    }
}
