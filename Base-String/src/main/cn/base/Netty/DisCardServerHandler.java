package cn.base.Netty;


import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.util.ReferenceCountUtil;

/**
 * @program: BasePromotion
 * @description:
 * @author: yarne
 * @create: 2019-07-31 16:50
 **/
@ChannelHandler.Sharable
public class DisCardServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 通道读取到信息的时候被激活
     *
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf bmsg= (ByteBuf)msg;
        bmsg.clear().writeBytes("hello world".getBytes());
        ctx.write(bmsg);
        ctx.flush();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx)
            throws Exception {

    }
    /**
     * 异常情况被激活
     *
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
