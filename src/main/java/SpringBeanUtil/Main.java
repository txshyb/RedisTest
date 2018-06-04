package SpringBeanUtil;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author tangxiaoshuang
 * @date 2017/12/20 17:29
 */
public class Main {

    public static void main(String[] args) {
        Target target = new Qos("aaa","1");
        Target t = null;
        try {
            t = (Target) Qos.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(target,t);

        System.out.println(t);
        test();
    }


    public static void test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        System.out.println(list);
        Set<Integer> set = new HashSet<>();
        set.addAll(list);
        System.out.println(set);
        List<Integer> list1 = new ArrayList<>();
        list1.addAll(set);
        System.out.println(list1);
    }
}
