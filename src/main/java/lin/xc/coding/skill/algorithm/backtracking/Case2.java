package lin.xc.coding.skill.algorithm.backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * @author lin.xc
 * @date 2021/5/13
 **/
public class Case2 {

    List<List<String>> res;

    /**
     * 输入棋盘边长 n，返回所有合法的放置
     * @param needAll 是否需要列出所有解
     * */
    List<List<String>> solveNQueens(int n, boolean needAll) {
        res = new ArrayList<>();
        // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
        String[][] board = new String[n][n];
        // 先都赋值成“.”
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                board[i][j] = ".";
            }
        }
        if(needAll){
            backtrack(board, 0);
        } else {
            backtrackForOne(board, 0);
        }
        return res;
    }

    /**
     * 路径：board 中小于 row 的那些行都已经成功放置了皇后
     * 选择列表：第 row 行的所有列都是放置皇后的选择
     * 结束条件：row 超过 board 的最后一行
     * */
    void backtrack(String[][] board, int row) {
        // 触发结束条件：row等于board.length-1是最后一行，等于board.length，说明整个棋盘路径都走过了，可以返回了
        if (row == board.length) {
            List<String> seg = new ArrayList<>(board.length);
            for(int i=0; i<board.length; i++){
                // 存储每一行的棋子摆放信息
                seg.add(arrToString(board[i]));
            }
            // 添加到最终结果
            res.add(seg);
            return;
        }

        int boardColSize = board[row].length;
        for (int col = 0; col < boardColSize; col++) {
            // 排除不合法选择
            if (!isValid(board, row, col)){
                continue;
            }
            // 做选择
            board[row][col] = "Q";
            // 进入下一行决策
            backtrack(board, row + 1);
            // 撤销选择
            board[row][col] = ".";
        }
    }

    /**
     * 只找一答案即可
     * */
    boolean backtrackForOne(String[][] board, int row) {
        // 触发结束条件
        if (row == board.length) {
            List<String> seg = new ArrayList<>(board.length);
            for(int i=0; i<board.length; i++){
                // 存储每一行的棋子摆放信息
                seg.add(arrToString(board[i]));
            }
            // 添加到最终结果
            res.add(seg);
            return true;
        }

        int boardColSize = board[row].length;
        for (int col = 0; col < boardColSize; col++) {
            // 排除不合法选择
            if (!isValid(board, row, col)){
                continue;
            }
            // 做选择
            board[row][col] = "Q";
            // 进入下一行决策
            if(backtrackForOne(board, row + 1)){
                return true;
            }
            // 撤销选择
            board[row][col] = ".";
        }
        return false;
    }

    /**
     * 是否有效：是否可以在 board[row][col] 放置皇后？
     * */
    boolean isValid(String[][] board, int row, int col) {
        // 列的长度等于行的长度
        int boardColLength = board.length;
        // 检查列是否有皇后互相冲突：小于这一行的所有该列是否有“Q”，找到即返回false
        for (int i = 0; i < row; i++) {
            if ("Q".equals(board[i][col])){
                return false;
            }
        }
        // 检查行是否有皇后互相冲突：小于这一列的所有该列是否有“Q”，找到即返回false
        for (int j = 0; j < col; j++) {
            if ("Q".equals(board[row][j])){
                return false;
            }
        }
        // 注意：因为都是由上向下，由左向右进行检查，所以在回溯过程中只需要检查左上方，也就排除了右下方；检查了右上方，也就排除了左下方
        // 开始沿左上方是否有皇后互相冲突
        for(int i=row-1,j=col-1; i>=0 && j>=0; i--,j--) {
            // 判断左上所有棋子是否有Q
            if ("Q".equals(board[i][j])){
                return false;
            }
        }
        // 开始沿右上方是否有皇后互相冲突
        for(int i=row-1,j=col+1; i>=0 && j<boardColLength; i--,j++) {
            if ("Q".equals(board[i][j])){
                return false;
            }
        }
        // 通过所有检查，则返回true
        return true;
    }

    /**
     * 数组转String
     * */
    public static <T> String arrToString(T[] arr) {
        if(arr.length==0){
            return null;
        }
        // 遍历
        StringBuffer str5 = new StringBuffer();
        for (T s : arr) {
            str5.append(s);
        }
        return str5.toString();
    }

    /**
     * 拷贝二维数组
     * */
    public static <T> void copy2dArr(T[][] sourceArr, T[][] destArr) {
        for (int i = 0; i < sourceArr.length; i++) {
            for (int j = 0; j < sourceArr[i].length; j++) {
                destArr[i][j] = sourceArr[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Case2 test = new Case2();
        System.out.println("列出所有解：");
        List<List<String>> result = test.solveNQueens(4, true);
        System.out.println(result);
        /**
         * 后记：
         * 有的时候，我们并不想得到所有合法的答案，只想要一个答案，怎么办呢？比如解数独的算法，找所有解法复杂度太高，只要找到一种解法就可以。
         * 其实特别简单，只要稍微修改一下回溯算法的代码即可：
         * 参考方法 {@link #backtrackForOne(String[][], int)}
         * */
        System.out.println("只需一个解：");
        result = test.solveNQueens(4, false);
        System.out.println(result);

    }

}
