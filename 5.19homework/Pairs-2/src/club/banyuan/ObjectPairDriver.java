package club.banyuan;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;

public class ObjectPairDriver {

    /**
     * 创建几个体育场对，然后打印容量最大的体育场名称。
     */

    public static void main(String[] args) {

        ObjectPair[] stadiums = new ObjectPair[3];
        stadiums[0] = new ObjectPair("五棵松", 25000);
        stadiums[1] = new ObjectPair("鸟巢", 109901);
        stadiums[2] = new ObjectPair("奥体中心", "66,233");

        System.out.println(stadiums[0]);
        System.out.println(largestStadium(stadiums));
    }

    /**
     * 返回容量最大的体育场的名称。
     *
     * @param stadiums ObjectPairs的数组，其中包含一个体育管名称，还有一个数字作为体育馆容量
     * @return
     */


    public static String largestStadium(ObjectPair[] stadiums) {
//        ObjectPair max = stadiums[0];
//        for (ObjectPair one : stadiums) {
//            if (Integer.parseInt(one.getSecond().toString().replace(",", ""))
//                    > Integer.parseInt(max.getSecond().toString().replace(",", ""))) {
//                max = one;
//            }
//        }
//        return max.getFirst().toString();
        ObjectPair max = stadiums[0];
        for (int i = 1; i < stadiums.length ; i++) {
            String a = stadiums[i].getSecond().toString().replace(",","");
            if(Integer.parseInt(max.getSecond().toString().replace(",","")) < Integer.parseInt(a)){
                max = stadiums[i];
            }
        }
        return max.getFirst().toString();



    }
}
