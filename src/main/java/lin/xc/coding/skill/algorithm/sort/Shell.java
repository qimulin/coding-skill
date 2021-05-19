package lin.xc.coding.skill.algorithm.sort;

/**
 * 希尔排序
 * @author lin.xc
 * @date 2021/5/18
 **/
public class Shell {

    /**
     * 《算法》一书中用到的方法
     *  h值设置较好，性能较高
     * */
    public static void sort(Comparable[] arr) {
        // 将数组按升序排列
        int len = arr.length;
        // 间隙初始为1
        int gap = 1;
        while(gap < len/3){
            gap = 3*gap+1;     //1，4，13，40，121，364，1093...
        }
        while(gap >= 1){
            System.out.println("---------- h="+gap);
            // 将数组变为h有序
            for(int i=gap;i<len;i++){
                System.out.println("------ i="+i);
                // 将a[i]插入到a[i-h]、a[i-2*h]、a[i-3*h]...之中
                for(int j=i; j>=gap && less(arr[j], arr[j-gap]); j-=gap){
                    System.out.println("--- j="+j);
                    System.out.print("["+j+"]="+arr[j]+" <——> ["+(j-gap)+"]="+arr[j-gap]+",");
                    exchange(arr, j, j-gap);
                }
                System.out.println();
            }
            gap = gap/3;
        }
    }

    /**
     * 自己比较好理解的希尔排序
     * @param arr 可排序的数组
     * */
    public static void mySort(Comparable[] arr) {
        // 将数组按升序排列
        int len = arr.length;
        // 取数组的一半的长度作为初始间隙
        for(int gap = len/2; gap>0; gap=gap/2){
            // 对各个度量的间隙产生的分组进行插入排序
            // 如果间隙gap的组后一个元素比前一个小，则交换
            // 以下则为插入排序
            for(int i = gap; i < len; i=i+gap){
                // 仅当当前位置比前一个位置小，且当前位置还不是第一位的时候，迭代往下比较
                for(int j = i; j > 0 && less(arr[j],arr[j - gap]); j=j-gap){
                    exchange(arr, j,j - gap);
                }
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
//        String[] a = new String[]{"L","E","E","A","M","H","L","E","T","S","O","L","P","S","X","R"};
//        String[] a = new String[]{"12","11","10","9","8","7","6","5","4","3","2","1","16","15","14","13"};
        String[] a = new String[]{"16","15","14","13","12","11","10","09","08","07","06","05","04","02","01","03","17"};
        show(a);
        mySort(a);
        System.out.println("排序操作后：");
        show(a);
        System.out.println("是否已排序？"+isSorted(a));
    }

    /**
     * 后记：
     * */

}
