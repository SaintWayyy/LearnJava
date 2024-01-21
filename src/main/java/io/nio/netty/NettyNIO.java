package io.nio.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.List;

public class NettyNIO {
    private int port;
    private int maxConnection;

    public NettyNIO(int port, int maxConnection) {
        this.port = port;
        this.maxConnection = maxConnection;
    }

    public void start() {
        System.out.println("Bio server start");
        // EventLoopGroup for handling incoming connections
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // EventLoopGroup for handling the actual work
        EventLoopGroup workerGroup = new NioEventLoopGroup(maxConnection);
        try {
            // set up a Netty server
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(new ByteToMessageDecoder() {
                                @Override
                                protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

                                }
                            });

                            ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                                @Override
                                public void channelRead(ChannelHandlerContext ctx, Object msg) {
                                    System.out.println("Client request: " + msg.toString());
                                    ctx.writeAndFlush(msg);
                                }

                                @Override
                                public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
                                    // Close the connection when an exception is raised.
                                    cause.printStackTrace();
                                    ctx.close();
                                }
                            });

                            ch.pipeline().addLast(new MessageToByteEncoder<>() {

                                @Override
                                protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) {

                                }
                            });
                        }
                    })
                    //Sets the maximum number of queued incoming connections waiting to be accepted
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //Sets whether the server should keep connections alive
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            // Bind and start to accept incoming connections.
            ChannelFuture f = serverBootstrap.bind(port).sync();

            // Wait until the server socket is closed.
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Shut down all EventLoopGroups to terminate all threads
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        NettyNIO nettyNIO = new NettyNIO(6789, 5);
        nettyNIO.start();
    }
}
