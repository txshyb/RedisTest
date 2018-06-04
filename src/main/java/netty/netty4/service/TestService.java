package netty.netty4.service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutorGroup;
import netty.netty4.Time;
import netty.netty4.TimeDecoder;
import netty.netty4.TimeEncoder;

public class TestService {

    public static final int PORT = 3333;
    public void run() {

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            EventLoopGroup bossLoop = new NioEventLoopGroup();
            EventLoopGroup workerLoop = new NioEventLoopGroup();
            serverBootstrap.group(bossLoop, workerLoop);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline p = ch.pipeline();
                    p.addLast(new TimeEncoder());
                    p.addLast(new TimeDecoder());
                    p.addLast(new TimeHandler());
                }
            });
            serverBootstrap.option(ChannelOption.SO_BACKLOG, 128);
            serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
            //绑定端口，等待服务器接受链接
            ChannelFuture channelFuture = serverBootstrap.bind(PORT).sync();
            //等待服务器socket关闭
            channelFuture.channel().closeFuture().sync();
        }catch(Exception e) {
            e.printStackTrace();
        } finally {

        }
    }


    public static void main(String[] args) {
        new TestService().run();
    }


    private class ServiceHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("channelActive...");
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf byteBuf = (ByteBuf)msg ;
            System.out.println("channelRead...       " + msg.getClass()+"     "  );
            System.out.println((char)(byteBuf.readByte()));
            ctx.write(msg);
            ctx.flush();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            super.exceptionCaught(ctx, cause);
        }
    }

    private class TimeHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelActive(final ChannelHandlerContext ctx) throws Exception {

            Channel c = ctx.channel();

            System.out.println("channelActive...."+c.remoteAddress());
           ByteBuf b = ctx.alloc().buffer(4);
            b.writeInt((int)(System.currentTimeMillis()/1000L+2208988800L));
            final ChannelFuture channelFuture =  ctx.writeAndFlush(new Time());
            /*//添加监听器   此处关闭链接
            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    assert channelFuture == future;
                    ctx.close();
                }
            });*/
        }

        @Override
        public void channelRead(final ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("back");
        //    Channel c = ctx.channel();
         //   c.writeAndFlush(new Time());
         //   final ChannelFuture channelFuture =  ctx.writeAndFlush(new Time());
            //添加监听器   此处关闭链接
            /*channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    assert channelFuture == future;
                    ctx.close();
                }
            });*/
            System.out.println(msg);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            super.exceptionCaught(ctx, cause);
        }
    }
}
