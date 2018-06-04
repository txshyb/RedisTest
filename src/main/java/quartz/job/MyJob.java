package quartz.job;

import mvc.service.TestServiceImpl;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class MyJob implements Job {

    @Autowired
    private TestServiceImpl testService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(jobExecutionContext+"*************************************");
        testService.find();
    }
}
