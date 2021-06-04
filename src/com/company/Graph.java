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

        for(int i=0; i< numberOfVertices; i++)
        {
            verticesList.add(new Vertices());
        }

    }

    public void addEdgesBetweenVertices(int c1, int c2)
    {
        verticesList.get(c1).addNewEdgeToVertices(c2);
        verticesList.get(c2).addNewEdgeToVertices(c1);
    }

    public void BFS_TraverSalOfGraph(int startVertices)
    {

        boolean[] visited = new boolean[numberOfVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertices]=true;
        queue.add(startVertices);

        while (queue.size() != 0)
        {
            startVertices = queue.poll();
            System.out.print(startVertices + " ");

            for (int n : verticesList.get(startVertices).getEdges()) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }


    void DFSUtil( int startVertices, boolean[] visited )
    {
        visited[startVertices] = true;
        System.out.print(startVertices + " ");

        for (int n : verticesList.get(startVertices).getEdges()) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    public void DFS_TraverSalOfGraph(int startVertices)
    {
        boolean[] visited = new boolean[numberOfVertices];
        DFSUtil(startVertices, visited);
    }

}