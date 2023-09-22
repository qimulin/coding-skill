package lin.xc.coding.skill.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 逆邻接表示例
 * @author zhou.wu
 * @date 2023/9/22
 **/
public class TestAdjacencyList {

    public static void main(String[] args) {
        // 创建一个有向图
        AdjacencyList adjacencyList = new AdjacencyList();

        // 添加有向边
        adjacencyList.addEdge(1, 2);
        adjacencyList.addEdge(1, 3);
        adjacencyList.addEdge(1, 4);
        adjacencyList.addEdge(2, 3);
        adjacencyList.addEdge(3, 1);
        adjacencyList.addEdge(3, 5);
        adjacencyList.addEdge(4, 3);

        // 打印邻接表
        adjacencyList.printList();
    }
}

/**
 * 邻接表对象
 * @author zhou.wu
 * @date 2023/9/22
 **/
class AdjacencyList{

    private Map<Integer, List<Integer>> adjacencyList;

    // 构造函数，初始化邻接表
    public AdjacencyList() {
        adjacencyList = new HashMap<>();
    }

    // 添加有向边
    public void addEdge(int source, int destination) {
        // 获取源顶点的邻接列表
        List<Integer> neighbors = adjacencyList.getOrDefault(source, new ArrayList<>());
        // 将目标顶点添加到邻接列表中
        neighbors.add(destination);
        // 更新邻接表
        adjacencyList.put(source, neighbors);
    }

    // 打印邻接表
    public void printList() {
        for (Integer vertex : adjacencyList.keySet()) {
            List<Integer> neighbors = adjacencyList.get(vertex);
            System.out.print(vertex + " -> ");
            for (Integer neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}