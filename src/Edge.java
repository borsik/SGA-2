/**
 * Created by olzhas on 05.11.2016.
 */
public class Edge {
    private int source;
    private int dest;
    private int weight;

    public int getSource() {
        return source;
    }

    public int getDest() {
        return dest;
    }

    public int getWeight() {
        return weight;
    }

    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}
