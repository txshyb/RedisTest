package queue;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class SpringContextInitListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = Logger.getLogger(SpringContextInitListener.class);
    @Autowired
    @Qualifier("myExecutor")
    private TaskExecutor executor;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            logger.info("spring容器启动了");
            executor.execute(new TaskRunnable());
        }
    }

}
