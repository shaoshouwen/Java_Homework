package club.banyuan;

import com.sun.source.tree.ReturnTree;

public enum Weekday {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");
    private final String dayName;

    Weekday(String dayName) {
        this.dayName = dayName;
    }

    boolean isWeekDay() {

        return !(this.equals(SATURDAY) || this.equals(SUNDAY));
    }


    boolean isHoliday() {

        return !isWeekDay();
    }


    public String getDayName() {
        return dayName;
    }

    @Override
    public String toString() {
        return this.dayName;
    }

    public static void printMessage(Weekday weekday) {
        if (weekday.isHoliday()) {
            System.out.println(weekday + "是假日");
        } else {
            System.out.println(weekday + "不是假日");
        }
    }
}

