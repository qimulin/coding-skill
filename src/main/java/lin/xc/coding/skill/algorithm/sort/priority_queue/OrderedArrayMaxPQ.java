package lin.xc.coding.skill.algorithm.sort.priority_queue;

import lin.xc.coding.skill.algorithm.sort.std.StdOut;

/**
 * 最大优先队列-有序数组实现
 * @author lin.xc
 * @date 2021/7/29
 **/
public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;      // 元素集
    private int n;         // 元素个数

    // 初始化设置大小
    public OrderedArrayMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
        n = 0;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public Key delMax(){
        return pq[--n];
    }

    public void insert(Key key) {
        // 找集合最右边元素（本例中的指最大值）
        int i = n-1;
        // 当插入的元素比用来比较的索引元素小
        while (i >= 0 && less(key, pq[i])) {
            // 将较大的索引元素排靠右边
            pq[i+1] = pq[i];
            i--;
        }
        // 跳出循环，则说明插入的元素比pg[i]大了，则将key赋值给pg[i+1]
        pq[i+1] = key;
        n++;
    }

    /***************************************************************************
     * Helper functions.
     ***************************************************************************/
    private boolean less(Key v, Key w) {
        return v.compareTo(w) < 0;
    }

    /***************************************************************************
     * Test routine.
     ***************************************************************************/
    public static void main(String[] args) {
        OrderedArrayMaxPQ<String> pq = new OrderedArrayMaxPQ<String>(10);
        pq.insert("09");
        pq.insert("02");
        pq.insert("01");
        pq.insert("03");
        pq.insert("04");
        pq.insert("08");
        pq.insert("07");
        pq.insert("06");
        pq.insert("10");
        pq.insert("11");
        // 开始操作删除最大的元素
        while (!pq.isEmpty())
            StdOut.println(pq.delMax());
    }

}
