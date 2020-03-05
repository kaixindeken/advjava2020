import Component.Component;
import org.omg.CORBA.COMM_FAILURE;

public class Computer{

    private String name;
    private int price;
    private Component cpu;
    private Component memory;
    private Component hardDisk;
    private Component motherBoard;

    public Computer(String name, int price, Component cpu, Component memory, Component hardDisk, Component motherBoard) {
        this.name = name;
        this.price = price;
        this.cpu = cpu;
        this.memory = memory;
        this.hardDisk = hardDisk;
        this.motherBoard = motherBoard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Component getCpu() {
        return cpu;
    }

    public Component getMemory() {
        return memory;
    }

    public Component getHardDisk() {
        return hardDisk;
    }

    public Component getMotherBoard() {
        return motherBoard;
    }

    public void description(){
        cpu.description();
        memory.description();
        hardDisk.description();
        motherBoard.description();
    }

    public void work(){
        cpu.work();
        memory.work();
        hardDisk.work();
        motherBoard.work();
    }




}
