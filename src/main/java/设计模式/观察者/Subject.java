package 设计模式.观察者;

/**
 * @author tangxiaoshuang
 * @date 2018/1/16 10:08
 */
public interface Subject {
    /**
     *增加订阅者
     * @param observer
     */
    void attach(Observer observer);

    /**
     * 删除订阅者
     * @param observer
     */
    void detach(Observer observer);

    /**
     * 通知
     * @param message
     */
    void notify(String message);
}
