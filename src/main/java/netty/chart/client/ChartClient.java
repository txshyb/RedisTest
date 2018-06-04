package netty.chart.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.EventExecutorGroup;
import netty.chart.ChartContextDecoder;
import netty.chart.ChartContextEncoder;
import netty.chart.entity.ChartContext;
import netty.chart.service.ChartService;
import netty.netty4.Time;

import java.util.Scanner;

/**
 * @author tangxiaoshuang
 * @date 2017/11/23 18:02
 */
public class ChartClient {
    static String id ;
    public Channel run() {
        Scanner sc = new Scanner(System.in);
         id = sc.nextLine();
        try {
            Bootstrap bootstrap = new Bootstrap();
            EventLoopGroup workGroup = new NioEventLoopGroup();
            bootstrap.group(workGroup)
                    .channel(NioSocketChannel.class)
           //         .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new ChartContextEncoder(id));
                            p.addLast(new ChartContextDecoder());
                            p.addLast(new ClientHandler());
                        }
                    });
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 3000).sync();
            Channel channel = channelFuture.channel();

            ChartContext message = new ChartContext();
            channel.writeAndFlush(message);
            return channel;
        }catch (Exception e) {

        }
        return  null;
    }

    private class ClientHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            super.channelActive(ctx);
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println((ChartContext)msg);
        }
    }

    public static void main(String[] args) {
        Channel channel = new ChartClient().run();
        Scanner sc = new Scanner(System.in);

        while(true) {
            String context = sc.nextLine();
            ChartContext message = new ChartContext(id,context,id);
            message.setTarget("2");
            channel.writeAndFlush(message);
        }
    }
}
