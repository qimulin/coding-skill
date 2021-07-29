package lin.xc.coding.skill.algorithm.sort.priority_queue;


import lin.xc.coding.skill.algorithm.sort.std.StdIn;
import lin.xc.coding.skill.algorithm.sort.std.StdOut;
import lin.xc.coding.skill.algorithm.sort.util.MinPQ;
import lin.xc.coding.skill.algorithm.sort.util.Transaction;

import java.util.Stack;

/**
 * 一个优先队列的用例
 */
public class TopM {

	public static void main(String[] args) {
		// 打印输入流中最大的M行（即队列能存放的最大元素个数）
		int M = Integer.parseInt(args[0]);
		MinPQ<Transaction> pq = new MinPQ(M+1);
		// 为下一行输入创建一个元素并放入优先队列中
		while(StdIn.hasNextLine()){
			pq.insert(new Transaction(StdIn.readLine()));
			if(pq.size() > M){
				// 当队列元素个数超出限定的元素个数，则删除其中最小的元素
				pq.delMin();
			}
		}
		// 则比较大的M个元素都在优先队列中
		Stack<Transaction> stack = new Stack();
		// 将队列元素push栈中
		while(!pq.isEmpty()) {
			stack.push(pq.delMin());
		}
		for (Transaction t : stack) {
			StdOut.println(t);
		}
	}
}
