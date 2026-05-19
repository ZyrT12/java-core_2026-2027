package Lab3;

import java.io.*;
import java.util.*;

public class Timus1056 {

    private static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);

        int n = scanner.nextInt();
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 2; i <= n; i++) {
            int parent = scanner.nextInt();
            graph[i].add(parent);
            graph[parent].add(i);
        }

        int firstEnd = bfs(1, null);
        int[] parent = new int[n + 1];
        int secondEnd = bfs(firstEnd, parent);

        List<Integer> path = new ArrayList<>();
        int current = secondEnd;

        while (current != 0) {
            path.add(current);
            if (current == firstEnd) {
                break;
            }
            current = parent[current];
        }

        List<Integer> centers = new ArrayList<>();
        int size = path.size();

        if (size % 2 == 1) {
            centers.add(path.get(size / 2));
        } else {
            centers.add(path.get(size / 2 - 1));
            centers.add(path.get(size / 2));
        }

        Collections.sort(centers);

        for (int center : centers) {
            System.out.print(center + " ");
        }
    }

    private static int bfs(int start, int[] parent) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];

        queue.add(start);
        visited[start] = true;

        if (parent != null) {
            parent[start] = 0;
        }

        int last = start;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            last = current;

            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;

                    if (parent != null) {
                        parent[next] = current;
                    }

                    queue.add(next);
                }
            }
        }

        return last;
    }

    private static class FastScanner {
        private final InputStream inputStream;
        private final byte[] buffer = new byte[1 << 16];
        private int pointer = 0;
        private int length = 0;

        FastScanner(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        private int read() throws IOException {
            if (pointer >= length) {
                length = inputStream.read(buffer);
                pointer = 0;

                if (length <= 0) {
                    return -1;
                }
            }

            return buffer[pointer++];
        }

        int nextInt() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ' && c != -1);

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            int result = 0;

            while (c > ' ') {
                result = result * 10 + c - '0';
                c = read();
            }

            return result * sign;
        }
    }
}