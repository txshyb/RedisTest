package scheduled;

import mvc.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author tangxiaoshuang
 * @date 2017/11/21 17:05
 */
@Component
public class ScheduledTest {

    private static Logger logger = LoggerFactory.getLogger(ScheduledTest.class);

    @Autowired
    private TestService testService;
//    @Scheduled(cron="*/5 * * * * ?")
    public int test() {
        String name = Thread.currentThread().getName();
        logger.info(name + "   start***********************");

        List<Map> map = testService.find();
        logger.info(map.size()+"");
        return 110;
    }
}
