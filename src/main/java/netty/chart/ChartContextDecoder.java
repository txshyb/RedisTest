package netty.chart;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import netty.chart.ChartContextConvert.ObjectConvert;
import netty.chart.entity.ChartContext;
import netty.netty4.Time;

import java.util.List;

/**
 * @author tangxiaoshuang
 * @date 2017/11/23 17:29
 */
public class ChartContextDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

            if (!in.hasArray()) {
                int len = in.readableBytes();
                if (len > 0) {
                    byte[] arr = new byte[len];

                    in.getBytes(0, arr);
                    ChartContext msg = ObjectConvert.byte2Obj(arr);

             //       System.out.println("decoder*****: "+msg.getContext());
                    out.add(msg);
                    in.clear();
                }
            }


    }
}
