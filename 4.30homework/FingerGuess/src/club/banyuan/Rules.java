package club.banyuan;

import java.util.Scanner;

public class Rules {
  static boolean willBackToMenu;//true为返回主界面，false为不返回主界面

  private static int countPlaysLeft;//游戏剩余人数

  public static int getCountPlaysLeft() { return countPlaysLeft; }

  public static void setCountPlaysLeft(int count) { countPlaysLeft = count; }

  //在两种出拳中找到胜利者
  //  12 21 = 1
  //         13 31 = 3
  //         23 32 = 2
  private static int getWinnerFinger(String rlt) {
    if ("12".equals(rlt) || "21".equals(rlt)) {
      return 1;
    } else if ("13".equals(rlt) || "31".equals(rlt)) {
      return 3;
    } else {
      return 2;
    }
  }

  //判断每一轮是否平局
  static boolean isDraw(String rlt) {
    return rlt.length() == 3 || rlt.length() == 1;
  }

  //每轮输出每个人的猜拳输赢，rlt是每轮不同的猜拳组成的字符串
  static void outPlayer(Player[] players, String rlt) {
    int winnerFinger = getWinnerFinger(rlt);//找出两种猜拳中的胜利者
    for (Player player : players) {
      if (!player.isOut() && player.getFinger() != winnerFinger) {
        player.setOut(true);
        int countLeft = getCountPlaysLeft();
        setCountPlaysLeft(countLeft - 1);//淘汰人时，将剩余游戏人数减1
        System.out.println(player.toString() + "输掉了");//注意，此处是在player类中重写了toString方法，要注意看调用toString方法的类的类型
      } else if (!player.isOut()) {
        System.out.println(player.toString() + "胜利");
      }
    }
    System.out.println();
  }

  static void showFingers(Player[] players) {
    System.out.printf("当前游戏%d人参与猜拳\n", Rules.getCountPlaysLeft());//每轮猜拳开始之前，输出当前参与游戏人数
    for (Player player : players) {
      if (player.isOut()) {
        continue;
      }
      player.showFinger();//每名玩家出拳
    }
  }

//将每一轮猜拳中不同的结果单拎出来放到一个字符串中，返回的时该字符串，此方法中toString是StringBuilder型调用的，
// StringBuilder定义了自己的toString方法
  static String competeResult(Player[] players) {
    StringBuilder rlt = new StringBuilder();
    for (Player player : players) {
      if (player.isOut()) {
        continue;
      }
      String oneFinger = player.getFinger() + "";
      if (!rlt.toString().contains(oneFinger)) {
        rlt.append(oneFinger);
      }
    }
    return rlt.toString();
  }

  //通过每个player的是否出局来判断是否猜拳游戏结束
  static boolean isFinalWinner(Player[] players) {
    int winnerCount = 0;
    for (Player player : players) {
      if (!player.isOut()) {
        winnerCount++;
      }
    }
    return winnerCount == 1;
  }

  static void printWinner(Player[] players) {
    // 输出获胜方
    for (Player player : players) {
      if (!player.isOut()) {
        if(Player.ROLE_HUMAN.equals(player.getRole())){
          System.out.println("获胜方是" + player.getRole() );
        }else {
          System.out.println("获胜方是" + player.getRole() + player.getId());
        }
      }
    }
  }

  public static int playersCountInit() {
    int playerCount;
    while(true){
      System.out.println("用户输入多少人参与猜拳（2~5人）。输入0退出程序");
      Scanner scanner = new Scanner(System.in);
      int a = scanner.nextInt();//先取出数字
      scanner.nextLine();//nextInt()无法不会自动消除后面的换行，而nextLine()可以
      if(a == 0){//输入0退出程序
        System.exit(0);
      }else if(a < 2 || a > 5){
        System.out.println("非法输入");
      }else{
        playerCount = a;
        break;
      }
    }
    return playerCount;
  }
}
