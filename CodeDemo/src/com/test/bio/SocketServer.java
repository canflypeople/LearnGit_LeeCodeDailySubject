package com.test.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/4/14 上午9:11
 **/
public class SocketServer {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(9000);
    while (true) {
      System.out.println("等待连接");
      Socket socket = serverSocket.accept();
      System.out.println("有客户连接了");
      new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            handle(socket);
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }).start();
    }
  }

  private static void handle(Socket socket) throws IOException {
    System.out.println("thread id = " + Thread.currentThread().getId());
    byte[] bytes = new byte[1024];
    System.out.println("准备read");
    // 接受客户端数据， 阻塞方法， 没有数据可读时就阻塞
    int read = socket.getInputStream().read(bytes);
    System.out.println("read完毕");
    if (read != -1) {
      System.out.println("接受到客户端数据：" + new String(bytes, 0, read));
      System.out.println("thread id = " + Thread.currentThread().getId());
    }
    socket.getOutputStream().write("HelloClient".getBytes());
    socket.getOutputStream().flush();
  }
}
