package cn.base.Netty;


import io.netty.buffer.ByteBuf;
import io.netty.channel.*;

/**
 * @program: BasePromotion
 * @description:
 * @author: yarne
 * @create: 2019-07-31 16:50
 **/
@ChannelHandler.Sharable
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

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

    /**
     * 链接创建的时候被激活
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        final ByteBuf time = ctx.alloc().buffer();
        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
        //(3)
        final ChannelFuture f = ctx.writeAndFlush(time);
        f.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) {
                assert f == future;
                ctx.close();
            }
        });
    }
}
