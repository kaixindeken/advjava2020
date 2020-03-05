package Component.entity.CPU;

import Component.Component;

public class CPU implements Component {

    private String name;
    private int coreNum;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoreNum() {
        return coreNum;
    }

    public void setCoreNum(int coreNum) {
        this.coreNum = coreNum;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void work() {
        System.out.println("CPU Work");
    }

    @Override
    public void description() {
        System.out.println("CPU: "+this.getName()+" "+this.getCoreNum());
    }
}
