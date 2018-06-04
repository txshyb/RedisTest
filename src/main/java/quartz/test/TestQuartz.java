package quartz.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import quartz.job.MyJob;
import quartz.service.QuartzServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/spring-redis.xml"})
public class TestQuartz {

    @Autowired
    private QuartzServiceImpl quartzService;
    @Test
    public void test(){
        quartzService.add(new MyJob());

        while(true) {
            try {
                Thread.sleep(200000);
            } catch (Exception e) {

            }
        }
    }
}
