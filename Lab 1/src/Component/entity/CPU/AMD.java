package Component.entity.CPU;

import Component.Component;

public class AMD extends CPU {
    public AMD(String name, int coreNum, int price){
        this.setName(name);
        this.setCoreNum(coreNum);
        this.setPrice(price);
    }
}
