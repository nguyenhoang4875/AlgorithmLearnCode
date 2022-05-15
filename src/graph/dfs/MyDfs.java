package graph.dfs;

import java.util.Vector;

public class MyDfs {
    static Vector<Vector<Integer>> adjList;
    private static int n = 12;// number of node
    private static boolean[] visited = new boolean[n];// number of node

    public static void initGraph() {
        adjList = new Vector<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new Vector<>());
        }
    }

    public static void linkNode(int src, int dest) {
        adjList.get(src).add(dest);
    }

    public static void dfs(int node) {
        if (visited[node]) return;
        visited[node] = true;
        System.out.printf("%3d", node);
        for (int i = 0; i < adjList.get(node).size(); i++) {
            dfs(adjList.get(node).get(i));
        }
//        adjList.get(node).forEach(MyDfs::dfs);
//        Iterator<Integer> i = adjList.get(node).listIterator();
//        while (i.hasNext()) {
//            int n = i.next();
//            if (!visited[n])
//                dfs(n);
//        }

    }

    public static void main(String[] args) {
        initGraph();

        linkNode(0, 1);
        linkNode(1, 0);
        linkNode(0, 9);
        linkNode(9, 0);
        linkNode(1, 8);
        linkNode(8, 1);
        linkNode(9, 8);
        linkNode(8, 9);
        linkNode(8, 7);
        linkNode(7, 8);
        linkNode(7, 10);
        linkNode(10, 7);
        linkNode(10, 11);
        linkNode(11, 10);
        linkNode(7, 11);
        linkNode(11, 7);
        linkNode(7, 6);
        linkNode(6, 7);
        linkNode(7, 3);
        linkNode(3, 7);
        linkNode(6, 5);
        linkNode(5, 6);
        linkNode(3, 5);
        linkNode(5, 3);
        linkNode(3, 2);
        linkNode(2, 3);
        linkNode(3, 4);
        linkNode(4, 3);

        dfs(0);
    }
}
