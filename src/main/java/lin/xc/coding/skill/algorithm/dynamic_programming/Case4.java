package lin.xc.coding.skill.algorithm.dynamic_programming;

/**
 * 动态规划的「状态压缩
 * @author lin.xc
 * @date 2021/5/12
 * {@link Case3} 这个例子的最后，讲一个细节优化。细心的读者会发现，根据斐波那契数列的状态转移方程，当前状态只和之前的两个状态有关，
 * 其实并不需要那么长的一个 DP table 来存储所有的状态，只要想办法存储之前的两个状态就行了。所以，可以进一步优化，把空间复杂度降为 O(1)：
 **/
public class Case4 {

    /**
     * 这个技巧就是所谓的「状态压缩」，如果我们发现每次状态转移只需要 DP table 中的一部分，那么可以尝试用状态压缩来缩小 DP table 的大小，
     * 只记录必要的数据，上述例子就相当于把DP table 的大小从 n 缩小到 2。后续的动态规划章节中我们还会看到这样的例子，
     * 一般来说是把一个二维的 DP table 压缩成一维，即把空间复杂度从 O(n^2) 压缩到 O(n)。
     * */
    static int fib(int n) {
        if (n < 1) return 0;
        if (n == 2 || n == 1)
            return 1;
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

    /**
     * 本例子以斐波那契数列举例
     * 1、1、2、3、5、8、13、21、34……
     * */
    public static void main(String[] args) {
        System.out.println(fib(9));
    }

}
