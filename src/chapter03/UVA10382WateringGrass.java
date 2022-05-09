package chapter03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class UVA10382WateringGrass {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            double wHalf = W / 2.0;

            ArrayList<Node> list = new ArrayList<>();
            TreeSet<Node> nodes = new TreeSet<>();

            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                double pos = Double.parseDouble(st.nextToken());
                double r = Double.parseDouble(st.nextToken());
                if (r > wHalf) {
                    double dx = Math.sqrt(r * r - wHalf * wHalf);
                    list.add(new Node(Math.max(0, pos - dx), pos + dx));
                }
            }

            list.sort(Comparator.comparingDouble((Node node) -> node.l).thenComparingDouble(node -> node.r));
//            list.forEach(x -> System.out.println("l: " + x.l + " r: " + x.r));

            double start = 0, end = 0;
            int num = 1;

            if (list.size() > 0 && list.get(0).l > start) {
                System.out.println(-1);
                continue;
            }

            for (Node node : list) {
                if (node.l <= start) {
                    end = Math.max(end, node.r);
                } else {
                    num++;
                    start = end;
                    if (node.l <= start) {
                        end = Math.max(end, node.r);
                    } else {
                        break;
                    }
                }
                if (end >= L) break;
            }
            if (end < L) System.out.println(-1);
            else System.out.println(num);

        }
    }

    public static class Node {
        private final double l;
        private final double r;

        public Node(double l, double r) {
            this.l = l;
            this.r = r;
        }
    }

}
/*
            double end=0;
            int index=0, sol=0;
            while (index<list.size() && end<L) {
                boolean found=false;
                double tempEnd=end;
                for (;index<list.size();index++) {
                    if (list.get(index).l <= tempEnd) {
                        end=Math.max(list.get(index).r, end);
                        found=true;
                    } else break;
                }
                if (found) sol++;
                else {
                    end=-1;
                    break;
                }
            }

            if (end < L) System.out.println(-1);
            else System.out.println(sol);
*/
