package lin.xc.coding.skill.algorithm.dynamic_programming;

/**
 * 自底向上动态规划
 * @author lin.xc
 * @date 2021/5/12
 * {@link Case2} 里的例子就是「自顶向下」的
 * 注意我们刚才画的递归树（或者说图），是从上向下延伸，都是从一个规模较大的原问题比如说 f(20)，向下逐渐分解规模，
 * 直到 f(1) 和 f(2) 这两个 base case，然后逐层返回答案，这就叫「自顶向下」。
 * 啥叫「自底向上」？反过来，我们直接从最底下，最简单，问题规模最小的 f(1) 和 f(2) 开始往上推，直到推到我们想要的答案 f(20)，
 * 这就是动态规划的思路，这也是为什么动态规划一般都脱离了递归，而是由循环迭代完成计算。
 **/
public class Case3 {

    /**
     * dp（dynamic programming）数组的迭代解法
     * 有{@link Case2}「备忘录」的启发，我们可以把这个「备忘录」独立出来成为一张表，就叫做 DP table 吧，在这张表上完成「自底向上」的推算岂不美哉！
     * */
    static int fib(int N) {
        if (N < 1){
            return 0;
        }
        if (N == 1 || N == 2){
            return 1;
        }
        int[] dp = new int[N+1];
        // base case
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= N; i++){
            // 从i=3开始，逐个自底向上计算
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    /**
     * 本例子以斐波那契数列举例
     * 1、1、2、3、5、8、13、21、34……
     * */
    public static void main(String[] args) {
        System.out.println(fib(9));
    }

    /**
     * 后记：
     * 你会发现，上面的{@link Case1,Case2,Case3}几种解法中的所有操作，例如 return f(n - 1) + f(n - 2)，dp[i] = dp[i - 1] + dp[i - 2]，
     * 以及对备忘录或 DP table 的初始化操作，都是围绕这个方程式的不同表现形式。可见列出「状态转移方程」的重要性，它是解决问题的核心。
     * 而且很容易发现，其实状态转移方程直接代表着暴力解法。
     * 千万不要看不起暴力解，动态规划问题最困难的就是写出这个暴力解，即状态转移方程。只要写出暴力解，优化方法无非是用备忘录或者 DP table，再无奥妙可言。
     * */
}
