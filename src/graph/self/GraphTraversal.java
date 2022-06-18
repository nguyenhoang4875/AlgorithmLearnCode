package graph.self;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import chapter02.Stack;

public class GraphTraversal {
    int count = 0;

    private static int DEPT_TOKEN = -1;

    static class Edge {
        int from, to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    List<List<Edge>> createGraph(int n) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Edge> node = new ArrayList<>();
            graph.add(node);
        }
        return graph;
    }

    void addUnWeightEdge(List<List<Edge>> graph, int from, int to) {
        graph.get(from).add(new Edge(from, to));

    }

    public static void main(String[] args) {
        int n = 9;
        GraphTraversal m = new GraphTraversal();
        List<List<Edge>> graph = m.createGraph(n);
        m.addUnWeightEdge(graph, 0, 1);
        m.addUnWeightEdge(graph, 0, 2);
        m.addUnWeightEdge(graph, 1, 3);
        m.addUnWeightEdge(graph, 1, 4);
        m.addUnWeightEdge(graph, 2, 5);
        m.addUnWeightEdge(graph, 2, 6);
        m.addUnWeightEdge(graph, 3, 7);
        m.addUnWeightEdge(graph, 6, 8);

//        m.dfs(graph, n, 0);
        boolean visited[] = new boolean[n];
//        m.dfsRecursion(0, graph, visited);

        System.out.println("BFS");
        m.bfs(graph, n, 0);

        System.out.println("BFS with recursion");
        System.out.println("BFS with recursion count dept");
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
//        queue.offer(DEPT_TOKEN);
//        int dept = m.countDeptBfs(graph,queue,visited);
//        System.out.println("Dept: " + dept);
        m.bfsRecursion(graph, queue, visited);
    }


    void dfs(List<List<Edge>> graph, int n, int start) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            System.out.println("Node: " + node);
            List<Edge> edges = graph.get(node);
            for (Edge edge : edges) {
                if (!visited[edge.to]) {
                    stack.push(edge.to);
                    visited[edge.to] = true;
                }
            }
        }
    }

    void dfsRecursion(int at, List<List<Edge>> graph, boolean[] visited) {
        visited[at] = true;
        System.out.println("Node: " + at);
        List<Edge> edges = graph.get(at);
        for (Edge edge : edges) {
            dfsRecursion(edge.to, graph, visited);
        }
    }


    void bfs(List<List<Edge>> graph, int n, int start) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            System.out.println("Node: " + node);
            List<Edge> edges = graph.get(node);
            for (Edge edge : edges) {
                if (!visited[edge.to]) {
                    queue.offer(edge.to);
                    visited[edge.to] = true;
                }
            }

        }
    }

    void bfsRecursion(List<List<Edge>> graph, Queue<Integer> queue, boolean[] visited) {
        if (queue.isEmpty()) return;

        int node = queue.poll();
        System.out.println("Node: " + node);
        for (Edge edge : graph.get(node)) {
            if (!visited[edge.to]) {
                queue.offer(edge.to);
                visited[edge.to] = true;
            }
        }

        bfsRecursion(graph, queue, visited);
    }

    int countDeptBfs(List<List<Edge>> graph, Queue<Integer> queue, boolean[] visited) {
        int node = queue.poll();
        if (node == DEPT_TOKEN) {
            queue.offer(DEPT_TOKEN);
            return 1;
        }
        if (visited[node]) return 0;
        visited[node] = true;
        System.out.println("Node count: " + node);
        for (Edge edge : graph.get(node)) {
            if (!visited[edge.to]) {
                queue.offer(edge.to);
            }
        }

        int dept = 0;
        while (true) {
            if (queue.size() == 1 && queue.peek() == DEPT_TOKEN) {
                break;
            }
            dept += countDeptBfs(graph, queue, visited);
        }

        return dept;
    }
}
