package lin.xc.coding.skill.algorithm.sort;

/**
 * 选择排序
 * 记号好本轮最小的元素位置，一轮结束后和首元素进行替换
 * @author lin.xc
 * @date 2021/5/17
 **/
public class Selection {

    /**
     * 排序方法
     * @param arr 可排序的数组
     * */
    public static void sort(Comparable[] arr) {
        int len = arr.length;
        for(int i=0; i<len; i++){
            // 当前要处理的最小数位置
            int min = i;
            // 已经历过的无需比较
            for(int j=i+1; j<len; j++){
                // 逐个比较，记录最小的位置
                if(less(arr[j], arr[min])){
                    min = j;
                }
            }
            // i位置与本轮最小的值进行交换
            exchange(arr, i, min);
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
        String[] a = new String[]{"abc","bcd","acd","cde","ceb"};
        System.out.println(a);
        sort(a);
        System.out.println("是否已排序？"+isSorted(a));
        show(a);
    }

    /**
     * 后记：
     * 这个排序算法模板适用于任何实现了Comparable接口的数据类型。如封装数字的类型Interger和Double，以及String和其他许多高级数据类型（File和URL）。
     * 在创建自己的数据类型时，只要实现Comparable接口就能够将其排序。要做到这一点，只需实现一个comparableTo（）方法来定义目标类型的自然顺序即可
     * */

}
