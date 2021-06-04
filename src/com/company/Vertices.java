package com.company;

import java.util.ArrayList;
import java.util.List;

public class Vertices {

    private final List<Integer> edges;

    public Vertices() {
        edges = new ArrayList<>();
    }

    public void addNewEdgeToVertices( int edge ) {
        this.edges.add(edge);
    }

    public List<Integer> getEdges() {
        return edges;
    }
}
