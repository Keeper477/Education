package prac23.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import prac23.model.Departure;
import prac23.model.PostOffice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
@Slf4j
@ManagedResource(
        objectName = "Practice23:category=MBeans,name=DataScheduler"
)
public class SchedulerService {

    @Autowired
    private PostOfficeService postOfficeService;

    @Autowired
    private DepartureService departureService;

    @Scheduled(cron = "0 0/30 * * * *")
    @ManagedOperation(description = "Overwrite files in out")
    public void doScheduledTask() throws IOException {
        System.out.println("Scheduled task");
        File file_dir = ResourceUtils.getFile("Java/sem_4/prac_23/src/main/resources/out");
        try {
            for (File file : file_dir.listFiles())
                if (file.isFile()) file.delete();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        BufferedWriter departureFile = new BufferedWriter(new FileWriter(file_dir.getAbsolutePath()
                + "/departure.txt"));
        BufferedWriter postOfficeFile = new BufferedWriter(new FileWriter(file_dir.getAbsolutePath()
                + "/postOffice.txt"));

        departureFile.write("id\tpostoffice_id\ttype\tdeparture date\n");
        for (Departure departure : departureService.getDepartures())
            departureFile.write(String.format("%d\t%d\t%s\t%s\n", departure.getId(), departure.getPostoffice_id(),
                    departure.getType(), departure.getDepartureDate()));
        departureFile.close();

        postOfficeFile.write("id\tname\tcity name\n");
        for (PostOffice postOffice : postOfficeService.getPostOffices())
            postOfficeFile.write(String.format("%d\t%s\t%s\n", postOffice.getId(), postOffice.getName(),
                    postOffice.getCityName()));
        postOfficeFile.close();
        log.info("Files overwritten");
    }

}
