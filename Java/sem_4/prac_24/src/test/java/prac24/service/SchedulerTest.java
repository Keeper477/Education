package prac24.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SchedulerTest {
    private SchedulerService schedulerService;
    @Mock
    private PostOfficeService postOfficeService;
    @Mock
    private DepartureService departureService;

    @Autowired
    public void setDataScheduler(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @Test
    public void checkDataFilesExist() throws IOException {
        schedulerService.doScheduledTask();

        String path = "out";
        File dir = ResourceUtils.getFile(path);
        verify(postOfficeService, times(1)).getPostOffices();
        verify(departureService, times(1)).getDepartures();
        assertTrue(dir.exists());
        String[] files = {"departure.txt", "postOffice.txt"};

        assertTrue(Arrays.stream(Objects.requireNonNull(dir.listFiles()))
                .map(File::getName)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList(files)));
    }
}
