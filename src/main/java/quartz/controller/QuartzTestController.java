package quartz.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import quartz.job.MyJob;
import quartz.service.QuartzServiceImpl;

@Controller
public class QuartzTestController {
    @Autowired
    private QuartzServiceImpl quartzService;

    @RequestMapping("/quartz")
    public void test() {
        quartzService.add(new MyJob());
    }
}

