package Redis;

import entity.Person;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TestPublish {

    private static final Logger LOGGER = Logger.getLogger(TestPublish.class);

    @Autowired
    private RedisTemplate redisTemplate;

    //可通过RedisConfig注入，也可通过spring-redis.xml注入
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void publicMessage() {
     //   redisTemplate.convertAndSend("test","hehe");
        Person p = new Person("mike",20);
        //test为topic
        redisTemplate.convertAndSend("test",p);
    }

  /*  public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {

        this.redisTemplate = redisTemplate;
    }

    public StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }*/
}
