package netty.netty4.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.EventExecutorGroup;
import netty.netty4.Time;
import netty.netty4.TimeDecoder;
import netty.netty4.TimeEncoder;

import java.util.Date;
import java.util.Scanner;

public class TestClient {

    public void run() {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new TimeEncoder());
                            p.addLast(new TimeDecoder());
                            p.addLast(new ClientHandler());
                        }
                    });
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 3333).sync();
            Scanner in = new Scanner(System.in);
            while(true) {
                if(in.hasNextLine()) {
                    in.nextLine();
                    channelFuture.channel().writeAndFlush(new Time());
                }
            }
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
        }
    }
    public static void main(String[] args) {
            new TestClient().run();
    }
    private class ClientHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            super.channelActive(ctx);
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            try {
                System.out.println((Time)msg);
                /*ByteBuf byteBuf = (ByteBuf) msg;
                System.out.println(new Date((byteBuf.readUnsignedInt()-2208988800L)*1000L));*/
                ByteBuf b = ctx.alloc().buffer(4);
                b.writeInt((int)(System.currentTimeMillis()/1000L+2208988800L));
                final ChannelFuture channelFuture =  ctx.writeAndFlush(new Time());

            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            super.exceptionCaught(ctx, cause);
        }
    }
}
