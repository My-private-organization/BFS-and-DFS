package com.company;

import java.util.*;

public class Graph {

    private final int numberOfVertices;
    private List<Vertices> verticesList;

    public Graph( int numberOfVertices ) {
        this.numberOfVertices = numberOfVertices;
        constructVertices();
    }

    private void constructVertices() {

        verticesList = new ArrayList<>();

        for (int i = 0; i < numberOfVertices; i++) {
            verticesList.add(new Vertices());
        }

    }

    public void addEdgesBetweenVertices( int c1, int c2 ) {
        verticesList.get(c1).addNewEdgeToVertices(c2);
        verticesList.get(c2).addNewEdgeToVertices(c1);
    }

    public List<Integer> BFS_TraverSalOfGraph( int startVertices ) {
        boolean[] visited = new boolean[numberOfVertices];
        List<Integer> visitedCity = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertices] = true;
        queue.add(startVertices);

        while (queue.size() != 0) {
            startVertices = queue.poll();
            visitedCity.add(startVertices);

            for (int n : verticesList.get(startVertices).getEdges()) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        return visitedCity;
    }


    private void DFSUtil( int startVertices, boolean[] visited, List<Integer> visitedCity ) {
        visited[startVertices] = true;
        visitedCity.add(startVertices);

        for (int n : verticesList.get(startVertices).getEdges()) {
            if (!visited[n])
                DFSUtil(n, visited, visitedCity);
        }

    }

    public List<Integer> DFS_TraverSalOfGraph( int startVertices ) {
        boolean[] visited = new boolean[numberOfVertices];
        final List<Integer> visitedCity = new ArrayList<>();
        DFSUtil(startVertices, visited, visitedCity);

        return visitedCity;
    }

}
