package quartz.common;

/**
 * @author tangxiaoshuang
 * @date 2017/12/20 11:02
 */

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * 配置该类使job可以注入spring bean
 * 正常情况下如果不需要MyJob里注入对象，则不需要配置该类，MyJob也不需要交给spring管理
 *
 *  <bean id="jobFactory" class="quartz.common.JobFactory"></bean>
    <bean id="schedulerFactoryBean" class="org.springframework.scheduling.quartz.SchedulerFactoryBean">
        <property name="jobFactory" ref="jobFactory"></property>
    </bean>

 */
@Component
public class JobFactory extends AdaptableJobFactory {
    @Autowired
    private AutowireCapableBeanFactory capableBeanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        //调用父类的方法
        Object jobInstance = super.createJobInstance(bundle);
        //进行注入
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
