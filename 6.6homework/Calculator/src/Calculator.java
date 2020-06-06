import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean vaule = true;
    while (vaule) {
      System.out.println("请输入表达式:");
      String regex = "(^[0-9]\\.[0-9]*) <([+-\\\\*/%])> ([0-9]\\.[0-9]*$)";
      String test = scanner.nextLine();
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(test);
//    System.out.println(matcher.group(1));
      if (matcher.find()) {

        double sum, dif, pro, quo, mod = 0;
        switch (matcher.group(2)) {
          case "+":
            sum = Double.parseDouble(matcher.group(1)) + Double.parseDouble(matcher.group(3));
            System.out.println("和为" + sum);
            break;
          case "-":
            dif = Double.parseDouble(matcher.group(1)) - Double.parseDouble(matcher.group(3));
            System.out.println("差为" + dif);
            break;
          case "*":
            pro = Double.parseDouble(matcher.group(1)) * Double.parseDouble(matcher.group(3));
            System.out.println("乘积为" + pro);
            break;
          case "/":
            quo = Double.parseDouble(matcher.group(1)) / Double.parseDouble(matcher.group(3));
            System.out.println("商为" + quo);
            break;
          case "%":
            mod = Double.parseDouble(matcher.group(1)) % Double.parseDouble(matcher.group(3));
            System.out.println("取模为" + mod);
            break;

        }
      } else if("quit".equals(test)){
        vaule=false;
        System.out.println("退出");
      }
      else {
        System.out.println("输入不合法");
      }
    }
  }
}

