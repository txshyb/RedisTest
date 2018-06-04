package sourcecode.spring.构造器循环依赖;

import org.springframework.stereotype.Component;

/**
 * @author tangxiaoshuang
 * @date 2018/5/7 17:22
 */
@Component
public class TestA {

    private TestB testB;


    public TestA(TestB testB) {
        this.testB = testB;
    }
}
