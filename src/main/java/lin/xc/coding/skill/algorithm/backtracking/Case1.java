package lin.xc.coding.skill.algorithm.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lin.xc
 * @date 2021/5/13
 **/
public class Case1 {

    List<List<Integer>> res = new LinkedList<>();

    /**
     * 主函数，输入一组不重复的数字，返回它们的全排列
     * */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     * 路径：记录在 track 中
     * 选择列表：nums 中不存在于 track 的那些元素
     * 结束条件：nums 中的元素全都在 track 中出现
     * */
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件，下面判断说明路径已经全部走完，即可将该排列加入返回结果中
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择，路径中包含该元素，说明已被使用过
            if (track.contains(nums[i])){
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择，上面递归已将该层及以下所有选择都操作完了，接下来就是移除本次选择，走下个循环元素，再进行穷举
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Case1 case1 = new Case1();
        List<List<Integer>> permute = case1.permute(new int[]{1, 2, 3});
        System.out.println(permute.toString());
    }

    /**
     * 后记：
     * 至此，我们就通过全排列问题详解了回溯算法的底层原理。当然，这个算法解决全排列不是很高效，应为对链表使用 contains 方法需要 O(N) 的时间复杂度。
     * 有更好的方法通过交换元素达到目的，但是难理解一些，这里就不写了，有兴趣可以自行搜索一下。
     *
     * 但是必须说明的是，不管怎么优化，都符合回溯框架，而且时间复杂度都不可能低于 O(N!)，因为穷举整棵决策树是无法避免的。
     * 这也是回溯算法的一个特点，不像动态规划存在重叠子问题可以优化，回溯算法就是纯暴力穷举，复杂度一般都很高。
     * */
}
