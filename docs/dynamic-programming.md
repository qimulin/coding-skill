# 动态规划
## 斐波那契数列
拿斐波那契数列举例，
> 斐波那契数列（Fibonacci sequence），又称黄金分割数列，因数学家莱昂纳多·斐波那契（Leonardoda Fibonacci）以兔子繁殖为例子而引入，
> 故又称为“兔子数列”，指的是这样一个数列：0、1、1、2、3、5、8、13、21、34、……在数学上，斐波那契数列以如下被以递推的方法定义：
> F(0)=0，F(1)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 2，n ∈ N*）

- [暴力递归](../src/main/java/lin/xc/coding/skill/algorithm/dynamic_programming/Case1.java)
- [带备忘录的递归方法](../src/main/java/lin/xc/coding/skill/algorithm/dynamic_programming/Case2.java)
- [动态规划的dp数组的迭代解法](../src/main/java/lin/xc/coding/skill/algorithm/dynamic_programming/Case3.java)
- [动态规划的「状态压缩」](../src/main/java/lin/xc/coding/skill/algorithm/dynamic_programming/Case3.java)
## 凑零钱问题
> 题目：给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，
> 如果不可能凑出，算法返回 -1 。算法的函数签名如下：<br>
> // coins 中是可选硬币面值，amount 是目标金额<br>
> int coinChange(int[] coins, int amount);<br>
> 比如说 k = 3，面值分别为 1，2，5，总金额 amount = 11。那么最少需要 3 枚硬币凑出，即 11 = 5 + 5 + 1。
- [递归](../src/main/java/lin/xc/coding/skill/algorithm/dynamic_programming/Case5.java)
- [带备忘录的递归](../src/main/java/lin/xc/coding/skill/algorithm/dynamic_programming/Case6.java)
- [dp数组的迭代解法](../src/main/java/lin/xc/coding/skill/algorithm/dynamic_programming/Case7.java)