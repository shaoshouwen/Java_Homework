package club.banyuan;

// TODO: 实现 Measurable 接口. getMeasure() 返回国家的人口总数. 提供构造方法，让DataSetTester运行正常
public class Country implements Measurable{
    private int county_counts;
   public double getMeasure(){
    return county_counts;
}

    public int getCounty_counts() {
        return county_counts;
    }

    public void setCounty_counts(int county_counts) {
        this.county_counts = county_counts;
    }
    public Country(int county_counts){
        this.county_counts = county_counts;
    }
}
