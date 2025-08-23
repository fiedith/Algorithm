import java.io.*;
import java.util.*;

public class Main {

    private static int cols;    // x
    private static int rows;    // y

    static class Node{
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int nodeCount = 0;
        int[][] graph;
        Set<Node> set;

        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++){
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            cols = Integer.parseInt(st.nextToken());
            rows = Integer.parseInt(st.nextToken());
            nodeCount = Integer.parseInt(st.nextToken());
            graph = new int[rows][cols];
            set = new HashSet<>();

            // init set
            for (int j = 0; j < nodeCount; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = 1;
                set.add(new Node(x, y));
            }

            while (!set.isEmpty()) {
                bfs(set);
                answer++;
            }
            System.out.println(answer);
        }
    }

    private static void bfs(Set<Node> set) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        Iterator<Node> iterator = set.iterator();
        Deque<Node> q = new ArrayDeque<>();
        Node start = iterator.next();
        set.remove(start);
        q.addLast(start);

        while (!q.isEmpty()) {
            Node now = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < -1 || nx >= cols || ny < -1 || ny >= rows) {
                    continue;
                }
                Node next = new Node(nx, ny);
                if (set.contains(next)) {
                    q.addLast(next);
                    set.remove(next);
                }
            }
        }
    }
}