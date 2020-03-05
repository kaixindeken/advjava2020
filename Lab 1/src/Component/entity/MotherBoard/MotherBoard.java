package Component.entity.MotherBoard;

import Component.Component;

public class MotherBoard implements Component {

    private String name;
    private double speed;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void work() {
        System.out.println("Mother Board Work");
    }

    @Override
    public void description() {
        System.out.println("Mother Board: "+this.getName()+" "+this.getSpeed());
    }
}
