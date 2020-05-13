package club.banyuan;

import static club.banyuan.Weekday.printMessage;

public class Main {
    public static void main(String[] args) {
        for (Weekday one : Weekday.values()) {
            printMessage(one);
        }
        Weekday sat = Weekday.SATURDAY;
        for (Weekday day : Weekday.values()) {
            int num = day.compareTo(sat);
            if (num < 0) {
                System.out.println(day+"比"+sat+"小"+"相差"+num);
            } else if (num > 0) {
                System.out.println(day+"和"+sat+"大"+"相差"+num);
            } else {
                System.out.println(day+"和"+sat+"相等");
            }
        }
    }
}












