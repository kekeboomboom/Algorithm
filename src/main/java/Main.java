import com.sun.org.apache.xpath.internal.operations.Or;
import common.ListNode;
import common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @author keboom
 * @date 2021/9/3
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        System.out.println(Integer.parseInt("001"));

    }



    public int compareVersion(String version1, String version2) {
        List<Integer> v1 = Arrays.asList(version1.split(".")).stream().map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> v2 = Arrays.asList(version2.split(".")).stream().map(Integer::parseInt).collect(Collectors.toList());
        int index = 0;
        while (index < v1.size() && index < v2.size()) {
            Integer value1 = v1.get(index);
            Integer value2 = v2.get(index);
            index++;
            if (value1 == value2) {
                continue;
            } else if (value1 > value2) {
                return 1;
            } else {
                return -1;
            }
        }
        if (v1.size() == v2.size()) {
            return 0;
        } else if (v1.size() > v2.size()) {
            while (index < v1.size()) {
                if (v1.get(index) > 0) {
                    return 1;
                }
                index++;
            }
            return 0;
        } else {
            while (index < v2.size()) {
                if (v2.get(index) > 0) {
                    return -1;
                }
                index++;
            }
            return 0;
        }
    }
}
