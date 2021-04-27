package SwordPointToOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author keboom
 * @date 2021/3/12
 */
public class JZ13 {
    public int[] reOrderArray (int[] array) {
        // write code here
        List<Integer> ji = new ArrayList<>();
        List<Integer> ou = new ArrayList<>();
        int[] res = new int[array.length];
        for(int num:array){
            if(num%2==0){
                ou.add(num);
            }else{
                ji.add(num);
            }
        }
        ji.addAll(ou);
        for (int i = 0; i < ji.size(); i++) {
            res[i] = ji.get(i);
        }
        return res;

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Integer[] array = (Integer[]) list.toArray();

    }
}
