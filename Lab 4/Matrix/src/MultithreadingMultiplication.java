import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class MultithreadingMultiplication extends Thread{

    private List<List<Double>> m1;
    private List<List<Double>> m2;
    private int index;
    private int gap;
    private CountDownLatch countDownLatch;
    private List<List<Double>>[] res;

    public MultithreadingMultiplication(
            List<List<Double>> m1, List<List<Double>> m2, int index, int gap, CountDownLatch countDownLatch, List<List<Double>>[] res
    ){
        this.m1=m1;
        this.m2=m2;
        this.index=index;
        this.gap=gap;
        this.res=res;
        this.countDownLatch=countDownLatch;
    }

    public void run(){
        List<List<Double>> re = new ArrayList<>();
        for (int i = index*gap;i<(index+1)*gap;i++){
            re.add(new NormalMultiplication().singleLine(m1.get(i),m2));
        }
        res[index] = re;
        countDownLatch.countDown();
    }

}
