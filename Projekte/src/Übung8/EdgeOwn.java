package Übung8;

/**
 * Eine Klasse die Kanten eines Graphen repr�sentiert
 *
 * @param <V> eine Unterklasse der Knotenklasse Vertex zur Repr�sentation der Endknoten der Kante
 * @author ripphausen
 * @version 1.0
 */
public class EdgeOwn<V extends VertexDist> extends Edge<V> {
    private V vertexA;
    private V vertexB;
    private int weight = 1;


    public EdgeOwn(V vertexA, V vertexB, int weight) {
        super(vertexA, vertexB, weight);
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.weight = weight;
    }

    public EdgeOwn(V a, V b) {
        super(a, b);
        vertexA = a;
        vertexB = b;
        weight = 1; // Standardgewicht
    }

    public V getVertexA() {
        return vertexA;
    }

    public V getVertexB() {
        return vertexB;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString() {
        return "(" + vertexA.getId() + "," + vertexB.getId() + "; g:" + this.weight + ")";
    }
}


