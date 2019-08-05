package cn.base.Netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @program: BasePromotion
 * @description:
 * @author: yarne
 * @create: 2019-07-31 17:18
 **/
public class ClientNetty {
    private final int port;

    public ClientNetty(int port) {
        this.port = port;
    }

    public static void main(String[] args) {

    }


    public void start(int port) {
       /* EventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(nioEventLoopGroup).channel(NioSocketChannel.class).connect()*/
    }


}
