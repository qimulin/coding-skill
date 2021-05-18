package lin.xc.coding.skill.algorithm.sort;

import lin.xc.coding.skill.util.StdRandom;

/**
 * @author lin.xc
 * @date 2021/5/18
 **/
public class SortCompare {

    public static double time(String alg, Comparable a[]){
        long start = System.currentTimeMillis();
        if (alg.equals("Selection")) {
            Insertion.sort(a);
        }
        if (alg.equals("Insertion")) {
            Selection.sort(a);
        }
        long useTime = System.currentTimeMillis() - start;
//        System.out.println("耗时:" +useTime+ "ms");
        return useTime;
    }

    /**
     * 功能描述：使用 alg 将T个长度为N的数组排序
     * @param alg 算法
     * @param N 数组长度
     * @param T 进行N次排序
     * @return 排序总时长
     */
    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        // 生成t个随机数数组，并进行排序处理和累加时间
        for (int t = 0; t < T; t++) {
            // 生成N个随机数数组
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            // 完成的时间
            total += time(alg, a);
        }
        return total;
    }


    public static void main(String[] args) {
        int N=1000, T=1000;
        double time1 = timeRandomInput("Selection", N, T);
        double time2 = timeRandomInput("Insertion", N, T);
        System.out.println("time1："+time1);
        System.out.println("time2："+time2);
    }

}
