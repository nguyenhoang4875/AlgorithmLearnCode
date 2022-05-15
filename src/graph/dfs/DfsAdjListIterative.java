package graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DfsAdjListIterative {
    public static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    private static int dfs(Map<Integer, List<Edge>> graph, int start, int n) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        boolean[] visited = new boolean[n];

        while (!stack.isEmpty()) {
            int node = stack.pop();
            count++;
            List<Edge> edges = graph.get(node);
            if (edges != null) {
                for (Edge edge : edges) {
                    if (!visited[edge.to]) {
                        visited[edge.to] = true;
                        stack.push(edge.to);
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        int numberNode = 5;
        addElement(graph, 0, 1, 4);
        addElement(graph, 0, 2, 5);
        addElement(graph, 1, 2, -2);
        addElement(graph, 1, 3, 6);
        addElement(graph, 2, 3, 1);
        addElement(graph, 2, 2, 10);

        int count = dfs(graph, 4, numberNode);
        System.out.println("count: " + count);


    }

    private static void addElement(Map<Integer, List<Edge>> graph, int from, int to, int cost) {
        List<Edge> edges = graph.get(from);
        if (edges == null) {
            edges = new ArrayList<>();
        }
        edges.add(new Edge(from, to, cost));
        graph.put(from, edges);

    }
}
