package Übung8;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * this class realize the DijsktraAlgorithmus with a PiorityQueue/ PQ. the PQ
 * sorte the Vertecie, with priority sorted by weight acsending
 *
 * @author Stephan Duenkel, Emil Steinkopf, Loen Roesler
 */
public class DijkstraAlgorithmusPQ {

    private GraphOwn graph;
    private VertexDist startpoint;
    private Double MAXDOUBLE = Double.POSITIVE_INFINITY;
    private HashMap<Integer, Double> prevDistanceMap = new HashMap<>();
    //filled with all vertecies from graph 
    Collection<VertexDist> vertexCollection;
    // shortestDistanceComparator for the PQ 
    private final Comparator<VertexDist> shortestDistanceComparator = new Comparator<VertexDist>() {
        @Override
        public int compare(VertexDist aktuell, VertexDist prev) {
            Double resultD = getShortestDistance(aktuell) - getShortestDistance(prev);
            int result = resultD.intValue();
            return (result == 0) ? aktuell.compareTo(prev) : result;
        }

        /**
         * @return the shortest distance from the source to the given
         * VertexDist, if there is no route to the destination returns infinity
         *
         */
        private Double getShortestDistance(VertexDist aktuell) {
            Double shortesDistance = aktuell.getDistance();
            int shortesIntDistance = shortesDistance.intValue();
            // two options Double.POSITIVE_INFINITY or a number
            return shortesDistance;
        }
    };
    //this PQ safe the vertexID of unvistedvertecies with priority sorted by weight decesnding
    private PriorityQueue<VertexDist> unvisitedPQ = new PriorityQueue<>(7, shortestDistanceComparator);
    //
    private PriorityQueue<VertexDist> visitedPQ = new PriorityQueue<VertexDist>(7, shortestDistanceComparator);
    private PriorityQueue weight = new PriorityQueue<VertexDist>(7, shortestDistanceComparator);

    /**
     * The Constructor for the Algorithem if edges get a negative value it
     * throws an NegativeEdgeException
     *
     * @param graph
     * @param weight
     * @param startpoint
     * @throws NegativeEdgeException
     */
    public DijkstraAlgorithmusPQ(GraphOwn graph, PriorityQueue weight, VertexDist startpoint) throws NegativeEdgeException {

        this.graph = graph;
        Collection<EdgeOwn> collectionOfEdges = graph.getEdges();

        weightMethode(collectionOfEdges, weight);
        negativeEdgeCheck(collectionOfEdges);
        this.weight = weight;
        this.startpoint = startpoint;
        vertexCollection = graph.getVertices();

        initializeSingleSource(graph, startpoint);
        fillPriorityQueue();

    }

    /**
     * this methode filles the weightPQ with all weight from the graph
     *
     * @param collectionOfEdges
     * @param weight1
     */
    private void weightMethode(Collection<EdgeOwn> collectionOfEdges, PriorityQueue weight1) {
        for (EdgeOwn edge : collectionOfEdges) {
            String msg = "this Edge has negative Weight!!";
            if (edge.getWeight() < 0) {

                try {
                    throw new NegativeEdgeException(msg);
                } catch (NegativeEdgeException ex) {
                    ex.getMessage();
                }
            }
            Integer edgeWeight = edge.getWeight();
            weight1.add(edgeWeight.doubleValue());
        }
    }

    public PriorityQueue<VertexDist> getVisitedPQ() {
        return visitedPQ;
    }

    /**
     * Methode to check if edges have negative value
     *
     * @param collectionOfEdges
     * @throws NegativeEdgeException
     */
    private void negativeEdgeCheck(Collection<EdgeOwn> collectionOfEdges) throws NegativeEdgeException {
        for (EdgeOwn edge : collectionOfEdges) {
            String msg = "this Edge has negative Weight!!";
            if (edge.getWeight() < 0) {
                throw new NegativeEdgeException();

            }
        }
    }

    /**
     * Assume: all Verticies are unvisited . this methode initialize all
     * verticies from the graph with infinity and the startinpoint with weight 0
     *
     * @param graph
     * @param startpoint
     */
    private void initializeSingleSource(GraphOwn graph, VertexDist startpoint) {
        vertexCollection.forEach((vertexfromGraph) -> {
            Integer vertexId = vertexfromGraph.getId();
            if (vertexId != startpoint.getId()) {
                vertexfromGraph.setDistance(MAXDOUBLE);
                vertexfromGraph.setPrevVertex(null);
            }
        });
        startpoint.setDistance(0.0);
    }

