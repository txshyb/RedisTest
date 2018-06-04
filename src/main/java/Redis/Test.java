package Redis;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

/**
 * @author tangxiaoshuang
 * @date 2018/1/2 9:23
 */
public class Test {

    private static final Logger LOGGER = Logger.getLogger(Test.class);


    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("./spring/spring-dataSource.xml","./spring/applicationContext.xml","spring/spring-redis.xml");
        RedisTemplate redisTemplate = (RedisTemplate)context.getBean("stringRedisTemplate");
        Set<String> str  = redisTemplate.keys("[\\w\\W]*");
        redisTemplate.rename("app_rules_bak","app_app");
        LOGGER.info(str);
    }
}
