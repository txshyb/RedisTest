package cache.service;

import entity.Person;
import entity.StaticsParam;

import java.util.Map;

public interface CacheService {

    public int getMap() ;

    public Map getMap1(StaticsParam st ,String path, String p);

    public String getTimestamp(String param);

    public int clearMap();
}
