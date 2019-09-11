/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EigthPuzzle;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author user
 */
public class BFS_Solver {
    private final Queue<Puzzle> frontier = new LinkedList<>();
    
    public Puzzle solve(Puzzle puzzleToSolve, Puzzle.Direction[] strategy){
        frontier.add(puzzleToSolve);
        
        while(!frontier.isEmpty()){
            Puzzle puzzle = frontier.poll();
            
            if(puzzle.isSolved()){
                return puzzle;
            }
            
            for(int i=0; i<strategy.length; i++){
                if(puzzle.canMove(strategy[i])){
                    Puzzle newPuzzle = new Puzzle(puzzle);
                    newPuzzle.move(strategy[i]);
                    
                    frontier.add(newPuzzle);
                }
            }
        }
        
        return null;
    }
}
