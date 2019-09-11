/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EigthPuzzle;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long timeStart;
        long timeStop;
        
        int [][] puzzle = new int[3][3];
        int [][] goal = new int[3][3];
        
        System.out.println("INPUT INITIAL STATE : ");
        for(int i=0; i<puzzle.length; i++){
            for(int j=0; j<puzzle[0].length; j++){
                puzzle[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("INPUT GOAL TEST");
        for(int i=0; i<goal.length; i++){
            for(int j=0; j<goal[0].length; j++){
                goal[i][j] = sc.nextInt();
            }
        }
        
        Puzzle puzzleObj = new Puzzle(puzzle,goal);
        BFS_Solver solver = new BFS_Solver();
        Puzzle.Direction[] strategy = {Puzzle.Direction.RIGHT, Puzzle.Direction.DOWN, Puzzle.Direction.UP, Puzzle.Direction.LEFT};
        
        System.out.println("------- INITIAL STATE -------");
        System.out.println(puzzleObj);
        
        timeStart = System.nanoTime();
        
        Puzzle solvedPuzzle = solver.solve(puzzleObj, strategy);
        
        timeStop = System.nanoTime();
        
        System.out.println("------- GOAL -------");
        System.out.println(solvedPuzzle);

        System.out.println("Path: " + solvedPuzzle.getPath());
        System.out.println("Path length: " + solvedPuzzle.getPath().length());
        System.out.println("Solved in: " + ((timeStop - timeStart) / 1000) / 1000.0 + "ms");
    }
    
    private static int[][] generateCorrectPuzzle(int xSize, int ySize) {
        int[][] correctPuzzle = new int[ySize][xSize];
        int counter = 1;

        for (int y = 0; y < ySize; ++y) {
            for (int x = 0; x < xSize; ++x) {
                correctPuzzle[y][x] = counter;

                ++counter;
            }
        }

        correctPuzzle[ySize - 1][xSize - 1] = 0;

        return correctPuzzle;
    }
}
