package netty.chart.service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.EventExecutorGroup;
import netty.chart.ChartContextDecoder;
import netty.chart.ChartContextEncoder;
import netty.chart.entity.ChartContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tangxiaoshuang
 * @date 2017/11/23 17:01
 */
public class ChartService {

    private static int port = 3000;
    private static HashMap<String,Channel> channels = new HashMap<>();

    public void run() {

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        EventLoopGroup bossLoop = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        serverBootstrap.group(bossLoop,workGroup);
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline p = ch.pipeline();
                p.addLast(new ChartContextEncoder());
                p.addLast(new ChartContextDecoder());
                p.addLast(new ChartContextHandler());
            }
        });

     //   serverBootstrap.option(ChannelOption.SO_BACKLOG, 128);
        serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
        try {
            //绑定端口，等待服务器接受链接
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            //等待服务器socket关闭
            channelFuture.channel().closeFuture().sync();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private class ChartContextHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            Channel channel = ctx.channel();

            System.out.println(channel.remoteAddress()+"上线...");

        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            Channel channel = ctx.channel();
            ChartContext chartContext = (ChartContext)msg;
            if(chartContext.getTarget() == null) {
                channels.put(chartContext.getChannelId(), channel);
            } else {
                //  System.out.println("service: "+chartContext.getContext());
                String target = chartContext.getTarget();
                Channel c = channels.get(target);
//                for (Map.Entry<String, Channel> entry : channels.entrySet()) {
//                    ChartContext message = new ChartContext(ctx.channel().id().asLongText(), chartContext.getContext(), ctx.channel().remoteAddress() + "来信： ");
//                    entry.getValue().writeAndFlush(message);
//                }
               ChartContext message = new ChartContext(target,chartContext.getContext(),chartContext.getChannelId()+"来信： ");
               c.writeAndFlush(message);

            }
        }
    }


    public static void main(String[] args) {
        new ChartService().run();
    }
}


