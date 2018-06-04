package sourcecode.spring.构造器循环依赖;

import org.springframework.stereotype.Component;

/**
 * @author tangxiaoshuang
 * @date 2018/5/7 17:23
 */
@Component
public class TestC {

    private TestA testA;

    public TestC(TestA testA) {
        this.testA = testA;
    }
}
