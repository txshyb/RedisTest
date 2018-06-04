package cache.service;

import cache.Utils;
import entity.Person;
import entity.StaticsParam;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheServiceImpl implements CacheService{

    @Cacheable(value = "myCache")
    public int getMap() {
        int i=11;
        return i;
    }

    @CacheEvict(value = "myCache")
    public int clearMap() {
        return 111;
    }

    //    @Cacheable(value = "staticsObjInfo",key="#path")
    public Map getMap1(StaticsParam st,String path, String p) {


        HashMap map = new HashMap();
        map.put("ss","value");
        return new Utils().getMap("a");
    }

    @Cacheable(value="cacheTest",key="#param")
    public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }

}
