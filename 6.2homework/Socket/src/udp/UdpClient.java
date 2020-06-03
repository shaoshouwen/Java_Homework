package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {

  public static void main(String[] args) throws IOException {
    boolean isRunning = true;
    Scanner sc = new Scanner(System.in);
    DatagramSocket ds = new DatagramSocket();
    while (isRunning) {
      System.out.println("请上传：");
      String word = sc.nextLine();
      byte[] bytes = word.getBytes();
      DatagramPacket dp = new DatagramPacket(bytes, bytes.length,
          InetAddress.getByName("192.168.9.220"),
          10000);
      ds.send(dp);
    }
      ds.close();
  }
}
