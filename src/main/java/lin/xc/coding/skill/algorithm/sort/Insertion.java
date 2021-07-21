package lin.xc.coding.skill.algorithm.sort;

/**
 * 插入排序
 * 说明：
 * 第一轮：先比较下标0和下标1的元素，较小的排0位，较大的排1位
 * 第二轮：拿下标2位的值和下标1的元素比较，若下标2的大，则不动；若比下标1小，则先与下标1交换位置；接下来就是新下标1和下标0的比较了，一样的道理，大了就不换，小了就换到前面去
 * 第三轮：第二轮的规律往下
 * @author lin.xc
 * @date 2021/5/17
 **/
public class Insertion {

    /**
     * 排序方法
     * @param arr 可排序的数组
     * */
    public static void sort(Comparable[] arr) {
        int len = arr.length;
        // i从1开始
        for(int i = 1; i < len; i ++){
            // 仅当 当前位置比前一个位置小，且当前位置还不是第一位的时候，迭代往下比较
            for(int j = i; j > 0 && less(arr[j],arr[j - 1]); j--){
                exchange(arr, j,j - 1);
            }
        }
    }

    /**
     * 是否小于方法：对可比较的元素进行比较
     * */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换方法
     * */
    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp=arr[i]; arr[i]=arr[j]; arr[j]=temp;
    }

    /**
     * 展示
     * */
    public static void show(Comparable[] arr) {
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    /**
     * 测试元素是否有序
     * */
    public static boolean isSorted(Comparable[] arr) {
        for(int i=1; i<arr.length; i++){
            // 若后一个数比前一个数小，则非有序数组
            if(less(arr[i], arr[i-1])){
                return false;
            }
        }
        // 都是后一个数比前一个数大，则返回true
        return true;
    }

    public static void main(String[] args) {
        String[] a = new String[]{"2","5","3","4","1"};
        System.out.println(a);
        sort(a);
        System.out.println("是否已排序？"+isSorted(a));
        show(a);
    }


    /**
     * 后记：
     * 当倒置的数量很少时，插入排序很可能就比大多数算法都要快了，因为需要交换的情况少了。
     * 总的来说，插入排序对于部分有序的数组十分高效，也很适合小规模数组。
     * */

}
