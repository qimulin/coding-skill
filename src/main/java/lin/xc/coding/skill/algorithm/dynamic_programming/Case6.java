package lin.xc.coding.skill.algorithm.dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 带备忘录的递归
 * @author lin.xc
 * @date 2021/5/12
 * 类似之前斐波那契数列的例子{@link Case2}，只需要稍加修改，就可以通过备忘录消除重叠子问题：
 **/
public class Case6 {

    static int coinChange(List<Integer> coins, int amount) {
        // 备忘录：存储到每个金额的最小货币张数
        Map<Integer, Integer> memo= new HashMap(amount);
        return dp(coins, amount, memo);
    }

    /**
     * 代码可参考{@link Case5#dp(List, int)} 一起理解
     * */
    static int dp(List<Integer> coins, int n, Map<Integer, Integer> memo){
        // 查备忘录，避免重复计算
        if(memo.get(n)!=null){
            System.out.println(String.format("备忘录有[%d]对应最小货币数值[%d]", n, memo.get(n)));
            return memo.get(n);
        }
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
        for(Integer coin: coins){
            int subProblem = dp(coins, n-coin, memo);
            if(subProblem==-1){
                continue;
            }
            minNum = Integer.min(minNum, subProblem+1);
            // 设置该金额最小张数值
            memo.put(n, minNum);
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
     * 很显然「备忘录」大大减小了子问题数目，完全消除了子问题的冗余，所以子问题总数不会超过金额数 n，即子问题数目为 O(n)。
     * 处理一个子问题的时间不变，仍是 O(k)，所以总的时间复杂度是 O(kn)。
     * */
}
