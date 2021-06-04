package com.company;

import java.util.Scanner;

public class Main {

    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[4];

        for(int i=0; i<4; i++)
            arr[i] = scanner.nextInt();

        Graph graph = new Graph(arr[0]);

        for(int i=0; i<arr[1]; i++)
        {
            int C1, C2;

            C1 = scanner.nextInt();
            C2 = scanner.nextInt();

            graph.addEdgesBetweenVertices(C1, C2);
        }

//        graph.BFS_TraverSalOfGraph(4);
        graph.DFS_TraverSalOfGraph(4);
    }
}
