package other.exam.huaweiOD;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * {@code @author:} keboom
 * {@code @date:} 2024/1/9
 * {@code @description:}
 */
public class Solution2 {

    /**
     * 题目描述：
     * 一个文件目录的数据格=式为：目录id,本目录中文件大小，（子目录id列表）。其中目录id全局唯一，取值范围[1,200]，本目录中文件大小范围[1,1000]，子目录id列表个数
     * [0,10]
     * 例如：120(2,3)表示目录1中文件总大小是20，有两个子目录，1d分别是2和3
     * 现在输入一个文件系统中所有目录信息，以及待查询的目录d,返回这个目录和及该目录所有子目录的大小之和，
     *
     * 输入描述：第一行为两个数字M,N,分别表示目录的个数和待查询的目录id,1<=M<=100,1<=N<=200
     * 接下来M行，每行为1个目录的数据：目录id本目录中文件大小（子目录id列表），子目录列表中的子目录id以逗号分隔。
     * 输出描述：待查询目录及其子目录的大小之和
     *
     * 示例
     * 示例1
     * 输入：3 1
     * 3 15 ()
     * 1 20 (2)
     * 2 10 (3)
     * 输出：45
     * 说明：目录1大小为20，包含一个子目录2（大小为10），子目录2包含一个子目录3（大小为15），总的大小为20+10+15=45。
     *
     * 示例2
     * 输入：4 2
     * 4 20 ()
     * 5 30 ()
     * 2 10 (4,5)
     * 140 ()
     * 输出：60
     * 说明：目录2包含2个子目录4和5，总的大小为10+20+30=60
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 这一题用递归很合适，每次都查询当前目录的大小，递归查找自目录大小
        String[] s1 = scanner.nextLine().split(" ");
        Integer M = new Integer(s1[0]);
        Integer N = new Integer(s1[1]);
        Map dirsMap = new HashMap<Integer, Dir>(M);
        for (int i = 0; i < M; i++) {
            String[] s2 = scanner.nextLine().split(" ");
            Integer dirId = new Integer(s2[0]);
            Integer size = new Integer(s2[1]);
            Dir dir = new Dir();
            dir.dirId = dirId;
            dir.size = size;
            String substring = s2[2].substring(1, s2[2].length() - 1);
            if (!substring.isEmpty()) {
                String[] split = substring.split(",");
                int[] subDirs = new int[split.length];
                for (int j = 0; j < split.length; j++) {
                    subDirs[j] = new Integer(split[j]);
                }
                dir.subDirs = subDirs;
            }
            dirsMap.put(dirId, dir);
        }
        int sumSize = getSpecificDirSize(dirsMap, N);
        System.out.println(sumSize);
    }

    private static int getSpecificDirSize(Map<Integer, Dir> dirsMap, Integer N) {
        Dir curDir = dirsMap.get(N);
        int sum = curDir.size;
        if (curDir.subDirs != null) {
            for (int subDir : curDir.subDirs) {
                sum += getSpecificDirSize(dirsMap, subDir);
            }
        }
        return sum;
    }

    static class Dir {
        Integer dirId;
        Integer size;
        int[] subDirs;
    }
}
