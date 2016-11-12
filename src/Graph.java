import java.util.LinkedList;
import java.util.Random;

/**
 * Created by olzhas on 05.11.2016.
 */
public class Graph {
    private int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public Graph(int[][] in) {
        int white = -1;
        int orange = -32985;
        int black = -16777216;

        int height = in.length;
        int width = 0;

        this.V = height * in[0].length;
        this.E = 0;

        for (int i = 0; i < height; i++) {
            width = in[i].length;
            for (int j = 0; j < width; j++) {
                int curr = in[i][j];
                if (curr == white) {
                    int n, s, e, w, nw, ne, sw, se;
                    if (i > 0) {
                        n = in[i - 1][j];
                        if (n == white) {
                            addEdge(curr, n);
                        }
                    }
                    if (i < height) {
                        s = in[i + 1][j];
                        if (s == white) {
                            addEdge(curr, s);
                        }
                    }
                    if (j > 0) {
                        e = in[i][j - 1];
                        if (e == white) {
                            addEdge(curr, e);
                        }
                    }

                    if (j < width) {
                        w = in[i][j + 1];
                        if (w == white) {
                            addEdge(curr, w);
                        }
                    }
                    if (i > 0 && j > 0) {
                        ne = in[i - 1][j - 1];
                        if (ne == white) {
                            addEdge(curr, ne);
                        }
                    }
                    if (i > 0 && j < width) {
                        nw = in[i - 1][j - 1];
                        if (nw == white) {
                            addEdge(curr, nw);
                        }
                    }
                    if (i < height && j > 0) {
                        se = in[i + 1][j - 1];
                        if (se == white) {
                            addEdge(curr, se);
                        }
                    }
                    if (i < height && j < width) {
                        sw = in[i + 1][j + 1];
                        if (sw == white) {
                            addEdge(curr, sw);
                        }
                    }
                }
            }
        }
    }

    public int V() {
        return V;
    }
    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    public int degree(int v) {
        return adj[v].size();
    }

    public LinkedList<Integer> getAdj(int v) {
        return adj[v];
    }

}
