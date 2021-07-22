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
//        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    /**
     * 递归方法，逐级将左右进行排序
     * 右扫比V大，要排V的右边，就肯定需要一次交换，看下一个右扫元素是否（比V小）可以拿来交换; 比V小，继续右扫，直至遇到比V大的元素，再进行右扫
     * 左扫比V小，要排V的左边，就肯定需要一次交换，则配合右扫做交换；比V大，继续左扫，直至遇到比V小的元素，再配合右扫当前元素交换
     * 跳出节点：当左指针大于等于右指针（情况包括一直右扫无左扫，至最右边；一直左扫至最左边无右扫；部分右扫部分左扫三种情况）
     * 示例演示：
     * 以数组arr={09,23,14,13,11,10,12,08,19,18,26,15,14,06,12,03,02}为例，
     * 1、取首个元素V=arr[0]=09，lo=0，hi=16。调用sort方法，调用partition方法
     * - 右扫至arr[1]，比V大，则先找下一个右扫元素，此时数组不动，为：09,23,14,13,11,10,12,08,19,18,26,15,14,06,12,03,02   【右扫元素待交换】
     * - 左扫至arr[16]，比V小，则交换右扫当前节点arr[1]，为：09,02,14,13,11,10,12,08,19,18,26,15,14,06,12,03,23
     * - 右扫至arr[2]，比V大，则先找下一个右扫元素，此时数组不动    【右扫元素待交换】arr[2]
     * - 左扫至arr[15]，比V小，则交换右扫当前节点arr[2]，为：09,02,03,13,11,10,12,08,19,18,26,15,14,06,12,14,23
     * - 右扫至arr[3]，比V大，则先找下一个右扫元素，此时数组不动    【右扫元素待交换】arr[3]
     * - 左扫至arr[14]，也比V大，继续左扫，此时数组不动
     * - 左扫至arr[13]，比V小，则交换右扫当前节点arr[3]，为：09,02,03,06,11,10,12,08,19,18,26,15,14,13,12,14,23
     * - 右扫至arr[4]，比V大，则先找下一个右扫元素，此时数组不动    【右扫元素待交换】arr[4]
     * - 左扫至arr[12]，比V大，继续左扫，此时数组不动
     * - 左扫至arr[11]，比V大，继续左扫，此时数组不动
     * - …… 都比V大，省略步骤
     * - 左扫至arr[7]，比V小，则交换右扫当前节点arr[4]，为：09,02,03,06,08,10,12,11,19,18,26,15,14,13,12,14,23
     * - 右扫至arr[5]，比V大，则先找下一个右扫元素，此时数组不动    【右扫元素待交换】arr[5]
     * - …… 接下来左扫都比V大，但是左扫没有碰到比V小的，数组皆不动
     * - 直至左扫到arr[4]，经过前面的交换，此时arr[4]=08, 右扫至arr[5]=10，先让左扫和右扫交叉了
     * 这时候，要开始将V这个中间值放置在中间了，则交换a[0]和a[4]，得：08,02,03,06,09,10,12,11,19,18,26,15,14,13,12,14,23
     * 返回中间值下标4，接着按以上同样的方式处理arr[0]~arr[4-1]和arr[5]~arr[16]
     * */
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        // 切分，取出切分值坐标
        int j = partition(a, lo, hi);
        System.out.println("----- j="+j+" -----");
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
     * 该方法作用：
     * 取首个元素作为中间值，通过比较和交换，将小于V的放在V的左侧，将大于V的放在V的右侧，最后返回该中间值的数组下标。注意！此时V的左侧不一定是有序的，同样，右侧也一样
     * 但颗粒度最细的情况，数组三个元素，arr[0]作为中间值V，由左开始扫arr[1],由右开始扫arr[2]，小的排arr[0]的左侧，大的排arr[1]的右侧
     * 这时候，arr就可以保证是个整体有序的数组了，然后颗粒度逐渐增大，就可以保证，最终得到的整个数组都是有序的了
     * @param a 数组
     * @param lo 开始
     * @param hi 结束
     * */
    private static int partition(Comparable[] a, int lo, int hi) {
        System.out.println("----- lo="+lo+" && hi="+hi+" -----");
        // 定义往右扫描的指针i
        int i = lo;
        // 定义往左扫描的指针j
        int j = hi + 1;
        // 初始定义v为最左边的元素
        Comparable v = a[lo];
        while (true) {
            System.out.println("++i值="+(i+1)+" --j值="+(j-1));
            // 由以下两个while可以看出，是左比较一次，右比较一次
            // a[往右扫描指针]如果一直小于V，则一直往右扫
            while (less(a[++i], v)) {
                // 直至扫描到右边，跳出当前while循环，可能去处理交换
                if (i == hi) break;
            }
            // a[往左扫描指针]如果一直大于V,则一直往左扫
            while (less(v, a[--j])) {
                // 直至扫描到左边，跳出当前while循环，可能去处理交换
                if (j == lo) break;
            }
            // 当左扫描指针大于等于右扫描指针，就无需再比了，两个指针碰到了，说明元素都扫描完了，比V小的排V的左边，比V大的，排V的右边
            if (i >= j){
                System.out.println("skip this loop i="+i+" j="+j);
                break;
            }
            // 每次一卡点，就是在v没有大于a[左扫描i]，且a[右扫描j]没有大于v的时候，做一次左右交换
            System.out.println("a["+i+"]="+a[i]+" <---> a["+j+"]="+a[j]);
            exchange(a, i, j);
        }
        // 此时j是个中间值坐标，上面都是拿a[lo]（即v）进行比较的，j左边都是小于a[lo]值的，j的右边都是大于a[lo]值的，所以把a[lo]和a[j]交换
        exchange(a, lo, j);
        System.out.print("此时一轮的arr：");
        show(a);
        return j;
    }

    public static void main(String[] args) {
        String[] a = new String[]{"09","23","14","13","11","10","12","08","19","18","26","15","14","06","12","03","02"};
        show(a);
        Quick quick = new Quick();
        quick.sort(a);
        show(a);
    }

}
