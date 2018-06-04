package mvc.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author tangxiaoshuang
 * @date 2017/12/19 14:48
 */
@Repository("testDao")
public interface TestDao {
    List<Map> find();
}
