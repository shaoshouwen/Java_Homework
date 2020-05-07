package club.banyuan;

public class ReadyMadeCake extends Cake{
    private int quantity;

    //子类构造方法
    public ReadyMadeCake(int n, double r,int quantity){
        super(n, r);
        this.quantity = quantity;
    }

    //重写价格计算方法
    public double calcPrice(){
        return price * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
