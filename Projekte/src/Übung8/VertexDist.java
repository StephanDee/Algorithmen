package Übung8;

/**
 * Eine Klasse, die Knoten eines Graphen repräsentiert
 *
 * @author ripphausen
 * @version 1.0
 */
public class VertexDist extends Vertex implements Comparable {

    private int id;
    private double distance;
    private VertexDist prevVertex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VertexDist getPrevVertex() {
        return prevVertex;
    }

    public void setPrevVertex(VertexDist prevVertex) {
        this.prevVertex = prevVertex;
    }

    public VertexDist(int id) {
        super(id);
        this.id = id;
        this.distance = Double.POSITIVE_INFINITY;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(Object other) {
        Double thisVertex = this.getDistance();
        VertexDist vertexTemp = (VertexDist) other;
        Double otherVertex = vertexTemp.getDistance();
        return thisVertex.compareTo(otherVertex);
    }

}