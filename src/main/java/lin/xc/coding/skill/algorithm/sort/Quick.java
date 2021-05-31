package lin.xc.coding.skill.algorithm.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lin.xc
 * @date 2021/5/31
 **/
public class Quick extends SortBase {

    @Override
    public void sort(Comparable[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    /**
     * 递归方法，逐级将左右进行排序
     * */
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        // 切分，取出切分值坐标
        int j = partition(a, lo, hi);
//        System.out.println("partition="+j);
        // 将左半部分a[lo ~ j-1]排序
        sort(a, lo, j-1);
        // 将右半部分a[j+1 ~ hi]排序
        sort(a, j+1, hi);
    }

    private void shuffle(Comparable[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        // static void shuffle(List<?> list) 使用默认随机源对列表进行置换，所有置换发生的可能性都是大致相等的
        Collections.shuffle(list);
        list.toArray(nums);
        show(nums);
    }

    /**
     * @param a 数组
     * @param lo 开始
     * @param hi 结束
     * */
    private static int partition(Comparable[] a, int lo, int hi) {
        // 定义往右扫描的指针i
        int i = lo;
        // 定义往左扫描的指针j
        int j = hi + 1;
        // 初始定义v为最左边的元素
        Comparable v = a[lo];
        while (true) {
            // a[往右扫描指针]如果一直小于V，则一直往右扫
            while (less(a[++i], v)) {
                if (i == hi) break;
            }
            // a[往左扫描指针]如果一直大于V,则一直往左扫
            while (less(v, a[--j])) {
                if (j == lo) break;
            }
            // 当左扫描指针大于等于右扫描指针，就无需再比了
            if (i >= j){
                break;
            }
            // 每次一卡点，就是在v没有大于a[左扫描i]，且a[右扫描j]没有大于v的时候，做一次左右交换
            exchange(a, i, j);
        }
        // 此时j是个中间值坐标，上面都是拿a[lo]（即v）进行比较的，j左边都是小于a[lo]值的，j的右边都是大于a[lo]值的，所以把a[lo]和a[j]交换
        exchange(a, lo, j);
        return j;
    }

    public static void main(String[] args) {
        String[] a = new String[]{"03","03","04","07","09","11","12","16","01","05","06","06","08","11","12","13","17"};
        show(a);
        Quick quick = new Quick();
        quick.sort(a);
        show(a);
    }

}
