package thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tangxiaoshuang
 * @date 2018/1/17 16:59
 */
@Controller
@RequestMapping("/thread")
public class ThreadController {

    @Autowired
    private TestService testService;
    @RequestMapping("/test")
    public void test() {
        testService.asycnTest();
    }
}
