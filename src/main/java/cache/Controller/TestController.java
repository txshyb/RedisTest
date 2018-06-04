package cache.Controller;


import cache.service.CacheService;
import entity.Person;
import entity.StaticsParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    private CacheService cacheService;
    @RequestMapping("/index")
    public String toIndex() {
        return "/index.jsp";
    }

    @RequestMapping("/cache")
    public Map getCache() {
        Person p = new Person("mike",20);

        StaticsParam st = new StaticsParam();
         cacheService.getMap1(st,"abc","abchdjhs");
         return new HashMap();
    }

    @RequestMapping("/cachetest")
    @ResponseBody
    public void cachetest() {
        cacheService.getMap();
    }

    @RequestMapping("/cleartest")
    @ResponseBody
    public void cleartest() {
        cacheService.clearMap();
    }
}
