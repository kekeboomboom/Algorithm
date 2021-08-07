package other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


/**
 * @author keboom
 * @date 2021/7/21
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(",");
        int[] rains = new int[strings.length];
        rains[0]=Integer.valueOf(strings[0].charAt(1)-'0');
        for (int i = 1; i < strings.length-1; i++) {
            rains[i] = Integer.valueOf(strings[i]);
        }
        rains[strings.length - 1] = Integer.valueOf(strings[strings.length - 1].charAt(0) - '0');
//        System.out.println(Arrays.toString(rains));
        int[] ans = new int[rains.length];
        process(rains, ans);
        System.out.println(Arrays.toString(ans));
    }

    private static void process(int[] rains, int[] ans) {
        HashSet<Integer> rained = new HashSet<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] != 0) {
                if (rained.contains(rains[i])) {
                    ans = new int[rains.length];
                    return;
                }
                ans[i] = -1;
                rained.add(rains[i]);
            } else {
                for (int j = i+1; j < rains.length; j++) {
                    if (rains[j] != 0 && rained.contains(rains[j])) {
                        ans[i] = rains[j];
                        rained.remove(rains[j]);
                        break;
                    }
                }
            }
        }
    }
}
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String[] split = s.split(",");
//        String[] last = split[split.length - 1].split(":");
//        int[] arr = new int[split.length];
//        int k = Integer.valueOf(last[1]);
//        for (int i = 0; i < split.length-1; i++) {
//            arr[i] = Integer.valueOf(split[i]);
//        }
//        arr[split.length - 1] = Integer.valueOf(last[0]);
//
//        maxP(arr, k);
//
//    }
//
//    private static void maxP(int[] arr, int k) {
//        double maxRes = 0;
//        double sum = arr[0] + arr[1] + arr[2];
//        double prejun = sum / k;
//        double curjun = 0;
//        for (int i = 3; i < arr.length; i++) {
//            sum = sum + arr[i] - arr[i-k];
//            curjun = sum / k;
//            if ((curjun - prejun) / prejun > maxRes) {
//                maxRes = (curjun - prejun) / prejun;
//            }
//            prejun = curjun;
//        }
//        maxRes *= 100;
//        DecimalFormat df = new DecimalFormat("#.00");
//        String res = df.format(maxRes);
//        System.out.println(res+"%");
//    }


/*
需求：一个工程的技术OR产品需求

任务：根据需求拆解可执行落地的实际任务

以下为任务表

id（任务ID）	demand_id（需求ID）	name（任务名称）
1	1	xxx
2	1	xxx
3	2	xxx
写一段SQL语句查出2个任务（含）以上的需求ID以及对应的任务数量

查询结果格式如下

demand_id（需求ID）	count（数量）
1	2
3	5
10	3

select demand_id, count(id) as count
from Task
group by demand_id
having count > 1;
 */

/*
一个自然数数组arr，有大小为k的数据滑动窗口从数组头部往数组尾部滑动，窗口每次滑动一位，窗口最后一位到达数组末尾时滑动结束。

窗口每次滑动后，窗口内k个整数的平均值相比滑动前会有一个变化幅度百分比p。

过程如下：

滑动窗口位置                                                  窗口平均值        平均值增幅

----------------------------------       -------         --------

[5  6  8] 26  50  48  52  55  10  1  2  1  20  5          6.33

 5 [6  8  26] 50  48  52  55  10  1  2  1  20  5          13.33                   110.53%

 5  6 [8  26  50] 48  52  55  10  1  2  1  20  5          28.00                   110.00%

 5  6  8 [26  50  48] 52  55  10  1  2  1  20  5          41.33                   47.62%

 5  6  8  26 [50  48  52] 55  10  1  2  1  20  5          50.00                   20.97%

 5  6  8  26  50 [48  52  55] 10  1  2  1  20  5          51.67                   3.33%

 5  6  8  26  50  48 [52  55  10] 1  2  1  20  5          39.00                   -24.52%

 5  6  8  26  50  48  52 [55  10  1] 2  1  20  5          22.00                   -43.59%

 5  6  8  26  50  48  52  55 [10  1  2] 1  20  5          4.33                     -80.30%

 5  6  8  26  50  48  52  55  10 [1  2  1] 20  5          1.33                     -69.23%

 5  6  8  26  50  48  52  55  10  1 [2  1  20] 5          7.67                     475.00%

 5  6  8  26  50  48  52  55  10  1  2 [1  20  5]        8.67                     13.04%

 样例输入
5,6,8,26,50,48,52,55,10,1,2,1,20,5:3
样例输出
475.00%


 */


