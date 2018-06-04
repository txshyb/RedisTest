package mvc.service;

import mvc.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author tangxiaoshuang
 * @date 2017/12/19 14:50
 */
@Service("testService")
public class TestServiceImpl implements TestService {
    @Autowired
    @Qualifier("testDao")
    private TestDao testDao;
    @Override
    public List<Map> find() {
        return testDao.find();
    }
}
