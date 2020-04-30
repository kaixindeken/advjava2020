import java.util.ArrayList;
import java.util.List;

public class NormalMultiplication {

    public List<List<Double>> Multiply(List<List<Double>> m1, List<List<Double>> m2){
        int m = m1.size();
        List<List<Double>> res = new ArrayList<>();
        for (int i=0;i<m;i++){
            res.add(singleLine(m1.get(i),m2));
        }
        return res;
    }

    public List<Double> singleLine(List<Double> line ,List<List<Double>> m2){
        List<Double> res = new ArrayList<>();
        int p = m2.size();
        int n = m2.get(0).size();
        for (int i=0;i<n;i++){
            List<Double> col = new ArrayList<>();
            for (int j=0;j<p;j++){
                col.add(m2.get(j).get(i));
            }
            res.add(singleAtom(line,col));
        }
        return res;
    }

    public double singleAtom(List<Double> line, List<Double> column){
        double res=0;
        for (int i=0;i<line.size();i++){
            res+=line.get(i)*column.get(i);
        }
        return res;
    }
}