/*
你的省份有多个湖泊，所有湖泊一开始都是空的。当第 n 个湖泊下雨的时候，如果第 n 个湖泊是空的，那么它就会装满水，否则这个湖泊会发生洪水。你的目标是避免任意一个湖泊发生洪水



输入描述
给你一个整数数组 rains ，其中：

rains[i] > 0 表示第 i 天时，第 rains[i] 个湖泊会下雨。

rains[i] == 0 表示第 i 天没有湖泊会下雨，你可以选择 一个 湖泊并 抽干 这个湖泊的水

输出描述
返回一个数组 ans ，满足：

ans.length == rains.length

如果 rains[i] > 0 ，那么ans[i] == -1 。

如果 rains[i] == 0 ，ans[i] 是你第 i 天选择抽干的湖泊。

如果有多种可行解，请返回它们中的 任意一个 。如果没办法阻止洪水，请返回一个 空的数组


样例输入
[1,2,0,0,2,1]
样例输出
[-1,-1,2,1,-1,-1]


 */

/*
要求：

1. 请使用多线程重写translatedAll方法来提升翻译速度

2. 请注意翻译后的line的前后顺序要和输入的List<line>的顺序保持一致，因为字幕的顺序是不能乱的

样例输入
aaa,bbb,ccc
样例输出
AAA,BBB,CCC


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.stream.Collectors;


public class Main {


    public static void main(String[] args) throws InterruptedException {
        Solution s = new Solution();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10000));
        final Scanner reader = new Scanner(System.in);
        final String next = reader.next();
        List<Line> lines = Arrays.stream(next.split(",")).map(str -> new StringLine(str))
                .collect(Collectors.toList());
        List<Line> result = s.translateAll(lines, "", threadPoolExecutor);
        String resultString = result.stream().map(l -> l.toString()).collect(Collectors.joining(","));
        System.out.println(resultString);
        reader.close();
        threadPoolExecutor.shutdown();
    }

    public interface Line {
        /**
         * translate the line to the specific language
         * @param language - the language to translate
         * @return the line of translated by the {@code language} */
Line translate(String language);
}

public static class Solution {
    /**
     * translate the all lines to the specific language
     * @param lines the text lines of episode
     * @param language the language to translate
     * @return the lines of translated by the {@code language} */
    public List<Line> translateAll(List<Line> lines, String language, Executor executor) throws InterruptedException {
        Job<Line> job = new Job<>();
        for (Line line : lines) {
            Callable<Line> callable = () -> line.translate(language);
            job.newTask(callable);
        }
        job.execute(executor);
        return job.get();
    }
}

public static class Job<V> {

    public void newTask(Callable<V> runnable) {
        //待实现
    }


    public void execute(Executor executor) {
        //待实现
    }

    public List<V> get() throws InterruptedException {
        //待实现
    }

}

/**
 * translate the string line to upper case
 */
public static class StringLine implements Line {
    private String text;

    public StringLine(String text) {
        this.text = text;
    }

    @Override
    public Line translate(String language) {
        return new StringLine(text.toUpperCase());
    }


    @Override
    public String toString() {
        return text;
    }
}
}

 */