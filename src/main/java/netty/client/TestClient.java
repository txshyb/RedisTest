package netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TestClient {

    private String address;
    private int port;
    public TestClient() {

    }
    public TestClient(String address,int port) {
        this.address = address;
        this.port = port;
    }
    public Channel start() throws Exception{
        Bootstrap bootstrap = new Bootstrap();
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        bootstrap.group(eventLoopGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
     //   bootstrap.remoteAddress(address,port);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new TestClientHandler());
            }
        });

        ChannelFuture f = bootstrap.connect(address,port).sync();

        return f.channel();

}

    public static void main(String[] args) throws Exception {

        Channel channel = new TestClient("127.0.0.1", 3333).start();
        channel.writeAndFlush("heheh");
        channel.closeFuture().sync();
       /* f.channel().writeAndFlush();
        f.channel().closeFuture().sync();
        eventLoopGroup.shutdownGracefully().sync();*/
    }
}
