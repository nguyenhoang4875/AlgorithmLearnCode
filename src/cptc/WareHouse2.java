package cptc;

import java.io.*;
import java.util.*;
public class WareHouse2 {
    List<List<Edge>> graph = new ArrayList<>();
    int n;
    int m;

    public static class Edge {
        int from;
        int to;
        int cost;

        public  Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public void addUndirectedEdge(List<List<Edge>> graph, int from, int to, int cost) {
        graph.get(from).add(new Edge(from, to, cost));
        graph.get(to).add(new Edge(to, from, cost));
    }

    public  List<List<Edge>> createEmptyGraph(int n) {
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i < n ; i++) {
            List<Edge> edges = new ArrayList<>();
            graph.add(edges);
        }
        return graph;
    }

    void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        graph = createEmptyGraph(n);
        int from, to, cost;
        for(int i = 0 ; i < m ; i++) {
            input = br.readLine();
            String[] strs = input.split(" ");
            from = Integer.parseInt(strs[0]) - 1;
            to = Integer.parseInt(strs[1]) - 1;
            cost = Integer.parseInt(strs[2]);
            addUndirectedEdge(graph, from, to, cost);
        }
    }

    public int dijkstra(int start) {
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        Queue<int[]> queue = new PriorityQueue<>(2*n, (x,y) -> x[1] - y[1]);
        queue.offer(new int[] {start, 0});

        while(!queue.isEmpty()) {
            int[]	node = queue.poll();
            List<Edge> edges = graph.get(node[0]);
            visited[node[0]] = true;

            if(dist[node[0]] < node[1]) continue;
            for (Edge edge: edges) {
                if(!visited[edge.to])	{
                    int newDist = dist[node[0]] + edge.cost;
                    if (newDist < dist[edge.to]) {
                        dist[edge.to] = newDist;
                        queue.offer(new int[] {edge.to, newDist});
                    }
                }
            }
        }

        return Arrays.stream(dist).max().getAsInt();

    }

    public static void main(String[] args) throws Exception {
        WareHouse2 m = new WareHouse2();
        m.input();
        int ans = Integer.MAX_VALUE;
        int temp;
        for (int i = 0; i < m.n ; i++) {
            temp = m.dijkstra(i);
            if(ans > temp) {
                ans = temp;
            }
        }
        System.out.println(ans);
    }
}