package lin.xc.coding.skill.datastructure.graph;

/**
 * 邻接矩阵示例
 * @author zhou.wu
 * @date 2023/9/22
 **/
public class TestAdjacencyMatrix {

    public static void main(String[] args) {
        int numVertices = 5;
        AdjacencyMatrix graph = new AdjacencyMatrix(numVertices);

        // 添加有向边
        graph.addEdge(0, 4, 6);
        graph.addEdge(1, 0, 9);
        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 0, 2);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 1);

        // 打印邻接矩阵
        graph.printMatrix();
    }
}

/** 邻接矩阵 */
class AdjacencyMatrix {

    private Integer[][] matrix;

    private int numVertices;

    /** 构造函数，初始化邻接矩阵 */
    public AdjacencyMatrix(int numVertices) {
        this.numVertices = numVertices;
        matrix = new Integer[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++){
            // 自己和自己绝对没有边，设置成0，【自注】：我觉得看业务吧，可以不额外设置
            matrix[i][i] = 0;
        }
    }

    /** 添加有向边 */
    public void addEdge(int source, int destination, int length) {
        // 在邻接矩阵中设置对应位置为 1，表示存在一条边从 source 到 destination
        matrix[source][destination] = length;
    }

    /** 打印邻接矩阵 */
    public void printMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
