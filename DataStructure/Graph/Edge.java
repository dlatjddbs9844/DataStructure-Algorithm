package DataStructure.Graph;

public class Edge implements Comparable<Edge>{
    int v;
    int cost;
    public Edge(int v) {
        this.v = v;
    }
    public Edge(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    public int compareTo(Edge e) {
        return (this.cost - e.v);
    }
}
