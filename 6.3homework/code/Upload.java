import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Upload {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    File file = new File(
        "/Users/edz/GitHub/shengtang-se/DevelopSupport/IO/practice-ans/CaesarCipher/alice.code");

    try {
      Socket socket = new Socket("127.0.0.1", 10000);
      System.out.println("客户端启动");
      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
      OutputStream dos = socket.getOutputStream();
      //再发送数据
      byte[] b = new byte[1024];

      while ( bis.read(b) != -1) {
        String str = new String(b);
        char[] ch = str.toCharArray();
        for (char one : ch) {
          dos.write(Decode.caesarDecode(one));
        }

      }
      System.out.println("加密上传结束");

//      InputStream in = socket.getInputStream();
//      byte[] bytes = in.readAllBytes();
//      System.out.println("来自服务器的消息:" + new String(bytes));

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("客户端退出");


  }
}
