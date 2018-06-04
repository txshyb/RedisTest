package queue;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author tangxiaoshuang
 * @date 2018/4/9 10:12
 */
public class QueueWrap {
    private static LinkedBlockingQueue<List<Integer>> queue = new LinkedBlockingQueue<List<Integer>>();

    public static void add(List<Integer> ids) throws InterruptedException {
        queue.put(ids);
    }

    public static List<Integer> take() throws InterruptedException {
        return queue.take();
    }
}
