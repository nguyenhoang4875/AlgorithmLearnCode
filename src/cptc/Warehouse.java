package cptc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class WareHouse {
    int N;
    int M;
    List<List<Edge>> graph;
    int[] dist;

    Comparator<Node> comparator = new Comparator<Node>() {
        @Override
        public int compare(Node node, Node t1) {
            return node.value - t1.value;
        }
    };

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br =
//                new BufferedReader(new InputStreamReader(new FileInputStream("src/input_samples.txt")));
        String input = br.readLine();
        String[] row = input.split(" ");
        N = Integer.parseInt(row[0]);
        M = Integer.parseInt(row[1]);

        graph = createEmptyGraph(N);

        int from, to, cost;
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line);
            from = Integer.parseInt(tokenizer.nextToken()) - 1;
            to = Integer.parseInt(tokenizer.nextToken()) - 1;
            cost = Integer.parseInt(tokenizer.nextToken());
            addUndirectedEdge(graph, from, to, cost);
        }
    }

    public static void main(String[] args) throws IOException {
        WareHouse m = new WareHouse();
        m.input();
        int result = m.dijkstra(0);
        int temp ;
        for (int i = 1; i < m.N; i++) {
            temp = m.dijkstra(i);
            if (result > temp) {
                result = temp;
            }
        }
        System.out.println(result);
    }

    public int dijkstra(int start) {
        dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        boolean[] visited = new boolean[N];

        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(2 * N, comparator);
        priorityQueue.offer(new Node(start, 0));

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            visited[node.id] = true;
            List<Edge> edges = graph.get(node.id);

            if (dist[node.id] < node.value) continue;
            for (Edge edge : edges) {
                if (visited[edge.to]) continue;

                int newDist = dist[edge.from] + edge.cost;
                if (newDist < dist[edge.to]) {
                    dist[edge.to] = newDist;
                    priorityQueue.offer(new Node(edge.to, newDist));
                }
            }
        }

//        System.out.println(Arrays.toString(dist));
        return Arrays.stream(dist).max().getAsInt();
    }

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

    public static class Node {
        int id;
        int value;

        public Node(int id, int value) {
            this.id = id;
            this.value = value;
        }
    }

    public List<List<Edge>> createEmptyGraph(int n) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        return graph;
    }

    public void addUndirectedEdge(List<List<Edge>> graph, int from, int to, int cost) {
        graph.get(from).add(new Edge(from, to, cost));
        graph.get(to).add(new Edge(to, from, cost));
    }

}
