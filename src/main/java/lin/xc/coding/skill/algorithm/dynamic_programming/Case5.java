package lin.xc.coding.skill.algorithm.dynamic_programming;

import java.util.Arrays;
import java.util.List;

/**
 * 凑零钱问题
 * @author lin.xc
 * @date 2021/5/12
 **/
public class Case5 {

    /**
     * 自解：动态规划就是逐个拆分子问题，然后取最值。比如：
     * 想求 amount = 11 时的最少硬币数（原问题），如果你知道凑出 amount = 10 的最少硬币数（子问题），
     * 你只需要把子问题的答案加一（再选一枚面值为 1 的硬币）就是原问题的答案。因为硬币的数量是没有限制的，所以子问题之间没有相互制，是互相独立的。
     *
     * 那么，既然知道了这是个动态规划问题，就要思考如何列出正确的状态转移方程？
     * 1、确定 base case，这个很简单，显然目标金额 amount 为 0 时算法返回 0，因为不需要任何硬币就已经凑出目标金额了。
     * 2、确定「状态」，也就是原问题和子问题中会变化的变量。由于硬币数量无限，硬币的面额也是题目给定的，只有目标金额会不断地向 base case 靠近，所以唯一的「状态」就是目标金额 amount。
     * 3、确定「选择」，也就是导致「状态」产生变化的行为。目标金额为什么变化呢，因为你在选择硬币，你每选择一枚硬币，就相当于减少了目标金额。所以说所有硬币的面值，就是你的「选择」。
     * 4、明确 dp 函数/数组的定义。我们这里讲的是自顶向下的解法，所以会有一个递归的 dp 函数，一般来说函数的参数就是状态转移中会变化的量，也就是上面说到的「状态」；函数的返回值就是题目要求我们计算的量。就本题来说，状态只有一个，即「目标金额」，题目要求我们计算凑出目标金额所需的最少硬币数量。所以我们可以这样定义 dp 函数：
     * dp(n) 的定义：输入一个目标金额 n，返回凑出目标金额 n 的最少硬币数量。
     * */
    static int coinChange(List<Integer> coins, int amount) {
        return dp(coins, amount);
    }

    static int dp(List<Integer> coins, int n){
        // base case
        if(n == 0){
            return 0;
        }
        if(n < 0){
            return -1;
        }
        int maxNumAdd1 = n+1;
        // 初始设置这个值，由于币种最小的就是1元，所以，数目怎么也不会超过金额n+1
        int minNum = maxNumAdd1;
        for (Integer coin:coins){
            // 用掉一张面值，n相应的减小
            int subProblem = dp(coins, n-coin);
            // 子问题无解，跳过，说明使用这一面值无法满足条件
            if(subProblem == -1){
                continue;
            }
            // 取每次规划的路线的最小值
            minNum = Integer.min(minNum, subProblem+1);
        }
        // 说明不为初始的那个值
        if(minNum!=maxNumAdd1){
            return minNum;
        }else{
            return -1;
        }
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
     * 至此，状态转移方程其实已经完成了，以上算法已经是暴力解法了。
     * 至此，这个问题其实就解决了，只不过需要消除一下重叠子问题
     * 递归算法的时间复杂度分析：子问题总数 x 每个子问题的时间。
     * 子问题总数为递归树节点个数，这个比较难看出来，是 O(n^k)，总之是指数级别的。每个子问题中含有一个 for 循环，复杂度为 O(k)。所以总时间复杂度为 O(k * n^k)，指数级别。
     * */
}
