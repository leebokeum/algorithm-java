package graph;

/**
 *     2 ---- 4 --- 6
 *   / |    / |
 * 1   |   /  |
 *   \ | /    |
 *     3 ---- 5
 */
public class TestGraph {
    public static void main(String[] args) {
        int initSize = 6;
        GraphNode adjList = new GraphNode(initSize);

        adjList.put(1, 2);
        adjList.put(1, 3);
        adjList.put(2, 3);
        adjList.put(2, 4);
        adjList.put(3, 4);
        adjList.put(3, 5);
        adjList.put(4, 5);
        adjList.put(4, 6);

        adjList.printGraphToAdjList();
    }
}
