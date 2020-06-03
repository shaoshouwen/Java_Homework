import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {

  public static void main(String[] args) {

    File file = new File("/Users/edz/GitHub/shengtang-se/DevelopSupport/IO/practice-ans/CaesarCipher/alice.code");
    try {
      Socket socket = new Socket("127.0.0.1", 10000);
      System.out.println("客户端启动");
      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
      OutputStream dos = socket.getOutputStream();
      //再发送数据
      byte[] b = new byte[1024];
      int len = 0;
      while ((len = bis.read(b)) != -1) {
        dos.write(b, 0, len);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("客户端退出");
  }
}

