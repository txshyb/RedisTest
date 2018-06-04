package netty.service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class TestService {

    private static final int PORT = 3333;

    public void start() throws InterruptedException {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        serverBootstrap.group(bossGroup,workerGroup);
        serverBootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>(){
            @Override
            protected void initChannel(SocketChannel e) throws Exception {
                e.pipeline().addLast(new TestServiceHandler());
            }
        });

        ChannelFuture f = serverBootstrap.bind(PORT).sync();// 配置完成，开始绑定server，通过调用sync同步方法阻塞直到绑定成功
        System.out.println(TestService.class.getName() + " started and listen on " + f.channel().localAddress());
        f.channel().closeFuture().sync();// 应用程序会一直等待，直到channel关闭

        bossGroup.shutdownGracefully().sync();//关闭EventLoopGroup，释放掉所有资源包括创建的线程
        workerGroup.shutdownGracefully().sync();
    }


    public static void main(String[] args) throws Exception {

        new TestService().start();
    }

}
