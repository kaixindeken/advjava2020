import Component.Component;
import Component.entity.CPU.AMD;
import Component.entity.CPU.Intel;
import Component.entity.HardDisk.Seagate;
import Component.entity.HardDisk.WestDigitals;
import Component.entity.Memory.Kingston;
import Component.entity.Memory.Samsung;
import Component.entity.MotherBoard.Asus;
import Component.entity.MotherBoard.Gigabyte;

public class ComputerStore {
    public static void ShowAll(Computer[] computers){
        for (Computer computer:computers) {
            System.out.println(computer.getName()+": ");
            computer.description();
            System.out.println("Price: "+computer.getPrice());
            computer.work();
            System.out.println();
        }
    }

    public static void main(String []args){
         Component intel = new Intel("i7",8,2000);
         Component amd = new AMD("RYZEN 5",8,1800);

         Component kingston = new Kingston("kingston",16,600);
         Component samsung = new Samsung("samsung",16,700);

         Component seagate = new Seagate("seagate",1024,500);
         Component westDigitals = new WestDigitals("westdigitals",1024,600);

         Component gigabyte = new Gigabyte("gigabyte",100,700);
         Component asus = new Asus("asus",100,800);

         Computer[] computers = new Computer[3];
         computers[0] = new Computer("co1",2000,intel,samsung,seagate,asus);
         computers[1] = new Computer("co2",2500,amd,kingston,westDigitals,gigabyte);
         computers[2] = new Computer("co3",3000,intel,samsung,seagate,gigabyte);

         ShowAll(computers);
    }
}
