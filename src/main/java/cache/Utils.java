package cache;

import org.springframework.cache.annotation.Cacheable;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    @Cacheable(value = "staticsObjInfo",key="#path")
    public  Map getMap(String path){
        return new HashMap<>();
    }
}
