package io.nio;

import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Channel {
    // File
    FileChannel fileChannel;
    // UDP
    DatagramChannel datagramChannel;
    // TCP worker
    SocketChannel socketChannel;
    // TCP boss
    ServerSocketChannel serverSocketChannel;

    public static void main(String[] args) {

    }
}
