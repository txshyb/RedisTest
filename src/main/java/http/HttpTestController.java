package http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tangxiaoshuang
 * @date 2017/12/14 15:37
 */
@Controller
public class HttpTestController {
    Logger logger = LoggerFactory.getLogger(HttpTestController.class);

    @RequestMapping("/httpTest")
    @ResponseBody
    public void httpTest(String name) {
        logger.info(name+"httpTest++++++++++++++++++++++++++++++++");
    }
}
