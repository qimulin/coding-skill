package lin.xc.coding.skill.algorithm.sort.priority_queue;

import lin.xc.coding.skill.algorithm.sort.std.StdOut;

/**
 * 最大优先队列-无序数组实现
 * @author lin.xc
 * @date 2021/7/29
 **/
public class DisorderedArrayMaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;      // 元素集
    private int size;         // 元素个数

    // 初始化设置大小
    public DisorderedArrayMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    /**
     * 插入元素
     * */
    public void insert(Key x){
        // 即给下一个数组元素赋值，本轮的数组大小即为下一个元素的下标位置
        pq[size++] = x;
    }

    /**
     * 删除最大值元素，相当于在删除的时候，进行选择排序，然后删除最大的值
     * */
    public Key delMax() {
        int max = 0;
        for (int i = 1; i < size; i++){
            // 取到本数组中最大元素的下标
            if (less(max, i)) max = i;
        }
        // 将这个最大的元素放到数组的最后一位
        exchange(max, size -1);

        return pq[--size];
    }


    /***************************************************************************
     * Helper functions.
     ***************************************************************************/
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }



    /***************************************************************************
     * Test routine.
     ***************************************************************************/
    public static void main(String[] args) {
        DisorderedArrayMaxPQ<String> pq = new DisorderedArrayMaxPQ<String>(10);
        pq.insert("01");
        pq.insert("02");
        pq.insert("03");
        pq.insert("04");
        pq.insert("09");
        pq.insert("08");
        pq.insert("07");
        pq.insert("06");
        pq.insert("10");
        pq.insert("11");
        // 元素添加完（注意不要溢出）开始操作删除最大的元素
        while (!pq.isEmpty())
            StdOut.println(pq.delMax());
        System.out.println(pq);
    }

}