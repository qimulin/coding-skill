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
        System.out.println("len="+len);
        // 间隙初始为1
        int diff = 1;
        while(diff < len/3){
            diff = 3*diff+1;     //1，4，13，40，121，364，1093...
        }
        while(diff >= 1){
            System.out.println("---------- diff="+diff);
            // 将数组变为diff有序
            for(int i=diff;i<len;i++){
                System.out.println("------ i="+i);
                // 将a[i]根据大小插入到a[i-diff]、a[i-2*diff]、a[i-3*diff]...之中
                for(int j=i; j>=diff && less(arr[j], arr[j-diff]); j-=diff){
                    System.out.print("["+j+"]="+arr[j]+" <——> ["+(j-diff)+"]="+arr[j-diff]+",");
                    System.out.println(" when j="+j+" and j-diff="+(j-diff));
                    exchange(arr, j, j-diff);
                }
                System.out.println();
            }
            diff = diff/3;
        }
    }

    /**
     * 自己比较好理解的希尔排序
     * 和{@link #sort(Comparable[])}实现不一样，该方法二分之后，颗粒度慢慢变细
     * @param arr 可排序的数组
     * */
    public static void mySort(Comparable[] arr) {
        // 将数组按升序排列
        int len = arr.length;
        // 取数组的一半的长度作为初始间隙
        for(int gap = len/2; gap>0; gap=gap/2){
            System.out.println("---------- gap="+gap);
            // 对各个度量的间隙产生的分组进行插入排序
            // 如果间隙gap的组后一个元素比前一个小，则交换
            // 以下则为插入排序
            for(int i = gap; i < len; i=i+gap){
                // 仅当当前位置比前一个位置小，且当前位置还不是第一位的时候，迭代往下比较
                for(int j = i; j > 0 && less(arr[j],arr[j - gap]); j=j-gap){
                    System.out.println("["+j+"]="+arr[j]+" <——> ["+(j-gap)+"]="+arr[j-gap]);
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
//        String[] a = new String[]{"9","8","7","6","5","4"};
        show(a);
        mySort(a);
        System.out.println("排序操作后：");
        show(a);
        System.out.println("是否已排序？"+isSorted(a));
    }

    /**
     * 后记：为了方便理解和回忆，搞一个{@link #sort(Comparable[])}方法的示例讲解，简单数字组合：16 15 14 13 12 11 10 09 08 07 06 05 04 02 01 03 17
     * 算出首次间隙为13，【注意】先取间隔下标为1的和下标为0的比较
     * ----- 间隙为13时，则此间隔下 将shell_arr[1]组（arr[13]~arr[len-1]）与shell_arr[0]组（arr[0]~arr[len-1-13]）逐一间隔为13的元素进行排序 -----
     * 比较下标13和下标0，得：02 15 14 13 12 11 10 09 08 07 06 05 04 16 01 03 17
     * 比较下标14和下标1，得：02 01 14 13 12 11 10 09 08 07 06 05 04 16 15 03 17
     * 比较下标15和下标2，得：02 01 03 13 12 11 10 09 08 07 06 05 04 16 15 14 17
     * 比较下标16和下标3，得：02 01 03 13 12 11 10 09 08 07 06 05 04 16 15 14 17 --- 不需要变
     * ----- 间隙为4时，然后将shell_arr[1]组（arr[4]~arr[len-1]）与shell_arr[0]组（arr[0]~arr[len-1-4]）逐一间隔为4的进行排序 -----
     * 比较下标4和下标0，得：02 01 03 13 12 11 10 09 08 07 06 05 04 16 15 14 17 --- 不需要变
     * 比较下标5和下标1，得：02 01 03 13 12 11 10 09 08 07 06 05 04 16 15 14 17 --- 不需要变
     * 比较下标6和下标2，得：02 01 03 13 12 11 10 09 08 07 06 05 04 16 15 14 17 --- 不需要变
     * 比较下标7和下标3，得：02 01 03 09 12 11 10 13 08 07 06 05 04 16 15 14 17
     * ……
     * 比较下标16和下标12，得：自己推
     * ----- 间隙为1时，则此间隔下 将shell_arr[1]组（arr[2]~arr[len-1]）与shell_arr[0]组（arr[0]~arr[len-1-1]）逐一间隔为1的元素进行排序 -----
     * ……（不再一一列举）
     * */

}
