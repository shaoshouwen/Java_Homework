package club.banyuan;

public class OrderCake extends Cake{
    private double weightInKG;

    //子类构造方法
    public OrderCake(int n, double r,double weight){
        super(n, r);
        this.weightInKG = weight;
    }

    //重写加个计算方法
    public double calcPrice(){
        return price * weightInKG;
    }

    public double getWeightInKG() {
        return weightInKG;
    }

    public void setWeightInKG(double weightInKG) {
        this.weightInKG = weightInKG;
    }

}
