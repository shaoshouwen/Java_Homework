package club.banyuan;

public class Main {
    public static void main(String[] args) {
        Cake[] cakeArray = new Cake[10];
        //前五个蛋糕是OrderCake类，称重卖
        //后五个蛋糕是ReadyMadeCake类，按数量卖

        //输入Cake对象的数据并将其存储到数组中
        for(int i = 0; i < 5; i++){
            Cake cake = new OrderCake(i + 1, 20, 0.1 * (i + 1));
            cakeArray[i] = cake;
        }
        for(int i = 5; i < 10;i++){
            Cake cake = new ReadyMadeCake(i + 1, 2, 1);
            cakeArray[i] = cake;
        }

        //显示所有蛋糕的总价
        double overallPrice = 0;
        for(int i = 0; i < 10; i++){
            overallPrice = overallPrice + cakeArray[i].calcPrice();
        }
        System.out.println("所有蛋糕的总价为" + overallPrice);

        //显示ReadyMadeCake蛋糕的总价和数量之和
        double overallPriceOfReadyMadeCake = 0;
        for(int i = 5; i < 10; i++){
            overallPriceOfReadyMadeCake = overallPriceOfReadyMadeCake + cakeArray[i].calcPrice();
        }
        System.out.println("ReadyMadeCake蛋糕的总价为" + overallPriceOfReadyMadeCake + "  " + "总数量为5");

        //显示最高价格出售的蛋糕的信息
        Cake highestPriceCake = cakeArray[0];
        for(int i = 1; i < 10; i++){
            if(cakeArray[i].calcPrice() > highestPriceCake.calcPrice()){
                highestPriceCake = cakeArray[i];
            }
        }
        System.out.println("价格最高的蛋糕：");
        System.out.println("编号:  " + highestPriceCake.id);
        System.out.println("售价： " + highestPriceCake.calcPrice());

    }
}
