package quartz.service;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import quartz.job.MyJob;

@Service
public class QuartzServiceImpl implements QuartzService{

    //Scheduler也可以通过gSchedulerFactory.getScheduler()获取，直接把下面add方法抽成工具类
    private static SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;
    @Override
    public void add(MyJob myjob) {
        try {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
           //  = gSchedulerFactory.getScheduler();
            JobDetail jobDetail = JobBuilder.newJob(myjob.getClass()).withIdentity("print", "group1").build();
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("print", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?")).build();
            scheduler.scheduleJob(jobDetail, trigger);
            if (!scheduler.isShutdown())
            {
                scheduler.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
