package MapSort;

import java.util.*;

public class MapSort {

    public static List<Map.Entry<String,Integer>> sortByValueIntegerDesc(Map<String, Integer> nowPartTwoData){
        //这里将map.entrySet()转换成list
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(nowPartTwoData.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
             //降序排序
             @Override
             public int compare(Map.Entry<String, Integer> o1,
                                Map.Entry<String, Integer> o2) {
                 return o2.getValue().compareTo(o1.getValue());
             }
         });
        return list;
    }

}
