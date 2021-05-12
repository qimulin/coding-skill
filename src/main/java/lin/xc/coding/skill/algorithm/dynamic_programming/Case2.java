package lin.xc.coding.skill.algorithm.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lin.xc
 * @date 2021/5/12
 **/
public class Case2 {

    /**
     * 带备忘录的递归解法
     * 为了解决{@link Case1#fib(int)} 中的重叠子问题，我们可以造一个「备忘录」，每次算出某个子问题的答案后别急着返回，先记到「备忘录」里再返回；
     * 每次遇到一个子问题先去「备忘录」里查一查，如果发现之前已经解决过这个问题了，直接把答案拿出来用，不要再耗时去计算了。
     * 一般使用一个数组充当这个「备忘录」，当然你也可以使用哈希表（字典），思想都是一样的。
     * */
    static int fibByMap(int N) {
        if (N < 1) return 0;
        // Map做备忘录
        Map<Integer, Integer> memo = new HashMap<>(N);

        // 进行带备忘录的递归
        return helper(memo, N);
    }

    static int helper(Map<Integer, Integer> memo, int n) {
        // base case
        if (n == 1 || n == 2) {
            return 1;
        }
        // 已经计算过
        if (memo.get(n) != null){
            return memo.get(n);
        }
        // 未计算过，再依靠备忘录计算，并设置值到备忘录
        memo.put(n, helper(memo, n - 1) + helper(memo, n - 2));
        return memo.get(n);
    }

    static int fib(int N) {
        if (N < 1) return 0;
        // 本例子可以采用数组做备忘录，因为数组下标刚好是int类型，数组下标从0开始，所以这里可以容量设置为N+1
        int[] memo = new int[N+1];
        // 进行带备忘录的递归
        return helper(memo, N);
    }

    static int helper(int[] memo, int n) {
        // base case
        if (n == 1 || n == 2) {
            return 1;
        }
        // 已经计算过
        if (memo[n] != 0){
            return memo[n];
        }
        // 未计算过，再依靠备忘录计算，并设置值到备忘录
        memo[n]= helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    /**
     * 本例子以斐波那契数列举例
     * 1、1、2、3、5、8、13、21、34……
     * */
    public static void main(String[] args) {
        System.out.println(fibByMap(9));
    }

    /**
     * 后记：
     * 至此，带备忘录的递归解法的效率已经和迭代的动态规划解法一样了。
     * 实际上，这种解法和迭代的动态规划已经差不多了，只不过这种方法叫做「自顶向下」，动态规划叫做「自底向上」。
     * */
}
