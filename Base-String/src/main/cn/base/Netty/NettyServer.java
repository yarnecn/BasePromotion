package cn.base.Netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @program: BasePromotion
 * @description:
 * @author: yarne
 * @create: 2019-07-30 17:46
 **/
public class NettyServer {

    private int port;

    public NettyServer(int port) {
        this.port=port;
    }

    public void start() throws InterruptedException {
        EventLoopGroup bossGroup=new NioEventLoopGroup();
        EventLoopGroup workGroup=new NioEventLoopGroup();
      try {
          ServerBootstrap serverBootstrap=new ServerBootstrap();
          serverBootstrap.group(bossGroup,workGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>(){
              @Override
              protected void initChannel(SocketChannel socketChannel) throws Exception {
                  socketChannel.pipeline().addLast(new DisCardServerHandler());
              }
          }).option(ChannelOption.SO_BACKLOG,128).childOption(ChannelOption.SO_KEEPALIVE,true);

          ChannelFuture sync = serverBootstrap.bind(port).sync();
          sync.channel().closeFuture().sync();
      }finally {
          workGroup.shutdownGracefully();
          bossGroup.shutdownGracefully();
      }

    }

    public static void main(String[] args) throws Exception{
        int port;
        if(args.length>0){
            port=Integer.parseInt(args[0]);
        }else{
            port=8080;
        }
        new NettyServer(port).start();
    }

}
