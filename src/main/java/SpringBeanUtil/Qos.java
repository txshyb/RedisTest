package SpringBeanUtil;

/**
 * @author tangxiaoshuang
 * @date 2017/12/20 17:27
 */

public class Qos extends Target {

    private String flow;

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public Qos(String flow,String id) {
        super(id);
        this.flow = flow;
    }

    public Qos() {
    }
}
