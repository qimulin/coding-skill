package lin.xc.coding.skill.algorithm.dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * dp数组的迭代解法
 * @author lin.xc
 * @date 2021/5/12
 * 当然，我们也可以自底向上使用 dp table 来消除重叠子问题，关于「状态」「选择」和 base case 与之前没有区别，
 * dp 数组的定义和刚才 dp 函数类似，也是把「状态」，也就是目标金额作为变量。不过 dp 函数体现在函数参数，而 dp 数组体现在数组索引：
 **/
public class Case7 {

    static int coinChange(List<Integer> coins, int amount) {
        // 数组大小为 amount + 1，因为下标0（即金额0）也一并存储
        int[] dp = new int[amount+1];
        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int arrIdx = 1; arrIdx <= amount; arrIdx++) {
            // 初始都设置成金额+1，即本轮不可能超越的最大值
            dp[arrIdx] = arrIdx+1;
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (arrIdx - coin < 0){
                    // 无法被该金额拆分，所以无解
                    continue;
                }
                // 自底向上的话，就一定能取到之前路过的每个金额的最小张数，比较小的则被更新掉
                dp[arrIdx] = Integer.min(dp[arrIdx], 1 + dp[arrIdx - coin]);
            }
        }
        return (dp[amount] == amount+1) ? -1 : dp[amount];
    }

    /**
     * 凑零钱问题
     * 题目：给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，
     * 如果不可能凑出，算法返回 -1 。算法的函数签名如下：
     * // coins 中是可选硬币面值，amount 是目标金额
     * int coinChange(int[] coins, int amount);
     * 比如说 k = 3，面值分别为 1，2，5，总金额 amount = 11。那么最少需要 3 枚硬币凑出，即 11 = 5 + 5 + 1。
     * */
    public static void main(String[] args) {
        List<Integer> coins = Arrays.asList(1, 2, 5);
        System.out.println(coinChange(coins, 11));
    }

    /**
     * 后记：
     * PS：为啥 dp 数组元素都初始化为 amount + 1 呢，因为凑成 amount 金额的硬币数最多只可能等于 amount（全用 1 元面值的硬币），
     * 所以初始化为 amount + 1 就相当于初始化为正无穷，便于后续取最小值。
     * */
}
