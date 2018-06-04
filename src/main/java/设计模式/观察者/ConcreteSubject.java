package 设计模式.观察者;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangxiaoshuang
 * @date 2018/1/16 10:10
 */
public class ConcreteSubject implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(String message) {
        if(CollectionUtils.isNotEmpty(observers)) {
            for(Observer observer : observers) {
                observer.update(message);
            }
        }
    }
}
