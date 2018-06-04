package Redis.StringTemplate;

import Redis.TestListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource(value = {"classpath:redis.properties"},encoding="utf-8")
public class RedisConfig {

    @Value("${redis.pool.maxActive}")
    private int maxActive;

    @Value("${redis.pool.maxIdle}")
    private int maxIdle;

    @Value("${redis.pool.maxWait}")
    private int maxWait;

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private int port;

    @Value("${redis.default.db}")
    private int db;

    @Bean
    public JedisConnectionFactory jedisConnFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWait);

        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        jedisConnectionFactory.setHostName(host);
        jedisConnectionFactory.setPort(port);
        jedisConnectionFactory.setDatabase(db);
        return jedisConnectionFactory;
    }

    @Bean(value = "stringRedisTemplate")
    public StringRedisTemplate getStringRedisTemplate() {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(jedisConnFactory());
        return stringRedisTemplate;
    }


    @Bean(value = "stringRedisTemplate")
    public StringRedisTemplate getStringRedisTemplate(JedisConnectionFactory jedisConnFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(jedisConnFactory);
        return stringRedisTemplate;
    }

}