    /**
     * Assume PQ is Empty. method to fill the unvisited ProirityQueue with alle
     * Vertecies from the Graph Assume: that all Vertices are not visited
     */
    private void fillPriorityQueue() {
        // PQ unvisted
        //vertexCollection unvisited Vertecies
        System.out.println("vertexCollection" + vertexCollection);
        for (VertexDist vertexDist : vertexCollection) {
            unvisitedPQ.add(vertexDist);

        }
    }

    /**
     * The method relaxation of an edge(u,v) consists in the examination, if the
     * so far determined shortest path to v * can be improved by taking the
     * current shortest path from s to u and append the edge(u,v) assumes
     * VertexDist are numbered 0, 1, ... n and that the source VertexDist is 0
     *
     * @param vertexA
     * @param vertexB
     * @param egdeWeight
     */
    private void relax(VertexDist vertexA, VertexDist vertexB, Double egdeWeight) {

        Double prevVertexDistWeight = vertexA.getDistance();
        Double vertexWeight = egdeWeight + prevVertexDistWeight;

        if ((vertexB.getDistance() >= vertexA.getDistance() + egdeWeight)) {
            Double newDistance = prevVertexDistWeight + egdeWeight;
            VertexDist newPredecessor = vertexA;
            visitedPQ.remove(vertexB);
            vertexB.setDistance(newDistance);
            vertexB.setPrevVertex(newPredecessor);
            visitedPQ.add(vertexB);

        }
    }

    /**
     * A methode that initialize
     *
     * @param vertexU
     * @throws NegativeEdgeException
     */
    public void initWeightrelaxMethod(VertexDist vertexU) throws NegativeEdgeException {
        Collection<EdgeOwn> incidentEdges = graph.getIncidentEdgesOwn(vertexU);
        negativeEdgeCheck(incidentEdges);
        Integer egdeWeight;
        for (EdgeOwn edge : incidentEdges) {
            egdeWeight = edge.getWeight();
            VertexDist vertexB;
            VertexDist vertexA;
            if ((edge.getVertexB().getId() < edge.getVertexA().getId())) {
                vertexB = edge.getVertexA();
                vertexA = edge.getVertexB();
            } else {
                vertexB = edge.getVertexB();
                vertexA = edge.getVertexA();
            }
            relax(vertexA, vertexB, egdeWeight.doubleValue());
        }

    }

    /**
     * this methode execute the Algorithem
     *
     * @throws NegativeEdgeException
     */
    public void executeDijkstra() throws NegativeEdgeException {

        // fillPriorityQueue();
        while (unvisitedPQ.peek() != null) {
            // this is literally the extract-Methode for the PriorityQue it uses the
            // methode poll of the PQ and removes the vertex at the head of the PQ and
            // returns the id from thhe vertex
            VertexDist vertexU = unvisitedPQ.poll();
            initWeightrelaxMethod(vertexU);
        }
        System.out.println("Das ist die VISITED sortierte PQ" + visitedPQ);
    }

    /**
     * Assume target is visited an has predessecor.
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     *
     * @param target
     * @return
     */
    public LinkedList<VertexDist> getPath(VertexDist target) {
        LinkedList<VertexDist> path = new LinkedList<VertexDist>();
        VertexDist step = target;
        // check if a path exists
        if (step.getPrevVertex() == null) {
            return null;
        }
        path.add(step);
        while (step.getPrevVertex().getDistance() != startpoint.getDistance()) {
            step = step.getPrevVertex();
            path.add(step);
        }

        // Put it into the correct order
        Collections.reverse(path);
        System.out.println("Das ist der Zielvertex!!" + target);
        System.out.println("Das die DIstance!!" + target.getDistance());
        System.out.println("so ergibt sie Sich:");

        System.out.println(path);
        System.out.println(startpoint);
        String pathfromVertex;
        for (VertexDist vertexPath : path) {
            pathfromVertex = vertexPath.toString();

            System.out.println(pathfromVertex);
        }
        return path;
    }
}
