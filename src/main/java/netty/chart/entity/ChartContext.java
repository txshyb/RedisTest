package netty.chart.entity;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author tangxiaoshuang
 * @date 2017/11/23 17:02
 */
public class ChartContext implements Serializable{

    private String channelId;

    private String context;

    private String msg;

    private String target;

    public ChartContext(String channelId, String context, String msg) {
        this.channelId = channelId;
        this.context = context;
        this.msg = msg;
    }

    public ChartContext() {

    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return msg + context;
    }
}
