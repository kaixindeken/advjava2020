import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Test {

    public static void main(String[] args) throws InterruptedException {

        System.out.print("请设置行列数最大值：");
        Scanner scanner = new Scanner(System.in);
        int max = scanner.nextInt();
        MatrixGenerator matrixGenerator = new MatrixGenerator(max);
        long started_at = System.currentTimeMillis();
        List<List<Double>> res = new NormalMultiplication().Multiply(matrixGenerator.getMatrix_1(),matrixGenerator.getMatrix_2());
        System.out.println("\nduration_serial = "+ ((System.currentTimeMillis() - started_at)/1000.0)+" s"+
                "\nresult_line_count = "+res.size()+
                "\nresult_col_count = "+res.get(0).size());

        int threadnum = 0;
        CountDownLatch countDownLatch = new CountDownLatch(threadnum);
        int m1_size = matrixGenerator.getMatrix_1().size();
        for (int i=1;i<10;i++){
            if (m1_size%i == 0){
                threadnum = i;
            }
        }
        System.out.println("\nthread_num = "+threadnum);
        int gap = m1_size / threadnum;
        List<List<Double>>[] result = new List[threadnum];
        started_at = System.currentTimeMillis();
        for (int i=0;i<threadnum;i++){
            MultithreadingMultiplication multithreadingMultiplication = new MultithreadingMultiplication(
                    matrixGenerator.getMatrix_1(),matrixGenerator.getMatrix_2(),i,gap,countDownLatch,result
            );
            multithreadingMultiplication.start();
        }
        countDownLatch.await();

        System.out.println(
                "duration_parallel = "+((System.currentTimeMillis()-started_at)/1000.0)+" s"+
//                        "\nresult_line_count = "+ (result.length*result[0].size()) +
//                        "\nresult_col_count = "+result[0].get(0).size()
                        "\nresult_line_count = "+res.size()+
                        "\nresult_col_count = "+res.get(0).size()
        );

    }

}
