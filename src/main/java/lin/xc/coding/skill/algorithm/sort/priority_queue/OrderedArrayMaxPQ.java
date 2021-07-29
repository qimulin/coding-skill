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


    public boolean isEmpty() { return n == 0;  }
    public int size()        { return n;       }
    public Key delMax()      { return pq[--n]; }

    public void insert(Key key) {
        int i = n-1;
        while (i >= 0 && less(key, pq[i])) {
            pq[i+1] = pq[i];
            i--;
        }
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
        pq.insert("this");
        pq.insert("is");
        pq.insert("a");
        pq.insert("test");
        while (!pq.isEmpty())
            StdOut.println(pq.delMax());
    }

}
