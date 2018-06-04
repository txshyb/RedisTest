package thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author tangxiaoshuang
 * @date 2018/1/17 17:00
 */
@Component
public class TestServiceImpl implements TestService{

    private Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);
    @Override
    @Async("myExecutor")
    public void asycnTest() {
        String name = Thread.currentThread().getName();
        logger.info(name + "   @Async start*********");
    }
}
