package com.company;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[4];

        for (int i = 0; i < 4; i++)
            arr[i] = scanner.nextInt();

        Graph graph = new Graph(arr[0]);

        for (int i = 0; i < arr[1]; i++) {
            int C1, C2;
            C1 = scanner.nextInt();
            C2 = scanner.nextInt();
            graph.addEdgesBetweenVertices(C1, C2);
        }

        int[][] cityPieces = new int[arr[2]][2];
        int[][] cityFriends = new int[arr[3]][2];

        for (int i = 0; i < arr[2]; i++) {
            int c, p;

            c = scanner.nextInt();
            p = scanner.nextInt();

            cityPieces[i][0] = c;
            cityPieces[i][1] = p;
        }

        for (int i = 0; i < arr[3]; i++) {
            int c, f;

            c = scanner.nextInt();
            f = scanner.nextInt();

            cityFriends[i][0] = c;
            cityFriends[i][1] = f;
        }

        //Solution Using BFS
        for (int i = 0; i < arr[3]; i++) {

            List<Integer> visitedCities = graph.BFS_TraverSalOfGraph(cityFriends[i][0]);

            for (int visited : visitedCities) {

                for (int j = 0; j < arr[2]; j++) {

                    if (cityPieces[j][0] == visited) {

                        if(cityFriends[i][1] == 0)
                            cityPieces[j][0] = Integer.MIN_VALUE;
                        else
                            cityPieces[j][0] = -cityFriends[i][1];

                        break;
                    }
                }

            }
        }

        int totalPieces = 0;
        int collectedPieces = 0;

        for (int i = 0; i < arr[2]; i++) {

            totalPieces += cityPieces[i][1];

            if(cityPieces[i][0] < 0)
                collectedPieces += cityPieces[i][1];
        }

        if(totalPieces == collectedPieces)
            System.out.println("Mission Accomplished");
        else
            System.out.println("Mission Impossible");

        System.out.printf("%d out of %d pieces are collected", collectedPieces, totalPieces);

    }
}
