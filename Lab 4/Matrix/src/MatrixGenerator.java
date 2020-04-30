import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatrixGenerator {

    private List<List<Double>> matrix_1 = new ArrayList<>();
    private List<List<Double>> matrix_2 = new ArrayList<>();

    //m行p列，p行n列
    public MatrixGenerator(int max){
        int m = new Random().nextInt(max);
        int p = new Random().nextInt(max);
        int n = new Random().nextInt(max);
        System.out.println("m="+m+"\np="+p+"\nn="+n);
        for (int i=0;i<m;i++){
            this.matrix_1.add(
                    LineGen(p)
            );
        }
        for (int i=0;i<p;i++){
            this.matrix_2.add(
                    LineGen(n)
            );
        }
    }

    public List<Double> LineGen(int width){
        List<Double> line = new ArrayList<>();
        for (int i=0;i<width;i++){
            line.add(new Random().nextDouble());
        }
        return line;
    }

    public List<List<Double>> getMatrix_1() {
        return matrix_1;
    }

    public List<List<Double>> getMatrix_2() {
        return matrix_2;
    }
}
