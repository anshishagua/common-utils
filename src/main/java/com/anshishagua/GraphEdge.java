package com.anshishagua;

public class GraphEdge {
    private GraphNode fromNode;
    private GraphNode toNode;

    public GraphEdge(GraphNode fromNode, GraphNode toNode) {
        this.fromNode = fromNode;
        this.toNode = toNode;
    }
}
