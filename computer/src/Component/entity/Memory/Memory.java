package Component.entity.Memory;

import Component.Component;

public class Memory implements Component {

    private String name;
    private double volume;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void work() {
        System.out.println("Memory Work");
    }

    @Override
    public void description() {
        System.out.println("Memory: "+this.getName()+" "+this.getVolume());
    }
}
