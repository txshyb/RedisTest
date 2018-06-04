package netty.chart;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import netty.chart.ChartContextConvert.ObjectConvert;
import netty.chart.entity.ChartContext;

/**
 * @author tangxiaoshuang
 * @date 2017/11/23 17:30
 */
public class ChartContextEncoder extends MessageToByteEncoder<ChartContext> {
    private String id;
    public ChartContextEncoder(String id) {
        this.id = id;
    }
    public ChartContextEncoder() {
    }
    @Override
    protected void encode(ChannelHandlerContext ctx, ChartContext msg, ByteBuf out) throws Exception {
        //System.out.println("encoder*****: "+msg.getContext());
        msg.setChannelId(id);
        out.writeBytes(ObjectConvert.object2byte(msg));
    }
}
