package 设计模式.观察者;

/**
 * @author tangxiaoshuang
 * @date 2018/1/16 10:16
 */
public class ConcreteObserver implements Observer  {
    @Override
    public void update(String message) {
        System.out.println(message);
    }
}
