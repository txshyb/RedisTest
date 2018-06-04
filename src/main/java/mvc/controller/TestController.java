package mvc.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;

/**
 * @author tangxiaoshuang
 * @date 2018/1/22 16:09
 */
@Component("urlController")
@RequestMapping("/urlController")
public class TestController {

    @RequestMapping("/test/{str}")
    public String test(@PathVariable String str) {
        try {
            str = new String(str.getBytes("ISO-8859-1"), "utf8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
