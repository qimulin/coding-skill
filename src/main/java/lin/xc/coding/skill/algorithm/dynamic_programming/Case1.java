package lin.xc.coding.skill.algorithm.dynamic_programming;

/**
 * @author lin.xc
 * @date 2021/5/12
 **/
public class Case1 {

    /**
     * 暴力递归
     * 很明显发现了算法低效的原因：存在大量重复计算，比如 f(18) 被计算了两次，而且你可以看到，以 f(18) 为根的这个递归树体量巨大，
     * 多算一遍，会耗费巨大的时间。更何况，还不止 f(18) 这一个节点被重复计算
     * 这就是动态规划问题的第一个性质：重叠子问题
     * */
    static int fib(int N) {
        if (N == 1 || N == 2) return 1;
        // 到最底层，N=1或者N=2的时候，都会变成1返回
        return fib(N - 1) + fib(N - 2);
    }

    /**
     * 本例子以斐波那契数列举例
     * 1、1、2、3、5、8、13、21、34……
     * */
    public static void main(String[] args) {
        System.out.println(fib(9));
    }
}
