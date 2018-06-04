package queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author tangxiaoshuang
 * @date 2018/4/9 13:59
 */
public class TaskRunnable implements Runnable {
    private static Logger logger = LoggerFactory.getLogger(TaskRunnable.class);
    @Override
    public void run() {
        while(true) {
            executeTask();
        }
    }

    private void executeTask() {
        try {
            logger.info(Thread.currentThread().getName());
            List<Integer> ids = QueueWrap.take();
            logger.info("ids:|{}",ids);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
