package Redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("./spring/spring-dataSource.xml","./spring/applicationContext.xml","spring/spring-redis.xml");
        TestPublish test = (TestPublish)context.getBean("testPublish");
        while (true){
            Thread.sleep(2000000);
        }

    }
}
