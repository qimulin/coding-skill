package lin.xc.coding.skill.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 邻接表示例
 * @author zhou.wu
 * @date 2023/9/22
 **/
public class TestInverseAdjacencyList {
    public static void main(String[] args) {
        // 创建一个有向图
        Graph graph = new Graph();

        // 添加顶点
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        // 添加有向边
        graph.addDirectedEdge(1, 2);
        graph.addDirectedEdge(1, 3);
        graph.addDirectedEdge(1, 4);
        graph.addDirectedEdge(2, 3);
        graph.addDirectedEdge(3, 1);
        graph.addDirectedEdge(3, 5);
        graph.addDirectedEdge(4, 3);

        // 打印逆邻接表
        graph.printInverseAdjacencyList();
    }
}

/** 表示图中的顶点 */
class Vertex {
    int id;
    List<Integer> inboundNeighbors;

    public Vertex(int id) {
        this.id = id;
        inboundNeighbors = new ArrayList<>();
    }
}

/**  图的逆邻接表表示 */
class Graph {
    List<Vertex> vertices;

    public Graph() {
        vertices = new ArrayList<>();
    }

    // 添加顶点
    public void addVertex(int id) {
        vertices.add(new Vertex(id));
    }

    // 添加有向边
    public void addDirectedEdge(int src, int dest) {
        // 找到目标顶点
        Vertex destVertex = null;
        for (Vertex vertex : vertices) {
            if (vertex.id == dest) {
                destVertex = vertex;
                break;
            }
        }

        // 添加边
        if (destVertex != null) {
            destVertex.inboundNeighbors.add(src);
        }
    }

    // 打印逆邻接表
    public void printInverseAdjacencyList() {
        for (Vertex vertex : vertices) {
            System.out.print("顶点 " + vertex.id + " 的入边: ");
            for (int inboundNeighbor : vertex.inboundNeighbors) {
                System.out.print(inboundNeighbor + " ");
            }
            System.out.println();
        }
    }
}
