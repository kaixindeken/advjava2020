package Component.entity.CPU;

public class Intel extends CPU{
    public Intel(String name, int coreNum, int price){
        this.setName(name);
        this.setCoreNum(coreNum);
        this.setPrice(price);
    }
}
