package com.test.bio;

import java.io.IOException;
import java.net.Socket;

/**
 * @program:
 * @description:
 * @author: zhongmou.ji
 * @create: 2021/4/14 上午9:18
 **/
public class SocketClient {
  public static void main(String[] args) throws IOException, InterruptedException {
    int count = 0;
    while (true) {
      Socket socket = new Socket("localhost", 9000);
      // 向服务端发送数据
      socket.getOutputStream().write("HelloServer".getBytes());
      socket.getOutputStream().flush();
      System.out.println("向服务端发送数据结束");
      byte[] bytes = new byte[1024];
      // 接受服务端回传的数据
      socket.getInputStream().read(bytes);
      System.out.println("接收到服务端的数据：" + new String(bytes));
      if (count++ > 10) {
        break;
      }
      socket.close();
    }


  }
}
