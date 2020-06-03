import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receive {

  public static void main(String[] args) throws IOException {

    try {
      ServerSocket serverSocket = new ServerSocket(10000);
      System.out.println("服务器启动");
      Socket socket = serverSocket.accept();
      String hostAddress = socket.getInetAddress().getHostAddress();
      System.out.println(hostAddress + " 客户端接入。。");

      InputStream inputStream = socket.getInputStream();
      String pathName = "./alice.code1";
      byte[] bytes = new byte[1024];
      int count;
      OutputStream outputStream = new FileOutputStream(pathName);
      while ((count = inputStream.read(bytes)) != -1) {
        outputStream.write(bytes, 0, count);
      }

//      OutputStream out = socket.getOutputStream();
//      out.write("消息收到了!".getBytes());



    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}

