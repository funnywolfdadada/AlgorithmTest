package map;

import queue.Queue;

public class MapSearch {
    public static void depthFirstSearch(int[][] array) {
        int len = array.length;
        boolean[] visited = new boolean[len];
        System.out.println("depthFirstSearch start");
        depthFirstSearch(array, visited, 0);
        System.out.println("\ndepthFirstSearch end");
    }

    private static void depthFirstSearch(int[][] array, boolean[] visited, int index) {
        System.out.print(index + " ");
        visited[index] = true;
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i] && array[index][i] != 0) {
                depthFirstSearch(array, visited, i);
            }
        }
    }

    public static void broadFirstSearch(int[][] array) {
        System.out.println("broadFirstSearch start");
        int len = array.length;
        boolean[] visited = new boolean[len];
        Queue<Integer> queue = new Queue<>();
        queue.add(0);
        visited[0] = true;
        while (queue.size() != 0) {
            int index = queue.remove();
            System.out.print(index + " ");
            for (int i = 0; i < visited.length; i++) {
                if(!visited[i] && array[index][i] != 0) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println("\nbroadFirstSearch end");
    }

}
